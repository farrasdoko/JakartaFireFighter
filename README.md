# Jakarta Fire Fighter

Jakarta fire fighter is an app that show us information about **Firefighter** status on Jakarta city using [API Jakarta Smart City](http://api.jakarta.go.id/)

---
## Screenshot

![1](https://bitbucket.org/farrasdoko/jakartafirefighter/raw/0178ede718741050fa729134eba2bf9f1e037380/SCREENSHOT/1.png) ![2](https://bitbucket.org/farrasdoko/jakartafirefighter/raw/0178ede718741050fa729134eba2bf9f1e037380/SCREENSHOT/2.png)
![3](https://bitbucket.org/farrasdoko/jakartafirefighter/raw/0178ede718741050fa729134eba2bf9f1e037380/SCREENSHOT/3.png) ![4](https://bitbucket.org/farrasdoko/jakartafirefighter/raw/0178ede718741050fa729134eba2bf9f1e037380/SCREENSHOT/4.png)

---

## Gradle

apply plugin: 'com.android.application'

android {

    compileSdkVersion 28
    defaultConfig {
        applicationId "com.gmail.farrasabiyyu12.jakartafirefighter"
        minSdkVersion 15
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
	
}

dependencies {

    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:28.0.0-rc02'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    //TODO Gradle Tambahan
    implementation 'com.android.support:cardview-v7:28.0.0-rc02'
    implementation 'com.android.support:recyclerview-v7:28.0.0-rc02'
    //TODO Gradle Retrofit
    implementation 'com.google.code.gson:gson:2.8.0'
    implementation 'com.squareup.retrofit2:retrofit:2.0.2'
    implementation 'com.squareup.retrofit2:converter-gson:2.0.2'
    //TODO Butterknife
    implementation 'com.jakewharton:butterknife:8.8.1'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'

}

---

## Contact

* Instagram : [farrasdoko](https://instagram.com/farrasdoko)
* facebook : [farrasdoko](https://facebook.com/farras.abiyyu.31)
* Email : farras.abiyyu.doko@gmail.com
