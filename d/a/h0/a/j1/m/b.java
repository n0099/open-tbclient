package d.a.h0.a.j1.m;

import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import d.a.h0.a.e0.i.a;
import d.a.h0.a.e0.r.a;
import d.a.h0.a.e0.w.d;
import d.a.h0.a.f1.f;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42966a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f42967b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f42968c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile C0680b f42969d;

    /* renamed from: d.a.h0.a.j1.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0680b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f42970a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f42971b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f42972c;

        public C0680b() {
            d.a.h0.a.w0.a.N().x();
            d.a.h0.a.w0.a.N().k();
            d.a.h0.a.w0.a.N().I();
            this.f42970a = f.f();
            this.f42971b = d.a.h0.a.o0.c.L();
            this.f42972c = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }

    static {
        f42967b = !ProcessUtils.isMainProcess() && d.a.h0.a.w0.a.N().p();
        f42968c = false;
    }

    public static C0680b a() {
        if (f42969d == null) {
            synchronized (C0680b.class) {
                if (f42969d == null) {
                    f42969d = new C0680b();
                    if (f42966a) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return f42969d;
    }

    public static boolean b() {
        return a().f42971b;
    }

    public static boolean c() {
        return a().f42972c;
    }

    public static boolean d() {
        return a().f42970a;
    }

    public static boolean e() {
        return f42967b && f42968c && f42969d != null;
    }

    public static void f() {
        if (f42968c) {
            return;
        }
        if (f42966a) {
            Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + f42967b);
        }
        h();
        g();
        f42968c = true;
    }

    public static void g() {
        a();
    }

    public static void h() {
        a.b.b();
        a.C0651a.b();
        d.a.h0.a.w0.a.N().w();
        d.a.h0.a.e0.s.a.e();
        d.a.h0.a.i2.b.j();
        d.a();
        d.m.e();
        d.p.c();
        d.o.f(Boolean.TRUE);
    }

    public static boolean i() {
        return f42968c;
    }
}
