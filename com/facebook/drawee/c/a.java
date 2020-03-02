package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes13.dex */
public class a {
    InterfaceC0657a lNC;
    final float lND;
    boolean lNE;
    boolean lNF;
    long lNG;
    float lNH;
    float lNI;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0657a {
        boolean dmd();
    }

    public a(Context context) {
        this.lND = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gk(Context context) {
        return new a(context);
    }

    public void init() {
        this.lNC = null;
        reset();
    }

    public void reset() {
        this.lNE = false;
        this.lNF = false;
    }

    public void a(InterfaceC0657a interfaceC0657a) {
        this.lNC = interfaceC0657a;
    }

    public boolean dng() {
        return this.lNE;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.lNE = true;
                this.lNF = true;
                this.lNG = motionEvent.getEventTime();
                this.lNH = motionEvent.getX();
                this.lNI = motionEvent.getY();
                break;
            case 1:
                this.lNE = false;
                if (Math.abs(motionEvent.getX() - this.lNH) > this.lND || Math.abs(motionEvent.getY() - this.lNI) > this.lND) {
                    this.lNF = false;
                }
                if (this.lNF && motionEvent.getEventTime() - this.lNG <= ViewConfiguration.getLongPressTimeout() && this.lNC != null) {
                    this.lNC.dmd();
                }
                this.lNF = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.lNH) > this.lND || Math.abs(motionEvent.getY() - this.lNI) > this.lND) {
                    this.lNF = false;
                    break;
                }
                break;
            case 3:
                this.lNE = false;
                this.lNF = false;
                break;
        }
        return true;
    }
}
