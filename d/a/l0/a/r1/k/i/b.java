package d.a.l0.a.r1.k.i;

import android.util.Log;
import d.a.l0.a.r1.l.e;
import d.a.l0.a.v2.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b implements d.a.l0.a.f1.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f44501e = e.i();

    /* renamed from: b  reason: collision with root package name */
    public boolean f44502b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Runnable, String> f44503c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.r1.r.c.a f44504d;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.r1.r.c.a {
        public a() {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void b() {
            b.this.f44502b = false;
            b.this.d();
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void c(boolean z) {
            b.this.f44502b = false;
            long currentTimeMillis = System.currentTimeMillis();
            int size = b.this.f44503c.size();
            b.this.d();
            if (d.a.l0.a.f1.f.a.f41852a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "thread dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + size);
            }
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void d(String str) {
            b.this.f44502b = true;
        }

        @Override // d.a.l0.a.r1.r.c.a
        public String getName() {
            return "ThreadDispatch";
        }
    }

    /* renamed from: d.a.l0.a.r1.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0809b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f44506a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b e() {
        return C0809b.f44506a;
    }

    public final void d() {
        if (this.f44503c.isEmpty()) {
            return;
        }
        for (Map.Entry<Runnable, String> entry : this.f44503c.entrySet()) {
            if (entry != null) {
                q.k(entry.getKey(), entry.getValue());
            }
        }
        this.f44503c.clear();
    }

    public boolean f(Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        if (f44501e > 0 && this.f44502b) {
            this.f44503c.put(runnable, str);
            return true;
        }
        q.k(runnable, str);
        return false;
    }

    public void g() {
        c.f().g();
        if (f44501e <= 0) {
            if (d.a.l0.a.f1.f.a.f41852a) {
                Log.e("SwanPerformance", "launch thread dispatch can't register. ab is closed");
                return;
            }
            return;
        }
        d.a.l0.a.r1.r.a.f().h(this.f44504d, f44501e);
    }

    public b() {
        this.f44502b = false;
        this.f44503c = new ConcurrentHashMap();
        this.f44504d = new a();
    }
}
