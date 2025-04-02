# KToast

![Maven Central](https://img.shields.io/maven-central/v/io.github.tarifchakder.materializekmp/material-theme)
[![License](https://img.shields.io/github/license/tarifchakder/MaterializeKMP)](https://opensource.org/license/mit/)

[![Kotlin](https://img.shields.io/badge/kotlin-v2.1.10-blue.svg?logo=kotlin)](http://kotlinlang.org)

[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-1.6.1-blue)](https://github.com/JetBrains/compose-multiplatform)
![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat)
![badge-desktop](http://img.shields.io/badge/platform-desktop-DB413D.svg?style=flat)
![badge-js](http://img.shields.io/badge/platform-js%2Fwasm-FDD835.svg?style=flat)

Toast messages are now ubiquitous! This library, built with Compose Multiplatform, extends its versatility to Android, iOS, Web, and Desktop platforms, delivering seamless toast notifications across all these environments
## Support Platforms

This library is written for Compose Multiplatform, and can be used on the following platforms:

- Android
- iOS
- JVM (Desktop)
- JavaScript/wasm (Browser)

## DEMO

![Mobile](screenshot/mobile.gif)![Desktop](screenshot/desktop.gif)![Web](screenshot/web.gif)


## Configuration

You can add this library to your project using Gradle.

### Multiplatform

To add to a multiplatform project, add the dependency to the common source-set:

```kotlin
  commonMain {
    dependencies {
        implementation("io.github.tarifchakder.materializekmp:material-theme:0.0.1")
    }
  }
```

### Version Catalog

```toml
[versions]
materialtheme = "1.0.0"

[libraries]
materialKolor = { module = "io.github.tarifchakder.materializekmp", version.ref = "materialtheme" }
```

## License
See [LICENSE](LICENSE) for more information.



