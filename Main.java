import crypt.*;

// main
class Main {
    public static void main(String[] args){
        String key = "4"; // key
        String code = "TOG II is so long."; // 暗号化・復号化したい文字列

        System.out.println("code:" + code + " key:" + key);

        String tmp = crypt.Caesar.encrypt(code, key);
        System.out.println(code + " --caesar encrypt--> " + tmp);
        String tmp1 = crypt.Caesar.decrypt(tmp, key);
        System.out.println(tmp + " --caesar decrypt--> " + tmp1);

        String tmp2 = crypt.Scytale.encrypt(code, key);
        System.out.println(code + " --scytale encrypt--> " + tmp2);
        String tmp3 = crypt.Scytale.decrypt(tmp2, key);
        System.out.println(tmp2 + " --scytale decrypt--> " + tmp3);
    }
}