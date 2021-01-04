package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes15.dex */
public class a {
    InterfaceC1020a pyq;
    final float pyr;
    boolean pys;
    boolean pyt;
    long pyu;
    float pyv;
    float pyw;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC1020a {
        boolean evn();
    }

    public a(Context context) {
        this.pyr = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a ih(Context context) {
        return new a(context);
    }

    public void init() {
        this.pyq = null;
        reset();
    }

    public void reset() {
        this.pys = false;
        this.pyt = false;
    }

    public void a(InterfaceC1020a interfaceC1020a) {
        this.pyq = interfaceC1020a;
    }

    public boolean ewq() {
        return this.pys;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.pys = true;
                this.pyt = true;
                this.pyu = motionEvent.getEventTime();
                this.pyv = motionEvent.getX();
                this.pyw = motionEvent.getY();
                break;
            case 1:
                this.pys = false;
                if (Math.abs(motionEvent.getX() - this.pyv) > this.pyr || Math.abs(motionEvent.getY() - this.pyw) > this.pyr) {
                    this.pyt = false;
                }
                if (this.pyt && motionEvent.getEventTime() - this.pyu <= ViewConfiguration.getLongPressTimeout() && this.pyq != null) {
                    this.pyq.evn();
                }
                this.pyt = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.pyv) > this.pyr || Math.abs(motionEvent.getY() - this.pyw) > this.pyr) {
                    this.pyt = false;
                    break;
                }
                break;
            case 3:
                this.pys = false;
                this.pyt = false;
                break;
        }
        return true;
    }
}
