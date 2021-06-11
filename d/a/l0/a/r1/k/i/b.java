package d.a.l0.a.r1.k.i;

import android.util.Log;
import d.a.l0.a.r1.l.e;
import d.a.l0.a.v2.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b implements d.a.l0.a.f1.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f48175e = e.i();

    /* renamed from: b  reason: collision with root package name */
    public boolean f48176b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Runnable, String> f48177c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.r1.r.c.a f48178d;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.r1.r.c.a {
        public a() {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void b() {
            b.this.f48176b = false;
            b.this.d();
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void c(boolean z) {
            b.this.f48176b = false;
            long currentTimeMillis = System.currentTimeMillis();
            int size = b.this.f48177c.size();
            b.this.d();
            if (d.a.l0.a.f1.f.a.f45528a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "thread dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + size);
            }
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void d(String str) {
            b.this.f48176b = true;
        }

        @Override // d.a.l0.a.r1.r.c.a
        public String getName() {
            return "ThreadDispatch";
        }
    }

    /* renamed from: d.a.l0.a.r1.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0865b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f48180a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b e() {
        return C0865b.f48180a;
    }

    public final void d() {
        if (this.f48177c.isEmpty()) {
            return;
        }
        for (Map.Entry<Runnable, String> entry : this.f48177c.entrySet()) {
            if (entry != null) {
                q.k(entry.getKey(), entry.getValue());
            }
        }
        this.f48177c.clear();
    }

    public boolean f(Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        if (f48175e > 0 && this.f48176b) {
            this.f48177c.put(runnable, str);
            return true;
        }
        q.k(runnable, str);
        return false;
    }

    public void g() {
        c.f().g();
        if (f48175e <= 0) {
            if (d.a.l0.a.f1.f.a.f45528a) {
                Log.e("SwanPerformance", "launch thread dispatch can't register. ab is closed");
                return;
            }
            return;
        }
        d.a.l0.a.r1.r.a.f().h(this.f48178d, f48175e);
    }

    public b() {
        this.f48176b = false;
        this.f48177c = new ConcurrentHashMap();
        this.f48178d = new a();
    }
}
