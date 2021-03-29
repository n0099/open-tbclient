package d.b.g0.a.i2;

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
import d.b.g0.a.y0.e.b;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d implements SlideInterceptor {
    public static final boolean i = d.b.g0.a.k.f45051a;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<SwanAppActivity> f44677f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.a.x1.b f44678g;

    /* renamed from: h  reason: collision with root package name */
    public BroadcastReceiver f44679h = new a();

    /* renamed from: e  reason: collision with root package name */
    public SlideHelper f44676e = new SlideHelper();

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
                if (("homekey".equals(stringExtra) || stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) && d.this.f44676e != null) {
                    d.this.f44676e.closePane();
                    d.this.f44676e.setCanSlide(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f44680a;

        public b(SwanAppActivity swanAppActivity) {
            this.f44680a = swanAppActivity;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            this.f44680a.onBackPressed();
            d.this.h();
            this.f44680a.overridePendingTransition(0, 0);
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            View maskView = d.this.f44676e.getMaskView();
            if (maskView != null) {
                maskView.setAlpha(1.0f - f2);
                if (this.f44680a.hasActivedFrame()) {
                    this.f44680a.getFrame().f0();
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

    public d(SwanAppActivity swanAppActivity) {
        this.f44677f = new WeakReference<>(swanAppActivity);
    }

    public final boolean d() {
        SwanAppActivity swanAppActivity = this.f44677f.get();
        return (swanAppActivity == null || swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    public void e() {
        this.f44676e.closePane();
    }

    public void f() {
        SwanAppActivity swanAppActivity = this.f44677f.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed()) {
            return;
        }
        this.f44676e.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
        this.f44676e.attachActivity(swanAppActivity);
        this.f44676e.setEnableReleaseWhenNoTranslucent(false);
        this.f44676e.setFadeColor(0);
        this.f44676e.setSlideInterceptor(this);
        this.f44676e.setSlideListener(new b(swanAppActivity));
        d.b.g0.a.p.d.b g2 = g();
        if (g2 != null) {
            this.f44676e.setRegionFactor(g2.c0());
        }
    }

    public final d.b.g0.a.p.d.b g() {
        d.b.g0.a.e0.l.f swanAppFragmentManager;
        d.b.g0.a.e0.l.c m;
        SwanAppActivity swanAppActivity = this.f44677f.get();
        if (swanAppActivity == null || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (m = swanAppFragmentManager.m()) == null || !(m instanceof d.b.g0.a.e0.l.e)) {
            return null;
        }
        return ((d.b.g0.a.e0.l.e) m).T2();
    }

    public final void h() {
        if (d.b.g0.a.w0.a.z().a()) {
            this.f44678g.c(8);
        }
    }

    public final boolean i() {
        d.b.g0.a.v1.c.e eVar;
        SwanAppActivity swanAppActivity = this.f44677f.get();
        if (swanAppActivity != null && !swanAppActivity.isDestroyed() && swanAppActivity.hasActivedFrame()) {
            d.b.g0.a.e0.l.e o = swanAppActivity.getSwanAppFragmentManager().o();
            if (o != null) {
                return o.y1() == null || !o.y1().l || (eVar = d.b.g0.a.g1.o.c.a.g(true).get("scope_disable_swipe_back")) == null || eVar.f46771d;
            } else if (i) {
                Log.d("SwanActivitySlideHelper", "topFragment = null; return false");
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [d.b.g0.a.p.d.c] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        d.b.g0.a.e0.l.f swanAppFragmentManager;
        d.b.g0.a.p.d.b g2;
        SwanAppActivity swanAppActivity = this.f44677f.get();
        if (swanAppActivity == null || !swanAppActivity.hasActivedFrame() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (g2 = g()) == null) {
            return false;
        }
        d.b.g0.a.p.d.e n = g2.n();
        return swanAppFragmentManager.k() <= 1 && g2.isSlidable(motionEvent) && !(n != null && n.getWebView() != 0 && n.getWebView().canGoBack()) && i();
    }

    public void j() {
        SwanAppActivity swanAppActivity = this.f44677f.get();
        if (swanAppActivity == null) {
            return;
        }
        d.b.g0.a.x1.b skinDecorator = swanAppActivity.getSkinDecorator();
        this.f44678g = skinDecorator;
        if (skinDecorator == null) {
            return;
        }
        if (d.b.g0.a.y0.c.a.c(false).booleanValue()) {
            this.f44678g.c(0);
        }
        f();
    }

    public void k() {
        SwanAppActivity swanAppActivity = this.f44677f.get();
        if (swanAppActivity == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        swanAppActivity.registerReceiver(this.f44679h, intentFilter);
    }

    public void l() {
        SwanAppActivity swanAppActivity;
        WeakReference<SwanAppActivity> weakReference = this.f44677f;
        if (weakReference == null || (swanAppActivity = weakReference.get()) == null) {
            return;
        }
        swanAppActivity.unregisterReceiver(this.f44679h);
    }

    public void o() {
        if (this.f44677f.get() == null) {
            return;
        }
        this.f44676e.setCanSlide(d());
    }

    public void p() {
        SwanAppActivity swanAppActivity = this.f44677f.get();
        if (swanAppActivity == null) {
            return;
        }
        b.a launchInfo = swanAppActivity.getLaunchInfo();
        if ((launchInfo != null && "1230000000000000".equals(launchInfo.S())) || swanAppActivity.getFrameType() == 1) {
            this.f44676e.setCanSlide(false);
        } else {
            this.f44676e.setCanSlide(d());
        }
    }

    public void q() {
        if (d.b.g0.a.y0.c.a.c(true).booleanValue()) {
            this.f44678g.c(0);
        }
    }

    public void r(boolean z) {
        this.f44676e.setCanSlide(z);
    }
}
