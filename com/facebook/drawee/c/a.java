package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes13.dex */
public class a {
    InterfaceC0797a mNV;
    final float mNW;
    boolean mNX;
    boolean mNY;
    long mNZ;
    float mOa;
    float mOb;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0797a {
        boolean dAB();
    }

    public a(Context context) {
        this.mNW = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a fU(Context context) {
        return new a(context);
    }

    public void init() {
        this.mNV = null;
        reset();
    }

    public void reset() {
        this.mNX = false;
        this.mNY = false;
    }

    public void a(InterfaceC0797a interfaceC0797a) {
        this.mNV = interfaceC0797a;
    }

    public boolean dBF() {
        return this.mNX;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mNX = true;
                this.mNY = true;
                this.mNZ = motionEvent.getEventTime();
                this.mOa = motionEvent.getX();
                this.mOb = motionEvent.getY();
                break;
            case 1:
                this.mNX = false;
                if (Math.abs(motionEvent.getX() - this.mOa) > this.mNW || Math.abs(motionEvent.getY() - this.mOb) > this.mNW) {
                    this.mNY = false;
                }
                if (this.mNY && motionEvent.getEventTime() - this.mNZ <= ViewConfiguration.getLongPressTimeout() && this.mNV != null) {
                    this.mNV.dAB();
                }
                this.mNY = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.mOa) > this.mNW || Math.abs(motionEvent.getY() - this.mOb) > this.mNW) {
                    this.mNY = false;
                    break;
                }
                break;
            case 3:
                this.mNX = false;
                this.mNY = false;
                break;
        }
        return true;
    }
}
