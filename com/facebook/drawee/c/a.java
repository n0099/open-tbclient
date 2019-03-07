package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float dmQ;
    float dmR;
    InterfaceC0335a jEm;
    final float jEn;
    boolean jEo;
    boolean jEp;
    long jEq;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0335a {
        boolean cuO();
    }

    public a(Context context) {
        this.jEn = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a eL(Context context) {
        return new a(context);
    }

    public void init() {
        this.jEm = null;
        reset();
    }

    public void reset() {
        this.jEo = false;
        this.jEp = false;
    }

    public void a(InterfaceC0335a interfaceC0335a) {
        this.jEm = interfaceC0335a;
    }

    public boolean cvS() {
        return this.jEo;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.jEo = true;
                this.jEp = true;
                this.jEq = motionEvent.getEventTime();
                this.dmQ = motionEvent.getX();
                this.dmR = motionEvent.getY();
                break;
            case 1:
                this.jEo = false;
                if (Math.abs(motionEvent.getX() - this.dmQ) > this.jEn || Math.abs(motionEvent.getY() - this.dmR) > this.jEn) {
                    this.jEp = false;
                }
                if (this.jEp && motionEvent.getEventTime() - this.jEq <= ViewConfiguration.getLongPressTimeout() && this.jEm != null) {
                    this.jEm.cuO();
                }
                this.jEp = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.dmQ) > this.jEn || Math.abs(motionEvent.getY() - this.dmR) > this.jEn) {
                    this.jEp = false;
                    break;
                }
                break;
            case 3:
                this.jEo = false;
                this.jEp = false;
                break;
        }
        return true;
    }
}
