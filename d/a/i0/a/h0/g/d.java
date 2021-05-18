package d.a.i0.a.h0.g;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.v0.c;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.x0;
import d.a.i0.k.n;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class d extends Fragment implements SlideInterceptor {
    public static final boolean w0 = d.a.i0.a.k.f43025a;
    public Activity f0;
    public d.a.i0.a.l1.c g0;
    public View h0;
    public SwanAppActionBar i0;
    public n j0;
    public SwanAppMenuHeaderView k0;
    public View l0;
    public TextView m0;
    @Nullable
    public d.a.i0.a.w2.d.b n0;
    public SlideHelper p0;
    public l s0;
    public m t0;
    public d.a.i0.a.h0.g.l.c v0;
    public boolean o0 = d.a.i0.a.w2.d.b.f45482i;
    public int q0 = 1;
    public int r0 = 1;
    public boolean u0 = false;

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                d.this.p0.setRegionFactor(0.1d);
                d dVar = d.this;
                dVar.p0.setCanSlide(dVar.w1());
                return;
            }
            d dVar2 = d.this;
            dVar2.p0.setCanSlide(dVar2.w1());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {
        public b() {
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
            d.this.f2();
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            d.this.B1();
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            View maskView = d.this.p0.getMaskView();
            if (maskView != null) {
                maskView.setAlpha(1.0f - f2);
            }
            d.this.g2(f2);
            if (d.this.t0 != null) {
                d.this.t0.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.m1.g.d();
        }
    }

    /* renamed from: d.a.i0.a.h0.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC0648d implements View.OnClickListener {

        /* renamed from: d.a.i0.a.h0.g.d$d$a */
        /* loaded from: classes2.dex */
        public class a implements d.a.i0.a.h0.j.b<Boolean> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.h0.j.b
            /* renamed from: b */
            public void a(Boolean bool) {
                if (bool.booleanValue()) {
                    d.this.c2();
                }
            }
        }

        public View$OnClickListenerC0648d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.i0.a.v0.a.b().c()) {
                d.a.i0.a.v0.a.b().f(d.this.f0, new a());
            } else {
                d.this.c2();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.e2();
            d.a.i0.a.j2.p.f fVar = new d.a.i0.a.j2.p.f();
            fVar.f43015e = SupportMenuInflater.XML_MENU;
            if (d.a.i0.a.a2.e.Q() != null && d.a.i0.a.a2.e.Q().J().d("key_unread_counts_message", 0).intValue() > 0) {
                fVar.f43017g = String.valueOf(1);
            }
            d.this.y1(fVar);
            if (d.this.s0 != null) {
                d.this.s0.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {

        /* loaded from: classes2.dex */
        public class a implements d.a.i0.a.h0.j.b<Boolean> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.h0.j.b
            /* renamed from: b */
            public void a(Boolean bool) {
                if (bool.booleanValue()) {
                    d.this.x1();
                }
            }
        }

        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = d.this.f0;
            if (activity == null || !(activity instanceof SwanAppActivity)) {
                return;
            }
            if (d.a.i0.a.a2.e.i() == null || d.a.i0.a.a2.e.V() == null) {
                d.this.x1();
            } else if (d.a.i0.a.v0.a.b().c()) {
                d.a.i0.a.v0.a.b().f(d.this.f0, new a());
            } else if (d.a.i0.a.v0.c.c().h()) {
                d.this.x1();
            } else {
                d.a.i0.a.v0.b bVar = new d.a.i0.a.v0.b();
                bVar.h();
                if (!bVar.k()) {
                    d.this.x1();
                    d.a.i0.a.m1.g.f().i();
                    return;
                }
                String f2 = bVar.f();
                String e2 = bVar.e();
                d.a.i0.a.v0.c c2 = d.a.i0.a.v0.c.c();
                d dVar = d.this;
                c2.j(dVar.f0, f2, e2, bVar, dVar.C1());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements c.b {
        public g() {
        }

        @Override // d.a.i0.a.v0.c.b
        public void a() {
            d.this.x1();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.i2();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.z1(d.a.i0.a.u1.a.a.D());
        }
    }

    /* loaded from: classes2.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f41870e;

        public j(boolean z) {
            this.f41870e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActionBar swanAppActionBar;
            d dVar = d.this;
            if (dVar.f0 == null || (swanAppActionBar = dVar.i0) == null) {
                return;
            }
            if (this.f41870e) {
                if (dVar.m0 == null) {
                    dVar.m0 = new TextView(d.this.f0);
                }
                if (d.this.m0.getParent() instanceof SwanAppActionBar) {
                    return;
                }
                d.this.m0.setText(d.a.i0.a.h.aiapps_debug_open_cts);
                d dVar2 = d.this;
                dVar2.m0.setTextColor(dVar2.G1().getColor(17170455));
                d dVar3 = d.this;
                dVar3.i0.addView(dVar3.m0);
                return;
            }
            TextView textView = dVar.m0;
            if (textView != null) {
                swanAppActionBar.removeView(textView);
                d.this.m0 = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.d2();
        }
    }

    /* loaded from: classes2.dex */
    public class l {

        /* renamed from: a  reason: collision with root package name */
        public int f41873a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f41874b = 0;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f41875c;

        public l(Runnable runnable) {
            this.f41875c = runnable;
        }

        public void a() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f41874b > 1333) {
                this.f41874b = currentTimeMillis;
                this.f41873a = 1;
                return;
            }
            int i2 = this.f41873a + 1;
            this.f41873a = i2;
            if (i2 == 3) {
                Runnable runnable = this.f41875c;
                if (runnable != null) {
                    runnable.run();
                }
                this.f41873a = 0;
                this.f41874b = 0L;
                return;
            }
            this.f41874b = currentTimeMillis;
        }
    }

    /* loaded from: classes2.dex */
    public interface m {
        void a();
    }

    public View A1(View view, SlideInterceptor slideInterceptor) {
        SlideHelper slideHelper = new SlideHelper();
        this.p0 = slideHelper;
        View wrapSlideView = slideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.p0.setFadeColor(0);
        q2();
        A2();
        return wrapSlideView;
    }

    public final void A2() {
        this.p0.setSlideListener(new b());
    }

    public void B1() {
        d.a.i0.a.h0.g.g J1 = J1();
        if (J1 != null && J1.k() != 1) {
            g.b i2 = J1.i("navigateBack");
            i2.n(0, 0);
            i2.g();
            i2.a();
            d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
            eVar.f43015e = com.alipay.sdk.widget.j.j;
            eVar.f43017g = V1() ? "1" : "0";
            eVar.f43012b = "gesture";
            d.a.i0.a.j2.d.a(eVar, d.a.i0.a.a2.d.g().r().L());
            d.a.i0.a.j2.d.c(eVar);
            return;
        }
        Activity activity = this.f0;
        if (activity != null) {
            activity.moveTaskToBack(true);
            x0.b().e(1);
        }
    }

    public boolean B2(FrameLayout frameLayout, int i2) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i2);
        d.a.i0.a.a2.n.g D1 = D1();
        if (D1 != null) {
            D1.f40622e = i2;
            return true;
        }
        return true;
    }

    public final c.b C1() {
        return new g();
    }

    public void C2() {
    }

    public d.a.i0.a.a2.n.g D1() {
        return null;
    }

    public boolean D2() {
        SwanAppActionBar swanAppActionBar = this.i0;
        if (swanAppActionBar == null) {
            return false;
        }
        swanAppActionBar.g(true);
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void E0() {
        if (w0) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.f0 = null;
        N1(false);
        super.E0();
        try {
            Field declaredField = Fragment.class.getDeclaredField("y");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int E1() {
        if (TextUtils.isEmpty(d.a.i0.a.a2.e.V())) {
            return 0;
        }
        return d.a.i0.a.j0.b.a.n(d.a.i0.a.a2.e.V()) ? 2 : 1;
    }

    public final void E2(boolean z, float f2) {
        d.a.i0.a.h0.g.g J1 = J1();
        if (J1 == null || J1.k() < 2) {
            return;
        }
        d j2 = J1.j(J1.k() - 2);
        b2(f2, j2);
        if (z) {
            J1.h().o(j2);
        } else {
            J1.h().c(j2);
        }
    }

    @Nullable
    public d.a.i0.a.w2.d.b F1() {
        return this.n0;
    }

    public void F2(d.a.i0.a.h0.g.l.a aVar) {
        this.v0.d(aVar);
    }

    public final Resources G1() {
        if (n0()) {
            return z();
        }
        return AppRuntime.getAppContext().getResources();
    }

    public void G2() {
        d.a.i0.a.r1.k.i.b.e().f(new i(), "updateCtsView");
    }

    public SwanAppActionBar H1() {
        return this.i0;
    }

    public View I1() {
        return this.h0;
    }

    public final d.a.i0.a.h0.g.g J1() {
        Activity activity = this.f0;
        if (activity == null) {
            return null;
        }
        return ((SwanAppActivity) activity).getSwanAppFragmentManager();
    }

    public abstract boolean K();

    public d.a.i0.a.l1.c K1() {
        return this.g0;
    }

    public void L1() {
        d.a.i0.a.c2.f.p0.a.f("backtohome", SupportMenuInflater.XML_MENU, d.a.i0.a.g1.f.V().f());
        d.a.i0.a.j2.p.f fVar = new d.a.i0.a.j2.p.f();
        fVar.f43015e = "gohome";
        fVar.f43013c = SupportMenuInflater.XML_MENU;
        y1(fVar);
    }

    public void M1(boolean z) {
        FloatButton c2 = d.a.i0.a.c2.f.i0.a.d().c();
        if (!z) {
            if (c2 == null || c2.getVisibility() != 0) {
                return;
            }
            c2.setVisibility(8);
        } else if (c2 == null || c2.getVisibility() == 0) {
        } else {
            c2.setVisibility(0);
        }
    }

    public void N1(boolean z) {
        d j2;
        d.a.i0.a.h0.g.g W = d.a.i0.a.g1.f.V().W();
        if (W != null) {
            if (z) {
                j2 = W.m();
            } else {
                j2 = W.j(W.k() - 1);
            }
            if (j2 == null) {
                return;
            }
            M1(j2.X1());
        }
    }

    public boolean O1() {
        SwanAppActionBar swanAppActionBar = this.i0;
        if (swanAppActionBar == null) {
            return false;
        }
        swanAppActionBar.g(false);
        return true;
    }

    public boolean P1() {
        return this.o0;
    }

    public void Q1(View view) {
        d.a.i0.a.a2.n.g e2;
        R1(view);
        SwanAppConfigData s = d.a.i0.a.g1.f.V().s();
        if (s == null) {
            if (w0) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        d.a.i0.a.l1.c cVar = this.g0;
        if (cVar == null) {
            e2 = s.f11348e;
        } else {
            e2 = d.a.i0.a.g1.f.V().e(d.a.i0.a.c2.f.p0.j.c(cVar.g(), s));
        }
        l2(e2.f40618a);
        this.i0.setTitle(e2.f40619b);
        this.s0 = new l(new c());
        if (!(this instanceof SwanAppAdLandingFragment)) {
            t2(SwanAppConfigData.s(e2.f40620c));
        }
        String str = e2.f40620c;
    }

    public void R1(View view) {
        if (view == null) {
            return;
        }
        this.i0 = (SwanAppActionBar) view.findViewById(d.a.i0.a.f.ai_apps_title_bar);
        this.h0 = view.findViewById(d.a.i0.a.f.ai_apps_title_bar_root);
        this.l0 = view.findViewById(d.a.i0.a.f.title_shadow);
        this.i0.setLeftBackViewMinWidth(n0.f(this.f0, 38.0f));
        View$OnClickListenerC0648d view$OnClickListenerC0648d = new View$OnClickListenerC0648d();
        this.i0.setLeftBackViewClickListener(view$OnClickListenerC0648d);
        this.i0.setLeftFloatBackViewClickListener(view$OnClickListenerC0648d);
        this.i0.setRightMenuOnClickListener(new e());
        this.i0.setRightExitOnClickListener(new f());
    }

    public View S1(View view) {
        if (view == null) {
            return null;
        }
        if ("IMMERSION_LAYOUT_TAG".equals(view.getTag())) {
            return view;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            if ("IMMERSION_LAYOUT_TAG".equals(viewGroup.getTag())) {
                return viewGroup;
            }
            viewGroup.removeView(view);
        }
        FrameLayout frameLayout = new FrameLayout(q());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        T1(frameLayout, view);
        return frameLayout;
    }

    public View T1(FrameLayout frameLayout, View view) {
        frameLayout.setTag("IMMERSION_LAYOUT_TAG");
        frameLayout.addView(view);
        this.n0 = new d.a.i0.a.w2.d.b(this.f0, frameLayout);
        t1();
        return frameLayout;
    }

    public boolean U1() {
        Activity activity = this.f0;
        return (activity instanceof SwanAppActivity) && ((SwanAppActivity) activity).getFrameType() == 1;
    }

    public final boolean V1() {
        d.a.i0.a.h0.g.g J1 = J1();
        return J1 != null && J1.k() > 1;
    }

    public boolean W1() {
        return this.r0 == -1;
    }

    public abstract boolean X1();

    public boolean Y1() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(d.a.i0.a.a2.e.V());
    }

    public abstract boolean Z1();

    public void a2() {
        this.i0.setLeftHomeViewVisibility(0);
        this.i0.setLeftHomeViewClickListener(new k());
    }

    public final void b2(float f2, Fragment fragment) {
        View b0;
        float o = n0.o(this.f0) >> 2;
        float f3 = (f2 * o) - o;
        if (fragment == null || (b0 = fragment.b0()) == null) {
            return;
        }
        b0.setX(f3);
    }

    public void c2() {
        Activity activity = this.f0;
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).onBackPressed(2);
        } else if (activity != null) {
            activity.onBackPressed();
        }
    }

    public void d2() {
    }

    public abstract void e2();

    public void f2() {
        E2(false, 1.0f);
    }

    public void g2(float f2) {
        E2(true, f2);
    }

    public void h2(d.a.i0.a.h0.g.l.a aVar) {
        this.v0.c(aVar);
    }

    public void i2() {
        d.a.i0.a.w2.d.b bVar;
        if (!P1() || (bVar = this.n0) == null) {
            return;
        }
        bVar.l();
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public final void j2() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.i0.a.a2.e.V());
        d.a.i0.a.g1.f.V().v(new d.a.i0.a.o0.d.c(hashMap));
        d.a.i0.a.e0.d.g("SwanAppBaseFragment", "onClose");
        d.a.i0.a.j2.p.f fVar = new d.a.i0.a.j2.p.f();
        fVar.f43015e = IntentConfig.CLOSE;
        y1(fVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void k2(int i2, String str) {
        char c2;
        TimeInterpolator linearInterpolator;
        switch (str.hashCode()) {
            case -1965087616:
                if (str.equals("easeOut")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1310316109:
                if (str.equals("easeIn")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1330629787:
                if (str.equals("easeInOut")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            linearInterpolator = new LinearInterpolator();
        } else if (c2 == 1) {
            linearInterpolator = new AccelerateInterpolator();
        } else if (c2 == 2) {
            linearInterpolator = new DecelerateInterpolator();
        } else if (c2 != 3) {
            linearInterpolator = new LinearInterpolator();
        } else {
            linearInterpolator = new AccelerateDecelerateInterpolator();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.i0, "alpha", 0.0f, 1.0f);
        long j2 = i2;
        ofFloat.setDuration(j2);
        ofFloat.setInterpolator(linearInterpolator);
        ofFloat.start();
        d.a.i0.a.w2.d.b bVar = this.n0;
        if (bVar == null || bVar.e() == null) {
            return;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.n0.e(), "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(j2);
        ofFloat2.setInterpolator(linearInterpolator);
        ofFloat2.start();
    }

    public boolean l2(int i2) {
        return m2(i2, false);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void m1(boolean z) {
        super.m1(z);
        if (z) {
            i2();
        }
    }

    public boolean m2(int i2, boolean z) {
        SwanAppActionBar swanAppActionBar = this.i0;
        if (swanAppActionBar == null || this.l0 == null) {
            return false;
        }
        this.r0 = i2;
        swanAppActionBar.setBackgroundColor(i2);
        d.a.i0.a.a2.n.g D1 = D1();
        if (D1 != null) {
            D1.f40618a = i2;
            D1.g(z);
        }
        if (P1()) {
            t1();
        }
        if (W1()) {
            this.l0.setVisibility(0);
            return true;
        }
        this.l0.setVisibility(8);
        return true;
    }

    @Nullable
    public boolean n2(String str) {
        return o2(str, false);
    }

    public boolean o2(String str, boolean z) {
        SwanAppActionBar swanAppActionBar = this.i0;
        if (swanAppActionBar == null) {
            return false;
        }
        swanAppActionBar.setTitle(str);
        d.a.i0.a.a2.n.g D1 = D1();
        if (D1 != null) {
            D1.f40619b = str;
            D1.g(z);
        }
        d.a.i0.a.e0.d.g("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n0.c(this.f0);
        if (P1() && this.n0 != null && configuration.orientation == 1) {
            h().getWindow().clearFlags(1024);
            q0.c0(new h(), 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        this.v0.b();
        super.onPause();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.v0.a();
        if (w0) {
            Log.d("SwanAppBaseFragment", MissionEvent.MESSAGE_RESUME);
        }
        if (W()) {
            i2();
        }
        G2();
    }

    public void p2(boolean z) {
        this.i0.setLeftBackViewVisibility(z);
    }

    public final void q2() {
        d.a.i0.a.a2.n.g D1 = D1();
        if (D1 != null && (D1.l || D1.m)) {
            d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
            if (Q != null) {
                Q.T().g(Q.x(), "scope_disable_swipe_back", new a());
                return;
            } else {
                this.p0.setCanSlide(w1());
                return;
            }
        }
        this.p0.setCanSlide(w1());
    }

    public void r2(boolean z) {
        this.u0 = z;
    }

    public void s2(boolean z, boolean z2) {
        SwanAppActionBar swanAppActionBar = this.i0;
        if (swanAppActionBar != null) {
            swanAppActionBar.setActionBarCustom(z, z2);
        }
        if (this.l0 != null) {
            int i2 = 8;
            if (!z && W1()) {
                i2 = 0;
            }
            this.l0.setVisibility(i2);
        }
    }

    public void t1() {
        if (this.n0 == null) {
            return;
        }
        u1(this.r0);
    }

    public boolean t2(int i2) {
        return u2(i2, "", false);
    }

    public void u1(@ColorInt int i2) {
        if (this.n0 == null) {
            return;
        }
        v1(i2, false);
    }

    public boolean u2(@ColorInt int i2, String str, boolean z) {
        if (this.i0 == null) {
            return false;
        }
        y2(!this.u0);
        d.a.i0.a.a2.n.g D1 = D1();
        if (D1 != null) {
            if (!TextUtils.isEmpty(str)) {
                D1.f40620c = str;
            }
            D1.g(z);
        }
        int i3 = i2 != -16777216 ? -1 : -16777216;
        if (P1() && i3 != this.q0) {
            this.q0 = i3;
            t1();
        }
        return this.i0.f(i2, this.u0);
    }

    public void v1(@ColorInt int i2, boolean z) {
        if (this.n0 == null) {
            return;
        }
        this.r0 = i2;
        int i3 = this.q0;
        boolean z2 = true;
        if (i3 == 1) {
            z2 = d.a.i0.a.v2.i.a(i2);
        } else if (i3 != -16777216) {
            z2 = false;
        }
        this.n0.m(i2, z, z2);
    }

    public boolean v2(String str, boolean z) {
        return u2(SwanAppConfigData.s(str), str, z);
    }

    public final boolean w1() {
        return (G1().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    public void w2(m mVar) {
        this.t0 = mVar;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void x0(Context context) {
        if (w0) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        this.v0 = new d.a.i0.a.h0.g.l.c();
        super.x0(context);
        this.f0 = h();
        N1(true);
    }

    public final void x1() {
        if (this.f0 != null) {
            d.a.i0.a.g1.g.a().d(false);
            this.f0.moveTaskToBack(true);
            j2();
            ((SwanAppActivity) this.f0).handleSwanAppExit(1);
            x0.b().e(2);
        }
    }

    public void x2(int i2) {
        Activity activity = this.f0;
        if (activity != null) {
            activity.setRequestedOrientation(i2);
        }
    }

    public final void y1(d.a.i0.a.j2.p.f fVar) {
        Activity activity = this.f0;
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).doUBCEventStatistic(fVar);
        }
    }

    public void y2(boolean z) {
        this.i0.setRightExitViewVisibility(z);
    }

    public final void z1(boolean z) {
        q0.b0(new j(z));
    }

    public void z2(boolean z) {
        this.i0.setRightZoneVisibility(z);
    }
}
