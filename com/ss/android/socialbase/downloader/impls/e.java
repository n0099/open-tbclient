package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public static com.ss.android.socialbase.downloader.h.d f60157b;

    public e() {
        f60157b = new com.ss.android.socialbase.downloader.h.d();
    }

    public static void c(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService q = com.ss.android.socialbase.downloader.downloader.c.q();
        if (q != null) {
            q.invokeAll(list);
        }
    }

    public static List<Future> d(List<Runnable> list) {
        ExecutorService q = com.ss.android.socialbase.downloader.downloader.c.q();
        ArrayList arrayList = new ArrayList(list.size());
        for (Runnable runnable : list) {
            arrayList.add(q.submit(runnable));
        }
        return arrayList;
    }

    public static Runnable e(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService q = com.ss.android.socialbase.downloader.downloader.c.q();
                if ((q instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) q).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = it.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public boolean a(int i2) {
        DownloadInfo d2;
        com.ss.android.socialbase.downloader.h.d dVar = f60157b;
        if (dVar == null || !dVar.a(i2) || (d2 = d(i2)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(d2.getStatus())) {
            return true;
        }
        b(i2);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void b(int i2) {
        com.ss.android.socialbase.downloader.h.d dVar = f60157b;
        if (dVar == null) {
            return;
        }
        dVar.c(i2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public com.ss.android.socialbase.downloader.h.c c(int i2) {
        com.ss.android.socialbase.downloader.h.d dVar = f60157b;
        if (dVar == null) {
            return null;
        }
        return dVar.b(i2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(com.ss.android.socialbase.downloader.h.c cVar) {
        com.ss.android.socialbase.downloader.h.d dVar = f60157b;
        if (dVar == null) {
            return;
        }
        dVar.b(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i2, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b("DownloadTask", "start doDownload for task : " + i2);
        f60157b.a(new com.ss.android.socialbase.downloader.h.c(downloadTask, this.a));
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List<Integer> a() {
        return f60157b.a();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i2, long j2) {
        com.ss.android.socialbase.downloader.h.d dVar = f60157b;
        if (dVar == null) {
            return;
        }
        dVar.a(i2, j2);
    }
}
