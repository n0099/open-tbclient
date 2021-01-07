package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import androidx.appcompat.widget.ActivityChooserView;
import com.ss.android.downloadlib.a.j;
import com.ss.android.socialbase.downloader.downloader.k;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f13284a;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f13285b;
    private ScheduledExecutorService pWT;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static f pWU = new f();
    }

    public static f eGz() {
        return a.pWU;
    }

    private f() {
    }

    public void a(Runnable runnable) {
        c(runnable, false);
    }

    public void b(Runnable runnable) {
        d(runnable, false);
    }

    public void c(Runnable runnable, boolean z) {
        if (runnable != null) {
            if (z && !com.ss.android.downloadlib.f.i.a()) {
                runnable.run();
            } else {
                b().execute(runnable);
            }
        }
    }

    public void d(Runnable runnable, boolean z) {
        if (runnable != null) {
            if (z && !com.ss.android.downloadlib.f.i.a()) {
                runnable.run();
            } else {
                c().execute(runnable);
            }
        }
    }

    public void a(Runnable runnable, long j) {
        try {
            eGA().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ExecutorService b() {
        if (this.f13284a == null) {
            synchronized (f.class) {
                if (this.f13284a == null) {
                    this.f13284a = new ThreadPoolExecutor(0, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.l.a(i.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.f13284a;
    }

    public ExecutorService c() {
        if (this.f13285b == null) {
            synchronized (f.class) {
                if (this.f13285b == null) {
                    this.f13285b = new ThreadPoolExecutor(0, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.l.a(i.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.f13285b;
    }

    public ScheduledExecutorService eGA() {
        if (this.pWT == null) {
            synchronized (f.class) {
                if (this.pWT == null) {
                    this.pWT = new ScheduledThreadPoolExecutor(0, new com.ss.android.socialbase.downloader.l.a(i.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.pWT;
    }

    public void e() {
        a(new Runnable() { // from class: com.ss.android.downloadlib.f.1
            @Override // java.lang.Runnable
            public void run() {
                k eHJ;
                synchronized (f.class) {
                    try {
                        for (String str : new String[]{"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_appdownloader"}) {
                            SharedPreferences sharedPreferences = j.a().getSharedPreferences(str, 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        eHJ = com.ss.android.socialbase.downloader.downloader.b.eHJ();
                    } catch (Throwable th) {
                    }
                    if (eHJ instanceof com.ss.android.socialbase.downloader.impls.d) {
                        SparseArray<com.ss.android.socialbase.downloader.g.c> a2 = ((com.ss.android.socialbase.downloader.impls.d) eHJ).eJP().a();
                        for (int size = a2.size() - 1; size >= 0; size--) {
                            com.ss.android.socialbase.downloader.g.c cVar = a2.get(a2.keyAt(size));
                            if (cVar != null) {
                                com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).j(cVar.g());
                            }
                        }
                    }
                }
            }
        });
    }
}
