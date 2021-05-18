package com.cmic.sso.sdk.d;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final String f30648a = "i";

    /* renamed from: d  reason: collision with root package name */
    public static i f30649d;

    /* renamed from: b  reason: collision with root package name */
    public PublicKey f30650b = null;

    /* renamed from: c  reason: collision with root package name */
    public PublicKey f30651c = null;

    public i() {
        if (0 == 0) {
            try {
                b();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (this.f30651c == null) {
            c();
        }
    }

    public static i a() {
        if (f30649d == null) {
            f30649d = new i();
        }
        return f30649d;
    }

    private void c() {
        try {
            this.f30651c = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6YCzxZS0FaWDOdtwgcHJ\n4aw0AoExz4atTkUlZJIf9eNLj7ogTlQGANNzE2R/uskFse2GsCqJKFTk4UraBkzf\naQu/yuFwKjURi0gEqyna1wQ3Anh3e6J/Pvhrp7vJyyRF3gZQCHElna1CWEN1zyT9\n+APJWeeIsUEJHi0FSf3EmwAtNgcJwLYed8Lrem+2+qvFY8RRjH3w4jT/wl2HKGEY\nYal33Q/OxoAE80SAD+DuXjpeynY1slzFV/Pi2qYmsnuBsnlDPQgJzxQKfCHl8xLf\nsjV57o+phSlqM0B5aPiMScxWJmCzFRX4NKcjt6KGP+3GpzmTyrpavnYQtHasperH\nmQIDAQAB\n", 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥输入流为空");
        }
    }

    public String b(byte[] bArr) {
        if (this.f30650b == null) {
            c.a(f30648a, "mServerPublicKey == null");
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.f30651c);
            return Base64.encodeToString(cipher.doFinal(bArr), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String a(byte[] bArr) {
        if (this.f30650b == null) {
            c.a(f30648a, "mServerPublicKey == null");
            return "";
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.f30650b);
            return s.a(cipher.doFinal(bArr));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void b() {
        try {
            this.f30650b = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/YHP9utFGOhGk7Xf5L7jOgQz5\nv2JKxdrIE3yzYsHoZJwzKC7Ttx380UZmBFzr5I1k6FFMn/YGXd4ts6UHT/nzsCIc\ngZlTTem7Pjdm1V9bJgQ6iQvFHsvT+vNgJ3wAIRd+iCMXm8y96yZhD2+SH5odBYS2\nZzwTYXBQDvB/rTfdjwIDAQAB", 0)));
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }
}
