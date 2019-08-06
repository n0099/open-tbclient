package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float dAZ;
    float dBa;
    InterfaceC0455a keU;
    final float keV;
    boolean keW;
    boolean keX;
    long keY;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0455a {
        boolean cGn();
    }

    public a(Context context) {
        this.keV = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a eB(Context context) {
        return new a(context);
    }

    public void init() {
        this.keU = null;
        reset();
    }

    public void reset() {
        this.keW = false;
        this.keX = false;
    }

    public void a(InterfaceC0455a interfaceC0455a) {
        this.keU = interfaceC0455a;
    }

    public boolean cHt() {
        return this.keW;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.keW = true;
                this.keX = true;
                this.keY = motionEvent.getEventTime();
                this.dAZ = motionEvent.getX();
                this.dBa = motionEvent.getY();
                break;
            case 1:
                this.keW = false;
                if (Math.abs(motionEvent.getX() - this.dAZ) > this.keV || Math.abs(motionEvent.getY() - this.dBa) > this.keV) {
                    this.keX = false;
                }
                if (this.keX && motionEvent.getEventTime() - this.keY <= ViewConfiguration.getLongPressTimeout() && this.keU != null) {
                    this.keU.cGn();
                }
                this.keX = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.dAZ) > this.keV || Math.abs(motionEvent.getY() - this.dBa) > this.keV) {
                    this.keX = false;
                    break;
                }
                break;
            case 3:
                this.keW = false;
                this.keX = false;
                break;
        }
        return true;
    }
}
