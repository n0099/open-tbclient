package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public class c {
    @Nullable
    @WorkerThread
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(new File(str));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @Nullable
    @WorkerThread
    public static byte[] a(File file) {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception unused) {
            return null;
        } finally {
            a(fileInputStream);
        }
    }

    @Nullable
    @WorkerThread
    public static String b(File file) {
        try {
            byte[] a = a(file);
            if (a != null && a.length != 0) {
                return aa.a(a, 0, a.length);
            }
        } catch (IOException | NoSuchAlgorithmException unused) {
        }
        return null;
    }
}
