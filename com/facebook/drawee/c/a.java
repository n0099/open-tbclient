package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float dmQ;
    float dmR;
    InterfaceC0431a jDS;
    final float jDT;
    boolean jDU;
    boolean jDV;
    long jDW;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0431a {
        boolean cuU();
    }

    public a(Context context) {
        this.jDT = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a eJ(Context context) {
        return new a(context);
    }

    public void init() {
        this.jDS = null;
        reset();
    }

    public void reset() {
        this.jDU = false;
        this.jDV = false;
    }

    public void a(InterfaceC0431a interfaceC0431a) {
        this.jDS = interfaceC0431a;
    }

    public boolean cvY() {
        return this.jDU;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.jDU = true;
                this.jDV = true;
                this.jDW = motionEvent.getEventTime();
                this.dmQ = motionEvent.getX();
                this.dmR = motionEvent.getY();
                break;
            case 1:
                this.jDU = false;
                if (Math.abs(motionEvent.getX() - this.dmQ) > this.jDT || Math.abs(motionEvent.getY() - this.dmR) > this.jDT) {
                    this.jDV = false;
                }
                if (this.jDV && motionEvent.getEventTime() - this.jDW <= ViewConfiguration.getLongPressTimeout() && this.jDS != null) {
                    this.jDS.cuU();
                }
                this.jDV = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.dmQ) > this.jDT || Math.abs(motionEvent.getY() - this.dmR) > this.jDT) {
                    this.jDV = false;
                    break;
                }
                break;
            case 3:
                this.jDU = false;
                this.jDV = false;
                break;
        }
        return true;
    }
}
