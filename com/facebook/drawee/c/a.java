package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes12.dex */
public class a {
    InterfaceC0649a lMT;
    final float lMU;
    boolean lMV;
    boolean lMW;
    long lMX;
    float lMY;
    float lMZ;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0649a {
        boolean dkO();
    }

    public a(Context context) {
        this.lMU = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gl(Context context) {
        return new a(context);
    }

    public void init() {
        this.lMT = null;
        reset();
    }

    public void reset() {
        this.lMV = false;
        this.lMW = false;
    }

    public void a(InterfaceC0649a interfaceC0649a) {
        this.lMT = interfaceC0649a;
    }

    public boolean dlS() {
        return this.lMV;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.lMV = true;
                this.lMW = true;
                this.lMX = motionEvent.getEventTime();
                this.lMY = motionEvent.getX();
                this.lMZ = motionEvent.getY();
                break;
            case 1:
                this.lMV = false;
                if (Math.abs(motionEvent.getX() - this.lMY) > this.lMU || Math.abs(motionEvent.getY() - this.lMZ) > this.lMU) {
                    this.lMW = false;
                }
                if (this.lMW && motionEvent.getEventTime() - this.lMX <= ViewConfiguration.getLongPressTimeout() && this.lMT != null) {
                    this.lMT.dkO();
                }
                this.lMW = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.lMY) > this.lMU || Math.abs(motionEvent.getY() - this.lMZ) > this.lMU) {
                    this.lMW = false;
                    break;
                }
                break;
            case 3:
                this.lMV = false;
                this.lMW = false;
                break;
        }
        return true;
    }
}
