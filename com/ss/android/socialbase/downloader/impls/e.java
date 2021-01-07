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
    private static com.ss.android.socialbase.downloader.l.d qbd;

    public static void c(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService eHF = com.ss.android.socialbase.downloader.downloader.b.eHF();
        if (eHF != null) {
            eHF.invokeAll(list);
        }
    }

    public static List<Future> hd(List<Runnable> list) {
        ExecutorService eHF = com.ss.android.socialbase.downloader.downloader.b.eHF();
        ArrayList arrayList = new ArrayList(list.size());
        for (Runnable runnable : list) {
            arrayList.add(eHF.submit(runnable));
        }
        return arrayList;
    }

    public e() {
        qbd = new com.ss.android.socialbase.downloader.l.d();
    }

    public static Runnable he(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            ExecutorService eHF = com.ss.android.socialbase.downloader.downloader.b.eHF();
            if ((eHF instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) eHF).getQueue()) != null && !queue.isEmpty()) {
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
        com.ss.android.socialbase.downloader.g.c Tb;
        if (qbd == null || !qbd.a(i) || (Tb = Tb(i)) == null) {
            return false;
        }
        if (!com.ss.android.socialbase.downloader.b.f.b(Tb.q())) {
            b(i);
            return false;
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(com.ss.android.socialbase.downloader.l.c cVar) {
        if (qbd != null) {
            qbd.b(cVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, com.ss.android.socialbase.downloader.g.d dVar) {
        if (dVar != null) {
            com.ss.android.socialbase.downloader.f.a.b("DownloadTask", "start doDownload for task : " + i);
            qbd.a(new com.ss.android.socialbase.downloader.l.c(dVar, this.qaS));
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void b(int i) {
        if (qbd != null) {
            qbd.c(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    protected com.ss.android.socialbase.downloader.l.c Ta(int i) {
        if (qbd == null) {
            return null;
        }
        return qbd.Tk(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List<Integer> a() {
        return qbd.a();
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i, long j) {
        if (qbd != null) {
            qbd.a(i, j);
        }
    }
}
