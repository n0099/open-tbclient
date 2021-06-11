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
    public static final byte[] f39185a = {91, -62};

    /* renamed from: b  reason: collision with root package name */
    public static Cipher f39186b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Cipher f39187c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f39188d = String.format("AES/%s/PKCS7Padding", "ECB");

    /* renamed from: e  reason: collision with root package name */
    public static byte[] f39189e = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

    /* renamed from: com.qq.e.comm.net.rr.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0471a extends Exception {
        public C0471a(String str, Throwable th) {
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
    public static synchronized Cipher a() throws C0471a {
        synchronized (a.class) {
            if (f39186b != null) {
                return f39186b;
            }
            try {
                Cipher cipher = Cipher.getInstance(f39188d);
                cipher.init(1, new SecretKeySpec(f39189e, "AES"));
                f39186b = cipher;
                return cipher;
            } catch (Exception e2) {
                throw new C0471a("Fail To Init Cipher", e2);
            }
        }
    }

    public static byte[] a(byte[] bArr) throws b {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(f39185a);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(2);
            dataOutputStream.write(c(com.qq.e.comm.a.a(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    public static synchronized Cipher b() throws C0471a {
        synchronized (a.class) {
            if (f39187c != null) {
                return f39187c;
            }
            try {
                Cipher cipher = Cipher.getInstance(f39188d);
                cipher.init(2, new SecretKeySpec(f39189e, "AES"));
                f39187c = cipher;
                return cipher;
            } catch (Exception e2) {
                throw new C0471a("Fail To Init Cipher", e2);
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
            if (f39185a[0] == bArr2[0] && f39185a[1] == bArr2[1] && 1 == bArr2[2] && 2 == bArr2[3]) {
                return com.qq.e.comm.a.b(d(Arrays.copyOfRange(bArr, 4, bArr.length)));
            }
            throw new b("S2SS Package Magic/Version FormatError", null);
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    public static byte[] c(byte[] bArr) throws C0471a {
        try {
            return a().doFinal(bArr);
        } catch (Exception e2) {
            throw new C0471a("Exception While encrypt byte array", e2);
        }
    }

    public static byte[] d(byte[] bArr) throws C0471a {
        try {
            return b().doFinal(bArr);
        } catch (Exception e2) {
            throw new C0471a("Exception While dencrypt byte array", e2);
        }
    }
}
