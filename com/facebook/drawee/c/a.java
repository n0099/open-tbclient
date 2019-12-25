package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes11.dex */
public class a {
    InterfaceC0644a lJr;
    final float lJs;
    boolean lJt;
    boolean lJu;
    long lJv;
    float lJw;
    float lJx;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0644a {
        boolean djL();
    }

    public a(Context context) {
        this.lJs = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gk(Context context) {
        return new a(context);
    }

    public void init() {
        this.lJr = null;
        reset();
    }

    public void reset() {
        this.lJt = false;
        this.lJu = false;
    }

    public void a(InterfaceC0644a interfaceC0644a) {
        this.lJr = interfaceC0644a;
    }

    public boolean dkO() {
        return this.lJt;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.lJt = true;
                this.lJu = true;
                this.lJv = motionEvent.getEventTime();
                this.lJw = motionEvent.getX();
                this.lJx = motionEvent.getY();
                break;
            case 1:
                this.lJt = false;
                if (Math.abs(motionEvent.getX() - this.lJw) > this.lJs || Math.abs(motionEvent.getY() - this.lJx) > this.lJs) {
                    this.lJu = false;
                }
                if (this.lJu && motionEvent.getEventTime() - this.lJv <= ViewConfiguration.getLongPressTimeout() && this.lJr != null) {
                    this.lJr.djL();
                }
                this.lJu = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.lJw) > this.lJs || Math.abs(motionEvent.getY() - this.lJx) > this.lJs) {
                    this.lJu = false;
                    break;
                }
                break;
            case 3:
                this.lJt = false;
                this.lJu = false;
                break;
        }
        return true;
    }
}
