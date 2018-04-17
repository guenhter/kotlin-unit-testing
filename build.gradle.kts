import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.31"
}

repositories {
    jcenter()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))

    testCompile("org.jetbrains.spek:spek-api:1.1.5")
    testCompile("org.jetbrains.spek:spek-subject-extension:1.1.5")
    testCompile("org.jetbrains.spek:spek-data-driven-extension:1.1.5")

    testCompile("org.assertj:assertj-core:3.9.1")
    testCompile("org.amshove.kluent:kluent:1.36")

    testCompile("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testCompile("org.junit.jupiter:junit-jupiter-params:5.1.0")
    testCompile("com.github.blindpirate:junit5-unroll-extension:0.1.1")

    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    testRuntime("org.junit.platform:junit-platform-launcher:1.1.0")
    testRuntime("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
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
