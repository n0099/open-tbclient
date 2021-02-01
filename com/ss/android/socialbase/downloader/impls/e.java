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
    private static com.ss.android.socialbase.downloader.l.d qgH;

    public static void c(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService eGg = com.ss.android.socialbase.downloader.downloader.b.eGg();
        if (eGg != null) {
            eGg.invokeAll(list);
        }
    }

    public static List<Future> hb(List<Runnable> list) {
        ExecutorService eGg = com.ss.android.socialbase.downloader.downloader.b.eGg();
        ArrayList arrayList = new ArrayList(list.size());
        for (Runnable runnable : list) {
            arrayList.add(eGg.submit(runnable));
        }
        return arrayList;
    }

    public e() {
        qgH = new com.ss.android.socialbase.downloader.l.d();
    }

    public static Runnable hc(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            ExecutorService eGg = com.ss.android.socialbase.downloader.downloader.b.eGg();
            if ((eGg instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) eGg).getQueue()) != null && !queue.isEmpty()) {
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
        com.ss.android.socialbase.downloader.g.c RP;
        if (qgH == null || !qgH.a(i) || (RP = RP(i)) == null) {
            return false;
        }
        if (!com.ss.android.socialbase.downloader.b.f.b(RP.q())) {
            b(i);
            return false;
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(com.ss.android.socialbase.downloader.l.c cVar) {
        if (qgH != null) {
            qgH.b(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null) {
            com.ss.android.socialbase.downloader.f.a.b("DownloadTask", "start doDownload for task : " + i);
            qgH.a(new com.ss.android.socialbase.downloader.l.c(dVar, this.qgw));
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void b(int i) {
        if (qgH != null) {
            qgH.c(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    protected com.ss.android.socialbase.downloader.l.c RO(int i) {
        if (qgH == null) {
            return null;
        }
        return qgH.RY(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List<Integer> a() {
        return qgH.a();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, long j) {
        if (qgH != null) {
            qgH.a(i, j);
        }
    }
}
