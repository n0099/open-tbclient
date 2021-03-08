package com.ss.android.downloadlib.a.c;

import android.content.Context;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.f.i;
import com.ss.android.socialbase.downloader.downloader.f;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    public static void a() {
        List<com.ss.android.socialbase.downloader.g.c> a2 = com.ss.android.socialbase.appdownloader.d.eFz().a(j.a());
        if (a2 != null && a2.size() > 0) {
            for (int i = 0; i < a2.size(); i++) {
                com.ss.android.socialbase.downloader.g.c cVar = a2.get(i);
                File file = new File(cVar.l(), cVar.m());
                long lastModified = file.lastModified();
                long a3 = com.ss.android.socialbase.downloader.k.a.Sa(cVar.g()).a("download_file_expire_hours", 0) * BdKVCache.MILLS_1Hour;
                if (a3 <= 0) {
                    a3 = 604800000;
                }
                if (file != null && file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= a3) {
                    a(file);
                    f.iC(j.a()).j(cVar.g());
                }
            }
        }
    }

    public static void b() {
        com.ss.android.socialbase.downloader.g.c cVar;
        boolean z;
        List<com.ss.android.socialbase.downloader.g.c> b = f.iC(j.a()).b("application/vnd.android.package-archive");
        if (b != null && !b.isEmpty()) {
            for (int i = 0; i < b.size(); i++) {
                if (b.get(i) != null) {
                    String str = cVar.k() + File.separator + cVar.h();
                    File file = new File(str);
                    if (file != null && file.exists()) {
                        long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                        long a2 = com.ss.android.socialbase.downloader.k.a.Sa(cVar.g()).a("download_complete_file_expire_hours", 0) * BdKVCache.MILLS_1Hour;
                        if (a2 <= 0) {
                            a2 = 604800000;
                        }
                        if (currentTimeMillis >= a2) {
                            z = true;
                        } else {
                            z = i.e(j.a(), str);
                        }
                        if (z) {
                            a(file);
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context) {
        File externalCacheDir;
        if (context != null && (externalCacheDir = context.getExternalCacheDir()) != null) {
            try {
                a(externalCacheDir.getPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    fileOutputStream.write("1".getBytes());
                    fileOutputStream.close();
                    FileOutputStream fileOutputStream2 = null;
                    if (0 != 0) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    file.delete();
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
        file.delete();
    }

    private static void a(String str) {
        String str2;
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list != null) {
                for (String str3 : list) {
                    if (str3 != null) {
                        if (str.endsWith(File.separator)) {
                            str2 = str + str3;
                        } else {
                            str2 = str + File.separator + str3;
                        }
                        File file2 = new File(str2);
                        if (file2.isFile()) {
                            file2.delete();
                        }
                        if (file2.isDirectory()) {
                            a(str2);
                        }
                    }
                }
                file.delete();
            }
        }
    }
}
