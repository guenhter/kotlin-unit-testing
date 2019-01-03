import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.11"
}

repositories {
    jcenter()
}

var junitVersion = "5.3.2"
var junitPlatformLauncherVersion = "1.3.2"
var spek1Version = "1.1.5"
var spek2Version = "2.0.0-rc.1"
var assertJVersion = "3.11.1"
var kluentVersion = "1.45"
var junit5UnrollVersion = "0.1.2"

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))


    // junit5 dependencies
    testCompile("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testCompile("org.junit.jupiter:junit-jupiter-params:$junitVersion")

    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testRuntime("org.junit.platform:junit-platform-launcher:$junitPlatformLauncherVersion")


    // spek2 dependencies
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spek2Version")  {
        exclude(group = "org.jetbrains.kotlin")
    }
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spek2Version") {
        exclude(group = "org.junit.platform")
        exclude(group = "org.jetbrains.kotlin")
    }


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
            includeEngines("spek2", "junit-jupiter")
        }
        reports.html.isEnabled = true
    }
}
