package com.kwad.sdk.utils;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public class c {
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
        } catch (Exception e2) {
            Log.e("FileMD5Utils", "getting file md5 digest error.", e2);
            return null;
        } finally {
            a(fileInputStream);
        }
    }

    @Nullable
    @WorkerThread
    public static String b(File file) {
        try {
            byte[] a2 = a(file);
            if (a2 != null && a2.length != 0) {
                return r.a(a2, 0, a2.length);
            }
            return null;
        } catch (IOException | NoSuchAlgorithmException e2) {
            Log.e("FileMD5Utils", "cannot calculate md5 of file", e2);
            return null;
        }
    }
}
