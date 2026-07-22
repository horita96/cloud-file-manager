package com.horita.storage;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.horita.storage.model.FileMetaData;
import com.horita.storage.service.LocalStorageService;
// import com.horita.storage.service.S3StorageService;
import com.horita.storage.service.StorageService;
import com.horita.storage.util.StorageUtil;

public class Main {
    public static void main(String[] args) {
        // try-with-resources: 抜けた時に自動で close される
        try (Scanner scanner = new Scanner(System.in)) {
            StorageService storageService = new LocalStorageService();

            System.out.println("--- クラウドファイルマネージャー起動 ---");

            System.out.println("ファイル名を入力してください：");
            String name = scanner.nextLine();

            System.out.println("ファイルサイズを入力してください（バイト）：");
            long size = scanner.nextLong();

            // staticメソッドの呼び出し：3MBチェックのバリデーション
            if (!StorageUtil.isValidSize(size)) {
                System.out.println("【エラー】3MB（3,145,728バイト）を越えるファイルは保存できません。");
                return; // 異常値なのでここでプログラムを安全に終了させる
            }

            FileMetaData file = new FileMetaData(name, size);
            storageService.save(file);

        } catch (InputMismatchException e) {
            System.out.println("【エラー】ファイルサイズには半角数字を入力してください。");
        }
        // try-with-resources のおかげで finally ブロックが不要になる
    }
}
