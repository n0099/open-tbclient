package com.ss.android.downloadlib.g;

import java.io.File;
/* loaded from: classes8.dex */
public class g {
    public static long a(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return a(file, file.lastModified(), 0);
    }

    public static long a(File file, long j2, int i2) {
        File[] listFiles;
        if (file != null && file.exists()) {
            j2 = Math.max(j2, file.lastModified());
            int i3 = i2 + 1;
            if (i3 >= 50) {
                return j2;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    j2 = Math.max(j2, a(file2, j2, i3));
                }
            }
        }
        return j2;
    }
}
