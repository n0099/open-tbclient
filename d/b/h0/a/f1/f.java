package d.b.h0.a.f1;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.h0.a.y0.e.b;
import d.b.h0.a.z1.h;
/* loaded from: classes2.dex */
public class f implements d.b.h0.a.e0.n.c, d.b.h0.a.e0.n.e {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45154c = d.b.h0.a.r1.e.x;

    /* renamed from: d  reason: collision with root package name */
    public static f f45155d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f45156a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.a.f1.a f45157b = new b();

    /* loaded from: classes2.dex */
    public class a implements h.n.b<d.b.h0.a.q1.b.b.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(d.b.h0.a.q1.b.b.a aVar) {
            f.this.g(new d.b.h0.a.f1.g.a(aVar));
        }
    }

    public f() {
        EventBusWrapper.lazyRegister("dialog_event_tag", d.b.h0.a.q1.b.b.a.class, new a());
    }

    public static void d() {
        c.a();
    }

    @NonNull
    public static f e() {
        if (f45155d == null) {
            synchronized (f.class) {
                if (f45155d == null) {
                    f45155d = new f();
                }
            }
        }
        return f45155d;
    }

    public static boolean f() {
        if (d.b.h0.a.j1.m.b.e()) {
            return d.b.h0.a.j1.m.b.d();
        }
        d.b.h0.a.w0.a.N().getSwitch("swan_white_screen_forward", false);
        return false;
    }

    @Override // d.b.h0.a.e0.n.e
    public void a(d.b.h0.a.p.d.e eVar) {
        if (f45154c) {
            Log.d("SwanAppPageMonitor", "webview insert event");
        }
        g(new d.b.h0.a.f1.g.e(eVar, true));
    }

    @Override // d.b.h0.a.e0.n.e
    public void b(d.b.h0.a.p.d.e eVar) {
        if (f45154c) {
            Log.d("SwanAppPageMonitor", "webview remove event");
        }
        g(new d.b.h0.a.f1.g.e(eVar, false));
    }

    public final void g(d.b.h0.a.f1.g.c cVar) {
        this.f45157b.a(cVar);
    }

    public void h(boolean z) {
        if (f45154c) {
            StringBuilder sb = new StringBuilder();
            sb.append("change to ");
            sb.append(z ? NotificationCompat.WearableExtender.KEY_BACKGROUND : Constant.FOREGROUND);
            Log.d("SwanAppPageMonitor", sb.toString());
        }
        g(new d.b.h0.a.f1.g.b(z));
    }

    public void i(boolean z) {
        this.f45156a = z;
        if (z) {
            e.k();
            d.b.h0.a.z1.e.w();
        }
    }

    public void j() {
        d.b.h0.a.f1.g.c cVar;
        b.a J;
        long t = d.b.h0.a.w0.a.N().t();
        if (f45154c) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + t);
        }
        if (this.f45156a) {
            boolean f2 = f();
            if (f45154c) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + f2);
            }
            SwanAppActivity activity = d.b.h0.a.z0.f.V().getActivity();
            if (f2 && activity != null && (J = d.b.h0.a.r1.d.e().s().J()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - J.M();
                t -= currentTimeMillis;
                if (t < 0) {
                    if (f45154c) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    d.b.h0.a.f2.a aVar = new d.b.h0.a.f2.a();
                    aVar.j(5L);
                    aVar.h(40L);
                    aVar.e("whitescreen monitor out of time: time=" + currentTimeMillis);
                    d.b.h0.a.z1.k.d dVar = new d.b.h0.a.z1.k.d();
                    dVar.q(h.n(J.F()));
                    dVar.p(aVar);
                    dVar.r(J);
                    h.H(dVar);
                }
            }
            cVar = new d.b.h0.a.f1.g.c(1, null, t, true);
            this.f45156a = false;
        } else {
            cVar = null;
        }
        if (f45154c) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + t);
        }
        if (cVar == null) {
            cVar = new d.b.h0.a.f1.g.c(1, null, t);
        }
        g(cVar);
    }

    public void k() {
        g(new d.b.h0.a.f1.g.c(9, null, 6000L));
    }

    public void l() {
        if (f45154c) {
            Log.d("SwanAppPageMonitor", "stop page monitoring");
        }
        g(new d.b.h0.a.f1.g.c(7));
    }

    @Override // d.b.h0.a.e0.n.c
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0 && i == 0 && i2 == 1) {
            return;
        }
        g(new d.b.h0.a.f1.g.c(3));
    }
}
