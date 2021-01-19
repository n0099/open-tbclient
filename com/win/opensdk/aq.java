package com.win.opensdk;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
/* loaded from: classes3.dex */
public final class aq {
    private static final byte[] pZz = {-50, 53, 5, 13, -104, -111, 8, 10};
    private AlgorithmParameterSpec qab;
    private Key qac;

    public aq(String str, String str2) {
        try {
            this.qab = new IvParameterSpec(str2.getBytes("utf-8"));
            this.qac = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Error in getKey(String secretKey), Cause: ".concat(String.valueOf(e)));
        }
    }

    public final String hv(String str, String str2) {
        Cipher cipher;
        char c = 65535;
        switch (str2.hashCode()) {
            case 66500:
                if (str2.equals("CBC")) {
                    c = 0;
                    break;
                }
                break;
            case 66623:
                if (str2.equals("CFB")) {
                    c = 2;
                    break;
                }
                break;
            case 78155:
                if (str2.equals("OFB")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                cipher = Cipher.getInstance("DES/CBC/NoPadding");
                cipher.init(2, this.qac, this.qab);
                break;
            case 1:
                cipher = Cipher.getInstance("DES/OFB/PKCS5Padding");
                cipher.init(2, this.qac, this.qab);
                break;
            case 2:
                cipher = Cipher.getInstance("DES/CFB/PKCS5Padding");
                cipher.init(2, this.qac, this.qab);
                break;
            default:
                cipher = Cipher.getInstance("DES");
                cipher.init(2, this.qac);
                break;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return new String(cipher.doFinal(bArr), "utf-8");
    }
}
