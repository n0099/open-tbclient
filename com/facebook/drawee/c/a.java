package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float dCK;
    float dCL;
    InterfaceC0466a khr;
    final float khs;
    boolean kht;
    boolean khu;
    long khv;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0466a {
        boolean cHb();
    }

    public a(Context context) {
        this.khs = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a eC(Context context) {
        return new a(context);
    }

    public void init() {
        this.khr = null;
        reset();
    }

    public void reset() {
        this.kht = false;
        this.khu = false;
    }

    public void a(InterfaceC0466a interfaceC0466a) {
        this.khr = interfaceC0466a;
    }

    public boolean cIh() {
        return this.kht;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.kht = true;
                this.khu = true;
                this.khv = motionEvent.getEventTime();
                this.dCK = motionEvent.getX();
                this.dCL = motionEvent.getY();
                break;
            case 1:
                this.kht = false;
                if (Math.abs(motionEvent.getX() - this.dCK) > this.khs || Math.abs(motionEvent.getY() - this.dCL) > this.khs) {
                    this.khu = false;
                }
                if (this.khu && motionEvent.getEventTime() - this.khv <= ViewConfiguration.getLongPressTimeout() && this.khr != null) {
                    this.khr.cHb();
                }
                this.khu = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.dCK) > this.khs || Math.abs(motionEvent.getY() - this.dCL) > this.khs) {
                    this.khu = false;
                    break;
                }
                break;
            case 3:
                this.kht = false;
                this.khu = false;
                break;
        }
        return true;
    }
}
