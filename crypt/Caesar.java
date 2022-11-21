package crypt;

// シーザー暗号(大文字と小文字をそれぞれ区別した英語のみ暗号化する．それ以外の文字は特に操作しない)
public class Caesar extends Cryptography{
    private static String codeTmp = "None"; // 暗号化用String型フィールド
    // 暗号化
    public String encrypt(String code, String key){
        codeTmp = code; // 引数を格納
        int key_num = 0; // シフトする数
        String output = ""; // 出力用

        try{
            key_num = Integer.parseInt(key); // 引数のString型をint型に変換・格納
        }
        catch (NumberFormatException e){ // String型のフィールドが数字に変換できない時
            System.out.println(key + " is not number.");
            return "error"; // エラー
        }
        for(;key_num > 'z' - 'a';){ // シフトさせる数字が大きすぎる場合，結果が同じとなる小さな数字に変換する
            key_num -= 'z' - 'a';
        }

        char replace_char; // codeTmpのi番目の文字をchar型として格納
        for(int i = 0; i < codeTmp.length(); i++){
            replace_char = codeTmp.charAt(i); // i番目のcodeTmpの文字をchar型にする

            if(replace_char >= 'a' && replace_char <= 'z'){ // replace_charが小文字の英字なら
                replace_char += key_num; // key分シフトさせる
                if(replace_char > 'z'){ // zから英字がはみ出ると
                    replace_char = (char)('a' - 1 + replace_char - 'z'); // zの次をaとする
                }
            }
            else if(replace_char >= 'A' && replace_char <= 'Z'){ // replace_charが大文字の英字なら
                replace_char += key_num; // key分シフトさせる
                if(replace_char > 'Z'){ // zから英字がはみ出ると
                    replace_char = (char)('A' - 1 + replace_char - 'Z'); // zの次をaとする
                }
            }

            //System.out.println(replace_char);
            output += String.valueOf(replace_char);
        }

        return output;
    }

    // 復号化
    public String decrypt(String code, String key){
        codeTmp = code; // 引数を格納
        int key_num = 0; // シフトする数
        String output = ""; // 出力用

        try{
            key_num = Integer.parseInt(key); // 引数のString型をint型に変換・格納
        }
        catch (NumberFormatException e){ // String型のフィールドが数字に変換できない時
            System.out.println(key + " is not number.");
            return "error"; // エラー
        }
        for(;key_num > 'z' - 'a';){ // シフトさせる数字が大きすぎる場合，結果が同じとなる小さな数字に変換する
            key_num -= 'z' - 'a';
        }

        char replace_char; // codeTmpのi番目の文字をchar型として格納
        for(int i = 0; i < codeTmp.length(); i++){
            replace_char = codeTmp.charAt(i); // i番目のcodeTmpの文字をchar型にする

            if(replace_char >= 'a' && replace_char <= 'z'){ // replace_charが小文字の英字なら
                replace_char -= key_num; // key分逆シフトさせる
                if(replace_char < 'a'){ // aから英字がはみ出ると
                    replace_char = (char)(replace_char - 'a' + 'z' + 1); // aの前をzとする
                }
            }
            else if(replace_char >= 'A' && replace_char <= 'Z'){ // replace_charが大文字の英字なら
                replace_char -= key_num; // key分逆シフトさせる
                if(replace_char < 'A'){ // aから英字がはみ出ると
                    replace_char = (char)(replace_char - 'A' + 'Z' + 1); // aの前をzとする
                }
            }

            //System.out.println(replace_char);
            output += String.valueOf(replace_char);
        }
        return output;
    }
}
