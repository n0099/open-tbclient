package com.facebook.common.file;

import java.io.File;
/* loaded from: classes2.dex */
public class a {
    public static void a(File file, b bVar) {
        bVar.X(file);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2, bVar);
                } else {
                    bVar.Y(file2);
                }
            }
        }
        bVar.Z(file);
    }

    public static boolean deleteContents(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                boolean af = af(listFiles[i]) & z;
                i++;
                z = af;
            }
        }
        return z;
    }

    public static boolean af(File file) {
        if (file.isDirectory()) {
            deleteContents(file);
        }
        return file.delete();
    }
}
