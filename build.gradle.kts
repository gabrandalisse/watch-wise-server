import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
	kotlin("plugin.serialization") version "1.5.31"
}

group = "com.movie"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("io.ktor:ktor-client-core:1.6.7")
	implementation("io.ktor:ktor-client-cio:1.6.7")
	implementation("io.ktor:ktor-client-json:1.6.7")
	implementation("io.ktor:ktor-client-serialization:1.6.7")
	implementation("org.reactivestreams:reactive-streams:1.0.3")
	implementation("io.projectreactor:reactor-core:3.4.10")
	implementation ("com.google.code.gson:gson:2.10.1")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.5.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
