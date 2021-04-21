package d.b.h0.a.j1.m;

import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import d.b.h0.a.e0.i.a;
import d.b.h0.a.e0.r.a;
import d.b.h0.a.e0.w.d;
import d.b.h0.a.f1.f;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45642a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45643b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f45644c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile C0741b f45645d;

    /* renamed from: d.b.h0.a.j1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0741b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f45646a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f45647b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f45648c;

        public C0741b() {
            d.b.h0.a.w0.a.N().a();
            d.b.h0.a.w0.a.N().t();
            d.b.h0.a.w0.a.N().B();
            this.f45646a = f.f();
            this.f45647b = d.b.h0.a.o0.c.L();
            this.f45648c = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }

    static {
        f45643b = !ProcessUtils.isMainProcess() && d.b.h0.a.w0.a.N().A();
        f45644c = false;
    }

    public static C0741b a() {
        if (f45645d == null) {
            synchronized (C0741b.class) {
                if (f45645d == null) {
                    f45645d = new C0741b();
                    if (f45642a) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return f45645d;
    }

    public static boolean b() {
        return a().f45647b;
    }

    public static boolean c() {
        return a().f45648c;
    }

    public static boolean d() {
        return a().f45646a;
    }

    public static boolean e() {
        return f45643b && f45644c && f45645d != null;
    }

    public static void f() {
        if (f45644c) {
            return;
        }
        if (f45642a) {
            Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + f45643b);
        }
        h();
        g();
        f45644c = true;
    }

    public static void g() {
        a();
    }

    public static void h() {
        a.b.b();
        a.C0712a.b();
        d.b.h0.a.w0.a.N().K();
        d.b.h0.a.e0.s.a.e();
        d.b.h0.a.i2.b.j();
        d.a();
        d.m.e();
        d.p.c();
        d.o.f(Boolean.TRUE);
    }

    public static boolean i() {
        return f45644c;
    }
}
