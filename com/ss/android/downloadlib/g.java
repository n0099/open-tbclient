package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes7.dex */
public class g {
    public static volatile g a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.download.api.a f42947b;

    /* renamed from: c  reason: collision with root package name */
    public final f f42948c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ss.android.downloadad.api.a f42949d;

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.downloadad.api.b f42950e;

    /* renamed from: f  reason: collision with root package name */
    public long f42951f;

    /* JADX INFO: Access modifiers changed from: private */
    public f h() {
        return this.f42948c;
    }

    public void c() {
        this.f42951f = System.currentTimeMillis();
    }

    public com.ss.android.downloadad.api.a d() {
        return this.f42949d;
    }

    public com.ss.android.downloadad.api.b e() {
        if (this.f42950e == null) {
            this.f42950e = b.a();
        }
        return this.f42950e;
    }

    public String f() {
        return j.m();
    }

    public void g() {
        d.a().e();
    }

    public g(Context context) {
        this.f42948c = f.a();
        this.f42947b = new e();
        this.f42951f = System.currentTimeMillis();
        b(context);
        this.f42949d = a.a();
    }

    public static g a(final Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g unused = g.a = new g(context);
                        }
                    });
                }
            }
        }
        return a;
    }

    private void b(Context context) {
        j.a(context);
        Downloader.getInstance(j.getContext());
        com.ss.android.downloadlib.addownload.b.f.a().b();
        com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), "misc_config", new com.ss.android.downloadlib.c.g(), new com.ss.android.downloadlib.c.f(context), new c());
        com.ss.android.downloadlib.c.d dVar = new com.ss.android.downloadlib.c.d();
        com.ss.android.socialbase.appdownloader.d.j().a(dVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(dVar);
        com.ss.android.socialbase.appdownloader.d.j().a(new k());
        com.ss.android.socialbase.downloader.downloader.c.a(new com.ss.android.downloadlib.c.e());
        com.ss.android.socialbase.appdownloader.d.j().a(com.ss.android.downloadlib.f.c.a());
    }

    public com.ss.android.download.api.a a() {
        return this.f42947b;
    }

    @MainThread
    public void a(final Context context, final int i, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.3
            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(context, i, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    @MainThread
    public void a(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final u uVar, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.4
            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(str, j, i, downloadEventConfig, downloadController, uVar, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void a(final String str, final long j, final int i, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.5
            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(str, j, i, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    public void a(final String str, final int i) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.6
            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(str, i);
            }
        });
    }

    public long b() {
        return this.f42951f;
    }

    @MainThread
    public void a(final String str, final boolean z) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.2
            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(str, z);
            }
        });
    }

    public void a(com.ss.android.download.api.download.a.a aVar) {
        h().a(aVar);
    }

    public DownloadInfo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), str);
    }
}
