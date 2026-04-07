# My Profile App (MVVM)
Tugas Praktikum Pertemuan 4 — State & MVVM in Compose Multiplatform  
IF25-22017 Pengembangan Aplikasi Mobile  
Program Studi Teknik Informatika · Institut Teknologi Sumatera

## Deskripsi
My Profile App adalah aplikasi multiplatform yang dikembangkan menggunakan Kotlin dan Compose Multiplatform dengan menerapkan arsitektur MVVM (Model-View-ViewModel). Aplikasi ini memungkinkan pengguna untuk melihat dan mengedit profil, serta mendukung fitur Dark Mode untuk meningkatkan pengalaman pengguna.

## Screenshot

| Profile | Edit Profile | Dark Mode |
|--------|--------------|-----------|
| <img src="https://github.com/user-attachments/assets/45eb9993-e14b-48c4-bb52-aaefdac56a7d" width="250"/> | <img src="https://github.com/user-attachments/assets/4a35d9c6-eea6-4fdd-9a6a-2e5db723aa7b" width="250"/> | <img src="https://github.com/user-attachments/assets/22937e3a-d5b1-458f-b4ff-54ad55114add" width="250"/> |

## Fitur
- **MVVM Architecture:** Menggunakan ViewModel dan StateFlow untuk memisahkan UI dan logic.
- **Reactive UI:** Tampilan otomatis berubah sesuai state menggunakan `collectAsState()`.
- **Edit Profile:** Pengguna dapat mengubah nama dan bio secara langsung.
- **State Hoisting:** State dikelola di parent composable dan dikirim ke child.
- **Dark Mode Toggle:** Menggunakan Switch untuk mengubah tema terang dan gelap.
- **Modern UI:** Menggunakan Material 3 dengan desain bersih dan responsif.
- **Reusable Component:** Komponen seperti TextField dan InfoItem dapat digunakan ulang.

## Struktur Composable Functions
| File | Deskripsi |
| :--- | :--- |
| **App.kt** | Entry point aplikasi dan menghubungkan UI dengan ViewModel. |
| **ProfileScreen.kt** | Menampilkan UI utama, meng-handle state dari ViewModel, dan menampilkan form edit. |
| **ProfileHeader.kt** | Menampilkan nama dan bio pengguna. |
| **ProfileCard.kt** | Container untuk informasi profil. |
| **InfoItem.kt** | Menampilkan item informasi seperti email, phone, dan location. |
| **Profile.kt** | Data class untuk model data profil. |
| **ProfileViewModel.kt** | Mengelola state aplikasi menggunakan StateFlow. |
| **ProfileUiState.kt** | Representasi state UI (nama, bio, dark mode). |
| **Platform.kt** | Konfigurasi multiplatform bawaan. |

## Komponen UI yang Digunakan
| Komponen | Digunakan di |
| :--- | :--- |
| **Column** | Menyusun layout secara vertikal. |
| **Row** | Menyusun item seperti InfoItem secara horizontal. |
| **Card** | Menampilkan bio dan informasi dalam bentuk kartu. |
| **Text** | Menampilkan data teks seperti nama dan bio. |
| **TextField** | Input untuk edit nama dan bio. |
| **Button** | Menyimpan perubahan profil. |
| **Switch** | Toggle untuk Dark Mode. |
| **Icon** | Ikon email, phone, dan location. |

## Teknologi
- **Kotlin** — bahasa pemrograman utama.
- **Compose Multiplatform** — framework UI deklaratif.
- **Material 3** — desain UI modern.
- **StateFlow** — pengelolaan state secara reaktif.
- **ViewModel** — pemisahan logic dan UI.

## Cara Menjalankan
### Android
1. Buka proyek di **Android Studio**.
2. Hubungkan perangkat atau jalankan emulator.
3. Pilih konfigurasi **`androidApp`**.
4. Klik tombol **Run (▶️)**.

### Desktop (JVM)
Jalankan perintah berikut:
```bash
./gradlew :composeApp:run
```

## Struktur File Utama
```text
composeApp/
└── src/
    └── commonMain/
        └── kotlin/
            └── com/example/myprofileapp/
                ├── data/
                │   └── Profile.kt
                ├── viewmodel/
                │   ├── ProfileViewModel.kt
                │   └── ProfileUiState.kt
                ├── ui/
                │   ├── ProfileScreen.kt
                │   ├── ProfileCard.kt
                │   ├── ProfileHeader.kt
                │   └── InfoItem.kt
                ├── App.kt
                └── Platform.kt
```

## Penulis
- **Nama**: Muhamad Arif Ardani
- **NIM**: 123140186
- **Kelas**: Pengembangan Aplikasi Mobile RB
- **Institusi**: Institut Teknologi Sumatera


