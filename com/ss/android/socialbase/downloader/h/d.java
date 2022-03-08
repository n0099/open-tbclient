package com.ss.android.socialbase.downloader.h;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class d {
    public static ExecutorService a = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("Download_OP_Thread"));

    /* renamed from: c  reason: collision with root package name */
    public int f58654c = 0;

    /* renamed from: b  reason: collision with root package name */
    public volatile SparseArray<c> f58653b = new SparseArray<>();

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }

    private void b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f58653b.size(); i2++) {
                int keyAt = this.f58653b.keyAt(i2);
                if (!this.f58653b.get(keyAt).d()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Integer num = (Integer) arrayList.get(i3);
                if (num != null) {
                    this.f58653b.remove(num.intValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(int i2) {
        synchronized (d.class) {
            b();
            c cVar = this.f58653b.get(i2);
            if (cVar != null) {
                cVar.a();
                c(cVar);
                this.f58653b.remove(i2);
            }
        }
    }

    public void a(c cVar) {
        cVar.f();
        synchronized (d.class) {
            if (this.f58654c >= 500) {
                b();
                this.f58654c = 0;
            } else {
                this.f58654c++;
            }
            this.f58653b.put(cVar.e(), cVar);
        }
        DownloadTask c2 = cVar.c();
        try {
            ExecutorService p = com.ss.android.socialbase.downloader.downloader.c.p();
            if (c2 != null && c2.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(c2.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.g.a.c().a("divide_plugin", 1) == 1) {
                    c2.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = c2.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    p = com.ss.android.socialbase.downloader.downloader.c.n();
                } else if (executorGroup == 4) {
                    p = com.ss.android.socialbase.downloader.downloader.c.o();
                }
            }
            if (p != null) {
                if (com.ss.android.socialbase.downloader.g.a.a(cVar.e()).b("pause_with_interrupt", false)) {
                    cVar.a(p.submit(cVar));
                    return;
                } else {
                    p.execute(cVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.d.a.a(c2.getMonitorDepend(), c2.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), c2.getDownloadInfo() != null ? c2.getDownloadInfo().getStatus() : 0);
        } catch (Exception e2) {
            if (c2 != null) {
                com.ss.android.socialbase.downloader.d.a.a(c2.getMonitorDepend(), c2.getDownloadInfo(), new BaseException(1003, com.ss.android.socialbase.downloader.i.f.b(e2, "DownloadThreadPoolExecute")), c2.getDownloadInfo() != null ? c2.getDownloadInfo().getStatus() : 0);
            }
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            if (c2 != null) {
                com.ss.android.socialbase.downloader.d.a.a(c2.getMonitorDepend(), c2.getDownloadInfo(), new BaseException(1003, "execute OOM"), c2.getDownloadInfo() != null ? c2.getDownloadInfo().getStatus() : 0);
            }
            e3.printStackTrace();
        }
    }

    private void c(c cVar) {
        Future g2;
        if (cVar == null) {
            return;
        }
        try {
            ExecutorService p = com.ss.android.socialbase.downloader.downloader.c.p();
            DownloadTask c2 = cVar.c();
            if (c2 != null && c2.getDownloadInfo() != null) {
                int executorGroup = c2.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    p = com.ss.android.socialbase.downloader.downloader.c.n();
                } else if (executorGroup == 4) {
                    p = com.ss.android.socialbase.downloader.downloader.c.o();
                }
            }
            if (p == null || !(p instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) p).remove(cVar);
            if (!com.ss.android.socialbase.downloader.g.a.a(cVar.e()).b("pause_with_interrupt", false) || (g2 = cVar.g()) == null) {
                return;
            }
            g2.cancel(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        synchronized (d.class) {
            try {
                if (com.ss.android.socialbase.downloader.i.a.a(524288)) {
                    int indexOfValue = this.f58653b.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.f58653b.removeAt(indexOfValue);
                    }
                } else {
                    this.f58653b.remove(cVar.e());
                }
            }
        }
    }

    public c b(int i2) {
        synchronized (d.class) {
            b();
            c cVar = this.f58653b.get(i2);
            if (cVar != null) {
                cVar.b();
                c(cVar);
                this.f58653b.remove(i2);
                return cVar;
            }
            return null;
        }
    }

    public boolean a(int i2) {
        synchronized (d.class) {
            boolean z = false;
            if (this.f58653b != null && this.f58653b.size() > 0) {
                c cVar = this.f58653b.get(i2);
                if (cVar != null && cVar.d()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public List<Integer> a() {
        ArrayList arrayList;
        synchronized (d.class) {
            b();
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f58653b.size(); i2++) {
                c cVar = this.f58653b.get(this.f58653b.keyAt(i2));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.e()));
                }
            }
        }
        return arrayList;
    }

    public void a(int i2, long j2) {
        c cVar = this.f58653b.get(i2);
        if (cVar != null) {
            cVar.c(j2);
        }
    }
}
