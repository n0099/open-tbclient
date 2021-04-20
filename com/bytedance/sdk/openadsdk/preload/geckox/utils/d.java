package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import android.os.Process;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes5.dex */
public class d {
    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "delete file，pid:", Integer.valueOf(Process.myPid()), ", thread:", Thread.currentThread().toString(), ", file:" + file.getAbsolutePath());
        return d(file);
    }

    public static List<File> b(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            List<File> asList = Arrays.asList(file.listFiles());
            Collections.sort(asList, new Comparator<File>() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.utils.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(File file2, File file3) {
                    return Long.compare(file2.lastModified(), file3.lastModified());
                }
            });
            return asList;
        }
        return null;
    }

    public static boolean c(File file) {
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!c(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean d(File file) {
        boolean z;
        File[] listFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            z = true;
        } else {
            z = true;
            for (File file2 : listFiles) {
                z = z && d(file2);
            }
        }
        return z && file.delete();
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                bufferedOutputStream.write(bArr, 0, read);
            } else {
                bufferedOutputStream.flush();
                return;
            }
        }
    }
}
