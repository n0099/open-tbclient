package d.a.t.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f64495f;

    /* renamed from: g  reason: collision with root package name */
    public static int f64496g;

    /* renamed from: a  reason: collision with root package name */
    public Context f64497a;

    /* renamed from: b  reason: collision with root package name */
    public int f64498b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.t.a.d.a f64499c;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Integer, d.a.t.a.a.c> f64501e = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public ScheduledExecutorService f64500d = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: d.a.t.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1805a implements Runnable {
        public RunnableC1805a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f64499c.b();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.t.a.a.c f64503e;

        public b(d.a.t.a.a.c cVar) {
            this.f64503e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f64499c.j(this.f64503e);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.t.a.a.c f64505e;

        public c(d.a.t.a.a.c cVar) {
            this.f64505e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f64499c.e(this.f64505e);
        }
    }

    public a(Context context) {
        this.f64497a = context;
        this.f64498b = g.g(context, "flow_handle", f64496g);
        this.f64499c = d.a.t.a.d.a.i(this.f64497a);
    }

    public static a h(@NonNull Context context) {
        if (f64495f == null) {
            synchronized (a.class) {
                if (f64495f == null) {
                    f64495f = new a(context);
                }
            }
        }
        return f64495f;
    }

    public synchronized d.a.t.a.a.c b(int i2) {
        return d(i2);
    }

    public void c() {
        this.f64500d.execute(new RunnableC1805a());
    }

    public final d.a.t.a.a.c d(int i2) {
        if (!this.f64501e.containsKey(Integer.valueOf(i2))) {
            this.f64498b++;
            d.a.t.a.h.e.a("BehaviorProcess", "FlowHandle:" + this.f64498b);
            d.a.t.a.a.c cVar = new d.a.t.a.a.c(this.f64497a, i2, this.f64498b);
            this.f64501e.put(Integer.valueOf(i2), cVar);
            this.f64500d.execute(new b(cVar));
            g.l(this.f64497a, "flow_handle", this.f64498b);
            return cVar;
        }
        return this.f64501e.get(Integer.valueOf(i2));
    }

    public synchronized void e(d.a.t.a.a.c cVar) {
        if (this.f64501e.containsKey(Integer.valueOf(cVar.f64508a))) {
            this.f64501e.remove(Integer.valueOf(cVar.f64508a));
            d.a.t.a.h.e.a("BehaviorProcess", "flow endFlow");
            this.f64500d.execute(new c(cVar));
        }
    }

    public ScheduledExecutorService f() {
        return this.f64500d;
    }

    public synchronized d.a.t.a.a.c g(int i2) {
        if (this.f64501e.containsKey(Integer.valueOf(i2))) {
            return this.f64501e.get(Integer.valueOf(i2));
        }
        return new d.a.t.a.a.b(this.f64497a, i2, f64496g);
    }
}
