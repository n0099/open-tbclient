package d.a.i0.a.r1.k.i;

import android.util.Log;
import d.a.i0.a.r1.l.e;
import d.a.i0.a.v2.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b implements d.a.i0.a.f1.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f44325e = e.i();

    /* renamed from: b  reason: collision with root package name */
    public boolean f44326b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Runnable, String> f44327c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.r1.r.c.a f44328d;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.r1.r.c.a {
        public a() {
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void b() {
            b.this.f44326b = false;
            b.this.d();
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void c(boolean z) {
            b.this.f44326b = false;
            long currentTimeMillis = System.currentTimeMillis();
            int size = b.this.f44327c.size();
            b.this.d();
            if (d.a.i0.a.f1.f.a.f41678a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "thread dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + size);
            }
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void d(String str) {
            b.this.f44326b = true;
        }

        @Override // d.a.i0.a.r1.r.c.a
        public String getName() {
            return "ThreadDispatch";
        }
    }

    /* renamed from: d.a.i0.a.r1.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0798b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f44330a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b e() {
        return C0798b.f44330a;
    }

    public final void d() {
        if (this.f44327c.isEmpty()) {
            return;
        }
        for (Map.Entry<Runnable, String> entry : this.f44327c.entrySet()) {
            if (entry != null) {
                q.k(entry.getKey(), entry.getValue());
            }
        }
        this.f44327c.clear();
    }

    public boolean f(Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        if (f44325e > 0 && this.f44326b) {
            this.f44327c.put(runnable, str);
            return true;
        }
        q.k(runnable, str);
        return false;
    }

    public void g() {
        c.f().g();
        if (f44325e <= 0) {
            if (d.a.i0.a.f1.f.a.f41678a) {
                Log.e("SwanPerformance", "launch thread dispatch can't register. ab is closed");
                return;
            }
            return;
        }
        d.a.i0.a.r1.r.a.f().h(this.f44328d, f44325e);
    }

    public b() {
        this.f44326b = false;
        this.f44327c = new ConcurrentHashMap();
        this.f44328d = new a();
    }
}
