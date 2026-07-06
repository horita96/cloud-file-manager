package com.horita.storage.model;

public class FileMetaData {
    // 外部から書き換えられないよう private でカプセル化
    private String fileName;
    private long fileSize;

    // コンストラクタ（初期化の強制）
    public FileMetaData(String fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    // 安全に値を取り出すためのgetter
    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

}
