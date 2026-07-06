package com.horita.storage.service;

import com.horita.storage.model.FileMetaData;

public interface StorageService {
    // ファイルを保存するという「看板（ルール）」を定義
    void save(FileMetaData file);
}
