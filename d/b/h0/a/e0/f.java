package d.b.h0.a.e0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import d.b.h0.a.h;
import d.b.h0.a.i2.j;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.q1.b.b.g;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44592a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static c f44593b;

    /* loaded from: classes2.dex */
    public static class a implements SwanAppNetworkUtils.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44594a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44595b;

        public a(String str, String str2) {
            this.f44594a = str;
            this.f44595b = str2;
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i) {
            if (i == 1) {
                f.d(this.f44594a + "; 网络：正常");
                d.b.h0.a.e0.d.b(this.f44595b, FrsActivityConfig.GOOD);
                d.b.h0.a.e0.c.f(h.swanapp_tip_loading_slow);
            } else if (i == 2) {
                f.d(this.f44594a + "; 网络：较差");
                d.b.h0.a.e0.d.b(this.f44595b, "bad");
                d.b.h0.a.e0.c.f(h.swanapp_tip_net_unavailable);
            } else if (i != 3) {
                f.d(this.f44594a + "; 网络：未知");
                d.b.h0.a.e0.d.b(this.f44595b, "unknown");
                d.b.h0.a.e0.c.f(h.swanapp_tip_loading_slow);
            } else {
                f.d(this.f44594a + "; 网络：离线");
                d.b.h0.a.e0.d.b(this.f44595b, "offline");
                d.b.h0.a.e0.c.f(h.swanapp_tip_net_unavailable);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f44596a = d.b.h0.a.w0.a.N().b();

        /* renamed from: b  reason: collision with root package name */
        public static final int f44597b = d.b.h0.a.w0.a.N().E();

        /* renamed from: c  reason: collision with root package name */
        public static final double f44598c = d.b.h0.a.w0.a.N().g();

        /* renamed from: d  reason: collision with root package name */
        public static final boolean f44599d = d.b.h0.a.w0.a.N().x();

        /* renamed from: e  reason: collision with root package name */
        public static final double f44600e = d.b.h0.a.w0.a.N().m();

        /* renamed from: f  reason: collision with root package name */
        public static final double f44601f = d.b.h0.a.w0.a.N().L();

        /* renamed from: g  reason: collision with root package name */
        public static final int f44602g = d.b.h0.a.w0.a.N().e();
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f44617a;

        /* renamed from: b  reason: collision with root package name */
        public long f44618b;

        /* renamed from: c  reason: collision with root package name */
        public long f44619c;

        /* renamed from: d  reason: collision with root package name */
        public int f44620d;

        public d(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        public d(String str, long j, long j2, int i) {
            this.f44617a = str;
            this.f44618b = j;
            this.f44619c = j2;
            this.f44620d = i;
        }
    }

    public static void b(SwanAppNetworkUtils.b bVar) {
        if (b.f44599d) {
            synchronized (f.class) {
                if (f44593b == null) {
                    c();
                }
            }
            f44593b.f(bVar);
        }
    }

    public static synchronized void c() {
        synchronized (f.class) {
            d.b.h0.a.e0.c.e();
            if (f44593b != null) {
                f44593b.d();
            }
            f44593b = new c(null);
        }
    }

    public static void d(String str) {
        if (b.f44599d) {
            synchronized (f.class) {
                if (f44593b == null) {
                    c();
                }
            }
            f44593b.i(str);
        }
    }

    public static void e(long j) {
        c cVar;
        if (b.f44599d && (cVar = f44593b) != null) {
            cVar.j(j);
        }
    }

    public static void f(long j) {
        c cVar;
        if (b.f44599d && (cVar = f44593b) != null) {
            cVar.k(j);
        }
    }

    public static void g(String str, int i) {
        c cVar;
        if (b.f44599d && (cVar = f44593b) != null) {
            cVar.l(str, i);
        }
    }

    public static void h(String str) {
        c cVar;
        if (b.f44599d && (cVar = f44593b) != null) {
            cVar.m(str);
        }
    }

    public static void i(String str, long j) {
        c cVar;
        if (b.f44599d && (cVar = f44593b) != null) {
            cVar.n(str, j);
        }
    }

    public static void j() {
        c cVar;
        if (b.f44599d && (cVar = f44593b) != null) {
            cVar.r();
        }
    }

    public static void k(String str, String str2) {
        b(new a(str2, str));
    }

    public static synchronized void l(boolean z) {
        synchronized (f.class) {
            if (b.f44599d) {
                if (d.b.h0.a.r1.d.e().h() == 1) {
                    return;
                }
                if (z || f44593b == null) {
                    c();
                }
                f44593b.s();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public long f44603a;

        /* renamed from: b  reason: collision with root package name */
        public long f44604b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f44605c;

        /* renamed from: d  reason: collision with root package name */
        public List<d> f44606d;

        /* renamed from: e  reason: collision with root package name */
        public List<d> f44607e;

        /* renamed from: f  reason: collision with root package name */
        public List<d> f44608f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f44609g;

        /* renamed from: h  reason: collision with root package name */
        public String f44610h;
        public boolean i;
        public Timer j;

        /* loaded from: classes2.dex */
        public class a extends TimerTask {

            /* renamed from: d.b.h0.a.e0.f$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0678a extends d.b.h0.a.o0.a {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f44612a;

                public C0678a(SwanAppActivity swanAppActivity) {
                    this.f44612a = swanAppActivity;
                }

                @Override // d.b.h0.a.o0.a, d.b.h0.a.o0.b
                public void b() {
                    if (c.this.q()) {
                        this.f44612a.unregisterCallback(this);
                    }
                }
            }

            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                c.this.g();
                c.this.p();
                SwanAppActivity activity = d.b.h0.a.z0.f.V().getActivity();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                activity.registerCallback(new C0678a(activity));
            }
        }

        /* loaded from: classes2.dex */
        public class b implements DialogInterface.OnClickListener {
            public b(c cVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: d.b.h0.a.e0.f$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0679c implements SwanAppNetworkUtils.b {
            public C0679c() {
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i) {
                if (k0.E()) {
                    if (i == 1) {
                        c cVar = c.this;
                        cVar.i(d.b.h0.a.e0.a.f44579a + "; 网络：正常");
                        d.b.h0.a.e0.d.b("fmp_timeout", FrsActivityConfig.GOOD);
                        d.b.h0.a.e0.c.f(h.swanapp_tip_loading_slow);
                    } else if (i == 2) {
                        c cVar2 = c.this;
                        cVar2.i(d.b.h0.a.e0.a.f44579a + "; 网络：较差");
                        d.b.h0.a.e0.d.b("fmp_timeout", "bad");
                        d.b.h0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                    } else if (i != 3) {
                        c cVar3 = c.this;
                        cVar3.i(d.b.h0.a.e0.a.f44579a + "; 网络：未知");
                        d.b.h0.a.e0.d.b("fmp_timeout", "unknown");
                        d.b.h0.a.e0.c.f(h.swanapp_tip_loading_slow);
                    } else {
                        c cVar4 = c.this;
                        cVar4.i(d.b.h0.a.e0.a.f44579a + "; 网络：离线");
                        d.b.h0.a.e0.d.b("fmp_timeout", "offline");
                        d.b.h0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        public class d implements SwanAppNetworkUtils.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f44615a;

            public d(String str) {
                this.f44615a = str;
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i) {
                if (i == 1) {
                    c cVar = c.this;
                    cVar.i(this.f44615a + "; 网络：正常");
                    d.b.h0.a.e0.d.b("request_slow", FrsActivityConfig.GOOD);
                    d.b.h0.a.e0.c.f(h.swanapp_tip_service_slow);
                } else if (i == 2) {
                    c cVar2 = c.this;
                    cVar2.i(this.f44615a + "; 网络：较差");
                    d.b.h0.a.e0.d.b("request_slow", "bad");
                    d.b.h0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                } else if (i != 3) {
                    c cVar3 = c.this;
                    cVar3.i(this.f44615a + "; 网络：未知");
                    d.b.h0.a.e0.d.b("request_slow", "unknown");
                    d.b.h0.a.e0.c.f(h.swanapp_tip_loading_slow);
                } else {
                    c cVar4 = c.this;
                    cVar4.i(this.f44615a + "; 网络：离线");
                    d.b.h0.a.e0.d.b("request_slow", "offline");
                    d.b.h0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                }
            }
        }

        public c() {
            this.f44603a = 0L;
            this.f44604b = 0L;
            this.f44605c = false;
            this.f44606d = new ArrayList();
            this.f44607e = new ArrayList();
            this.f44608f = new ArrayList();
            this.f44609g = b.f44599d;
            this.f44610h = "";
            this.i = false;
        }

        public void d() {
            p();
        }

        public final void e(long j) {
            if (this.f44605c) {
                return;
            }
            this.f44605c = true;
            long h2 = h();
            if (h2 == 0 || j - h2 <= b.f44602g) {
                return;
            }
            f(new C0679c());
        }

        public void f(SwanAppNetworkUtils.b bVar) {
            this.i = true;
            SwanAppNetworkUtils.b(bVar);
        }

        public final synchronized void g() {
            this.f44609g = false;
            long currentTimeMillis = System.currentTimeMillis();
            for (d dVar : this.f44606d) {
                dVar.f44619c = currentTimeMillis - dVar.f44618b;
                this.f44607e.add(dVar);
            }
            int i = 0;
            for (int i2 = 0; i2 < this.f44608f.size(); i2++) {
                d dVar2 = this.f44608f.get(i2);
                if (dVar2 != null && dVar2.f44620d >= 400 && dVar2.f44620d < 600) {
                    i++;
                }
            }
            int size = this.f44607e.size();
            if (i > 0) {
                i("检查request状况，总请求次数：" + (i + size) + ", 失败次数: " + i);
            }
            if (i / (i + size) >= b.f44598c) {
                i(d.b.h0.a.e0.a.f44582d);
                this.i = true;
                d.b.h0.a.e0.c.f(h.swanapp_tip_service_unavailable);
                d.b.h0.a.e0.d.a("request_fail");
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.f44607e.size(); i4++) {
                d dVar3 = this.f44607e.get(i4);
                if (dVar3.f44619c > b.f44597b) {
                    try {
                        URL url = new URL(dVar3.f44617a);
                        i("请求 " + url.getPath() + " 耗时较长 ：" + dVar3.f44619c + "ms");
                    } catch (MalformedURLException e2) {
                        if (f.f44592a) {
                            e2.printStackTrace();
                        }
                    }
                    i3++;
                }
            }
            if (i3 >= 2) {
                f(new d(String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i3), Integer.valueOf(b.f44597b))));
            }
            this.f44606d.clear();
            this.f44607e.clear();
            this.f44608f.clear();
        }

        public final long h() {
            d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
            if (O != null) {
                return O.J().k("launch_time", 0L);
            }
            return 0L;
        }

        public void i(String str) {
            this.f44610h += j.f(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.f44592a) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void j(long j) {
            if (this.f44603a == 0) {
                this.f44603a = j;
                e(j);
            }
        }

        public void k(long j) {
            if (this.f44604b == 0) {
                this.f44604b = j;
                e(j);
            }
        }

        public synchronized void l(String str, int i) {
            if (this.f44609g) {
                this.f44608f.add(new d(str, 0L, 0L, i));
                o(str);
            }
        }

        public synchronized void m(String str) {
            if (this.f44609g) {
                this.f44606d.add(new d(str, System.currentTimeMillis(), 0L));
            }
        }

        public synchronized void n(String str, long j) {
            if (this.f44609g) {
                this.f44607e.add(new d(str, 0L, j));
                o(str);
            }
        }

        public final void o(String str) {
            for (int i = 0; i < this.f44606d.size(); i++) {
                if (TextUtils.equals(this.f44606d.get(i).f44617a, str)) {
                    List<d> list = this.f44606d;
                    list.remove(list.get(i));
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
            if (!this.i || TextUtils.isEmpty(this.f44610h)) {
                return false;
            }
            d.b.h0.a.e0.b.h(h(), this.f44610h);
            this.i = false;
            return true;
        }

        public void r() {
            SwanAppActivity activity = d.b.h0.a.z0.f.V().getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            StringBuilder sb = new StringBuilder(activity.getText(h.swanapp_tip_cur_title));
            sb.append(TextUtils.isEmpty(this.f44610h) ? "未检测到异常\n" : this.f44610h);
            String e2 = d.b.h0.a.e0.b.e();
            if (!TextUtils.isEmpty(e2)) {
                sb.append(e2);
            }
            g.a aVar = new g.a(activity);
            aVar.U(h.swanapp_tip_title);
            aVar.y(sb.toString());
            aVar.z();
            aVar.n(new d.b.h0.a.j2.g.a());
            aVar.m(false);
            aVar.O(h.swanapp_tip_dialog_close, new b(this));
            aVar.X();
        }

        public void s() {
            if (!this.f44609g || b.f44596a <= 0) {
                return;
            }
            Timer timer = new Timer();
            this.j = timer;
            timer.schedule(new a(), b.f44596a);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
