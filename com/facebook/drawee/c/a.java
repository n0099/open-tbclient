package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes15.dex */
public class a {
    float oQA;
    InterfaceC0971a oQu;
    final float oQv;
    boolean oQw;
    boolean oQx;
    long oQy;
    float oQz;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0971a {
        boolean elx();
    }

    public a(Context context) {
        this.oQv = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gY(Context context) {
        return new a(context);
    }

    public void init() {
        this.oQu = null;
        reset();
    }

    public void reset() {
        this.oQw = false;
        this.oQx = false;
    }

    public void a(InterfaceC0971a interfaceC0971a) {
        this.oQu = interfaceC0971a;
    }

    public boolean emA() {
        return this.oQw;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.oQw = true;
                this.oQx = true;
                this.oQy = motionEvent.getEventTime();
                this.oQz = motionEvent.getX();
                this.oQA = motionEvent.getY();
                break;
            case 1:
                this.oQw = false;
                if (Math.abs(motionEvent.getX() - this.oQz) > this.oQv || Math.abs(motionEvent.getY() - this.oQA) > this.oQv) {
                    this.oQx = false;
                }
                if (this.oQx && motionEvent.getEventTime() - this.oQy <= ViewConfiguration.getLongPressTimeout() && this.oQu != null) {
                    this.oQu.elx();
                }
                this.oQx = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.oQz) > this.oQv || Math.abs(motionEvent.getY() - this.oQA) > this.oQv) {
                    this.oQx = false;
                    break;
                }
                break;
            case 3:
                this.oQw = false;
                this.oQx = false;
                break;
        }
        return true;
    }
}
