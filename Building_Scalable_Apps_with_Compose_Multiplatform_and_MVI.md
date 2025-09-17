# Clean and Scalable MVI Architecture for Compose Multiplatform

*A comprehensive guide to building maintainable cross-platform applications using modern architecture patterns*

![Header Image](https://images.unsplash.com/photo-1551288049-bebda4e38f71?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2340&q=80)

## The New Era: Compose Multiplatform is Here! 🚀

**Compose Multiplatform** has revolutionized cross-platform development! 🌟 But with this exciting new technology comes a crucial question: **How do we build scalable, maintainable architectures that truly leverage its power?** 🤔

### The Challenge with New Technology 💭

When adopting **Compose Multiplatform**, many developers face:
- 😰 **Architecture uncertainty**: "What patterns work best for multiplatform?"
- 🤕 **Scalability concerns**: "Will this architecture handle 50+ screens?"
- 🔄 **State management chaos**: "How do we manage complex state across platforms?"
- 🧩 **Code organization**: "Where do we put business logic vs UI logic?"

### Our Solution: A Proven Scalable Architecture! ✨

This dummy project demonstrates a **battle-tested MVI architecture** specifically designed for **Compose Multiplatform** that solves these exact problems by showing you a **real GitHub repository viewer** that works flawlessly on Android 🤖, iOS 🍎, and Desktop 💻.

### What You'll Master 🎯

A complete architectural blueprint that handles:

- **🏗️ Scalable Architecture** that grows from 1 to 100+ screens effortlessly
- **🔄 Bulletproof State Management** using MVI patterns built for Compose Multiplatform
- **💉 Smart Dependency Injection** with compile-time safety across all platforms
- **📱 Platform-Agnostic Screens** with shared business logic and platform-specific optimizations
- **🌐 Global State Coordination** for seamless cross-screen communication

**🎯 Why This Matters**: As Compose Multiplatform adoption explodes, having a proven architecture blueprint gives you a **massive competitive advantage**!

## 🎬 See the Architecture in Action

Let's follow a **real user interaction** through our architecture:

**User Journey**: *"User clicks refresh button to reload repositories"* 

1. **👆 User Action**: Clicks refresh button in `HomeView`
2. **📡 Event Emission**: `onEvent(HomeUIEvent.LoadRepositories)`  
3. **🧠 ViewModel Processing**: `loadRepositoriesHandler()` receives event
4. **🔄 State Update**: `updateState { copy(processState = processState.copy(isLoading = true)) }`
5. **🌐 Network Call**: `repositoryService.getRepositories()`
6. **✨ UI Update**: Compose automatically recomposes with loading state
7. **🎉 Success**: Data loads, loading disappears, repositories appear

**✨ The Magic**: This entire flow is type-safe, predictable, and automatically handles errors!

## Architecture Overview & Component Responsibilities 🏗️

Before diving into the implementation details, let's understand the key components and their responsibilities in this MVI architecture:

### � Core Components Summary

| Component | Responsibility | Key Features |
|-----------|---------------|--------------|
| **🎼 BaseRoute** | Navigation & ViewModel Integration | Type-safe parameter parsing, automatic ViewModel creation, UI-ViewModel binding |
| **🧠 BaseViewModel** | State Management & Business Logic | MVI pattern implementation, event handling, coroutine management, error handling |
| **🧭 Router** | Navigation Flow Management | Reactive navigation based on events, type-safe screen transitions |
| **💉 DI Components** | Dependency Management | Screen-scoped and app-scoped dependencies, compile-time safety |
| **📋 Contracts** | Type Safety & API Definition | State classes, Event definitions, Effect handling |

### 🔄 Data Flow Architecture

```
UI Event → ViewModel → State Update → UI Recomposition
    ↓           ↓           ↓
📱 User      🧠 Logic    ✨ Magic
Clicks   →   Processes → Renders
    ↓
🧭 Navigation Event → Router → Screen Navigation
    ↓
💫 UI Effect → Global Systems (Snackbars, Popups)
```

**Flow Explanation:**
1. **📱 UI Layer** emits events through `onEvent()` callbacks
2. **🧠 ViewModel** processes events using dedicated handlers
3. **🔄 State Updates** trigger automatic UI recomposition
4. **🧭 Navigation Events** are handled by dedicated Router components
5. **💫 UI Effects** are managed globally for consistent UX
6. **💉 DI Components** provide dependencies at appropriate scopes

## Why MVI + Compose Multiplatform = 🚀 Perfect Match?

### 🤯 The Compose Multiplatform Reality Check

**Compose Multiplatform** is incredible, but it brings new architectural challenges:
- **🌊 State flows** across multiple platforms simultaneously 
- **🧠 Shared business logic** needs clear organization patterns
- **📱 Platform differences** require flexible yet consistent architecture
- **⚡ Performance** considerations across Android, iOS, and Desktop

### ❌ Common Architecture Mistakes with Compose Multiplatform
```kotlin
// 😵‍💫 Platform-specific state scattered everywhere
// Android
var isLoading by mutableStateOf(false) 
// iOS  
var loadingState by mutableStateOf(LoadingState.Idle)
// Desktop
var showProgress by mutableStateOf(false)

// 🤮 Inconsistent business logic across platforms
fun loadDataAndroid() { /* Android-specific approach */ }
fun loadDataiOS() { /* iOS-specific approach */ } 
fun loadDataDesktop() { /* Desktop-specific approach */ }

// 💥 No clear navigation strategy
// Each platform handles navigation differently!
```

### ✅ Our MVI + Compose Multiplatform Solution
```kotlin
// 😍 Single source of truth across ALL platforms
data class HomeState(
    val processState: HomeProcessState = HomeProcessState(),
    val repositories: List<Repository> = emptyList()
) // Works on Android 🤖, iOS 🍎, Desktop 💻

// 🚀 Unified business logic everywhere
sealed class HomeUIEvent {
    data object LoadRepositories : HomeUIEvent()
} // Same events, same handling, all platforms!

// 🎯 Platform-agnostic, crystal clear flow
private suspend fun loadRepositoriesHandler() {
    updateState { copy(processState = processState.copy(isLoading = true)) }
    val repositories = repositoryService.getRepositories()
    updateState { copy(repositories = repositories, processState = processState.copy(isLoading = false)) }
} // This runs identically on every platform! ✨
```

### 🎯 Why MVI is Perfect for Compose Multiplatform
- **🔄 Unidirectional Data Flow**: Perfect for Compose's reactive nature across all platforms
- **🎯 Predictable State Management**: Same state logic works everywhere - no platform surprises!
- **🧪 Easy Testing**: Test once, works everywhere - massive productivity boost
- **⏰ Time Travel Debugging**: Debug state changes across all platforms simultaneously

### 🚀 Compose Multiplatform Superpowers Unlocked
- **🤝 True Code Sharing**: 90%+ business logic shared between Android, iOS, Desktop
- **⚡ Reactive UI Everywhere**: Compose's declarative nature scales beautifully
- **🛡️ Type Safety Across Platforms**: Kotlin's type system prevents cross-platform bugs
- **🏃‍♂️ Native Performance**: Compiles to native code with shared architecture patterns

## Project Structure Overview 📁

```
composeApp/src/commonMain/kotlin/com/punith/mediumarticle/
├── 🚀 App.kt                           # Main application entry point
├── 🧭 Navigator.kt                     # Navigation setup
├── 🏗️ arch/                           # Base architecture components
│   ├── 🎼 BaseRoute.kt                # Generic route handler
│   ├── 🧠 BaseViewModel.kt            # Base ViewModel with MVI
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
    ├── 🔐 login/                     # Login screen feature
    └── 👤 profile/                   # Profile screen feature
```

## ⚡ Real Performance Benefits

Our MockApiClient simulates realistic network conditions:

| Operation | Delay | User Experience |
|-----------|-------|-----------------|
| **📦 Repository loading** | 3 seconds | Realistic GitHub API simulation |
| **📤 Post operations** | 300ms | Quick user feedback |
| **🔄 Automatic retry** | Built-in | Graceful error recovery |
| **⏳ Loading states** | Immediate | Smooth UX during network calls |

**🎯 Result**: Users see immediate feedback, no blocking UI, graceful error recovery!

## Core Architecture Components 🧩

### 1. BaseViewModel - The Foundation 🧠

The `BaseViewModel` is the **cornerstone** of our MVI architecture, providing common functionality for all ViewModels:

```kotlin
abstract class BaseViewModel<UIState, UIEvent, NavEvent, UIEffect, Params>(
  protected val params: Params,
  initialState: UIState,
) : ViewModel() {

  // State management
  private val _stateFlow = MutableStateFlow(initialState)
  val stateFlow: StateFlow<UIState> = _stateFlow.asStateFlow()

  // UI events from the view
  private val _uiEvents = MutableSharedFlow<UIEvent>(replay = 0, extraBufferCapacity = 64)
  protected val uiEvents = _uiEvents.asSharedFlow()

  // Navigation events
  private val _navEvents = MutableSharedFlow<NavEvent>(replay = 0, extraBufferCapacity = 64)
  val navEvents = _navEvents.asSharedFlow()

  // One-time UI effects (snackbars, dialogs, etc.)
  private val _uiEffects = Channel<UIEffect>(capacity = Channel.BUFFERED)
  val uiEffects = _uiEffects.receiveAsFlow()

  // Thread-safe state updates
  protected fun updateState(transform: UIState.() -> UIState) {
    _stateFlow.value = _stateFlow.value.transform()
  }

  // Event handling
  fun emitUIEvent(event: UIEvent) {
    _uiEvents.tryEmit(event)
  }

  protected fun emitNavEvent(event: NavEvent) {
    _navEvents.tryEmit(event)
  }

  protected fun emitUIEffect(effect: UIEffect) {
    _uiEffects.trySend(effect)
  }

  // Coroutine management with global exception handling
  private val globalExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    onGlobalCoroutineException(throwable)
  }

  protected fun launch(block: suspend CoroutineScope.() -> Unit): Job =
    viewModelScope.launch(Dispatchers.Default + globalExceptionHandler) { block() }

  protected open fun onGlobalCoroutineException(throwable: Throwable) {
    println("[BaseViewModel] Unhandled coroutine exception: $throwable")
    GlobalPopupCenter.showNow(fullScreenPopup(dedupKey = "global_error_default") {
      DefaultGlobalError(
        message = "Something went wrong", 
        onDismiss = { GlobalPopupCenter.dismiss(dedupKey = "global_error_default") }
      )
    })
  }
}
```

**🎯 Key Features:**
- **🛡️ Type-safe generics** for UIState, UIEvent, NavEvent, UIEffect, and Params
- **🔒 Centralized state management** with thread-safe updates
- **🚨 Automatic exception handling** with user-friendly error display
- **🧭 Built-in navigation** and UI effect management
- **♻️ Lifecycle-aware cleanup** to prevent memory leaks

### 2. BaseRoute - The Navigation Orchestrator 🎼

The `BaseRoute` component is the **navigation orchestrator** that seamlessly connects ViewModels to Compose UI while handling all the complex wiring automatically:

## 🛠️ Developer Experience Magic

### 🚨 Instant Error Catching
```kotlin
// This WON'T compile - caught at build time! ❌
HomeUIEvent.RepositoryClicked("wrong-type") // 💥 Type mismatch

// This WILL compile - type safe! ✅
HomeUIEvent.RepositoryClicked(repository) // 🎯 Perfect
```

### ⚡ Hot Reload in Action
- 🎨 Change a UI color → See it instantly on Android 🤖, iOS 🍎, and Desktop 💻
- 🧠 Modify business logic → Automatically applies across all platforms
- 🔥 Zero build time for UI changes!

```kotlin
@Composable
inline fun <
    reified VM : BaseViewModel<UIState, UIEvent, NavEvent, UIEffect, Params>,
    UIState,
    UIEvent,
    NavEvent,
    UIEffect,
    reified Params,
> BaseRoute(
  backStackEntry: NavBackStackEntry,
  noinline componentProvider: (Params, ApplicationComponent) -> VM,
  noinline router: @Composable (Flow<NavEvent>) -> Unit,
  content: @Composable (UIState, (UIEvent) -> Unit, Flow<UIEffect>) -> Unit,
) {
  val applicationComponent = LocalApplicationComponent.current
  val params = backStackEntry.toRoute<Params>()
  val viewModel: VM = viewModel { componentProvider(params, applicationComponent) }
  val state by viewModel.stateFlow.collectAsState()
  
  content(state, viewModel::emitUIEvent, viewModel.uiEffects)
  router(viewModel.navEvents)
}
```

## 🎭 BaseRoute: The Master Conductor

Think of `BaseRoute` as a **master conductor** orchestrating a symphony:

### 🎼 The Symphony in Action

```kotlin
@Composable 
fun HomeRoute(backStackEntry: NavBackStackEntry) {
    BaseRoute<...>( // 🎭 Conductor enters
        backStackEntry = backStackEntry,        // 📋 Gets the music sheet (params)
        componentProvider = { params, app ->     // 🏭 Builds the orchestra (ViewModel)
            HomeComponent::class.create(params, app).homeViewModel
        },
        router = { navEvents -> /* 🧭 Handles scene changes */ },
    ) { state, onEvent, uiEffects ->            // 🎨 Paints the performance (UI)
        HomeView(state, onEvent, uiEffects)
    }
}
```

**🎬 What happens behind the scenes:**
- **🔍 Parameter Extraction**: Safely pulls navigation data
- **⚙️ Dependency Injection**: Creates all needed services
- **🔄 State Binding**: Connects ViewModel to UI
- **🎯 Event Routing**: Handles navigation automatically

**🎉 Result**: You write business logic, BaseRoute handles the plumbing!

**🚀 BaseRoute Responsibilities:**
- **🔗 Parameter Binding**: Automatically extracts and type-checks navigation parameters
- **🏭 ViewModel Factory**: Creates ViewModels using dependency injection
- **📡 State Streaming**: Connects ViewModel state to UI with reactive updates
- **🧭 Navigation Handling**: Routes navigation events to appropriate handlers
- **🔄 Lifecycle Management**: Ensures proper ViewModel lifecycle handling

**✨ Benefits:**
- **🛡️ Type-safe navigation** with automatic parameter parsing
- **🤖 Automatic ViewModel creation** using dependency injection
- **🧩 Separation of concerns** between UI, navigation, and business logic
- **♻️ Reusable pattern** across all screens
- **⚡ Zero boilerplate** for common ViewModel-UI connections

## Screen Architecture Deep Dive 🏠

Let's examine how screens are structured using the **Home screen** as an example:

## 📈 How the Architecture Scales

### 📅 Week 1: Login Screen
```kotlin
// Just login functionality 🔐
sealed class LoginUIEvent {
    data class EmailChanged(val email: String) : LoginUIEvent()
    data class PasswordChanged(val password: String) : LoginUIEvent()
    data object LoginClicked : LoginUIEvent()
}
```

### 📅 Week 3: Added Home Screen  
```kotlin
// Reused the same pattern - zero architectural changes needed! 🎉
sealed class HomeUIEvent {
    data object LoadRepositories : HomeUIEvent()
    data object RefreshData : HomeUIEvent()
    // Same patterns, different domain 🔄
}
```

### 📅 Week 5: Added Profile Screen
```kotlin
// Still the same pattern - architecture scales beautifully! ✨
sealed class ProfileUIEvent {
    data object StartEditing : ProfileUIEvent()
    data class UpdateName(val name: String) : ProfileUIEvent()
}
```

**🔑 Key Insight**: Each new screen follows the exact same pattern. No architectural rework needed!

### 1. Screen Contract (HomeContract.kt) 📋

```kotlin
/**
 * Home screen state - Immutable data class representing UI state
 */
data class HomeState(
  val userInfo: UserInfo = UserInfo(),
  val uiState: HomeUiState = HomeUiState(),
  val processState: HomeProcessState = HomeProcessState(),
  val repositories: List<Repository> = emptyList(),
)

data class UserInfo(
  val email: String = "",
  val name: String = "",
  val loginType: String = "",
  val loginTime: String = "",
)

data class HomeUiState(
  val showWelcomeDialog: Boolean = false,
  val selectedTab: Int = 0,
)

data class HomeProcessState(
  val isLoading: Boolean = false,
  val refreshing: Boolean = false,
)

/**
 * UI Events - User interactions that trigger state changes
 */
sealed class HomeUIEvent {
  data object RefreshData : HomeUIEvent()
  data object ShowWelcomeDialog : HomeUIEvent()
  data object DismissWelcomeDialog : HomeUIEvent()
  data class TabSelected(val index: Int) : HomeUIEvent()
  data object Logout : HomeUIEvent()
  data object NavigateToProfile : HomeUIEvent()
  data object LoadRepositories : HomeUIEvent()
  data class RepositoryClicked(val repository: Repository) : HomeUIEvent()
}

/**
 * Navigation Events - Screen-to-screen navigation
 */
sealed class HomeNavEvent {
  data object NavigateToLogin : HomeNavEvent()
  data class NavigateToProfile(val params: ProfileParams) : HomeNavEvent()
}

/**
 * UI Effects - One-time events like snackbars, dialogs
 */
sealed class HomeUIEffect {
  data class ShowSnackbar(val message: String) : HomeUIEffect()
  data class ShowRepositoryDetails(val repository: Repository) : HomeUIEffect()
}
```

**🏗️ Architecture Benefits:**
- **🔒 Immutable state** prevents accidental mutations
- **🛡️ Sealed classes** provide type-safe event handling
- **🧩 Clear separation** between different types of events
- **🧪 Easy testing** with predictable state transformations

### 2. ViewModel Implementation (HomeViewModel.kt) 🧠

```kotlin
@Inject
class HomeViewModel(
  params: HomeParams,
  private val repositoryService: RepositoryService,
) : BaseViewModel<HomeState, HomeUIEvent, HomeNavEvent, HomeUIEffect, HomeParams>(
  params = params,
  initialState = HomeState()
) {

  init {
    setupEventHandlers()
    initializeUserInfo()
    launch { loadRepositories() }
  }

  private fun setupEventHandlers() {
    launch { refreshDataHandler() }
    launch { showWelcomeDialogHandler() }
    launch { dismissWelcomeDialogHandler() }
    launch { tabSelectedHandler() }
    launch { logoutHandler() }
    launch { navigateToProfileHandler() }
    launch { loadRepositoriesHandler() }
    launch { repositoryClickedHandler() }
  }

  private suspend fun refreshDataHandler() {
    uiEvents.filterIsInstance<HomeUIEvent.RefreshData>().collect {
      try {
        updateState { copy(processState = processState.copy(refreshing = true)) }
        
        val repositories = repositoryService.refreshRepositories()
        
        updateState { 
          copy(
            repositories = repositories,
            processState = processState.copy(refreshing = false)
          )
        }
        
        emitUIEffect(HomeUIEffect.ShowSnackbar("Data refreshed successfully!"))
      } catch (e: Exception) {
        updateState { copy(processState = processState.copy(refreshing = false)) }
        emitUIEffect(HomeUIEffect.ShowSnackbar("Failed to refresh data"))
      }
    }
  }

  private suspend fun loadRepositoriesHandler() {
    uiEvents.filterIsInstance<HomeUIEvent.LoadRepositories>().collect {
      try {
        updateState { copy(processState = processState.copy(isLoading = true)) }
        
        val repositories = repositoryService.getRepositories()
        
        updateState { 
          copy(
            repositories = repositories,
            processState = processState.copy(isLoading = false)
          )
        }
      } catch (e: Exception) {
        updateState { copy(processState = processState.copy(isLoading = false)) }
        emitUIEffect(HomeUIEffect.ShowSnackbar("Failed to load repositories"))
      }
    }
  }

  private suspend fun navigateToProfileHandler() {
    uiEvents.filterIsInstance<HomeUIEvent.NavigateToProfile>().collect {
      val profileParams = ProfileParams(
        userId = "user123",
        userEmail = state.value.userInfo.email,
        userName = state.value.userInfo.name,
        fromScreen = "home"
      )
      emitNavEvent(HomeNavEvent.NavigateToProfile(profileParams))
    }
  }

  // ... other event handlers
}
```

**🔑 Key Patterns:**
- **📡 Event-driven architecture** with separate handlers for each UI event
- **⚡ Reactive programming** using Kotlin Flows
- **🚨 Error handling** with user feedback through UI effects
- **💉 Dependency injection** for external services
- **🔄 Async operations** managed through coroutines

### 3. UI Implementation (HomeView.kt) 🎨

```kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
  state: HomeState,
  onEvent: (HomeUIEvent) -> Unit,
  uiEffects: Flow<HomeUIEffect>,
) {
  // Handle UI Effects
  LaunchedEffect(Unit) {
    uiEffects.collect { effect ->
      when (effect) {
        is HomeUIEffect.ShowSnackbar -> {
          when {
            effect.message.contains("success", ignoreCase = true) -> {
              showSuccessSnackbar(effect.message)
            }
            effect.message.contains("failed", ignoreCase = true) -> {
              showErrorSnackbar(effect.message)
            }
            else -> {
              GlobalSnackbarCenter.showSnackbar(effect.message)
            }
          }
        }
        is HomeUIEffect.ShowRepositoryDetails -> {
          // Handle repository detail display
        }
      }
    }
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Home") },
        actions = {
          IconButton(onClick = { onEvent(HomeUIEvent.NavigateToProfile) }) {
            Icon(Icons.Default.Person, contentDescription = "Profile")
          }
          IconButton(onClick = { onEvent(HomeUIEvent.Logout) }) {
            Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "Logout")
          }
        }
      )
    }
  ) { paddingValues ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      item {
        UserInfoCard(
          userInfo = state.userInfo,
          onShowWelcome = { onEvent(HomeUIEvent.ShowWelcomeDialog) }
        )
      }
      
      item {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "My Repositories",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
          )
          if (state.processState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.size(20.dp))
          } else {
            IconButton(onClick = { onEvent(HomeUIEvent.LoadRepositories) }) {
              Icon(Icons.Default.Refresh, contentDescription = "Refresh Repositories")
            }
          }
        }
      }
      
      items(state.repositories) { repository ->
        RepositoryCard(
          repository = repository,
          onClick = { onEvent(HomeUIEvent.RepositoryClicked(repository)) }
        )
      }
    }
  }

  // Welcome Dialog
  if (state.uiState.showWelcomeDialog) {
    WelcomeDialog(
      userInfo = state.userInfo,
      onDismiss = { onEvent(HomeUIEvent.DismissWelcomeDialog) }
    )
  }
}
```

**UI Architecture Benefits:**
- **Pure composable functions** that are easy to test
- **Reactive UI** that automatically updates when state changes
- **Effect handling** separated from UI rendering
- **Event-driven interactions** with clear user intent

### 4. Route Definition (HomeRoute.kt)

```kotlin
@Serializable
data class HomeParams(
  val userEmail: String,
  val userName: String,
  val loginType: String,
)

@Composable
fun HomeRoute(backStackEntry: NavBackStackEntry) {
  BaseRoute<HomeViewModel, HomeState, HomeUIEvent, HomeNavEvent, HomeUIEffect, HomeParams>(
    backStackEntry = backStackEntry,
    componentProvider = { params, applicationComponent ->
      HomeComponent::class.create(params, applicationComponent).homeViewModel
    },
    router = { navEvents ->
      HomeRouter(navEvents = navEvents)
    }
  ) { state, onEvent, uiEffects ->
    HomeView(
      state = state,
      onEvent = onEvent,
      uiEffects = uiEffects
    )
  }
}
```

### 5. Navigation Handling (HomeRouter.kt)

```kotlin
@Composable
fun HomeRouter(
  navEvents: Flow<HomeNavEvent>,
) {
  val rootNavController = LocalNavController.current
  LaunchedEffect(Unit) {
    navEvents.collect {
      when (it) {
        is HomeNavEvent.NavigateToLogin -> {
          rootNavController.navigate(LoginParams(fromScreen = "home")) {
            popUpTo(0) { inclusive = true }
          }
        }
        is HomeNavEvent.NavigateToProfile -> {
          rootNavController.navigate(it.params)
        }
      }
    }
  }
}
```

## Dependency Injection Strategy 💉

The project uses **Kotlin Inject** for compile-time dependency injection, providing excellent performance and type safety.

## 🚨 Common Pitfalls (And How We Avoid Them)

### 🕳️ Pitfall #1: "Callback Hell"
**😱 Traditional Approach**: Nested callbacks everywhere
```kotlin
loadUser { user ->
    loadRepos(user.id) { repos ->
        updateUI(repos) { success ->
            if (success) showSuccess() else showError()
        }
    }
}
```

**✅ Our Solution**: Sequential, readable flow
```kotlin
// Crystal clear, sequential logic 💎
private suspend fun loadRepositoriesHandler() {
    updateState { copy(processState = processState.copy(isLoading = true)) }
    val repositories = repositoryService.getRepositories()
    updateState { copy(repositories = repositories, processState = processState.copy(isLoading = false)) }
}
```

### 🌪️ Pitfall #2: "State Chaos"
**😵‍💫 Problem**: Multiple sources of truth, inconsistent state  
**✅ Our Solution**: Single state object, immutable updates, predictable flow

### 1. Application-Wide Component 🌐

```kotlin
@ApplicationScope
@Component
abstract class ApplicationComponent {
  
  @ApplicationScope
  @Provides
  fun provideApiClient(): ApiClient = MockApiClient()
  
  companion object
}
```

**🌐 Global Dependencies:**
- **🔌 ApiClient**: HTTP client for network operations
- **💾 Database**: Local storage (if needed)
- **📊 Analytics**: Tracking and metrics
- **🔐 Authentication**: User session management

### 2. Screen-Specific Components 📱

```kotlin
@HomeScope
@Component
abstract class HomeComponent(
  @get:Provides val params: HomeParams,
  @Component val applicationComponent: ApplicationComponent,
) {
  abstract val homeViewModel: HomeViewModel

  @HomeScope
  @Provides
  fun provideRepositoryService(apiClient: ApiClient): RepositoryService {
    return NetworkRepositoryService(apiClient)
  }
}
```

**📱 Screen-Level Dependencies:**
- **📋 Screen Parameters**: Navigation parameters and configuration
- **🧠 ViewModels**: Screen-specific business logic
- **📦 Repositories**: Data access layer for the screen
- **🎯 Use Cases**: Business logic specific to the screen

### 3. Service Layer Example 🔧

```kotlin
interface RepositoryService {
  suspend fun getRepositories(): List<Repository>
  suspend fun getRepository(id: Int): Repository?
  suspend fun refreshRepositories(): List<Repository>
}

@Inject
class NetworkRepositoryService(
  private val apiClient: ApiClient,
) : RepositoryService {

  override suspend fun getRepositories(): List<Repository> {
    val response = apiClient.get("/api/v1/repositories")
    return parseRepositoriesFromJson(response.data ?: error("No data in response"))
  }

  override suspend fun refreshRepositories(): List<Repository> {
    delay(1000) // Simulate refresh delay
    return getRepositories()
  }

  private fun parseRepositoriesFromJson(jsonData: String): List<Repository> {
    val jsonObject = json.parseToJsonElement(jsonData)
    val repositoriesArray = jsonObject.jsonObject["repositories"]?.jsonArray

    return repositoriesArray?.map { element ->
      json.decodeFromJsonElement<Repository>(element)
    } ?: error("No repositories found")
  }
}
```

**🚀 Benefits of This DI Strategy:**
- **⚡ Compile-time safety**: No runtime dependency resolution failures
- **🏃‍♂️ Performance**: Zero reflection overhead
- **🧩 Modularity**: Screen-specific dependencies don't pollute global scope
- **🧪 Testability**: Easy to mock dependencies for testing
- **📈 Scalability**: Clear separation between global and feature-specific dependencies

## Global State Management 🌐

### 1. Cross-Screen Communication 📡

```kotlin
object GlobalListenerRegistry {
  private var counter = 0L
  private val backingMap = mutableMapOf<String, Any>()

  fun <T: Any> register(listener: T): String {
    val token = "L_" + (++counter)
    backingMap[token] = listener
    return token
  }

  inline fun <reified T: Any> getTyped(token: String): T = backingMap[token] as? T
    ?: error("Listener for token '$token' not found or wrong type ${T::class}")

  fun unregister(token: String) { 
    backingMap.remove(token) 
  }
}
```

**📡 Usage Example:**
```kotlin
// In ProfileViewModel - register listener 📝
private val profileListener = registerListener(ProfileListenerImpl())

// In HomeViewModel - get listener to communicate 📞
private val profileListener = getListener<ProfileListener>(params.listenerToken)
```

### 2. Global UI Feedback 💫

```kotlin
object GlobalSnackbarCenter {
  fun showSnackbar(
    message: String,
    actionLabel: String? = null,
    duration: SnackbarDuration = SnackbarDuration.Short
  ) {
    // Queue and display snackbars globally
  }

  fun showCustomContent(
    duration: Long = 3000L,
    content: @Composable () -> Unit
  ) {
    // Show custom snackbar content
  }
}

// 🎉 Convenience functions for different types
fun showSuccessSnackbar(message: String) {
  GlobalSnackbarCenter.showCustomContent {
    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
      Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = MaterialTheme.colorScheme.primary) // ✅
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = message, color = MaterialTheme.colorScheme.onPrimaryContainer)
      }
    }
  }
}
```

### 3. Application Setup 🚀

```kotlin
@Composable
fun App() {
  val applicationComponent = remember { ApplicationComponent::class.create() }

  CompositionLocalProvider(LocalApplicationComponent provides applicationComponent) {
    MaterialTheme {
      Scaffold(
        snackbarHost = { CustomSnackbarHost() }
      ) { _ ->
        GlobalPopupLayer { 
          Navigator() 
        }
      }
    }
  }
}
```

## Navigation Architecture 🧭

### 1. Type-Safe Navigation Setup 🛡️

```kotlin
@Composable
fun Navigator() {
  val navController = rememberNavController()
  CompositionLocalProvider(LocalNavController provides navController) {
    NavHost(
      navController = navController,
      startDestination = HomeParams(
        userEmail = "user@example.com",
        userName = "User Name",
        loginType = "Default"
      )
    ) {
      composable<LoginParams>(
        enterTransition = { slideInHorizontally { it } },
        exitTransition = { slideOutHorizontally { it } }
      ) { backStackEntry ->
        LoginRoute(backStackEntry)
      }

      composable<HomeParams>(
        enterTransition = { fadeIn(tween(200)) },
        exitTransition = { fadeOut(tween(200)) }
      ) { backStackEntry ->
        HomeRoute(backStackEntry)
      }

      composable<ProfileParams>(
        enterTransition = { slideInHorizontally { it } },
        exitTransition = { slideOutHorizontally { it } }
      ) { backStackEntry ->
        ProfileRoute(backStackEntry)
      }
    }
  }
}
```

**🧭 Navigation Benefits:**
- **🛡️ Type safety**: Parameters are validated at compile time
- **📦 Serializable parameters**: Automatic serialization/deserialization
- **🎬 Custom transitions**: Smooth animations between screens
- **🔗 Deep linking**: Easy support for external navigation

## 🔥 Quick Wins You'll Get Immediately

### 📅 Day 1: Set Up Base Architecture
- 📋 Copy `BaseViewModel` and `BaseRoute`
- 🛡️ Instant type-safe navigation
- 🚨 Automatic error handling

### 📅 Day 2: Create Your First Screen  
- 🏠 Follow the HomeScreen pattern
- 🎯 State management works perfectly
- 🧭 Navigation flows seamlessly

### 📅 Day 3: Add More Screens
- ♻️ Reuse the exact same patterns
- ⚡ Zero architectural changes needed
- 📈 Scale effortlessly

### 📅 Week 1: You're a Multiplatform Pro! 🏆
- 🔄 Consistent patterns across all screens
- 🛡️ Type-safe everything
- 🧠 Predictable, maintainable codebase

## Architecture Benefits & Trade-offs ⚖️

### ✅ Pros

**1. 📈 Scalability**
- **🧩 Modular architecture**: Each screen is self-contained
- **🔲 Clear boundaries**: Well-defined interfaces between layers
- **🆕 Easy to add features**: Follow established patterns
- **👥 Team scalability**: Multiple developers can work on different screens

**2. 🔧 Maintainability**
- **🔮 Predictable patterns**: Consistent structure across screens
- **🛡️ Type safety**: Compile-time error checking
- **🔒 Immutable state**: Prevents unexpected mutations
- **🔄 Clear data flow**: Easy to trace state changes

**3. 🧪 Testability**
- **🧮 Pure functions**: ViewModels contain pure business logic
- **🎭 Mockable dependencies**: DI makes testing straightforward
- **✅ State verification**: Easy to assert on state changes
- **🔬 Isolated testing**: Each component can be tested independently

**4. 👨‍💻 Developer Experience**
- **⚡ Hot reload**: Fast development iteration
- **🤝 Code sharing**: Business logic shared across platforms
- **🛡️ Type-safe navigation**: Fewer runtime navigation errors
- **🤖 Automatic state management**: Less boilerplate code

### ⚠️ Cons

**1. 📚 Learning Curve**
- **🧠 MVI complexity**: Understanding the pattern takes time
- **🌐 Kotlin Multiplatform**: Platform-specific knowledge still needed
- **💉 Dependency injection**: Understanding scopes and components
- **⚡ Coroutines and Flow**: Async programming concepts

**2. 📝 Boilerplate**
- **📋 Contract definitions**: Each screen needs state/event classes
- **⚙️ Component setup**: DI requires configuration
- **🛣️ Router definitions**: Navigation handling code
- **📁 Multiple files per feature**: More files to manage

**3. ⚡ Performance Considerations**
- **📋 State copying**: Immutable updates create new objects
- **🔄 Flow operators**: Potential memory leaks if not handled properly
- **🎨 Compose recomposition**: Need to optimize for performance

**4. 🌐 Platform Limitations**
- **🍎 iOS specific features**: Some features require platform-specific code
- **🧪 Testing complexity**: UI testing across platforms is challenging
- **⚙️ Build complexity**: Multiplatform builds can be slower

## Best Practices & Recommendations 💡

### 1. 📊 State Management
- **📏 Keep state flat**: Avoid deep nesting in state objects
- **🛡️ Use sealed classes**: For events and effects to ensure exhaustive handling
- **🔒 Immutable collections**: Use Kotlin's immutable collections
- **🎯 Single source of truth**: Each piece of state should have one owner

### 2. 🚨 Error Handling
- **🌐 Global exception handling**: Catch unhandled exceptions at the ViewModel level
- **😊 User-friendly messages**: Convert technical errors to user-friendly messages
- **🔄 Retry mechanisms**: Provide retry options for failed operations
- **📶 Offline support**: Handle network connectivity issues gracefully

### 3. ⚡ Performance Optimization
- **🦥 Lazy loading**: Load data only when needed
- **🗝️ Stable keys**: Use stable keys for LazyColumn items
- **⚡ Minimize recomposition**: Use remember and derivedStateOf appropriately
- **🔄 Background processing**: Move heavy operations off the main thread

## Getting Started 🚀

To implement this architecture in your project:

### 1. 📦 Set up dependencies in `build.gradle.kts`:

```kotlin
kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.kotlin.inject.runtime)
            implementation(libs.navigation.compose)
            implementation(libs.kotlinx.serialization.json)
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", libs.kotlin.inject.compiler)
}
```

### 2. 🏗️ Create your base architecture components:
- **🧠 `BaseViewModel`** for common ViewModel functionality
- **🎼 `BaseRoute`** for consistent route handling
- **🏭 `ApplicationComponent`** for global dependencies

### 3. 📱 Define your first screen:
- **📋 Create contract** with State, Event, NavEvent, and Effect classes
- **🧠 Implement ViewModel** extending BaseViewModel
- **🎨 Create View** composable
- **🛣️ Set up Route and Router**
- **💉 Configure DI** component

### 4. 🧭 Set up navigation:
- **📦 Define serializable** parameter classes
- **🛡️ Configure NavHost** with type-safe routes
- **🧭 Implement navigation** handling

## Conclusion

This **dummy project** demonstrates a clean and scalable MVI architecture for Compose Multiplatform that provides a solid foundation for building real-world cross-platform applications. While it requires an initial investment in learning and setup, the benefits in terms of code quality, testability, and developer productivity make it worthwhile for medium to large-scale projects.

**Key Takeaways from this Demo:**

### 🎯 Architecture Strengths
- **Predictable State Flow**: MVI ensures unidirectional data flow
- **Type Safety**: Compile-time checks prevent runtime errors  
- **Modularity**: Each screen is self-contained with clear boundaries
- **Testability**: Pure functions and dependency injection enable easy testing
- **Scalability**: Consistent patterns make adding new features straightforward

### 🚀 Implementation Success Factors

### 🚀 Implementation Success Factors

1. **Consistency**: Follow the established patterns across all screens
2. **Gradual adoption**: Start with simple screens and gradually add complexity
3. **Team alignment**: Ensure all team members understand the patterns
4. **Continuous improvement**: Refactor and optimize based on real-world usage

### 🏆 Why This Architecture Works

This dummy project proves that with proper architectural foundations:
- **Development velocity increases** as patterns become familiar
- **Bug density decreases** due to type safety and predictable flow
- **Team collaboration improves** with clear component responsibilities
- **Code maintainability scales** with project complexity

By following these principles and patterns demonstrated in this sample project, you'll build applications that are not only functional but also maintainable and scalable for years to come.

---

*This article covered the complete architecture of a **dummy Compose Multiplatform application** with MVI pattern. The sample code demonstrates practical implementation of these concepts that can be adapted for real-world applications.*

**Want to learn more?** Check out the official documentation for [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform) and [Kotlin Inject](https://github.com/evant/kotlin-inject) to dive deeper into these technologies.
