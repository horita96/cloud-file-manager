package com.horita.storage.util;

public class StorageUtil {
    // インスタンス化（new）させないためにコンストラクタを private にする
    private StorageUtil() {}

    // 要件1：ファイルサイズのバリデーションチェック（上限3MB = 3,145,728バイト）
    public static boolean isValidSize(long sizeInBytes) {
        if (sizeInBytes < 0) {
            return false;
        }
        long maxBytes = 3 * 1024 * 1024; // 3MB制限
        return sizeInBytes <= maxBytes;
    }

    public static String formatSize(long sizeInBytes) {
        if (sizeInBytes < 1024) {
            return sizeInBytes + " B";
        } else if (sizeInBytes < 1024 * 1024) {
            double kb = sizeInBytes / 1024.0;
            return String.format("%.2f KB", kb);
        } else {
            double mb = sizeInBytes / (1024.0 * 1024.0);
            return String.format("%.2f MB", mb);
        }
    }


}
