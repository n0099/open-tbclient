package d.b.b.e.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class a implements Executor {
    public static a o;
    public static final ThreadFactory p = new ThreadFactoryC0533a();
    public static final BlockingQueue<Runnable> q = new SynchronousQueue();
    public static final Executor r = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, q, p, new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: e  reason: collision with root package name */
    public volatile int f41659e = 0;

    /* renamed from: f  reason: collision with root package name */
    public volatile int f41660f = 0;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f41661g = 0;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f41662h = 0;
    public final SparseIntArray i = new SparseIntArray();
    public final LinkedList<d> j = new LinkedList<>();
    public final LinkedList<d> k = new LinkedList<>();
    public final LinkedList<d> l = new LinkedList<>();
    public HandlerThread m;
    public Handler n;

    /* renamed from: d.b.b.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ThreadFactoryC0533a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f41663e = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            String str = "BdAsyncTask #" + String.valueOf(this.f41663e.getAndIncrement());
            BdLog.i(str);
            return new Thread(runnable, str);
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                Object obj2 = message.obj;
                if (obj2 == null || !(obj2 instanceof d)) {
                    return;
                }
                a.this.y((d) obj2);
            } else if (i == 2 && (obj = message.obj) != null && (obj instanceof d)) {
                a.this.p((d) obj);
                BdBaseApplication.getInst().isDebugMode();
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends d {
        public c(d.b.b.e.c.b bVar) {
            super(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    if (g() == 4) {
                        Process.setThreadPriority(-2);
                    } else if (g() == 3) {
                        Process.setThreadPriority(-1);
                    } else if (g() == 2) {
                        Process.setThreadPriority(0);
                    } else {
                        Process.setThreadPriority(10);
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                l();
            } finally {
                if (!k()) {
                    a.this.n.sendMessageDelayed(a.this.n.obtainMessage(2, this), 1L);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.b.e.c.b<?> f41666e;

        public d(d.b.b.e.c.b<?> bVar) {
            this.f41666e = null;
            if (bVar != null && bVar.b() != null) {
                this.f41666e = bVar;
                return;
            }
            throw new InvalidParameterException("parameter is null");
        }

        public boolean a() {
            return this.f41666e.b().isTimeout();
        }

        public void b() {
            this.f41666e.a();
        }

        public int c() {
            if (this.f41666e.b().getParallel() != null) {
                return this.f41666e.b().getParallel().a();
            }
            return 1;
        }

        public String d() {
            return this.f41666e.b().getKey();
        }

        public int e() {
            if (this.f41666e.b().getParallel() != null) {
                return this.f41666e.b().getParallel().b();
            }
            return 0;
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType f() {
            if (this.f41666e.b().getParallel() != null) {
                return this.f41666e.b().getParallel().c();
            }
            return BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int g() {
            return this.f41666e.b().getPriority();
        }

        public int h() {
            return this.f41666e.b().getTag();
        }

        public BdAsyncTask<?, ?, ?> i() {
            return this.f41666e.b();
        }

        public boolean j() {
            return this.f41666e.isCancelled();
        }

        public boolean k() {
            return this.f41666e.b().isSelfExecute();
        }

        public void l() {
            try {
                this.f41666e.run();
            } catch (OutOfMemoryError unused) {
                BdBaseApplication.getInst().onAppMemoryLow();
            }
        }

        public void m(boolean z) {
            this.f41666e.b().setTimeout(z);
        }
    }

    public a() {
        this.m = null;
        this.n = null;
        HandlerThread handlerThread = new HandlerThread("BdAsyncTaskExecutor");
        this.m = handlerThread;
        handlerThread.start();
        this.n = new b(this.m.getLooper());
    }

    public static a e() {
        if (o == null) {
            synchronized (a.class) {
                if (o == null) {
                    o = new a();
                }
            }
        }
        return o;
    }

    public final boolean c(int i, d dVar) {
        if (dVar == null) {
            return false;
        }
        BdAsyncTaskParallel.BdAsyncTaskParallelType f2 = dVar.f();
        if (f2 == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL) {
            if (i < 1) {
                return true;
            }
        } else if (f2 == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL) {
            if (i < 2) {
                return true;
            }
        } else if (f2 == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL) {
            if (i < 3) {
                return true;
            }
        } else if (f2 == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL) {
            if (i < 4) {
                return true;
            }
        } else if (f2 != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < dVar.c()) {
            return true;
        }
        return false;
    }

    public final synchronized void d(d dVar) {
        if (dVar == null) {
            return;
        }
        this.k.add(dVar);
        this.j.remove(dVar);
        r.execute(dVar);
        this.n.sendMessageDelayed(this.n.obtainMessage(1, dVar), 180000L);
        int g2 = dVar.g();
        if (g2 == 1) {
            this.f41662h++;
        } else if (g2 == 2) {
            this.f41661g++;
        } else if (g2 == 3) {
            this.f41660f++;
        } else if (g2 == 4) {
            this.f41659e++;
            if (this.f41659e >= 7) {
                BdLog.e("SuperHight Task too much num = " + this.f41659e);
            }
        }
        int e2 = dVar.e();
        if (e2 != 0) {
            this.i.put(e2, this.i.get(e2, 0) + 1);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof d.b.b.e.c.b) {
            c cVar = new c((d.b.b.e.c.b) runnable);
            if (cVar.k()) {
                new Thread(cVar).start();
                return;
            }
            h(cVar);
            p(null);
            BdBaseApplication.getInst().isDebugMode();
        }
    }

    public final synchronized int f(LinkedList<d> linkedList, String str, BdUniqueId bdUniqueId) {
        int i = 0;
        if (linkedList == null || bdUniqueId == null) {
            return 0;
        }
        int id = bdUniqueId.getId();
        Iterator<d> it = linkedList.iterator();
        while (it.hasNext()) {
            d next = it.next();
            int h2 = next.h();
            String d2 = next.d();
            if ((str != null && h2 == id && str.equals(d2)) || (str == null && id != 0 && h2 == id)) {
                if (next.i() != null && !next.i().isCancelled()) {
                    i++;
                }
            }
        }
        return i;
    }

    public int g(String str, BdUniqueId bdUniqueId) {
        return f(this.j, str, bdUniqueId) + f(this.k, str, bdUniqueId) + f(this.l, str, bdUniqueId);
    }

    public final synchronized void h(d dVar) {
        if (dVar == null) {
            return;
        }
        int size = this.j.size();
        int i = 0;
        while (i < size && this.j.get(i).g() >= dVar.g()) {
            i++;
        }
        this.j.add(i, dVar);
    }

    public synchronized void i(BdUniqueId bdUniqueId) {
        j(bdUniqueId, null);
    }

    public synchronized void j(BdUniqueId bdUniqueId, String str) {
        l(bdUniqueId, str);
        n(this.k, false, bdUniqueId, str);
        n(this.l, false, bdUniqueId, str);
    }

    public synchronized void k(BdUniqueId bdUniqueId) {
        l(bdUniqueId, null);
    }

    public synchronized void l(BdUniqueId bdUniqueId, String str) {
        n(this.j, true, bdUniqueId, str);
    }

    public final synchronized void m(d dVar) {
        if (dVar == null) {
            return;
        }
        if (dVar.a()) {
            this.l.remove(dVar);
        } else {
            this.k.remove(dVar);
            this.n.removeMessages(1, dVar);
            int g2 = dVar.g();
            if (g2 == 1) {
                this.f41662h--;
            } else if (g2 == 2) {
                this.f41661g--;
            } else if (g2 == 3) {
                this.f41660f--;
            } else if (g2 == 4) {
                this.f41659e--;
            }
            int e2 = dVar.e();
            if (e2 != 0) {
                int i = this.i.get(e2) - 1;
                if (i <= 0) {
                    this.i.delete(e2);
                } else {
                    this.i.put(e2, i);
                }
                if (i < 0) {
                    BdLog.e("removeTask error < 0");
                }
            }
        }
    }

    public final synchronized void n(LinkedList<d> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId == null) {
            return;
        }
        int id = bdUniqueId.getId();
        Iterator<d> it = linkedList.iterator();
        while (it.hasNext()) {
            d next = it.next();
            int h2 = next.h();
            String d2 = next.d();
            if ((str != null && h2 == id && str.equals(d2)) || (str == null && id != 0 && h2 == id)) {
                if (z) {
                    it.remove();
                }
                next.b();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        r0.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void o(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        Iterator<d> it = this.j.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next != null && next.i() == bdAsyncTask) {
                break;
            }
        }
    }

    public synchronized void p(d dVar) {
        m(dVar);
        for (int i = 0; i < this.j.size(); i++) {
            d dVar2 = this.j.get(i);
            if (dVar2 != null) {
                int e2 = dVar2.e();
                int g2 = dVar2.g();
                if (g2 != 1) {
                    if (g2 != 2) {
                        if (g2 != 3) {
                            if (g2 == 4 && e2 == 0) {
                                d(dVar2);
                                return;
                            }
                        } else if (this.f41660f + this.f41661g + this.f41662h >= 7) {
                            return;
                        }
                    } else if (this.f41660f + this.f41661g + this.f41662h >= 6) {
                        return;
                    }
                } else if (this.f41660f + this.f41661g + this.f41662h >= 5) {
                    return;
                }
                if (c(this.i.get(e2), dVar2)) {
                    d(dVar2);
                    return;
                }
            }
        }
    }

    public synchronized BdAsyncTask<?, ?, ?> q(String str) {
        return v(this.k, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> r(BdUniqueId bdUniqueId) {
        return s(bdUniqueId, null);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> s(BdUniqueId bdUniqueId, String str) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> t = t(this.j, bdUniqueId, str);
        if (t != null) {
            linkedList.addAll(t);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> t2 = t(this.k, bdUniqueId, str);
        if (t2 != null) {
            linkedList.addAll(t2);
        }
        LinkedList<BdAsyncTask<?, ?, ?>> t3 = t(this.l, bdUniqueId, str);
        if (t3 != null) {
            linkedList.addAll(t3);
        }
        return linkedList;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> t(LinkedList<d> linkedList, BdUniqueId bdUniqueId, String str) {
        if (linkedList == null || bdUniqueId == null) {
            return null;
        }
        int id = bdUniqueId.getId();
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList2 = new LinkedList<>();
        Iterator<d> it = linkedList.iterator();
        while (it.hasNext()) {
            d next = it.next();
            int h2 = next.h();
            String d2 = next.d();
            if ((str != null && h2 == id && str.equals(d2)) || (str == null && id != 0 && h2 == id)) {
                if (next.i() != null && !next.i().isCancelled()) {
                    linkedList2.add(next.i());
                }
            }
        }
        return linkedList2;
    }

    public String toString() {
        return "mWaitingTasks = " + this.j.size() + " mRunningTasks = " + this.k.size() + " mTimeOutTasks = " + this.l.size();
    }

    public synchronized BdAsyncTask<?, ?, ?> u(String str) {
        BdAsyncTask<?, ?, ?> v;
        v = v(this.j, str);
        if (v == null) {
            v = v(this.k, str);
        }
        if (v == null) {
            v = v(this.l, str);
        }
        return v;
    }

    public synchronized BdAsyncTask<?, ?, ?> v(LinkedList<d> linkedList, String str) {
        if (linkedList == null || str == null) {
            return null;
        }
        Iterator<d> it = linkedList.iterator();
        while (it.hasNext()) {
            d next = it.next();
            String d2 = next.d();
            if (d2 != null && d2.equals(str) && !next.i().isCancelled()) {
                return next.i();
            }
        }
        return null;
    }

    public synchronized BdAsyncTask<?, ?, ?> w(String str) {
        return v(this.j, str);
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> x(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        LinkedList<BdAsyncTask<?, ?, ?>> t = t(this.j, bdUniqueId, null);
        if (t != null) {
            linkedList.addAll(t);
        }
        return linkedList;
    }

    public final synchronized void y(d dVar) {
        d poll;
        m(dVar);
        if (!dVar.j()) {
            dVar.m(true);
            this.l.add(dVar);
            if (this.l.size() > 242 && (poll = this.l.poll()) != null) {
                poll.b();
            }
        } else {
            BdLog.e("task TimeOut but it's cancelled()");
        }
        p(null);
    }

    public String z() {
        return this.j.size() + "/" + this.k.size() + "/" + this.l.size();
    }
}
