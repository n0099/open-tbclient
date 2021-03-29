package d.b.g0.a.j1.m;

import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import d.b.g0.a.e0.i.a;
import d.b.g0.a.e0.r.a;
import d.b.g0.a.e0.w.d;
import d.b.g0.a.f1.f;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44921a = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44922b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f44923c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile C0709b f44924d;

    /* renamed from: d.b.g0.a.j1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0709b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f44925a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f44926b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f44927c;

        public C0709b() {
            d.b.g0.a.w0.a.N().a();
            d.b.g0.a.w0.a.N().t();
            d.b.g0.a.w0.a.N().B();
            this.f44925a = f.f();
            this.f44926b = d.b.g0.a.o0.c.L();
            this.f44927c = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }

    static {
        f44922b = !ProcessUtils.isMainProcess() && d.b.g0.a.w0.a.N().A();
        f44923c = false;
    }

    public static C0709b a() {
        if (f44924d == null) {
            synchronized (C0709b.class) {
                if (f44924d == null) {
                    f44924d = new C0709b();
                    if (f44921a) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return f44924d;
    }

    public static boolean b() {
        return a().f44926b;
    }

    public static boolean c() {
        return a().f44927c;
    }

    public static boolean d() {
        return a().f44925a;
    }

    public static boolean e() {
        return f44922b && f44923c && f44924d != null;
    }

    public static void f() {
        if (f44923c) {
            return;
        }
        if (f44921a) {
            Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + f44922b);
        }
        h();
        g();
        f44923c = true;
    }

    public static void g() {
        a();
    }

    public static void h() {
        a.b.b();
        a.C0680a.b();
        d.b.g0.a.w0.a.N().K();
        d.b.g0.a.e0.s.a.e();
        d.b.g0.a.i2.b.j();
        d.a();
        d.m.e();
        d.p.c();
        d.o.f(Boolean.TRUE);
    }

    public static boolean i() {
        return f44923c;
    }
}
