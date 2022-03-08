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
/* loaded from: classes8.dex */
public class g {
    public static volatile g a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.download.api.a f58207b;

    /* renamed from: c  reason: collision with root package name */
    public final f f58208c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ss.android.downloadad.api.a f58209d;

    /* renamed from: e  reason: collision with root package name */
    public com.ss.android.downloadad.api.b f58210e;

    /* renamed from: f  reason: collision with root package name */
    public long f58211f;

    /* JADX INFO: Access modifiers changed from: private */
    public f h() {
        return this.f58208c;
    }

    public void c() {
        this.f58211f = System.currentTimeMillis();
    }

    public com.ss.android.downloadad.api.a d() {
        return this.f58209d;
    }

    public com.ss.android.downloadad.api.b e() {
        if (this.f58210e == null) {
            this.f58210e = b.a();
        }
        return this.f58210e;
    }

    public String f() {
        return j.m();
    }

    public void g() {
        d.a().e();
    }

    public g(Context context) {
        this.f58208c = f.a();
        this.f58207b = new e();
        this.f58211f = System.currentTimeMillis();
        b(context);
        this.f58209d = a.a();
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
        return this.f58207b;
    }

    @MainThread
    public void a(final Context context, final int i2, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.3
            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(context, i2, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    @MainThread
    public void a(final String str, final long j2, final int i2, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final u uVar, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.4
            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(str, j2, i2, downloadEventConfig, downloadController, uVar, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void a(final String str, final long j2, final int i2, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.5
            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(str, j2, i2, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    public void a(final String str, final int i2) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.g.6
            @Override // java.lang.Runnable
            public void run() {
                g.this.h().a(str, i2);
            }
        });
    }

    public long b() {
        return this.f58211f;
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
