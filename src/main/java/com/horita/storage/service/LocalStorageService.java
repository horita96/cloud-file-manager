package com.horita.storage.service;

import com.horita.storage.model.FileMetaData;
import com.horita.storage.util.StorageUtil;

// implements で 「StorageServiceのルールに従う」と宣言
public class LocalStorageService implements StorageService {
    
    // 看板で決めたルールを具体的に実装（オーバーライド）
    @Override
    public void save(FileMetaData file) {
        // StorageUtil.formatSize を使って、バイトから適切な単位（KBやMB）へ変換
        String formattedSize = StorageUtil.formatSize(file.getFileSize());

        System.out.println("[ローカル] ファイル 「" + file.getFileName() + "」 をPCに保存しました。");
        System.out.println("[ローカル] 保存サイズ： " + formattedSize); // 見やすい表示に変更
    }

}
