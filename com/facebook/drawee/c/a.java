package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float dmQ;
    float dmR;
    InterfaceC0338a jEF;
    final float jEG;
    boolean jEH;
    boolean jEI;
    long jEJ;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0338a {
        boolean cuY();
    }

    public a(Context context) {
        this.jEG = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a eL(Context context) {
        return new a(context);
    }

    public void init() {
        this.jEF = null;
        reset();
    }

    public void reset() {
        this.jEH = false;
        this.jEI = false;
    }

    public void a(InterfaceC0338a interfaceC0338a) {
        this.jEF = interfaceC0338a;
    }

    public boolean cwc() {
        return this.jEH;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.jEH = true;
                this.jEI = true;
                this.jEJ = motionEvent.getEventTime();
                this.dmQ = motionEvent.getX();
                this.dmR = motionEvent.getY();
                break;
            case 1:
                this.jEH = false;
                if (Math.abs(motionEvent.getX() - this.dmQ) > this.jEG || Math.abs(motionEvent.getY() - this.dmR) > this.jEG) {
                    this.jEI = false;
                }
                if (this.jEI && motionEvent.getEventTime() - this.jEJ <= ViewConfiguration.getLongPressTimeout() && this.jEF != null) {
                    this.jEF.cuY();
                }
                this.jEI = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.dmQ) > this.jEG || Math.abs(motionEvent.getY() - this.dmR) > this.jEG) {
                    this.jEI = false;
                    break;
                }
                break;
            case 3:
                this.jEH = false;
                this.jEI = false;
                break;
        }
        return true;
    }
}
