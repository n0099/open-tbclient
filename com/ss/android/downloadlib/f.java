package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
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
/* loaded from: classes8.dex */
public class f {
    public static volatile f a;
    public long f;
    public final List c = new CopyOnWriteArrayList();
    public final Map d = new ConcurrentHashMap();
    public final CopyOnWriteArrayList e = new CopyOnWriteArrayList();
    public final Handler b = new Handler(Looper.getMainLooper());

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
        if (currentTimeMillis - this.f < 300000) {
            return;
        }
        this.f = currentTimeMillis;
        if (!this.c.isEmpty()) {
            d();
        }
    }

    public Handler b() {
        return this.b;
    }

    private synchronized void b(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.c.size() <= 0) {
            c(context, i, downloadStatusChangeListener, downloadModel);
        } else {
            com.ss.android.downloadlib.addownload.f fVar = (com.ss.android.downloadlib.addownload.f) this.c.remove(0);
            fVar.b(context).b(i, downloadStatusChangeListener).b(downloadModel).a();
            this.d.put(downloadModel.getDownloadUrl(), fVar);
        }
    }

    public void a(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel != null && !TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            com.ss.android.downloadlib.addownload.f fVar = (com.ss.android.downloadlib.addownload.f) this.d.get(downloadModel.getDownloadUrl());
            if (fVar != null) {
                fVar.b(context).b(i, downloadStatusChangeListener).b(downloadModel).a();
            } else if (!this.c.isEmpty()) {
                b(context, i, downloadStatusChangeListener, downloadModel);
            } else {
                c(context, i, downloadStatusChangeListener, downloadModel);
            }
        }
    }

    private void c(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.e eVar = new com.ss.android.downloadlib.addownload.e();
        eVar.b(context).b(i, downloadStatusChangeListener).b(downloadModel).a();
        this.d.put(downloadModel.getDownloadUrl(), eVar);
    }

    private void d() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.f fVar : this.c) {
            if (!fVar.b() && currentTimeMillis - fVar.d() > 300000) {
                fVar.h();
                arrayList.add(fVar);
            }
        }
        if (!arrayList.isEmpty()) {
            this.c.removeAll(arrayList);
        }
    }

    public com.ss.android.downloadlib.addownload.e a(String str) {
        Map map = this.d;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            com.ss.android.downloadlib.addownload.f fVar = (com.ss.android.downloadlib.addownload.f) this.d.get(str);
            if (fVar instanceof com.ss.android.downloadlib.addownload.e) {
                return (com.ss.android.downloadlib.addownload.e) fVar;
            }
        }
        return null;
    }

    public void a(final DownloadModel downloadModel, final DownloadController downloadController, final DownloadEventConfig downloadEventConfig) {
        this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.f.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.e.iterator();
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

    public void a(com.ss.android.download.api.download.a.a aVar) {
        if (aVar != null) {
            if (com.ss.android.socialbase.downloader.g.a.c().b("fix_listener_oom", false)) {
                this.e.add(new SoftReference(aVar));
            } else {
                this.e.add(aVar);
            }
        }
    }

    public void a(final DownloadInfo downloadInfo) {
        this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.f.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.e.iterator();
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

    public void a(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.f.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.e.iterator();
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
        this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.f.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.e.iterator();
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

    public void b(final DownloadInfo downloadInfo, final String str) {
        this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.f.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.e.iterator();
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

    public void a(String str, int i) {
        com.ss.android.downloadlib.addownload.f fVar;
        if (!TextUtils.isEmpty(str) && (fVar = (com.ss.android.downloadlib.addownload.f) this.d.get(str)) != null) {
            if (fVar.a(i)) {
                this.c.add(fVar);
                this.d.remove(str);
            }
            c();
        }
    }

    public void a(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        a(str, j, i, downloadEventConfig, downloadController, null, null);
    }

    public void a(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        a(str, j, i, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void a(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.f fVar;
        if (!TextUtils.isEmpty(str) && (fVar = (com.ss.android.downloadlib.addownload.f) this.d.get(str)) != null) {
            fVar.a(j).b(downloadEventConfig).b(downloadController).a(onItemClickListener).a(iDownloadButtonClickListener).b(i);
        }
    }

    public void a(String str, boolean z) {
        com.ss.android.downloadlib.addownload.f fVar;
        if (!TextUtils.isEmpty(str) && (fVar = (com.ss.android.downloadlib.addownload.f) this.d.get(str)) != null) {
            fVar.a(z);
        }
    }
}
