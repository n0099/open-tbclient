package d.a.n0.a.e;

import android.app.Activity;
import android.os.Handler;
import com.baidu.ubs.analytics.a.n;
import d.a.n0.a.c;
import d.a.n0.a.e.a;
import d.a.n0.a.e.d;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class m implements a.InterfaceC1704a {

    /* renamed from: f  reason: collision with root package name */
    public static n f63402f;

    /* renamed from: g  reason: collision with root package name */
    public static long f63403g = f.a();

    /* renamed from: h  reason: collision with root package name */
    public static long f63404h;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f63408d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f63405a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63406b = true;

    /* renamed from: c  reason: collision with root package name */
    public Handler f63407c = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public e f63409e = new a();

    /* loaded from: classes5.dex */
    public class a implements e {

        /* renamed from: d.a.n0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1705a extends d.a.n0.a.f.c {
            public C1705a(a aVar) {
            }

            @Override // d.a.n0.a.f.c
            public final void a() {
                d.a.n0.a.f.a.b("记录一次app启动事件");
                d.a.n0.a.a.c("power_on", "", "", null);
                d.a.n0.a.c.i().d(false);
            }
        }

        public a() {
        }

        @Override // d.a.n0.a.e.m.e
        public final void a() {
            long currentTimeMillis = System.currentTimeMillis();
            d.a.n0.a.f.a.b("app   went foreground ");
            if (currentTimeMillis - m.f63404h > m.f63403g) {
                m.this.l(currentTimeMillis);
            }
            if (d.a.n0.a.c.i().h()) {
                d.a.n0.a.f.b.a(new C1705a(this));
            }
        }

        @Override // d.a.n0.a.e.m.e
        public final void b() {
            d.a.n0.a.e.d dVar;
            dVar = d.a.f63378a;
            if (dVar.a().size() == 0) {
                d.a.n0.a.f.a.b("后台应用退出了 了               ");
                d.a.n0.a.c.i().d(true);
                long unused = m.f63404h = 0L;
                return;
            }
            d.a.n0.a.f.a.b("进入后台但没退出                  ");
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (m.this.f63405a && m.this.f63406b) {
                m.this.f63405a = false;
                try {
                    m.this.f63409e.b();
                } catch (Exception e2) {
                    d.a.n0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.a.n0.a.f.c {
        public c(m mVar) {
        }

        @Override // d.a.n0.a.f.c
        public final void a() {
            long currentTimeMillis = System.currentTimeMillis();
            m.f63402f.z(String.valueOf(currentTimeMillis));
            try {
                m.f63402f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f63402f.N())));
            } catch (NumberFormatException e2) {
                d.a.n0.a.f.a.b(e2.getLocalizedMessage());
            }
            c.l lVar = new c.l();
            if (lVar.b(m.f63402f.I())) {
                lVar.e(m.f63402f);
            } else {
                lVar.f(m.f63402f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.a.n0.a.f.c {
        public d(m mVar) {
        }

        @Override // d.a.n0.a.f.c
        public final void a() {
            d.a.n0.a.f.a.b("超时了……………… 一个新的session");
            new c.l().f(m.f63402f);
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b();
    }

    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        f63404h = currentTimeMillis;
        l(currentTimeMillis);
    }

    public static n d() {
        return f63402f;
    }

    @Override // d.a.n0.a.e.a.InterfaceC1704a
    public final void T() {
        this.f63406b = false;
        boolean z = !this.f63405a;
        this.f63405a = true;
        Runnable runnable = this.f63408d;
        if (runnable != null) {
            this.f63407c.removeCallbacks(runnable);
        }
        if (z) {
            try {
                this.f63409e.a();
            } catch (Exception e2) {
                d.a.n0.a.f.i.b("Listener threw exception!:" + e2.toString());
            }
        }
    }

    @Override // d.a.n0.a.e.a.InterfaceC1704a
    public final void U() {
        this.f63406b = true;
        Runnable runnable = this.f63408d;
        if (runnable != null) {
            this.f63407c.removeCallbacks(runnable);
            this.f63408d = null;
        }
        f63404h = System.currentTimeMillis();
        d.a.n0.a.f.b.c(new c(this));
        Handler handler = this.f63407c;
        b bVar = new b();
        this.f63408d = bVar;
        handler.postDelayed(bVar, 1000L);
    }

    @Override // d.a.n0.a.e.a.InterfaceC1704a
    public final void a(Activity activity) {
    }

    public final void l(long j) {
        n nVar = new n();
        f63402f = nVar;
        nVar.setStartTime(String.valueOf(j));
        f63402f.x(UUID.randomUUID().toString().replace("-", ""));
        d.a.n0.a.f.b.c(new d(this));
    }

    @Override // d.a.n0.a.e.a.InterfaceC1704a
    public final void onActivityDestroyed(Activity activity) {
    }
}
