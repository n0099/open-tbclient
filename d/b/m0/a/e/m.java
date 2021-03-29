package d.b.m0.a.e;

import android.app.Activity;
import android.os.Handler;
import com.baidu.ubs.analytics.a.n;
import d.b.m0.a.c;
import d.b.m0.a.e.a;
import d.b.m0.a.e.d;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class m implements a.InterfaceC1735a {

    /* renamed from: f  reason: collision with root package name */
    public static n f64095f;

    /* renamed from: g  reason: collision with root package name */
    public static long f64096g = f.a();

    /* renamed from: h  reason: collision with root package name */
    public static long f64097h;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f64101d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64098a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64099b = true;

    /* renamed from: c  reason: collision with root package name */
    public Handler f64100c = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public e f64102e = new a();

    /* loaded from: classes5.dex */
    public class a implements e {

        /* renamed from: d.b.m0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1736a extends d.b.m0.a.f.c {
            public C1736a(a aVar) {
            }

            @Override // d.b.m0.a.f.c
            public final void a() {
                d.b.m0.a.f.a.b("记录一次app启动事件");
                d.b.m0.a.a.c("power_on", "", "", null);
                d.b.m0.a.c.i().d(false);
            }
        }

        public a() {
        }

        @Override // d.b.m0.a.e.m.e
        public final void a() {
            long currentTimeMillis = System.currentTimeMillis();
            d.b.m0.a.f.a.b("app   went foreground ");
            if (currentTimeMillis - m.f64097h > m.f64096g) {
                m.this.l(currentTimeMillis);
            }
            if (d.b.m0.a.c.i().h()) {
                d.b.m0.a.f.b.a(new C1736a(this));
            }
        }

        @Override // d.b.m0.a.e.m.e
        public final void b() {
            d.b.m0.a.e.d dVar;
            dVar = d.a.f64071a;
            if (dVar.a().size() == 0) {
                d.b.m0.a.f.a.b("后台应用退出了 了               ");
                d.b.m0.a.c.i().d(true);
                long unused = m.f64097h = 0L;
                return;
            }
            d.b.m0.a.f.a.b("进入后台但没退出                  ");
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (m.this.f64098a && m.this.f64099b) {
                m.this.f64098a = false;
                try {
                    m.this.f64102e.b();
                } catch (Exception e2) {
                    d.b.m0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.b.m0.a.f.c {
        public c(m mVar) {
        }

        @Override // d.b.m0.a.f.c
        public final void a() {
            long currentTimeMillis = System.currentTimeMillis();
            m.f64095f.z(String.valueOf(currentTimeMillis));
            try {
                m.f64095f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f64095f.N())));
            } catch (NumberFormatException e2) {
                d.b.m0.a.f.a.b(e2.getLocalizedMessage());
            }
            c.l lVar = new c.l();
            if (lVar.b(m.f64095f.I())) {
                lVar.e(m.f64095f);
            } else {
                lVar.f(m.f64095f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.b.m0.a.f.c {
        public d(m mVar) {
        }

        @Override // d.b.m0.a.f.c
        public final void a() {
            d.b.m0.a.f.a.b("超时了……………… 一个新的session");
            new c.l().f(m.f64095f);
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b();
    }

    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        f64097h = currentTimeMillis;
        l(currentTimeMillis);
    }

    public static n d() {
        return f64095f;
    }

    @Override // d.b.m0.a.e.a.InterfaceC1735a
    public final void T() {
        this.f64099b = false;
        boolean z = !this.f64098a;
        this.f64098a = true;
        Runnable runnable = this.f64101d;
        if (runnable != null) {
            this.f64100c.removeCallbacks(runnable);
        }
        if (z) {
            try {
                this.f64102e.a();
            } catch (Exception e2) {
                d.b.m0.a.f.i.b("Listener threw exception!:" + e2.toString());
            }
        }
    }

    @Override // d.b.m0.a.e.a.InterfaceC1735a
    public final void U() {
        this.f64099b = true;
        Runnable runnable = this.f64101d;
        if (runnable != null) {
            this.f64100c.removeCallbacks(runnable);
            this.f64101d = null;
        }
        f64097h = System.currentTimeMillis();
        d.b.m0.a.f.b.c(new c(this));
        Handler handler = this.f64100c;
        b bVar = new b();
        this.f64101d = bVar;
        handler.postDelayed(bVar, 1000L);
    }

    @Override // d.b.m0.a.e.a.InterfaceC1735a
    public final void a(Activity activity) {
    }

    public final void l(long j) {
        n nVar = new n();
        f64095f = nVar;
        nVar.setStartTime(String.valueOf(j));
        f64095f.x(UUID.randomUUID().toString().replace("-", ""));
        d.b.m0.a.f.b.c(new d(this));
    }

    @Override // d.b.m0.a.e.a.InterfaceC1735a
    public final void onActivityDestroyed(Activity activity) {
    }
}
