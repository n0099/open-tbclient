package d.a.h0.a.f1;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.z1.h;
/* loaded from: classes3.dex */
public class f implements d.a.h0.a.e0.n.c, d.a.h0.a.e0.n.e {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42465c = d.a.h0.a.r1.e.x;

    /* renamed from: d  reason: collision with root package name */
    public static f f42466d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42467a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.a.f1.a f42468b = new b();

    /* loaded from: classes3.dex */
    public class a implements h.n.b<d.a.h0.a.q1.b.b.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(d.a.h0.a.q1.b.b.a aVar) {
            f.this.g(new d.a.h0.a.f1.g.a(aVar));
        }
    }

    public f() {
        EventBusWrapper.lazyRegister("dialog_event_tag", d.a.h0.a.q1.b.b.a.class, new a());
    }

    public static void d() {
        c.a();
    }

    @NonNull
    public static f e() {
        if (f42466d == null) {
            synchronized (f.class) {
                if (f42466d == null) {
                    f42466d = new f();
                }
            }
        }
        return f42466d;
    }

    public static boolean f() {
        if (d.a.h0.a.j1.m.b.e()) {
            return d.a.h0.a.j1.m.b.d();
        }
        d.a.h0.a.w0.a.N().getSwitch("swan_white_screen_forward", false);
        return false;
    }

    @Override // d.a.h0.a.e0.n.e
    public void a(d.a.h0.a.p.d.e eVar) {
        if (f42465c) {
            Log.d("SwanAppPageMonitor", "webview insert event");
        }
        g(new d.a.h0.a.f1.g.e(eVar, true));
    }

    @Override // d.a.h0.a.e0.n.e
    public void b(d.a.h0.a.p.d.e eVar) {
        if (f42465c) {
            Log.d("SwanAppPageMonitor", "webview remove event");
        }
        g(new d.a.h0.a.f1.g.e(eVar, false));
    }

    public final void g(d.a.h0.a.f1.g.c cVar) {
        this.f42468b.a(cVar);
    }

    public void h(boolean z) {
        if (f42465c) {
            StringBuilder sb = new StringBuilder();
            sb.append("change to ");
            sb.append(z ? NotificationCompat.WearableExtender.KEY_BACKGROUND : Constant.FOREGROUND);
            Log.d("SwanAppPageMonitor", sb.toString());
        }
        g(new d.a.h0.a.f1.g.b(z));
    }

    public void i(boolean z) {
        this.f42467a = z;
        if (z) {
            e.k();
            d.a.h0.a.z1.e.w();
        }
    }

    public void j() {
        d.a.h0.a.f1.g.c cVar;
        b.a J;
        long k = d.a.h0.a.w0.a.N().k();
        if (f42465c) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + k);
        }
        if (this.f42467a) {
            boolean f2 = f();
            if (f42465c) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + f2);
            }
            SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
            if (f2 && activity != null && (J = d.a.h0.a.r1.d.e().p().J()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - J.M();
                k -= currentTimeMillis;
                if (k < 0) {
                    if (f42465c) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(40L);
                    aVar.e("whitescreen monitor out of time: time=" + currentTimeMillis);
                    d.a.h0.a.z1.k.d dVar = new d.a.h0.a.z1.k.d();
                    dVar.q(h.n(J.F()));
                    dVar.p(aVar);
                    dVar.r(J);
                    h.H(dVar);
                }
            }
            cVar = new d.a.h0.a.f1.g.c(1, null, k, true);
            this.f42467a = false;
        } else {
            cVar = null;
        }
        if (f42465c) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + k);
        }
        if (cVar == null) {
            cVar = new d.a.h0.a.f1.g.c(1, null, k);
        }
        g(cVar);
    }

    public void k() {
        g(new d.a.h0.a.f1.g.c(9, null, 6000L));
    }

    public void l() {
        if (f42465c) {
            Log.d("SwanAppPageMonitor", "stop page monitoring");
        }
        g(new d.a.h0.a.f1.g.c(7));
    }

    @Override // d.a.h0.a.e0.n.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        if (i4 == 0 && i5 == 0 && i2 == 0 && i3 == 1) {
            return;
        }
        g(new d.a.h0.a.f1.g.c(3));
    }
}
