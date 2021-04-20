package d.b.g0.a.e0;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import d.b.g0.a.h;
import d.b.g0.a.i2.j;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.q1.b.b.g;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44263a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static c f44264b;

    /* loaded from: classes2.dex */
    public static class a implements SwanAppNetworkUtils.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44265a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44266b;

        public a(String str, String str2) {
            this.f44265a = str;
            this.f44266b = str2;
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i) {
            if (i == 1) {
                f.d(this.f44265a + "; 网络：正常");
                d.b.g0.a.e0.d.b(this.f44266b, FrsActivityConfig.GOOD);
                d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
            } else if (i == 2) {
                f.d(this.f44265a + "; 网络：较差");
                d.b.g0.a.e0.d.b(this.f44266b, "bad");
                d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
            } else if (i != 3) {
                f.d(this.f44265a + "; 网络：未知");
                d.b.g0.a.e0.d.b(this.f44266b, "unknown");
                d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
            } else {
                f.d(this.f44265a + "; 网络：离线");
                d.b.g0.a.e0.d.b(this.f44266b, "offline");
                d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f44267a = d.b.g0.a.w0.a.N().b();

        /* renamed from: b  reason: collision with root package name */
        public static final int f44268b = d.b.g0.a.w0.a.N().E();

        /* renamed from: c  reason: collision with root package name */
        public static final double f44269c = d.b.g0.a.w0.a.N().g();

        /* renamed from: d  reason: collision with root package name */
        public static final boolean f44270d = d.b.g0.a.w0.a.N().x();

        /* renamed from: e  reason: collision with root package name */
        public static final double f44271e = d.b.g0.a.w0.a.N().m();

        /* renamed from: f  reason: collision with root package name */
        public static final double f44272f = d.b.g0.a.w0.a.N().L();

        /* renamed from: g  reason: collision with root package name */
        public static final int f44273g = d.b.g0.a.w0.a.N().e();
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f44288a;

        /* renamed from: b  reason: collision with root package name */
        public long f44289b;

        /* renamed from: c  reason: collision with root package name */
        public long f44290c;

        /* renamed from: d  reason: collision with root package name */
        public int f44291d;

        public d(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        public d(String str, long j, long j2, int i) {
            this.f44288a = str;
            this.f44289b = j;
            this.f44290c = j2;
            this.f44291d = i;
        }
    }

    public static void b(SwanAppNetworkUtils.b bVar) {
        if (b.f44270d) {
            synchronized (f.class) {
                if (f44264b == null) {
                    c();
                }
            }
            f44264b.f(bVar);
        }
    }

    public static synchronized void c() {
        synchronized (f.class) {
            d.b.g0.a.e0.c.e();
            if (f44264b != null) {
                f44264b.d();
            }
            f44264b = new c(null);
        }
    }

    public static void d(String str) {
        if (b.f44270d) {
            synchronized (f.class) {
                if (f44264b == null) {
                    c();
                }
            }
            f44264b.i(str);
        }
    }

    public static void e(long j) {
        c cVar;
        if (b.f44270d && (cVar = f44264b) != null) {
            cVar.j(j);
        }
    }

    public static void f(long j) {
        c cVar;
        if (b.f44270d && (cVar = f44264b) != null) {
            cVar.k(j);
        }
    }

    public static void g(String str, int i) {
        c cVar;
        if (b.f44270d && (cVar = f44264b) != null) {
            cVar.l(str, i);
        }
    }

    public static void h(String str) {
        c cVar;
        if (b.f44270d && (cVar = f44264b) != null) {
            cVar.m(str);
        }
    }

    public static void i(String str, long j) {
        c cVar;
        if (b.f44270d && (cVar = f44264b) != null) {
            cVar.n(str, j);
        }
    }

    public static void j() {
        c cVar;
        if (b.f44270d && (cVar = f44264b) != null) {
            cVar.r();
        }
    }

    public static void k(String str, String str2) {
        b(new a(str2, str));
    }

    public static synchronized void l(boolean z) {
        synchronized (f.class) {
            if (b.f44270d) {
                if (d.b.g0.a.r1.d.e().h() == 1) {
                    return;
                }
                if (z || f44264b == null) {
                    c();
                }
                f44264b.s();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public long f44274a;

        /* renamed from: b  reason: collision with root package name */
        public long f44275b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f44276c;

        /* renamed from: d  reason: collision with root package name */
        public List<d> f44277d;

        /* renamed from: e  reason: collision with root package name */
        public List<d> f44278e;

        /* renamed from: f  reason: collision with root package name */
        public List<d> f44279f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f44280g;

        /* renamed from: h  reason: collision with root package name */
        public String f44281h;
        public boolean i;
        public Timer j;

        /* loaded from: classes2.dex */
        public class a extends TimerTask {

            /* renamed from: d.b.g0.a.e0.f$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0658a extends d.b.g0.a.o0.a {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f44283a;

                public C0658a(SwanAppActivity swanAppActivity) {
                    this.f44283a = swanAppActivity;
                }

                @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
                public void b() {
                    if (c.this.q()) {
                        this.f44283a.unregisterCallback(this);
                    }
                }
            }

            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                c.this.g();
                c.this.p();
                SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                activity.registerCallback(new C0658a(activity));
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

        /* renamed from: d.b.g0.a.e0.f$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0659c implements SwanAppNetworkUtils.b {
            public C0659c() {
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i) {
                if (k0.E()) {
                    if (i == 1) {
                        c cVar = c.this;
                        cVar.i(d.b.g0.a.e0.a.f44250a + "; 网络：正常");
                        d.b.g0.a.e0.d.b("fmp_timeout", FrsActivityConfig.GOOD);
                        d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
                    } else if (i == 2) {
                        c cVar2 = c.this;
                        cVar2.i(d.b.g0.a.e0.a.f44250a + "; 网络：较差");
                        d.b.g0.a.e0.d.b("fmp_timeout", "bad");
                        d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                    } else if (i != 3) {
                        c cVar3 = c.this;
                        cVar3.i(d.b.g0.a.e0.a.f44250a + "; 网络：未知");
                        d.b.g0.a.e0.d.b("fmp_timeout", "unknown");
                        d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
                    } else {
                        c cVar4 = c.this;
                        cVar4.i(d.b.g0.a.e0.a.f44250a + "; 网络：离线");
                        d.b.g0.a.e0.d.b("fmp_timeout", "offline");
                        d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        public class d implements SwanAppNetworkUtils.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f44286a;

            public d(String str) {
                this.f44286a = str;
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i) {
                if (i == 1) {
                    c cVar = c.this;
                    cVar.i(this.f44286a + "; 网络：正常");
                    d.b.g0.a.e0.d.b("request_slow", FrsActivityConfig.GOOD);
                    d.b.g0.a.e0.c.f(h.swanapp_tip_service_slow);
                } else if (i == 2) {
                    c cVar2 = c.this;
                    cVar2.i(this.f44286a + "; 网络：较差");
                    d.b.g0.a.e0.d.b("request_slow", "bad");
                    d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                } else if (i != 3) {
                    c cVar3 = c.this;
                    cVar3.i(this.f44286a + "; 网络：未知");
                    d.b.g0.a.e0.d.b("request_slow", "unknown");
                    d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
                } else {
                    c cVar4 = c.this;
                    cVar4.i(this.f44286a + "; 网络：离线");
                    d.b.g0.a.e0.d.b("request_slow", "offline");
                    d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                }
            }
        }

        public c() {
            this.f44274a = 0L;
            this.f44275b = 0L;
            this.f44276c = false;
            this.f44277d = new ArrayList();
            this.f44278e = new ArrayList();
            this.f44279f = new ArrayList();
            this.f44280g = b.f44270d;
            this.f44281h = "";
            this.i = false;
        }

        public void d() {
            p();
        }

        public final void e(long j) {
            if (this.f44276c) {
                return;
            }
            this.f44276c = true;
            long h2 = h();
            if (h2 == 0 || j - h2 <= b.f44273g) {
                return;
            }
            f(new C0659c());
        }

        public void f(SwanAppNetworkUtils.b bVar) {
            this.i = true;
            SwanAppNetworkUtils.b(bVar);
        }

        public final synchronized void g() {
            this.f44280g = false;
            long currentTimeMillis = System.currentTimeMillis();
            for (d dVar : this.f44277d) {
                dVar.f44290c = currentTimeMillis - dVar.f44289b;
                this.f44278e.add(dVar);
            }
            int i = 0;
            for (int i2 = 0; i2 < this.f44279f.size(); i2++) {
                d dVar2 = this.f44279f.get(i2);
                if (dVar2 != null && dVar2.f44291d >= 400 && dVar2.f44291d < 600) {
                    i++;
                }
            }
            int size = this.f44278e.size();
            if (i > 0) {
                i("检查request状况，总请求次数：" + (i + size) + ", 失败次数: " + i);
            }
            if (i / (i + size) >= b.f44269c) {
                i(d.b.g0.a.e0.a.f44253d);
                this.i = true;
                d.b.g0.a.e0.c.f(h.swanapp_tip_service_unavailable);
                d.b.g0.a.e0.d.a("request_fail");
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.f44278e.size(); i4++) {
                d dVar3 = this.f44278e.get(i4);
                if (dVar3.f44290c > b.f44268b) {
                    try {
                        URL url = new URL(dVar3.f44288a);
                        i("请求 " + url.getPath() + " 耗时较长 ：" + dVar3.f44290c + "ms");
                    } catch (MalformedURLException e2) {
                        if (f.f44263a) {
                            e2.printStackTrace();
                        }
                    }
                    i3++;
                }
            }
            if (i3 >= 2) {
                f(new d(String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i3), Integer.valueOf(b.f44268b))));
            }
            this.f44277d.clear();
            this.f44278e.clear();
            this.f44279f.clear();
        }

        public final long h() {
            d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
            if (O != null) {
                return O.J().k("launch_time", 0L);
            }
            return 0L;
        }

        public void i(String str) {
            this.f44281h += j.f(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.f44263a) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void j(long j) {
            if (this.f44274a == 0) {
                this.f44274a = j;
                e(j);
            }
        }

        public void k(long j) {
            if (this.f44275b == 0) {
                this.f44275b = j;
                e(j);
            }
        }

        public synchronized void l(String str, int i) {
            if (this.f44280g) {
                this.f44279f.add(new d(str, 0L, 0L, i));
                o(str);
            }
        }

        public synchronized void m(String str) {
            if (this.f44280g) {
                this.f44277d.add(new d(str, System.currentTimeMillis(), 0L));
            }
        }

        public synchronized void n(String str, long j) {
            if (this.f44280g) {
                this.f44278e.add(new d(str, 0L, j));
                o(str);
            }
        }

        public final void o(String str) {
            for (int i = 0; i < this.f44277d.size(); i++) {
                if (TextUtils.equals(this.f44277d.get(i).f44288a, str)) {
                    List<d> list = this.f44277d;
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
            if (!this.i || TextUtils.isEmpty(this.f44281h)) {
                return false;
            }
            d.b.g0.a.e0.b.h(h(), this.f44281h);
            this.i = false;
            return true;
        }

        public void r() {
            SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            StringBuilder sb = new StringBuilder(activity.getText(h.swanapp_tip_cur_title));
            sb.append(TextUtils.isEmpty(this.f44281h) ? "未检测到异常\n" : this.f44281h);
            String e2 = d.b.g0.a.e0.b.e();
            if (!TextUtils.isEmpty(e2)) {
                sb.append(e2);
            }
            g.a aVar = new g.a(activity);
            aVar.U(h.swanapp_tip_title);
            aVar.y(sb.toString());
            aVar.z();
            aVar.n(new d.b.g0.a.j2.g.a());
            aVar.m(false);
            aVar.O(h.swanapp_tip_dialog_close, new b(this));
            aVar.X();
        }

        public void s() {
            if (!this.f44280g || b.f44267a <= 0) {
                return;
            }
            Timer timer = new Timer();
            this.j = timer;
            timer.schedule(new a(), b.f44267a);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
