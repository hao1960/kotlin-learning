plugins {
    kotlin("jvm") version "2.1.21"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
}

kotlin {
    jvmToolchain(17)
}

// 用法：gradle run -Pday=02
val day = (findProperty("day") as String?) ?: "02"

sourceSets {
    main {
        kotlin {
            setSrcDirs(listOf("day$day"))
        }
    }
}

application {
    mainClass.set("Day${day}Kt")
}
