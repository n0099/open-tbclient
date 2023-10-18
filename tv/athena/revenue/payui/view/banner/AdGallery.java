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
/* loaded from: classes2.dex */
public class AdGallery extends Gallery implements View.OnTouchListener {
    public final Handler a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public final BroadcastReceiver h;
    public boolean i;

    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                AdGallery.this.g = false;
                AdGallery.this.n();
            } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                AdGallery.this.g = true;
                AdGallery.this.o(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Handler {
        public WeakReference<AdGallery> a;

        public b(AdGallery adGallery) {
            this.a = new WeakReference<>(adGallery);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AdGallery adGallery = this.a.get();
            if (adGallery != null && message.what == 1 && adGallery.d) {
                if (adGallery.getSelectedItemPosition() >= adGallery.getCount() - 1) {
                    adGallery.setSelection(0, true);
                    adGallery.onKeyDown(21, null);
                } else {
                    adGallery.onKeyDown(22, null);
                }
                sendMessageDelayed(obtainMessage(1), adGallery.b);
            }
        }
    }

    public AdGallery(Context context) {
        super(context);
        this.a = new b(this);
        this.b = 10000;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = new a();
        this.i = false;
        g();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        this.f = z;
        o(false);
    }

    public void setAutoStart(boolean z) {
        this.c = z;
    }

    public void setFlipInterval(int i) {
        this.b = i;
    }

    public AdGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b(this);
        this.b = 10000;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = new a();
        this.i = false;
        g();
    }

    public final boolean h(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent2.getX() > motionEvent.getX() + 50.0f) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        if (1 != motionEvent.getAction() && 3 != motionEvent.getAction()) {
            l();
            return false;
        }
        k();
        return false;
    }

    public AdGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new b(this);
        this.b = 10000;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = true;
        this.h = new a();
        this.i = false;
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

    public void j() {
        k();
    }

    public void k() {
        this.e = true;
        n();
    }

    public void l() {
        this.e = false;
        n();
    }

    public final void n() {
        o(true);
    }

    @Override // android.widget.Gallery, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
        if (this.c) {
            k();
        }
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f = false;
        m();
        n();
    }

    public final void i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        getContext().registerReceiver(this.h, intentFilter, null, this.a);
        this.i = true;
        RLog.debug("AdGallery", "[onAttachedToWindow] mHasRegisterReceiver = " + this.i);
    }

    public final void m() {
        RLog.debug("AdGallery", "[onAttachedToWindow] mHasRegisterReceiver = " + this.i);
        if (this.i) {
            RLog.debug("AdGallery", "[onAttachedToWindow] unregisterReceiver");
            try {
                getContext().unregisterReceiver(this.h);
            } catch (Exception e) {
                RLog.error("AdGallery", "unregisterReceiver exception ", e);
            }
            this.i = false;
        }
    }

    public final void o(boolean z) {
        boolean z2;
        if (this.f && this.e && this.g) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != this.d) {
            if (z2) {
                setSelection(getSelectedItemPosition(), z);
                this.a.sendMessageDelayed(this.a.obtainMessage(1), this.b);
            } else {
                this.a.removeMessages(1);
            }
            this.d = z2;
        }
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        if (h(motionEvent, motionEvent2)) {
            i = 21;
        } else {
            i = 22;
        }
        onKeyDown(i, null);
        return true;
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }
}
