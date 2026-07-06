package com.horita.storage.service;

import com.horita.storage.model.FileMetaData;

// implements で 「StorageServiceのルールに従う」と宣言
public class LocalStorageService implements StorageService {
    
    // 看板で決めたルールを具体的に実装（オーバーライド）
    @Override
    public void save(FileMetaData file) {
        System.out.println("[ローカル] ファイル 「" + file.getFileName() + "」 をPCに保存しました。");
        System.out.println("[ローカル] 保存サイズ： " + file.getFileSize() + " バイト");
    }

}
