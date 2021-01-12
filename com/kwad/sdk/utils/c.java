package com.kwad.sdk.utils;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public class c {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    @Nullable
    @WorkerThread
    public static byte[] a(File file) {
        byte[] bArr = null;
        if (file != null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr2, 0, read);
                }
                bArr = messageDigest.digest();
            } catch (Exception e) {
                Log.e("FileMD5Utils", "getting file md5 digest error.", e);
            } finally {
                a(fileInputStream);
            }
        }
        return bArr;
    }

    @Nullable
    @WorkerThread
    public static String b(File file) {
        try {
            byte[] a2 = a(file);
            if (a2 == null || a2.length == 0) {
                return null;
            }
            return t.a(a2, 0, a2.length);
        } catch (IOException | NoSuchAlgorithmException e) {
            Log.e("FileMD5Utils", "cannot calculate md5 of file", e);
            return null;
        }
    }
}
