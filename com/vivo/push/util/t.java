package com.vivo.push.util;

import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
/* loaded from: classes3.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static String f13997a = RSAUtil.ALGORITHM_RSA;

    public static PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(f13997a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e3) {
            throw new Exception("公钥非法");
        }
    }

    public static boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) throws Exception {
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }
}
