package d.a.s0.a.e;

import android.app.Activity;
import android.os.Handler;
import com.baidu.ubs.analytics.a.n;
import d.a.s0.a.c;
import d.a.s0.a.e.a;
import d.a.s0.a.e.d;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class m implements a.InterfaceC1863a {

    /* renamed from: f  reason: collision with root package name */
    public static n f68271f;

    /* renamed from: g  reason: collision with root package name */
    public static long f68272g = f.a();

    /* renamed from: h  reason: collision with root package name */
    public static long f68273h;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f68277d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f68274a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68275b = true;

    /* renamed from: c  reason: collision with root package name */
    public Handler f68276c = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public e f68278e = new a();

    /* loaded from: classes5.dex */
    public class a implements e {

        /* renamed from: d.a.s0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1864a extends d.a.s0.a.f.c {
            public C1864a(a aVar) {
            }

            @Override // d.a.s0.a.f.c
            public final void a() {
                d.a.s0.a.f.a.b("记录一次app启动事件");
                d.a.s0.a.a.c("power_on", "", "", null);
                d.a.s0.a.c.i().d(false);
            }
        }

        public a() {
        }

        @Override // d.a.s0.a.e.m.e
        public final void a() {
            long currentTimeMillis = System.currentTimeMillis();
            d.a.s0.a.f.a.b("app   went foreground ");
            if (currentTimeMillis - m.f68273h > m.f68272g) {
                m.this.l(currentTimeMillis);
            }
            if (d.a.s0.a.c.i().h()) {
                d.a.s0.a.f.b.a(new C1864a(this));
            }
        }

        @Override // d.a.s0.a.e.m.e
        public final void b() {
            d.a.s0.a.e.d dVar;
            dVar = d.a.f68247a;
            if (dVar.a().size() == 0) {
                d.a.s0.a.f.a.b("后台应用退出了 了               ");
                d.a.s0.a.c.i().d(true);
                long unused = m.f68273h = 0L;
                return;
            }
            d.a.s0.a.f.a.b("进入后台但没退出                  ");
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (m.this.f68274a && m.this.f68275b) {
                m.this.f68274a = false;
                try {
                    m.this.f68278e.b();
                } catch (Exception e2) {
                    d.a.s0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.a.s0.a.f.c {
        public c(m mVar) {
        }

        @Override // d.a.s0.a.f.c
        public final void a() {
            long currentTimeMillis = System.currentTimeMillis();
            m.f68271f.z(String.valueOf(currentTimeMillis));
            try {
                m.f68271f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f68271f.N())));
            } catch (NumberFormatException e2) {
                d.a.s0.a.f.a.b(e2.getLocalizedMessage());
            }
            c.l lVar = new c.l();
            if (lVar.b(m.f68271f.I())) {
                lVar.e(m.f68271f);
            } else {
                lVar.f(m.f68271f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.a.s0.a.f.c {
        public d(m mVar) {
        }

        @Override // d.a.s0.a.f.c
        public final void a() {
            d.a.s0.a.f.a.b("超时了……………… 一个新的session");
            new c.l().f(m.f68271f);
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b();
    }

    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        f68273h = currentTimeMillis;
        l(currentTimeMillis);
    }

    public static n d() {
        return f68271f;
    }

    @Override // d.a.s0.a.e.a.InterfaceC1863a
    public final void T() {
        this.f68275b = false;
        boolean z = !this.f68274a;
        this.f68274a = true;
        Runnable runnable = this.f68277d;
        if (runnable != null) {
            this.f68276c.removeCallbacks(runnable);
        }
        if (z) {
            try {
                this.f68278e.a();
            } catch (Exception e2) {
                d.a.s0.a.f.i.b("Listener threw exception!:" + e2.toString());
            }
        }
    }

    @Override // d.a.s0.a.e.a.InterfaceC1863a
    public final void U() {
        this.f68275b = true;
        Runnable runnable = this.f68277d;
        if (runnable != null) {
            this.f68276c.removeCallbacks(runnable);
            this.f68277d = null;
        }
        f68273h = System.currentTimeMillis();
        d.a.s0.a.f.b.c(new c(this));
        Handler handler = this.f68276c;
        b bVar = new b();
        this.f68277d = bVar;
        handler.postDelayed(bVar, 1000L);
    }

    @Override // d.a.s0.a.e.a.InterfaceC1863a
    public final void a(Activity activity) {
    }

    public final void l(long j) {
        n nVar = new n();
        f68271f = nVar;
        nVar.setStartTime(String.valueOf(j));
        f68271f.x(UUID.randomUUID().toString().replace("-", ""));
        d.a.s0.a.f.b.c(new d(this));
    }

    @Override // d.a.s0.a.e.a.InterfaceC1863a
    public final void onActivityDestroyed(Activity activity) {
    }
}
