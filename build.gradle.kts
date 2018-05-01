import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.31"
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

    testCompile("org.jetbrains.spek:spek-api:$spekVersion")
    testCompile("org.jetbrains.spek:spek-subject-extension:$spekVersion")
    testCompile("org.jetbrains.spek:spek-data-driven-extension:$spekVersion")

    testCompile("org.assertj:assertj-core:$assertJVersion")
    testCompile("org.amshove.kluent:kluent:$kluentVersion")

    testCompile("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testCompile("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testCompile("com.github.blindpirate:junit5-unroll-extension:$junit5UnrollVersion")

    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testRuntime("org.junit.platform:junit-platform-launcher:$junitPlatformLauncherVersion")
    testRuntime("org.jetbrains.spek:spek-junit-platform-engine:$spekVersion")
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
