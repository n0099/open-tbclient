package com.qq.e.comm.net.rr;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Base64;
import com.baidu.sapi2.utils.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f7587a = {91, -62};
    private static Cipher b = null;
    private static Cipher c = null;
    private static String d = String.format("AES/%s/PKCS7Padding", "ECB");
    private static byte[] e = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qq.e.comm.net.rr.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1205a extends Exception {
        public C1205a(String str, Throwable th) {
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
    private static synchronized Cipher a() throws C1205a {
        Cipher cipher;
        synchronized (a.class) {
            if (b != null) {
                cipher = b;
            } else {
                try {
                    Cipher cipher2 = Cipher.getInstance(d);
                    cipher2.init(1, new SecretKeySpec(e, e.q));
                    b = cipher2;
                    cipher = b;
                } catch (Exception e2) {
                    throw new C1205a("Fail To Init Cipher", e2);
                }
            }
        }
        return cipher;
    }

    public static byte[] a(byte[] bArr) throws b {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(f7587a);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(2);
            dataOutputStream.write(c(com.qq.e.comm.a.a(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    private static synchronized Cipher b() throws C1205a {
        Cipher cipher;
        synchronized (a.class) {
            if (c != null) {
                cipher = c;
            } else {
                try {
                    Cipher cipher2 = Cipher.getInstance(d);
                    cipher2.init(2, new SecretKeySpec(e, e.q));
                    c = cipher2;
                    cipher = c;
                } catch (Exception e2) {
                    throw new C1205a("Fail To Init Cipher", e2);
                }
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
            new DataInputStream(new ByteArrayInputStream(bArr)).read(bArr2);
            if (f7587a[0] == bArr2[0] && f7587a[1] == bArr2[1] && 1 == bArr2[2] && 2 == bArr2[3]) {
                return com.qq.e.comm.a.b(d(Arrays.copyOfRange(bArr, 4, bArr.length)));
            }
            throw new b("S2SS Package Magic/Version FormatError", null);
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    private static byte[] c(byte[] bArr) throws C1205a {
        try {
            return a().doFinal(bArr);
        } catch (Exception e2) {
            throw new C1205a("Exception While encrypt byte array", e2);
        }
    }

    private static byte[] d(byte[] bArr) throws C1205a {
        try {
            return b().doFinal(bArr);
        } catch (Exception e2) {
            throw new C1205a("Exception While dencrypt byte array", e2);
        }
    }
}
