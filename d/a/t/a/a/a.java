package d.a.t.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f68213f;

    /* renamed from: g  reason: collision with root package name */
    public static int f68214g;

    /* renamed from: a  reason: collision with root package name */
    public Context f68215a;

    /* renamed from: b  reason: collision with root package name */
    public int f68216b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.t.a.d.a f68217c;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Integer, d.a.t.a.a.c> f68219e = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public ScheduledExecutorService f68218d = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: d.a.t.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1863a implements Runnable {
        public RunnableC1863a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f68217c.b();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.t.a.a.c f68221e;

        public b(d.a.t.a.a.c cVar) {
            this.f68221e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f68217c.j(this.f68221e);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.t.a.a.c f68223e;

        public c(d.a.t.a.a.c cVar) {
            this.f68223e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f68217c.e(this.f68223e);
        }
    }

    public a(Context context) {
        this.f68215a = context;
        this.f68216b = g.g(context, "flow_handle", f68214g);
        this.f68217c = d.a.t.a.d.a.i(this.f68215a);
    }

    public static a h(@NonNull Context context) {
        if (f68213f == null) {
            synchronized (a.class) {
                if (f68213f == null) {
                    f68213f = new a(context);
                }
            }
        }
        return f68213f;
    }

    public synchronized d.a.t.a.a.c b(int i2) {
        return d(i2);
    }

    public void c() {
        this.f68218d.execute(new RunnableC1863a());
    }

    public final d.a.t.a.a.c d(int i2) {
        if (!this.f68219e.containsKey(Integer.valueOf(i2))) {
            this.f68216b++;
            d.a.t.a.h.e.a("BehaviorProcess", "FlowHandle:" + this.f68216b);
            d.a.t.a.a.c cVar = new d.a.t.a.a.c(this.f68215a, i2, this.f68216b);
            this.f68219e.put(Integer.valueOf(i2), cVar);
            this.f68218d.execute(new b(cVar));
            g.l(this.f68215a, "flow_handle", this.f68216b);
            return cVar;
        }
        return this.f68219e.get(Integer.valueOf(i2));
    }

    public synchronized void e(d.a.t.a.a.c cVar) {
        if (this.f68219e.containsKey(Integer.valueOf(cVar.f68226a))) {
            this.f68219e.remove(Integer.valueOf(cVar.f68226a));
            d.a.t.a.h.e.a("BehaviorProcess", "flow endFlow");
            this.f68218d.execute(new c(cVar));
        }
    }

    public ScheduledExecutorService f() {
        return this.f68218d;
    }

    public synchronized d.a.t.a.a.c g(int i2) {
        if (this.f68219e.containsKey(Integer.valueOf(i2))) {
            return this.f68219e.get(Integer.valueOf(i2));
        }
        return new d.a.t.a.a.b(this.f68215a, i2, f68214g);
    }
}
