package d.a.h0.a.i2;

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
import d.a.h0.a.y0.e.b;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class d implements SlideInterceptor {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f42714i = d.a.h0.a.k.f43101a;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<SwanAppActivity> f42716f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.a.x1.b f42717g;

    /* renamed from: h  reason: collision with root package name */
    public BroadcastReceiver f42718h = new a();

    /* renamed from: e  reason: collision with root package name */
    public SlideHelper f42715e = new SlideHelper();

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
                if (("homekey".equals(stringExtra) || stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) && d.this.f42715e != null) {
                    d.this.f42715e.closePane();
                    d.this.f42715e.setCanSlide(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f42719a;

        public b(SwanAppActivity swanAppActivity) {
            this.f42719a = swanAppActivity;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            this.f42719a.onBackPressed();
            d.this.h();
            this.f42719a.overridePendingTransition(0, 0);
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            View maskView = d.this.f42715e.getMaskView();
            if (maskView != null) {
                maskView.setAlpha(1.0f - f2);
                if (this.f42719a.hasActivedFrame()) {
                    this.f42719a.getFrame().f0();
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
        this.f42716f = new WeakReference<>(swanAppActivity);
    }

    public final boolean d() {
        SwanAppActivity swanAppActivity = this.f42716f.get();
        return (swanAppActivity == null || swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true;
    }

    public void e() {
        this.f42715e.closePane();
    }

    public void f() {
        SwanAppActivity swanAppActivity = this.f42716f.get();
        if (swanAppActivity == null || swanAppActivity.isDestroyed()) {
            return;
        }
        this.f42715e.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
        this.f42715e.attachActivity(swanAppActivity);
        this.f42715e.setEnableReleaseWhenNoTranslucent(false);
        this.f42715e.setFadeColor(0);
        this.f42715e.setSlideInterceptor(this);
        this.f42715e.setSlideListener(new b(swanAppActivity));
        d.a.h0.a.p.d.b g2 = g();
        if (g2 != null) {
            this.f42715e.setRegionFactor(g2.A());
        }
    }

    public final d.a.h0.a.p.d.b g() {
        d.a.h0.a.e0.l.f swanAppFragmentManager;
        d.a.h0.a.e0.l.c m;
        SwanAppActivity swanAppActivity = this.f42716f.get();
        if (swanAppActivity == null || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (m = swanAppFragmentManager.m()) == null || !(m instanceof d.a.h0.a.e0.l.e)) {
            return null;
        }
        return ((d.a.h0.a.e0.l.e) m).S2();
    }

    public final void h() {
        if (d.a.h0.a.w0.a.z().a()) {
            this.f42717g.c(8);
        }
    }

    public final boolean i() {
        d.a.h0.a.v1.c.e eVar;
        SwanAppActivity swanAppActivity = this.f42716f.get();
        if (swanAppActivity != null && !swanAppActivity.isDestroyed() && swanAppActivity.hasActivedFrame()) {
            d.a.h0.a.e0.l.e o = swanAppActivity.getSwanAppFragmentManager().o();
            if (o != null) {
                return o.x1() == null || !o.x1().l || (eVar = d.a.h0.a.g1.o.c.a.g(true).get("scope_disable_swipe_back")) == null || eVar.f44913d;
            } else if (f42714i) {
                Log.d("SwanActivitySlideHelper", "topFragment = null; return false");
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [d.a.h0.a.p.d.c] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        d.a.h0.a.e0.l.f swanAppFragmentManager;
        d.a.h0.a.p.d.b g2;
        SwanAppActivity swanAppActivity = this.f42716f.get();
        if (swanAppActivity == null || !swanAppActivity.hasActivedFrame() || (swanAppFragmentManager = swanAppActivity.getSwanAppFragmentManager()) == null || (g2 = g()) == null) {
            return false;
        }
        d.a.h0.a.p.d.e l = g2.l();
        return swanAppFragmentManager.k() <= 1 && g2.isSlidable(motionEvent) && !(l != null && l.s() != 0 && l.s().canGoBack()) && i();
    }

    public void j() {
        SwanAppActivity swanAppActivity = this.f42716f.get();
        if (swanAppActivity == null) {
            return;
        }
        d.a.h0.a.x1.b skinDecorator = swanAppActivity.getSkinDecorator();
        this.f42717g = skinDecorator;
        if (skinDecorator == null) {
            return;
        }
        if (d.a.h0.a.y0.c.a.c(false).booleanValue()) {
            this.f42717g.c(0);
        }
        f();
    }

    public void m() {
        SwanAppActivity swanAppActivity = this.f42716f.get();
        if (swanAppActivity == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        swanAppActivity.registerReceiver(this.f42718h, intentFilter);
    }

    public void o() {
        SwanAppActivity swanAppActivity;
        WeakReference<SwanAppActivity> weakReference = this.f42716f;
        if (weakReference == null || (swanAppActivity = weakReference.get()) == null) {
            return;
        }
        swanAppActivity.unregisterReceiver(this.f42718h);
    }

    public void p() {
        if (this.f42716f.get() == null) {
            return;
        }
        this.f42715e.setCanSlide(d());
    }

    public void q() {
        SwanAppActivity swanAppActivity = this.f42716f.get();
        if (swanAppActivity == null) {
            return;
        }
        b.a launchInfo = swanAppActivity.getLaunchInfo();
        if ((launchInfo != null && "1230000000000000".equals(launchInfo.S())) || swanAppActivity.getFrameType() == 1) {
            this.f42715e.setCanSlide(false);
        } else {
            this.f42715e.setCanSlide(d());
        }
    }

    public void s() {
        if (d.a.h0.a.y0.c.a.c(true).booleanValue()) {
            this.f42717g.c(0);
        }
    }

    public void t(boolean z) {
        this.f42715e.setCanSlide(z);
    }
}
