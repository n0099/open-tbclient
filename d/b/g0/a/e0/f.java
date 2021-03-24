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
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43870a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static c f43871b;

    /* loaded from: classes3.dex */
    public static class a implements SwanAppNetworkUtils.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43872a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43873b;

        public a(String str, String str2) {
            this.f43872a = str;
            this.f43873b = str2;
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i) {
            if (i == 1) {
                f.d(this.f43872a + "; 网络：正常");
                d.b.g0.a.e0.d.b(this.f43873b, FrsActivityConfig.GOOD);
                d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
            } else if (i == 2) {
                f.d(this.f43872a + "; 网络：较差");
                d.b.g0.a.e0.d.b(this.f43873b, "bad");
                d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
            } else if (i != 3) {
                f.d(this.f43872a + "; 网络：未知");
                d.b.g0.a.e0.d.b(this.f43873b, "unknown");
                d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
            } else {
                f.d(this.f43872a + "; 网络：离线");
                d.b.g0.a.e0.d.b(this.f43873b, "offline");
                d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final int f43874a = d.b.g0.a.w0.a.N().b();

        /* renamed from: b  reason: collision with root package name */
        public static final int f43875b = d.b.g0.a.w0.a.N().E();

        /* renamed from: c  reason: collision with root package name */
        public static final double f43876c = d.b.g0.a.w0.a.N().g();

        /* renamed from: d  reason: collision with root package name */
        public static final boolean f43877d = d.b.g0.a.w0.a.N().x();

        /* renamed from: e  reason: collision with root package name */
        public static final double f43878e = d.b.g0.a.w0.a.N().m();

        /* renamed from: f  reason: collision with root package name */
        public static final double f43879f = d.b.g0.a.w0.a.N().L();

        /* renamed from: g  reason: collision with root package name */
        public static final int f43880g = d.b.g0.a.w0.a.N().e();
    }

    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f43895a;

        /* renamed from: b  reason: collision with root package name */
        public long f43896b;

        /* renamed from: c  reason: collision with root package name */
        public long f43897c;

        /* renamed from: d  reason: collision with root package name */
        public int f43898d;

        public d(String str, long j, long j2) {
            this(str, j, j2, 200);
        }

        public d(String str, long j, long j2, int i) {
            this.f43895a = str;
            this.f43896b = j;
            this.f43897c = j2;
            this.f43898d = i;
        }
    }

    public static void b(SwanAppNetworkUtils.b bVar) {
        if (b.f43877d) {
            synchronized (f.class) {
                if (f43871b == null) {
                    c();
                }
            }
            f43871b.f(bVar);
        }
    }

    public static synchronized void c() {
        synchronized (f.class) {
            d.b.g0.a.e0.c.e();
            if (f43871b != null) {
                f43871b.d();
            }
            f43871b = new c(null);
        }
    }

    public static void d(String str) {
        if (b.f43877d) {
            synchronized (f.class) {
                if (f43871b == null) {
                    c();
                }
            }
            f43871b.i(str);
        }
    }

    public static void e(long j) {
        c cVar;
        if (b.f43877d && (cVar = f43871b) != null) {
            cVar.j(j);
        }
    }

    public static void f(long j) {
        c cVar;
        if (b.f43877d && (cVar = f43871b) != null) {
            cVar.k(j);
        }
    }

    public static void g(String str, int i) {
        c cVar;
        if (b.f43877d && (cVar = f43871b) != null) {
            cVar.l(str, i);
        }
    }

    public static void h(String str) {
        c cVar;
        if (b.f43877d && (cVar = f43871b) != null) {
            cVar.m(str);
        }
    }

    public static void i(String str, long j) {
        c cVar;
        if (b.f43877d && (cVar = f43871b) != null) {
            cVar.n(str, j);
        }
    }

    public static void j() {
        c cVar;
        if (b.f43877d && (cVar = f43871b) != null) {
            cVar.r();
        }
    }

    public static void k(String str, String str2) {
        b(new a(str2, str));
    }

    public static synchronized void l(boolean z) {
        synchronized (f.class) {
            if (b.f43877d) {
                if (d.b.g0.a.r1.d.e().h() == 1) {
                    return;
                }
                if (z || f43871b == null) {
                    c();
                }
                f43871b.s();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public long f43881a;

        /* renamed from: b  reason: collision with root package name */
        public long f43882b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f43883c;

        /* renamed from: d  reason: collision with root package name */
        public List<d> f43884d;

        /* renamed from: e  reason: collision with root package name */
        public List<d> f43885e;

        /* renamed from: f  reason: collision with root package name */
        public List<d> f43886f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f43887g;

        /* renamed from: h  reason: collision with root package name */
        public String f43888h;
        public boolean i;
        public Timer j;

        /* loaded from: classes3.dex */
        public class a extends TimerTask {

            /* renamed from: d.b.g0.a.e0.f$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0645a extends d.b.g0.a.o0.a {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SwanAppActivity f43890a;

                public C0645a(SwanAppActivity swanAppActivity) {
                    this.f43890a = swanAppActivity;
                }

                @Override // d.b.g0.a.o0.a, d.b.g0.a.o0.b
                public void b() {
                    if (c.this.q()) {
                        this.f43890a.unregisterCallback(this);
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
                activity.registerCallback(new C0645a(activity));
            }
        }

        /* loaded from: classes3.dex */
        public class b implements DialogInterface.OnClickListener {
            public b(c cVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: d.b.g0.a.e0.f$c$c  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0646c implements SwanAppNetworkUtils.b {
            public C0646c() {
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i) {
                if (k0.E()) {
                    if (i == 1) {
                        c cVar = c.this;
                        cVar.i(d.b.g0.a.e0.a.f43857a + "; 网络：正常");
                        d.b.g0.a.e0.d.b("fmp_timeout", FrsActivityConfig.GOOD);
                        d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
                    } else if (i == 2) {
                        c cVar2 = c.this;
                        cVar2.i(d.b.g0.a.e0.a.f43857a + "; 网络：较差");
                        d.b.g0.a.e0.d.b("fmp_timeout", "bad");
                        d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                    } else if (i != 3) {
                        c cVar3 = c.this;
                        cVar3.i(d.b.g0.a.e0.a.f43857a + "; 网络：未知");
                        d.b.g0.a.e0.d.b("fmp_timeout", "unknown");
                        d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
                    } else {
                        c cVar4 = c.this;
                        cVar4.i(d.b.g0.a.e0.a.f43857a + "; 网络：离线");
                        d.b.g0.a.e0.d.b("fmp_timeout", "offline");
                        d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class d implements SwanAppNetworkUtils.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f43893a;

            public d(String str) {
                this.f43893a = str;
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i) {
                if (i == 1) {
                    c cVar = c.this;
                    cVar.i(this.f43893a + "; 网络：正常");
                    d.b.g0.a.e0.d.b("request_slow", FrsActivityConfig.GOOD);
                    d.b.g0.a.e0.c.f(h.swanapp_tip_service_slow);
                } else if (i == 2) {
                    c cVar2 = c.this;
                    cVar2.i(this.f43893a + "; 网络：较差");
                    d.b.g0.a.e0.d.b("request_slow", "bad");
                    d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                } else if (i != 3) {
                    c cVar3 = c.this;
                    cVar3.i(this.f43893a + "; 网络：未知");
                    d.b.g0.a.e0.d.b("request_slow", "unknown");
                    d.b.g0.a.e0.c.f(h.swanapp_tip_loading_slow);
                } else {
                    c cVar4 = c.this;
                    cVar4.i(this.f43893a + "; 网络：离线");
                    d.b.g0.a.e0.d.b("request_slow", "offline");
                    d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
                }
            }
        }

        public c() {
            this.f43881a = 0L;
            this.f43882b = 0L;
            this.f43883c = false;
            this.f43884d = new ArrayList();
            this.f43885e = new ArrayList();
            this.f43886f = new ArrayList();
            this.f43887g = b.f43877d;
            this.f43888h = "";
            this.i = false;
        }

        public void d() {
            p();
        }

        public final void e(long j) {
            if (this.f43883c) {
                return;
            }
            this.f43883c = true;
            long h2 = h();
            if (h2 == 0 || j - h2 <= b.f43880g) {
                return;
            }
            f(new C0646c());
        }

        public void f(SwanAppNetworkUtils.b bVar) {
            this.i = true;
            SwanAppNetworkUtils.b(bVar);
        }

        public final synchronized void g() {
            this.f43887g = false;
            long currentTimeMillis = System.currentTimeMillis();
            for (d dVar : this.f43884d) {
                dVar.f43897c = currentTimeMillis - dVar.f43896b;
                this.f43885e.add(dVar);
            }
            int i = 0;
            for (int i2 = 0; i2 < this.f43886f.size(); i2++) {
                d dVar2 = this.f43886f.get(i2);
                if (dVar2 != null && dVar2.f43898d >= 400 && dVar2.f43898d < 600) {
                    i++;
                }
            }
            int size = this.f43885e.size();
            if (i > 0) {
                i("检查request状况，总请求次数：" + (i + size) + ", 失败次数: " + i);
            }
            double d2 = i;
            double d3 = i + size;
            Double.isNaN(d2);
            Double.isNaN(d3);
            if (d2 / d3 >= b.f43876c) {
                i(d.b.g0.a.e0.a.f43860d);
                this.i = true;
                d.b.g0.a.e0.c.f(h.swanapp_tip_service_unavailable);
                d.b.g0.a.e0.d.a("request_fail");
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.f43885e.size(); i4++) {
                d dVar3 = this.f43885e.get(i4);
                if (dVar3.f43897c > b.f43875b) {
                    try {
                        URL url = new URL(dVar3.f43895a);
                        i("请求 " + url.getPath() + " 耗时较长 ：" + dVar3.f43897c + "ms");
                    } catch (MalformedURLException e2) {
                        if (f.f43870a) {
                            e2.printStackTrace();
                        }
                    }
                    i3++;
                }
            }
            if (i3 >= 2) {
                f(new d(String.format("检测到%s个请求耗时大于 %s ms", Integer.valueOf(i3), Integer.valueOf(b.f43875b))));
            }
            this.f43884d.clear();
            this.f43885e.clear();
            this.f43886f.clear();
        }

        public final long h() {
            d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
            if (O != null) {
                return O.J().k("launch_time", 0L);
            }
            return 0L;
        }

        public void i(String str) {
            this.f43888h += j.f(System.currentTimeMillis(), "【HH:mm:ss】") + str + "\n";
            if (f.f43870a) {
                Log.d("SwanAppLaunchTips", str);
            }
        }

        public void j(long j) {
            if (this.f43881a == 0) {
                this.f43881a = j;
                e(j);
            }
        }

        public void k(long j) {
            if (this.f43882b == 0) {
                this.f43882b = j;
                e(j);
            }
        }

        public synchronized void l(String str, int i) {
            if (this.f43887g) {
                this.f43886f.add(new d(str, 0L, 0L, i));
                o(str);
            }
        }

        public synchronized void m(String str) {
            if (this.f43887g) {
                this.f43884d.add(new d(str, System.currentTimeMillis(), 0L));
            }
        }

        public synchronized void n(String str, long j) {
            if (this.f43887g) {
                this.f43885e.add(new d(str, 0L, j));
                o(str);
            }
        }

        public final void o(String str) {
            for (int i = 0; i < this.f43884d.size(); i++) {
                if (TextUtils.equals(this.f43884d.get(i).f43895a, str)) {
                    List<d> list = this.f43884d;
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
            if (!this.i || TextUtils.isEmpty(this.f43888h)) {
                return false;
            }
            d.b.g0.a.e0.b.h(h(), this.f43888h);
            this.i = false;
            return true;
        }

        public void r() {
            SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            StringBuilder sb = new StringBuilder(activity.getText(h.swanapp_tip_cur_title));
            sb.append(TextUtils.isEmpty(this.f43888h) ? "未检测到异常\n" : this.f43888h);
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
            if (!this.f43887g || b.f43874a <= 0) {
                return;
            }
            Timer timer = new Timer();
            this.j = timer;
            timer.schedule(new a(), b.f43874a);
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }
}
