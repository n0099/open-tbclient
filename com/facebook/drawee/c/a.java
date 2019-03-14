package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float dmM;
    float dmN;
    boolean jEA;
    long jEB;
    InterfaceC0431a jEx;
    final float jEy;
    boolean jEz;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0431a {
        boolean cvb();
    }

    public a(Context context) {
        this.jEy = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a eK(Context context) {
        return new a(context);
    }

    public void init() {
        this.jEx = null;
        reset();
    }

    public void reset() {
        this.jEz = false;
        this.jEA = false;
    }

    public void a(InterfaceC0431a interfaceC0431a) {
        this.jEx = interfaceC0431a;
    }

    public boolean cwf() {
        return this.jEz;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.jEz = true;
                this.jEA = true;
                this.jEB = motionEvent.getEventTime();
                this.dmM = motionEvent.getX();
                this.dmN = motionEvent.getY();
                break;
            case 1:
                this.jEz = false;
                if (Math.abs(motionEvent.getX() - this.dmM) > this.jEy || Math.abs(motionEvent.getY() - this.dmN) > this.jEy) {
                    this.jEA = false;
                }
                if (this.jEA && motionEvent.getEventTime() - this.jEB <= ViewConfiguration.getLongPressTimeout() && this.jEx != null) {
                    this.jEx.cvb();
                }
                this.jEA = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.dmM) > this.jEy || Math.abs(motionEvent.getY() - this.dmN) > this.jEy) {
                    this.jEA = false;
                    break;
                }
                break;
            case 3:
                this.jEz = false;
                this.jEA = false;
                break;
        }
        return true;
    }
}
