package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes13.dex */
public class a {
    InterfaceC0701a lWP;
    final float lWQ;
    boolean lWR;
    boolean lWS;
    long lWT;
    float lWU;
    float lWV;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0701a {
        boolean dou();
    }

    public a(Context context) {
        this.lWQ = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a fN(Context context) {
        return new a(context);
    }

    public void init() {
        this.lWP = null;
        reset();
    }

    public void reset() {
        this.lWR = false;
        this.lWS = false;
    }

    public void a(InterfaceC0701a interfaceC0701a) {
        this.lWP = interfaceC0701a;
    }

    public boolean dpz() {
        return this.lWR;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.lWR = true;
                this.lWS = true;
                this.lWT = motionEvent.getEventTime();
                this.lWU = motionEvent.getX();
                this.lWV = motionEvent.getY();
                break;
            case 1:
                this.lWR = false;
                if (Math.abs(motionEvent.getX() - this.lWU) > this.lWQ || Math.abs(motionEvent.getY() - this.lWV) > this.lWQ) {
                    this.lWS = false;
                }
                if (this.lWS && motionEvent.getEventTime() - this.lWT <= ViewConfiguration.getLongPressTimeout() && this.lWP != null) {
                    this.lWP.dou();
                }
                this.lWS = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.lWU) > this.lWQ || Math.abs(motionEvent.getY() - this.lWV) > this.lWQ) {
                    this.lWS = false;
                    break;
                }
                break;
            case 3:
                this.lWR = false;
                this.lWS = false;
                break;
        }
        return true;
    }
}
