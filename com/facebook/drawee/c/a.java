package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes14.dex */
public class a {
    InterfaceC0974a oRX;
    final float oRY;
    boolean oRZ;
    boolean oSa;
    long oSb;
    float oSc;
    float oSd;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0974a {
        boolean elv();
    }

    public a(Context context) {
        this.oRY = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gW(Context context) {
        return new a(context);
    }

    public void init() {
        this.oRX = null;
        reset();
    }

    public void reset() {
        this.oRZ = false;
        this.oSa = false;
    }

    public void a(InterfaceC0974a interfaceC0974a) {
        this.oRX = interfaceC0974a;
    }

    public boolean emy() {
        return this.oRZ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.oRZ = true;
                this.oSa = true;
                this.oSb = motionEvent.getEventTime();
                this.oSc = motionEvent.getX();
                this.oSd = motionEvent.getY();
                break;
            case 1:
                this.oRZ = false;
                if (Math.abs(motionEvent.getX() - this.oSc) > this.oRY || Math.abs(motionEvent.getY() - this.oSd) > this.oRY) {
                    this.oSa = false;
                }
                if (this.oSa && motionEvent.getEventTime() - this.oSb <= ViewConfiguration.getLongPressTimeout() && this.oRX != null) {
                    this.oRX.elv();
                }
                this.oSa = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.oSc) > this.oRY || Math.abs(motionEvent.getY() - this.oSd) > this.oRY) {
                    this.oSa = false;
                    break;
                }
                break;
            case 3:
                this.oRZ = false;
                this.oSa = false;
                break;
        }
        return true;
    }
}
