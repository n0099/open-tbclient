package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes13.dex */
public class a {
    InterfaceC0722a lWT;
    final float lWU;
    boolean lWV;
    boolean lWW;
    long lWX;
    float lWY;
    float lWZ;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0722a {
        boolean dos();
    }

    public a(Context context) {
        this.lWU = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a fB(Context context) {
        return new a(context);
    }

    public void init() {
        this.lWT = null;
        reset();
    }

    public void reset() {
        this.lWV = false;
        this.lWW = false;
    }

    public void a(InterfaceC0722a interfaceC0722a) {
        this.lWT = interfaceC0722a;
    }

    public boolean dpx() {
        return this.lWV;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.lWV = true;
                this.lWW = true;
                this.lWX = motionEvent.getEventTime();
                this.lWY = motionEvent.getX();
                this.lWZ = motionEvent.getY();
                break;
            case 1:
                this.lWV = false;
                if (Math.abs(motionEvent.getX() - this.lWY) > this.lWU || Math.abs(motionEvent.getY() - this.lWZ) > this.lWU) {
                    this.lWW = false;
                }
                if (this.lWW && motionEvent.getEventTime() - this.lWX <= ViewConfiguration.getLongPressTimeout() && this.lWT != null) {
                    this.lWT.dos();
                }
                this.lWW = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.lWY) > this.lWU || Math.abs(motionEvent.getY() - this.lWZ) > this.lWU) {
                    this.lWW = false;
                    break;
                }
                break;
            case 3:
                this.lWV = false;
                this.lWW = false;
                break;
        }
        return true;
    }
}
