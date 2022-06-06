package br.ucsal.bes.iot.leitorsus.leitoresus.util;

public class Teste {

    public static void main(String[] args) {
        EncriptaDecriptaRC4 rc4 = new EncriptaDecriptaRC4("esus1");
        char[] textoCriptografado =
                rc4.criptografa("123456".toCharArray());
        //String text = textoCriptografado.toString();
//        System.out.println("Texto Criptografado:\n" +
//               textoCriptografado.toString());
//        char[] txtcrypt = rc4.criptografa(text.toCharArray());
//        System.out.println("Texto Decriptografado:\n"
//                + new String(rc4.decriptografa(txtcrypt)));


//        EncriptaDecriptaRC4 rc4 = new EncriptaDecriptaRC4("testkey");
//        char[] textoCriptografado =
//                rc4.criptografa("Teste de Mensagem de Texto Puro".toCharArray());
//        System.out.println("Texto Criptografado:\n" +
//                new String(textoCriptografado));
//        System.out.println("Texto Decriptografado:\n"
//                        + new String(rc4.decriptografa(textoCriptografado))

        System.out.println("Salvou no banco "+new String(textoCriptografado));
        char[] txtcrypt = rc4.criptografa(textoCriptografado);
        System.out.println("Buscou do banco "+new String (txtcrypt));
    }
}
