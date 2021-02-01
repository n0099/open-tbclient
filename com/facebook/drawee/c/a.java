package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes15.dex */
public class a {
    InterfaceC1045a pEf;
    final float pEg;
    boolean pEh;
    boolean pEi;
    long pEj;
    float pEk;
    float pEl;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC1045a {
        boolean etT();
    }

    public a(Context context) {
        this.pEg = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a ii(Context context) {
        return new a(context);
    }

    public void init() {
        this.pEf = null;
        reset();
    }

    public void reset() {
        this.pEh = false;
        this.pEi = false;
    }

    public void a(InterfaceC1045a interfaceC1045a) {
        this.pEf = interfaceC1045a;
    }

    public boolean euX() {
        return this.pEh;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.pEh = true;
                this.pEi = true;
                this.pEj = motionEvent.getEventTime();
                this.pEk = motionEvent.getX();
                this.pEl = motionEvent.getY();
                break;
            case 1:
                this.pEh = false;
                if (Math.abs(motionEvent.getX() - this.pEk) > this.pEg || Math.abs(motionEvent.getY() - this.pEl) > this.pEg) {
                    this.pEi = false;
                }
                if (this.pEi && motionEvent.getEventTime() - this.pEj <= ViewConfiguration.getLongPressTimeout() && this.pEf != null) {
                    this.pEf.etT();
                }
                this.pEi = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.pEk) > this.pEg || Math.abs(motionEvent.getY() - this.pEl) > this.pEg) {
                    this.pEi = false;
                    break;
                }
                break;
            case 3:
                this.pEh = false;
                this.pEi = false;
                break;
        }
        return true;
    }
}
