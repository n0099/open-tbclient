package d.a.m0.a.r1.k.i;

import android.util.Log;
import d.a.m0.a.r1.l.e;
import d.a.m0.a.v2.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c implements d.a.m0.a.f1.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f48289e = e.k();

    /* renamed from: b  reason: collision with root package name */
    public boolean f48290b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Runnable, String> f48291c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.a.r1.r.c.a f48292d;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.r1.r.c.a {
        public a() {
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void b() {
            c.this.f48290b = false;
            c.this.d();
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void c(boolean z) {
            c.this.f48290b = false;
            long currentTimeMillis = System.currentTimeMillis();
            int size = c.this.f48291c.size();
            c.this.d();
            if (d.a.m0.a.f1.f.a.f45636a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "thread dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + size);
            }
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void d(String str) {
            c.this.f48290b = true;
        }

        @Override // d.a.m0.a.r1.r.c.a
        public String getName() {
            return "TaskDispatch";
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f48294a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c f() {
        return b.f48294a;
    }

    public final void d() {
        if (this.f48291c.isEmpty()) {
            return;
        }
        for (Map.Entry<Runnable, String> entry : this.f48291c.entrySet()) {
            if (entry != null) {
                q.k(entry.getKey(), entry.getValue());
            }
        }
        this.f48291c.clear();
    }

    public boolean e(Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        if (f48289e > 0 && this.f48290b) {
            this.f48291c.put(runnable, str);
            return true;
        }
        q.k(runnable, str);
        return true;
    }

    public void g() {
        if (f48289e <= 0) {
            if (d.a.m0.a.f1.f.a.f45636a) {
                Log.e("SwanPerformance", "thread dispatch can't register. ab is closed");
                return;
            }
            return;
        }
        d.a.m0.a.r1.r.a.f().h(this.f48292d, f48289e);
    }

    public c() {
        this.f48290b = false;
        this.f48291c = new ConcurrentHashMap();
        this.f48292d = new a();
    }
}
