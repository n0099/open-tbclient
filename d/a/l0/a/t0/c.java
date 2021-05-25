package d.a.l0.a.t0;

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
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.l0.a.a2.i;
import d.a.l0.a.a2.m;
import d.a.l0.a.f;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.k;
import d.a.l0.a.r1.h;
import d.a.l0.a.v1.c.e.a;
import d.a.l0.a.v2.p;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.x0;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public abstract class c extends m {
    public static final boolean u = k.f43199a;

    /* renamed from: f  reason: collision with root package name */
    public final SwanAppActivity f44717f;

    /* renamed from: g  reason: collision with root package name */
    public g f44718g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f44719h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.l0.a.n2.h.d f44720i;
    public FrameLayout j;
    public d.a.l0.a.j2.a k;
    public d.a.l0.a.t0.d l;
    public boolean m;
    public final String n;
    public FrameLifeState o;
    public FrameLifeState p;
    public boolean q;
    public boolean r;
    public final d.a.l0.a.a2.b s;
    public boolean t;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<i.a> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44721e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f44722f;

        public a(boolean z, boolean z2) {
            this.f44721e = z;
            this.f44722f = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            if (d.a.l0.a.a2.d.g().C()) {
                c.this.s.f("event_first_action_launched");
                c.this.w0(this.f44721e, this.f44722f);
                c.this.D0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.D0();
        }
    }

    /* renamed from: d.a.l0.a.t0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0822c implements Runnable {
        public RunnableC0822c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.n1.q.a.g().y();
            if (c.u) {
                Log.e("SwanActivityFrame", "try update on computation thread");
            }
            if (c.this.f44717f != null && d.a.l0.a.a2.e.i() != null) {
                d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
                d.a.l0.a.n0.l.c l = d.a.l0.a.n0.l.c.l();
                l.n(10);
                d.a.l0.a.w0.c.c(i2, l.k());
            }
            if (d.a.l0.a.r1.l.e.l()) {
                p.i(c.this.f44717f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f44727e;

            public a(Bitmap bitmap) {
                this.f44727e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f44717f == null || d.a.l0.a.a2.e.Q() == null) {
                    return;
                }
                c.this.G(this.f44727e);
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q0.b0(new a(q0.i(c.this.O(), "SwanActivityFrame", true)));
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44729a;

        static {
            int[] iArr = new int[FrameLifeState.values().length];
            f44729a = iArr;
            try {
                iArr[FrameLifeState.JUST_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44729a[FrameLifeState.JUST_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44729a[FrameLifeState.JUST_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44729a[FrameLifeState.INACTIVATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public c(SwanAppActivity swanAppActivity, String str) {
        super(d.a.l0.a.a2.d.g());
        this.f44719h = null;
        this.f44720i = new d.a.l0.a.n2.h.d();
        this.o = FrameLifeState.INACTIVATED;
        this.p = null;
        this.q = false;
        this.r = false;
        this.s = new d.a.l0.a.a2.b();
        this.t = true;
        this.f44717f = swanAppActivity;
        this.n = str;
        this.l = new d.a.l0.a.t0.d();
        v(this.s);
    }

    public static void B0(Activity activity, String str, Bitmap bitmap, int i2) {
        if (i2 != 0 && Color.alpha(i2) != 255) {
            i2 = Color.argb(255, Color.red(i2), Color.green(i2), Color.blue(i2));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i2));
        }
    }

    public void A0() {
        d.a.l0.a.z1.b.d.a.c(this.j);
    }

    public void C0() {
        FrameLayout frameLayout = (FrameLayout) this.f44717f.findViewById(f.ai_apps_activity_root);
        this.j = frameLayout;
        d.a.l0.a.z1.b.d.a.e(this.f44717f, frameLayout);
    }

    public boolean D() {
        if (this.m || !d.a.l0.a.v0.c.c().a(new WeakReference<>(this.f44717f))) {
            return false;
        }
        this.m = true;
        return true;
    }

    public final synchronized void D0() {
        boolean z = true;
        this.q = true;
        while (this.p != null && U()) {
            FrameLifeState j = j(this.p);
            Y("syncLifeState: pendingTarget=" + this.p + " fixedTarget=" + j);
            this.p = null;
            int i2 = e.f44729a[j.ordinal()];
            if (i2 == 1) {
                M();
                H();
            } else if (i2 == 2) {
                J();
                L();
            } else if (i2 != 3) {
                I();
            } else {
                K();
            }
        }
        Y("syncLifeState: done=" + this.o);
        if (FrameLifeState.INACTIVATED != this.p) {
            z = false;
        }
        this.r = z;
        this.q = false;
    }

    public final void E() {
        this.f44718g = new g(this.f44717f);
        f0();
    }

    public final void E0() {
        d.a.l0.a.p.d.b a2 = y().a().a();
        if (a2 != null) {
            a2.a(this.f44717f);
        }
    }

    public final void F(d.a.l0.a.j2.p.f fVar) {
        if (fVar == null || !C()) {
            return;
        }
        b.a O = O();
        fVar.f43185a = d.a.l0.a.j2.k.m(l());
        fVar.f43190f = O.H();
        fVar.f43187c = O.T();
        fVar.b(d.a.l0.a.j2.k.k(O.W()));
        if (TextUtils.isEmpty(fVar.f43186b)) {
            fVar.f43186b = PrefetchEvent.STATE_CLICK;
        }
        fVar.d(O.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        if (TextUtils.equals(fVar.f43186b, PrefetchEvent.STATE_CLICK)) {
            d.a.l0.a.j2.d.b(fVar);
        } else {
            d.a.l0.a.j2.k.onEvent(fVar);
        }
    }

    public void F0() {
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        d.a.l0.a.m.b j = i2 != null ? i2.j() : null;
        if (j != null) {
            j.h(j.c(AppRuntime.getAppContext()));
        }
    }

    public final void G(Bitmap bitmap) {
        if (r().e()) {
            B0(this.f44717f, O().K(), bitmap, (int) O().b0());
        }
    }

    public void G0() {
        E0();
        F0();
    }

    public final synchronized void H() {
        if (!this.o.hasCreated()) {
            c0();
            d.a.l0.a.e0.d.g("SwanApp", "onPostCreate: " + this);
            l0();
            this.o = FrameLifeState.JUST_CREATED;
        }
    }

    public final synchronized void H0(@NonNull FrameLifeState frameLifeState) {
        Y(" transLifeState: target=" + frameLifeState + " holdon=" + this.q + " locked=" + this.r + " thread=" + Thread.currentThread());
        if (!this.r) {
            this.p = frameLifeState;
            this.r = FrameLifeState.INACTIVATED == frameLifeState;
        }
        if (this.q) {
            return;
        }
        this.q = true;
        q0.b0(new b());
    }

    public final synchronized void I() {
        M();
        if (this.o.hasCreated()) {
            e0();
            this.o = FrameLifeState.INACTIVATED;
        }
    }

    public void I0() {
        z().S();
        this.f44719h = null;
    }

    public final synchronized void J() {
        if (this.o.hasResumed()) {
            k0();
            this.o = FrameLifeState.JUST_STARTED;
        }
    }

    public void J0(d.a.l0.a.t0.b bVar) {
        this.l.i(bVar);
    }

    public final synchronized void K() {
        L();
        if (!this.o.hasResumed()) {
            p0();
            this.o = FrameLifeState.JUST_RESUMED;
        }
    }

    public final synchronized void K0(FrameLifeState frameLifeState, boolean z) {
        if (!this.f44717f.isDestroyed()) {
            boolean z2 = false;
            boolean z3 = z | (!this.o.hasCreated());
            if (this.o.hasCreated() && z3) {
                z2 = true;
            }
            boolean N = N();
            this.t = N;
            if (N && z2 && !r().g()) {
                this.s.e(new a(z3, z2), "event_first_action_launched");
            } else {
                w0(z3, z2);
            }
            H0(frameLifeState);
            if (z3 && (z2 || 1 == l())) {
                h.j(O(), z2);
            }
        }
    }

    public final synchronized void L() {
        H();
        if (!this.o.hasStarted()) {
            r0();
            this.o = FrameLifeState.JUST_STARTED;
        }
    }

    public final void L0() {
        if (r().e()) {
            d.a.l0.a.r1.k.i.b.e().f(new d(), "updateTaskDescription");
        }
    }

    public final synchronized void M() {
        J();
        if (this.o.hasStarted()) {
            t0();
            this.o = FrameLifeState.JUST_CREATED;
        }
    }

    public final boolean N() {
        d.a.l0.a.c1.a.Z().getSwitch("swan_fixed_relaunch_switch", true);
        return true;
    }

    public b.a O() {
        return r().L();
    }

    public synchronized FrameLifeState P() {
        return this.o;
    }

    @NonNull
    public abstract a.c Q();

    public g R() {
        if (this.f44718g == null) {
            E();
        }
        return this.f44718g;
    }

    @NonNull
    public d.a.l0.a.n2.h.d S() {
        return this.f44720i;
    }

    public boolean T() {
        if (this.f44718g.k() != 1) {
            return false;
        }
        this.f44717f.moveTaskToBack(true);
        this.f44717f.handleSwanAppExit(2);
        x0.b().e(1);
        return true;
    }

    public boolean U() {
        return d.a.l0.a.g1.f.V().Z();
    }

    public boolean V() {
        return false;
    }

    public boolean W(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    public boolean X() {
        return this.r;
    }

    public final void Y(String str) {
        if (u) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public abstract void Z();

    public void a0(int i2) {
        Z();
    }

    public abstract void b0();

    @DebugTrace
    public final synchronized void c0() {
        Y("onCreateInternal");
        HybridUbcFlow p = h.p("startup");
        p.C(new UbcFlowEvent("frame_start_create"));
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onCreateInternalStart");
        ubcFlowEvent.a(true);
        p.C(ubcFlowEvent);
        this.l.g();
        d.a.l0.a.e0.d.g("SwanApp", "onCreate: " + this);
        if (d.a.l0.a.e0.f.e.e.d()) {
            d.a.l0.a.h0.u.g.A0(false);
        }
        E();
        d.a.l0.a.a2.d g2 = d.a.l0.a.a2.d.g();
        if (g2.C() && g2.r().e()) {
            k();
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onCreateStart");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
            b0();
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onCreateEnd");
            ubcFlowEvent3.a(true);
            p.C(ubcFlowEvent3);
            d.a.l0.a.v2.e slideHelper = this.f44717f.getSlideHelper();
            if (slideHelper != null) {
                slideHelper.q();
            }
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onCreateInternalEnd");
            ubcFlowEvent4.a(true);
            p.C(ubcFlowEvent4);
            return;
        }
        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
        aVar.j(5L);
        aVar.h(11L);
        aVar.e("aiapp data is invalid");
        d.a.l0.a.q2.e.a().f(aVar);
        d.a.l0.a.j2.p.d dVar = new d.a.l0.a.j2.p.d();
        dVar.q(d.a.l0.a.j2.k.m(l()));
        dVar.p(aVar);
        dVar.r(O());
        d.a.l0.a.j2.k.L(dVar);
        h.k(aVar);
        d.a.l0.a.v2.f.j(this.f44717f);
    }

    public abstract void d0();

    public final synchronized void e0() {
        Y("onDestroyInternal");
        d0();
        this.l.c();
        d.a.l0.a.e0.d.g("SwanApp", "onDestroy: " + this);
        d.a.l0.a.n1.q.a.g().u();
        d.a.l0.a.h0.q.b.g().n();
        d.a.l0.a.u.g.c.c().d();
        d.a.l0.a.r1.p.d.f();
        z0();
        I0();
        d.a.l0.a.g1.f.c0();
        d.a.l0.a.o0.b.b().a();
    }

    public void f0() {
    }

    public boolean g0(int i2, KeyEvent keyEvent) {
        return this.l.onKeyDown(i2, keyEvent);
    }

    public void h0() {
    }

    public void i0() {
        this.l.a();
    }

    public final synchronized FrameLifeState j(@NonNull FrameLifeState frameLifeState) {
        if (!frameLifeState.inactivated() && !r().g() && frameLifeState.hasStarted() && !frameLifeState.moreInactiveThan(this.o)) {
            return this.o.hasCreated() ? this.o : FrameLifeState.JUST_CREATED;
        }
        return frameLifeState;
    }

    public abstract void j0();

    public void k() {
        if (this.f44719h == null) {
            this.f44719h = Q();
        }
        z().i(null, this.f44719h);
    }

    public final synchronized void k0() {
        Y("onPauseInternal");
        j0();
        d.a.l0.a.g1.f.V().x();
        this.l.b();
        d.a.l0.a.e0.d.g("SwanApp", "onPause: " + this);
        if (this.k != null && C()) {
            d.a.l0.a.j2.p.a aVar = new d.a.l0.a.j2.p.a();
            b.a O = O();
            aVar.f43185a = d.a.l0.a.j2.k.m(l());
            aVar.f43190f = O.H();
            aVar.f43187c = O.T();
            aVar.i(O);
            aVar.d(O.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            aVar.b(d.a.l0.a.j2.k.k(O.W()));
            d.a.l0.a.j2.k.i(this.k, aVar);
            this.k = null;
        }
    }

    public abstract void l0();

    public abstract void m0();

    public final synchronized void n0() {
        Y("onReleaseInternal");
        m0();
        d.a.l0.a.g1.f.c0();
    }

    public abstract void o0();

    public final synchronized void p0() {
        HybridUbcFlow p = h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onResumeInternalStart");
        ubcFlowEvent.a(true);
        p.C(ubcFlowEvent);
        Y("onResumeInternal");
        this.l.e();
        d.a.l0.a.e0.d.g("SwanApp", "onResume: " + this);
        this.k = d.a.l0.a.j2.k.c("607");
        L0();
        if (C()) {
            r().o0(this.f44717f);
        }
        d.a.l0.a.r1.k.i.b.e().f(new RunnableC0822c(), "tryUpdateAndInsertHistory");
        HybridUbcFlow p2 = h.p("startup");
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_page_show");
        ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
        p2.C(ubcFlowEvent2);
        d.a.l0.a.i2.a.d().i("na_page_show");
        d.a.l0.a.g1.f.V().w();
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onResumeStart");
        ubcFlowEvent3.a(true);
        p.C(ubcFlowEvent3);
        o0();
        UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onResumeEnd");
        ubcFlowEvent4.a(true);
        p.C(ubcFlowEvent4);
    }

    public abstract void q0();

    public final synchronized void r0() {
        HybridUbcFlow p = h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onStartStart");
        ubcFlowEvent.a(true);
        p.C(ubcFlowEvent);
        Y("onStartInternal");
        this.l.d();
        q0();
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onStartEnd");
        ubcFlowEvent2.a(true);
        p.C(ubcFlowEvent2);
    }

    public abstract void s0();

    public final synchronized void t0() {
        h.m();
        Y("onStopInternal");
        s0();
        this.l.f();
    }

    public void u0(int i2) {
        d.a.l0.a.e0.d.l("SwanActivityFrame", "onTrimMemory level:" + i2);
        S().a(i2);
    }

    public abstract void v0(boolean z, boolean z2);

    public final synchronized void w0(boolean z, boolean z2) {
        HybridUbcFlow p = h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onUpdateInternalStart");
        ubcFlowEvent.a(true);
        p.C(ubcFlowEvent);
        Y("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a O = O();
            if (!z2) {
                h0();
            }
            if (!TextUtils.isEmpty(O.g0())) {
                d.a.l0.a.e0.f.e.e.g(O.g0());
            }
        }
        d.a.l0.a.g1.f.V().l(this.f44717f);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onUpdateStart");
        ubcFlowEvent2.a(true);
        p.C(ubcFlowEvent2);
        v0(z, z2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onUpdateEnd");
        ubcFlowEvent3.a(true);
        p.C(ubcFlowEvent3);
    }

    public void x0(d.a.l0.a.t0.b bVar) {
        this.l.h(bVar);
    }

    public final synchronized void y0() {
        H0(FrameLifeState.INACTIVATED);
        n0();
    }

    public final void z0() {
        d.a.l0.a.c2.f.p0.c.f41151b = null;
        h.f44442e = null;
    }
}
