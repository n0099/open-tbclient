package org.acra.util;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;
/* loaded from: classes.dex */
public class e {
    private static String a;

    public static synchronized String a(Context context) {
        String str;
        synchronized (e.class) {
            if (a == null) {
                File file = new File(context.getFilesDir(), "ACRA-INSTALLATION");
                try {
                    if (!file.exists()) {
                        b(file);
                    }
                    a = a(file);
                } catch (IOException e) {
                    Log.w(org.acra.a.a, "Couldn't retrieve InstallationId for " + context.getPackageName(), e);
                    str = "Couldn't retrieve InstallationId";
                } catch (RuntimeException e2) {
                    Log.w(org.acra.a.a, "Couldn't retrieve InstallationId for " + context.getPackageName(), e2);
                    str = "Couldn't retrieve InstallationId";
                }
            }
            str = a;
        }
        return str;
    }

    private static String a(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[(int) randomAccessFile.length()];
        try {
            randomAccessFile.readFully(bArr);
            randomAccessFile.close();
            return new String(bArr);
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    private static void b(File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(UUID.randomUUID().toString().getBytes());
        } finally {
            fileOutputStream.close();
        }
    }
}
