package d.a.l0.a.h0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.l0.a.h0.i.a;
import d.a.l0.a.h0.i.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45853a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static c f45854b;

    /* renamed from: c  reason: collision with root package name */
    public static LinkedHashMap<String, String> f45855c;

    /* loaded from: classes2.dex */
    public static class a implements g.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.a f45856a;

        public a(g.a aVar) {
            this.f45856a = aVar;
        }

        @Override // d.a.l0.a.h0.i.g.a
        public void a(@NonNull g gVar) {
            this.f45856a.a(gVar);
            i.r(gVar);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f45857a;

        public b(d.a.l0.a.v2.e1.b bVar) {
            this.f45857a = bVar;
        }

        @Override // d.a.l0.a.h0.i.g.a
        public void a(@NonNull g gVar) {
            if (TextUtils.isEmpty(i.f45854b.f45863f)) {
                i.f45854b.f45863f = d.a.l0.a.h0.i.c.b("", gVar);
            }
            d.a.l0.a.v2.e1.b bVar = this.f45857a;
            if (bVar != null) {
                bVar.onCallback(i.f45854b.r(i.f45854b.f45863f));
            }
            if (i.f45853a) {
                Log.d("SwanAppLaunchTips", String.format("getLaunchInfo by click, consume time: %d ms，detail:%s", Long.valueOf(System.currentTimeMillis() - i.f45854b.s()), i.f45854b.f45863f));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f45876a;

        /* renamed from: b  reason: collision with root package name */
        public long f45877b;

        /* renamed from: c  reason: collision with root package name */
        public int f45878c;

        public d(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        public d(String str, long j, long j2, int i2) {
            this.f45876a = str;
            this.f45877b = j2;
            this.f45878c = i2;
        }
    }

    public static void c() {
        c cVar = f45854b;
        if (cVar != null) {
            cVar.o();
        }
    }

    public static void d(g.a aVar) {
        c cVar = f45854b;
        if (cVar != null) {
            cVar.q(aVar);
        }
    }

    public static synchronized void e() {
        synchronized (i.class) {
            if (f45854b != null) {
                e.e();
                f45854b.n();
            }
            f45854b = new c(null);
            if (f45855c != null) {
                for (Map.Entry<String, String> entry : f45855c.entrySet()) {
                    f45854b.w(entry.getKey(), entry.getValue());
                }
                f45854b.K(true);
                f45855c = null;
            }
        }
    }

    public static void f(d.a.l0.a.v2.e1.b<String> bVar) {
        c cVar = f45854b;
        if (cVar == null) {
            if (bVar != null) {
                bVar.onCallback("");
            }
        } else if (cVar.v() && !TextUtils.isEmpty(f45854b.f45863f)) {
            if (bVar != null) {
                c cVar2 = f45854b;
                bVar.onCallback(cVar2.r(cVar2.f45863f));
            }
        } else if (!f45854b.u() || TextUtils.isEmpty(f45854b.f45863f)) {
            f45854b.q(new b(bVar));
        } else if (bVar != null) {
            c cVar3 = f45854b;
            bVar.onCallback(cVar3.r(cVar3.f45863f));
        }
    }

    public static boolean g() {
        c cVar = f45854b;
        if (cVar == null) {
            return false;
        }
        return cVar.t();
    }

    public static void h(boolean z) {
        if (d.a.l0.a.a2.d.g().l() == 1) {
            return;
        }
        e();
        v();
        u();
        if (z) {
            t();
        }
    }

    public static void i(String str) {
        j(str, d.a.l0.a.v2.k.g(System.currentTimeMillis(), "【HH:mm:ss】"));
    }

    public static void j(String str, String str2) {
        c cVar = f45854b;
        if (cVar != null) {
            cVar.w(str, str2);
            return;
        }
        if (f45855c == null) {
            f45855c = new LinkedHashMap<>();
        }
        f45855c.put(str, str2);
    }

    public static void k() {
        c cVar = f45854b;
        if (cVar != null) {
            cVar.x();
        }
    }

    public static void l(long j) {
        c cVar = f45854b;
        if (cVar != null) {
            cVar.y(j);
        }
    }

    public static void m(a.C0722a c0722a) {
        c cVar = f45854b;
        if (cVar != null) {
            cVar.z(c0722a);
        }
    }

    public static void n(String str, int i2) {
        c cVar = f45854b;
        if (cVar != null) {
            cVar.A(str, i2);
        }
    }

    public static void o(String str) {
        c cVar = f45854b;
        if (cVar != null) {
            cVar.B(str);
        }
    }

    public static void p(String str, long j) {
        c cVar = f45854b;
        if (cVar != null) {
            cVar.C(str, j);
        }
    }

    public static void q(int i2) {
        c cVar = f45854b;
        if (cVar != null) {
            cVar.J(i2);
        }
    }

    public static void r(g gVar) {
        if (gVar == null) {
            return;
        }
        int i2 = d.a.l0.a.h.swanapp_tip_request_default;
        int d2 = gVar.d();
        d.a.l0.a.h0.i.a c2 = gVar.c();
        if (c2 != null && c2.c()) {
            i2 = d.a.l0.a.h.swanapp_tip_show_js_error;
        } else if (d2 != 1 && d2 != 2) {
            int f2 = gVar.f();
            if (f2 == 4) {
                i2 = d.a.l0.a.h.swanapp_tip_request_fail;
            } else if (f2 == 8) {
                i2 = d.a.l0.a.h.swanapp_tip_request_slow;
            }
        } else {
            i2 = d.a.l0.a.h.swanapp_tip_request_bad_network;
        }
        e.f(i2);
    }

    public static void s(g.a aVar) {
        c cVar = f45854b;
        if (cVar == null) {
            return;
        }
        cVar.q(new a(aVar));
    }

    public static void t() {
        c cVar = f45854b;
        if (cVar != null) {
            cVar.L();
        }
    }

    public static void u() {
        c cVar = f45854b;
        if (cVar != null) {
            cVar.M();
        }
    }

    public static synchronized void v() {
        synchronized (i.class) {
            if (f45854b != null) {
                f45854b.N();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {
        public static final long p = d.a.l0.a.c1.a.Z().o();

        /* renamed from: a  reason: collision with root package name */
        public long f45858a;

        /* renamed from: b  reason: collision with root package name */
        public List<d> f45859b;

        /* renamed from: c  reason: collision with root package name */
        public List<d> f45860c;

        /* renamed from: d  reason: collision with root package name */
        public List<d> f45861d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f45862e;

        /* renamed from: f  reason: collision with root package name */
        public String f45863f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f45864g;

        /* renamed from: h  reason: collision with root package name */
        public Timer f45865h;

        /* renamed from: i  reason: collision with root package name */
        public Timer f45866i;
        public Timer j;
        public long k;
        public int l;
        public d.a.l0.a.h0.i.a m;
        public boolean n;
        public long o;

        /* loaded from: classes2.dex */
        public class a extends TimerTask {
            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                c.this.f45862e = false;
                c.this.H();
            }
        }

        /* loaded from: classes2.dex */
        public class b extends d.a.l0.a.t0.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppActivity f45868a;

            public b(SwanAppActivity swanAppActivity) {
                this.f45868a = swanAppActivity;
            }

            @Override // d.a.l0.a.t0.a, d.a.l0.a.t0.b
            public void f() {
                if (c.this.I()) {
                    this.f45868a.unregisterCallback(this);
                }
            }
        }

        /* renamed from: d.a.l0.a.h0.i.i$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0724c implements SwanAppNetworkUtils.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f45870a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g.a f45871b;

            public C0724c(g gVar, g.a aVar) {
                this.f45870a = gVar;
                this.f45871b = aVar;
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i2) {
                if (i2 == 1) {
                    this.f45870a.j(0);
                } else if (i2 == 2) {
                    this.f45870a.j(1);
                } else if (i2 != 3) {
                    this.f45870a.j(3);
                } else {
                    this.f45870a.j(2);
                }
                if (c.this.f45860c.size() + c.this.f45859b.size() + c.this.f45861d.size() > 2 && System.currentTimeMillis() - c.this.k >= 3000) {
                    if (!c.this.E(this.f45870a)) {
                        if (c.this.F(this.f45870a)) {
                            this.f45870a.k(8);
                            this.f45871b.a(this.f45870a);
                            return;
                        }
                        this.f45871b.a(this.f45870a);
                        return;
                    }
                    this.f45870a.k(4);
                    this.f45871b.a(this.f45870a);
                    return;
                }
                this.f45870a.k(12);
                this.f45871b.a(this.f45870a);
            }
        }

        /* loaded from: classes2.dex */
        public class d extends TimerTask {

            /* loaded from: classes2.dex */
            public class a implements g.a {
                public a(d dVar) {
                }

                @Override // d.a.l0.a.h0.i.g.a
                public void a(@NonNull g gVar) {
                    if (q0.H()) {
                        f.c("fcp_timeout", gVar);
                        int d2 = gVar.d();
                        if (d2 == 1) {
                            i.i(d.a.l0.a.h0.i.c.b(d.a.l0.a.h0.i.c.f45838a, gVar));
                            d.a.l0.a.h0.i.e.f(d.a.l0.a.h.swanapp_tip_net_unavailable);
                        } else if (d2 != 2) {
                            i.i(d.a.l0.a.h0.i.c.b(d.a.l0.a.h0.i.c.f45838a, gVar));
                        } else {
                            i.i(d.a.l0.a.h0.i.c.b(d.a.l0.a.h0.i.c.f45838a, gVar));
                            d.a.l0.a.h0.i.e.f(d.a.l0.a.h.swanapp_tip_net_unavailable);
                        }
                    }
                }
            }

            public d() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (c.this.f45858a == 0 && d.a.l0.a.m1.g.f().e() == 0) {
                    c.this.q(new a(this));
                }
            }
        }

        /* loaded from: classes2.dex */
        public class e extends TimerTask {

            /* loaded from: classes2.dex */
            public class a implements g.a {
                public a() {
                }

                @Override // d.a.l0.a.h0.i.g.a
                public void a(@NonNull g gVar) {
                    if (TextUtils.isEmpty(c.this.f45863f)) {
                        c.this.f45863f = d.a.l0.a.h0.i.c.b("", gVar);
                        if (i.f45853a) {
                            Log.d("SwanAppLaunchTips", String.format("%d ms countdown end，collect launchInfo：%s", 6000L, c.this.f45863f));
                        }
                    }
                }
            }

            public e() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (c.this.u() || !TextUtils.isEmpty(c.this.f45863f)) {
                    return;
                }
                c.this.q(new a());
            }
        }

        public c() {
            this.f45858a = 0L;
            this.f45859b = new ArrayList();
            this.f45860c = new ArrayList();
            this.f45861d = new ArrayList();
            this.f45862e = true;
            this.f45863f = "";
            this.f45864g = false;
            this.k = 0L;
            this.l = 0;
            this.m = new d.a.l0.a.h0.i.a();
            this.n = false;
            this.o = s();
        }

        public synchronized void A(String str, int i2) {
            if (this.f45862e) {
                this.f45861d.add(new d(str, 0L, 0L, i2));
                D(str);
            }
        }

        public synchronized void B(String str) {
            if (this.f45862e) {
                this.f45859b.add(new d(str, System.currentTimeMillis(), 0L));
            }
        }

        public synchronized void C(String str, long j) {
            if (this.f45862e) {
                this.f45860c.add(new d(str, 0L, j));
                D(str);
            }
        }

        public final void D(String str) {
            for (int i2 = 0; i2 < this.f45859b.size(); i2++) {
                if (TextUtils.equals(this.f45859b.get(i2).f45876a, str)) {
                    List<d> list = this.f45859b;
                    list.remove(list.get(i2));
                    return;
                }
            }
        }

        public final boolean E(g gVar) {
            int i2;
            ArrayList arrayList = new ArrayList();
            int size = this.f45861d.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                d dVar = this.f45861d.get(i4);
                if (dVar != null && (i2 = dVar.f45878c) >= 400 && i2 < 600) {
                    i3++;
                    arrayList.add(dVar.f45876a);
                }
            }
            int size2 = this.f45860c.size() + i3 + this.f45859b.size();
            gVar.f45849c = arrayList;
            gVar.f45848b = size2;
            return ((double) i3) / ((double) size2) >= 0.5d;
        }

        public final boolean F(g gVar) {
            TreeMap treeMap = new TreeMap();
            int size = this.f45860c.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                d dVar = this.f45860c.get(i3);
                long j = dVar.f45877b;
                if (j > 3000) {
                    i2++;
                    treeMap.put(dVar.f45876a, Integer.valueOf((int) j));
                }
            }
            gVar.f45850d = treeMap;
            return i2 >= 2;
        }

        public void G() {
            Timer timer = this.f45865h;
            if (timer != null) {
                timer.cancel();
                this.f45865h = null;
            }
            this.f45858a = 0L;
        }

        public final void H() {
            Timer timer = this.f45866i;
            if (timer != null) {
                timer.cancel();
                this.f45866i = null;
            }
        }

        public final boolean I() {
            if (!this.f45864g || TextUtils.isEmpty(this.f45863f)) {
                return false;
            }
            d.a.l0.a.h0.i.b.h(s(), this.f45863f);
            this.f45864g = false;
            return true;
        }

        public void J(int i2) {
            this.l = i2;
        }

        public void K(boolean z) {
            this.f45864g = z;
        }

        public void L() {
            G();
            Timer timer = new Timer();
            this.f45865h = timer;
            timer.schedule(new d(), 3000L);
        }

        public void M() {
            Timer timer = this.j;
            if (timer != null) {
                timer.cancel();
                this.j = null;
            }
            Timer timer2 = new Timer();
            this.j = timer2;
            timer2.schedule(new e(), 6000L);
        }

        public void N() {
            if (this.f45862e) {
                this.k = System.currentTimeMillis();
                Timer timer = new Timer();
                this.f45866i = timer;
                timer.schedule(new a(), 6000L);
                SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                activity.registerCallback(new b(activity));
            }
        }

        public void n() {
            H();
        }

        public void o() {
            if (this.l == 1) {
                if (!TextUtils.equals(d.a.l0.a.g1.f.V().U(), d.a.l0.a.h0.i.d.a())) {
                    if (i.f45853a) {
                        Log.d("SwanAppLaunchTips", "current page is not skeleton error first page");
                        Log.d("SwanAppLaunchTips", "current page: " + d.a.l0.a.g1.f.V().U());
                        String a2 = d.a.l0.a.h0.i.d.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("skeleton error first page: ");
                        if (a2 == null) {
                            a2 = "";
                        }
                        sb.append(a2);
                        Log.d("SwanAppLaunchTips", sb.toString());
                        return;
                    }
                    return;
                }
                String D = d.a.l0.a.g1.f.V().D();
                if (TextUtils.isEmpty(D)) {
                    return;
                }
                d.a.l0.a.g1.f.V().m(D, new d.a.l0.a.o0.d.b("check-skeleton-status"));
            }
        }

        public void p(SwanAppNetworkUtils.b bVar) {
            this.f45864g = true;
            SwanAppNetworkUtils.b(bVar);
        }

        public void q(g.a aVar) {
            g gVar = new g();
            gVar.h(System.currentTimeMillis() - this.k);
            gVar.i(this.m);
            p(new C0724c(gVar, aVar));
        }

        public String r(String str) {
            StringBuilder sb = new StringBuilder(d.a.l0.a.c1.a.b().getText(d.a.l0.a.h.swanapp_tip_cur_title));
            sb.append(str);
            String e2 = d.a.l0.a.h0.i.b.e();
            if (!TextUtils.isEmpty(e2)) {
                sb.append(e2);
            }
            return sb.toString();
        }

        public final long s() {
            d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
            if (Q != null) {
                return Q.L().l("launch_time", 0L);
            }
            return 0L;
        }

        public boolean t() {
            return this.m.c();
        }

        public boolean u() {
            return this.n;
        }

        public boolean v() {
            return System.currentTimeMillis() - this.o > ((long) ((p > 6000L ? 1 : (p == 6000L ? 0 : -1)) >= 0 ? 10000 : 7000));
        }

        public void w(String str, String str2) {
            if (v()) {
                d.a.l0.a.e0.d.h("SwanAppLaunchTips", "the log has expired, content=" + str2 + str);
                return;
            }
            String str3 = "\n" + str2 + str;
            if (!TextUtils.isEmpty(this.f45863f)) {
                str3 = this.f45863f + str3;
            }
            this.f45863f = str3;
            if (i.f45853a) {
                Log.d("SwanAppLaunchTips", str);
            }
            d.a.l0.a.e0.d.h("SwanAppLaunchTips", str2 + str);
        }

        public void x() {
            this.n = true;
        }

        public void y(long j) {
            if (this.f45858a == 0) {
                this.f45858a = j;
            }
        }

        public void z(@NonNull a.C0722a c0722a) {
            boolean z = u() || v();
            if (i.f45853a) {
                Log.d("SwanAppLaunchTips", String.format("onJsError needFilter ?: %s, content:%s", Boolean.valueOf(z), c0722a.toString()));
            }
            if (z) {
                return;
            }
            this.m.a(c0722a);
        }

        public /* synthetic */ c(h hVar) {
            this();
        }
    }
}
