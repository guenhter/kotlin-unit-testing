import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
}

repositories {
    mavenCentral()
}

var junitVersion = "5.9.1"
var spek2Version = "2.0.19"
var assertJVersion = "3.23.1"
var kluentVersion = "1.72"
var junit5UnrollVersion = "0.1.2"

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

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.test {
    useJUnitPlatform {
        includeEngines("spek2", "junit-jupiter")
    }
    reports.html.required.set(true)
}
