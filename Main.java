import crypt.*;

// main
class Main {
    public static void main(String[] args){
        String key = "4"; // key
        String code = "TOG II is so long."; // 暗号化・復号化したい文字列

        System.out.println("code:" + code + " key:" + key);

        
        Caesar caesar = new Caesar();
        String tmp = caesar.encrypt(code, key);
        System.out.println(code + " --caesar encrypt--> " + tmp);
        String tmp1 = caesar.decrypt(tmp, key);
        System.out.println(tmp + " --caesar decrypt--> " + tmp1);

        Scytale scytale = new Scytale();
        String tmp2 = scytale.encrypt(code, key);
        System.out.println(code + " --scytale encrypt--> " + tmp2);
        String tmp3 = scytale.decrypt(tmp2, key);
        System.out.println(tmp2 + " --scytale decrypt--> " + tmp3);
    }
}