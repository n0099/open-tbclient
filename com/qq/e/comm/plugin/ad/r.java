package com.qq.e.comm.plugin.ad;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ai;
/* loaded from: classes15.dex */
public class r implements GestureDetector.OnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    private final GestureDetector f11909a;

    /* renamed from: b  reason: collision with root package name */
    private int f11910b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private ai.a j;

    public r(Context context) {
        this(context, false);
    }

    public r(Context context, boolean z) {
        this.e = false;
        this.j = null;
        this.f11909a = new GestureDetector(context, this);
        int a2 = com.qq.e.comm.plugin.util.p.a(context);
        int b2 = com.qq.e.comm.plugin.util.p.b(context);
        if (z) {
            this.d = (GDTADManager.getInstance().getSM().getInteger("ad_scroll_event_filter_click_s_v_ratio", 10) * b2) / 100;
        } else {
            this.d = (GDTADManager.getInstance().getSM().getInteger("ad_scroll_event_filter_click_v_ratio", 5) * b2) / 100;
        }
        this.c = (GDTADManager.getInstance().getSM().getInteger("ad_scroll_event_filter_click_h_ratio", 10) * a2) / 100;
        if (GDTADManager.getInstance().getSM().getInteger("ad_scroll_event_filter_click_s_ratio", 0) != 0) {
            this.f11910b = ViewConfiguration.get(context).getScaledTouchSlop();
            this.c = this.f11910b;
            this.d = this.f11910b;
        }
        ai.a("手机像素 = 宽 " + a2 + " *  高 " + b2 + ", 阈值中，横向移动的像素 = " + this.c + " , 纵向移动的像素 = " + this.d, this.j);
    }

    public void a(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        if (this.f11909a != null) {
            this.f11909a.onTouchEvent(motionEvent);
        }
        this.h = (int) motionEvent.getX();
        this.i = (int) motionEvent.getY();
        ai.a("横向滑动了 " + Math.abs(this.h - this.f) + " 像素", this.j);
        ai.a("纵向滑动了 " + Math.abs(this.i - this.g) + " 像素", this.j);
        if (Math.abs(this.h - this.f) >= this.c) {
            this.e = false;
        }
        if (Math.abs(this.i - this.g) >= this.d) {
            this.e = false;
        }
    }

    public boolean a() {
        if (GDTADManager.getInstance().getSM().getInteger("ad_scroll_event_filter_click", 0) == 1) {
            ai.a("mIsInterceptClickedEvent=" + this.e + (this.e ? " , 响应点击事件" : " , 不响应点击事件"), this.j);
            return this.e;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (motionEvent != null) {
            this.f = (int) motionEvent.getX();
            this.g = (int) motionEvent.getY();
            ai.a("onDown(e)", this.j);
            this.e = true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        ai.a("onFling(e1, e2, velocityX, velocityY)", this.j);
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        ai.a("onLongPress(e)", this.j);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        ai.a("onScroll(e1, e2, distanceX, distanceY)", this.j);
        if (motionEvent != null && motionEvent2 != null) {
            if (Math.abs(motionEvent.getX() - motionEvent2.getX()) >= this.c) {
                this.e = false;
                return true;
            } else if (Math.abs(motionEvent.getY() - motionEvent2.getY()) >= this.d) {
                this.e = false;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        ai.a("onShowPress(e)", this.j);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        ai.a("onSingleTapUp(e)", this.j);
        return false;
    }
}
