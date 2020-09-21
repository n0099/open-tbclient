package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes11.dex */
public class a {
    InterfaceC0862a nAp;
    final float nAq;
    boolean nAr;
    boolean nAs;
    long nAt;
    float nAu;
    float nAv;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0862a {
        boolean dTZ();
    }

    public a(Context context) {
        this.nAq = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gw(Context context) {
        return new a(context);
    }

    public void init() {
        this.nAp = null;
        reset();
    }

    public void reset() {
        this.nAr = false;
        this.nAs = false;
    }

    public void a(InterfaceC0862a interfaceC0862a) {
        this.nAp = interfaceC0862a;
    }

    public boolean dVc() {
        return this.nAr;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nAr = true;
                this.nAs = true;
                this.nAt = motionEvent.getEventTime();
                this.nAu = motionEvent.getX();
                this.nAv = motionEvent.getY();
                break;
            case 1:
                this.nAr = false;
                if (Math.abs(motionEvent.getX() - this.nAu) > this.nAq || Math.abs(motionEvent.getY() - this.nAv) > this.nAq) {
                    this.nAs = false;
                }
                if (this.nAs && motionEvent.getEventTime() - this.nAt <= ViewConfiguration.getLongPressTimeout() && this.nAp != null) {
                    this.nAp.dTZ();
                }
                this.nAs = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.nAu) > this.nAq || Math.abs(motionEvent.getY() - this.nAv) > this.nAq) {
                    this.nAs = false;
                    break;
                }
                break;
            case 3:
                this.nAr = false;
                this.nAs = false;
                break;
        }
        return true;
    }
}
