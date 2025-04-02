# KToast

![Maven Central](https://img.shields.io/maven-central/v/io.github.tarifchakder.materializekmp/material-theme)
[![License](https://img.shields.io/github/license/tarifchakder/MaterializeKMP)](https://opensource.org/license/mit/)

[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.10-blue.svg?logo=kotlin)](https://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-1.6.1-blue)](https://github.com/JetBrains/compose-multiplatform)

![badge-android](https://img.shields.io/badge/Platform-Android-6EDB8D.svg?style=flat)
![badge-ios](https://img.shields.io/badge/Platform-iOS-CDCDCD.svg?style=flat)
![badge-desktop](https://img.shields.io/badge/Platform-Desktop-DB413D.svg?style=flat)
![badge-js](https://img.shields.io/badge/Platform-JS%2FWASM-FDD835.svg?style=flat)

**KToast** brings toast messages to the next level! Built with *Compose Multiplatform*, this library delivers seamless and versatile toast notifications across **Android**, **iOS**, **Web**, and **Desktop** platforms.

---

## Supported Platforms

KToast is designed for *Compose Multiplatform* and supports:

- **Android**
- **iOS**
- **JVM (Desktop)**
- **JavaScript/WASM (Browser)**

---

## Demo

Check out KToast in action:

| Mobile                          | Desktop                          | Web                          |
|:-------------------------------:|:--------------------------------:|:----------------------------:|
| ![Mobile](screenshot/mobile.gif) | ![Desktop](screenshot/desktop.gif) | ![Web](screenshot/web.gif) |

---

## Installation

Add KToast to your project using Gradle.

### Multiplatform Setup

In a multiplatform project, add the dependency to your `commonMain` source set:

```kotlin
commonMain {
  dependencies {
    implementation("io.github.tarifchakder.materializekmp:material-theme:0.0.1")
  }
}
```

```toml
[versions]
materialtheme = "1.0.0"

[libraries]
materialKolor = { module = "io.github.tarifchakder.materializekmp", version.ref = "materialtheme" }
```

## License
See [LICENSE](LICENSE) for more information.



