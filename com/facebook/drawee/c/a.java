package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float bXb;
    float bXc;
    InterfaceC0360a iks;
    final float ikt;
    boolean iku;
    boolean ikv;
    long ikw;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0360a {
        boolean bUr();
    }

    public a(Context context) {
        this.ikt = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a dq(Context context) {
        return new a(context);
    }

    public void init() {
        this.iks = null;
        reset();
    }

    public void reset() {
        this.iku = false;
        this.ikv = false;
    }

    public void a(InterfaceC0360a interfaceC0360a) {
        this.iks = interfaceC0360a;
    }

    public boolean bVu() {
        return this.iku;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.iku = true;
                this.ikv = true;
                this.ikw = motionEvent.getEventTime();
                this.bXb = motionEvent.getX();
                this.bXc = motionEvent.getY();
                break;
            case 1:
                this.iku = false;
                if (Math.abs(motionEvent.getX() - this.bXb) > this.ikt || Math.abs(motionEvent.getY() - this.bXc) > this.ikt) {
                    this.ikv = false;
                }
                if (this.ikv && motionEvent.getEventTime() - this.ikw <= ViewConfiguration.getLongPressTimeout() && this.iks != null) {
                    this.iks.bUr();
                }
                this.ikv = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.bXb) > this.ikt || Math.abs(motionEvent.getY() - this.bXc) > this.ikt) {
                    this.ikv = false;
                    break;
                }
                break;
            case 3:
                this.iku = false;
                this.ikv = false;
                break;
        }
        return true;
    }
}
