package com.qq.e.comm.plugin.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes4.dex */
public class aq {
    private static final byte[] c = {91, -62};
    private static Cipher d = null;
    private static Cipher e = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f12860a = String.format("AES/%s/PKCS7Padding", "ECB");

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f12861b = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Exception {
        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends Exception {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    @SuppressLint({"TrulyRandom"})
    private static Cipher a() throws a {
        Cipher cipher;
        synchronized (aq.class) {
            try {
                if (d != null) {
                    cipher = d;
                } else {
                    try {
                        Cipher cipher2 = Cipher.getInstance(f12860a);
                        cipher2.init(1, new SecretKeySpec(c(), com.baidu.sapi2.utils.e.q));
                        d = cipher2;
                        cipher = d;
                    } catch (Exception e2) {
                        throw new a("Fail To Init Cipher", e2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cipher;
    }

    public static byte[] a(byte[] bArr) throws b {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(c);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(2);
            dataOutputStream.write(c(e(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    private static Cipher b() throws a {
        Cipher cipher;
        synchronized (aq.class) {
            try {
                if (e != null) {
                    cipher = e;
                } else {
                    try {
                        Cipher cipher2 = Cipher.getInstance(f12860a);
                        cipher2.init(2, new SecretKeySpec(c(), com.baidu.sapi2.utils.e.q));
                        e = cipher2;
                        cipher = e;
                    } catch (Exception e2) {
                        throw new a("Fail To Init Cipher", e2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cipher;
    }

    @TargetApi(9)
    public static byte[] b(byte[] bArr) throws b {
        if (bArr == null || bArr.length < 4) {
            throw new b("S2SS Package FormatError", null);
        }
        try {
            byte[] bArr2 = new byte[4];
            if (new DataInputStream(new ByteArrayInputStream(bArr)).read(bArr2) >= 4 && c[0] == bArr2[0] && c[1] == bArr2[1] && 1 == bArr2[2] && 2 == bArr2[3]) {
                return f(d(Arrays.copyOfRange(bArr, 4, bArr.length)));
            }
            throw new b("S2SS Package Magic/Version FormatError", null);
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    private static byte[] c() {
        return f12861b;
    }

    private static byte[] c(byte[] bArr) throws a {
        try {
            return a().doFinal(bArr);
        } catch (Exception e2) {
            throw new a("Exception While encrypt byte array", e2);
        }
    }

    private static byte[] d(byte[] bArr) throws a {
        try {
            return b().doFinal(bArr);
        } catch (Exception e2) {
            throw new a("Exception While dencrypt byte array", e2);
        }
    }

    private static byte[] e(byte[] bArr) {
        return bj.a(bArr);
    }

    private static byte[] f(byte[] bArr) {
        return bj.b(bArr);
    }
}
