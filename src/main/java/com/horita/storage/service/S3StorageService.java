package com.horita.storage.service;

import com.horita.storage.model.FileMetaData;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

// implements で「StorageServiceのルールに従う」と宣言
public class S3StorageService implements StorageService {
    
    // 作成したS3バケット名
    private static final String BUCKET_NAME = "horita-cloud-file-manager-2026";

    @Override
    public void save(FileMetaData file) {
        System.out.println("[AWS S3] クラウドへの接続を開始します．．．");
        
        // S3クライアントの生成（観葉変数から認証情報を自動読み込み）
        try (S3Client s3Client = S3Client.builder()
                .region(Region.AP_NORTHEAST_1)
                .build()) {

            // アップロード用のリクエストを作成
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(file.getFileName())
                    .build();

            // S3へデータを送信（現在は実態ファイルがないためテスト用文字列を書き込み）
            s3Client.putObject(putObjectRequest, RequestBody.fromString("Cloud File Manager Data: " + file.getFileName()));
            System.out.println("[AWS S3] バケット「" + BUCKET_NAME + "」へ「" + file.getFileName() + "」を正常にアップロードしました！");
        } catch (Exception e) {
            System.out.println("[エラー] S3への送信に失敗しました: " + e.getMessage());
        }

    }
}
