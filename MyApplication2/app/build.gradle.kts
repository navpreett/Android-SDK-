plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        resValue("bool", "IS_HIDDEN_AMITY_LOG", "true")
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("bool", "IS_HIDDEN_AMITY_LOG", "true")
        }
        debug {
            resValue("bool", "IS_HIDDEN_AMITY_LOG", "false")
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
        viewBinding = true
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("androidx.paging:paging-runtime:3.3.0")
    implementation("com.github.AmityCo.Amity-Social-Cloud-SDK-Android:amity-sdk:6.35.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.8")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.security:security-crypto:1.0.0")
    implementation("androidx.compose.ui:ui:1.6.8")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.8")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")
    implementation("io.reactivex.rxjava3:rxjava:3.1.2") // RxJava 3


    implementation(libs.androidx.material3.android)
    implementation(libs.play.services.auth)
    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
