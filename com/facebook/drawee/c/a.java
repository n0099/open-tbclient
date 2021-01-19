package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes3.dex */
public class a {
    InterfaceC1041a ptX;
    final float ptY;
    boolean ptZ;
    boolean pua;
    long pub;
    float puc;
    float pud;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1041a {
        boolean erB();
    }

    public a(Context context) {
        this.ptY = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    /* renamed from: if  reason: not valid java name */
    public static a m55if(Context context) {
        return new a(context);
    }

    public void init() {
        this.ptX = null;
        reset();
    }

    public void reset() {
        this.ptZ = false;
        this.pua = false;
    }

    public void a(InterfaceC1041a interfaceC1041a) {
        this.ptX = interfaceC1041a;
    }

    public boolean esF() {
        return this.ptZ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ptZ = true;
                this.pua = true;
                this.pub = motionEvent.getEventTime();
                this.puc = motionEvent.getX();
                this.pud = motionEvent.getY();
                break;
            case 1:
                this.ptZ = false;
                if (Math.abs(motionEvent.getX() - this.puc) > this.ptY || Math.abs(motionEvent.getY() - this.pud) > this.ptY) {
                    this.pua = false;
                }
                if (this.pua && motionEvent.getEventTime() - this.pub <= ViewConfiguration.getLongPressTimeout() && this.ptX != null) {
                    this.ptX.erB();
                }
                this.pua = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.puc) > this.ptY || Math.abs(motionEvent.getY() - this.pud) > this.ptY) {
                    this.pua = false;
                    break;
                }
                break;
            case 3:
                this.ptZ = false;
                this.pua = false;
                break;
        }
        return true;
    }
}
