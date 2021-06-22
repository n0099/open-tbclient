package com.meizu.cloud.pushsdk.util;

import android.text.TextUtils;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f38808a = Charset.forName("UTF-8");

    public static String a(String str, String str2) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                return new String(a(a(str), b(str2)), f38808a);
            } catch (Exception e2) {
                d.j.a.a.a.b("RSAUtils", "decrypt " + e2.getMessage());
                return null;
            }
        }
        return null;
    }

    public static RSAPublicKey a(String str) {
        StringBuilder sb;
        String message;
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b(str)));
        } catch (IOException e2) {
            sb = new StringBuilder();
            sb.append("loadPublicKey IOException ");
            message = e2.getMessage();
            sb.append(message);
            d.j.a.a.a.b("RSAUtils", sb.toString());
            return null;
        } catch (NoSuchAlgorithmException e3) {
            sb = new StringBuilder();
            sb.append("loadPublicKey NoSuchAlgorithmException ");
            message = e3.getMessage();
            sb.append(message);
            d.j.a.a.a.b("RSAUtils", sb.toString());
            return null;
        } catch (InvalidKeySpecException e4) {
            sb = new StringBuilder();
            sb.append("loadPublicKey InvalidKeySpecException ");
            message = e4.getMessage();
            sb.append(message);
            d.j.a.a.a.b("RSAUtils", sb.toString());
            return null;
        }
    }

    public static byte[] a(PublicKey publicKey, byte[] bArr) throws Exception {
        Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] b(String str) throws IOException {
        return com.meizu.cloud.pushsdk.b.g.a.a(str);
    }
}
