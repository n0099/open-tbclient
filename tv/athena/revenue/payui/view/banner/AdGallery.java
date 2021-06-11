package tv.athena.revenue.payui.view.banner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Gallery;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class AdGallery extends Gallery implements View.OnTouchListener {

    /* renamed from: e  reason: collision with root package name */
    public final Handler f72965e;

    /* renamed from: f  reason: collision with root package name */
    public int f72966f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f72967g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72968h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f72969i;
    public boolean j;
    public boolean k;
    public final BroadcastReceiver l;
    public boolean m;

    /* loaded from: classes8.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                AdGallery.this.k = false;
                AdGallery.this.n();
            } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                AdGallery.this.k = true;
                AdGallery.this.o(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<AdGallery> f72970a;

        public b(AdGallery adGallery) {
            this.f72970a = new WeakReference<>(adGallery);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AdGallery adGallery = this.f72970a.get();
            if (adGallery != null && message.what == 1 && adGallery.f72968h) {
                if (adGallery.getSelectedItemPosition() >= adGallery.getCount() - 1) {
                    adGallery.setSelection(0, true);
                    adGallery.onKeyDown(21, null);
                } else {
                    adGallery.onKeyDown(22, null);
                }
                sendMessageDelayed(obtainMessage(1), adGallery.f72966f);
            }
        }
    }

    public AdGallery(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f72965e = new b(this);
        this.f72966f = 10000;
        this.f72967g = false;
        this.f72968h = false;
        this.f72969i = false;
        this.j = false;
        this.k = true;
        this.l = new a();
        this.m = false;
        g();
    }

    public void f() {
        l();
    }

    public void g() {
        setOnTouchListener(this);
        setSoundEffectsEnabled(false);
        setFocusableInTouchMode(true);
    }

    public final boolean h(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent2.getX() > motionEvent.getX() + 50.0f;
    }

    public final void i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        getContext().registerReceiver(this.l, intentFilter, null, this.f72965e);
        this.m = true;
        RLog.debug("AdGallery", "[onAttachedToWindow] mHasRegisterReceiver = " + this.m);
    }

    public void j() {
        k();
    }

    public void k() {
        this.f72969i = true;
        n();
    }

    public void l() {
        this.f72969i = false;
        n();
    }

    public final void m() {
        RLog.debug("AdGallery", "[onAttachedToWindow] mHasRegisterReceiver = " + this.m);
        if (this.m) {
            RLog.debug("AdGallery", "[onAttachedToWindow] unregisterReceiver");
            try {
                getContext().unregisterReceiver(this.l);
            } catch (Exception e2) {
                RLog.error("AdGallery", "unregisterReceiver exception ", e2);
            }
            this.m = false;
        }
    }

    public final void n() {
        o(true);
    }

    public final void o(boolean z) {
        boolean z2 = this.j && this.f72969i && this.k;
        if (z2 != this.f72968h) {
            if (z2) {
                setSelection(getSelectedItemPosition(), z);
                this.f72965e.sendMessageDelayed(this.f72965e.obtainMessage(1), this.f72966f);
            } else {
                this.f72965e.removeMessages(1);
            }
            this.f72968h = z2;
        }
    }

    @Override // android.widget.Gallery, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
        if (this.f72967g) {
            k();
        }
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.j = false;
        m();
        n();
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        onKeyDown(h(motionEvent, motionEvent2) ? 21 : 22, null);
        return true;
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return super.onScroll(motionEvent, motionEvent2, f2, f3);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (1 != motionEvent.getAction() && 3 != motionEvent.getAction()) {
            l();
            return false;
        }
        k();
        return false;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.j = i2 == 0;
        o(false);
    }

    public void setAutoStart(boolean z) {
        this.f72967g = z;
    }

    public void setFlipInterval(int i2) {
        this.f72966f = i2;
    }

    public AdGallery(Context context) {
        super(context);
        this.f72965e = new b(this);
        this.f72966f = 10000;
        this.f72967g = false;
        this.f72968h = false;
        this.f72969i = false;
        this.j = false;
        this.k = true;
        this.l = new a();
        this.m = false;
        g();
    }

    public AdGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f72965e = new b(this);
        this.f72966f = 10000;
        this.f72967g = false;
        this.f72968h = false;
        this.f72969i = false;
        this.j = false;
        this.k = true;
        this.l = new a();
        this.m = false;
        g();
    }
}
