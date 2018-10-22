package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float bSx;
    float bSy;
    InterfaceC0318a ibv;
    final float ibw;
    boolean ibx;
    boolean iby;
    long ibz;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0318a {
        boolean bSR();
    }

    public a(Context context) {
        this.ibw = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a dr(Context context) {
        return new a(context);
    }

    public void init() {
        this.ibv = null;
        reset();
    }

    public void reset() {
        this.ibx = false;
        this.iby = false;
    }

    public void a(InterfaceC0318a interfaceC0318a) {
        this.ibv = interfaceC0318a;
    }

    public boolean bTU() {
        return this.ibx;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ibx = true;
                this.iby = true;
                this.ibz = motionEvent.getEventTime();
                this.bSx = motionEvent.getX();
                this.bSy = motionEvent.getY();
                break;
            case 1:
                this.ibx = false;
                if (Math.abs(motionEvent.getX() - this.bSx) > this.ibw || Math.abs(motionEvent.getY() - this.bSy) > this.ibw) {
                    this.iby = false;
                }
                if (this.iby && motionEvent.getEventTime() - this.ibz <= ViewConfiguration.getLongPressTimeout() && this.ibv != null) {
                    this.ibv.bSR();
                }
                this.iby = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.bSx) > this.ibw || Math.abs(motionEvent.getY() - this.bSy) > this.ibw) {
                    this.iby = false;
                    break;
                }
                break;
            case 3:
                this.ibx = false;
                this.iby = false;
                break;
        }
        return true;
    }
}
