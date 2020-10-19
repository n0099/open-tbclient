package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes15.dex */
public class a {
    InterfaceC0880a nPI;
    final float nPJ;
    boolean nPK;
    boolean nPL;
    long nPM;
    float nPN;
    float nPO;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0880a {
        boolean dXK();
    }

    public a(Context context) {
        this.nPJ = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gE(Context context) {
        return new a(context);
    }

    public void init() {
        this.nPI = null;
        reset();
    }

    public void reset() {
        this.nPK = false;
        this.nPL = false;
    }

    public void a(InterfaceC0880a interfaceC0880a) {
        this.nPI = interfaceC0880a;
    }

    public boolean dYN() {
        return this.nPK;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nPK = true;
                this.nPL = true;
                this.nPM = motionEvent.getEventTime();
                this.nPN = motionEvent.getX();
                this.nPO = motionEvent.getY();
                break;
            case 1:
                this.nPK = false;
                if (Math.abs(motionEvent.getX() - this.nPN) > this.nPJ || Math.abs(motionEvent.getY() - this.nPO) > this.nPJ) {
                    this.nPL = false;
                }
                if (this.nPL && motionEvent.getEventTime() - this.nPM <= ViewConfiguration.getLongPressTimeout() && this.nPI != null) {
                    this.nPI.dXK();
                }
                this.nPL = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.nPN) > this.nPJ || Math.abs(motionEvent.getY() - this.nPO) > this.nPJ) {
                    this.nPL = false;
                    break;
                }
                break;
            case 3:
                this.nPK = false;
                this.nPL = false;
                break;
        }
        return true;
    }
}
