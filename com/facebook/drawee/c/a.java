package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float dmP;
    float dmQ;
    InterfaceC0431a jDR;
    final float jDS;
    boolean jDT;
    boolean jDU;
    long jDV;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0431a {
        boolean cuU();
    }

    public a(Context context) {
        this.jDS = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a eJ(Context context) {
        return new a(context);
    }

    public void init() {
        this.jDR = null;
        reset();
    }

    public void reset() {
        this.jDT = false;
        this.jDU = false;
    }

    public void a(InterfaceC0431a interfaceC0431a) {
        this.jDR = interfaceC0431a;
    }

    public boolean cvY() {
        return this.jDT;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.jDT = true;
                this.jDU = true;
                this.jDV = motionEvent.getEventTime();
                this.dmP = motionEvent.getX();
                this.dmQ = motionEvent.getY();
                break;
            case 1:
                this.jDT = false;
                if (Math.abs(motionEvent.getX() - this.dmP) > this.jDS || Math.abs(motionEvent.getY() - this.dmQ) > this.jDS) {
                    this.jDU = false;
                }
                if (this.jDU && motionEvent.getEventTime() - this.jDV <= ViewConfiguration.getLongPressTimeout() && this.jDR != null) {
                    this.jDR.cuU();
                }
                this.jDU = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.dmP) > this.jDS || Math.abs(motionEvent.getY() - this.dmQ) > this.jDS) {
                    this.jDU = false;
                    break;
                }
                break;
            case 3:
                this.jDT = false;
                this.jDU = false;
                break;
        }
        return true;
    }
}
