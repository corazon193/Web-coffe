import 'package:flutter/material.dart';

class BerandaScreen extends StatelessWidget {
  const BerandaScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final screenWidth = MediaQuery.of(context).size.width;
    final isMobile = screenWidth < 600;

    return SingleChildScrollView(
      child: Column(
        children: [
          Container(
            padding: EdgeInsets.fromLTRB(
              isMobile ? 16 : 24,
              isMobile ? 30 : 40,
              isMobile ? 16 : 24,
              isMobile ? 16 : 24,
            ),
            child: Row(
              children: [
                Container(
                  width: isMobile ? 40 : 44,
                  height: isMobile ? 40 : 44,
                  decoration: BoxDecoration(
                    shape: BoxShape.circle,
                    gradient: const LinearGradient(
                      colors: [Color(0xFF3B82F6), Color(0xFF60A5FA)],
                    ),
                    boxShadow: [
                      BoxShadow(
                        color: const Color(0xFF3B82F6).withAlpha(30),
                        spreadRadius: 2,
                        blurRadius: 6,
                        offset: const Offset(0, 2),
                      ),
                    ],
                  ),
                  child: Icon(
                    Icons.person,
                    color: Colors.white,
                    size: isMobile ? 20 : 22,
                  ),
                ),
                SizedBox(width: isMobile ? 12 : 16),
                Expanded(
                  child: Text(
                    'Selamat Pagi,\nLeonardo Dicaprio',
                    style: TextStyle(
                      fontSize: isMobile ? 20 : 24,
                      fontWeight: FontWeight.w700,
                      height: 1.4,
                      color: const Color(0xFF1E293B),
                      shadows: [
                        Shadow(
                          color: Colors.black.withOpacity(0.05),
                          offset: const Offset(0, 1),
                          blurRadius: 2,
                        ),
                      ],
                    ),
                  ),
                ),
                Container(
                  width: isMobile ? 40 : 44,
                  height: isMobile ? 40 : 44,
                  decoration: BoxDecoration(
                    shape: BoxShape.circle,
                    gradient: const LinearGradient(
                      colors: [Color(0xFF8B5CF6), Color(0xFFA78BFA)],
                    ),
                    boxShadow: [
                      BoxShadow(
                        color: const Color(0xFF8B5CF6).withAlpha(30),
                        spreadRadius: 2,
                        blurRadius: 6,
                        offset: const Offset(0, 2),
                      ),
                    ],
                  ),
                  child: Icon(
                    Icons.notifications,
                    color: Colors.white,
                    size: isMobile ? 20 : 22,
                  ),
                ),
              ],
            ),
          ),

          Padding(
            padding: EdgeInsets.symmetric(horizontal: isMobile ? 16 : 24),
            child: Row(
              children: [
                Expanded(
                  child: Container(
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(isMobile ? 16 : 20),
                      gradient: const LinearGradient(
                        colors: [Color(0xFF93C5FD), Color(0xFF60A5FA)],
                      ),
                      boxShadow: [
                        BoxShadow(
                          color: Colors.blue.withOpacity(0.15),
                          spreadRadius: 3,
                          blurRadius: 10,
                          offset: const Offset(0, 4),
                        ),
                      ],
                    ),
                    child: Padding(
                      padding: EdgeInsets.all(isMobile ? 14 : 18),
                      child: Column(
                        children: [
                          Container(
                            padding: EdgeInsets.all(isMobile ? 8 : 10),
                            decoration: BoxDecoration(
                              shape: BoxShape.circle,
                              color: Colors.white,
                              boxShadow: [
                                BoxShadow(
                                  color: Colors.blue.withOpacity(0.2),
                                  spreadRadius: 2,
                                  blurRadius: 6,
                                ),
                              ],
                            ),
                            child: Icon(
                              Icons.calendar_today,
                              color: Color(0xFF1E40AF),
                              size: isMobile ? 20 : 24,
                            ),
                          ),
                          SizedBox(height: isMobile ? 10 : 14),
                          Text(
                            '0',
                            style: TextStyle(
                              fontSize: isMobile ? 20 : 22,
                              fontWeight: FontWeight.bold,
                              color: const Color(0xFF1E293B),
                            ),
                          ),
                          Text(
                            'Hari Libur',
                            style: TextStyle(
                              color: const Color(0xFF1E293B),
                              fontWeight: FontWeight.w600,
                              fontSize: isMobile ? 13 : 14,
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
                ),
                SizedBox(width: isMobile ? 12 : 16),
                Expanded(
                  child: Container(
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(isMobile ? 16 : 20),
                      gradient: const LinearGradient(
                        colors: [Color(0xFFBFDBFE), Color(0xFF93C5FD)],
                      ),
                      boxShadow: [
                        BoxShadow(
                          color: Colors.blue.withOpacity(0.15),
                          spreadRadius: 3,
                          blurRadius: 10,
                          offset: const Offset(0, 4),
                        ),
                      ],
                    ),
                    child: Padding(
                      padding: EdgeInsets.all(isMobile ? 14 : 18),
                      child: Column(
                        children: [
                          Container(
                            padding: EdgeInsets.all(isMobile ? 8 : 10),
                            decoration: BoxDecoration(
                              shape: BoxShape.circle,
                              color: Colors.white,
                              boxShadow: [
                                BoxShadow(
                                  color: Colors.blue.withOpacity(0.2),
                                  spreadRadius: 2,
                                  blurRadius: 6,
                                ),
                              ],
                            ),
                            child: Icon(
                              Icons.work,
                              color: Color(0xFF1E40AF),
                              size: isMobile ? 20 : 24,
                            ),
                          ),
                          SizedBox(height: isMobile ? 10 : 14),
                          Text(
                            '0',
                            style: TextStyle(
                              fontSize: isMobile ? 20 : 22,
                              fontWeight: FontWeight.bold,
                              color: const Color(0xFF1E293B),
                            ),
                          ),
                          Text(
                            'Hari Kerja',
                            style: TextStyle(
                              color: const Color(0xFF1E293B),
                              fontWeight: FontWeight.w600,
                              fontSize: isMobile ? 13 : 14,
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),

          SizedBox(height: isMobile ? 20 : 28),

          GridView.count(
            crossAxisCount: isMobile ? 3 : 4,
            shrinkWrap: true,
            physics: const NeverScrollableScrollPhysics(),
            padding: EdgeInsets.symmetric(horizontal: isMobile ? 16 : 24),
            childAspectRatio: isMobile ? 1.0 : 0.9,
            children: [
              _buildMenuCard(
                Icons.calendar_today,
                'KALENDER',
                const Color(0xFF3B82F6),
                isMobile,
              ),
              _buildMenuCard(
                Icons.attach_money,
                'SLIP GAJI',
                const Color(0xFF10B981),
                isMobile,
              ),
              _buildMenuCard(
                Icons.list_alt,
                'DAFTAR ABSEN',
                const Color(0xFF8B5CF6),
                isMobile,
              ),
              _buildMenuCard(
                Icons.access_time,
                'LEMBUR',
                const Color(0xFFF59E0B),
                isMobile,
              ),
              _buildMenuCard(
                Icons.receipt_long,
                'REIMBURSEMENT',
                const Color(0xFFEC4899),
                isMobile,
              ),
              _buildMenuCard(
                Icons.face,
                'ABSEN',
                const Color(0xFF0EA5E9),
                isMobile,
              ),
            ],
          ),

          SizedBox(height: isMobile ? 20 : 28),

          _buildSection(
            'Pengumuman',
            'Lihat semua',
            Icons.notifications_active,
            const Color(0xFF3B82F6),
            'Belum ada pengumuman\nPengumuman akan tampil disini',
            isMobile,
          ),

          _buildSection(
            'Tugas',
            'Lihat semua',
            Icons.task_alt,
            const Color(0xFF10B981),
            'Tidak ada tugas\nAnda tidak memiliki tugas yang tersedia',
            isMobile,
          ),

          SizedBox(height: isMobile ? 60 : 80),
        ],
      ),
    );
  }

  Widget _buildMenuCard(
    IconData icon,
    String title,
    Color color,
    bool isMobile,
  ) {
    return Container(
      margin: EdgeInsets.all(isMobile ? 6 : 8),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(isMobile ? 16 : 20),
        color: Colors.white,
        boxShadow: [
          BoxShadow(
            color: Colors.blue.withOpacity(0.1),
            spreadRadius: 1,
            blurRadius: 4,
            offset: const Offset(0, 2),
          ),
        ],
      ),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Container(
            width: isMobile ? 45 : 50,
            height: isMobile ? 45 : 50,
            decoration: BoxDecoration(
              shape: BoxShape.circle,
              gradient: LinearGradient(
                colors: [color.withOpacity(0.95), color.withOpacity(0.85)],
              ),
              boxShadow: [
                BoxShadow(
                  color: color.withOpacity(0.3),
                  spreadRadius: 1,
                  blurRadius: 6,
                  offset: const Offset(0, 3),
                ),
                BoxShadow(
                  color: Colors.white.withOpacity(0.5),
                  spreadRadius: 1,
                  blurRadius: 2,
                  offset: const Offset(0, -1),
                ),
              ],
            ),
            child: Icon(icon, color: Colors.white, size: isMobile ? 20 : 24),
          ),
          SizedBox(height: isMobile ? 8 : 10),
          Text(
            title,
            style: const TextStyle(
              fontWeight: FontWeight.w600,
              fontSize: 11,
              color: Color(0xFF1E293B),
            ),
            textAlign: TextAlign.center,
            maxLines: isMobile ? 1 : 2,
            overflow: TextOverflow.ellipsis,
          ),
        ],
      ),
    );
  }

  Widget _buildSection(
    String title,
    String action,
    IconData icon,
    Color color,
    String content,
    bool isMobile,
  ) {
    return Padding(
      padding: EdgeInsets.symmetric(
        horizontal: isMobile ? 16 : 24,
        vertical: isMobile ? 6 : 8,
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            children: [
              Container(
                padding: EdgeInsets.all(isMobile ? 6 : 8),
                decoration: BoxDecoration(
                  color: color.withOpacity(0.15),
                  shape: BoxShape.circle,
                ),
                child: Icon(icon, color: color, size: isMobile ? 18 : 20),
              ),
              SizedBox(width: isMobile ? 8 : 12),
              Text(
                title,
                style: const TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.w700,
                  color: Color(0xFF1E293B),
                ),
              ),
              const Spacer(),
              Text(
                action,
                style: TextStyle(
                  color: const Color(0xFF1E40AF),
                  fontWeight: FontWeight.w600,
                  fontSize: isMobile ? 12 : 14,
                ),
              ),
            ],
          ),
          SizedBox(height: isMobile ? 12 : 16),
          Container(
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(isMobile ? 14 : 16),
              color: Colors.white,
              boxShadow: [
                BoxShadow(
                  color: Colors.blue.withOpacity(0.1),
                  spreadRadius: 1,
                  blurRadius: 4,
                  offset: const Offset(0, 2),
                ),
              ],
            ),
            child: Padding(
              padding: EdgeInsets.all(isMobile ? 16 : 20),
              child: Column(
                children: [
                  Icon(icon, color: color, size: isMobile ? 28 : 32),
                  SizedBox(height: isMobile ? 10 : 12),
                  Text(
                    content,
                    style: const TextStyle(
                      color: Color(0xFF4B5563),
                      fontSize: 15,
                      height: 1.5,
                    ),
                    textAlign: TextAlign.center,
                  ),
                ],
              ),
            ),
          ),
          SizedBox(height: isMobile ? 12 : 16),
        ],
      ),
    );
  }
}