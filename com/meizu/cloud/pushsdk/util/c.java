package com.meizu.cloud.pushsdk.util;

import android.text.TextUtils;
import com.baidu.android.common.security.RSAUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f4448a = Charset.forName("UTF-8");

    public static String a(String str, String str2) {
        String str3;
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    str3 = new String(a(a(str), b(str2)), f4448a);
                    return str3;
                }
            } catch (Exception e) {
                com.meizu.cloud.a.a.e("RSAUtils", "decrypt " + e.getMessage());
                return null;
            }
        }
        str3 = null;
        return str3;
    }

    private static RSAPublicKey a(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(b(str)));
        } catch (IOException e) {
            com.meizu.cloud.a.a.e("RSAUtils", "loadPublicKey IOException " + e.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e2) {
            com.meizu.cloud.a.a.e("RSAUtils", "loadPublicKey NoSuchAlgorithmException " + e2.getMessage());
            return null;
        } catch (InvalidKeySpecException e3) {
            com.meizu.cloud.a.a.e("RSAUtils", "loadPublicKey InvalidKeySpecException " + e3.getMessage());
            return null;
        }
    }

    private static byte[] a(PublicKey publicKey, byte[] bArr) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    private static byte[] b(String str) throws IOException {
        return com.meizu.cloud.pushsdk.b.g.a.a(str);
    }
}
