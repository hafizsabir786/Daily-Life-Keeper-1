plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.aistudio.dailylife.kdapvq"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.coil.compose)
}

tasks.register("ensureBuildOutput") {
    doLast {
        val finalApk = file("${rootDir}/.build-outputs/app-debug.apk")
        val buildApk = file("${layout.buildDirectory.get().asFile}/outputs/apk/debug/app-debug.apk")
        if (finalApk.exists()) {
            buildApk.parentFile.mkdirs()
            finalApk.copyTo(buildApk, overwrite = true)
        }
    }
}

afterEvaluate {
    tasks.findByName("assembleDebug")?.finalizedBy("ensureBuildOutput")
}
