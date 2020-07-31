package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes9.dex */
public class a {
    InterfaceC0807a mWh;
    final float mWi;
    boolean mWj;
    boolean mWk;
    long mWl;
    float mWm;
    float mWn;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0807a {
        boolean dDR();
    }

    public a(Context context) {
        this.mWi = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a fX(Context context) {
        return new a(context);
    }

    public void init() {
        this.mWh = null;
        reset();
    }

    public void reset() {
        this.mWj = false;
        this.mWk = false;
    }

    public void a(InterfaceC0807a interfaceC0807a) {
        this.mWh = interfaceC0807a;
    }

    public boolean dEV() {
        return this.mWj;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mWj = true;
                this.mWk = true;
                this.mWl = motionEvent.getEventTime();
                this.mWm = motionEvent.getX();
                this.mWn = motionEvent.getY();
                break;
            case 1:
                this.mWj = false;
                if (Math.abs(motionEvent.getX() - this.mWm) > this.mWi || Math.abs(motionEvent.getY() - this.mWn) > this.mWi) {
                    this.mWk = false;
                }
                if (this.mWk && motionEvent.getEventTime() - this.mWl <= ViewConfiguration.getLongPressTimeout() && this.mWh != null) {
                    this.mWh.dDR();
                }
                this.mWk = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.mWm) > this.mWi || Math.abs(motionEvent.getY() - this.mWn) > this.mWi) {
                    this.mWk = false;
                    break;
                }
                break;
            case 3:
                this.mWj = false;
                this.mWk = false;
                break;
        }
        return true;
    }
}
