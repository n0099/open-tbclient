package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes15.dex */
public class a {
    InterfaceC0952a oHb;
    final float oHc;
    boolean oHd;
    boolean oHe;
    long oHf;
    float oHg;
    float oHh;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0952a {
        boolean ehI();
    }

    public a(Context context) {
        this.oHc = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gY(Context context) {
        return new a(context);
    }

    public void init() {
        this.oHb = null;
        reset();
    }

    public void reset() {
        this.oHd = false;
        this.oHe = false;
    }

    public void a(InterfaceC0952a interfaceC0952a) {
        this.oHb = interfaceC0952a;
    }

    public boolean eiL() {
        return this.oHd;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.oHd = true;
                this.oHe = true;
                this.oHf = motionEvent.getEventTime();
                this.oHg = motionEvent.getX();
                this.oHh = motionEvent.getY();
                break;
            case 1:
                this.oHd = false;
                if (Math.abs(motionEvent.getX() - this.oHg) > this.oHc || Math.abs(motionEvent.getY() - this.oHh) > this.oHc) {
                    this.oHe = false;
                }
                if (this.oHe && motionEvent.getEventTime() - this.oHf <= ViewConfiguration.getLongPressTimeout() && this.oHb != null) {
                    this.oHb.ehI();
                }
                this.oHe = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.oHg) > this.oHc || Math.abs(motionEvent.getY() - this.oHh) > this.oHc) {
                    this.oHe = false;
                    break;
                }
                break;
            case 3:
                this.oHd = false;
                this.oHe = false;
                break;
        }
        return true;
    }
}
