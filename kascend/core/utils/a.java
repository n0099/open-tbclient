package kascend.core.utils;

import com.baidu.android.common.security.RSAUtil;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes9.dex */
public final class a {
    public static byte[] decryptByPrivateKey(byte[] bArr, String str) throws Exception {
        byte[] doFinal;
        PrivateKey generatePrivate = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(b.decode(str)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, generatePrivate);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            if (length - i2 > 128) {
                doFinal = cipher.doFinal(bArr, i2, 128);
            } else {
                doFinal = cipher.doFinal(bArr, i2, length - i2);
            }
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            int i3 = i + 1;
            i2 = i3 * 128;
            i = i3;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }
}
