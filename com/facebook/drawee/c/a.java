package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float dAS;
    float dAT;
    InterfaceC0455a kdN;
    final float kdO;
    boolean kdP;
    boolean kdQ;
    long kdR;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0455a {
        boolean cFS();
    }

    public a(Context context) {
        this.kdO = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a eA(Context context) {
        return new a(context);
    }

    public void init() {
        this.kdN = null;
        reset();
    }

    public void reset() {
        this.kdP = false;
        this.kdQ = false;
    }

    public void a(InterfaceC0455a interfaceC0455a) {
        this.kdN = interfaceC0455a;
    }

    public boolean cGY() {
        return this.kdP;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.kdP = true;
                this.kdQ = true;
                this.kdR = motionEvent.getEventTime();
                this.dAS = motionEvent.getX();
                this.dAT = motionEvent.getY();
                break;
            case 1:
                this.kdP = false;
                if (Math.abs(motionEvent.getX() - this.dAS) > this.kdO || Math.abs(motionEvent.getY() - this.dAT) > this.kdO) {
                    this.kdQ = false;
                }
                if (this.kdQ && motionEvent.getEventTime() - this.kdR <= ViewConfiguration.getLongPressTimeout() && this.kdN != null) {
                    this.kdN.cFS();
                }
                this.kdQ = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.dAS) > this.kdO || Math.abs(motionEvent.getY() - this.dAT) > this.kdO) {
                    this.kdQ = false;
                    break;
                }
                break;
            case 3:
                this.kdP = false;
                this.kdQ = false;
                break;
        }
        return true;
    }
}
