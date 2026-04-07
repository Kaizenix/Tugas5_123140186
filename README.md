# Notes App with Navigation (MVVM)

Tugas Praktikum Pertemuan 5 — Navigation in Compose Multiplatform  
IF25-22017 Pengembangan Aplikasi Mobile  
Program Studi Teknik Informatika · Institut Teknologi Sumatera

## Deskripsi
Notes App adalah pengembangan dari aplikasi Profile UI sebelumnya. Aplikasi ini kini dilengkapi dengan fitur manajemen catatan (Notes) yang mencakup navigasi antar layar, penanganan argumen (`noteId`), dan Bottom Navigation yang modern. Aplikasi tetap mempertahankan identitas visual dari Profile App sebelumnya dengan tema hijau olive yang khas.

## Fitur Utama
- **Bottom Navigation:** 3 tab utama (Notes, Favorites, Profile) dengan gaya floating capsule yang modern.
- **CRUD Notes:** Menambah, melihat detail, mengedit, dan menghapus catatan.
- **Favorites System:** Menandai catatan sebagai favorit dan melihatnya di tab terpisah.
- **Navigation with Arguments:** Berpindah antar layar dengan mengirimkan data `noteId`.
- **Integrated Profile:** Fitur profil dari aplikasi sebelumnya diintegrasikan sebagai salah satu tab utama.
- **Dark & Light Mode:** Dukungan penuh untuk tema terang dan gelap yang konsisten.
- **Smooth Animations:** Transisi antar layar dan interaksi UI yang halus.

## Screenshot

| Notes Screen | Note Detail | Favorite Notes | Add Note | Edit and Delete Note |
|--------|--------------|-----------|-----------|-----------|
| <img src="https://github.com/user-attachments/assets/7f9f79a6-cf65-4e0d-b4d6-80d2d998d166" width="250"/> | <img src="https://github.com/user-attachments/assets/31437c2e-f8c1-4f20-897b-8683f180621e" width="250"/> | <img src="https://github.com/user-attachments/assets/cbfbc30f-08dd-40c6-972f-5bc656b0e462" width="250"/> | <img src="https://github.com/user-attachments/assets/c72f4acb-2920-46ae-a1fb-7fddb4f833b8" width="250"/> | <img src="https://github.com/user-attachments/assets/cc9793fe-2415-4e9a-bc4d-47146e784890"  width="250"/> |

## Struktur Navigasi
Aplikasi menggunakan **Navigation Compose** dengan rute sebagai berikut:
- `notes`: Menampilkan daftar semua catatan.
- `favorites`: Menampilkan catatan yang ditandai sebagai favorit.
- `profile`: Menampilkan informasi profil pengguna (Legacy UI).
- `add`: Form untuk menambahkan catatan baru.
- `detail/{noteId}`: Menampilkan isi lengkap catatan berdasarkan ID.
- `edit/{noteId}`: Form untuk mengubah isi catatan yang sudah ada.

## Teknologi
- **Kotlin** — Bahasa pemrograman utama.
- **Compose Multiplatform** — Framework UI deklaratif.
- **Jetpack Navigation** — Pengelolaan navigasi dan backstack.
- **Material 3** — Komponen desain modern.
- **ViewModel & StateFlow** — Arsitektur state management yang reaktif.

## Cara Menjalankan
### Android
1. Buka proyek di **Android Studio**.
2. Pilih perangkat emulator atau fisik.
3. Jalankan konfigurasi **`composeApp`**.
4. Klik **Run (▶️)**.

### Desktop (JVM)
```bash
./gradlew :composeApp:run
```

## Struktur Proyek
```text
composeApp/
└── src/
    └── commonMain/
        └── kotlin/
            └── com/example/myprofileapp/
                ├── data/           # Data Model (Note)
                ├── navigation/     # NavGraph & Routes
                ├── ui/
                │   ├── components/ # Reusable UI (NavBar, Cards)
                │   ├── screens/    # All Screen UI
                │   └── theme/      # Colors & Typography
                ├── viewmodel/      # Notes & Profile ViewModels
                └── App.kt          # Entry Point
```

## Penulis
- **Nama**: Muhamad Arif Ardani
- **NIM**: 123140186
- **Kelas**: Pengembangan Aplikasi Mobile RB
- **Institusi**: Institut Teknologi Sumatera
