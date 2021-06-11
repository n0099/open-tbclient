package d.a.v.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.SparseIntArray;
import com.baidu.live.asynctask.BdAsyncTask;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
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
/* loaded from: classes2.dex */
public class a implements Executor {
    public static final ThreadFactory o = new ThreadFactoryC1870a();
    public static final BlockingQueue<Runnable> p = new SynchronousQueue();
    public static final Executor q = new ThreadPoolExecutor(7, 256, 30, TimeUnit.SECONDS, p, o, new ThreadPoolExecutor.DiscardPolicy());
    public static volatile a r = null;

    /* renamed from: e  reason: collision with root package name */
    public final SparseIntArray f68413e = new SparseIntArray();

    /* renamed from: f  reason: collision with root package name */
    public final LinkedList<d> f68414f = new LinkedList<>();

    /* renamed from: g  reason: collision with root package name */
    public final LinkedList<d> f68415g = new LinkedList<>();

    /* renamed from: h  reason: collision with root package name */
    public final LinkedList<d> f68416h = new LinkedList<>();

    /* renamed from: i  reason: collision with root package name */
    public volatile int f68417i = 0;
    public volatile int j = 0;
    public volatile int k = 0;
    public volatile int l = 0;
    public HandlerThread m;
    public Handler n;

    /* renamed from: d.a.v.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC1870a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f68418e = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            String str = "BdAsyncTask #" + String.valueOf(this.f68418e.getAndIncrement());
            d.a.v.e.a.g(str);
            return new Thread(runnable, str);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1) {
                Object obj2 = message.obj;
                if (obj2 == null || !(obj2 instanceof d)) {
                    return;
                }
                a.this.j((d) obj2);
            } else if (i2 == 2 && (obj = message.obj) != null && (obj instanceof d)) {
                a.this.i((d) obj);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d {
        public c(d.a.v.a.b bVar) {
            super(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    if (e() == 4) {
                        Process.setThreadPriority(-2);
                    } else if (e() == 3) {
                        Process.setThreadPriority(-1);
                    } else if (e() == 2) {
                        Process.setThreadPriority(0);
                    } else {
                        Process.setThreadPriority(10);
                    }
                } catch (Exception e2) {
                    d.a.v.e.a.d(e2.getMessage());
                }
                j();
            } finally {
                if (!h()) {
                    a.this.n.sendMessageDelayed(a.this.n.obtainMessage(2, this), 1L);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.v.a.b<?> f68421e;

        public d(d.a.v.a.b<?> bVar) {
            this.f68421e = null;
            if (bVar != null && bVar.c() != null) {
                this.f68421e = bVar;
                return;
            }
            throw new InvalidParameterException("parameter is null");
        }

        public void a() {
            this.f68421e.b();
        }

        public int b() {
            if (this.f68421e.c().j() != null) {
                return this.f68421e.c().j().a();
            }
            return 1;
        }

        public int c() {
            if (this.f68421e.c().j() != null) {
                return this.f68421e.c().j().b();
            }
            return 0;
        }

        public BdAsyncTaskParallelType d() {
            if (this.f68421e.c().j() != null) {
                return this.f68421e.c().j().c();
            }
            return BdAsyncTaskParallelType.MAX_PARALLEL;
        }

        public int e() {
            return this.f68421e.c().k();
        }

        public BdAsyncTask<?, ?, ?> f() {
            return this.f68421e.c();
        }

        public boolean g() {
            return this.f68421e.isCancelled();
        }

        public boolean h() {
            return this.f68421e.c().m();
        }

        public boolean i() {
            return this.f68421e.c().n();
        }

        public void j() {
            try {
                this.f68421e.run();
            } catch (OutOfMemoryError e2) {
                d.a.v.e.a.e(e2);
            }
        }

        public void k(boolean z) {
            this.f68421e.c().y(z);
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
        if (r == null) {
            synchronized (a.class) {
                if (r == null) {
                    r = new a();
                }
            }
        }
        return r;
    }

    public final boolean c(int i2, d dVar) {
        if (dVar == null) {
            return false;
        }
        BdAsyncTaskParallelType d2 = dVar.d();
        if (d2 == BdAsyncTaskParallelType.SERIAL) {
            if (i2 < 1) {
                return true;
            }
        } else if (d2 == BdAsyncTaskParallelType.TWO_PARALLEL) {
            if (i2 < 2) {
                return true;
            }
        } else if (d2 == BdAsyncTaskParallelType.THREE_PARALLEL) {
            if (i2 < 3) {
                return true;
            }
        } else if (d2 == BdAsyncTaskParallelType.FOUR_PARALLEL) {
            if (i2 < 4) {
                return true;
            }
        } else if (d2 != BdAsyncTaskParallelType.CUSTOM_PARALLEL || i2 < dVar.b()) {
            return true;
        }
        return false;
    }

    public final synchronized void d(d dVar) {
        if (dVar == null) {
            return;
        }
        this.f68415g.add(dVar);
        this.f68414f.remove(dVar);
        q.execute(dVar);
        this.n.sendMessageDelayed(this.n.obtainMessage(1, dVar), 180000L);
        int e2 = dVar.e();
        if (e2 == 1) {
            this.l++;
        } else if (e2 == 2) {
            this.k++;
        } else if (e2 == 3) {
            this.j++;
        } else if (e2 == 4) {
            this.f68417i++;
            if (this.f68417i >= 7) {
                d.a.v.e.a.d("SuperHight Task too much num = " + this.f68417i);
            }
        }
        int c2 = dVar.c();
        if (c2 != 0) {
            this.f68413e.put(c2, this.f68413e.get(c2, 0) + 1);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (runnable instanceof d.a.v.a.b) {
            c cVar = new c((d.a.v.a.b) runnable);
            if (cVar.h()) {
                new Thread(cVar).start();
                return;
            }
            f(cVar);
            i(null);
        }
    }

    public final synchronized void f(d dVar) {
        if (dVar == null) {
            return;
        }
        int size = this.f68414f.size();
        int i2 = 0;
        while (i2 < size && this.f68414f.get(i2).e() >= dVar.e()) {
            i2++;
        }
        this.f68414f.add(i2, dVar);
    }

    public final synchronized void g(d dVar) {
        if (dVar == null) {
            return;
        }
        if (dVar.i()) {
            this.f68416h.remove(dVar);
        } else {
            this.f68415g.remove(dVar);
            this.n.removeMessages(1, dVar);
            int e2 = dVar.e();
            if (e2 == 1) {
                this.l--;
            } else if (e2 == 2) {
                this.k--;
            } else if (e2 == 3) {
                this.j--;
            } else if (e2 == 4) {
                this.f68417i--;
            }
            int c2 = dVar.c();
            if (c2 != 0) {
                int i2 = this.f68413e.get(c2) - 1;
                if (i2 <= 0) {
                    this.f68413e.delete(c2);
                } else {
                    this.f68413e.put(c2, i2);
                }
                if (i2 < 0) {
                    d.a.v.e.a.d("removeTask error < 0");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        r0.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void h(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        Iterator<d> it = this.f68414f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next != null && next.f() == bdAsyncTask) {
                break;
            }
        }
    }

    public synchronized void i(d dVar) {
        g(dVar);
        for (int i2 = 0; i2 < this.f68414f.size(); i2++) {
            d dVar2 = this.f68414f.get(i2);
            if (dVar2 != null) {
                int c2 = dVar2.c();
                int e2 = dVar2.e();
                if (e2 != 1) {
                    if (e2 != 2) {
                        if (e2 != 3) {
                            if (e2 == 4 && c2 == 0) {
                                d(dVar2);
                                return;
                            }
                        } else if (this.j + this.k + this.l >= 7) {
                            return;
                        }
                    } else if (this.j + this.k + this.l >= 6) {
                        return;
                    }
                } else if (this.j + this.k + this.l >= 5) {
                    return;
                }
                if (c(this.f68413e.get(c2), dVar2)) {
                    d(dVar2);
                    return;
                }
            }
        }
    }

    public final synchronized void j(d dVar) {
        d poll;
        g(dVar);
        if (!dVar.g()) {
            dVar.k(true);
            this.f68416h.add(dVar);
            if (this.f68416h.size() > 242 && (poll = this.f68416h.poll()) != null) {
                poll.a();
            }
        } else {
            d.a.v.e.a.d("task TimeOut but it's cancelled()");
        }
        i(null);
    }

    public String toString() {
        return "mWaitingTasks = " + this.f68414f.size() + " mRunningTasks = " + this.f68415g.size() + " mTimeOutTasks = " + this.f68416h.size();
    }
}
