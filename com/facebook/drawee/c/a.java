package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes13.dex */
public class a {
    InterfaceC0798a mNY;
    final float mNZ;
    boolean mOa;
    boolean mOb;
    long mOc;
    float mOd;
    float mOe;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0798a {
        boolean dAF();
    }

    public a(Context context) {
        this.mNZ = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a fU(Context context) {
        return new a(context);
    }

    public void init() {
        this.mNY = null;
        reset();
    }

    public void reset() {
        this.mOa = false;
        this.mOb = false;
    }

    public void a(InterfaceC0798a interfaceC0798a) {
        this.mNY = interfaceC0798a;
    }

    public boolean dBJ() {
        return this.mOa;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mOa = true;
                this.mOb = true;
                this.mOc = motionEvent.getEventTime();
                this.mOd = motionEvent.getX();
                this.mOe = motionEvent.getY();
                break;
            case 1:
                this.mOa = false;
                if (Math.abs(motionEvent.getX() - this.mOd) > this.mNZ || Math.abs(motionEvent.getY() - this.mOe) > this.mNZ) {
                    this.mOb = false;
                }
                if (this.mOb && motionEvent.getEventTime() - this.mOc <= ViewConfiguration.getLongPressTimeout() && this.mNY != null) {
                    this.mNY.dAF();
                }
                this.mOb = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.mOd) > this.mNZ || Math.abs(motionEvent.getY() - this.mOe) > this.mNZ) {
                    this.mOb = false;
                    break;
                }
                break;
            case 3:
                this.mOa = false;
                this.mOb = false;
                break;
        }
        return true;
    }
}
