package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

//【仕様：自動販売機】
//  お金を入れる
//  商品を選ぶ
//  商品が出てくる
//  購入するか確認
//  お釣りが出てくる

//【追加仕様】
//  在庫の概念が出てくる
//      追加
//      品切れ

//  商品がジュース以外も取り扱える


  public static void main(String[] args) {

    //飲み物在庫
    Map<String, Integer> drinks = new HashMap<>();
    drinks.put("cola", 10);
    drinks.put("green-tea", 10);
    drinks.put("pepsi", 5);

    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("====================================");
      for (Map.Entry<String, Integer> drink : drinks.entrySet()) {
        System.out.println("%sの在庫は%s本です。".formatted(drink.getKey(), drink.getValue()));
      }
      System.out.println("====================================");
      System.out.println("欲しいドリンクと本数を入力してください。");
      System.out.println("やめる場合は close と入力してください");


      String input_text = scanner.nextLine();
      String[] inputed = input_text.split(" ");

      if (Arrays.stream(inputed).anyMatch(a -> a.equals("close"))) {
        System.out.println("終了します！！");
        scanner.close();
        break;
      }

      try {
        String selectdDrink = inputed[0];
        int selectedDrinkAmount = Integer.parseInt(inputed[1]);
        int money = Integer.parseInt(inputed[2]);

        if (!drinks.containsKey(selectdDrink)) {
          System.out.println("飲み物を入力してください。");
          continue;
        }

        int drinkSettingAmount = drinks.get(selectdDrink).intValue();
        if (selectedDrinkAmount > drinkSettingAmount) {
          System.out.println("飲み物の在庫本数が超えています");
          continue;
        }

        //価格のチェック
//        if()


        System.out.println("%sを %s本 購入しました！".formatted(selectdDrink, selectedDrinkAmount));
        drinks.put(selectdDrink, drinkSettingAmount - selectedDrinkAmount);


      } catch (Exception e) {
        System.out.println("適切な内容を入力してください");
      }

    }

  }
}