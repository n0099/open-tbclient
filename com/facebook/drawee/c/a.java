package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class a {
    InterfaceC0865a nqr;
    final float nqs;
    boolean nqt;
    boolean nqu;
    long nqv;
    float nqw;
    float nqx;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0865a {
        boolean dQb();
    }

    public a(Context context) {
        this.nqs = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gq(Context context) {
        return new a(context);
    }

    public void init() {
        this.nqr = null;
        reset();
    }

    public void reset() {
        this.nqt = false;
        this.nqu = false;
    }

    public void a(InterfaceC0865a interfaceC0865a) {
        this.nqr = interfaceC0865a;
    }

    public boolean dRe() {
        return this.nqt;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nqt = true;
                this.nqu = true;
                this.nqv = motionEvent.getEventTime();
                this.nqw = motionEvent.getX();
                this.nqx = motionEvent.getY();
                break;
            case 1:
                this.nqt = false;
                if (Math.abs(motionEvent.getX() - this.nqw) > this.nqs || Math.abs(motionEvent.getY() - this.nqx) > this.nqs) {
                    this.nqu = false;
                }
                if (this.nqu && motionEvent.getEventTime() - this.nqv <= ViewConfiguration.getLongPressTimeout() && this.nqr != null) {
                    this.nqr.dQb();
                }
                this.nqu = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.nqw) > this.nqs || Math.abs(motionEvent.getY() - this.nqx) > this.nqs) {
                    this.nqu = false;
                    break;
                }
                break;
            case 3:
                this.nqt = false;
                this.nqu = false;
                break;
        }
        return true;
    }
}
