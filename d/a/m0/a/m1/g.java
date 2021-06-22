package d.a.m0.a.m1;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.j2.h;
import d.a.m0.a.j2.k;
/* loaded from: classes3.dex */
public class g implements d.a.m0.a.h0.j.c, d.a.m0.a.h0.j.e {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47259d = d.a.m0.a.a2.e.y;

    /* renamed from: e  reason: collision with root package name */
    public static volatile g f47260e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f47261a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47262b = false;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.a.m1.a f47263c = new b();

    /* loaded from: classes3.dex */
    public class a implements Action<d.a.m0.a.z1.b.b.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        /* renamed from: a */
        public void call(d.a.m0.a.z1.b.b.a aVar) {
            g.this.h(new d.a.m0.a.m1.h.a(aVar));
        }
    }

    public g() {
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", d.a.m0.a.z1.b.b.a.class, 0, new a());
    }

    public static void d() {
        c.a();
    }

    @NonNull
    public static g f() {
        if (f47260e == null) {
            synchronized (g.class) {
                if (f47260e == null) {
                    f47260e = new g();
                }
            }
        }
        return f47260e;
    }

    @Override // d.a.m0.a.h0.j.e
    public void a(d.a.m0.a.p.e.e eVar) {
        if (f47259d) {
            Log.d("SwanAppPageMonitor", "webview insert event");
        }
        h(new d.a.m0.a.m1.h.e(eVar, true));
    }

    @Override // d.a.m0.a.h0.j.e
    public void b(d.a.m0.a.p.e.e eVar) {
        if (f47259d) {
            Log.d("SwanAppPageMonitor", "webview remove event");
        }
        h(new d.a.m0.a.m1.h.e(eVar, false));
    }

    public int e() {
        return ((b) this.f47263c).d();
    }

    public final boolean g() {
        d.a.m0.a.c1.a.Z().getSwitch("swan_white_screen_forward", false);
        return false;
    }

    public final void h(d.a.m0.a.m1.h.c cVar) {
        this.f47263c.a(cVar);
    }

    public void i() {
        h(new d.a.m0.a.m1.h.c(11));
    }

    public void j(boolean z) {
        if (f47259d) {
            StringBuilder sb = new StringBuilder();
            sb.append("change to ");
            sb.append(z ? NotificationCompat.WearableExtender.KEY_BACKGROUND : Constant.FOREGROUND);
            Log.d("SwanAppPageMonitor", sb.toString());
        }
        h(new d.a.m0.a.m1.h.b(z));
    }

    public void k(boolean z) {
        if (h.f46913e) {
            if (z) {
                m();
            } else {
                l();
            }
        }
    }

    public final void l() {
        this.f47262b = true;
        h(new d.a.m0.a.m1.h.c(12, null, 0L, false));
        if (f47259d) {
            Log.d("SwanAPPPageMonitor-Route", "**************** page onPause cancel route monitor");
        }
    }

    public final void m() {
        if (this.f47262b) {
            h(new d.a.m0.a.m1.h.c(13, null, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL, false));
            if (f47259d) {
                Log.d("SwanAPPPageMonitor-Route", "**************** page onResume start route monitor, time=" + PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            }
        }
    }

    public void n(boolean z) {
        this.f47261a = z;
        if (z) {
            f.k();
            d.a.m0.a.j2.e.z();
            this.f47262b = false;
        }
    }

    public void o() {
        d.a.m0.a.m1.h.c cVar;
        b.a L;
        long o = d.a.m0.a.c1.a.Z().o();
        if (f47259d) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + o);
        }
        if (this.f47261a) {
            boolean g2 = g();
            if (f47259d) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + g2);
            }
            SwanAppActivity activity = d.a.m0.a.g1.f.V().getActivity();
            if (g2 && activity != null && (L = d.a.m0.a.a2.d.g().r().L()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - L.N();
                o -= currentTimeMillis;
                if (o < 0) {
                    if (f47259d) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
                    aVar.j(5L);
                    aVar.h(40L);
                    aVar.e("whitescreen monitor out of time: time=" + currentTimeMillis);
                    d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
                    dVar.q(k.m(L.G()));
                    dVar.p(aVar);
                    dVar.r(L);
                    k.L(dVar);
                }
            }
            cVar = new d.a.m0.a.m1.h.c(1, null, o, true);
            this.f47261a = false;
            this.f47262b = false;
            if (h.f46913e) {
                h(cVar);
            }
        } else {
            cVar = null;
        }
        if (f47259d) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + o);
        }
        if (h.f46913e) {
            return;
        }
        if (cVar == null) {
            cVar = new d.a.m0.a.m1.h.c(1, null, o);
        }
        h(cVar);
    }

    @Override // d.a.m0.a.h0.j.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        if (i4 == 0 && i5 == 0 && i2 == 0 && i3 == 1) {
            return;
        }
        h(new d.a.m0.a.m1.h.c(3));
    }

    public void p() {
        h(new d.a.m0.a.m1.h.c(9, null, 6000L));
    }

    public void q() {
        if (f47259d) {
            Log.d("SwanAppPageMonitor", "stop page monitoring");
        }
        h(new d.a.m0.a.m1.h.c(7));
    }
}
