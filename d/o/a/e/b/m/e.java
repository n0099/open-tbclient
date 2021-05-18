package d.o.a.e.b.m;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes7.dex */
public class e extends a {
    public static d.o.a.e.b.k.d k;

    public e() {
        k = new d.o.a.e.b.k.d();
    }

    public static void S(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService B0 = d.o.a.e.b.g.d.B0();
        if (B0 != null) {
            B0.invokeAll(list);
        }
    }

    public static List<Future> T(List<Runnable> list) {
        ExecutorService B0 = d.o.a.e.b.g.d.B0();
        ArrayList arrayList = new ArrayList(list.size());
        for (Runnable runnable : list) {
            arrayList.add(B0.submit(runnable));
        }
        return arrayList;
    }

    public static Runnable U(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService B0 = d.o.a.e.b.g.d.B0();
                if ((B0 instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) B0).getQueue()) != null && !queue.isEmpty()) {
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
                d.o.a.e.b.c.a.i("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    @Override // d.o.a.e.b.m.a
    public d.o.a.e.b.k.c B(int i2) {
        d.o.a.e.b.k.d dVar = k;
        if (dVar == null) {
            return null;
        }
        return dVar.e(i2);
    }

    @Override // d.o.a.e.b.m.a
    public List<Integer> a() {
        return k.a();
    }

    @Override // d.o.a.e.b.m.a
    public void f(int i2, long j) {
        d.o.a.e.b.k.d dVar = k;
        if (dVar == null) {
            return;
        }
        dVar.b(i2, j);
    }

    @Override // d.o.a.e.b.m.a
    public void i(int i2, d.o.a.e.b.n.a aVar) {
        if (aVar == null) {
            return;
        }
        d.o.a.e.b.c.a.g("DownloadTask", "start doDownload for task : " + i2);
        k.c(new d.o.a.e.b.k.c(aVar, this.j));
    }

    @Override // d.o.a.e.b.m.a
    public void j(d.o.a.e.b.k.c cVar) {
        d.o.a.e.b.k.d dVar = k;
        if (dVar == null) {
            return;
        }
        dVar.g(cVar);
    }

    @Override // d.o.a.e.b.m.a
    public boolean p(int i2) {
        DownloadInfo D;
        d.o.a.e.b.k.d dVar = k;
        if (dVar == null || !dVar.d(i2) || (D = D(i2)) == null) {
            return false;
        }
        if (d.o.a.e.b.d.a.b(D.H0())) {
            return true;
        }
        t(i2);
        return false;
    }

    @Override // d.o.a.e.b.m.a
    public void t(int i2) {
        d.o.a.e.b.k.d dVar = k;
        if (dVar == null) {
            return;
        }
        dVar.h(i2);
    }
}
