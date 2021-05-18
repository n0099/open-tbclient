package d.a.i0.a.r1.k.i;

import android.util.Log;
import d.a.i0.a.r1.l.e;
import d.a.i0.a.v2.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class c implements d.a.i0.a.f1.f.a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f44331e = e.k();

    /* renamed from: b  reason: collision with root package name */
    public boolean f44332b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Runnable, String> f44333c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.r1.r.c.a f44334d;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.r1.r.c.a {
        public a() {
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void b() {
            c.this.f44332b = false;
            c.this.d();
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void c(boolean z) {
            c.this.f44332b = false;
            long currentTimeMillis = System.currentTimeMillis();
            int size = c.this.f44333c.size();
            c.this.d();
            if (d.a.i0.a.f1.f.a.f41678a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanPerformance", "thread dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + size);
            }
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void d(String str) {
            c.this.f44332b = true;
        }

        @Override // d.a.i0.a.r1.r.c.a
        public String getName() {
            return "TaskDispatch";
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f44336a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c f() {
        return b.f44336a;
    }

    public final void d() {
        if (this.f44333c.isEmpty()) {
            return;
        }
        for (Map.Entry<Runnable, String> entry : this.f44333c.entrySet()) {
            if (entry != null) {
                q.k(entry.getKey(), entry.getValue());
            }
        }
        this.f44333c.clear();
    }

    public boolean e(Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        if (f44331e > 0 && this.f44332b) {
            this.f44333c.put(runnable, str);
            return true;
        }
        q.k(runnable, str);
        return true;
    }

    public void g() {
        if (f44331e <= 0) {
            if (d.a.i0.a.f1.f.a.f41678a) {
                Log.e("SwanPerformance", "thread dispatch can't register. ab is closed");
                return;
            }
            return;
        }
        d.a.i0.a.r1.r.a.f().h(this.f44334d, f44331e);
    }

    public c() {
        this.f44332b = false;
        this.f44333c = new ConcurrentHashMap();
        this.f44334d = new a();
    }
}
