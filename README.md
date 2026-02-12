# Group Assignment 2: Declarative UI with Jetpack Compose

## Overview
A simple interactive dashboard featuring a counter that demonstrates state hoisting and automatic recomposition in Jetpack Compose.

## Q&A

### 1. What makes Compose declarative?
Instead of manually manipulating views (like calling `setText()`), we describe **what** the UI should look like for a given state. When the state changes, Compose automatically redraws the UI to match that description.

### 2. Where is state stored?
The state is stored in the `DashboardScreen` composable using `remember { mutableIntStateOf(0) }`. This preserves the count value across recompositions.

### 3. Stateful vs. Stateless Composables
* **Stateful:** `DashboardScreen` – It owns and manages the `count` state.
* **Stateless:** `CounterControl` – It receives data via parameters and triggers events via lambda callbacks, holding no internal state.

### 4. Difference from XML + View Logic
* **XML (Imperative):** Requires `findViewById` and manual updates (e.g., `view.setText()`) whenever data changes, which risks synchronization bugs.
* **Compose (Declarative):** The UI is a direct function of the state. The framework handles updates automatically, ensuring the UI always reflects the current data.