package com.horita.storage.service;

import com.horita.storage.model.FileMetaData;
import com.horita.storage.util.StorageUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// implements で 「StorageServiceのルールに従う」と宣言
public class LocalStorageService implements StorageService {

    private static final String STORAGE_DIR = "./local_storage";
    
    @Override
    public void save(FileMetaData file) {
        System.out.println("[ローカル] 保存処理を開始します．．．");

        try {
            Path dirPath = Paths.get(STORAGE_DIR);
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            Path filePath = dirPath.resolve(file.getFileName());

            // StorageUtil を使ってバイト数を整形（KB、MB表示へ）
            String formatttedSize = StorageUtil.formatSize(file.getFileSize());
            String content = "Local Storage Data: " + file.getFileName() + "（Size; " + formatttedSize + "）";

            Files.writeString(filePath, content);

            System.out.println("[ローカル] フォルダ[" + STORAGE_DIR + "」へ「" + file.getFileName() + "」を正常に保存しました！" );
            System.out.println("[ローカル] 保存サイズ: " + formatttedSize);

        } catch (IOException e) {
            System.out.println("[エラー] ローカルへの保存に失敗しました: " + e.getMessage());
        }
    }

}
