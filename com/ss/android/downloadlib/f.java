package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.a.j;
import com.ss.android.socialbase.downloader.downloader.k;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f12986a;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f12987b;
    private ScheduledExecutorService qcX;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static f qcY = new f();
    }

    public static f eFh() {
        return a.qcY;
    }

    private f() {
    }

    public void a(Runnable runnable) {
        d(runnable, false);
    }

    public void b(Runnable runnable) {
        e(runnable, false);
    }

    public void d(Runnable runnable, boolean z) {
        if (runnable != null) {
            if (z && !com.ss.android.downloadlib.f.i.a()) {
                runnable.run();
            } else {
                b().execute(runnable);
            }
        }
    }

    public void e(Runnable runnable, boolean z) {
        if (runnable != null) {
            if (z && !com.ss.android.downloadlib.f.i.a()) {
                runnable.run();
            } else {
                eFi().execute(runnable);
            }
        }
    }

    public void a(Runnable runnable, long j) {
        try {
            eFj().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ExecutorService b() {
        if (this.f12986a == null) {
            synchronized (f.class) {
                if (this.f12986a == null) {
                    this.f12986a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.l.a(i.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.f12986a;
    }

    public ExecutorService eFi() {
        if (this.f12987b == null) {
            synchronized (f.class) {
                if (this.f12987b == null) {
                    this.f12987b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.l.a(i.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.f12987b;
    }

    public ScheduledExecutorService eFj() {
        if (this.qcX == null) {
            synchronized (f.class) {
                if (this.qcX == null) {
                    this.qcX = new ScheduledThreadPoolExecutor(0, new com.ss.android.socialbase.downloader.l.a(i.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.qcX;
    }

    public void e() {
        a(new Runnable() { // from class: com.ss.android.downloadlib.f.1
            @Override // java.lang.Runnable
            public void run() {
                k eGs;
                synchronized (f.class) {
                    try {
                        for (String str : new String[]{"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_appdownloader"}) {
                            SharedPreferences sharedPreferences = j.a().getSharedPreferences(str, 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        eGs = com.ss.android.socialbase.downloader.downloader.b.eGs();
                    } catch (Throwable th) {
                    }
                    if (eGs instanceof com.ss.android.socialbase.downloader.impls.d) {
                        SparseArray<com.ss.android.socialbase.downloader.g.c> a2 = ((com.ss.android.socialbase.downloader.impls.d) eGs).eIy().a();
                        for (int size = a2.size() - 1; size >= 0; size--) {
                            com.ss.android.socialbase.downloader.g.c cVar = a2.get(a2.keyAt(size));
                            if (cVar != null) {
                                com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).j(cVar.g());
                            }
                        }
                    }
                }
            }
        });
    }
}
