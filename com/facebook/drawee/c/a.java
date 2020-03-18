package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes13.dex */
public class a {
    InterfaceC0658a lPt;
    final float lPu;
    boolean lPv;
    boolean lPw;
    long lPx;
    float lPy;
    float lPz;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0658a {
        boolean dmB();
    }

    public a(Context context) {
        this.lPu = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gj(Context context) {
        return new a(context);
    }

    public void init() {
        this.lPt = null;
        reset();
    }

    public void reset() {
        this.lPv = false;
        this.lPw = false;
    }

    public void a(InterfaceC0658a interfaceC0658a) {
        this.lPt = interfaceC0658a;
    }

    public boolean dnF() {
        return this.lPv;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.lPv = true;
                this.lPw = true;
                this.lPx = motionEvent.getEventTime();
                this.lPy = motionEvent.getX();
                this.lPz = motionEvent.getY();
                break;
            case 1:
                this.lPv = false;
                if (Math.abs(motionEvent.getX() - this.lPy) > this.lPu || Math.abs(motionEvent.getY() - this.lPz) > this.lPu) {
                    this.lPw = false;
                }
                if (this.lPw && motionEvent.getEventTime() - this.lPx <= ViewConfiguration.getLongPressTimeout() && this.lPt != null) {
                    this.lPt.dmB();
                }
                this.lPw = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.lPy) > this.lPu || Math.abs(motionEvent.getY() - this.lPz) > this.lPu) {
                    this.lPw = false;
                    break;
                }
                break;
            case 3:
                this.lPv = false;
                this.lPw = false;
                break;
        }
        return true;
    }
}
