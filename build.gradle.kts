import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.3"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // For Reactive MongoDB ORM.
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")

    // For Reactive API.
    implementation("org.springframework.boot:spring-boot-starter-webflux")


    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // For write test code.
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // For write test codes for reactive code.
    testImplementation("io.projectreactor:reactor-test")

    // For write test codes for related with MongoDB.
    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo.spring30x:4.9.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
