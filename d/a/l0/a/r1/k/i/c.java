package d.a.l0.a.r1.k.i;

import android.util.Log;
import d.a.l0.a.r1.l.e;
import d.a.l0.a.v2.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c implements d.a.l0.a.f1.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f44507e = e.k();

    /* renamed from: b  reason: collision with root package name */
    public boolean f44508b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Runnable, String> f44509c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.r1.r.c.a f44510d;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.r1.r.c.a {
        public a() {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void b() {
            c.this.f44508b = false;
            c.this.d();
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void c(boolean z) {
            c.this.f44508b = false;
            long currentTimeMillis = System.currentTimeMillis();
            int size = c.this.f44509c.size();
            c.this.d();
            if (d.a.l0.a.f1.f.a.f41852a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "thread dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + size);
            }
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void d(String str) {
            c.this.f44508b = true;
        }

        @Override // d.a.l0.a.r1.r.c.a
        public String getName() {
            return "TaskDispatch";
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f44512a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c f() {
        return b.f44512a;
    }

    public final void d() {
        if (this.f44509c.isEmpty()) {
            return;
        }
        for (Map.Entry<Runnable, String> entry : this.f44509c.entrySet()) {
            if (entry != null) {
                q.k(entry.getKey(), entry.getValue());
            }
        }
        this.f44509c.clear();
    }

    public boolean e(Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        if (f44507e > 0 && this.f44508b) {
            this.f44509c.put(runnable, str);
            return true;
        }
        q.k(runnable, str);
        return true;
    }

    public void g() {
        if (f44507e <= 0) {
            if (d.a.l0.a.f1.f.a.f41852a) {
                Log.e("SwanPerformance", "thread dispatch can't register. ab is closed");
                return;
            }
            return;
        }
        d.a.l0.a.r1.r.a.f().h(this.f44510d, f44507e);
    }

    public c() {
        this.f44508b = false;
        this.f44509c = new ConcurrentHashMap();
        this.f44510d = new a();
    }
}
