package tv.chushou.basis.b.a.a.a;
/* loaded from: classes5.dex */
public class b {
    private static final a oiG = new a("iT$0xM@v");

    public static String encrypt(String str) {
        return toHex(oiG.encrypt(str.getBytes()));
    }

    public static String decrypt(String str) {
        return new String(oiG.decrypt(toByte(str)));
    }

    private static byte[] toByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    private static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            appendHex(stringBuffer, b);
        }
        return stringBuffer.toString();
    }

    private static void appendHex(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15)).append("0123456789ABCDEF".charAt(b & 15));
    }
}
