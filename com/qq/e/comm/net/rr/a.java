package com.qq.e.comm.net.rr;

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
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f35577a = {91, -62};

    /* renamed from: b  reason: collision with root package name */
    public static Cipher f35578b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Cipher f35579c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f35580d = String.format("AES/%s/PKCS7Padding", "ECB");

    /* renamed from: e  reason: collision with root package name */
    public static byte[] f35581e = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

    /* renamed from: com.qq.e.comm.net.rr.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0419a extends Exception {
        public C0419a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends Exception {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    @SuppressLint({"TrulyRandom"})
    public static synchronized Cipher a() throws C0419a {
        synchronized (a.class) {
            if (f35578b != null) {
                return f35578b;
            }
            try {
                Cipher cipher = Cipher.getInstance(f35580d);
                cipher.init(1, new SecretKeySpec(f35581e, "AES"));
                f35578b = cipher;
                return cipher;
            } catch (Exception e2) {
                throw new C0419a("Fail To Init Cipher", e2);
            }
        }
    }

    public static byte[] a(byte[] bArr) throws b {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(f35577a);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(2);
            dataOutputStream.write(c(com.qq.e.comm.a.a(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    public static synchronized Cipher b() throws C0419a {
        synchronized (a.class) {
            if (f35579c != null) {
                return f35579c;
            }
            try {
                Cipher cipher = Cipher.getInstance(f35580d);
                cipher.init(2, new SecretKeySpec(f35581e, "AES"));
                f35579c = cipher;
                return cipher;
            } catch (Exception e2) {
                throw new C0419a("Fail To Init Cipher", e2);
            }
        }
    }

    @TargetApi(9)
    public static byte[] b(byte[] bArr) throws b {
        if (bArr == null || bArr.length < 4) {
            throw new b("S2SS Package FormatError", null);
        }
        try {
            byte[] bArr2 = new byte[4];
            new DataInputStream(new ByteArrayInputStream(bArr)).read(bArr2);
            if (f35577a[0] == bArr2[0] && f35577a[1] == bArr2[1] && 1 == bArr2[2] && 2 == bArr2[3]) {
                return com.qq.e.comm.a.b(d(Arrays.copyOfRange(bArr, 4, bArr.length)));
            }
            throw new b("S2SS Package Magic/Version FormatError", null);
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    public static byte[] c(byte[] bArr) throws C0419a {
        try {
            return a().doFinal(bArr);
        } catch (Exception e2) {
            throw new C0419a("Exception While encrypt byte array", e2);
        }
    }

    public static byte[] d(byte[] bArr) throws C0419a {
        try {
            return b().doFinal(bArr);
        } catch (Exception e2) {
            throw new C0419a("Exception While dencrypt byte array", e2);
        }
    }
}
