package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class k {
    public static Long a(File file) {
        File[] listFiles;
        Long l = null;
        if (file != null && (listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.utils.k.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        })) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                try {
                    long longValue = Long.valueOf(file2.getName()).longValue();
                    if (l == null) {
                        l = Long.valueOf(longValue);
                    } else if (longValue > l.longValue()) {
                        l = Long.valueOf(longValue);
                    }
                } catch (Exception e) {
                }
            }
        }
        return l;
    }

    public static List<Long> b(File file) {
        File[] listFiles;
        ArrayList arrayList = null;
        if (file != null && (listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.utils.k.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        })) != null && listFiles.length != 0) {
            arrayList = new ArrayList();
            for (File file2 : listFiles) {
                try {
                    arrayList.add(Long.valueOf(Long.valueOf(file2.getName()).longValue()));
                } catch (Exception e) {
                }
            }
        }
        return arrayList;
    }
}
