package d.b.m0.a.e;

import android.app.Activity;
import android.os.Handler;
import com.baidu.ubs.analytics.a.n;
import d.b.m0.a.c;
import d.b.m0.a.e.a;
import d.b.m0.a.e.d;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class m implements a.InterfaceC1747a {

    /* renamed from: f  reason: collision with root package name */
    public static n f64823f;

    /* renamed from: g  reason: collision with root package name */
    public static long f64824g = f.a();

    /* renamed from: h  reason: collision with root package name */
    public static long f64825h;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f64829d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64826a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64827b = true;

    /* renamed from: c  reason: collision with root package name */
    public Handler f64828c = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public e f64830e = new a();

    /* loaded from: classes5.dex */
    public class a implements e {

        /* renamed from: d.b.m0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1748a extends d.b.m0.a.f.c {
            public C1748a(a aVar) {
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
            if (currentTimeMillis - m.f64825h > m.f64824g) {
                m.this.l(currentTimeMillis);
            }
            if (d.b.m0.a.c.i().h()) {
                d.b.m0.a.f.b.a(new C1748a(this));
            }
        }

        @Override // d.b.m0.a.e.m.e
        public final void b() {
            d.b.m0.a.e.d dVar;
            dVar = d.a.f64799a;
            if (dVar.a().size() == 0) {
                d.b.m0.a.f.a.b("后台应用退出了 了               ");
                d.b.m0.a.c.i().d(true);
                long unused = m.f64825h = 0L;
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
            if (m.this.f64826a && m.this.f64827b) {
                m.this.f64826a = false;
                try {
                    m.this.f64830e.b();
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
            m.f64823f.z(String.valueOf(currentTimeMillis));
            try {
                m.f64823f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f64823f.N())));
            } catch (NumberFormatException e2) {
                d.b.m0.a.f.a.b(e2.getLocalizedMessage());
            }
            c.l lVar = new c.l();
            if (lVar.b(m.f64823f.I())) {
                lVar.e(m.f64823f);
            } else {
                lVar.f(m.f64823f);
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
            new c.l().f(m.f64823f);
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b();
    }

    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        f64825h = currentTimeMillis;
        l(currentTimeMillis);
    }

    public static n d() {
        return f64823f;
    }

    @Override // d.b.m0.a.e.a.InterfaceC1747a
    public final void T() {
        this.f64827b = false;
        boolean z = !this.f64826a;
        this.f64826a = true;
        Runnable runnable = this.f64829d;
        if (runnable != null) {
            this.f64828c.removeCallbacks(runnable);
        }
        if (z) {
            try {
                this.f64830e.a();
            } catch (Exception e2) {
                d.b.m0.a.f.i.b("Listener threw exception!:" + e2.toString());
            }
        }
    }

    @Override // d.b.m0.a.e.a.InterfaceC1747a
    public final void U() {
        this.f64827b = true;
        Runnable runnable = this.f64829d;
        if (runnable != null) {
            this.f64828c.removeCallbacks(runnable);
            this.f64829d = null;
        }
        f64825h = System.currentTimeMillis();
        d.b.m0.a.f.b.c(new c(this));
        Handler handler = this.f64828c;
        b bVar = new b();
        this.f64829d = bVar;
        handler.postDelayed(bVar, 1000L);
    }

    @Override // d.b.m0.a.e.a.InterfaceC1747a
    public final void a(Activity activity) {
    }

    public final void l(long j) {
        n nVar = new n();
        f64823f = nVar;
        nVar.setStartTime(String.valueOf(j));
        f64823f.x(UUID.randomUUID().toString().replace("-", ""));
        d.b.m0.a.f.b.c(new d(this));
    }

    @Override // d.b.m0.a.e.a.InterfaceC1747a
    public final void onActivityDestroyed(Activity activity) {
    }
}
