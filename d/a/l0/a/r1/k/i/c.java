package d.a.l0.a.r1.k.i;

import android.util.Log;
import d.a.l0.a.r1.l.e;
import d.a.l0.a.v2.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c implements d.a.l0.a.f1.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f48181e = e.k();

    /* renamed from: b  reason: collision with root package name */
    public boolean f48182b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Runnable, String> f48183c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.r1.r.c.a f48184d;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.r1.r.c.a {
        public a() {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void b() {
            c.this.f48182b = false;
            c.this.d();
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void c(boolean z) {
            c.this.f48182b = false;
            long currentTimeMillis = System.currentTimeMillis();
            int size = c.this.f48183c.size();
            c.this.d();
            if (d.a.l0.a.f1.f.a.f45528a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "thread dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + size);
            }
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void d(String str) {
            c.this.f48182b = true;
        }

        @Override // d.a.l0.a.r1.r.c.a
        public String getName() {
            return "TaskDispatch";
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f48186a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c f() {
        return b.f48186a;
    }

    public final void d() {
        if (this.f48183c.isEmpty()) {
            return;
        }
        for (Map.Entry<Runnable, String> entry : this.f48183c.entrySet()) {
            if (entry != null) {
                q.k(entry.getKey(), entry.getValue());
            }
        }
        this.f48183c.clear();
    }

    public boolean e(Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        if (f48181e > 0 && this.f48182b) {
            this.f48183c.put(runnable, str);
            return true;
        }
        q.k(runnable, str);
        return true;
    }

    public void g() {
        if (f48181e <= 0) {
            if (d.a.l0.a.f1.f.a.f45528a) {
                Log.e("SwanPerformance", "thread dispatch can't register. ab is closed");
                return;
            }
            return;
        }
        d.a.l0.a.r1.r.a.f().h(this.f48184d, f48181e);
    }

    public c() {
        this.f48182b = false;
        this.f48183c = new ConcurrentHashMap();
        this.f48184d = new a();
    }
}
