import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType.jvm

plugins {
    kotlin("multiplatform")   version "1.7.0"
    id("org.jetbrains.compose")  version "1.2.0-alpha01-dev729"
}

group = "org.kilehynn"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}


kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        val jvmMain by getting{
            dependencies {
                implementation(compose.desktop.currentOs)

                implementation("com.arkivanov.decompose:decompose:0.8.0")
                implementation("com.arkivanov.decompose:extensions-compose-jetbrains:0.8.0")
            }

        }
        val jvmTest by getting
    }
}



tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}


compose.desktop {
    application {
        mainClass = "org.kilehynn.helper.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "mod5050helper"
        }
    }
}