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
    public static final boolean f45313a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45314b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f45315c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile C0721b f45316d;

    /* renamed from: d.b.g0.a.j1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0721b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f45317a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f45318b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f45319c;

        public C0721b() {
            d.b.g0.a.w0.a.N().a();
            d.b.g0.a.w0.a.N().t();
            d.b.g0.a.w0.a.N().B();
            this.f45317a = f.f();
            this.f45318b = d.b.g0.a.o0.c.L();
            this.f45319c = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }

    static {
        f45314b = !ProcessUtils.isMainProcess() && d.b.g0.a.w0.a.N().A();
        f45315c = false;
    }

    public static C0721b a() {
        if (f45316d == null) {
            synchronized (C0721b.class) {
                if (f45316d == null) {
                    f45316d = new C0721b();
                    if (f45313a) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return f45316d;
    }

    public static boolean b() {
        return a().f45318b;
    }

    public static boolean c() {
        return a().f45319c;
    }

    public static boolean d() {
        return a().f45317a;
    }

    public static boolean e() {
        return f45314b && f45315c && f45316d != null;
    }

    public static void f() {
        if (f45315c) {
            return;
        }
        if (f45313a) {
            Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + f45314b);
        }
        h();
        g();
        f45315c = true;
    }

    public static void g() {
        a();
    }

    public static void h() {
        a.b.b();
        a.C0692a.b();
        d.b.g0.a.w0.a.N().K();
        d.b.g0.a.e0.s.a.e();
        d.b.g0.a.i2.b.j();
        d.a();
        d.m.e();
        d.p.c();
        d.o.f(Boolean.TRUE);
    }

    public static boolean i() {
        return f45315c;
    }
}
