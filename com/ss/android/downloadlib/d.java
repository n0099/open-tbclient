package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class d {
    public ExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f59829b;

    /* renamed from: c  reason: collision with root package name */
    public ScheduledExecutorService f59830c;

    /* loaded from: classes4.dex */
    public static class a {
        public static d a = new d();
    }

    public static d a() {
        return a.a;
    }

    public void b(Runnable runnable) {
        b(runnable, false);
    }

    public ExecutorService c() {
        if (this.f59829b == null) {
            synchronized (d.class) {
                if (this.f59829b == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue = new SynchronousQueue();
                    this.f59829b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new com.ss.android.socialbase.downloader.h.a(g.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.f59829b;
    }

    public ScheduledExecutorService d() {
        if (this.f59830c == null) {
            synchronized (d.class) {
                if (this.f59830c == null) {
                    this.f59830c = new ScheduledThreadPoolExecutor(0, new com.ss.android.socialbase.downloader.h.a(g.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.f59830c;
    }

    public void e() {
        a(new Runnable() { // from class: com.ss.android.downloadlib.d.1
            @Override // java.lang.Runnable
            public void run() {
                j x;
                synchronized (d.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i2 = 0; i2 < 13; i2++) {
                            SharedPreferences sharedPreferences = com.ss.android.downloadlib.addownload.j.getContext().getSharedPreferences(strArr[i2], 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        x = com.ss.android.socialbase.downloader.downloader.c.x();
                    } catch (Throwable unused) {
                    }
                    if (x instanceof com.ss.android.socialbase.downloader.impls.d) {
                        SparseArray<DownloadInfo> a2 = ((com.ss.android.socialbase.downloader.impls.d) x).a().a();
                        for (int size = a2.size() - 1; size >= 0; size--) {
                            DownloadInfo downloadInfo = a2.get(a2.keyAt(size));
                            if (downloadInfo != null) {
                                Downloader.getInstance(com.ss.android.downloadlib.addownload.j.getContext()).clearDownloadData(downloadInfo.getId());
                            }
                        }
                    }
                }
            }
        });
    }

    public d() {
    }

    public void a(Runnable runnable) {
        a(runnable, false);
    }

    public void b(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !l.a()) {
            runnable.run();
        } else {
            c().execute(runnable);
        }
    }

    public void a(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !l.a()) {
            runnable.run();
        } else {
            b().execute(runnable);
        }
    }

    public ExecutorService b() {
        if (this.a == null) {
            synchronized (d.class) {
                if (this.a == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue = new SynchronousQueue();
                    this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new com.ss.android.socialbase.downloader.h.a(g.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.a;
    }

    public void a(Runnable runnable, long j2) {
        try {
            d().schedule(runnable, j2, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
