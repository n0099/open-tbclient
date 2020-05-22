package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes13.dex */
public class a {
    InterfaceC0777a mqN;
    final float mqO;
    boolean mqP;
    boolean mqQ;
    long mqR;
    float mqS;
    float mqT;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0777a {
        boolean dvK();
    }

    public a(Context context) {
        this.mqO = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a fT(Context context) {
        return new a(context);
    }

    public void init() {
        this.mqN = null;
        reset();
    }

    public void reset() {
        this.mqP = false;
        this.mqQ = false;
    }

    public void a(InterfaceC0777a interfaceC0777a) {
        this.mqN = interfaceC0777a;
    }

    public boolean dwP() {
        return this.mqP;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mqP = true;
                this.mqQ = true;
                this.mqR = motionEvent.getEventTime();
                this.mqS = motionEvent.getX();
                this.mqT = motionEvent.getY();
                break;
            case 1:
                this.mqP = false;
                if (Math.abs(motionEvent.getX() - this.mqS) > this.mqO || Math.abs(motionEvent.getY() - this.mqT) > this.mqO) {
                    this.mqQ = false;
                }
                if (this.mqQ && motionEvent.getEventTime() - this.mqR <= ViewConfiguration.getLongPressTimeout() && this.mqN != null) {
                    this.mqN.dvK();
                }
                this.mqQ = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.mqS) > this.mqO || Math.abs(motionEvent.getY() - this.mqT) > this.mqO) {
                    this.mqQ = false;
                    break;
                }
                break;
            case 3:
                this.mqP = false;
                this.mqQ = false;
                break;
        }
        return true;
    }
}
