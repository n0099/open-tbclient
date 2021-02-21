package com.ss.android.socialbase.downloader.impls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes6.dex */
public class e extends a {
    private static com.ss.android.socialbase.downloader.l.d qhh;

    public static void c(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService eGo = com.ss.android.socialbase.downloader.downloader.b.eGo();
        if (eGo != null) {
            eGo.invokeAll(list);
        }
    }

    public static List<Future> hb(List<Runnable> list) {
        ExecutorService eGo = com.ss.android.socialbase.downloader.downloader.b.eGo();
        ArrayList arrayList = new ArrayList(list.size());
        for (Runnable runnable : list) {
            arrayList.add(eGo.submit(runnable));
        }
        return arrayList;
    }

    public e() {
        qhh = new com.ss.android.socialbase.downloader.l.d();
    }

    public static Runnable hc(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            ExecutorService eGo = com.ss.android.socialbase.downloader.downloader.b.eGo();
            if ((eGo instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) eGo).getQueue()) != null && !queue.isEmpty()) {
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
            com.ss.android.socialbase.downloader.f.a.d("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public boolean a(int i) {
        com.ss.android.socialbase.downloader.g.c RQ;
        if (qhh == null || !qhh.a(i) || (RQ = RQ(i)) == null) {
            return false;
        }
        if (!com.ss.android.socialbase.downloader.b.f.b(RQ.q())) {
            b(i);
            return false;
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(com.ss.android.socialbase.downloader.l.c cVar) {
        if (qhh != null) {
            qhh.b(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null) {
            com.ss.android.socialbase.downloader.f.a.b("DownloadTask", "start doDownload for task : " + i);
            qhh.a(new com.ss.android.socialbase.downloader.l.c(dVar, this.qgW));
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void b(int i) {
        if (qhh != null) {
            qhh.c(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    protected com.ss.android.socialbase.downloader.l.c RP(int i) {
        if (qhh == null) {
            return null;
        }
        return qhh.RZ(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List<Integer> a() {
        return qhh.a();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, long j) {
        if (qhh != null) {
            qhh.a(i, j);
        }
    }
}
