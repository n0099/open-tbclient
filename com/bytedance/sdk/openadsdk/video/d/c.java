package com.bytedance.sdk.openadsdk.video.d;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    public static File a(Context context, String str) {
        File a2 = a(context);
        File file = new File(a2, str);
        if (file.exists()) {
            return file;
        }
        return new File(a2, str + ".download");
    }

    public static void b(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " is not directory!");
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
        }
    }

    public static void a(Context context, int i2) {
        if (i2 < 0) {
            return;
        }
        try {
            File[] listFiles = a(context).listFiles();
            if (listFiles == null || listFiles.length <= i2) {
                return;
            }
            List asList = Arrays.asList(listFiles);
            Collections.sort(asList, new Comparator<File>() { // from class: com.bytedance.sdk.openadsdk.video.d.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(File file, File file2) {
                    int i3 = ((file2.lastModified() - file.lastModified()) > 0L ? 1 : ((file2.lastModified() - file.lastModified()) == 0L ? 0 : -1));
                    if (i3 == 0) {
                        return 0;
                    }
                    return i3 < 0 ? -1 : 1;
                }
            });
            while (i2 < asList.size()) {
                String name = ((File) asList.get(i2)).getName();
                if (!com.bytedance.sdk.openadsdk.video.a.b.a.f30438a.contains(name.replace(name, ".download"))) {
                    ((File) asList.get(i2)).delete();
                }
                i2++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static File a(Context context) {
        File externalFilesDir = a.b() ? context.getExternalFilesDir(null) : context.getFilesDir();
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
        }
        File file = new File(externalFilesDir.getAbsolutePath() + File.separator + "ttvideo");
        try {
            b(file);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return file;
    }

    public static boolean a(File file) {
        return !file.getName().endsWith(".download");
    }

    public static void a(RandomAccessFile randomAccessFile, byte[] bArr, int i2, int i3, String str) throws IOException {
        try {
            randomAccessFile.seek(i2);
            randomAccessFile.write(bArr, 0, i3);
            a.b("VideoFilesUtils", "append:  pisition =", Integer.valueOf(i2), "  length =", Integer.valueOf(i3), " completed length=", Integer.valueOf(i2 + i3), " ", " hash =", str);
        } catch (Throwable th) {
            th.printStackTrace();
            a.b("VideoFilesUtils", "append:  pisition =", Integer.valueOf(i2), "  length =", Integer.valueOf(i3), " ", " hash =", str, th.getMessage());
        }
    }
}
