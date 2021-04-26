package d.a.h0.a.e0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import d.a.h0.a.h;
import d.a.h0.a.i2.j;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.q1.b.b.g;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41888a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static c f41889b;

    /* loaded from: classes2.dex */
    public static class a implements SwanAppNetworkUtils.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41890a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41891b;

        public a(String str, String str2) {
            this.f41890a = str;
            this.f41891b = str2;
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i2) {
            if (i2 == 1) {
                f.d(this.f41890a + "; 网络：正常");
                d.a.h0.a.e0.d.b(this.f41891b, FrsActivityConfig.GOOD);
                d.a.h0.a.e0.c.f(h.swanapp_tip_loading_slow);
            } else if (i2 == 2) {
                f.d(this.f41890a + "; 网络：较差");
                d.a.h0.a.e0.d.b(this.f41891b, "bad");
                d.a.h0.a.e0.c.f(h.swanapp_tip_net_unavailable);
            } else if (i2 != 3) {
                f.d(this.f41890a + "; 网络：未知");
                d.a.h0.a.e0.d.b(this.f41891b, "unknown");
                d.a.h0.a.e0.c.f(h.swanapp_tip_loading_slow);
            } else {
                f.d(this.f41890a + "; 网络：离线");
                d.a.h0.a.e0.d.b(this.f41891b, "offline");
                d.a.h0.a.e0.c.f(h.swanapp_tip_net_unavailable);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f41892a = d.a.h0.a.w0.a.N().a();

        /* renamed from: b  reason: collision with root package name */
        public static final int f41893b = d.a.h0.a.w0.a.N().s();

        /* renamed from: c  reason: collision with root package name */
        public static final double f41894c = d.a.h0.a.w0.a.N().e();

        /* renamed from: d  reason: collision with root package name */
        public static final boolean f41895d = d.a.h0.a.w0.a.N().n();

        /* renamed from: e  reason: collision with root package name */
        public static final double f41896e = d.a.h0.a.w0.a.N().i();

        /* renamed from: f  reason: collision with root package name */
        public static final double f41897f = d.a.h0.a.w0.a.N().L();

        /* renamed from: g  reason: collision with root package name */
        public static final int f41898g = d.a.h0.a.w0.a.N().d();
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f41914a;

        /* renamed from: b  reason: collision with root package name */
        public long f41915b;

        /* renamed from: c  reason: collision with root package name */
        public long f41916c;

        /* renamed from: d  reason: collision with root package name */
        public int f41917d;

        public d(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        public d(String str, long j, long j2, int i2) {
            this.f41914a = str;
            this.f41915b = j;
            this.f41916c = j2;
            this.f41917d = i2;
        }
    }

    public static void b(SwanAppNetworkUtils.b bVar) {
        if (b.f41895d) {
            synchronized (f.class) {
                if (f41889b == null) {
                    c();
                }
            }
            f41889b.f(bVar);
        }
    }

    public static synchronized void c() {
        synchronized (f.class) {
            d.a.h0.a.e0.c.e();
            if (f41889b != null) {
                f41889b.d();
            }
            f41889b = new c(null);
        }
    }

    public static void d(String str) {
        if (b.f41895d) {
            synchronized (f.class) {
                if (f41889b == null) {
                    c();
                }
            }
            f41889b.i(str);
        }
    }

    public static void e(long j) {
        c cVar;
        if (b.f41895d && (cVar = f41889b) != null) {
            cVar.j(j);
        }
    }

    public static void f(long j) {
        c cVar;
        if (b.f41895d && (cVar = f41889b) != null) {
            cVar.k(j);
        }
    }

    public static void g(String str, int i2) {
        c cVar;
        if (b.f41895d && (cVar = f41889b) != null) {
            cVar.l(str, i2);
        }
    }

    public static void h(String str) {
        c cVar;
        if (b.f41895d && (cVar = f41889b) != null) {
            cVar.m(str);
        }
    }

    public static void i(String str, long j) {
        c cVar;
        if (b.f41895d && (cVar = f41889b) != null) {
            cVar.n(str, j);
        }
    }

    public static void j() {
        c cVar;
        if (b.f41895d && (cVar = f41889b) != null) {
            cVar.r();
        }
    }

    public static void k(String str, String str2) {
        b(new a(str2, str));
    }

    public static synchronized void l(boolean z) {
        synchronized (f.class) {
            if (b.f41895d) {
                if (d.a.h0.a.r1.d.e().j() == 1) {
                    return;
                }
                if (z || f41889b == null) {
                    c();
                }
                f41889b.s();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public long f41899a;

        /* renamed from: b  reason: collision with root package name */
        public long f41900b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f41901c;

        /* renamed from: d  reason: collision with root package name */
        public List<d> f41902d;

        /* renamed from: e  reason: collision with root package name */
        public List<d> f41903e;

        /* renamed from: f  reason: collision with root package name */
        public List<d> f41904f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f41905g;

        /* renamed from: h  reason: collision with root package name */
        public String f41906h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f41907i;
        public Timer j;

        /* loaded from: classes2.dex */
        public class a extends TimerTask {

            /* renamed from: d.a.h0.a.e0.f$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0617a extends d.a.h0.a.o0.a {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f41909a;

                public C0617a(SwanAppActivity swanAppActivity) {
                    this.f41909a = swanAppActivity;
                }

                @Override // d.a.h0.a.o0.a, d.a.h0.a.o0.b
                public void f() {
                    if (c.this.q()) {
                        this.f41909a.unregisterCallback(this);
                    }
                }
            }

            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                c.this.g();
                c.this.p();
                SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                activity.registerCallback(new C0617a(activity));
            }
        }

        /* loaded from: classes2.dex */
        public class b implements DialogInterface.OnClickListener {
            public b(c cVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        /* renamed from: d.a.h0.a.e0.f$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0618c implements SwanAppNetworkUtils.b {
            public C0618c() {
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i2) {
                if (k0.E()) {
                    if (i2 == 1) {
                        c cVar = c.this;
                        cVar.i(d.a.h0.a.e0.a.f41875a + "; 网络：正常");
                        d.a.h0.a.e0.d.b("fmp_timeout", FrsActivityConfig.GOOD);
                        d.a.h0.a.e0.c.f(h.swanapp_tip_loading_slow);
                    } else if (i2 == 2) {
                        c cVar2 = c.this;
                        cVar2.i(d.a.h0.a.e0.a.f41875a + "; 网络：较差");
                        d.a.h0.a.e0.d.b("fmp_timeout", "bad");
                        d.a.h0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                    } else if (i2 != 3) {
                        c cVar3 = c.this;
                        cVar3.i(d.a.h0.a.e0.a.f41875a + "; 网络：未知");
                        d.a.h0.a.e0.d.b("fmp_timeout", "unknown");
                        d.a.h0.a.e0.c.f(h.swanapp_tip_loading_slow);
                    } else {
                        c cVar4 = c.this;
                        cVar4.i(d.a.h0.a.e0.a.f41875a + "; 网络：离线");
                        d.a.h0.a.e0.d.b("fmp_timeout", "offline");
                        d.a.h0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        public class d implements SwanAppNetworkUtils.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f41912a;

            public d(String str) {
                this.f41912a = str;
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i2) {
                if (i2 == 1) {
                    c cVar = c.this;
                    cVar.i(this.f41912a + "; 网络：正常");
                    d.a.h0.a.e0.d.b("request_slow", FrsActivityConfig.GOOD);
                    d.a.h0.a.e0.c.f(h.swanapp_tip_service_slow);
                } else if (i2 == 2) {
                    c cVar2 = c.this;
                    cVar2.i(this.f41912a + "; 网络：较差");
                    d.a.h0.a.e0.d.b("request_slow", "bad");
                    d.a.h0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                } else if (i2 != 3) {
                    c cVar3 = c.this;
                    cVar3.i(this.f41912a + "; 网络：未知");
                    d.a.h0.a.e0.d.b("request_slow", "unknown");
                    d.a.h0.a.e0.c.f(h.swanapp_tip_loading_slow);
                } else {
                    c cVar4 = c.this;
                    cVar4.i(this.f41912a + "; 网络：离线");
                    d.a.h0.a.e0.d.b("request_slow", "offline");
                    d.a.h0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                }
            }
        }

        public c() {
            this.f41899a = 0L;
            this.f41900b = 0L;
            this.f41901c = false;
            this.f41902d = new ArrayList();
            this.f41903e = new ArrayList();
            this.f41904f = new ArrayList();
            this.f41905g = b.f41895d;
            this.f41906h = "";
            this.f41907i = false;
        }

        public void d() {
            p();
        }

        public final void e(long j) {
            if (this.f41901c) {
                return;
            }
            this.f41901c = true;
            long h2 = h();
            if (h2 == 0 || j - h2 <= b.f41898g) {
                return;
            }
            f(new C0618c());
        }

        public void f(SwanAppNetworkUtils.b bVar) {
            this.f41907i = true;
            SwanAppNetworkUtils.b(bVar);
        }

        public final synchronized void g() {
            this.f41905g = false;
            long currentTimeMillis = System.currentTimeMillis();
            for (d dVar : this.f41902d) {
                dVar.f41916c = currentTimeMillis - dVar.f41915b;
                this.f41903e.add(dVar);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f41904f.size(); i3++) {
                d dVar2 = this.f41904f.get(i3);
                if (dVar2 != null && dVar2.f41917d >= 400 && dVar2.f41917d < 600) {
                    i2++;
                }
            }
            int size = this.f41903e.size();
            if (i2 > 0) {
                i("检查request状况，总请求次数：" + (i2 + size) + ", 失败次数: " + i2);
            }
            if (i2 / (i2 + size) >= b.f41894c) {
                i(d.a.h0.a.e0.a.f41878d);
                this.f41907i = true;
                d.a.h0.a.e0.c.f(h.swanapp_tip_service_unavailable);
                d.a.h0.a.e0.d.a("request_fail");
                return;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.f41903e.size(); i5++) {
                d dVar3 = this.f41903e.get(i5);
                if (dVar3.f41916c > b.f41893b) {
                    try {
                        URL url = new URL(dVar3.f41914a);
                        i("请求 " + url.getPath() + " 耗时较长 ：" + dVar3.f41916c + "ms");
                    } catch (MalformedURLException e2) {
                        if (f.f41888a) {
                            e2.printStackTrace();
                        }
                    }
                    i4++;
                }
            }
            if (i4 >= 2) {
                f(new d(String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i4), Integer.valueOf(b.f41893b))));
            }
            this.f41902d.clear();
            this.f41903e.clear();
            this.f41904f.clear();
        }

        public final long h() {
            d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
            if (O != null) {
                return O.J().k("launch_time", 0L);
            }
            return 0L;
        }

        public void i(String str) {
            this.f41906h += j.f(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.f41888a) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void j(long j) {
            if (this.f41899a == 0) {
                this.f41899a = j;
                e(j);
            }
        }

        public void k(long j) {
            if (this.f41900b == 0) {
                this.f41900b = j;
                e(j);
            }
        }

        public synchronized void l(String str, int i2) {
            if (this.f41905g) {
                this.f41904f.add(new d(str, 0L, 0L, i2));
                o(str);
            }
        }

        public synchronized void m(String str) {
            if (this.f41905g) {
                this.f41902d.add(new d(str, System.currentTimeMillis(), 0L));
            }
        }

        public synchronized void n(String str, long j) {
            if (this.f41905g) {
                this.f41903e.add(new d(str, 0L, j));
                o(str);
            }
        }

        public final void o(String str) {
            for (int i2 = 0; i2 < this.f41902d.size(); i2++) {
                if (TextUtils.equals(this.f41902d.get(i2).f41914a, str)) {
                    List<d> list = this.f41902d;
                    list.remove(list.get(i2));
                }
            }
        }

        public final void p() {
            Timer timer = this.j;
            if (timer != null) {
                timer.cancel();
                this.j = null;
            }
        }

        public final boolean q() {
            if (!this.f41907i || TextUtils.isEmpty(this.f41906h)) {
                return false;
            }
            d.a.h0.a.e0.b.h(h(), this.f41906h);
            this.f41907i = false;
            return true;
        }

        public void r() {
            SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            StringBuilder sb = new StringBuilder(activity.getText(h.swanapp_tip_cur_title));
            sb.append(TextUtils.isEmpty(this.f41906h) ? "未检测到异常\n" : this.f41906h);
            String e2 = d.a.h0.a.e0.b.e();
            if (!TextUtils.isEmpty(e2)) {
                sb.append(e2);
            }
            g.a aVar = new g.a(activity);
            aVar.U(h.swanapp_tip_title);
            aVar.y(sb.toString());
            aVar.z();
            aVar.n(new d.a.h0.a.j2.g.a());
            aVar.m(false);
            aVar.O(h.swanapp_tip_dialog_close, new b(this));
            aVar.X();
        }

        public void s() {
            if (!this.f41905g || b.f41892a <= 0) {
                return;
            }
            Timer timer = new Timer();
            this.j = timer;
            timer.schedule(new a(), b.f41892a);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
