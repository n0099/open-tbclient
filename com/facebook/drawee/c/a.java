package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes13.dex */
public class a {
    InterfaceC0657a lNA;
    final float lNB;
    boolean lNC;
    boolean lND;
    long lNE;
    float lNF;
    float lNG;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0657a {
        boolean dmb();
    }

    public a(Context context) {
        this.lNB = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gk(Context context) {
        return new a(context);
    }

    public void init() {
        this.lNA = null;
        reset();
    }

    public void reset() {
        this.lNC = false;
        this.lND = false;
    }

    public void a(InterfaceC0657a interfaceC0657a) {
        this.lNA = interfaceC0657a;
    }

    public boolean dne() {
        return this.lNC;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.lNC = true;
                this.lND = true;
                this.lNE = motionEvent.getEventTime();
                this.lNF = motionEvent.getX();
                this.lNG = motionEvent.getY();
                break;
            case 1:
                this.lNC = false;
                if (Math.abs(motionEvent.getX() - this.lNF) > this.lNB || Math.abs(motionEvent.getY() - this.lNG) > this.lNB) {
                    this.lND = false;
                }
                if (this.lND && motionEvent.getEventTime() - this.lNE <= ViewConfiguration.getLongPressTimeout() && this.lNA != null) {
                    this.lNA.dmb();
                }
                this.lND = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.lNF) > this.lNB || Math.abs(motionEvent.getY() - this.lNG) > this.lNB) {
                    this.lND = false;
                    break;
                }
                break;
            case 3:
                this.lNC = false;
                this.lND = false;
                break;
        }
        return true;
    }
}
