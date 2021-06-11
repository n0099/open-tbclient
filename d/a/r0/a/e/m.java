package d.a.r0.a.e;

import android.app.Activity;
import android.os.Handler;
import com.baidu.ubs.analytics.a.n;
import d.a.r0.a.c;
import d.a.r0.a.e.a;
import d.a.r0.a.e.d;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class m implements a.InterfaceC1859a {

    /* renamed from: f  reason: collision with root package name */
    public static n f68155f;

    /* renamed from: g  reason: collision with root package name */
    public static long f68156g = f.a();

    /* renamed from: h  reason: collision with root package name */
    public static long f68157h;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f68161d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f68158a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68159b = true;

    /* renamed from: c  reason: collision with root package name */
    public Handler f68160c = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public e f68162e = new a();

    /* loaded from: classes5.dex */
    public class a implements e {

        /* renamed from: d.a.r0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1860a extends d.a.r0.a.f.c {
            public C1860a(a aVar) {
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
            if (currentTimeMillis - m.f68157h > m.f68156g) {
                m.this.l(currentTimeMillis);
            }
            if (d.a.r0.a.c.i().h()) {
                d.a.r0.a.f.b.a(new C1860a(this));
            }
        }

        @Override // d.a.r0.a.e.m.e
        public final void b() {
            d.a.r0.a.e.d dVar;
            dVar = d.a.f68131a;
            if (dVar.a().size() == 0) {
                d.a.r0.a.f.a.b("后台应用退出了 了               ");
                d.a.r0.a.c.i().d(true);
                long unused = m.f68157h = 0L;
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
            if (m.this.f68158a && m.this.f68159b) {
                m.this.f68158a = false;
                try {
                    m.this.f68162e.b();
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
            m.f68155f.z(String.valueOf(currentTimeMillis));
            try {
                m.f68155f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f68155f.N())));
            } catch (NumberFormatException e2) {
                d.a.r0.a.f.a.b(e2.getLocalizedMessage());
            }
            c.l lVar = new c.l();
            if (lVar.b(m.f68155f.I())) {
                lVar.e(m.f68155f);
            } else {
                lVar.f(m.f68155f);
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
            new c.l().f(m.f68155f);
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b();
    }

    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        f68157h = currentTimeMillis;
        l(currentTimeMillis);
    }

    public static n d() {
        return f68155f;
    }

    @Override // d.a.r0.a.e.a.InterfaceC1859a
    public final void T() {
        this.f68159b = false;
        boolean z = !this.f68158a;
        this.f68158a = true;
        Runnable runnable = this.f68161d;
        if (runnable != null) {
            this.f68160c.removeCallbacks(runnable);
        }
        if (z) {
            try {
                this.f68162e.a();
            } catch (Exception e2) {
                d.a.r0.a.f.i.b("Listener threw exception!:" + e2.toString());
            }
        }
    }

    @Override // d.a.r0.a.e.a.InterfaceC1859a
    public final void U() {
        this.f68159b = true;
        Runnable runnable = this.f68161d;
        if (runnable != null) {
            this.f68160c.removeCallbacks(runnable);
            this.f68161d = null;
        }
        f68157h = System.currentTimeMillis();
        d.a.r0.a.f.b.c(new c(this));
        Handler handler = this.f68160c;
        b bVar = new b();
        this.f68161d = bVar;
        handler.postDelayed(bVar, 1000L);
    }

    @Override // d.a.r0.a.e.a.InterfaceC1859a
    public final void a(Activity activity) {
    }

    public final void l(long j) {
        n nVar = new n();
        f68155f = nVar;
        nVar.setStartTime(String.valueOf(j));
        f68155f.x(UUID.randomUUID().toString().replace("-", ""));
        d.a.r0.a.f.b.c(new d(this));
    }

    @Override // d.a.r0.a.e.a.InterfaceC1859a
    public final void onActivityDestroyed(Activity activity) {
    }
}
