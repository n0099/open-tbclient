package com.qq.e.comm.util;

import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private PublicKey f12760a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f12761b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qq.e.comm.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C1214a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f12762a = new a((byte) 0);
    }

    private a() {
        boolean z;
        try {
            this.f12760a = b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z = true;
        } catch (Throwable th) {
            z = false;
        }
        this.f12761b = z;
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C1214a.f12762a;
    }

    private String a(String str) {
        if (this.f12760a != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, this.f12760a);
                return new String(cipher.doFinal(decode), "UTF-8").trim();
            } catch (Throwable th) {
                GDTLogger.e("ErrorWhileVerifySigNature", th);
            }
        }
        return null;
    }

    private static PublicKey b(String str) throws Exception {
        try {
            return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e3) {
            throw new Exception("公钥非法");
        }
    }

    private boolean b(String str, String str2) {
        if (StringUtil.isEmpty(str2)) {
            return false;
        }
        if (this.f12761b) {
            String a2 = a(str);
            boolean equals = str2.equals(a2);
            GDTLogger.d("Verify Result" + equals + "src=" + str2 + " & target=" + a2);
            return equals;
        }
        return true;
    }

    public final boolean a(String str, String str2) {
        return b(str, Md5Util.encode(str2));
    }
}
