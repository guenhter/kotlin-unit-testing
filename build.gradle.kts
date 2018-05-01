import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.41"
}

repositories {
    jcenter()
}

var junitVersion = "5.2.0"
var junitPlatformLauncherVersion = "1.2.0"
var spekVersion = "1.1.5"
var assertJVersion = "3.9.1"
var kluentVersion = "1.37"
var junit5UnrollVersion = "0.1.2"

dependencies {
    compile(kotlin("stdlib-jdk8"))


    // junit5 dependencies
    testCompile("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testCompile("org.junit.jupiter:junit-jupiter-params:$junitVersion")

    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testRuntime("org.junit.platform:junit-platform-launcher:$junitPlatformLauncherVersion")


    // spek dependencies
    testCompile("org.jetbrains.spek:spek-api:$spekVersion")
    testCompile("org.jetbrains.spek:spek-subject-extension:$spekVersion")
    testCompile("org.jetbrains.spek:spek-data-driven-extension:$spekVersion")

    testRuntime("org.jetbrains.spek:spek-junit-platform-engine:$spekVersion")


    // other nice junit and testing dependencies
    testCompile("com.github.blindpirate:junit5-unroll-extension:$junit5UnrollVersion")
    testCompile("org.assertj:assertj-core:$assertJVersion")
    testCompile("org.amshove.kluent:kluent:$kluentVersion")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks {
    "test"(Test::class) {
        useJUnitPlatform {
            includeEngines("spek", "junit-jupiter")
        }
        reports.html.isEnabled = true
    }
}
