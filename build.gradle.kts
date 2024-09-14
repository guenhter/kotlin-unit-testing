import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.0.20"
}

repositories {
    mavenCentral()
}

var junitVersion = "5.11.0"
var spek2Version = "2.0.19"
var assertJVersion = "3.26.3"
var kluentVersion = "1.73"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    // junit5 dependencies
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")

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
    testImplementation("org.amshove.kluent:kluent:$kluentVersion")

}

tasks.test {
    useJUnitPlatform {
        includeEngines("spek2", "junit-jupiter")
    }
    reports.html.required.set(true)
}
