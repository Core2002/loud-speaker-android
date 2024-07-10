<!-- <p align="center">
  <img src="https://cdn-icons-png.flaticon.com/512/6295/6295417.png" width="100" />
</p> -->
<p align="center">
    <h1 align="center">LOUD-SPEAKER-ANDROID</h1>
</p>
<p align="center">
  <em>This project is dedicated to developing a solution that enables the direct transmission of sound signals captured by a microphone to a speaker, facilitating immediate audio playback. This solution is particularly suited for scenarios requiring real-time audio feedback, such as public speaking, live performances, and educational demonstrations.</em>
</p>
<p align="center">
 <img src="https://img.shields.io/github/license/RUV2005/loud-speaker-android?style=flat&color=0080ff" alt="license">
 <img src="https://img.shields.io/github/last-commit/RUV2005/loud-speaker-android?style=flat&logo=git&logoColor=white&color=0080ff" alt="last-commit">
 <img src="https://img.shields.io/github/languages/top/RUV2005/loud-speaker-android?style=flat&color=0080ff" alt="repo-top-language">
 <img src="https://img.shields.io/github/languages/count/RUV2005/loud-speaker-android?style=flat&color=0080ff" alt="repo-language-count">
 <img src="https://img.shields.io/badge/Kotlin-7F52FF.svg?style=flat&logo=Kotlin&logoColor=white" alt="Kotlin">
</p>
<hr>

## 🔗 Quick Links

> - [📍 Overview](#-overview)
> - [🚀 Getting Started](#-getting-started)
    >   - [⚙️ Installation](#️-installation)
>   - [🤖 Running loud-speaker-android](#-running-loud-speaker-android)
>   - [🧪 Tests](#-tests)
> - [🤝 Contributing](#-contributing)
> - [📄 License](#-license)

---

## 📍 Overview

The microphone-to-speaker audio transmission solution fills a gap in the market, offering users a convenient and efficient method for real-time audio feedback. Through continuous development and optimization, we are confident that this product will become the preferred choice for real-time audio transmission in various settings.

With the rise of remote work, online education, and virtual events, the demand for real-time audio transmission solutions is on the rise. Furthermore, in the entertainment and performance sectors, real-time audio feedback is of paramount importance. As such, this project holds vast market potential.

---

## 🚀 Getting Started

***Requirements***

Ensure you have the following dependencies installed on your system:

- **Kotlin**: `version 1.9.0`
- **Android Studio**: `version 2023.2.1`
- **Android**: `version 14, API Leave 34`
- **Gradle**: `version 8.4`

### ⚙️ Installation

1. Clone the loud-speaker-android repository:

```sh
git clone https://github.com/RUV2005/loud-speaker-android
```

2. Change to the project directory:

```sh
cd loud-speaker-android
```

3. Install the dependencies:

```sh
./gradlew build
```

### 🤖 Running loud-speaker-android

Use the following command to run loud-speaker-android:

```sh
adb install build/outputs/apk/release/app-release-unsigned.apk
```

### 🧪 Tests

To execute tests, run:

```sh
gradle test
```

---

## 🤝 Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Submit Pull Requests](https://github.com/RUV2005/loud-speaker-android/pulls)**: Review open PRs, and submit your own PRs.
- **[Report Issues](https://github.com/RUV2005/loud-speaker-android/issues)**: Submit bugs found or log feature requests for Loud-speaker-android.

<details closed>
    <summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your GitHub account.
2. **Clone Locally**: Clone the forked repository to your local machine using a Git client.

   ```sh
   git clone https://github.com/RUV2005/loud-speaker-android
   ```

3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.

   ```sh
   git checkout -b new-feature-x
   ```

4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.

   ```sh
   git commit -m 'Implemented new feature x.'
   ```

6. **Push to GitHub**: Push the changes to your forked repository.

   ```sh
   git push origin new-feature-x
   ```

7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.

Once your PR is reviewed and approved, it will be merged into the main branch.

</details>

---

## 📄 License

This project is protected under the [MIT](./LICENSE) License. For more details, refer to the [LICENSE](./LICENSE) file.

---
