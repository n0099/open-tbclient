package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float bSx;
    float bSy;
    InterfaceC0318a ibu;
    final float ibv;
    boolean ibw;
    boolean ibx;
    long iby;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0318a {
        boolean bSR();
    }

    public a(Context context) {
        this.ibv = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a dr(Context context) {
        return new a(context);
    }

    public void init() {
        this.ibu = null;
        reset();
    }

    public void reset() {
        this.ibw = false;
        this.ibx = false;
    }

    public void a(InterfaceC0318a interfaceC0318a) {
        this.ibu = interfaceC0318a;
    }

    public boolean bTU() {
        return this.ibw;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ibw = true;
                this.ibx = true;
                this.iby = motionEvent.getEventTime();
                this.bSx = motionEvent.getX();
                this.bSy = motionEvent.getY();
                break;
            case 1:
                this.ibw = false;
                if (Math.abs(motionEvent.getX() - this.bSx) > this.ibv || Math.abs(motionEvent.getY() - this.bSy) > this.ibv) {
                    this.ibx = false;
                }
                if (this.ibx && motionEvent.getEventTime() - this.iby <= ViewConfiguration.getLongPressTimeout() && this.ibu != null) {
                    this.ibu.bSR();
                }
                this.ibx = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.bSx) > this.ibv || Math.abs(motionEvent.getY() - this.bSy) > this.ibv) {
                    this.ibx = false;
                    break;
                }
                break;
            case 3:
                this.ibw = false;
                this.ibx = false;
                break;
        }
        return true;
    }
}
