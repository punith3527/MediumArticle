# Clean and Scalable MVI Architecture for Compose Multiplatform

A comprehensive demonstration of building maintainable cross-platform applications using modern architecture patterns. This project showcases a **battle-tested MVI architecture** specifically designed for **Compose Multiplatform** that works seamlessly on Android 🤖, iOS 🍎, and Desktop 💻.

## 🚀 Project Overview

This project serves as a practical implementation guide for the Medium article: **"Clean and Scalable MVI Architecture for Compose Multiplatform"**. It demonstrates a real-world application architecture that scales from 1 to 100+ screens effortlessly.

### What You'll Find Here

- **🏗️ Production-Ready MVI Architecture** with type-safe state management
- **💉 Compile-Time Dependency Injection** using Tatarka Kotlin Inject
- **🧭 Type-Safe Navigation** with Compose Navigation 3 and serializable parameters
- **📡 Cross-Screen Communication** using listener patterns
- **🌐 Global State Management** with snackbars, popups, and error handling
- **🔄 Reactive Data Flow** that's predictable and maintainable

## 🎯 Key Features Demonstrated

### 🏠 Home Screen
- **User Information Display** with dynamic data
- **Repository List** with refresh functionality
- **Global Loading States** with overlay popups
- **Tab Navigation** and feature cards
- **Cross-Screen Communication** via listeners

### 🔐 Login Screen
- **Form Validation** with reactive state
- **Authentication Flow** with loading states
- **Type-Safe Navigation** to different screens
- **Error Handling** with user feedback

### 👤 Profile Screen
- **Profile Management** with update functionality
- **Listener-Based Communication** back to home screen
- **Logout Functionality** with state cleanup

## 📁 Project Structure

```
composeApp/src/commonMain/kotlin/com/punith/mediumarticle/
├── 🚀 App.kt                           # Main application entry point
├── 🧭 Navigator.kt                     # Type-safe navigation setup
├── 🏗️ arch/                           # Base architecture components
│   ├── 🎼 BaseRoute.kt                # Navigation & ViewModel integration
│   ├── 🧠 BaseViewModel.kt            # Base ViewModel with MVI pattern
│   └── 📡 GlobalListenerRegistry.kt   # Cross-screen communication
├── 💉 di/                            # Dependency injection
│   └── 🏭 ApplicationComponent.kt     # Global DI container
├── 🌐 global/                        # Global UI components
│   ├── 📢 GlobalSnackbar.kt          # App-wide notifications
│   └── 🎭 GlobalPopup.kt             # Global popup management
├── 🌍 network/                       # Network layer
│   └── 🔌 ApiClient.kt               # HTTP client abstraction
└── 📱 screens/                       # Feature modules
    ├── 🏠 home/                      # Home screen feature
    │   ├── HomeRoute.kt              # Navigation route
    │   ├── HomeViewModel.kt          # Business logic
    │   ├── HomeContract.kt           # MVI contracts
    │   ├── HomeRouter.kt             # Navigation handler
    │   ├── compose/HomeView.kt       # UI implementation
    │   ├── data/RepositoryService.kt # Data layer
    │   └── di/HomeComponent.kt       # Screen DI
    ├── 🔐 login/                     # Login screen feature
    └── 👤 profile/                   # Profile screen feature
```

## 🏗️ Architecture Components

### 1. BaseViewModel - The Foundation 🧠

```kotlin
abstract class BaseViewModel<UIState, UIEvent, NavEvent, UIEffect, Params>(
  protected val params: Params,
  initialState: UIState,
) : ViewModel() {
  // State management with reactive streams
  // Event handling with type safety
  // Navigation event emission
  // UI effect handling
  // Coroutine management with exception handling
}
```

**Key Features:**
- **🛡️ Type-safe generics** for all MVI components
- **🔒 Thread-safe state management** with immutable updates
- **🚨 Automatic exception handling** with user-friendly error display
- **♻️ Lifecycle-aware cleanup** to prevent memory leaks

### 2. BaseRoute - Navigation Orchestrator 🎼

```kotlin
@Composable
inline fun <VM : BaseViewModel<...>, UIState, UIEvent, NavEvent, UIEffect, Params> BaseRoute(
  backStackEntry: NavBackStackEntry,
  componentProvider: (Params, ApplicationComponent) -> VM,
  router: @Composable (Flow<NavEvent>) -> Unit,
  content: @Composable (UIState, (UIEvent) -> Unit, Flow<UIEffect>) -> Unit,
)
```

**Benefits:**
- **🔗 Automatic parameter extraction** and type checking
- **🏭 ViewModel factory integration** with DI
- **📡 Reactive state streaming** to UI
- **🧭 Navigation event routing**

### 3. Dependency Injection with Tatarka Kotlin Inject 💉

```kotlin
@ApplicationScope
@Component
abstract class ApplicationComponent {
  @ApplicationScope
  @Provides
  fun provideApiClient(): ApiClient = MockApiClient()
}

@HomeScope
@Component
abstract class HomeComponent(
  @get:Provides val params: HomeParams,
  @Component val applicationComponent: ApplicationComponent,
) {
  abstract val homeViewModel: HomeViewModel
}
```

**Advantages:**
- **⚡ Compile-time safety** - No runtime dependency resolution failures
- **🏃‍♂️ Zero reflection overhead** - Pure compile-time code generation
- **🧩 Modularity** - Screen-scoped dependencies don't pollute global scope
- **🧪 Easy testing** - Simple dependency mocking

## 🔄 Data Flow Architecture

```
UI Event → ViewModel → State Update → UI Recomposition
    ↓           ↓           ↓
📱 User      🧠 Logic    ✨ Magic
Clicks   →   Processes → Renders
    ↓
🧭 Navigation Event → Router → Screen Navigation
    ↓
💫 UI Effect → Global Systems (Snackbars, Popups)
    ↓
📡 Cross-Screen Event → Listener Registry → Other Screens
```

## 🛠️ Tech Stack

| Technology | Purpose | Version |
|------------|---------|---------|
| **Kotlin Multiplatform** | Cross-platform development | 2.2.20 |
| **Compose Multiplatform** | UI framework | 1.8.2 |
| **Compose Navigation 3** | Type-safe navigation | 2.8.0-alpha13 |
| **Tatarka Kotlin Inject** | Compile-time DI | 0.8.0 |
| **Kotlin Coroutines** | Reactive programming | Built-in |
| **Kotlinx Serialization** | Data serialization | 1.9.0 |
| **Kotlinx DateTime** | Date/time handling | 0.7.1 |

## 🚀 Getting Started

### Prerequisites
- **Android Studio** Hedgehog (2023.1.1) or later
- **Xcode** 15+ (for iOS development)
- **JDK** 11 or later

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/punith3527/MediumArticle.git
   cd MediumArticle
   ```

2. **Open in Android Studio**
   - Open Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned repository

3. **Run on different platforms**
   
   **Android:**
   ```bash
   ./gradlew :composeApp:installDebug
   ```
   
   **iOS:**
   - Open `iosApp/iosApp.xcodeproj` in Xcode
   - Select target device/simulator
   - Run the project

   **Desktop:**
   ```bash
   ./gradlew :composeApp:run
   ```

### Key Gradle Dependencies

```kotlin
commonMain.dependencies {
    implementation(compose.runtime)
    implementation(compose.material3)
    implementation(libs.androidx.lifecycle.viewmodelCompose)
    implementation(libs.kotlin.inject.runtime)
    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)
}
```

## 🎯 Real-World Usage Example

### User Journey: "Refresh Repositories"

1. **👆 User Action**: Clicks refresh button in `HomeView`
2. **📡 Event Emission**: `onEvent(HomeUIEvent.RefreshData)`
3. **🧠 ViewModel Processing**: `refreshDataHandler()` receives event
4. **🔄 State Update**: `updateState { copy(processState = processState.copy(refreshing = true)) }`
5. **🌐 Network Call**: `repositoryService.refreshRepositories()`
6. **✨ UI Update**: Compose automatically recomposes with loading state
7. **🎉 Success**: Data loads, loading disappears, repositories appear
8. **📢 Feedback**: Success snackbar shown to user

**✨ The Magic**: This entire flow is type-safe, predictable, and automatically handles errors!

## 🧪 Testing Strategy

The architecture supports comprehensive testing at multiple levels:

- **Unit Tests**: ViewModel logic with mockable dependencies
- **Integration Tests**: Screen-level testing with test doubles
- **UI Tests**: Cross-platform UI testing with shared test code

## 📈 Scalability Benefits

- **📱 Add New Screens**: Follow the established pattern (Contract → ViewModel → View → Route → Router)
- **🔧 Feature Modules**: Self-contained screens with clear boundaries
- **👥 Team Collaboration**: Standardized patterns enable parallel development
- **🔄 Maintenance**: Predictable structure makes debugging and updates easier

## 🤝 Contributing

This project serves as a reference implementation. Feel free to:

1. **Fork the repository**
2. **Create a feature branch**
3. **Submit a pull request** with improvements or additions
4. **Open issues** for discussions or questions

## 📚 Related Resources

- [Original Medium Article](./Article.md) - Complete architectural guide
- [Compose Multiplatform Documentation](https://github.com/JetBrains/compose-multiplatform)
- [Tatarka Kotlin Inject](https://github.com/evant/kotlin-inject)
- [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

---

**Built with ❤️ using Compose Multiplatform and modern Android development practices.**

*This project demonstrates production-ready patterns for building scalable, maintainable cross-platform applications. Perfect for teams looking to adopt Compose Multiplatform with confidence.*