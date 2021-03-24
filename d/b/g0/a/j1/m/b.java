package d.b.g0.a.j1.m;

import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import d.b.g0.a.e0.i.a;
import d.b.g0.a.e0.r.a;
import d.b.g0.a.e0.w.d;
import d.b.g0.a.f1.f;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44920a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44921b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f44922c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile C0708b f44923d;

    /* renamed from: d.b.g0.a.j1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0708b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f44924a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f44925b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f44926c;

        public C0708b() {
            d.b.g0.a.w0.a.N().a();
            d.b.g0.a.w0.a.N().t();
            d.b.g0.a.w0.a.N().B();
            this.f44924a = f.f();
            this.f44925b = d.b.g0.a.o0.c.L();
            this.f44926c = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }

    static {
        f44921b = !ProcessUtils.isMainProcess() && d.b.g0.a.w0.a.N().A();
        f44922c = false;
    }

    public static C0708b a() {
        if (f44923d == null) {
            synchronized (C0708b.class) {
                if (f44923d == null) {
                    f44923d = new C0708b();
                    if (f44920a) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return f44923d;
    }

    public static boolean b() {
        return a().f44925b;
    }

    public static boolean c() {
        return a().f44926c;
    }

    public static boolean d() {
        return a().f44924a;
    }

    public static boolean e() {
        return f44921b && f44922c && f44923d != null;
    }

    public static void f() {
        if (f44922c) {
            return;
        }
        if (f44920a) {
            Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + f44921b);
        }
        h();
        g();
        f44922c = true;
    }

    public static void g() {
        a();
    }

    public static void h() {
        a.b.b();
        a.C0679a.b();
        d.b.g0.a.w0.a.N().K();
        d.b.g0.a.e0.s.a.e();
        d.b.g0.a.i2.b.j();
        d.a();
        d.m.e();
        d.p.c();
        d.o.f(Boolean.TRUE);
    }

    public static boolean i() {
        return f44922c;
    }
}
