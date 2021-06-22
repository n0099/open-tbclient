package d.a.m0.a.h0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.m0.a.h0.i.a;
import d.a.m0.a.h0.i.g;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45961a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static c f45962b;

    /* renamed from: c  reason: collision with root package name */
    public static LinkedHashMap<String, String> f45963c;

    /* loaded from: classes3.dex */
    public static class a implements g.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.a f45964a;

        public a(g.a aVar) {
            this.f45964a = aVar;
        }

        @Override // d.a.m0.a.h0.i.g.a
        public void a(@NonNull g gVar) {
            this.f45964a.a(gVar);
            i.r(gVar);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v2.e1.b f45965a;

        public b(d.a.m0.a.v2.e1.b bVar) {
            this.f45965a = bVar;
        }

        @Override // d.a.m0.a.h0.i.g.a
        public void a(@NonNull g gVar) {
            if (TextUtils.isEmpty(i.f45962b.f45971f)) {
                i.f45962b.f45971f = d.a.m0.a.h0.i.c.b("", gVar);
            }
            d.a.m0.a.v2.e1.b bVar = this.f45965a;
            if (bVar != null) {
                bVar.onCallback(i.f45962b.r(i.f45962b.f45971f));
            }
            if (i.f45961a) {
                Log.d("SwanAppLaunchTips", String.format("getLaunchInfo by click, consume time: %d ms，detail:%s", Long.valueOf(System.currentTimeMillis() - i.f45962b.s()), i.f45962b.f45971f));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f45984a;

        /* renamed from: b  reason: collision with root package name */
        public long f45985b;

        /* renamed from: c  reason: collision with root package name */
        public int f45986c;

        public d(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        public d(String str, long j, long j2, int i2) {
            this.f45984a = str;
            this.f45985b = j2;
            this.f45986c = i2;
        }
    }

    public static void c() {
        c cVar = f45962b;
        if (cVar != null) {
            cVar.o();
        }
    }

    public static void d(g.a aVar) {
        c cVar = f45962b;
        if (cVar != null) {
            cVar.q(aVar);
        }
    }

    public static synchronized void e() {
        synchronized (i.class) {
            if (f45962b != null) {
                e.e();
                f45962b.n();
            }
            f45962b = new c(null);
            if (f45963c != null) {
                for (Map.Entry<String, String> entry : f45963c.entrySet()) {
                    f45962b.w(entry.getKey(), entry.getValue());
                }
                f45962b.K(true);
                f45963c = null;
            }
        }
    }

    public static void f(d.a.m0.a.v2.e1.b<String> bVar) {
        c cVar = f45962b;
        if (cVar == null) {
            if (bVar != null) {
                bVar.onCallback("");
            }
        } else if (cVar.v() && !TextUtils.isEmpty(f45962b.f45971f)) {
            if (bVar != null) {
                c cVar2 = f45962b;
                bVar.onCallback(cVar2.r(cVar2.f45971f));
            }
        } else if (!f45962b.u() || TextUtils.isEmpty(f45962b.f45971f)) {
            f45962b.q(new b(bVar));
        } else if (bVar != null) {
            c cVar3 = f45962b;
            bVar.onCallback(cVar3.r(cVar3.f45971f));
        }
    }

    public static boolean g() {
        c cVar = f45962b;
        if (cVar == null) {
            return false;
        }
        return cVar.t();
    }

    public static void h(boolean z) {
        if (d.a.m0.a.a2.d.g().l() == 1) {
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
        j(str, d.a.m0.a.v2.k.g(System.currentTimeMillis(), "【HH:mm:ss】"));
    }

    public static void j(String str, String str2) {
        c cVar = f45962b;
        if (cVar != null) {
            cVar.w(str, str2);
            return;
        }
        if (f45963c == null) {
            f45963c = new LinkedHashMap<>();
        }
        f45963c.put(str, str2);
    }

    public static void k() {
        c cVar = f45962b;
        if (cVar != null) {
            cVar.x();
        }
    }

    public static void l(long j) {
        c cVar = f45962b;
        if (cVar != null) {
            cVar.y(j);
        }
    }

    public static void m(a.C0725a c0725a) {
        c cVar = f45962b;
        if (cVar != null) {
            cVar.z(c0725a);
        }
    }

    public static void n(String str, int i2) {
        c cVar = f45962b;
        if (cVar != null) {
            cVar.A(str, i2);
        }
    }

    public static void o(String str) {
        c cVar = f45962b;
        if (cVar != null) {
            cVar.B(str);
        }
    }

    public static void p(String str, long j) {
        c cVar = f45962b;
        if (cVar != null) {
            cVar.C(str, j);
        }
    }

    public static void q(int i2) {
        c cVar = f45962b;
        if (cVar != null) {
            cVar.J(i2);
        }
    }

    public static void r(g gVar) {
        if (gVar == null) {
            return;
        }
        int i2 = d.a.m0.a.h.swanapp_tip_request_default;
        int d2 = gVar.d();
        d.a.m0.a.h0.i.a c2 = gVar.c();
        if (c2 != null && c2.c()) {
            i2 = d.a.m0.a.h.swanapp_tip_show_js_error;
        } else if (d2 != 1 && d2 != 2) {
            int f2 = gVar.f();
            if (f2 == 4) {
                i2 = d.a.m0.a.h.swanapp_tip_request_fail;
            } else if (f2 == 8) {
                i2 = d.a.m0.a.h.swanapp_tip_request_slow;
            }
        } else {
            i2 = d.a.m0.a.h.swanapp_tip_request_bad_network;
        }
        e.f(i2);
    }

    public static void s(g.a aVar) {
        c cVar = f45962b;
        if (cVar == null) {
            return;
        }
        cVar.q(new a(aVar));
    }

    public static void t() {
        c cVar = f45962b;
        if (cVar != null) {
            cVar.L();
        }
    }

    public static void u() {
        c cVar = f45962b;
        if (cVar != null) {
            cVar.M();
        }
    }

    public static synchronized void v() {
        synchronized (i.class) {
            if (f45962b != null) {
                f45962b.N();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {
        public static final long p = d.a.m0.a.c1.a.Z().o();

        /* renamed from: a  reason: collision with root package name */
        public long f45966a;

        /* renamed from: b  reason: collision with root package name */
        public List<d> f45967b;

        /* renamed from: c  reason: collision with root package name */
        public List<d> f45968c;

        /* renamed from: d  reason: collision with root package name */
        public List<d> f45969d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f45970e;

        /* renamed from: f  reason: collision with root package name */
        public String f45971f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f45972g;

        /* renamed from: h  reason: collision with root package name */
        public Timer f45973h;

        /* renamed from: i  reason: collision with root package name */
        public Timer f45974i;
        public Timer j;
        public long k;
        public int l;
        public d.a.m0.a.h0.i.a m;
        public boolean n;
        public long o;

        /* loaded from: classes3.dex */
        public class a extends TimerTask {
            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                c.this.f45970e = false;
                c.this.H();
            }
        }

        /* loaded from: classes3.dex */
        public class b extends d.a.m0.a.t0.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppActivity f45976a;

            public b(SwanAppActivity swanAppActivity) {
                this.f45976a = swanAppActivity;
            }

            @Override // d.a.m0.a.t0.a, d.a.m0.a.t0.b
            public void f() {
                if (c.this.I()) {
                    this.f45976a.unregisterCallback(this);
                }
            }
        }

        /* renamed from: d.a.m0.a.h0.i.i$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0727c implements SwanAppNetworkUtils.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f45978a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g.a f45979b;

            public C0727c(g gVar, g.a aVar) {
                this.f45978a = gVar;
                this.f45979b = aVar;
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i2) {
                if (i2 == 1) {
                    this.f45978a.j(0);
                } else if (i2 == 2) {
                    this.f45978a.j(1);
                } else if (i2 != 3) {
                    this.f45978a.j(3);
                } else {
                    this.f45978a.j(2);
                }
                if (c.this.f45968c.size() + c.this.f45967b.size() + c.this.f45969d.size() > 2 && System.currentTimeMillis() - c.this.k >= 3000) {
                    if (!c.this.E(this.f45978a)) {
                        if (c.this.F(this.f45978a)) {
                            this.f45978a.k(8);
                            this.f45979b.a(this.f45978a);
                            return;
                        }
                        this.f45979b.a(this.f45978a);
                        return;
                    }
                    this.f45978a.k(4);
                    this.f45979b.a(this.f45978a);
                    return;
                }
                this.f45978a.k(12);
                this.f45979b.a(this.f45978a);
            }
        }

        /* loaded from: classes3.dex */
        public class d extends TimerTask {

            /* loaded from: classes3.dex */
            public class a implements g.a {
                public a(d dVar) {
                }

                @Override // d.a.m0.a.h0.i.g.a
                public void a(@NonNull g gVar) {
                    if (q0.H()) {
                        f.c("fcp_timeout", gVar);
                        int d2 = gVar.d();
                        if (d2 == 1) {
                            i.i(d.a.m0.a.h0.i.c.b(d.a.m0.a.h0.i.c.f45946a, gVar));
                            d.a.m0.a.h0.i.e.f(d.a.m0.a.h.swanapp_tip_net_unavailable);
                        } else if (d2 != 2) {
                            i.i(d.a.m0.a.h0.i.c.b(d.a.m0.a.h0.i.c.f45946a, gVar));
                        } else {
                            i.i(d.a.m0.a.h0.i.c.b(d.a.m0.a.h0.i.c.f45946a, gVar));
                            d.a.m0.a.h0.i.e.f(d.a.m0.a.h.swanapp_tip_net_unavailable);
                        }
                    }
                }
            }

            public d() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (c.this.f45966a == 0 && d.a.m0.a.m1.g.f().e() == 0) {
                    c.this.q(new a(this));
                }
            }
        }

        /* loaded from: classes3.dex */
        public class e extends TimerTask {

            /* loaded from: classes3.dex */
            public class a implements g.a {
                public a() {
                }

                @Override // d.a.m0.a.h0.i.g.a
                public void a(@NonNull g gVar) {
                    if (TextUtils.isEmpty(c.this.f45971f)) {
                        c.this.f45971f = d.a.m0.a.h0.i.c.b("", gVar);
                        if (i.f45961a) {
                            Log.d("SwanAppLaunchTips", String.format("%d ms countdown end，collect launchInfo：%s", 6000L, c.this.f45971f));
                        }
                    }
                }
            }

            public e() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (c.this.u() || !TextUtils.isEmpty(c.this.f45971f)) {
                    return;
                }
                c.this.q(new a());
            }
        }

        public c() {
            this.f45966a = 0L;
            this.f45967b = new ArrayList();
            this.f45968c = new ArrayList();
            this.f45969d = new ArrayList();
            this.f45970e = true;
            this.f45971f = "";
            this.f45972g = false;
            this.k = 0L;
            this.l = 0;
            this.m = new d.a.m0.a.h0.i.a();
            this.n = false;
            this.o = s();
        }

        public synchronized void A(String str, int i2) {
            if (this.f45970e) {
                this.f45969d.add(new d(str, 0L, 0L, i2));
                D(str);
            }
        }

        public synchronized void B(String str) {
            if (this.f45970e) {
                this.f45967b.add(new d(str, System.currentTimeMillis(), 0L));
            }
        }

        public synchronized void C(String str, long j) {
            if (this.f45970e) {
                this.f45968c.add(new d(str, 0L, j));
                D(str);
            }
        }

        public final void D(String str) {
            for (int i2 = 0; i2 < this.f45967b.size(); i2++) {
                if (TextUtils.equals(this.f45967b.get(i2).f45984a, str)) {
                    List<d> list = this.f45967b;
                    list.remove(list.get(i2));
                    return;
                }
            }
        }

        public final boolean E(g gVar) {
            int i2;
            ArrayList arrayList = new ArrayList();
            int size = this.f45969d.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                d dVar = this.f45969d.get(i4);
                if (dVar != null && (i2 = dVar.f45986c) >= 400 && i2 < 600) {
                    i3++;
                    arrayList.add(dVar.f45984a);
                }
            }
            int size2 = this.f45968c.size() + i3 + this.f45967b.size();
            gVar.f45957c = arrayList;
            gVar.f45956b = size2;
            return ((double) i3) / ((double) size2) >= 0.5d;
        }

        public final boolean F(g gVar) {
            TreeMap treeMap = new TreeMap();
            int size = this.f45968c.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                d dVar = this.f45968c.get(i3);
                long j = dVar.f45985b;
                if (j > 3000) {
                    i2++;
                    treeMap.put(dVar.f45984a, Integer.valueOf((int) j));
                }
            }
            gVar.f45958d = treeMap;
            return i2 >= 2;
        }

        public void G() {
            Timer timer = this.f45973h;
            if (timer != null) {
                timer.cancel();
                this.f45973h = null;
            }
            this.f45966a = 0L;
        }

        public final void H() {
            Timer timer = this.f45974i;
            if (timer != null) {
                timer.cancel();
                this.f45974i = null;
            }
        }

        public final boolean I() {
            if (!this.f45972g || TextUtils.isEmpty(this.f45971f)) {
                return false;
            }
            d.a.m0.a.h0.i.b.h(s(), this.f45971f);
            this.f45972g = false;
            return true;
        }

        public void J(int i2) {
            this.l = i2;
        }

        public void K(boolean z) {
            this.f45972g = z;
        }

        public void L() {
            G();
            Timer timer = new Timer();
            this.f45973h = timer;
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
            if (this.f45970e) {
                this.k = System.currentTimeMillis();
                Timer timer = new Timer();
                this.f45974i = timer;
                timer.schedule(new a(), 6000L);
                SwanAppActivity activity = d.a.m0.a.g1.f.V().getActivity();
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
                if (!TextUtils.equals(d.a.m0.a.g1.f.V().U(), d.a.m0.a.h0.i.d.a())) {
                    if (i.f45961a) {
                        Log.d("SwanAppLaunchTips", "current page is not skeleton error first page");
                        Log.d("SwanAppLaunchTips", "current page: " + d.a.m0.a.g1.f.V().U());
                        String a2 = d.a.m0.a.h0.i.d.a();
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
                String D = d.a.m0.a.g1.f.V().D();
                if (TextUtils.isEmpty(D)) {
                    return;
                }
                d.a.m0.a.g1.f.V().m(D, new d.a.m0.a.o0.d.b("check-skeleton-status"));
            }
        }

        public void p(SwanAppNetworkUtils.b bVar) {
            this.f45972g = true;
            SwanAppNetworkUtils.b(bVar);
        }

        public void q(g.a aVar) {
            g gVar = new g();
            gVar.h(System.currentTimeMillis() - this.k);
            gVar.i(this.m);
            p(new C0727c(gVar, aVar));
        }

        public String r(String str) {
            StringBuilder sb = new StringBuilder(d.a.m0.a.c1.a.b().getText(d.a.m0.a.h.swanapp_tip_cur_title));
            sb.append(str);
            String e2 = d.a.m0.a.h0.i.b.e();
            if (!TextUtils.isEmpty(e2)) {
                sb.append(e2);
            }
            return sb.toString();
        }

        public final long s() {
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
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
                d.a.m0.a.e0.d.h("SwanAppLaunchTips", "the log has expired, content=" + str2 + str);
                return;
            }
            String str3 = "\n" + str2 + str;
            if (!TextUtils.isEmpty(this.f45971f)) {
                str3 = this.f45971f + str3;
            }
            this.f45971f = str3;
            if (i.f45961a) {
                Log.d("SwanAppLaunchTips", str);
            }
            d.a.m0.a.e0.d.h("SwanAppLaunchTips", str2 + str);
        }

        public void x() {
            this.n = true;
        }

        public void y(long j) {
            if (this.f45966a == 0) {
                this.f45966a = j;
            }
        }

        public void z(@NonNull a.C0725a c0725a) {
            boolean z = u() || v();
            if (i.f45961a) {
                Log.d("SwanAppLaunchTips", String.format("onJsError needFilter ?: %s, content:%s", Boolean.valueOf(z), c0725a.toString()));
            }
            if (z) {
                return;
            }
            this.m.a(c0725a);
        }

        public /* synthetic */ c(h hVar) {
            this();
        }
    }
}
