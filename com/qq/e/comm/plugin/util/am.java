package com.qq.e.comm.plugin.util;

import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.qq.e.comm.util.GDTLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes4.dex */
public class am {
    public static String a(String str) {
        byte[] bArr = new byte[0];
        try {
            bArr = a(str.getBytes(), "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw41hNBphwAvvOJ5Ruzq1\rEYxmKXMh2cRtxu9RsZKcELezpJhjYB1IfqhE9rBJFL2gxk7cb9GrzuaeukXAL5uA\r3tYEbZ8q3oRE2faRmlsCByktcfT68ngsTk2arqBewBwcbgcjAPt/onySpsf9wKUg\rEhrWoeR92BPNCaVEWpBDqKcIgGDr/W4lpU8hmY9DYrv0BM8qpFYYDnr+AcrgREb4\rvPq+B06GUwTLVh/NAA4Afb7R1dDpxuXT2CMfX/2vPgWW+GiqAl8b1Q2CjGWL6PU/\rmcjJUwSycdsoRr+hVjIOMImNpDd8mON6zPsEccJMC/+srcRTjZn78zNtDeMtYiOt\rDwIDAQAB");
        } catch (Exception e) {
            GDTLogger.d("Rsa encrypt encounter error: " + e.getMessage());
        }
        return Base64.encodeToString(bArr, 2);
    }

    private static byte[] a(byte[] bArr, String str) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException {
        PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i > 0) {
            byte[] doFinal = length - i > 245 ? cipher.doFinal(bArr, i, GDiffPatcher.COPY_UBYTE_USHORT) : cipher.doFinal(bArr, i, length - i);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2++;
            i = i2 * GDiffPatcher.COPY_UBYTE_USHORT;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }
}
