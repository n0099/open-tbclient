package d.a.o0.a.e;

import android.app.Activity;
import android.os.Handler;
import com.baidu.ubs.analytics.a.n;
import d.a.o0.a.c;
import d.a.o0.a.e.a;
import d.a.o0.a.e.d;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class m implements a.InterfaceC1769a {

    /* renamed from: f  reason: collision with root package name */
    public static n f64110f;

    /* renamed from: g  reason: collision with root package name */
    public static long f64111g = f.a();

    /* renamed from: h  reason: collision with root package name */
    public static long f64112h;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f64116d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64113a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64114b = true;

    /* renamed from: c  reason: collision with root package name */
    public Handler f64115c = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public e f64117e = new a();

    /* loaded from: classes5.dex */
    public class a implements e {

        /* renamed from: d.a.o0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1770a extends d.a.o0.a.f.c {
            public C1770a(a aVar) {
            }

            @Override // d.a.o0.a.f.c
            public final void a() {
                d.a.o0.a.f.a.b("记录一次app启动事件");
                d.a.o0.a.a.c("power_on", "", "", null);
                d.a.o0.a.c.i().d(false);
            }
        }

        public a() {
        }

        @Override // d.a.o0.a.e.m.e
        public final void a() {
            long currentTimeMillis = System.currentTimeMillis();
            d.a.o0.a.f.a.b("app   went foreground ");
            if (currentTimeMillis - m.f64112h > m.f64111g) {
                m.this.l(currentTimeMillis);
            }
            if (d.a.o0.a.c.i().h()) {
                d.a.o0.a.f.b.a(new C1770a(this));
            }
        }

        @Override // d.a.o0.a.e.m.e
        public final void b() {
            d.a.o0.a.e.d dVar;
            dVar = d.a.f64086a;
            if (dVar.a().size() == 0) {
                d.a.o0.a.f.a.b("后台应用退出了 了               ");
                d.a.o0.a.c.i().d(true);
                long unused = m.f64112h = 0L;
                return;
            }
            d.a.o0.a.f.a.b("进入后台但没退出                  ");
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (m.this.f64113a && m.this.f64114b) {
                m.this.f64113a = false;
                try {
                    m.this.f64117e.b();
                } catch (Exception e2) {
                    d.a.o0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.a.o0.a.f.c {
        public c(m mVar) {
        }

        @Override // d.a.o0.a.f.c
        public final void a() {
            long currentTimeMillis = System.currentTimeMillis();
            m.f64110f.z(String.valueOf(currentTimeMillis));
            try {
                m.f64110f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f64110f.N())));
            } catch (NumberFormatException e2) {
                d.a.o0.a.f.a.b(e2.getLocalizedMessage());
            }
            c.l lVar = new c.l();
            if (lVar.b(m.f64110f.I())) {
                lVar.e(m.f64110f);
            } else {
                lVar.f(m.f64110f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.a.o0.a.f.c {
        public d(m mVar) {
        }

        @Override // d.a.o0.a.f.c
        public final void a() {
            d.a.o0.a.f.a.b("超时了……………… 一个新的session");
            new c.l().f(m.f64110f);
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b();
    }

    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        f64112h = currentTimeMillis;
        l(currentTimeMillis);
    }

    public static n d() {
        return f64110f;
    }

    @Override // d.a.o0.a.e.a.InterfaceC1769a
    public final void T() {
        this.f64114b = false;
        boolean z = !this.f64113a;
        this.f64113a = true;
        Runnable runnable = this.f64116d;
        if (runnable != null) {
            this.f64115c.removeCallbacks(runnable);
        }
        if (z) {
            try {
                this.f64117e.a();
            } catch (Exception e2) {
                d.a.o0.a.f.i.b("Listener threw exception!:" + e2.toString());
            }
        }
    }

    @Override // d.a.o0.a.e.a.InterfaceC1769a
    public final void U() {
        this.f64114b = true;
        Runnable runnable = this.f64116d;
        if (runnable != null) {
            this.f64115c.removeCallbacks(runnable);
            this.f64116d = null;
        }
        f64112h = System.currentTimeMillis();
        d.a.o0.a.f.b.c(new c(this));
        Handler handler = this.f64115c;
        b bVar = new b();
        this.f64116d = bVar;
        handler.postDelayed(bVar, 1000L);
    }

    @Override // d.a.o0.a.e.a.InterfaceC1769a
    public final void a(Activity activity) {
    }

    public final void l(long j) {
        n nVar = new n();
        f64110f = nVar;
        nVar.setStartTime(String.valueOf(j));
        f64110f.x(UUID.randomUUID().toString().replace("-", ""));
        d.a.o0.a.f.b.c(new d(this));
    }

    @Override // d.a.o0.a.e.a.InterfaceC1769a
    public final void onActivityDestroyed(Activity activity) {
    }
}
