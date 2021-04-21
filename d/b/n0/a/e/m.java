package d.b.n0.a.e;

import android.app.Activity;
import android.os.Handler;
import com.baidu.ubs.analytics.a.n;
import d.b.n0.a.c;
import d.b.n0.a.e.a;
import d.b.n0.a.e.d;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class m implements a.InterfaceC1766a {

    /* renamed from: f  reason: collision with root package name */
    public static n f65091f;

    /* renamed from: g  reason: collision with root package name */
    public static long f65092g = f.a();

    /* renamed from: h  reason: collision with root package name */
    public static long f65093h;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f65097d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f65094a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65095b = true;

    /* renamed from: c  reason: collision with root package name */
    public Handler f65096c = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public e f65098e = new a();

    /* loaded from: classes5.dex */
    public class a implements e {

        /* renamed from: d.b.n0.a.e.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1767a extends d.b.n0.a.f.c {
            public C1767a(a aVar) {
            }

            @Override // d.b.n0.a.f.c
            public final void a() {
                d.b.n0.a.f.a.b("记录一次app启动事件");
                d.b.n0.a.a.c("power_on", "", "", null);
                d.b.n0.a.c.i().d(false);
            }
        }

        public a() {
        }

        @Override // d.b.n0.a.e.m.e
        public final void a() {
            long currentTimeMillis = System.currentTimeMillis();
            d.b.n0.a.f.a.b("app   went foreground ");
            if (currentTimeMillis - m.f65093h > m.f65092g) {
                m.this.l(currentTimeMillis);
            }
            if (d.b.n0.a.c.i().h()) {
                d.b.n0.a.f.b.a(new C1767a(this));
            }
        }

        @Override // d.b.n0.a.e.m.e
        public final void b() {
            d.b.n0.a.e.d dVar;
            dVar = d.a.f65067a;
            if (dVar.a().size() == 0) {
                d.b.n0.a.f.a.b("后台应用退出了 了               ");
                d.b.n0.a.c.i().d(true);
                long unused = m.f65093h = 0L;
                return;
            }
            d.b.n0.a.f.a.b("进入后台但没退出                  ");
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (m.this.f65094a && m.this.f65095b) {
                m.this.f65094a = false;
                try {
                    m.this.f65098e.b();
                } catch (Exception e2) {
                    d.b.n0.a.f.i.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d.b.n0.a.f.c {
        public c(m mVar) {
        }

        @Override // d.b.n0.a.f.c
        public final void a() {
            long currentTimeMillis = System.currentTimeMillis();
            m.f65091f.z(String.valueOf(currentTimeMillis));
            try {
                m.f65091f.A(String.valueOf(currentTimeMillis - Long.parseLong(m.f65091f.N())));
            } catch (NumberFormatException e2) {
                d.b.n0.a.f.a.b(e2.getLocalizedMessage());
            }
            c.l lVar = new c.l();
            if (lVar.b(m.f65091f.I())) {
                lVar.e(m.f65091f);
            } else {
                lVar.f(m.f65091f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d.b.n0.a.f.c {
        public d(m mVar) {
        }

        @Override // d.b.n0.a.f.c
        public final void a() {
            d.b.n0.a.f.a.b("超时了……………… 一个新的session");
            new c.l().f(m.f65091f);
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b();
    }

    public m() {
        long currentTimeMillis = System.currentTimeMillis();
        f65093h = currentTimeMillis;
        l(currentTimeMillis);
    }

    public static n d() {
        return f65091f;
    }

    @Override // d.b.n0.a.e.a.InterfaceC1766a
    public final void T() {
        this.f65095b = false;
        boolean z = !this.f65094a;
        this.f65094a = true;
        Runnable runnable = this.f65097d;
        if (runnable != null) {
            this.f65096c.removeCallbacks(runnable);
        }
        if (z) {
            try {
                this.f65098e.a();
            } catch (Exception e2) {
                d.b.n0.a.f.i.b("Listener threw exception!:" + e2.toString());
            }
        }
    }

    @Override // d.b.n0.a.e.a.InterfaceC1766a
    public final void U() {
        this.f65095b = true;
        Runnable runnable = this.f65097d;
        if (runnable != null) {
            this.f65096c.removeCallbacks(runnable);
            this.f65097d = null;
        }
        f65093h = System.currentTimeMillis();
        d.b.n0.a.f.b.c(new c(this));
        Handler handler = this.f65096c;
        b bVar = new b();
        this.f65097d = bVar;
        handler.postDelayed(bVar, 1000L);
    }

    @Override // d.b.n0.a.e.a.InterfaceC1766a
    public final void a(Activity activity) {
    }

    public final void l(long j) {
        n nVar = new n();
        f65091f = nVar;
        nVar.setStartTime(String.valueOf(j));
        f65091f.x(UUID.randomUUID().toString().replace("-", ""));
        d.b.n0.a.f.b.c(new d(this));
    }

    @Override // d.b.n0.a.e.a.InterfaceC1766a
    public final void onActivityDestroyed(Activity activity) {
    }
}
