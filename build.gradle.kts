plugins {
    kotlin("jvm") version "2.3.20"
    kotlin("plugin.power-assert") version "2.3.20"
}

repositories {
    mavenCentral()
}

val junitVersion = "6.0.3"
val kotestVersion = "6.1.10"
val assertJVersion = "3.27.7"

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    // junit dependencies
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:$junitVersion")

    // kotest dependencies (Kotlin-native testing framework, successor to Spek)
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")

    // other nice testing dependencies
    testImplementation("org.assertj:assertj-core:$assertJVersion")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    reports.html.required.set(true)
}
