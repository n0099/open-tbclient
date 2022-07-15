package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
public final class a {
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
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a("FileMD5Utils", "getting file md5 digest error.", e);
            return null;
        } finally {
            com.kwad.sdk.crash.utils.b.a(fileInputStream);
        }
    }

    @Nullable
    @WorkerThread
    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(new File(str));
    }

    @Nullable
    @WorkerThread
    public static String b(File file) {
        try {
            byte[] a = a(file);
            if (a != null && a.length != 0) {
                return z.a(a, 0, a.length);
            }
            return null;
        } catch (IOException e) {
            com.kwad.sdk.core.d.b.a("FileMD5Utils", "cannot calculate md5 of file", e);
            return null;
        }
    }
}
