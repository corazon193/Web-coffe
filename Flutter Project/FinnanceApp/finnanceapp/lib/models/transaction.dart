import 'package:flutter/widgets.dart';

class TransactionModel {
  final String title;
  final String amount;
  final String category;
  final String type;
  final IconData icon;

  TransactionModel({
    required this.title,
    required this.amount,
    required this.category,
    required this.type,
    required this.icon,
  });
}
