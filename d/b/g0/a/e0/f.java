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
    public static final boolean f43871a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static c f43872b;

    /* loaded from: classes2.dex */
    public static class a implements SwanAppNetworkUtils.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43873a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43874b;

        public a(String str, String str2) {
            this.f43873a = str;
            this.f43874b = str2;
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i) {
            if (i == 1) {
                f.d(this.f43873a + "; 网络：正常");
                d.b.g0.a.e0.d.b(this.f43874b, FrsActivityConfig.GOOD);
                d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
            } else if (i == 2) {
                f.d(this.f43873a + "; 网络：较差");
                d.b.g0.a.e0.d.b(this.f43874b, "bad");
                d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
            } else if (i != 3) {
                f.d(this.f43873a + "; 网络：未知");
                d.b.g0.a.e0.d.b(this.f43874b, "unknown");
                d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
            } else {
                f.d(this.f43873a + "; 网络：离线");
                d.b.g0.a.e0.d.b(this.f43874b, "offline");
                d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f43875a = d.b.g0.a.w0.a.N().b();

        /* renamed from: b  reason: collision with root package name */
        public static final int f43876b = d.b.g0.a.w0.a.N().E();

        /* renamed from: c  reason: collision with root package name */
        public static final double f43877c = d.b.g0.a.w0.a.N().g();

        /* renamed from: d  reason: collision with root package name */
        public static final boolean f43878d = d.b.g0.a.w0.a.N().x();

        /* renamed from: e  reason: collision with root package name */
        public static final double f43879e = d.b.g0.a.w0.a.N().m();

        /* renamed from: f  reason: collision with root package name */
        public static final double f43880f = d.b.g0.a.w0.a.N().L();

        /* renamed from: g  reason: collision with root package name */
        public static final int f43881g = d.b.g0.a.w0.a.N().e();
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f43896a;

        /* renamed from: b  reason: collision with root package name */
        public long f43897b;

        /* renamed from: c  reason: collision with root package name */
        public long f43898c;

        /* renamed from: d  reason: collision with root package name */
        public int f43899d;

        public d(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        public d(String str, long j, long j2, int i) {
            this.f43896a = str;
            this.f43897b = j;
            this.f43898c = j2;
            this.f43899d = i;
        }
    }

    public static void b(SwanAppNetworkUtils.b bVar) {
        if (b.f43878d) {
            synchronized (f.class) {
                if (f43872b == null) {
                    c();
                }
            }
            f43872b.f(bVar);
        }
    }

    public static synchronized void c() {
        synchronized (f.class) {
            d.b.g0.a.e0.c.e();
            if (f43872b != null) {
                f43872b.d();
            }
            f43872b = new c(null);
        }
    }

    public static void d(String str) {
        if (b.f43878d) {
            synchronized (f.class) {
                if (f43872b == null) {
                    c();
                }
            }
            f43872b.i(str);
        }
    }

    public static void e(long j) {
        c cVar;
        if (b.f43878d && (cVar = f43872b) != null) {
            cVar.j(j);
        }
    }

    public static void f(long j) {
        c cVar;
        if (b.f43878d && (cVar = f43872b) != null) {
            cVar.k(j);
        }
    }

    public static void g(String str, int i) {
        c cVar;
        if (b.f43878d && (cVar = f43872b) != null) {
            cVar.l(str, i);
        }
    }

    public static void h(String str) {
        c cVar;
        if (b.f43878d && (cVar = f43872b) != null) {
            cVar.m(str);
        }
    }

    public static void i(String str, long j) {
        c cVar;
        if (b.f43878d && (cVar = f43872b) != null) {
            cVar.n(str, j);
        }
    }

    public static void j() {
        c cVar;
        if (b.f43878d && (cVar = f43872b) != null) {
            cVar.r();
        }
    }

    public static void k(String str, String str2) {
        b(new a(str2, str));
    }

    public static synchronized void l(boolean z) {
        synchronized (f.class) {
            if (b.f43878d) {
                if (d.b.g0.a.r1.d.e().h() == 1) {
                    return;
                }
                if (z || f43872b == null) {
                    c();
                }
                f43872b.s();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public long f43882a;

        /* renamed from: b  reason: collision with root package name */
        public long f43883b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f43884c;

        /* renamed from: d  reason: collision with root package name */
        public List<d> f43885d;

        /* renamed from: e  reason: collision with root package name */
        public List<d> f43886e;

        /* renamed from: f  reason: collision with root package name */
        public List<d> f43887f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f43888g;

        /* renamed from: h  reason: collision with root package name */
        public String f43889h;
        public boolean i;
        public Timer j;

        /* loaded from: classes2.dex */
        public class a extends TimerTask {

            /* renamed from: d.b.g0.a.e0.f$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0646a extends d.b.g0.a.o0.a {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f43891a;

                public C0646a(SwanAppActivity swanAppActivity) {
                    this.f43891a = swanAppActivity;
                }

                @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
                public void b() {
                    if (c.this.q()) {
                        this.f43891a.unregisterCallback(this);
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
                activity.registerCallback(new C0646a(activity));
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
        public class C0647c implements SwanAppNetworkUtils.b {
            public C0647c() {
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i) {
                if (k0.E()) {
                    if (i == 1) {
                        c cVar = c.this;
                        cVar.i(d.b.g0.a.e0.a.f43858a + "; 网络：正常");
                        d.b.g0.a.e0.d.b("fmp_timeout", FrsActivityConfig.GOOD);
                        d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
                    } else if (i == 2) {
                        c cVar2 = c.this;
                        cVar2.i(d.b.g0.a.e0.a.f43858a + "; 网络：较差");
                        d.b.g0.a.e0.d.b("fmp_timeout", "bad");
                        d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                    } else if (i != 3) {
                        c cVar3 = c.this;
                        cVar3.i(d.b.g0.a.e0.a.f43858a + "; 网络：未知");
                        d.b.g0.a.e0.d.b("fmp_timeout", "unknown");
                        d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
                    } else {
                        c cVar4 = c.this;
                        cVar4.i(d.b.g0.a.e0.a.f43858a + "; 网络：离线");
                        d.b.g0.a.e0.d.b("fmp_timeout", "offline");
                        d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        public class d implements SwanAppNetworkUtils.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43894a;

            public d(String str) {
                this.f43894a = str;
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i) {
                if (i == 1) {
                    c cVar = c.this;
                    cVar.i(this.f43894a + "; 网络：正常");
                    d.b.g0.a.e0.d.b("request_slow", FrsActivityConfig.GOOD);
                    d.b.g0.a.e0.c.f(h.swanapp_tip_service_slow);
                } else if (i == 2) {
                    c cVar2 = c.this;
                    cVar2.i(this.f43894a + "; 网络：较差");
                    d.b.g0.a.e0.d.b("request_slow", "bad");
                    d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                } else if (i != 3) {
                    c cVar3 = c.this;
                    cVar3.i(this.f43894a + "; 网络：未知");
                    d.b.g0.a.e0.d.b("request_slow", "unknown");
                    d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
                } else {
                    c cVar4 = c.this;
                    cVar4.i(this.f43894a + "; 网络：离线");
                    d.b.g0.a.e0.d.b("request_slow", "offline");
                    d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                }
            }
        }

        public c() {
            this.f43882a = 0L;
            this.f43883b = 0L;
            this.f43884c = false;
            this.f43885d = new ArrayList();
            this.f43886e = new ArrayList();
            this.f43887f = new ArrayList();
            this.f43888g = b.f43878d;
            this.f43889h = "";
            this.i = false;
        }

        public void d() {
            p();
        }

        public final void e(long j) {
            if (this.f43884c) {
                return;
            }
            this.f43884c = true;
            long h2 = h();
            if (h2 == 0 || j - h2 <= b.f43881g) {
                return;
            }
            f(new C0647c());
        }

        public void f(SwanAppNetworkUtils.b bVar) {
            this.i = true;
            SwanAppNetworkUtils.b(bVar);
        }

        public final synchronized void g() {
            this.f43888g = false;
            long currentTimeMillis = System.currentTimeMillis();
            for (d dVar : this.f43885d) {
                dVar.f43898c = currentTimeMillis - dVar.f43897b;
                this.f43886e.add(dVar);
            }
            int i = 0;
            for (int i2 = 0; i2 < this.f43887f.size(); i2++) {
                d dVar2 = this.f43887f.get(i2);
                if (dVar2 != null && dVar2.f43899d >= 400 && dVar2.f43899d < 600) {
                    i++;
                }
            }
            int size = this.f43886e.size();
            if (i > 0) {
                i("检查request状况，总请求次数：" + (i + size) + ", 失败次数: " + i);
            }
            if (i / (i + size) >= b.f43877c) {
                i(d.b.g0.a.e0.a.f43861d);
                this.i = true;
                d.b.g0.a.e0.c.f(h.swanapp_tip_service_unavailable);
                d.b.g0.a.e0.d.a("request_fail");
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.f43886e.size(); i4++) {
                d dVar3 = this.f43886e.get(i4);
                if (dVar3.f43898c > b.f43876b) {
                    try {
                        URL url = new URL(dVar3.f43896a);
                        i("请求 " + url.getPath() + " 耗时较长 ：" + dVar3.f43898c + "ms");
                    } catch (MalformedURLException e2) {
                        if (f.f43871a) {
                            e2.printStackTrace();
                        }
                    }
                    i3++;
                }
            }
            if (i3 >= 2) {
                f(new d(String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i3), Integer.valueOf(b.f43876b))));
            }
            this.f43885d.clear();
            this.f43886e.clear();
            this.f43887f.clear();
        }

        public final long h() {
            d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
            if (O != null) {
                return O.J().k("launch_time", 0L);
            }
            return 0L;
        }

        public void i(String str) {
            this.f43889h += j.f(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.f43871a) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void j(long j) {
            if (this.f43882a == 0) {
                this.f43882a = j;
                e(j);
            }
        }

        public void k(long j) {
            if (this.f43883b == 0) {
                this.f43883b = j;
                e(j);
            }
        }

        public synchronized void l(String str, int i) {
            if (this.f43888g) {
                this.f43887f.add(new d(str, 0L, 0L, i));
                o(str);
            }
        }

        public synchronized void m(String str) {
            if (this.f43888g) {
                this.f43885d.add(new d(str, System.currentTimeMillis(), 0L));
            }
        }

        public synchronized void n(String str, long j) {
            if (this.f43888g) {
                this.f43886e.add(new d(str, 0L, j));
                o(str);
            }
        }

        public final void o(String str) {
            for (int i = 0; i < this.f43885d.size(); i++) {
                if (TextUtils.equals(this.f43885d.get(i).f43896a, str)) {
                    List<d> list = this.f43885d;
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
            if (!this.i || TextUtils.isEmpty(this.f43889h)) {
                return false;
            }
            d.b.g0.a.e0.b.h(h(), this.f43889h);
            this.i = false;
            return true;
        }

        public void r() {
            SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            StringBuilder sb = new StringBuilder(activity.getText(h.swanapp_tip_cur_title));
            sb.append(TextUtils.isEmpty(this.f43889h) ? "未检测到异常\n" : this.f43889h);
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
            if (!this.f43888g || b.f43875a <= 0) {
                return;
            }
            Timer timer = new Timer();
            this.j = timer;
            timer.schedule(new a(), b.f43875a);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
