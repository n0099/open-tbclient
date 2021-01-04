package com.bytedance.sdk.openadsdk.preload.geckox.a;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.d;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.f;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.j;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public static void a(final String str) {
        j.a().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.d(str);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.preload.geckox.utils.c.a(new RuntimeException("delete old channel version failed，path：" + str, th));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) throws Exception {
        com.bytedance.sdk.openadsdk.preload.geckox.g.a a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.a.a(str + File.separator + "update.lock");
        if (a2 != null) {
            try {
                com.bytedance.sdk.openadsdk.preload.geckox.g.b a3 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(str + File.separator + "select.lock");
                List<File> e = e(str);
                if (e != null && !e.isEmpty()) {
                    Iterator<File> it = e.iterator();
                    while (it.hasNext()) {
                        com.bytedance.sdk.openadsdk.preload.geckox.g.c.c(it.next().getAbsolutePath() + File.separator + "using.lock");
                    }
                    a3.a();
                    return;
                }
                a3.a();
            } finally {
                a2.a();
            }
        }
    }

    public static boolean b(String str) {
        try {
            com.bytedance.sdk.openadsdk.preload.geckox.g.a a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.a.a(str + File.separator + "update.lock");
            if (a2 == null) {
                return true;
            }
            com.bytedance.sdk.openadsdk.preload.geckox.g.b a3 = com.bytedance.sdk.openadsdk.preload.geckox.g.b.a(str + File.separator + "select.lock");
            try {
                d.c(new File(str));
                a3.a();
            } catch (Throwable th) {
                a3.a();
            }
            a2.a();
            return true;
        } catch (Throwable th2) {
            return false;
        }
    }

    private static List<File> e(String str) {
        File[] listFiles = new File(str).listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.a.c.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        if (listFiles == null || listFiles.length == 0 || listFiles.length == 1) {
            return null;
        }
        return a(listFiles);
    }

    private static List<File> a(File[] fileArr) {
        long j;
        File file = null;
        ArrayList<File> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long j2 = -1;
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (name.endsWith("--updating")) {
                arrayList.add(file2);
            } else if (name.endsWith("--pending-delete")) {
                a(file2);
            } else {
                try {
                    long parseLong = Long.parseLong(name);
                    if (parseLong > j2) {
                        if (file != null) {
                            try {
                                arrayList2.add(file);
                            } catch (Exception e) {
                                j2 = parseLong;
                                a(file2);
                            }
                        }
                    } else {
                        arrayList2.add(file2);
                        file2 = file;
                        parseLong = j2;
                    }
                    file = file2;
                    j2 = parseLong;
                } catch (Exception e2) {
                }
            }
        }
        for (File file3 : arrayList) {
            String name2 = file3.getName();
            int indexOf = name2.indexOf("--updating");
            if (indexOf == -1) {
                a(file3);
            } else {
                try {
                    j = Long.parseLong(name2.substring(0, indexOf));
                } catch (NumberFormatException e3) {
                    e3.printStackTrace();
                    j = -1;
                }
                if (j <= j2) {
                    a(file3);
                }
            }
        }
        return arrayList2;
    }

    private static void a(final File file) {
        f.a().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                d.a(file);
            }
        });
    }
}
