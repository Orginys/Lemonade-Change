public class Solution {  // Переименовали класс в Solution

    public boolean lemonadeChange(int[] bills) {
        int five = 0;  // Переменная для хранения количества купюр по $5
        int ten = 0;   // Переменная для хранения количества купюр по $10

        for (int bill : bills) {  // Проходим по каждому элементу массива bills
            if (bill == 5) {  // Если клиент платит $5
                five++;  // Увеличиваем количество $5 купюр
            } else if (bill == 10) {  // Если клиент платит $10
                if (five > 0) {  // Проверяем, можем ли мы дать сдачу $5
                    five--;  // Даем сдачу, уменьшая количество $5 купюр
                    ten++;  // Увеличиваем количество $10 купюр
                } else {
                    return false;  // Если нет купюр по $5, возвращаем false
                }
            } else {  // Если клиент платит $20
                if (ten > 0 && five > 0) {  // Если есть купюра по $10 и $5
                    ten--;  // Даем сдачу $10
                    five--;  // Даем сдачу $5
                } else if (five >= 3) {  // Если нет $10, но есть три купюры по $5
                    five -= 3;  // Даем сдачу тремя $5
                } else {
                    return false;  // Если не можем дать сдачу, возвращаем false
                }
            }
        }

        return true;  // Если смогли обслужить всех клиентов, возвращаем true
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] bills1 = {5, 5, 5, 10, 20};
        System.out.println(solution.lemonadeChange(bills1)); // Вывод: true

        int[] bills2 = {5, 5, 10, 10, 20};
        System.out.println(solution.lemonadeChange(bills2)); // Вывод: false
    }
}