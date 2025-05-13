plugins {
    kotlin("jvm") version "2.1.20"
    kotlin("plugin.power-assert") version "2.1.20"
}

repositories {
    mavenCentral()
}

var junitVersion = "5.12.1"
var spek2Version = "2.0.19"
var assertJVersion = "3.27.3"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    // junit5 dependencies
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // spek2 dependencies
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spek2Version")  {
        exclude(group = "org.jetbrains.kotlin")
    }
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spek2Version") {
        exclude(group = "org.junit.platform")
        exclude(group = "org.jetbrains.kotlin")
    }

    // other nice junit and testing dependencies
    testImplementation("org.assertj:assertj-core:$assertJVersion")

}

tasks.named<Test>("test") {
    useJUnitPlatform {
        includeEngines("spek2", "junit-jupiter")
    }
    reports.html.required.set(true)
}
