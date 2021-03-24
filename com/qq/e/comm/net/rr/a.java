package com.qq.e.comm.net.rr;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f38366a = {91, ExifInterface.MARKER_SOF2};

    /* renamed from: b  reason: collision with root package name */
    public static Cipher f38367b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Cipher f38368c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f38369d = String.format("AES/%s/PKCS7Padding", "ECB");

    /* renamed from: e  reason: collision with root package name */
    public static byte[] f38370e = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

    /* renamed from: com.qq.e.comm.net.rr.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0470a extends Exception {
        public C0470a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends Exception {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    @SuppressLint({"TrulyRandom"})
    public static synchronized Cipher a() throws C0470a {
        synchronized (a.class) {
            if (f38367b != null) {
                return f38367b;
            }
            try {
                Cipher cipher = Cipher.getInstance(f38369d);
                cipher.init(1, new SecretKeySpec(f38370e, "AES"));
                f38367b = cipher;
                return cipher;
            } catch (Exception e2) {
                throw new C0470a("Fail To Init Cipher", e2);
            }
        }
    }

    public static byte[] a(byte[] bArr) throws b {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(f38366a);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(2);
            dataOutputStream.write(c(com.qq.e.comm.a.a(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    public static synchronized Cipher b() throws C0470a {
        synchronized (a.class) {
            if (f38368c != null) {
                return f38368c;
            }
            try {
                Cipher cipher = Cipher.getInstance(f38369d);
                cipher.init(2, new SecretKeySpec(f38370e, "AES"));
                f38368c = cipher;
                return cipher;
            } catch (Exception e2) {
                throw new C0470a("Fail To Init Cipher", e2);
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
            if (f38366a[0] == bArr2[0] && f38366a[1] == bArr2[1] && 1 == bArr2[2] && 2 == bArr2[3]) {
                return com.qq.e.comm.a.b(d(Arrays.copyOfRange(bArr, 4, bArr.length)));
            }
            throw new b("S2SS Package Magic/Version FormatError", null);
        } catch (Exception e2) {
            throw new b("Exception while packaging byte array", e2);
        }
    }

    public static byte[] c(byte[] bArr) throws C0470a {
        try {
            return a().doFinal(bArr);
        } catch (Exception e2) {
            throw new C0470a("Exception While encrypt byte array", e2);
        }
    }

    public static byte[] d(byte[] bArr) throws C0470a {
        try {
            return b().doFinal(bArr);
        } catch (Exception e2) {
            throw new C0470a("Exception While dencrypt byte array", e2);
        }
    }
}
