package crypt;

// スキュタレー暗号
public class Scytale extends Cryptography {
    private static String codeTmp = "None";
    // 暗号化
    public String encrypt(String code, String key){
        codeTmp = code; // 引数を格納
        int key_num = 0; // 一周当たりの文字数
        String output = ""; // 出力用

        try{
            key_num = Integer.parseInt(key); // 引数のString型をint型に変換・格納
        }
        catch (NumberFormatException e){ // String型のフィールドが数字に変換できない時
            System.out.println(key + " is not number.");
            return "error"; // エラー
        }

        int quot = codeTmp.length() / key_num; // 商
        int remain = codeTmp.length() % key_num; // 余り
        if (remain > 0){ // もし余りがあるなら
            quot++;
        }

        char[][] con = new char[key_num][quot];
        for(int i = 0, con_x = 0; i < key_num; i++){
            for(int j = 0; j < quot; j++){
                if(remain > 0 && remain <= i && j == quot - 1){
                    // 何もしない
                }
                else{                    
                    try{
                        con[i][j] = codeTmp.charAt(con_x); // codeを前から順に入れていく
                    }
                    catch(java.lang.StringIndexOutOfBoundsException e){ // con_xの指定がcodeTmp.length()を超えると
                        System.out.println("charAtの範囲外の選択" + con_x);
                        con[i][j] = (char)'*';
                    }
                    con_x++;
                }
            }
        }

        // 出力用文字列を作成
        for(int j = 0; j < quot; j++){
            for(int i = 0; i < key_num; i++){
                output += String.valueOf(con[i][j]);
            }
        }

        return output;
    }

    // 復号化
    public String decrypt(String code, String key){
        codeTmp = code; // 引数を格納
        int key_num = 0; // 一周当たりの文字数
        String output = ""; // 出力用

        try{
            key_num = Integer.parseInt(key); // 引数のString型をint型に変換・格納
        }
        catch (NumberFormatException e){ // String型のフィールドが数字に変換できない時
            System.out.println(key + " is not number.");
            return "error"; // エラー
        }

        char pick_char;
        for(int i = 0; i < key_num; i++){
            for(int j = 0; j * key_num + i < codeTmp.length(); j++){
                pick_char = codeTmp.charAt(j * key_num + i); // codeTmpからj * key_num + i番目の文字を取り出す
                output += pick_char;
            }
        }

        return output;
    }
}
