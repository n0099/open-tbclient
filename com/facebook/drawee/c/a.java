package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class a {
    InterfaceC1041a ptW;
    final float ptX;
    boolean ptY;
    boolean ptZ;
    long pua;
    float pub;
    float puc;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1041a {
        boolean erB();
    }

    public a(Context context) {
        this.ptX = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    /* renamed from: if  reason: not valid java name */
    public static a m55if(Context context) {
        return new a(context);
    }

    public void init() {
        this.ptW = null;
        reset();
    }

    public void reset() {
        this.ptY = false;
        this.ptZ = false;
    }

    public void a(InterfaceC1041a interfaceC1041a) {
        this.ptW = interfaceC1041a;
    }

    public boolean esF() {
        return this.ptY;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ptY = true;
                this.ptZ = true;
                this.pua = motionEvent.getEventTime();
                this.pub = motionEvent.getX();
                this.puc = motionEvent.getY();
                break;
            case 1:
                this.ptY = false;
                if (Math.abs(motionEvent.getX() - this.pub) > this.ptX || Math.abs(motionEvent.getY() - this.puc) > this.ptX) {
                    this.ptZ = false;
                }
                if (this.ptZ && motionEvent.getEventTime() - this.pua <= ViewConfiguration.getLongPressTimeout() && this.ptW != null) {
                    this.ptW.erB();
                }
                this.ptZ = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.pub) > this.ptX || Math.abs(motionEvent.getY() - this.puc) > this.ptX) {
                    this.ptZ = false;
                    break;
                }
                break;
            case 3:
                this.ptY = false;
                this.ptZ = false;
                break;
        }
        return true;
    }
}
