package d.a.t.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f68295f;

    /* renamed from: g  reason: collision with root package name */
    public static int f68296g;

    /* renamed from: a  reason: collision with root package name */
    public Context f68297a;

    /* renamed from: b  reason: collision with root package name */
    public int f68298b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.t.a.d.a f68299c;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<Integer, d.a.t.a.a.c> f68301e = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public ScheduledExecutorService f68300d = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: d.a.t.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1866a implements Runnable {
        public RunnableC1866a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f68299c.b();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.t.a.a.c f68303e;

        public b(d.a.t.a.a.c cVar) {
            this.f68303e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f68299c.j(this.f68303e);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.t.a.a.c f68305e;

        public c(d.a.t.a.a.c cVar) {
            this.f68305e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f68299c.e(this.f68305e);
        }
    }

    public a(Context context) {
        this.f68297a = context;
        this.f68298b = g.g(context, "flow_handle", f68296g);
        this.f68299c = d.a.t.a.d.a.i(this.f68297a);
    }

    public static a h(@NonNull Context context) {
        if (f68295f == null) {
            synchronized (a.class) {
                if (f68295f == null) {
                    f68295f = new a(context);
                }
            }
        }
        return f68295f;
    }

    public synchronized d.a.t.a.a.c b(int i2) {
        return d(i2);
    }

    public void c() {
        this.f68300d.execute(new RunnableC1866a());
    }

    public final d.a.t.a.a.c d(int i2) {
        if (!this.f68301e.containsKey(Integer.valueOf(i2))) {
            this.f68298b++;
            d.a.t.a.h.e.a("BehaviorProcess", "FlowHandle:" + this.f68298b);
            d.a.t.a.a.c cVar = new d.a.t.a.a.c(this.f68297a, i2, this.f68298b);
            this.f68301e.put(Integer.valueOf(i2), cVar);
            this.f68300d.execute(new b(cVar));
            g.l(this.f68297a, "flow_handle", this.f68298b);
            return cVar;
        }
        return this.f68301e.get(Integer.valueOf(i2));
    }

    public synchronized void e(d.a.t.a.a.c cVar) {
        if (this.f68301e.containsKey(Integer.valueOf(cVar.f68308a))) {
            this.f68301e.remove(Integer.valueOf(cVar.f68308a));
            d.a.t.a.h.e.a("BehaviorProcess", "flow endFlow");
            this.f68300d.execute(new c(cVar));
        }
    }

    public ScheduledExecutorService f() {
        return this.f68300d;
    }

    public synchronized d.a.t.a.a.c g(int i2) {
        if (this.f68301e.containsKey(Integer.valueOf(i2))) {
            return this.f68301e.get(Integer.valueOf(i2));
        }
        return new d.a.t.a.a.b(this.f68297a, i2, f68296g);
    }
}
