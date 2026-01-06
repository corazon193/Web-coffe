import 'package:flutter/material.dart';
import 'screens/beranda_screen.dart';
import 'screens/pengajuan_screen.dart';
import 'screens/pesan_screen.dart';
import 'screens/profile_screen.dart';
import 'screens/info_personal_screen.dart';
import 'screens/info_pendidikan.dart';
import 'screens/info_keluarga.dart';
import 'screens/info_payroll.dart';
import 'screens/info_tambahan.dart'; // TAMBAHKAN IMPORT INI

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Dashboard Aplikasi',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.blue,
        scaffoldBackgroundColor: const Color(0xFFE3F2FD),
        primaryColor: const Color(0xFF1E40AF),
        colorScheme: ColorScheme.fromSeed(
          seedColor: const Color(0xFF3B82F6),
          brightness: Brightness.light,
        ),
        textTheme: const TextTheme(
          bodyMedium: TextStyle(color: Color(0xFF1E293B)),
          bodySmall: TextStyle(color: Color(0xFF4B5563)),
        ),
        fontFamily: 'Poppins',
      ),
      home: const MainScreen(),
      routes: {
        '/beranda': (context) => const BerandaScreen(),
        '/pengajuan': (context) => const PengajuanScreen(),
        '/pesan': (context) => const PesanScreen(),
        '/profil': (context) => const ProfilScreen(),
        '/info-personal': (context) => const InfoPersonalScreen(),
        '/info-pendidikan': (context) => const InfoPendidikanScreen(),
        '/info-keluarga': (context) => const InfoKeluargaScreen(),
        '/info-payroll': (context) => const InfoPayrollScreen(),
        '/info-tambahan': (context) =>
            const InfoTambahanScreen(), // TAMBAHKAN ROUTE INI
      },
    );
  }
}

class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  int _currentIndex = 0;

  final List<Widget> _screens = [
    const BerandaScreen(),
    const PengajuanScreen(),
    const PesanScreen(),
    const ProfilScreen(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _currentIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    final screenWidth = MediaQuery.of(context).size.width;
    final isMobile = screenWidth < 600;

    return Scaffold(
      body: IndexedStack(index: _currentIndex, children: _screens),
      bottomNavigationBar: Container(
        decoration: BoxDecoration(
          border: Border(top: BorderSide(color: Colors.grey.withOpacity(0.2))),
          gradient: const LinearGradient(
            colors: [Color(0xFFBFDBFE), Color(0xFF93C5FD)],
          ),
        ),
        child: BottomNavigationBar(
          currentIndex: _currentIndex,
          type: BottomNavigationBarType.fixed,
          backgroundColor: Colors.transparent,
          elevation: 0,
          onTap: _onItemTapped,
          items: [
            BottomNavigationBarItem(
              icon: Icon(
                Icons.home,
                size: isMobile ? 20 : 22,
                color: _currentIndex == 0
                    ? const Color(0xFF1E40AF)
                    : const Color(0xFF4B5563),
              ),
              label: 'BERANDA',
            ),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.send,
                size: isMobile ? 20 : 22,
                color: _currentIndex == 1
                    ? const Color(0xFF1E40AF)
                    : const Color(0xFF4B5563),
              ),
              label: 'PENGAJUAN',
            ),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.chat,
                size: isMobile ? 20 : 22,
                color: _currentIndex == 2
                    ? const Color(0xFF1E40AF)
                    : const Color(0xFF4B5563),
              ),
              label: 'PESAN',
            ),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.person,
                size: isMobile ? 20 : 22,
                color: _currentIndex == 3
                    ? const Color(0xFF1E40AF)
                    : const Color(0xFF4B5563),
              ),
              label: 'PROFIL',
            ),
          ],
          selectedItemColor: const Color(0xFF1E40AF),
          unselectedItemColor: const Color(0xFF4B5563),
          selectedLabelStyle: TextStyle(
            fontWeight: FontWeight.w600,
            color: const Color(0xFF1E40AF),
            fontSize: isMobile ? 11 : 12,
          ),
          unselectedLabelStyle: TextStyle(
            fontWeight: FontWeight.w500,
            color: const Color(0xFF4B5563),
            fontSize: isMobile ? 10 : 11,
          ),
          iconSize: isMobile ? 20 : 24,
        ),
      ),
    );
  }
}
