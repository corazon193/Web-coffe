import 'package:flutter/material.dart';
import '../widgets/atm_cart.dart';
import '../widgets/transaction_item.dart';
import '../models/transaction.dart';
import '../widgets/grid_menu_item.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final transactions = [
      TransactionModel(
        title: 'Coffee Shop',
        amount: '-Rp25.000',
        category: 'Food',
        type: 'expense',
        icon: Icons.local_cafe,
      ),
      TransactionModel(
        title: 'Grab Ride',
        amount: '-Rp55.000',
        category: 'Travel',
        type: 'expense',
        icon: Icons.directions_car,
      ),
      TransactionModel(
        title: 'Gym Membership',
        amount: '-Rp350.000',
        category: 'Health',
        type: 'expense',
        icon: Icons.fitness_center,
      ),
      TransactionModel(
        title: 'Movie Ticket',
        amount: '-Rp50.000',
        category: 'Event',
        type: 'expense',
        icon: Icons.movie,
      ),
      TransactionModel(
        title: 'Salary',
        amount: '+Rp7.500.000',
        category: 'Income',
        type: 'income',
        icon: Icons.attach_money,
      ),
    ];

    return Scaffold(
      appBar: AppBar(
        title: const Text('Selamat Datang'),
        centerTitle: true,
        backgroundColor: const Color.fromARGB(255, 161, 118, 152),
        foregroundColor: Colors.white,
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // ===== Title =====
            const Text(
              'My Cards',
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 12),

            // ===== Banner Cards =====
            SizedBox(
              height: 200,
              child: ListView(
                scrollDirection: Axis.horizontal,
                children: const [
                  AtmCard(
                    bankName: 'Bank A',
                    cardNumber: '**** 2345',
                    balance: 'Rp17.000.000',
                    color1: Color.fromARGB(255, 119, 103, 147),
                    color2: Color.fromARGB(255, 170, 168, 166),
                  ),
                  AtmCard(
                    bankName: 'Bank B',
                    cardNumber: '**** 8765',
                    balance: 'Rp7.500.000',
                    color1: Color.fromARGB(255, 119, 103, 147),
                    color2: Color.fromARGB(255, 170, 168, 166),
                  ),
                ],
              ),
            ),

            const SizedBox(height: 24),

            // ===== Grid Menu =====
            GridView.count(
              crossAxisCount: 4,
              shrinkWrap: true,
              crossAxisSpacing: 10,
              mainAxisSpacing: 10,
              physics: const NeverScrollableScrollPhysics(),
              children: const [
                GridMenuItem(icon: Icons.health_and_safety, label: 'Health'),
                GridMenuItem(icon: Icons.travel_explore, label: 'Travel'),
                GridMenuItem(icon: Icons.fastfood, label: 'Food'),
                GridMenuItem(icon: Icons.event, label: 'Event'),
              ],
            ),

            const SizedBox(height: 16),

            // ===== Transaction List =====
            const Text(
              'Recent Transactions',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 3),

            ListView.builder(
              shrinkWrap: true,
              physics: const NeverScrollableScrollPhysics(),
              itemCount: transactions.length,
              itemBuilder: (context, index) {
                return TransactionItem(transaction: transactions[index]);
              },
            ),
          ],
        ),
      ),
    );
  }
}

// ---- Grid Menu Item Widget ----
// ignore: unused_element
class _MenuItem extends StatelessWidget {
  final IconData icon;
  final String label;

  const _MenuItem({required this.icon, required this.label});

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      children: [
        CircleAvatar(
          radius: 24,
          backgroundColor: Colors.deepOrange.withOpacity(0.1),
          child: Icon(icon, color: Colors.deepPurple),
        ),
        const SizedBox(height: 6),
        Text(label, style: const TextStyle(fontSize: 12)),
      ],
    );
  }
}
