package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class f {
    public static volatile f a;

    /* renamed from: f  reason: collision with root package name */
    public long f42927f;

    /* renamed from: c  reason: collision with root package name */
    public final List<com.ss.android.downloadlib.addownload.f> f42924c = new CopyOnWriteArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, com.ss.android.downloadlib.addownload.f> f42925d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f42926e = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final Handler f42923b = new Handler(Looper.getMainLooper());

    private synchronized void b(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.f42924c.size() <= 0) {
            c(context, i, downloadStatusChangeListener, downloadModel);
        } else {
            com.ss.android.downloadlib.addownload.f remove = this.f42924c.remove(0);
            remove.b(context).b(i, downloadStatusChangeListener).b(downloadModel).a();
            this.f42925d.put(downloadModel.getDownloadUrl(), remove);
        }
    }

    private void c(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.e eVar = new com.ss.android.downloadlib.addownload.e();
        eVar.b(context).b(i, downloadStatusChangeListener).b(downloadModel).a();
        this.f42925d.put(downloadModel.getDownloadUrl(), eVar);
    }

    private void d() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.f fVar : this.f42924c) {
            if (!fVar.b() && currentTimeMillis - fVar.d() > 300000) {
                fVar.h();
                arrayList.add(fVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f42924c.removeAll(arrayList);
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f42927f < 300000) {
            return;
        }
        this.f42927f = currentTimeMillis;
        if (this.f42924c.isEmpty()) {
            return;
        }
        d();
    }

    public void a(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        com.ss.android.downloadlib.addownload.f fVar = this.f42925d.get(downloadModel.getDownloadUrl());
        if (fVar != null) {
            fVar.b(context).b(i, downloadStatusChangeListener).b(downloadModel).a();
        } else if (!this.f42924c.isEmpty()) {
            b(context, i, downloadStatusChangeListener, downloadModel);
        } else {
            c(context, i, downloadStatusChangeListener, downloadModel);
        }
    }

    public void b(final DownloadInfo downloadInfo, final String str) {
        this.f42923b.post(new Runnable() { // from class: com.ss.android.downloadlib.f.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.f42926e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).b(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).b(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public Handler b() {
        return this.f42923b;
    }

    public com.ss.android.downloadlib.addownload.e a(String str) {
        Map<String, com.ss.android.downloadlib.addownload.f> map = this.f42925d;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            com.ss.android.downloadlib.addownload.f fVar = this.f42925d.get(str);
            if (fVar instanceof com.ss.android.downloadlib.addownload.e) {
                return (com.ss.android.downloadlib.addownload.e) fVar;
            }
        }
        return null;
    }

    public void a(String str, int i) {
        com.ss.android.downloadlib.addownload.f fVar;
        if (TextUtils.isEmpty(str) || (fVar = this.f42925d.get(str)) == null) {
            return;
        }
        if (fVar.a(i)) {
            this.f42924c.add(fVar);
            this.f42925d.remove(str);
        }
        c();
    }

    public void a(String str, boolean z) {
        com.ss.android.downloadlib.addownload.f fVar;
        if (TextUtils.isEmpty(str) || (fVar = this.f42925d.get(str)) == null) {
            return;
        }
        fVar.a(z);
    }

    public void a(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        a(str, j, i, downloadEventConfig, downloadController, null, null);
    }

    public void a(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, u uVar, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.f fVar;
        if (TextUtils.isEmpty(str) || (fVar = this.f42925d.get(str)) == null) {
            return;
        }
        fVar.a(j).b(downloadEventConfig).b(downloadController).a(uVar).a(iDownloadButtonClickListener).b(i);
    }

    public void a(com.ss.android.download.api.download.a.a aVar) {
        if (aVar != null) {
            if (com.ss.android.socialbase.downloader.g.a.c().b("fix_listener_oom", false)) {
                this.f42926e.add(new SoftReference(aVar));
            } else {
                this.f42926e.add(aVar);
            }
        }
    }

    public void a(final DownloadModel downloadModel, @Nullable final DownloadController downloadController, @Nullable final DownloadEventConfig downloadEventConfig) {
        this.f42923b.post(new Runnable() { // from class: com.ss.android.downloadlib.f.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.f42926e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).a(downloadModel, downloadController, downloadEventConfig);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadModel, downloadController, downloadEventConfig);
                        }
                    }
                }
            }
        });
    }

    public void a(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.f42923b.post(new Runnable() { // from class: com.ss.android.downloadlib.f.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.f42926e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).a(downloadInfo, baseException, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    public void a(final DownloadInfo downloadInfo, final String str) {
        this.f42923b.post(new Runnable() { // from class: com.ss.android.downloadlib.f.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.f42926e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).a(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void a(final DownloadInfo downloadInfo) {
        this.f42923b.post(new Runnable() { // from class: com.ss.android.downloadlib.f.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.f42926e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).a(downloadInfo);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadInfo);
                        }
                    }
                }
            }
        });
    }
}
