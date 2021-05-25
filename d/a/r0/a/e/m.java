package d.a.r0.a.e;

import android.app.Activity;
import android.os.Handler;
import com.baidu.ubs.analytics.a.n;
import d.a.r0.a.c;
import d.a.r0.a.e.a;
import d.a.r0.a.e.d;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class m implements a.InterfaceC1801a {

    /* renamed from: f  reason: collision with root package name */
    public static n f64437f;

    /* renamed from: g  reason: collision with root package name */
    public static long f64438g = f.a();

    /* renamed from: h  reason: collision with root package name */
    public static long f64439h;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f64443d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64440a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64441b = true;

    /* renamed from: c  reason: collision with root package name */
    public Handler f64442c = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public e f64444e = new a();

    /* loaded from: classes5.dex */
    public class a implements e {

        /* renamed from: d.a.r0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1802a extends d.a.r0.a.f.c {
            public C1802a(a aVar) {
            }

            @Override // d.a.r0.a.f.c
            public final void a() {
                d.a.r0.a.f.a.b("记录一次app启动事件");
                d.a.r0.a.a.c("power_on", "", "", null);
                d.a.r0.a.c.i().d(false);
            }
        }

        public a() {
        }

        @Override // d.a.r0.a.e.m.e
        public final void a() {
            long currentTimeMillis = System.currentTimeMillis();
            d.a.r0.a.f.a.b("app   went foreground ");
            if (currentTimeMillis - m.f64439h > m.f64438g) {
                m.this.l(currentTimeMillis);
            }
            if (d.a.r0.a.c.i().h()) {
                d.a.r0.a.f.b.a(new C1802a(this));
            }
        }

        @Override // d.a.r0.a.e.m.e
        public final void b() {
            d.a.r0.a.e.d dVar;
            dVar = d.a.f64413a;
            if (dVar.a().size() == 0) {
                d.a.r0.a.f.a.b("后台应用退出了 了               ");
                d.a.r0.a.c.i().d(true);
                long unused = m.f64439h = 0L;
                return;
            }
            d.a.r0.a.f.a.b("进入后台但没退出                  ");
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (m.this.f64440a && m.this.f64441b) {
                m.this.f64440a = false;
                try {
                    m.this.f64444e.b();
                } catch (Exception e2) {
                    d.a.r0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.a.r0.a.f.c {
        public c(m mVar) {
        }

        @Override // d.a.r0.a.f.c
        public final void a() {
            long currentTimeMillis = System.currentTimeMillis();
            m.f64437f.z(String.valueOf(currentTimeMillis));
            try {
                m.f64437f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f64437f.N())));
            } catch (NumberFormatException e2) {
                d.a.r0.a.f.a.b(e2.getLocalizedMessage());
            }
            c.l lVar = new c.l();
            if (lVar.b(m.f64437f.I())) {
                lVar.e(m.f64437f);
            } else {
                lVar.f(m.f64437f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.a.r0.a.f.c {
        public d(m mVar) {
        }

        @Override // d.a.r0.a.f.c
        public final void a() {
            d.a.r0.a.f.a.b("超时了……………… 一个新的session");
            new c.l().f(m.f64437f);
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b();
    }

    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        f64439h = currentTimeMillis;
        l(currentTimeMillis);
    }

    public static n d() {
        return f64437f;
    }

    @Override // d.a.r0.a.e.a.InterfaceC1801a
    public final void T() {
        this.f64441b = false;
        boolean z = !this.f64440a;
        this.f64440a = true;
        Runnable runnable = this.f64443d;
        if (runnable != null) {
            this.f64442c.removeCallbacks(runnable);
        }
        if (z) {
            try {
                this.f64444e.a();
            } catch (Exception e2) {
                d.a.r0.a.f.i.b("Listener threw exception!:" + e2.toString());
            }
        }
    }

    @Override // d.a.r0.a.e.a.InterfaceC1801a
    public final void U() {
        this.f64441b = true;
        Runnable runnable = this.f64443d;
        if (runnable != null) {
            this.f64442c.removeCallbacks(runnable);
            this.f64443d = null;
        }
        f64439h = System.currentTimeMillis();
        d.a.r0.a.f.b.c(new c(this));
        Handler handler = this.f64442c;
        b bVar = new b();
        this.f64443d = bVar;
        handler.postDelayed(bVar, 1000L);
    }

    @Override // d.a.r0.a.e.a.InterfaceC1801a
    public final void a(Activity activity) {
    }

    public final void l(long j) {
        n nVar = new n();
        f64437f = nVar;
        nVar.setStartTime(String.valueOf(j));
        f64437f.x(UUID.randomUUID().toString().replace("-", ""));
        d.a.r0.a.f.b.c(new d(this));
    }

    @Override // d.a.r0.a.e.a.InterfaceC1801a
    public final void onActivityDestroyed(Activity activity) {
    }
}
