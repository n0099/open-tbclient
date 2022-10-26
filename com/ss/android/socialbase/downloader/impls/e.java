package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes8.dex */
public class e extends a {
    public static com.ss.android.socialbase.downloader.h.d b;

    public e() {
        b = new com.ss.android.socialbase.downloader.h.d();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List a() {
        return b.a();
    }

    public static void c(List list) throws InterruptedException {
        ExecutorService q = com.ss.android.socialbase.downloader.downloader.c.q();
        if (q != null) {
            q.invokeAll(list);
        }
    }

    public static List d(List list) {
        ExecutorService q = com.ss.android.socialbase.downloader.downloader.c.q();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(q.submit((Runnable) it.next()));
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(com.ss.android.socialbase.downloader.h.c cVar) {
        com.ss.android.socialbase.downloader.h.d dVar = b;
        if (dVar == null) {
            return;
        }
        dVar.b(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void b(int i) {
        com.ss.android.socialbase.downloader.h.d dVar = b;
        if (dVar == null) {
            return;
        }
        dVar.c(i);
    }

    public static Runnable e(List list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService q = com.ss.android.socialbase.downloader.downloader.c.q();
                if ((q instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) q).getQueue()) != null && !queue.isEmpty()) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Future future = (Future) it.next();
                            if ((future instanceof Runnable) && queue.remove(future)) {
                                runnable = (Runnable) future;
                                break;
                            }
                        } else {
                            runnable = null;
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
    public void a(int i, long j) {
        com.ss.android.socialbase.downloader.h.d dVar = b;
        if (dVar == null) {
            return;
        }
        dVar.a(i, j);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b("DownloadTask", "start doDownload for task : " + i);
        b.a(new com.ss.android.socialbase.downloader.h.c(downloadTask, this.a));
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public boolean a(int i) {
        DownloadInfo d;
        com.ss.android.socialbase.downloader.h.d dVar = b;
        if (dVar == null || !dVar.a(i) || (d = d(i)) == null) {
            return false;
        }
        if (!DownloadStatus.isDownloading(d.getStatus())) {
            b(i);
            return false;
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public com.ss.android.socialbase.downloader.h.c c(int i) {
        com.ss.android.socialbase.downloader.h.d dVar = b;
        if (dVar == null) {
            return null;
        }
        return dVar.b(i);
    }
}
