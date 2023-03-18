plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("io.realm.kotlin")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.home"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ProjectConfig.extensionVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.activity.compose)
    implementation(libs.material3.compose)
    implementation(libs.navigation.compose)
    implementation(libs.coroutines.core)
    implementation(libs.realm.sync)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.compose.tooling.preview)
    implementation(libs.date.time.picker)
    implementation(libs.date.dialog)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.storage)

    implementation(project(":core:util"))
    implementation(project(":core:ui"))
    implementation(project(":data:mongo"))
}