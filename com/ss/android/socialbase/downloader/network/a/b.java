package com.ss.android.socialbase.downloader.network.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.j;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    public static long a;
    public static long b;
    public static final HandlerThread c = new HandlerThread("Downloader-preconnecter");
    public static final Handler d;

    static {
        b();
        c.start();
        Handler handler = new Handler(c.getLooper());
        d = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static Looper a() {
        return c.getLooper();
    }

    public static void b() {
        a = com.ss.android.socialbase.downloader.g.a.c().a("preconnect_connection_outdate_time", 300000L);
        b = com.ss.android.socialbase.downloader.g.a.c().a("preconnect_head_info_outdate_time", 300000L);
        a.a().a(com.ss.android.socialbase.downloader.g.a.c().a("preconnect_max_cache_size", 3));
    }

    public static List<com.ss.android.socialbase.downloader.model.c> b(long j, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.c> list) {
        String str;
        if (downloadInfo == null) {
            str = null;
        } else {
            str = downloadInfo.geteTag();
        }
        return f.a(list, str, j, 0L);
    }

    public static void a(final String str, final j jVar) {
        d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                c cVar = null;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        try {
                            List<com.ss.android.socialbase.downloader.model.c> b2 = b.b(0L, null, null);
                            if (a.a().a(str)) {
                                cVar = a.a().a(str, b2);
                            }
                            if (cVar == null) {
                                c cVar2 = new c(str, b2, 0L);
                                try {
                                    cVar2.a();
                                    if (cVar2.e()) {
                                        a.a().a(str, cVar2);
                                    }
                                    cVar = cVar2;
                                } catch (Exception e) {
                                    e = e;
                                    cVar = cVar2;
                                    e.printStackTrace();
                                    cVar.c();
                                } catch (Throwable th) {
                                    th = th;
                                    cVar = cVar2;
                                    try {
                                        cVar.c();
                                    } catch (Throwable unused) {
                                    }
                                    throw th;
                                }
                            }
                            Map<String, String> i = cVar.i();
                            if (jVar != null) {
                                jVar.a(i);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        cVar.c();
                    } catch (Throwable unused2) {
                    }
                } else {
                    j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.a(null);
                    }
                }
            }
        });
    }
}
