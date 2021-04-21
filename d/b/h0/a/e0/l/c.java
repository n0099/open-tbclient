package d.b.h0.a.e0.l;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
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
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
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
import d.b.h0.a.e0.l.f;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.p0;
import d.b.h0.a.q0.c;
import d.b.h0.a.v1.c.i.b;
import d.b.h0.i.n;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class c extends Fragment implements SlideInterceptor {
    public static final boolean x0 = d.b.h0.a.k.f45772a;
    public Activity f0;
    public d.b.h0.a.e1.c g0;
    public View h0;
    public SwanAppActionBar i0;
    public n j0;
    public SwanAppMenuHeaderView k0;
    public View l0;
    public TextView m0;
    @Nullable
    public d.b.h0.a.j2.c.b n0;
    public SlideHelper p0;
    public AudioManager s0;
    public AudioManager.OnAudioFocusChangeListener t0;
    public l u0;
    public m v0;
    public boolean o0 = d.b.h0.a.j2.c.b.i;
    public int q0 = 1;
    public int r0 = 1;
    public boolean w0 = false;

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            if (!d.b.h0.a.v1.c.c.h(hVar)) {
                c cVar = c.this;
                cVar.p0.setCanSlide(cVar.r1());
                return;
            }
            c.this.p0.setCanSlide(false);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {
        public b() {
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
            c.this.b2();
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            c.this.w1();
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            View maskView = c.this.p0.getMaskView();
            if (maskView != null) {
                maskView.setAlpha(1.0f - f2);
            }
            c.this.c2(f2);
            if (c.this.v0 != null) {
                c.this.v0.a();
            }
        }
    }

    /* renamed from: d.b.h0.a.e0.l.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0693c implements Runnable {
        public RunnableC0693c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.f1.f.d();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {

        /* loaded from: classes2.dex */
        public class a implements d.b.h0.a.e0.n.b<Boolean> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.e0.n.b
            /* renamed from: b */
            public void a(Boolean bool) {
                if (bool.booleanValue()) {
                    c.this.Y1();
                }
            }
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.b.h0.a.q0.a.b().c()) {
                d.b.h0.a.q0.a.b().f(c.this.f0, new a());
            } else {
                c.this.Y1();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a2();
            d.b.h0.a.z1.k.f fVar = new d.b.h0.a.z1.k.f();
            fVar.f47975d = SupportMenuInflater.XML_MENU;
            if (d.b.h0.a.r1.e.O() != null && d.b.h0.a.r1.e.O().H().d("key_unread_counts_message", 0).intValue() > 0) {
                fVar.f47977f = String.valueOf(1);
            }
            c.this.t1(fVar);
            if (c.this.u0 != null) {
                c.this.u0.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {

        /* loaded from: classes2.dex */
        public class a implements d.b.h0.a.e0.n.b<Boolean> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.e0.n.b
            /* renamed from: b */
            public void a(Boolean bool) {
                if (bool.booleanValue()) {
                    c.this.s1();
                }
            }
        }

        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity = c.this.f0;
            if (activity == null || !(activity instanceof SwanAppActivity)) {
                return;
            }
            if (d.b.h0.a.r1.e.y() == null || d.b.h0.a.r1.e.T() == null) {
                c.this.s1();
            } else if (d.b.h0.a.q0.a.b().c()) {
                d.b.h0.a.q0.a.b().f(c.this.f0, new a());
            } else if (d.b.h0.a.q0.c.c().h()) {
                c.this.s1();
            } else {
                d.b.h0.a.q0.b bVar = new d.b.h0.a.q0.b();
                bVar.i();
                if (!bVar.j()) {
                    c.this.s1();
                    return;
                }
                String g2 = bVar.g();
                String f2 = bVar.f();
                d.b.h0.a.q0.c c2 = d.b.h0.a.q0.c.c();
                c cVar = c.this;
                c2.j(cVar.f0, g2, f2, cVar.x1());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements c.b {
        public g() {
        }

        @Override // d.b.h0.a.q0.c.b
        public void a() {
            c.this.s1();
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d2();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.u1(d.b.h0.a.m1.a.a.A());
        }
    }

    /* loaded from: classes2.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44707e;

        public j(boolean z) {
            this.f44707e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActionBar swanAppActionBar;
            c cVar = c.this;
            if (cVar.f0 == null || (swanAppActionBar = cVar.i0) == null) {
                return;
            }
            if (this.f44707e) {
                if (cVar.m0 == null) {
                    cVar.m0 = new TextView(c.this.f0);
                }
                if (c.this.m0.getParent() instanceof SwanAppActionBar) {
                    return;
                }
                c.this.m0.setText(d.b.h0.a.h.aiapps_debug_open_cts);
                c cVar2 = c.this;
                cVar2.m0.setTextColor(cVar2.C1().getColor(17170455));
                c cVar3 = c.this;
                cVar3.i0.addView(cVar3.m0);
                return;
            }
            TextView textView = cVar.m0;
            if (textView != null) {
                swanAppActionBar.removeView(textView);
                c.this.m0 = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.Z1();
        }
    }

    /* loaded from: classes2.dex */
    public class l {

        /* renamed from: a  reason: collision with root package name */
        public int f44710a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f44711b = 0;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f44712c;

        public l(Runnable runnable) {
            this.f44712c = runnable;
        }

        public void a() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f44711b > 1333) {
                this.f44711b = currentTimeMillis;
                this.f44710a = 1;
                return;
            }
            int i = this.f44710a + 1;
            this.f44710a = i;
            if (i == 3) {
                Runnable runnable = this.f44712c;
                if (runnable != null) {
                    runnable.run();
                }
                this.f44710a = 0;
                this.f44711b = 0L;
                return;
            }
            this.f44711b = currentTimeMillis;
        }
    }

    /* loaded from: classes2.dex */
    public interface m {
        void a();
    }

    public int A1() {
        Activity activity = this.f0;
        if (activity instanceof SwanAppActivity) {
            return ((SwanAppActivity) activity).getFrameType();
        }
        return -1;
    }

    public void A2() {
        ExecutorUtilsExt.postOnElastic(new i(), "updateCtsView", 2);
    }

    @Nullable
    public d.b.h0.a.j2.c.b B1() {
        return this.n0;
    }

    public final Resources C1() {
        if (i0()) {
            return u();
        }
        return AppRuntime.getAppContext().getResources();
    }

    public SwanAppActionBar D1() {
        return this.i0;
    }

    public View E1() {
        return this.h0;
    }

    public final d.b.h0.a.e0.l.f F1() {
        Activity activity = this.f0;
        if (activity == null) {
            return null;
        }
        return ((SwanAppActivity) activity).getSwanAppFragmentManager();
    }

    public d.b.h0.a.e1.c G1() {
        return this.g0;
    }

    public void H1() {
        d.b.h0.a.t1.k.p0.a.e("backtohome", SupportMenuInflater.XML_MENU, d.b.h0.a.z0.f.V().l());
        d.b.h0.a.z1.k.f fVar = new d.b.h0.a.z1.k.f();
        fVar.f47975d = "gohome";
        fVar.f47974c = SupportMenuInflater.XML_MENU;
        t1(fVar);
    }

    public void I1(boolean z) {
        FloatButton c2 = d.b.h0.a.t1.k.i0.a.d().c();
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

    public void J1(boolean z) {
        c j2;
        d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
        if (W != null) {
            if (z) {
                j2 = W.m();
            } else {
                j2 = W.j(W.k() - 1);
            }
            if (j2 == null) {
                return;
            }
            I1(j2.T1());
        }
    }

    public boolean K1() {
        SwanAppActionBar swanAppActionBar = this.i0;
        if (swanAppActionBar == null) {
            return false;
        }
        swanAppActionBar.g(false);
        return true;
    }

    public boolean L1() {
        return this.o0;
    }

    public void M1(View view) {
        d.b.h0.a.r1.n.c k2;
        N1(view);
        SwanAppConfigData I = d.b.h0.a.z0.f.V().I();
        if (I == null) {
            if (x0) {
                Log.d("SwanAppBaseFragment", "config data is null. " + Log.getStackTraceString(new Exception()));
                return;
            }
            return;
        }
        d.b.h0.a.e1.c cVar = this.g0;
        if (cVar == null) {
            k2 = I.f12285d;
        } else {
            k2 = d.b.h0.a.z0.f.V().k(d.b.h0.a.t1.k.p0.j.c(cVar.g(), I));
        }
        g2(k2.f46492a);
        this.i0.setTitle(k2.f46493b);
        this.u0 = new l(new RunnableC0693c());
        if (!(this instanceof SwanAppAdLandingFragment)) {
            o2(SwanAppConfigData.s(k2.f46494c));
        }
        String str = k2.f46494c;
    }

    public void N1(View view) {
        if (view == null) {
            return;
        }
        this.i0 = (SwanAppActionBar) view.findViewById(d.b.h0.a.f.ai_apps_title_bar);
        this.h0 = view.findViewById(d.b.h0.a.f.ai_apps_title_bar_root);
        this.l0 = view.findViewById(d.b.h0.a.f.title_shadow);
        this.i0.setLeftBackViewMinWidth(h0.e(this.f0, 38.0f));
        this.i0.setLeftBackViewClickListener(new d());
        this.i0.setRightMenuOnClickListener(new e());
        this.i0.setRightExitOnClickListener(new f());
    }

    public View O1(View view) {
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
        FrameLayout frameLayout = new FrameLayout(l());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        P1(frameLayout, view);
        return frameLayout;
    }

    public View P1(FrameLayout frameLayout, View view) {
        frameLayout.setTag("IMMERSION_LAYOUT_TAG");
        frameLayout.addView(view);
        this.n0 = new d.b.h0.a.j2.c.b(this.f0, frameLayout);
        o1();
        return frameLayout;
    }

    public boolean Q1() {
        Activity activity = this.f0;
        return (activity instanceof SwanAppActivity) && ((SwanAppActivity) activity).getFrameType() == 1;
    }

    public final boolean R1() {
        d.b.h0.a.e0.l.f F1 = F1();
        return F1 != null && F1.k() > 1;
    }

    public boolean S1() {
        return this.r0 == -1;
    }

    public abstract boolean T1();

    public boolean U1() {
        return "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(d.b.h0.a.r1.e.T());
    }

    public abstract boolean V1();

    public void W1() {
        this.i0.setLeftHomeViewVisibility(0);
        this.i0.setLeftHomeViewClickListener(new k());
    }

    public final void X1(float f2, Fragment fragment) {
        View W;
        float m2 = h0.m(this.f0) >> 2;
        float f3 = (f2 * m2) - m2;
        if (fragment == null || (W = fragment.W()) == null) {
            return;
        }
        W.setX(f3);
    }

    public void Y1() {
        Activity activity = this.f0;
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public void Z1() {
    }

    public abstract void a2();

    public void b2() {
        z2(false, 1.0f);
    }

    public void c2(float f2) {
        z2(true, f2);
    }

    public void d2() {
        d.b.h0.a.j2.c.b bVar;
        if (!L1() || (bVar = this.n0) == null) {
            return;
        }
        bVar.l();
    }

    public final void e2() {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", "onClose");
        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.b.h0.a.r1.e.T());
        d.b.h0.a.z0.f.V().N(new d.b.h0.a.k0.b.c(hashMap));
        d.b.h0.a.c0.c.g("SwanAppBaseFragment", "onClose");
        d.b.h0.a.z1.k.f fVar = new d.b.h0.a.z1.k.f();
        fVar.f47975d = IntentConfig.CLOSE;
        t1(fVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void f2(int i2, String str) {
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
        d.b.h0.a.j2.c.b bVar = this.n0;
        if (bVar == null || bVar.e() == null) {
            return;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.n0.e(), "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(j2);
        ofFloat2.setInterpolator(linearInterpolator);
        ofFloat2.start();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void g1(boolean z) {
        super.g1(z);
        if (z) {
            d2();
        }
    }

    public boolean g2(int i2) {
        return h2(i2, false);
    }

    public void h1() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
        AudioManager audioManager = this.s0;
        if (audioManager == null || (onAudioFocusChangeListener = this.t0) == null) {
            return;
        }
        audioManager.abandonAudioFocus(onAudioFocusChangeListener);
    }

    public boolean h2(int i2, boolean z) {
        SwanAppActionBar swanAppActionBar = this.i0;
        if (swanAppActionBar == null || this.l0 == null) {
            return false;
        }
        this.r0 = i2;
        swanAppActionBar.setBackgroundColor(i2);
        d.b.h0.a.r1.n.c y1 = y1();
        if (y1 != null) {
            y1.f46492a = i2;
            y1.g(z);
        }
        if (L1()) {
            o1();
        }
        if (S1()) {
            this.l0.setVisibility(0);
            return true;
        }
        this.l0.setVisibility(8);
        return true;
    }

    @Nullable
    public boolean i2(String str) {
        return j2(str, false);
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        return true;
    }

    public boolean j2(String str, boolean z) {
        SwanAppActionBar swanAppActionBar = this.i0;
        if (swanAppActionBar == null) {
            return false;
        }
        swanAppActionBar.setTitle(str);
        d.b.h0.a.r1.n.c y1 = y1();
        if (y1 != null) {
            y1.f46493b = str;
            y1.g(z);
        }
        d.b.h0.a.c0.c.g("SwanAppBaseFragment", "page title: " + str);
        return true;
    }

    public void k2(boolean z) {
        this.i0.setLeftBackViewVisibility(z);
    }

    public final void l2() {
        if (y1() != null && y1().l) {
            d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
            if (O != null) {
                O.R().g(O.n(), "scope_disable_swipe_back", new a());
                return;
            } else {
                this.p0.setCanSlide(r1());
                return;
            }
        }
        this.p0.setCanSlide(r1());
    }

    public void m2(boolean z) {
        this.w0 = z;
    }

    public void n2(boolean z) {
        SwanAppActionBar swanAppActionBar = this.i0;
        if (swanAppActionBar != null) {
            swanAppActionBar.setActionBarCustom(z);
        }
        if (this.l0 != null) {
            int i2 = 8;
            if (!z && S1()) {
                i2 = 0;
            }
            this.l0.setVisibility(i2);
        }
    }

    public void o1() {
        if (this.n0 == null) {
            return;
        }
        p1(this.r0);
    }

    public boolean o2(int i2) {
        return p2(i2, "", false);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (L1() && this.n0 != null && configuration.orientation == 1) {
            f().getWindow().clearFlags(1024);
            k0.Y(new h(), 200L);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (x0) {
            Log.d("SwanAppBaseFragment", MissionEvent.MESSAGE_RESUME);
        }
        if (T()) {
            d2();
        }
        A2();
    }

    public void p1(@ColorInt int i2) {
        if (this.n0 == null) {
            return;
        }
        q1(i2, false);
    }

    public boolean p2(@ColorInt int i2, String str, boolean z) {
        if (this.i0 == null) {
            return false;
        }
        t2(!this.w0);
        d.b.h0.a.r1.n.c y1 = y1();
        if (y1 != null) {
            if (!TextUtils.isEmpty(str)) {
                y1.f46494c = str;
            }
            y1.g(z);
        }
        int i3 = i2 != -16777216 ? -1 : -16777216;
        if (L1() && i3 != this.q0) {
            this.q0 = i3;
            o1();
        }
        return this.i0.f(i2, this.w0);
    }

    public void q1(@ColorInt int i2, boolean z) {
        if (this.n0 == null) {
            return;
        }
        this.r0 = i2;
        int i3 = this.q0;
        boolean z2 = true;
        if (i3 == 1) {
            z2 = d.b.h0.a.i2.h.a(i2);
        } else if (i3 != -16777216) {
            z2 = false;
        }
        this.n0.m(i2, z, z2);
    }

    public boolean q2(String str, boolean z) {
        return p2(SwanAppConfigData.s(str), str, z);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(Context context) {
        if (x0) {
            Log.d("SwanAppBaseFragment", "onAttach");
        }
        super.r0(context);
        this.f0 = f();
        J1(true);
    }

    public final boolean r1() {
        return (C1().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    public void r2(m mVar) {
        this.v0 = mVar;
    }

    public final void s1() {
        if (this.f0 != null) {
            d.b.h0.a.z0.g.a().d(false);
            this.f0.moveTaskToBack(true);
            e2();
            ((SwanAppActivity) this.f0).handleSwanAppExit(1);
            p0.b().e(2);
        }
    }

    public void s2(int i2) {
        Activity activity = this.f0;
        if (activity != null) {
            activity.setRequestedOrientation(i2);
        }
    }

    public final void t1(d.b.h0.a.z1.k.f fVar) {
        Activity activity = this.f0;
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).doUBCEventStatistic(fVar);
        }
    }

    public void t2(boolean z) {
        this.i0.setRightExitViewVisibility(z);
    }

    public final void u1(boolean z) {
        k0.X(new j(z));
    }

    public void u2(boolean z) {
        this.i0.setRightZoneVisibility(z);
    }

    public abstract boolean v();

    public View v1(View view, SlideInterceptor slideInterceptor) {
        SlideHelper slideHelper = new SlideHelper();
        this.p0 = slideHelper;
        View wrapSlideView = slideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
        this.p0.setFadeColor(0);
        l2();
        v2();
        return wrapSlideView;
    }

    public final void v2() {
        this.p0.setSlideListener(new b());
    }

    public void w1() {
        d.b.h0.a.e0.l.f F1 = F1();
        if (F1 != null && F1.k() != 1) {
            f.b i2 = F1.i("navigateBack");
            i2.n(0, 0);
            i2.g();
            i2.a();
            d.b.h0.a.z1.k.f fVar = new d.b.h0.a.z1.k.f();
            fVar.f47975d = com.alipay.sdk.widget.j.j;
            t1(fVar);
            return;
        }
        Activity activity = this.f0;
        if (activity != null) {
            activity.moveTaskToBack(true);
            p0.b().e(1);
        }
    }

    public boolean w2(FrameLayout frameLayout, int i2) {
        if (frameLayout == null) {
            return false;
        }
        frameLayout.setBackgroundColor(i2);
        d.b.h0.a.r1.n.c y1 = y1();
        if (y1 != null) {
            y1.f46496e = i2;
            return true;
        }
        return true;
    }

    public final c.b x1() {
        return new g();
    }

    public void x2() {
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        if (x0) {
            Log.d("SwanAppBaseFragment", "onDetach");
        }
        this.f0 = null;
        J1(false);
        super.y0();
        try {
            Field declaredField = Fragment.class.getDeclaredField("y");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public d.b.h0.a.r1.n.c y1() {
        return null;
    }

    public boolean y2() {
        SwanAppActionBar swanAppActionBar = this.i0;
        if (swanAppActionBar == null) {
            return false;
        }
        swanAppActionBar.g(true);
        return true;
    }

    public int z1() {
        if (TextUtils.isEmpty(d.b.h0.a.r1.e.T())) {
            return 0;
        }
        return d.b.h0.a.g0.c.a.n(d.b.h0.a.r1.e.T()) ? 2 : 1;
    }

    public final void z2(boolean z, float f2) {
        d.b.h0.a.e0.l.f F1 = F1();
        if (F1 == null || F1.k() < 2) {
            return;
        }
        c j2 = F1.j(F1.k() - 2);
        X1(f2, j2);
        if (z) {
            F1.h().o(j2);
        } else {
            F1.h().c(j2);
        }
    }
}
