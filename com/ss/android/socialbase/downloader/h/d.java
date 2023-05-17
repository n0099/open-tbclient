package com.ss.android.socialbase.downloader.h;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class d {
    public static ExecutorService a = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("Download_OP_Thread"));
    public int c = 0;
    public volatile SparseArray<c> b = new SparseArray<>();

    public static void a(Runnable runnable) {
        a.execute(runnable);
    }

    public c b(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.b.get(i);
            if (cVar != null) {
                cVar.b();
                c(cVar);
                this.b.remove(i);
                return cVar;
            }
            return null;
        }
    }

    public void c(int i) {
        synchronized (d.class) {
            b();
            c cVar = this.b.get(i);
            if (cVar != null) {
                cVar.a();
                c(cVar);
                this.b.remove(i);
            }
        }
    }

    private void b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.b.size(); i++) {
                int keyAt = this.b.keyAt(i);
                if (!this.b.get(keyAt).d()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Integer num = (Integer) arrayList.get(i2);
                if (num != null) {
                    this.b.remove(num.intValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(c cVar) {
        Future g;
        if (cVar == null) {
            return;
        }
        try {
            ExecutorService p = com.ss.android.socialbase.downloader.downloader.c.p();
            DownloadTask c = cVar.c();
            if (c != null && c.getDownloadInfo() != null) {
                int executorGroup = c.getDownloadInfo().getExecutorGroup();
                if (executorGroup != 3) {
                    if (executorGroup == 4) {
                        p = com.ss.android.socialbase.downloader.downloader.c.o();
                    }
                } else {
                    p = com.ss.android.socialbase.downloader.downloader.c.n();
                }
            }
            if (p != null && (p instanceof ThreadPoolExecutor)) {
                ((ThreadPoolExecutor) p).remove(cVar);
                if (com.ss.android.socialbase.downloader.g.a.a(cVar.e()).b("pause_with_interrupt", false) && (g = cVar.g()) != null) {
                    g.cancel(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Integer> a() {
        ArrayList arrayList;
        synchronized (d.class) {
            b();
            arrayList = new ArrayList();
            for (int i = 0; i < this.b.size(); i++) {
                c cVar = this.b.get(this.b.keyAt(i));
                if (cVar != null) {
                    arrayList.add(Integer.valueOf(cVar.e()));
                }
            }
        }
        return arrayList;
    }

    public void a(int i, long j) {
        c cVar = this.b.get(i);
        if (cVar != null) {
            cVar.c(j);
        }
    }

    public void a(c cVar) {
        int i;
        int i2;
        cVar.f();
        synchronized (d.class) {
            i = 0;
            if (this.c >= 500) {
                b();
                this.c = 0;
            } else {
                this.c++;
            }
            this.b.put(cVar.e(), cVar);
        }
        DownloadTask c = cVar.c();
        try {
            ExecutorService p = com.ss.android.socialbase.downloader.downloader.c.p();
            if (c != null && c.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(c.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.g.a.c().a("divide_plugin", 1) == 1) {
                    c.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = c.getDownloadInfo().getExecutorGroup();
                if (executorGroup != 3) {
                    if (executorGroup == 4) {
                        p = com.ss.android.socialbase.downloader.downloader.c.o();
                    }
                } else {
                    p = com.ss.android.socialbase.downloader.downloader.c.n();
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
            x monitorDepend = c.getMonitorDepend();
            DownloadInfo downloadInfo = c.getDownloadInfo();
            BaseException baseException = new BaseException(1003, "execute failed cpu thread executor service is null");
            if (c.getDownloadInfo() != null) {
                i2 = c.getDownloadInfo().getStatus();
            } else {
                i2 = 0;
            }
            com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, baseException, i2);
        } catch (Exception e) {
            if (c != null) {
                x monitorDepend2 = c.getMonitorDepend();
                DownloadInfo downloadInfo2 = c.getDownloadInfo();
                BaseException baseException2 = new BaseException(1003, com.ss.android.socialbase.downloader.i.f.b(e, "DownloadThreadPoolExecute"));
                if (c.getDownloadInfo() != null) {
                    i = c.getDownloadInfo().getStatus();
                }
                com.ss.android.socialbase.downloader.d.a.a(monitorDepend2, downloadInfo2, baseException2, i);
            }
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            if (c != null) {
                x monitorDepend3 = c.getMonitorDepend();
                DownloadInfo downloadInfo3 = c.getDownloadInfo();
                BaseException baseException3 = new BaseException(1003, "execute OOM");
                if (c.getDownloadInfo() != null) {
                    i = c.getDownloadInfo().getStatus();
                }
                com.ss.android.socialbase.downloader.d.a.a(monitorDepend3, downloadInfo3, baseException3, i);
            }
            e2.printStackTrace();
        }
    }

    public boolean a(int i) {
        synchronized (d.class) {
            boolean z = false;
            if (this.b != null && this.b.size() > 0) {
                c cVar = this.b.get(i);
                if (cVar != null && cVar.d()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        synchronized (d.class) {
            try {
                if (com.ss.android.socialbase.downloader.i.a.a(524288)) {
                    int indexOfValue = this.b.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.b.removeAt(indexOfValue);
                    }
                } else {
                    this.b.remove(cVar.e());
                }
            }
        }
    }
}
