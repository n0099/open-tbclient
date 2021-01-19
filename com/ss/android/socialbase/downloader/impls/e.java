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
    private static com.ss.android.socialbase.downloader.l.d pWD;

    public static void c(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService eDP = com.ss.android.socialbase.downloader.downloader.b.eDP();
        if (eDP != null) {
            eDP.invokeAll(list);
        }
    }

    public static List<Future> hd(List<Runnable> list) {
        ExecutorService eDP = com.ss.android.socialbase.downloader.downloader.b.eDP();
        ArrayList arrayList = new ArrayList(list.size());
        for (Runnable runnable : list) {
            arrayList.add(eDP.submit(runnable));
        }
        return arrayList;
    }

    public e() {
        pWD = new com.ss.android.socialbase.downloader.l.d();
    }

    public static Runnable he(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            ExecutorService eDP = com.ss.android.socialbase.downloader.downloader.b.eDP();
            if ((eDP instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) eDP).getQueue()) != null && !queue.isEmpty()) {
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
        com.ss.android.socialbase.downloader.g.c Ru;
        if (pWD == null || !pWD.a(i) || (Ru = Ru(i)) == null) {
            return false;
        }
        if (!com.ss.android.socialbase.downloader.b.f.b(Ru.q())) {
            b(i);
            return false;
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(com.ss.android.socialbase.downloader.l.c cVar) {
        if (pWD != null) {
            pWD.b(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null) {
            com.ss.android.socialbase.downloader.f.a.b("DownloadTask", "start doDownload for task : " + i);
            pWD.a(new com.ss.android.socialbase.downloader.l.c(dVar, this.pWs));
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void b(int i) {
        if (pWD != null) {
            pWD.c(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    protected com.ss.android.socialbase.downloader.l.c Rt(int i) {
        if (pWD == null) {
            return null;
        }
        return pWD.RD(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List<Integer> a() {
        return pWD.a();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, long j) {
        if (pWD != null) {
            pWD.a(i, j);
        }
    }
}
