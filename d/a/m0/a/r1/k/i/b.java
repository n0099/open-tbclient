package d.a.m0.a.r1.k.i;

import android.util.Log;
import d.a.m0.a.r1.l.e;
import d.a.m0.a.v2.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b implements d.a.m0.a.f1.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f48283e = e.i();

    /* renamed from: b  reason: collision with root package name */
    public boolean f48284b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Runnable, String> f48285c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.a.r1.r.c.a f48286d;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.r1.r.c.a {
        public a() {
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void b() {
            b.this.f48284b = false;
            b.this.d();
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void c(boolean z) {
            b.this.f48284b = false;
            long currentTimeMillis = System.currentTimeMillis();
            int size = b.this.f48285c.size();
            b.this.d();
            if (d.a.m0.a.f1.f.a.f45636a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "thread dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + size);
            }
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void d(String str) {
            b.this.f48284b = true;
        }

        @Override // d.a.m0.a.r1.r.c.a
        public String getName() {
            return "ThreadDispatch";
        }
    }

    /* renamed from: d.a.m0.a.r1.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0868b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f48288a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b e() {
        return C0868b.f48288a;
    }

    public final void d() {
        if (this.f48285c.isEmpty()) {
            return;
        }
        for (Map.Entry<Runnable, String> entry : this.f48285c.entrySet()) {
            if (entry != null) {
                q.k(entry.getKey(), entry.getValue());
            }
        }
        this.f48285c.clear();
    }

    public boolean f(Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        if (f48283e > 0 && this.f48284b) {
            this.f48285c.put(runnable, str);
            return true;
        }
        q.k(runnable, str);
        return false;
    }

    public void g() {
        c.f().g();
        if (f48283e <= 0) {
            if (d.a.m0.a.f1.f.a.f45636a) {
                Log.e("SwanPerformance", "launch thread dispatch can't register. ab is closed");
                return;
            }
            return;
        }
        d.a.m0.a.r1.r.a.f().h(this.f48286d, f48283e);
    }

    public b() {
        this.f48284b = false;
        this.f48285c = new ConcurrentHashMap();
        this.f48286d = new a();
    }
}
