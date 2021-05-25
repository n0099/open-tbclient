package d.a.l0.a.w2;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.view.SwanAppLaunchCircleAnimationView;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.apps.view.loading.SwanLoadingTips;
import com.baidu.swan.apps.view.loading.SwanLoadingTipsView;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.l0.a.a2.i;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.v2.f0;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.t;
import d.a.l0.a.v2.x0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes3.dex */
public class e {
    public static final boolean C = d.a.l0.a.k.f43199a;
    @SuppressLint({"StaticFieldLeak"})
    public static View D;
    @SuppressLint({"StaticFieldLeak"})
    public static View E;
    public TextView A;
    public int B;

    /* renamed from: a  reason: collision with root package name */
    public View f45667a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f45668b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppRoundedImageView f45669c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f45670d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f45671e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f45672f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f45673g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f45674h;

    /* renamed from: i  reason: collision with root package name */
    public BdBaseImageView f45675i;
    public TextView j;
    public View k;
    public d.a.l0.a.t.a l;
    public SwanAppActivity m;
    public View n;
    public SwanLoadingTipsView o;
    public SwanLoadingTips p;
    public TextView q;
    public ValueAnimator r;
    public long w;
    public boolean z;
    public boolean s = false;
    public float t = 0.0f;
    public float u = 0.0f;
    public float v = 0.0f;
    public m x = null;
    public String y = "";

    /* loaded from: classes3.dex */
    public class a implements SwanAppNetworkUtils.b {
        public a(e eVar) {
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i2) {
            if (i2 == 1) {
                d.a.l0.a.h0.i.i.i("包下载进度更新间隔超2秒; 网络：正常");
                d.a.l0.a.h0.i.f.d("pms_downloadPkg", FrsActivityConfig.GOOD);
                d.a.l0.a.h0.i.e.f(d.a.l0.a.h.swanapp_tip_waiting_and_retry);
            } else if (i2 == 2) {
                d.a.l0.a.h0.i.i.i("包下载进度更新间隔超2秒; 网络：弱网");
                d.a.l0.a.h0.i.f.d("pms_downloadPkg", "bad");
                d.a.l0.a.h0.i.e.f(d.a.l0.a.h.swanapp_tip_get_pkg_poor_net);
            } else if (i2 != 3) {
                d.a.l0.a.h0.i.i.i("包下载进度更新间隔超2秒; 网络：未知");
                d.a.l0.a.h0.i.f.d("pms_downloadPkg", "unknown");
                d.a.l0.a.h0.i.e.f(d.a.l0.a.h.swanapp_tip_waiting_and_retry);
            } else {
                d.a.l0.a.h0.i.i.i("包下载进度更新间隔超2秒; 网络：离线");
                d.a.l0.a.h0.i.f.d("pms_downloadPkg", "offline");
                d.a.l0.a.h0.i.e.f(d.a.l0.a.h.swanapp_tip_get_pkg_poor_net);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue > 0.9f || floatValue - e.this.u > 0.05d) {
                e.this.u = floatValue;
                e.this.O();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements t.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45677a;

        public c(e eVar, String str) {
            this.f45677a = str;
        }

        @Override // d.a.l0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            SwanAppActivity x;
            e loadingView;
            if (bitmap == null || (x = d.a.l0.a.a2.d.g().x()) == null || x.isDestroyed() || (loadingView = x.getLoadingView()) == null || !TextUtils.equals(this.f45677a, d.a.l0.a.a2.d.g().getAppId())) {
                return;
            }
            loadingView.L(bitmap);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45678e;

        public d(Context context) {
            this.f45678e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.z(this.f45678e);
        }
    }

    /* renamed from: d.a.l0.a.w2.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0897e implements Runnable {
        public RunnableC0897e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int e2 = f0.e(e.this.m);
            if (!f0.q(e.this.m, e.this.k) || e.this.m.isLandScape()) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) e.this.k.getLayoutParams();
            layoutParams.topMargin = e.this.k.getTop() + e2;
            e.this.k.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.q == null) {
                return;
            }
            e.this.q.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.A == null) {
                return;
            }
            e.this.A.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int e2 = f0.e(e.this.m);
            if (!f0.q(e.this.m, e.this.k) || e.this.m.isLandScape()) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) e.this.k.getLayoutParams();
            layoutParams.topMargin = e.this.k.getTop() + e2;
            e.this.k.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Function0<Unit> {
        public i() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            e.this.E();
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements View.OnAttachStateChangeListener {
        public j() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            e.this.E();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: classes3.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.m == null || e.this.m.isFinishing()) {
                return;
            }
            HybridUbcFlow m = d.a.l0.a.r1.h.m();
            if (m != null) {
                m.A("exitType", String.valueOf(3));
                m.B("value", QueryResponse.Options.CANCEL);
                m.l();
            }
            e.this.m.moveTaskToBack(true);
            x0.b().e(2);
            e.this.r();
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45686e;

        public l(int i2) {
            this.f45686e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (e.class) {
                d.a.l0.a.r1.h.o().C(new UbcFlowEvent("first_anim_end"));
                d.a.l0.a.i2.a.d().i("first_anim_end");
                if (e.this.l != null) {
                    e.this.l.n(e.this.m, this.f45686e);
                }
                e.this.s = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final boolean f45688e;

        /* renamed from: f  reason: collision with root package name */
        public final String f45689f;

        /* renamed from: i  reason: collision with root package name */
        public final d.a.l0.a.a2.b f45692i;
        public int k;
        public boolean l;

        /* renamed from: g  reason: collision with root package name */
        public boolean f45690g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f45691h = false;
        public int j = -1;

        /* loaded from: classes3.dex */
        public class a implements d.a.l0.a.v2.e1.b<i.a> {
            public a(e eVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (e.C) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_FINISH");
                }
                m.this.k = aVar.i("KEY_PRELOAD_STATE");
                m.this.e();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements d.a.l0.a.v2.e1.b<i.a> {
            public b(m mVar, e eVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (e.C) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_ERROR");
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements d.a.l0.a.v2.e1.b<i.a> {
            public c(m mVar, e eVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (e.C) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_START");
                }
            }
        }

        /* loaded from: classes3.dex */
        public class d implements d.a.l0.a.v2.e1.b<i.a> {
            public d(e eVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (e.C) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_FINISH");
                }
                m.this.l = true;
                m.this.e();
            }
        }

        /* renamed from: d.a.l0.a.w2.e$m$e  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0898e implements d.a.l0.a.v2.e1.b<i.a> {
            public C0898e(m mVar, e eVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (e.C) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_START");
                }
            }
        }

        /* loaded from: classes3.dex */
        public class f implements d.a.l0.a.v2.e1.b<i.a> {
            public f(e eVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (e.C) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                }
                m.this.j = aVar.j("KEY_PKG_STATE", -1);
                m.this.e();
            }
        }

        /* loaded from: classes3.dex */
        public class g implements d.a.l0.a.v2.e1.b<i.a> {
            public g(e eVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                if (e.C) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                }
                m.this.j = aVar.j("KEY_PKG_STATE", -1);
                m.this.e();
            }
        }

        public m(String str, boolean z) {
            this.f45689f = str;
            this.f45688e = z;
            d.a.l0.a.a2.b bVar = new d.a.l0.a.a2.b();
            bVar.e(new g(e.this), "event_pms_check_start");
            bVar.e(new f(e.this), "event_pms_check_finish");
            bVar.e(new C0898e(this, e.this), "event_pkg_download_start");
            bVar.e(new d(e.this), "event_pkg_download_finish");
            bVar.e(new c(this, e.this), "event_preload_start");
            bVar.e(new b(this, e.this), "event_preload_error");
            bVar.e(new a(e.this), "event_preload_finish");
            this.f45692i = bVar;
            d.a.l0.a.a2.d.g().v(this.f45692i);
        }

        public void e() {
            boolean j = j();
            boolean g2 = g();
            boolean i2 = i();
            if (e.C) {
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + j);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + g2);
                Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + i2);
            }
            if (j || g2 || !i2) {
                e.this.O();
            }
        }

        public void f(boolean z) {
            if (e.C) {
                StringBuilder sb = new StringBuilder();
                sb.append("ViewStarter exec : post = ");
                sb.append(z);
                sb.append(" trace = ");
                sb.append(z ? "post" : Log.getStackTraceString(new Exception()));
                Log.i("SwanAppLoadingView", sb.toString());
            }
            this.f45691h = true;
            boolean z2 = this.f45688e;
            if (z2) {
                e.this.y(z2, this.f45690g);
                return;
            }
            int d2 = d.a.l0.a.r1.l.b.d();
            if (d2 == 0) {
                e.this.y(this.f45688e, this.f45690g);
            } else if (d2 == 1) {
                e.this.x(this.f45688e, this.f45690g, true);
            } else if (d2 == 2) {
                e.this.x(this.f45688e, this.f45690g, false);
            } else if (d2 != 3) {
                if (e.C) {
                    Log.i("SwanAppLoadingView", "ViewStarter exec : invalid animationType = " + d.a.l0.a.r1.l.b.d());
                }
            } else {
                e.this.x(this.f45688e, this.f45690g, true);
            }
        }

        public boolean g() {
            boolean h2 = h();
            boolean i2 = i();
            boolean z = h2 && i2;
            if (e.C) {
                Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + h2);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + i2);
                Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
            }
            return z;
        }

        public boolean h() {
            int i2 = this.j;
            boolean z = true;
            if (i2 != 3 && i2 != 1) {
                z = false;
            }
            if (e.C) {
                Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
            }
            return z;
        }

        public boolean i() {
            boolean c0 = d.a.l0.a.h0.u.g.N().c0();
            if (e.C) {
                Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + c0);
            }
            return c0;
        }

        public boolean j() {
            boolean z = this.j == 4;
            boolean i2 = i();
            if (e.C) {
                Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + i2);
            }
            return z && !i2;
        }

        public void k() {
            if (e.C) {
                Log.i("SwanAppLoadingView", "onDestroy: ");
            }
            d.a.l0.a.a2.d.g().p(this.f45692i);
        }

        public m l() {
            this.f45690g = true;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            f(true);
        }
    }

    public e(SwanAppActivity swanAppActivity) {
        this.m = swanAppActivity;
    }

    public static void A(Context context) {
        q0.c0(new d(context), 5000L);
    }

    public static void B() {
        D = null;
        E = null;
    }

    public static View q(Context context, boolean z) {
        int i2;
        int i3 = z ? d.a.l0.a.g.ai_games_loading_fragment : d.a.l0.a.g.aiapps_loading_fragment;
        try {
            if (d.a.l0.a.r1.l.b.d() != 1 && d.a.l0.a.r1.l.b.d() != 3) {
                if (d.a.l0.a.r1.l.b.d() == 2) {
                    i2 = z ? d.a.l0.a.g.ai_games_loading_fragment : d.a.l0.a.g.aiapps_loading_fragment_shimmer;
                }
                return LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
            }
            i2 = z ? d.a.l0.a.g.ai_games_loading_fragment : d.a.l0.a.g.aiapps_loading_fragment_circle;
            return LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
        } catch (Exception e2) {
            if (C) {
                e2.printStackTrace();
            }
            return null;
        }
        i3 = i2;
    }

    public static void z(Context context) {
        if (D == null) {
            D = q(context, false);
        }
        if (E == null) {
            E = q(context, true);
        }
        if (C) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + D + " Game=" + E);
        }
    }

    public final void C() {
        this.f45673g.setOnClickListener(new k());
    }

    public final void D(float f2) {
        if (this.q == null || this.v > f2) {
            return;
        }
        this.v = f2;
        if (C) {
            Log.i("SwanAppLoadingView", "setProgressText: " + this.v);
        }
        int i2 = (int) (1000.0f * f2);
        String str = ((i2 / 10) + (i2 % 10 >= 5 ? 1 : 0)) + "%";
        String trim = this.y.trim();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(trim)) {
            sb.append(trim);
            sb.append(" ");
        }
        sb.append(str);
        m mVar = this.x;
        if (mVar != null && !mVar.f45688e) {
            if (mVar.j()) {
                if (C) {
                    Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                }
                if (this.B == 0) {
                    TextView textView = this.q;
                    textView.setText(textView.getContext().getString(d.a.l0.a.h.swanapp_swan_loading_runtime_loading));
                    this.q.setVisibility(0);
                }
            } else if (!this.x.h() || this.v > 0.0f) {
                if (this.x.l && !this.x.i()) {
                    if (C) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    if (this.B == 0) {
                        this.q.setVisibility(0);
                        TextView textView2 = this.q;
                        textView2.setText(textView2.getContext().getString(d.a.l0.a.h.swanapp_swan_loading_runtime_loading));
                    }
                    int i3 = this.B;
                    if (i3 == 1 || i3 == 3) {
                        this.q.setVisibility(4);
                    }
                } else if (this.v >= 1.0f && !this.x.i()) {
                    if (C) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    if (this.B == 0) {
                        this.q.setVisibility(0);
                        TextView textView3 = this.q;
                        textView3.setText(textView3.getContext().getString(d.a.l0.a.h.swanapp_swan_loading_runtime_loading));
                    }
                    int i4 = this.B;
                    if (i4 == 1 || i4 == 3) {
                        this.q.setVisibility(4);
                    }
                } else {
                    this.q.setText(sb);
                }
            } else {
                if (C) {
                    Log.i("SwanAppLoadingView", "setProgressText: checking update");
                }
                if (this.B == 0) {
                    this.q.setVisibility(0);
                    TextView textView4 = this.q;
                    textView4.setText(textView4.getContext().getString(d.a.l0.a.h.swanapp_swan_check_update_text));
                }
                int i5 = this.B;
                if (i5 == 1 || i5 == 3) {
                    this.q.setVisibility(4);
                }
            }
        } else {
            this.q.setText(sb);
        }
        if (f2 > 0.0f && this.B == 0) {
            this.q.setVisibility(0);
        }
        if (f2 == 1.0f) {
            int i6 = this.B;
            if (i6 == 1 || i6 == 3) {
                this.q.setVisibility(4);
            }
        }
    }

    public final void E() {
        SwanLoadingTips swanLoadingTips;
        if (this.o == null || (swanLoadingTips = this.p) == null) {
            return;
        }
        this.o.e(swanLoadingTips.b());
    }

    public void F(boolean z, boolean z2, @Nullable i.a aVar) {
        boolean z3 = true;
        this.z = d.a.l0.a.a2.d.g().l() != 1;
        this.w = 0L;
        String V = d.a.l0.a.a2.d.g().r().L().V();
        this.B = d.a.l0.a.r1.l.b.d();
        m mVar = this.x;
        boolean z4 = mVar == null || (mVar.f45688e ^ z) || TextUtils.isEmpty(V) || !TextUtils.equals(V, this.x.f45689f);
        if (C) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + V + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.x);
        }
        Handler i2 = d.a.l0.a.a2.d.i();
        if (this.x != null) {
            if (C) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.x.f45689f + " oldIsGameLoading = " + this.x.f45688e);
            }
            i2.removeCallbacks(this.x);
        }
        if (z4) {
            this.x = new m(V, z);
        }
        if (this.x == null) {
            return;
        }
        z3 = (aVar == null || !aVar.e(" event_params_pkg_update", false)) ? false : false;
        m mVar2 = this.x;
        if (mVar2.f45691h) {
            if (C) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: return by executing pkgUpdating = " + z3 + " trace = " + Log.getStackTraceString(new Exception()));
            }
            if (z3) {
                P(z, z3);
                return;
            }
            return;
        }
        if (z3) {
            mVar2.l();
        }
        if (z2) {
            this.x.f(false);
            return;
        }
        if (C) {
            Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
        }
        i2.post(this.x);
    }

    public final void G() {
        SwanAppNetworkUtils.b(new a(this));
    }

    public void H(int i2) {
        Handler i3 = d.a.l0.a.a2.d.i();
        m mVar = this.x;
        if (mVar != null) {
            i3.removeCallbacks(mVar);
            this.x.k();
            this.x = null;
        }
        i3.post(new l(i2));
    }

    public void I(boolean z, boolean z2) {
        if (this.q == null) {
            return;
        }
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.r.removeAllUpdateListeners();
        }
        P(z, z2);
        this.u = 0.0f;
        this.t = 0.0f;
        this.v = 0.0f;
        if (z) {
            O();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.r = ofFloat;
            ofFloat.addUpdateListener(new b());
            this.r.setDuration(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            this.r.start();
        }
    }

    public void J() {
        if (C) {
            Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
        }
        Handler i2 = d.a.l0.a.a2.d.i();
        m mVar = this.x;
        if (mVar != null) {
            i2.removeCallbacks(mVar);
            this.x.k();
            this.x = null;
        }
        synchronized (e.class) {
            if (this.l != null) {
                this.l.q();
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

    public void K(String str) {
        SwanAppRoundedImageView swanAppRoundedImageView;
        if (C) {
            Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
        }
        String appId = d.a.l0.a.a2.d.g().getAppId();
        if (!this.s || (swanAppRoundedImageView = this.f45669c) == null) {
            return;
        }
        swanAppRoundedImageView.setImageBitmap(q0.k(str, "SwanAppLoadingView", true, new c(this, appId)));
    }

    public final void L(Bitmap bitmap) {
        SwanAppRoundedImageView swanAppRoundedImageView;
        if (bitmap == null || (swanAppRoundedImageView = this.f45669c) == null || swanAppRoundedImageView == null) {
            return;
        }
        swanAppRoundedImageView.setImageBitmap(bitmap);
    }

    public void M(String str) {
        TextView textView;
        if (!this.s || TextUtils.isEmpty(str) || (textView = this.f45668b) == null) {
            return;
        }
        textView.setText(str);
    }

    public void N(int i2) {
        View view;
        RelativeLayout relativeLayout;
        if (i2 != PMSConstants.PayProtected.PAY_PROTECTED.type || (view = this.f45667a) == null || (relativeLayout = (RelativeLayout) view.findViewById(d.a.l0.a.f.guarantee_plan_rl)) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
    }

    public final void O() {
        SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView;
        if (this.q != null) {
            float p = p(this.u, this.t);
            if (p > 1.0f) {
                p = 1.0f;
            }
            D(p);
            int i2 = this.B;
            if ((i2 == 1 || i2 == 3) && p > 0.0f && d.a.l0.a.a2.d.g().l() != 1 && (swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) this.m.findViewById(d.a.l0.a.f.App_Launch_Circle_Animation_View)) != null) {
                swanAppLaunchCircleAnimationView.j(p);
            }
        }
    }

    public final void P(boolean z, boolean z2) {
        TextView textView = this.q;
        if (textView == null) {
            return;
        }
        if (!z) {
            this.y = textView.getContext().getString(z2 ? d.a.l0.a.h.swan_loading_view_tag_updating : d.a.l0.a.h.swanapp_swan_loading_runtime_loading);
            int i2 = this.B;
            if (i2 == 1 || i2 == 3) {
                this.y = this.q.getContext().getString(d.a.l0.a.h.swan_loading_view_tag_downloading);
                return;
            }
            return;
        }
        this.y = "";
    }

    public final float p(float f2, float f3) {
        return ((1.0f - f2) * f3) + f2;
    }

    public final void r() {
        Bundle P;
        b.a launchInfo = this.m.getLaunchInfo();
        if (launchInfo == null || (P = launchInfo.P()) == null) {
            return;
        }
        long j2 = P.getLong("page_display_flag_for_statistic");
        P.remove("page_display_flag_for_statistic");
        if (j2 <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() - launchInfo.l("launch_time", 0L));
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        fVar.f43186b = "launch";
        fVar.f43189e = "realcancel";
        fVar.q = valueOf;
        fVar.a("reason", IntentConfig.CLOSE);
        if (launchInfo.G() == 1) {
            fVar.a("errorList", d.a.l0.a.c1.b.j().a());
        }
        this.m.doUBCEventStatistic(fVar);
        d.a.l0.a.j2.e.q(launchInfo);
    }

    public final void s() {
        SwanLoadingTipsView swanLoadingTipsView = (SwanLoadingTipsView) this.f45667a.findViewById(d.a.l0.a.f.aigames_loading_game_tips);
        this.o = swanLoadingTipsView;
        swanLoadingTipsView.setTipsAnimationFinishCallback(new i());
        this.p = new SwanLoadingTips();
        this.f45667a.addOnAttachStateChangeListener(new j());
    }

    public final void t(int i2) {
        n0.I(this.f45675i, this.j, String.valueOf(i2));
    }

    public final View u(Context context, boolean z) {
        View view = z ? E : D;
        if (z) {
            E = null;
        } else {
            D = null;
        }
        boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
        if (!z2) {
            view = q(context, z);
        }
        if (C) {
            Log.i("SwanAppLoadingView", "obtainPreloadContainer:  isLegalContainer= " + z2 + " game=" + z + " container=" + view);
        }
        return view;
    }

    public void v(float f2) {
        if (C) {
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
        O();
        if (this.z) {
            if (this.w == 0) {
                this.w = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.w > 2000) {
                G();
                this.z = false;
            }
            this.w = currentTimeMillis;
        }
    }

    public void w() {
        if (this.q == null) {
            return;
        }
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.r.cancel();
            this.r = null;
        }
        D(1.0f);
    }

    public final void x(boolean z, boolean z2, boolean z3) {
        synchronized (e.class) {
            if (this.l == null) {
                this.l = new d.a.l0.a.t.a();
            }
            View u = u(this.m, z);
            this.f45667a = u;
            if (!z) {
                u.setPadding(0, d.a.l0.a.z1.b.a.f46040b ? n0.u() : 0, 0, 0);
            } else {
                s();
            }
            Handler i2 = d.a.l0.a.a2.d.i();
            b.a L = d.a.l0.a.a2.d.g().r().L();
            this.m.getFloatLayer().k(this.f45667a);
            this.s = true;
            this.f45672f = (ImageView) this.f45667a.findViewById(d.a.l0.a.f.titlebar_right_menu_img);
            this.f45673g = (ImageView) this.f45667a.findViewById(d.a.l0.a.f.titlebar_right_menu_exit);
            this.k = this.f45667a.findViewById(d.a.l0.a.f.titlebar_right_menu);
            if (z) {
                this.f45672f.setClickable(true);
                this.f45672f.setImageResource(d.a.l0.a.e.aiapps_action_bar_single_menu_white_selector);
                this.f45673g.setImageResource(d.a.l0.a.e.aiapps_action_bar_exit_white_selector);
                this.k.setBackgroundResource(d.a.l0.a.e.aiapps_action_bar_right_menu_bg_solid);
                View findViewById = this.f45667a.findViewById(d.a.l0.a.f.titlebar_right_menu_line);
                this.n = findViewById;
                findViewById.setBackgroundResource(d.a.l0.a.c.aiapps_action_bar_menu_line_white);
                this.k.post(new RunnableC0897e());
            } else {
                this.f45672f.setImageResource(d.a.l0.a.e.aiapps_action_bar_menu_black_selector);
                this.f45673g.setImageResource(d.a.l0.a.e.aiapps_action_bar_exit_black_selector);
                this.k.setBackgroundResource(d.a.l0.a.e.aiapps_action_bar_right_menu_bg);
                N(L.n1());
            }
            if (z3) {
                this.q = (TextView) this.f45667a.findViewById(d.a.l0.a.f.aiapps_loading_progress);
                i2.postDelayed(new f(), 2000L);
                I(z, z2);
                TextView textView = (TextView) this.f45667a.findViewById(d.a.l0.a.f.aiapps_title);
                this.f45668b = textView;
                textView.getPaint().setFakeBoldText(true);
                this.f45669c = (SwanAppRoundedImageView) this.f45667a.findViewById(d.a.l0.a.f.aiapps_icon);
                this.f45675i = (BdBaseImageView) this.f45667a.findViewById(d.a.l0.a.f.aiapps_label_bg);
                this.j = (TextView) this.f45667a.findViewById(d.a.l0.a.f.aiapps_label_tv);
                this.f45674h = (RelativeLayout) this.f45667a.findViewById(d.a.l0.a.f.aiapps_icon_rl);
                M(L.K());
                K(L.Q());
                t(L.t1());
                this.l.l(this.m);
            } else {
                this.A = (TextView) this.f45667a.findViewById(d.a.l0.a.f.aiapps_loading_shimmer_poor_network_notice);
                i2.postDelayed(new g(), d.a.l0.a.r1.l.b.c());
                this.l.p(this.m);
            }
            C();
        }
    }

    public final void y(boolean z, boolean z2) {
        synchronized (e.class) {
            if (this.l == null) {
                this.l = new d.a.l0.a.t.a();
            }
            View u = u(this.m, z);
            this.f45667a = u;
            if (!z) {
                u.setPadding(0, d.a.l0.a.z1.b.a.f46040b ? n0.u() : 0, 0, 0);
            } else {
                s();
            }
            this.q = (TextView) this.f45667a.findViewById(d.a.l0.a.f.aiapps_loading_progress);
            b.a L = d.a.l0.a.a2.d.g().r().L();
            L.f0();
            I(z, z2);
            this.m.getFloatLayer().k(this.f45667a);
            this.s = true;
            this.f45668b = (TextView) this.f45667a.findViewById(d.a.l0.a.f.aiapps_title);
            this.f45669c = (SwanAppRoundedImageView) this.f45667a.findViewById(d.a.l0.a.f.aiapps_icon);
            this.f45675i = (BdBaseImageView) this.f45667a.findViewById(d.a.l0.a.f.aiapps_label_bg);
            this.j = (TextView) this.f45667a.findViewById(d.a.l0.a.f.aiapps_label_tv);
            this.f45674h = (RelativeLayout) this.f45667a.findViewById(d.a.l0.a.f.aiapps_icon_rl);
            M(L.K());
            K(L.Q());
            t(L.t1());
            this.f45670d = (ImageView) this.f45667a.findViewById(d.a.l0.a.f.light_print);
            this.f45671e = (ImageView) this.f45667a.findViewById(d.a.l0.a.f.dark_print);
            this.f45672f = (ImageView) this.f45667a.findViewById(d.a.l0.a.f.titlebar_right_menu_img);
            this.f45673g = (ImageView) this.f45667a.findViewById(d.a.l0.a.f.titlebar_right_menu_exit);
            this.k = this.f45667a.findViewById(d.a.l0.a.f.titlebar_right_menu);
            if (z) {
                this.f45672f.setClickable(true);
                this.f45672f.setImageResource(d.a.l0.a.e.aiapps_action_bar_single_menu_white_selector);
                this.f45673g.setImageResource(d.a.l0.a.e.aiapps_action_bar_exit_white_selector);
                this.k.setBackgroundResource(d.a.l0.a.e.aiapps_action_bar_right_menu_bg_solid);
                View findViewById = this.f45667a.findViewById(d.a.l0.a.f.titlebar_right_menu_line);
                this.n = findViewById;
                findViewById.setBackgroundResource(d.a.l0.a.c.aiapps_action_bar_menu_line_white);
                this.k.post(new h());
            } else {
                this.f45672f.setImageResource(d.a.l0.a.e.aiapps_action_bar_menu_black_selector);
                this.f45673g.setImageResource(d.a.l0.a.e.aiapps_action_bar_exit_black_selector);
                this.k.setBackgroundResource(d.a.l0.a.e.aiapps_action_bar_right_menu_bg);
                N(L.n1());
            }
            this.f45671e.setAlpha(0.0f);
            this.l.o(this.m);
            C();
        }
    }
}
