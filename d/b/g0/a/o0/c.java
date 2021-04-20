package d.b.g0.a.o0;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.e0.l.f;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.i2.p0;
import d.b.g0.a.k;
import d.b.g0.a.n1.c.e.a;
import d.b.g0.a.r1.i;
import d.b.g0.a.r1.m;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.z1.h;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public abstract class c extends m {
    public static final boolean u = k.f45443a;

    /* renamed from: f  reason: collision with root package name */
    public final SwanAppActivity f45803f;

    /* renamed from: g  reason: collision with root package name */
    public f f45804g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f45805h;
    public final d.b.g0.a.c2.f.b i;
    public FrameLayout j;
    public d.b.g0.a.z1.a k;
    public d.b.g0.a.o0.d l;
    public boolean m;
    public final String n;
    public FrameLifeState o;
    public FrameLifeState p;
    public boolean q;
    public boolean r;
    public final d.b.g0.a.r1.b s;
    public boolean t;

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<i.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f45806e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45807f;

        public a(boolean z, boolean z2) {
            this.f45806e = z;
            this.f45807f = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            if (d.b.g0.a.r1.d.e().x()) {
                c.this.s.f("event_first_action_launched");
                c.this.t0(this.f45806e, this.f45807f);
                c.this.A0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.A0();
        }
    }

    /* renamed from: d.b.g0.a.o0.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0761c implements Runnable {
        public RunnableC0761c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.g1.o.a.h().y();
            if (c.u) {
                Log.e("SwanActivityFrame", "try update on computation thread");
            }
            if (c.this.f45803f == null || d.b.g0.a.r1.e.y() == null) {
                return;
            }
            d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
            d.b.g0.a.j0.j.c k = d.b.g0.a.j0.j.c.k();
            k.m(10);
            d.b.g0.a.g0.d.b.d(y, k.j());
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f45812e;

            public a(Bitmap bitmap) {
                this.f45812e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f45803f == null || d.b.g0.a.r1.e.O() == null) {
                    return;
                }
                c.this.E(this.f45812e);
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k0.X(new a(k0.j(c.this.M(), "SwanActivityFrame", true)));
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45814a;

        static {
            int[] iArr = new int[FrameLifeState.values().length];
            f45814a = iArr;
            try {
                iArr[FrameLifeState.JUST_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45814a[FrameLifeState.JUST_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45814a[FrameLifeState.JUST_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45814a[FrameLifeState.INACTIVATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public c(SwanAppActivity swanAppActivity, String str) {
        super(d.b.g0.a.r1.d.e());
        this.f45805h = null;
        this.i = new d.b.g0.a.c2.f.b();
        this.o = FrameLifeState.INACTIVATED;
        this.p = null;
        this.q = false;
        this.r = false;
        this.s = new d.b.g0.a.r1.b();
        this.t = true;
        this.f45803f = swanAppActivity;
        this.n = str;
        this.l = new d.b.g0.a.o0.d();
        i(this.s);
    }

    public static boolean L() {
        if (d.b.g0.a.j1.m.b.e()) {
            return d.b.g0.a.j1.m.b.b();
        }
        d.b.g0.a.w0.a.N().getSwitch("swan_fixed_relaunch_switch", true);
        return true;
    }

    public static void y0(Activity activity, String str, Bitmap bitmap, int i) {
        if (i != 0 && Color.alpha(i) != 255) {
            i = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i));
        }
    }

    public void A() {
        if (this.f45805h == null) {
            this.f45805h = O();
        }
        q().y(null, this.f45805h);
    }

    public final synchronized void A0() {
        boolean z = true;
        this.q = true;
        while (this.p != null && S()) {
            FrameLifeState z2 = z(this.p);
            W("syncLifeState: pendingTarget=" + this.p + " fixedTarget=" + z2);
            this.p = null;
            int i = e.f45814a[z2.ordinal()];
            if (i == 1) {
                K();
                F();
            } else if (i == 2) {
                H();
                J();
            } else if (i != 3) {
                G();
            } else {
                I();
            }
        }
        W("syncLifeState: done=" + this.o);
        if (FrameLifeState.INACTIVATED != this.p) {
            z = false;
        }
        this.r = z;
        this.q = false;
    }

    public boolean B() {
        if (this.m || !d.b.g0.a.q0.c.c().a(new WeakReference<>(this.f45803f))) {
            return false;
        }
        this.m = true;
        return true;
    }

    public final void B0() {
        d.b.g0.a.p.c.b b2 = o().a().b();
        if (b2 != null) {
            b2.a(this.f45803f);
        }
    }

    public final void C() {
        this.f45804g = new f(this.f45803f);
        c0();
    }

    public void C0() {
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        d.b.g0.a.m.b z = y != null ? y.z() : null;
        if (z != null) {
            z.h(z.c(AppRuntime.getAppContext()));
        }
    }

    public final void D(d.b.g0.a.z1.k.f fVar) {
        if (fVar == null || !x()) {
            return;
        }
        b.a M = M();
        fVar.f47643a = h.n(h());
        fVar.f47647e = M.G();
        fVar.f47645c = M.S();
        fVar.b(h.l(M.V()));
        if (TextUtils.isEmpty(fVar.f47644b)) {
            fVar.f47644b = PrefetchEvent.STATE_CLICK;
        }
        fVar.d(M.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        if (TextUtils.equals(fVar.f47644b, PrefetchEvent.STATE_CLICK)) {
            d.b.g0.a.z1.d.a(fVar);
        } else {
            h.onEvent(fVar);
        }
    }

    public void D0() {
        B0();
        C0();
    }

    public final void E(Bitmap bitmap) {
        if (s().d()) {
            y0(this.f45803f, M().J(), bitmap, (int) M().Y());
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        W(" transLifeState: target=" + frameLifeState + " holdon=" + this.q + " locked=" + this.r + " thread=" + Thread.currentThread());
        if (!this.r) {
            this.p = frameLifeState;
            this.r = FrameLifeState.INACTIVATED == frameLifeState;
        }
        if (this.q) {
            return;
        }
        this.q = true;
        k0.X(new b());
    }

    public final synchronized void F() {
        if (!this.o.hasCreated()) {
            Z();
            d.b.g0.a.c0.c.g("SwanApp", "onPostCreate: " + this);
            i0();
            this.o = FrameLifeState.JUST_CREATED;
        }
    }

    public void F0() {
        q().Q();
        this.f45805h = null;
    }

    public final synchronized void G() {
        K();
        if (this.o.hasCreated()) {
            b0();
            this.o = FrameLifeState.INACTIVATED;
        }
    }

    public void G0(d.b.g0.a.o0.b bVar) {
        this.l.i(bVar);
    }

    public final synchronized void H() {
        if (this.o.hasResumed()) {
            h0();
            this.o = FrameLifeState.JUST_STARTED;
        }
    }

    public final synchronized void H0(FrameLifeState frameLifeState, boolean z) {
        if (!this.f45803f.isDestroyed()) {
            boolean z2 = false;
            boolean z3 = z | (!this.o.hasCreated());
            if (this.o.hasCreated() && z3) {
                z2 = true;
            }
            boolean L = L();
            this.t = L;
            if (L && z2 && !s().f()) {
                this.s.e(new a(z3, z2), "event_first_action_launched");
            } else {
                t0(z3, z2);
            }
            E0(frameLifeState);
            if (z3 && (z2 || 1 == h())) {
                d.b.g0.a.j1.i.i(M(), z2);
            }
        }
    }

    public final synchronized void I() {
        J();
        if (!this.o.hasResumed()) {
            m0();
            this.o = FrameLifeState.JUST_RESUMED;
        }
    }

    public final void I0() {
        if (s().d()) {
            ExecutorUtilsExt.postOnElastic(new d(), "updateTaskDescription", 2);
        }
    }

    public final synchronized void J() {
        F();
        if (!this.o.hasStarted()) {
            o0();
            this.o = FrameLifeState.JUST_STARTED;
        }
    }

    public final synchronized void K() {
        H();
        if (this.o.hasStarted()) {
            q0();
            this.o = FrameLifeState.JUST_CREATED;
        }
    }

    public b.a M() {
        return s().J();
    }

    public synchronized FrameLifeState N() {
        return this.o;
    }

    @NonNull
    public abstract a.c O();

    public f P() {
        if (this.f45804g == null) {
            C();
        }
        return this.f45804g;
    }

    @NonNull
    public d.b.g0.a.c2.f.b Q() {
        return this.i;
    }

    public boolean R() {
        if (this.f45804g.k() != 1) {
            return false;
        }
        this.f45803f.moveTaskToBack(true);
        this.f45803f.handleSwanAppExit(2);
        p0.b().e(1);
        return true;
    }

    public boolean S() {
        return d.b.g0.a.z0.f.V().Z();
    }

    public boolean T() {
        return false;
    }

    public boolean U(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    public boolean V() {
        return this.r;
    }

    public final void W(String str) {
        if (u) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public abstract void X();

    public abstract void Y();

    @DebugTrace
    public final synchronized void Z() {
        W("onCreateInternal");
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        o.A(new UbcFlowEvent("frame_start_create"));
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onCreateInternalStart");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        this.l.g();
        d.b.g0.a.c0.c.g("SwanApp", "onCreate: " + this);
        if (d.b.g0.a.c0.d.d.e.d()) {
            d.b.g0.a.e0.w.d.t0(false);
        }
        C();
        d.b.g0.a.r1.d e2 = d.b.g0.a.r1.d.e();
        if (e2.x() && e2.s().d()) {
            A();
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onCreateStart");
            ubcFlowEvent2.a(true);
            o.A(ubcFlowEvent2);
            Y();
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onCreateEnd");
            ubcFlowEvent3.a(true);
            o.A(ubcFlowEvent3);
            d.b.g0.a.i2.d slideHelper = this.f45803f.getSlideHelper();
            if (slideHelper != null) {
                slideHelper.o();
            }
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onCreateInternalEnd");
            ubcFlowEvent4.a(true);
            o.A(ubcFlowEvent4);
            return;
        }
        d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
        aVar.j(5L);
        aVar.h(11L);
        aVar.e("aiapp data is invalid");
        d.b.g0.a.f2.e.a().f(aVar);
        d.b.g0.a.z1.k.d dVar = new d.b.g0.a.z1.k.d();
        dVar.q(h.n(h()));
        dVar.p(aVar);
        dVar.r(M());
        h.H(dVar);
        d.b.g0.a.j1.i.j(aVar);
        d.b.g0.a.i2.e.i(this.f45803f);
    }

    public abstract void a0();

    public final synchronized void b0() {
        W("onDestroyInternal");
        a0();
        this.l.d();
        d.b.g0.a.c0.c.g("SwanApp", "onDestroy: " + this);
        d.b.g0.a.g1.o.a.h().v();
        d.b.g0.a.e0.s.a.e().j();
        d.b.g0.a.t.d.c.c().d();
        d.b.g0.a.j1.p.d.f();
        w0();
        F0();
        d.b.g0.a.z0.f.d0();
    }

    public void c0() {
    }

    public boolean d0(int i, KeyEvent keyEvent) {
        return this.l.onKeyDown(i, keyEvent);
    }

    public void e0() {
    }

    public void f0() {
        this.l.a();
    }

    public abstract void g0();

    public final synchronized void h0() {
        W("onPauseInternal");
        g0();
        d.b.g0.a.z0.f.V().b();
        this.l.c();
        d.b.g0.a.c0.c.g("SwanApp", "onPause: " + this);
        if (this.k != null && x()) {
            d.b.g0.a.z1.k.a aVar = new d.b.g0.a.z1.k.a();
            b.a M = M();
            aVar.f47643a = h.n(h());
            aVar.f47647e = M.G();
            aVar.f47645c = M.S();
            aVar.i(M);
            aVar.d(M.n0().getString(UBCCloudControlProcessor.UBC_KEY));
            aVar.b(h.l(M.V()));
            h.k(this.k, aVar);
            this.k = null;
        }
    }

    public abstract void i0();

    public abstract void j0();

    public final synchronized void k0() {
        W("onReleaseInternal");
        j0();
        d.b.g0.a.z0.f.d0();
        d.b.g0.a.e0.p.r.a.c();
    }

    public abstract void l0();

    public final synchronized void m0() {
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onResumeInternalStart");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        W("onResumeInternal");
        this.l.f();
        d.b.g0.a.c0.c.g("SwanApp", "onResume: " + this);
        this.k = h.e("607");
        I0();
        if (x()) {
            s().j0(this.f45803f);
        }
        p.j(new RunnableC0761c(), "saveSwanAppHistory");
        HybridUbcFlow o2 = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_page_show");
        ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
        o2.A(ubcFlowEvent2);
        d.b.g0.a.y1.a.d().i("na_page_show");
        d.b.g0.a.z0.f.V().a();
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onResumeStart");
        ubcFlowEvent3.a(true);
        o.A(ubcFlowEvent3);
        l0();
        UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onResumeEnd");
        ubcFlowEvent4.a(true);
        o.A(ubcFlowEvent4);
    }

    public abstract void n0();

    public final synchronized void o0() {
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onStartStart");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        W("onStartInternal");
        this.l.e();
        n0();
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onStartEnd");
        ubcFlowEvent2.a(true);
        o.A(ubcFlowEvent2);
    }

    public abstract void p0();

    public final synchronized void q0() {
        d.b.g0.a.j1.i.l();
        W("onStopInternal");
        p0();
        this.l.b();
    }

    public void r0(int i) {
        d.b.g0.a.c0.c.l("SwanActivityFrame", "onTrimMemory level:" + i);
        Q().a(i);
    }

    public abstract void s0(boolean z, boolean z2);

    public final synchronized void t0(boolean z, boolean z2) {
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onUpdateInternalStart");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        W("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a M = M();
            if (!z2) {
                e0();
            }
            if (!TextUtils.isEmpty(M.d0())) {
                d.b.g0.a.c0.d.d.e.g(M.d0());
            }
        }
        d.b.g0.a.z0.f.V().x(this.f45803f);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onUpdateStart");
        ubcFlowEvent2.a(true);
        o.A(ubcFlowEvent2);
        s0(z, z2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onUpdateEnd");
        ubcFlowEvent3.a(true);
        o.A(ubcFlowEvent3);
    }

    public void u0(d.b.g0.a.o0.b bVar) {
        this.l.h(bVar);
    }

    public final synchronized void v0() {
        E0(FrameLifeState.INACTIVATED);
        k0();
    }

    public final void w0() {
        d.b.g0.a.t1.k.p0.c.f46859b = null;
        d.b.g0.a.j1.i.f45278d = null;
    }

    public void x0() {
        d.b.g0.a.q1.b.d.a.c(this.j);
    }

    public final synchronized FrameLifeState z(@NonNull FrameLifeState frameLifeState) {
        if (!frameLifeState.inactivated() && !s().f() && frameLifeState.hasStarted() && !frameLifeState.moreInactiveThan(this.o)) {
            return this.o.hasCreated() ? this.o : FrameLifeState.JUST_CREATED;
        }
        return frameLifeState;
    }

    public void z0() {
        FrameLayout frameLayout = (FrameLayout) this.f45803f.findViewById(d.b.g0.a.f.ai_apps_activity_root);
        this.j = frameLayout;
        d.b.g0.a.q1.b.d.a.e(this.f45803f, frameLayout);
    }
}
