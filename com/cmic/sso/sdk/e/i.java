package com.cmic.sso.sdk.e;

import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes10.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4026a = i.class.getSimpleName();
    private static i pab = null;
    private PublicKey oZZ = null;
    private PublicKey paa = null;

    public static i eoG() {
        if (pab == null) {
            pab = new i();
        }
        return pab;
    }

    private i() {
        try {
            if (this.oZZ == null) {
                b();
            }
            if (this.paa == null) {
                c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String a(byte[] bArr) {
        if (this.oZZ == null) {
            c.a(f4026a, "mServerPublicKey == null");
            return "";
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.oZZ);
            return s.a(cipher.doFinal(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String b(byte[] bArr) {
        if (this.oZZ == null) {
            c.a(f4026a, "mServerPublicKey == null");
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.paa);
            return Base64.encodeToString(cipher.doFinal(bArr), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private void b() throws Exception {
        try {
            this.oZZ = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/YHP9utFGOhGk7Xf5L7jOgQz5\nv2JKxdrIE3yzYsHoZJwzKC7Ttx380UZmBFzr5I1k6FFMn/YGXd4ts6UHT/nzsCIc\ngZlTTem7Pjdm1V9bJgQ6iQvFHsvT+vNgJ3wAIRd+iCMXm8y96yZhD2+SH5odBYS2\nZzwTYXBQDvB/rTfdjwIDAQAB", 0)));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void c() throws Exception {
        try {
            this.paa = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6YCzxZS0FaWDOdtwgcHJ\n4aw0AoExz4atTkUlZJIf9eNLj7ogTlQGANNzE2R/uskFse2GsCqJKFTk4UraBkzf\naQu/yuFwKjURi0gEqyna1wQ3Anh3e6J/Pvhrp7vJyyRF3gZQCHElna1CWEN1zyT9\n+APJWeeIsUEJHi0FSf3EmwAtNgcJwLYed8Lrem+2+qvFY8RRjH3w4jT/wl2HKGEY\nYal33Q/OxoAE80SAD+DuXjpeynY1slzFV/Pi2qYmsnuBsnlDPQgJzxQKfCHl8xLf\nsjV57o+phSlqM0B5aPiMScxWJmCzFRX4NKcjt6KGP+3GpzmTyrpavnYQtHasperH\nmQIDAQAB\n", 0)));
        } catch (NullPointerException e) {
            throw new Exception("公钥输入流为空");
        }
    }
}
