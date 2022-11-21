package crypt;

// 抽象クラス
abstract class Cryptography{
    // 暗号化
    public String encrypt(String code, String key){
        return "None";
    }

    // 復号化
    public String decrypt(String code, String key){
        return "None";
    }
}

