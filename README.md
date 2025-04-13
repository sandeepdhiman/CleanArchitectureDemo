This repository demonstrates a Clean Architecture implementation in an Android project using Jetpack Compose, Hilt, and Room Database. The goal is to showcase a modular, scalable, and testable app architecture suitable for production-level applications.
Tech Stack
Jetpack Compose - Declarative UI toolkit for modern Android development

Hilt - Dependency Injection made easy

Room - SQLite object mapping library

Kotlin - Modern programming language for Android

Coroutines & Flow - For asynchronous and reactive programming
 Architecture Overview
This project follows Uncle Bob’s Clean Architecture principles:

Layers:
scss
Copy
Edit
┌────────────────────┐
│      UI (Compose)  │
├────────────────────┤
│   Presentation      │
├────────────────────┤
│   Domain (UseCases) │
├────────────────────┤
│   Data (Repo, DB)   │
├────────────────────┤
│   Framework (Room)  │
└────────────────────┘
Key Principles:
Separation of Concerns

Dependency Rule – Inner layers don’t depend on outer layers

Testability – Business logic is decoupled and testable

Scalability – Easily extend features without tight coupling
