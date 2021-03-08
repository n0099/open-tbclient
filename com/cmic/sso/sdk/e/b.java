package com.cmic.sso.sdk.e;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes14.dex */
public class b {
    public static boolean a(Context context, boolean z) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.getCertificate("CMCC_SDK") != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            return a(context);
        }
        return false;
    }

    private static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSAUtil.ALGORITHM_RSA, "AndroidKeyStore");
                keyPairGenerator.initialize(new KeyGenParameterSpec.Builder("CMCC_SDK", 3).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("PKCS1Padding").setKeySize(2048).build());
                Thread.sleep(1000L);
                keyPairGenerator.generateKeyPair();
                return true;
            } catch (Exception e) {
                c.a("KeystoreUtil", e.getMessage());
                return false;
            }
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(1, 30);
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context).setAlias("CMCC_SDK").setSubject(new X500Principal("CN=CMCC_SDK")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance(RSAUtil.ALGORITHM_RSA, "AndroidKeyStore");
                keyPairGenerator2.initialize(build);
                Thread.sleep(1000L);
                keyPairGenerator2.generateKeyPair();
                return true;
            }
            return false;
        } catch (Exception e2) {
            c.a("KeystoreUtil", e2.getMessage());
            return false;
        }
    }

    private static byte[] a() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str) {
        byte[] b = b(context);
        if (b != null) {
            return a.a(b, str);
        }
        return null;
    }

    private static synchronized byte[] b(Context context) {
        KeyStore keyStore;
        byte[] bArr;
        byte[] bArr2 = null;
        synchronized (b.class) {
            try {
                keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(b())) {
                if (a(context, false)) {
                    bArr = a();
                    PublicKey publicKey = keyStore.getCertificate("CMCC_SDK").getPublicKey();
                    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    cipher.init(1, publicKey);
                    a(Base64.encodeToString(cipher.doFinal(bArr), 0));
                }
            } else {
                String b = b();
                if (TextUtils.isEmpty(b)) {
                    bArr = null;
                } else {
                    byte[] decode = Base64.decode(b, 0);
                    PrivateKey privateKey = (PrivateKey) keyStore.getKey("CMCC_SDK", null);
                    if (privateKey != null) {
                        Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                        cipher2.init(2, privateKey);
                        bArr = cipher2.doFinal(decode);
                    }
                }
            }
            bArr2 = bArr;
        }
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Context context, String str) {
        byte[] b;
        if (TextUtils.isEmpty(str) || (b = b(context)) == null) {
            return null;
        }
        return a.b(b, str);
    }

    private static void a(String str) {
        k.a("AES_KEY", str);
    }

    private static String b() {
        return k.b("AES_KEY", "");
    }
}
