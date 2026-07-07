package com.horita.storage.service;

import com.horita.storage.model.FileMetaData;
import com.horita.storage.util.StorageUtil;

// implements で「StorageServiceのルールに従う」と宣言
public class S3StorageService implements StorageService {
    
    @Override
    public void save(FileMetaData file) {
        // StorageUtil.formatSize を使って、バイトから適切な単位（KBやMB）へ変換
        String formattedSize = StorageUtil.formatSize(file.getFileSize());

        // 最初はローカルと同じく、画面へのログ出力（疑似実装）にする
        System.out.println("[AWS S3] バケットへファイル「" + file.getFileName() + "」をアップロードしました。（模擬）");
        System.out.println("[AWS S3] アップロードサイズ: " + formattedSize);

    }
}
