package com.ss.android.socialbase.downloader.i.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.i.i;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static long f13463a;

    /* renamed from: b  reason: collision with root package name */
    static long f13464b;
    private static final HandlerThread c = new HandlerThread("Downloader-preconnecter");
    private static final Handler d;

    static {
        a();
        c.start();
        d = new Handler(c.getLooper());
        d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable th) {
                }
            }
        });
    }

    public static void a(final String str, final i iVar) {
        d.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.i.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                c cVar = null;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        try {
                            List<e> a2 = b.a(0L, null, null);
                            c w = a.eJh().a(str) ? a.eJh().w(str, a2) : null;
                            if (w == null) {
                                try {
                                    cVar = new c(str, a2, 0L);
                                    cVar.a();
                                    if (cVar.e()) {
                                        a.eJh().a(str, cVar);
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    cVar = w;
                                    e.printStackTrace();
                                    try {
                                        cVar.c();
                                        return;
                                    } catch (Throwable th) {
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    cVar = w;
                                    try {
                                        cVar.c();
                                    } catch (Throwable th3) {
                                    }
                                    throw th;
                                }
                            } else {
                                cVar = w;
                            }
                            Map<String, String> i = cVar.i();
                            if (iVar != null) {
                                iVar.a(i);
                            }
                            try {
                                cVar.c();
                            } catch (Throwable th4) {
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } else if (iVar != null) {
                    iVar.a(null);
                }
            }
        });
    }

    private static void a() {
        f13463a = com.ss.android.socialbase.downloader.k.a.eJs().a("preconnect_connection_outdate_time", 300000L);
        f13464b = com.ss.android.socialbase.downloader.k.a.eJs().a("preconnect_head_info_outdate_time", 300000L);
        a.eJh().a(com.ss.android.socialbase.downloader.k.a.eJs().a("preconnect_max_cache_size", 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<e> a(long j, com.ss.android.socialbase.downloader.g.c cVar, List<e> list) {
        return com.ss.android.socialbase.downloader.m.d.a(list, cVar == null ? null : cVar.an(), j, 0L);
    }
}
