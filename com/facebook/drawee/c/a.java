package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes13.dex */
public class a {
    InterfaceC0657a lNN;
    final float lNO;
    boolean lNP;
    boolean lNQ;
    long lNR;
    float lNS;
    float lNT;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0657a {
        boolean dme();
    }

    public a(Context context) {
        this.lNO = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gk(Context context) {
        return new a(context);
    }

    public void init() {
        this.lNN = null;
        reset();
    }

    public void reset() {
        this.lNP = false;
        this.lNQ = false;
    }

    public void a(InterfaceC0657a interfaceC0657a) {
        this.lNN = interfaceC0657a;
    }

    public boolean dnh() {
        return this.lNP;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.lNP = true;
                this.lNQ = true;
                this.lNR = motionEvent.getEventTime();
                this.lNS = motionEvent.getX();
                this.lNT = motionEvent.getY();
                break;
            case 1:
                this.lNP = false;
                if (Math.abs(motionEvent.getX() - this.lNS) > this.lNO || Math.abs(motionEvent.getY() - this.lNT) > this.lNO) {
                    this.lNQ = false;
                }
                if (this.lNQ && motionEvent.getEventTime() - this.lNR <= ViewConfiguration.getLongPressTimeout() && this.lNN != null) {
                    this.lNN.dme();
                }
                this.lNQ = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.lNS) > this.lNO || Math.abs(motionEvent.getY() - this.lNT) > this.lNO) {
                    this.lNQ = false;
                    break;
                }
                break;
            case 3:
                this.lNP = false;
                this.lNQ = false;
                break;
        }
        return true;
    }
}
