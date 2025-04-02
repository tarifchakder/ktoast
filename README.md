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

### Single Platform

```kotlin
commonMain {
  dependencies {
    implementation("io.github.tarifchakder.ktoast:ktoast:1.0.0")
  }
}
```
### Version Catalog

```toml
[versions]
toast = "1.0.0"

[libraries]
k-toast = { module = "io.github.tarifchakder.ktoast:ktoast", version.ref = "toast" }
```

## Usage

```Kotlin
// Create toast state
val toast = ToastState()
```
```kotlin
MaterialTheme {
  Box {
    ToastHost(
      modifier = Modifier.fillMaxSize().padding(20.dp),
      alignment = Alignment.BottomCenter,
      hostState = toast,
      transitionSpec = { ToastDefaults.SLIDE }
    )
  }
}
```

```Kotlin
// Now call it anywhere
toast1.showToast("Hi this is a common toast")
```

## License
See [LICENSE](LICENSE) for more information.



