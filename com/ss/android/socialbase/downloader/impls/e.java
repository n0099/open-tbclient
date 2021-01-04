package com.ss.android.socialbase.downloader.impls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes4.dex */
public class e extends a {
    private static com.ss.android.socialbase.downloader.l.d pZv;

    public static void c(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService eHb = com.ss.android.socialbase.downloader.downloader.b.eHb();
        if (eHb != null) {
            eHb.invokeAll(list);
        }
    }

    public static List<Future> hc(List<Runnable> list) {
        ExecutorService eHb = com.ss.android.socialbase.downloader.downloader.b.eHb();
        ArrayList arrayList = new ArrayList(list.size());
        for (Runnable runnable : list) {
            arrayList.add(eHb.submit(runnable));
        }
        return arrayList;
    }

    public e() {
        pZv = new com.ss.android.socialbase.downloader.l.d();
    }

    public static Runnable hd(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            ExecutorService eHb = com.ss.android.socialbase.downloader.downloader.b.eHb();
            if ((eHb instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) eHb).getQueue()) != null && !queue.isEmpty()) {
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
        com.ss.android.socialbase.downloader.g.c SL;
        if (pZv == null || !pZv.a(i) || (SL = SL(i)) == null) {
            return false;
        }
        if (!com.ss.android.socialbase.downloader.b.f.b(SL.q())) {
            b(i);
            return false;
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(com.ss.android.socialbase.downloader.l.c cVar) {
        if (pZv != null) {
            pZv.b(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null) {
            com.ss.android.socialbase.downloader.f.a.b("DownloadTask", "start doDownload for task : " + i);
            pZv.a(new com.ss.android.socialbase.downloader.l.c(dVar, this.pZk));
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void b(int i) {
        if (pZv != null) {
            pZv.c(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    protected com.ss.android.socialbase.downloader.l.c SK(int i) {
        if (pZv == null) {
            return null;
        }
        return pZv.SU(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List<Integer> a() {
        return pZv.a();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, long j) {
        if (pZv != null) {
            pZv.a(i, j);
        }
    }
}
