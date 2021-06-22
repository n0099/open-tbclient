package d.a.m0.a.v2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import d.a.m0.a.f1.e.b;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class e implements SlideInterceptor {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f49178i = d.a.m0.a.k.f46983a;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<SwanAppActivity> f49180f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.a.g2.b f49181g;

    /* renamed from: h  reason: collision with root package name */
    public BroadcastReceiver f49182h = new a();

    /* renamed from: e  reason: collision with root package name */
    public SlideHelper f49179e = new SlideHelper();

    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("reason");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                if (("homekey".equals(stringExtra) || stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) && e.this.f49179e != null) {
                    e.this.f49179e.closePane();
                    e.this.f49179e.setCanSlide(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f49183a;

        public b(SwanAppActivity swanAppActivity) {
            this.f49183a = swanAppActivity;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            this.f49183a.onBackPressed(3);
            e.this.h();
            this.f49183a.overridePendingTransition(0, 0);
            d.a.m0.a.m1.g.f().i();
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            View maskView = e.this.f49179e.getMaskView();
            if (maskView != null) {
                maskView.setAlpha(1.0f - f2);
                if (this.f49183a.hasActivedFrame()) {
                    this.f49183a.getFrame().i0();
                }
                if (f2 == 0.0f) {
                    maskView.setBackgroundColor(Color.parseColor(SlideHelper.DEFAULT_MASK_COLOR));
                }
                if (f2 == 1.0f) {
                    maskView.setBackgroundColor(0);
                }
            }
        }
    }

    public e(SwanAppActivity swanAppActivity) {
        this.f49180f = new WeakReference<>(swanAppActivity);
    }

    public final boolean c() {
        SwanAppActivity swanAppActivity = this.f49180f.get();
        return (swanAppActivity == null || swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    public void e() {
        this.f49179e.closePane();
    }

    public void f() {
        SwanAppActivity swanAppActivity = this.f49180f.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed()) {
            return;
        }
        this.f49179e.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
        this.f49179e.attachActivity(swanAppActivity);
        this.f49179e.setEnableReleaseWhenNoTranslucent(false);
        this.f49179e.setFadeColor(0);
        this.f49179e.setSlideInterceptor(this);
        this.f49179e.setSlideListener(new b(swanAppActivity));
        d.a.m0.a.p.e.b g2 = g();
        if (g2 != null) {
            this.f49179e.setRegionFactor(g2.F());
        }
    }

    public final d.a.m0.a.p.e.b g() {
        d.a.m0.a.h0.g.g swanAppFragmentManager;
        d.a.m0.a.h0.g.d m;
        SwanAppActivity swanAppActivity = this.f49180f.get();
        if (swanAppActivity == null || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (m = swanAppFragmentManager.m()) == null || !(m instanceof d.a.m0.a.h0.g.f)) {
            return null;
        }
        return ((d.a.m0.a.h0.g.f) m).b3();
    }

    public final void h() {
        if (d.a.m0.a.c1.a.H().a()) {
            this.f49181g.c(8);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [d.a.m0.a.p.e.c] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        d.a.m0.a.h0.g.g swanAppFragmentManager;
        d.a.m0.a.p.e.b g2;
        SwanAppActivity swanAppActivity = this.f49180f.get();
        if (swanAppActivity == null || !swanAppActivity.hasActivedFrame() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (g2 = g()) == null) {
            return false;
        }
        d.a.m0.a.p.e.e m = g2.m();
        return swanAppFragmentManager.k() <= 1 && g2.isSlidable(motionEvent) && !(m != null && m.u() != 0 && m.u().canGoBack()) && j();
    }

    public final boolean j() {
        SwanAppActivity swanAppActivity = this.f49180f.get();
        if (swanAppActivity != null && !swanAppActivity.isDestroyed() && swanAppActivity.hasActivedFrame()) {
            d.a.m0.a.h0.g.f o = swanAppActivity.getSwanAppFragmentManager().o();
            if (o != null) {
                d.a.m0.a.a2.n.g D1 = o.D1();
                if (D1 == null) {
                    return true;
                }
                if (D1.l || D1.m) {
                    d.a.m0.a.e2.c.f fVar = d.a.m0.a.n1.q.c.a.g(true).get("scope_disable_swipe_back");
                    if (fVar == null || fVar.f45481d) {
                        return false;
                    }
                    SlideHelper slideHelper = this.f49179e;
                    if (slideHelper != null) {
                        slideHelper.setRegionFactor(0.1d);
                    }
                }
                return true;
            } else if (f49178i) {
                Log.d("SwanActivitySlideHelper", "topFragment = null; return false");
            }
        }
        return false;
    }

    public void k() {
        SwanAppActivity swanAppActivity = this.f49180f.get();
        if (swanAppActivity == null) {
            return;
        }
        d.a.m0.a.g2.b skinDecorator = swanAppActivity.getSkinDecorator();
        this.f49181g = skinDecorator;
        if (skinDecorator == null) {
            return;
        }
        if (d.a.m0.a.f1.c.a.c(false).booleanValue()) {
            this.f49181g.c(0);
        }
        f();
    }

    public void n() {
        SwanAppActivity swanAppActivity = this.f49180f.get();
        if (swanAppActivity == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        swanAppActivity.registerReceiver(this.f49182h, intentFilter);
    }

    public void p() {
        SwanAppActivity swanAppActivity;
        WeakReference<SwanAppActivity> weakReference = this.f49180f;
        if (weakReference == null || (swanAppActivity = weakReference.get()) == null) {
            return;
        }
        swanAppActivity.unregisterReceiver(this.f49182h);
    }

    public void q() {
        if (this.f49180f.get() == null) {
            return;
        }
        this.f49179e.setCanSlide(c());
    }

    public void r() {
        SwanAppActivity swanAppActivity = this.f49180f.get();
        if (swanAppActivity == null) {
            return;
        }
        b.a launchInfo = swanAppActivity.getLaunchInfo();
        if ((launchInfo != null && "1230000000000000".equals(launchInfo.T())) || swanAppActivity.getFrameType() == 1) {
            this.f49179e.setCanSlide(false);
        } else {
            this.f49179e.setCanSlide(c());
        }
    }

    public void s() {
        if (d.a.m0.a.f1.c.a.c(true).booleanValue()) {
            this.f49181g.c(0);
        }
    }

    public void u(boolean z) {
        this.f49179e.setCanSlide(z);
    }
}
