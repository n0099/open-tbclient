package d.b.g0.a.j2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.games.loading.SwanLoadingTips;
import com.baidu.swan.games.loading.SwanLoadingTipsView;
import com.baidu.swan.pms.PMSConstants$PayProtected;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p0;
import d.b.g0.a.i2.s;
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import d.b.g0.a.r1.i;
import d.b.g0.a.y0.e.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes3.dex */
public class d {
    public static final boolean A = k.f45443a;
    public static View B;
    public static View C;

    /* renamed from: a  reason: collision with root package name */
    public View f45380a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f45381b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppRoundedImageView f45382c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f45383d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f45384e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f45385f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f45386g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f45387h;
    public BdBaseImageView i;
    public TextView j;
    public View k;
    public d.b.g0.a.s.a l;
    public SwanAppActivity m;
    public View n;
    public SwanLoadingTipsView o;
    public SwanLoadingTips p;
    public TextView q;
    public ValueAnimator r;
    public boolean s = false;
    public float t = 0.0f;
    public float u = 0.0f;
    public float v = 0.0f;
    public long w = 0;
    public h x = null;
    public String y = "";
    public boolean z;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45388e;

        public a(Context context) {
            this.f45388e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.u(this.f45388e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Function0<Unit> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            d.this.z();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            d.this.z();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: d.b.g0.a.j2.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0724d implements View.OnClickListener {
        public View$OnClickListenerC0724d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.m == null || d.this.m.isFinishing()) {
                return;
            }
            HybridUbcFlow l = i.l();
            if (l != null) {
                l.y("exitType", String.valueOf(3));
                l.z("value", QueryResponse.Options.CANCEL);
                l.k();
            }
            d.this.m.moveTaskToBack(true);
            p0.b().e(2);
            d.this.n();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45392e;

        public e(int i) {
            this.f45392e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.class) {
                i.n().A(new UbcFlowEvent("first_anim_end"));
                d.b.g0.a.y1.a.d().i("first_anim_end");
                if (d.this.l != null) {
                    d.this.l.g(d.this.m, this.f45392e);
                }
                d.this.s = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue > 0.9f || floatValue - d.this.u > 0.05d) {
                d.this.u = floatValue;
                d.this.H();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements s.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45395a;

        public g(d dVar, String str) {
            this.f45395a = str;
        }

        @Override // d.b.g0.a.i2.s.b
        public void a(String str, Bitmap bitmap) {
            SwanAppActivity n;
            d loadingView;
            if (bitmap == null || (n = d.b.g0.a.r1.d.e().n()) == null || n.isDestroyed() || (loadingView = n.getLoadingView()) == null || !TextUtils.equals(this.f45395a, d.b.g0.a.r1.d.e().getAppId())) {
                return;
            }
            loadingView.F(bitmap);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final boolean f45396e;

        /* renamed from: f  reason: collision with root package name */
        public final String f45397f;
        public final d.b.g0.a.r1.b i;
        public int k;
        public boolean l;

        /* renamed from: g  reason: collision with root package name */
        public boolean f45398g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f45399h = false;
        public int j = -1;

        /* loaded from: classes3.dex */
        public class a implements d.b.g0.a.i2.u0.b<i.a> {
            public a(d dVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (d.A) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_FINISH");
                }
                h.this.k = aVar.h("KEY_PRELOAD_STATE");
                h.this.e();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements d.b.g0.a.i2.u0.b<i.a> {
            public b(h hVar, d dVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (d.A) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_ERROR");
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements d.b.g0.a.i2.u0.b<i.a> {
            public c(h hVar, d dVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (d.A) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_START");
                }
            }
        }

        /* renamed from: d.b.g0.a.j2.d$h$d  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0725d implements d.b.g0.a.i2.u0.b<i.a> {
            public C0725d(d dVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (d.A) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_FINISH");
                }
                h.this.l = true;
                h.this.e();
            }
        }

        /* loaded from: classes3.dex */
        public class e implements d.b.g0.a.i2.u0.b<i.a> {
            public e(h hVar, d dVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (d.A) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_START");
                }
            }
        }

        /* loaded from: classes3.dex */
        public class f implements d.b.g0.a.i2.u0.b<i.a> {
            public f(d dVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (d.A) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                }
                h.this.j = aVar.i("KEY_PKG_STATE", -1);
                h.this.e();
            }
        }

        /* loaded from: classes3.dex */
        public class g implements d.b.g0.a.i2.u0.b<i.a> {
            public g(d dVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (d.A) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                }
                h.this.j = aVar.i("KEY_PKG_STATE", -1);
                h.this.e();
            }
        }

        public h(String str, boolean z) {
            this.f45397f = str;
            this.f45396e = z;
            d.b.g0.a.r1.b bVar = new d.b.g0.a.r1.b();
            bVar.e(new g(d.this), "event_pms_check_start");
            bVar.e(new f(d.this), "event_pms_check_finish");
            bVar.e(new e(this, d.this), "event_pkg_download_start");
            bVar.e(new C0725d(d.this), "event_pkg_download_finish");
            bVar.e(new c(this, d.this), "event_preload_start");
            bVar.e(new b(this, d.this), "event_preload_error");
            bVar.e(new a(d.this), "event_preload_finish");
            this.i = bVar;
            d.b.g0.a.r1.d.e().i(this.i);
        }

        public void e() {
            boolean j = j();
            boolean g2 = g();
            boolean i = i();
            if (d.A) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + j);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + g2);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + i);
            }
            if (j || g2 || !i) {
                d.this.H();
            }
        }

        public void f(boolean z) {
            if (d.A) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewStarter exec : post = ");
                sb.append(z);
                sb.append(" trace = ");
                sb.append(z ? "post" : Log.getStackTraceString(new Exception()));
                Log.i("SwanAppLoadingView", sb.toString());
            }
            this.f45399h = true;
            d.this.t(this.f45396e, this.f45398g);
        }

        public boolean g() {
            boolean h2 = h();
            boolean i = i();
            boolean z = h2 && i;
            if (d.A) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + h2);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + i);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        public boolean h() {
            int i = this.j;
            boolean z = true;
            if (i != 3 && i != 1) {
                z = false;
            }
            if (d.A) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        public boolean i() {
            boolean a0 = d.b.g0.a.e0.w.d.L().a0();
            if (d.A) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + a0);
            }
            return a0;
        }

        public boolean j() {
            boolean z = this.j == 4;
            boolean i = i();
            if (d.A) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + i);
            }
            return z && !i;
        }

        public void k() {
            if (d.A) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            d.b.g0.a.r1.d.e().p(this.i);
        }

        public h l() {
            this.f45398g = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            f(true);
        }
    }

    public d(SwanAppActivity swanAppActivity) {
        this.z = d.b.g0.a.r1.d.e().h() != 1;
        this.m = swanAppActivity;
    }

    public static View m(Context context, boolean z) {
        try {
            return LayoutInflater.from(context).inflate(z ? d.b.g0.a.g.ai_games_loading_fragment : d.b.g0.a.g.aiapps_loading_fragment, (ViewGroup) null);
        } catch (Exception e2) {
            if (A) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static void u(Context context) {
        if (B == null) {
            B = m(context, false);
        }
        if (C == null) {
            C = m(context, true);
        }
        if (A) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + B + " Game=" + C);
        }
    }

    public static void v(Context context) {
        k0.Y(new a(context), 5000L);
    }

    public static void w() {
        B = null;
        C = null;
    }

    public void A(boolean z, boolean z2, @Nullable i.a aVar) {
        boolean z3 = true;
        this.z = d.b.g0.a.r1.d.e().h() != 1;
        this.w = 0L;
        String U = d.b.g0.a.r1.d.e().s().J().U();
        h hVar = this.x;
        boolean z4 = hVar == null || (hVar.f45396e ^ z) || TextUtils.isEmpty(U) || !TextUtils.equals(U, this.x.f45397f);
        if (A) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + U + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.x);
        }
        Handler g2 = d.b.g0.a.r1.d.g();
        if (this.x != null) {
            if (A) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.x.f45397f + " oldIsGameLoading = " + this.x.f45396e);
            }
            g2.removeCallbacks(this.x);
        }
        if (z4) {
            this.x = new h(U, z);
        }
        if (this.x == null) {
            return;
        }
        z3 = (aVar == null || !aVar.d(" event_params_pkg_update", false)) ? false : false;
        h hVar2 = this.x;
        if (hVar2.f45399h) {
            if (A) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: return by executing pkgUpdating = " + z3 + " trace = " + Log.getStackTraceString(new Exception()));
            }
            if (z3) {
                I(z, z3);
                return;
            }
            return;
        }
        if (z3) {
            hVar2.l();
        }
        if (z2) {
            this.x.f(false);
            return;
        }
        if (A) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
        }
        g2.post(this.x);
    }

    public void B(int i) {
        Handler g2 = d.b.g0.a.r1.d.g();
        h hVar = this.x;
        if (hVar != null) {
            g2.removeCallbacks(hVar);
            this.x.k();
            this.x = null;
        }
        g2.post(new e(i));
    }

    public void C(boolean z, boolean z2) {
        if (this.q == null) {
            return;
        }
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.r.removeAllUpdateListeners();
        }
        I(z, z2);
        this.u = 0.0f;
        this.t = 0.0f;
        this.v = 0.0f;
        if (z) {
            H();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.r = ofFloat;
            ofFloat.addUpdateListener(new f());
            this.r.setDuration(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            this.r.start();
        }
    }

    public void D() {
        if (A) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler g2 = d.b.g0.a.r1.d.g();
        h hVar = this.x;
        if (hVar != null) {
            g2.removeCallbacks(hVar);
            this.x.k();
            this.x = null;
        }
        synchronized (d.class) {
            if (this.l != null) {
                this.l.i();
            }
            if (this.o != null) {
                this.o.c();
                this.o = null;
            }
            if (this.q != null) {
                this.q.setVisibility(8);
                this.q = null;
                this.y = "";
                this.u = 0.0f;
                this.t = 0.0f;
                this.v = 0.0f;
            }
            if (this.r != null) {
                this.r.removeAllUpdateListeners();
                this.r.cancel();
                this.r = null;
            }
            this.s = false;
            if (this.x != null) {
                this.x.k();
                this.x = null;
            }
        }
    }

    public void E(String str) {
        if (A) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        String appId = d.b.g0.a.r1.d.e().getAppId();
        if (this.s) {
            this.f45382c.setImageBitmap(k0.l(str, "SwanAppLoadingView", true, new g(this, appId)));
        }
    }

    public final void F(Bitmap bitmap) {
        SwanAppRoundedImageView swanAppRoundedImageView;
        if (bitmap == null || (swanAppRoundedImageView = this.f45382c) == null) {
            return;
        }
        swanAppRoundedImageView.setImageBitmap(bitmap);
    }

    public void G(String str) {
        if (!this.s || TextUtils.isEmpty(str)) {
            return;
        }
        this.f45381b.setText(str);
    }

    public final void H() {
        if (this.q != null) {
            float l = l(this.u, this.t);
            if (l > 1.0f) {
                l = 1.0f;
            }
            y(l);
        }
    }

    public final void I(boolean z, boolean z2) {
        if (z) {
            this.y = "";
        } else {
            this.y = this.q.getContext().getString(z2 ? d.b.g0.a.h.swan_loading_view_tag_updating : d.b.g0.a.h.swan_loading_view_tag_loading);
        }
    }

    public final float l(float f2, float f3) {
        return ((1.0f - f2) * f3) + f2;
    }

    public final void n() {
        Bundle O;
        b.a launchInfo = this.m.getLaunchInfo();
        if (launchInfo == null || (O = launchInfo.O()) == null) {
            return;
        }
        long j = O.getLong("page_display_flag_for_statistic");
        O.remove("page_display_flag_for_statistic");
        if (j <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() - launchInfo.k("launch_time", 0L));
        d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
        fVar.f47644b = Config.LAUNCH;
        fVar.f47646d = "realcancel";
        fVar.r = valueOf;
        fVar.a("reason", IntentConfig.CLOSE);
        if (launchInfo.F() == 1) {
            fVar.a("errorList", d.b.g0.g.c0.b.c().d());
        }
        this.m.doUBCEventStatistic(fVar);
        d.b.g0.a.z1.e.n(launchInfo);
    }

    public final void o() {
        SwanLoadingTipsView swanLoadingTipsView = (SwanLoadingTipsView) this.f45380a.findViewById(d.b.g0.a.f.aigames_loading_game_tips);
        this.o = swanLoadingTipsView;
        swanLoadingTipsView.setTipsAnimationFinishCallback(new b());
        this.p = new SwanLoadingTips();
        this.f45380a.addOnAttachStateChangeListener(new c());
    }

    public final void p(int i) {
        h0.F(this.i, this.j, String.valueOf(i));
    }

    public final View q(Context context, boolean z) {
        View view = z ? C : B;
        if (z) {
            C = null;
        } else {
            B = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (z2) {
            v(context);
        }
        if (!z2) {
            view = m(context, z);
        }
        if (A) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  isLegalContainer= " + z2 + " game=" + z + " container=" + view);
        }
        return view;
    }

    public void r(float f2) {
        if (A) {
            Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f2 + " view: " + this.q);
        }
        if (this.q == null) {
            return;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.t = f2;
        H();
        if (this.z) {
            if (this.w == 0) {
                this.w = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.w > 2000) {
                d.b.g0.a.e0.f.k("pms_downloadPkg", "包下载进度更新间隔大于2秒");
                this.z = false;
            }
            this.w = currentTimeMillis;
        }
    }

    public void s() {
        if (this.q == null) {
            return;
        }
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.r.cancel();
            this.r = null;
        }
        y(1.0f);
    }

    public final void t(boolean z, boolean z2) {
        synchronized (d.class) {
            if (this.l == null) {
                this.l = new d.b.g0.a.s.a();
            }
            View q = q(this.m, z);
            this.f45380a = q;
            if (!z) {
                q.setPadding(0, d.b.g0.a.q1.b.a.f45931b ? h0.s() : 0, 0, 0);
            } else {
                o();
            }
            this.q = (TextView) this.f45380a.findViewById(d.b.g0.a.f.aiapps_loading_progress);
            b.a J = d.b.g0.a.r1.d.e().s().J();
            PMSAppInfo c0 = J.c0();
            C(z, z2);
            this.m.getFloatLayer().j(this.f45380a);
            this.s = true;
            this.f45381b = (TextView) this.f45380a.findViewById(d.b.g0.a.f.aiapps_title);
            this.f45382c = (SwanAppRoundedImageView) this.f45380a.findViewById(d.b.g0.a.f.aiapps_icon);
            this.i = (BdBaseImageView) this.f45380a.findViewById(d.b.g0.a.f.aiapps_label_bg);
            this.j = (TextView) this.f45380a.findViewById(d.b.g0.a.f.aiapps_label_tv);
            this.f45387h = (RelativeLayout) this.f45380a.findViewById(d.b.g0.a.f.aiapps_icon_rl);
            G(J.J());
            E(J.P());
            p(J.m1());
            this.f45383d = (ImageView) this.f45380a.findViewById(d.b.g0.a.f.light_print);
            this.f45384e = (ImageView) this.f45380a.findViewById(d.b.g0.a.f.dark_print);
            this.f45385f = (ImageView) this.f45380a.findViewById(d.b.g0.a.f.titlebar_right_menu_img);
            this.f45386g = (ImageView) this.f45380a.findViewById(d.b.g0.a.f.titlebar_right_menu_exit);
            this.k = this.f45380a.findViewById(d.b.g0.a.f.titlebar_right_menu);
            if (z) {
                this.f45385f.setClickable(true);
                this.f45385f.setImageResource(d.b.g0.a.e.aiapps_action_bar_single_menu_white_selector);
                this.f45386g.setImageResource(d.b.g0.a.e.aiapps_action_bar_exit_white_selector);
                this.k.setBackgroundResource(d.b.g0.a.e.aiapps_action_bar_right_menu_bg_solid);
                View findViewById = this.f45380a.findViewById(d.b.g0.a.f.titlebar_right_menu_line);
                this.n = findViewById;
                findViewById.setBackgroundResource(d.b.g0.a.c.aiapps_action_bar_menu_line_white);
            } else {
                this.f45385f.setImageResource(d.b.g0.a.e.aiapps_action_bar_menu_black_selector);
                this.f45386g.setImageResource(d.b.g0.a.e.aiapps_action_bar_exit_black_selector);
                this.k.setBackgroundResource(d.b.g0.a.e.aiapps_action_bar_right_menu_bg);
            }
            int i = c0 == null ? PMSConstants$PayProtected.NO_PAY_PROTECTED.type : c0.payProtected;
            if (!z && k0.D() && i == PMSConstants$PayProtected.PAY_PROTECTED.type) {
                ((RelativeLayout) this.f45380a.findViewById(d.b.g0.a.f.guarantee_plan_rl)).setVisibility(0);
            }
            this.f45384e.setAlpha(0.0f);
            this.l.h(this.m);
            x();
        }
    }

    public final void x() {
        this.f45386g.setOnClickListener(new View$OnClickListenerC0724d());
    }

    public final void y(float f2) {
        if (this.q == null || this.v > f2) {
            return;
        }
        this.v = f2;
        if (A) {
            Log.i("SwanAppLoadingView", "setProgressText: " + this.v);
        }
        int i = (int) (1000.0f * f2);
        String str = ((i / 10) + (i % 10 >= 5 ? 1 : 0)) + "%";
        String trim = this.y.trim();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(trim)) {
            sb.append(trim);
            sb.append(" ");
        }
        sb.append(str);
        h hVar = this.x;
        if (hVar != null && !hVar.f45396e) {
            if (hVar.j()) {
                if (A) {
                    Log.i("SwanAppLoadingView", "setProgressText: checking update");
                }
                TextView textView = this.q;
                textView.setText(textView.getContext().getString(d.b.g0.a.h.swanapp_swan_loading_runtime_check_updating));
                this.q.setVisibility(0);
            } else if (this.x.h() && this.v <= 0.0f) {
                if (A) {
                    Log.i("SwanAppLoadingView", "setProgressText: checking update");
                }
                TextView textView2 = this.q;
                textView2.setText(textView2.getContext().getString(d.b.g0.a.h.swanapp_swan_loading_runtime_check_updating));
                this.q.setVisibility(0);
            } else if (!this.x.j()) {
                if (this.x.l && !this.x.i()) {
                    if (A) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    TextView textView3 = this.q;
                    textView3.setText(textView3.getContext().getString(d.b.g0.a.h.swanapp_swan_loading_runtime_loading));
                    this.q.setVisibility(0);
                } else if (this.v >= 1.0f && !this.x.i()) {
                    if (A) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    TextView textView4 = this.q;
                    textView4.setText(textView4.getContext().getString(d.b.g0.a.h.swanapp_swan_loading_runtime_loading));
                    this.q.setVisibility(0);
                } else {
                    this.q.setText(sb);
                }
            } else {
                if (A) {
                    Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                }
                TextView textView5 = this.q;
                textView5.setText(textView5.getContext().getString(d.b.g0.a.h.swanapp_swan_loading_runtime_loading));
                this.q.setVisibility(0);
            }
        } else {
            this.q.setText(sb);
        }
        if (f2 > 0.0f) {
            this.q.setVisibility(0);
        }
    }

    public final void z() {
        SwanLoadingTips swanLoadingTips;
        if (this.o == null || (swanLoadingTips = this.p) == null) {
            return;
        }
        this.o.e(swanLoadingTips.b());
    }
}
