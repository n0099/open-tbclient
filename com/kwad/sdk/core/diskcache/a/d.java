package com.kwad.sdk.core.diskcache.a;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public class d {
    public static Object a(InputStream inputStream) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            try {
                try {
                    Object readObject = objectInputStream.readObject();
                    a((Closeable) objectInputStream);
                    return readObject;
                } catch (Exception e2) {
                    e = e2;
                    com.kwad.sdk.core.d.a.a(e);
                    a((Closeable) objectInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                objectInputStream2 = objectInputStream;
                a((Closeable) objectInputStream2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            objectInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            a((Closeable) objectInputStream2);
            throw th;
        }
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
        if ((obj instanceof String) && TextUtils.isEmpty((String) obj)) {
            throw new NullPointerException(str);
        }
    }

    public static boolean a(OutputStream outputStream, Object obj) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(outputStream);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            a(objectOutputStream);
            return true;
        } catch (Exception e3) {
            e = e3;
            objectOutputStream2 = objectOutputStream;
            com.kwad.sdk.core.d.a.a(e);
            a(objectOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            a(objectOutputStream2);
            throw th;
        }
    }
}
