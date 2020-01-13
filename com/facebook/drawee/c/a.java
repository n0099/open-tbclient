package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes12.dex */
public class a {
    InterfaceC0649a lMO;
    final float lMP;
    boolean lMQ;
    boolean lMR;
    long lMS;
    float lMT;
    float lMU;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0649a {
        boolean dkM();
    }

    public a(Context context) {
        this.lMP = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gl(Context context) {
        return new a(context);
    }

    public void init() {
        this.lMO = null;
        reset();
    }

    public void reset() {
        this.lMQ = false;
        this.lMR = false;
    }

    public void a(InterfaceC0649a interfaceC0649a) {
        this.lMO = interfaceC0649a;
    }

    public boolean dlQ() {
        return this.lMQ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.lMQ = true;
                this.lMR = true;
                this.lMS = motionEvent.getEventTime();
                this.lMT = motionEvent.getX();
                this.lMU = motionEvent.getY();
                break;
            case 1:
                this.lMQ = false;
                if (Math.abs(motionEvent.getX() - this.lMT) > this.lMP || Math.abs(motionEvent.getY() - this.lMU) > this.lMP) {
                    this.lMR = false;
                }
                if (this.lMR && motionEvent.getEventTime() - this.lMS <= ViewConfiguration.getLongPressTimeout() && this.lMO != null) {
                    this.lMO.dkM();
                }
                this.lMR = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.lMT) > this.lMP || Math.abs(motionEvent.getY() - this.lMU) > this.lMP) {
                    this.lMR = false;
                    break;
                }
                break;
            case 3:
                this.lMQ = false;
                this.lMR = false;
                break;
        }
        return true;
    }
}
