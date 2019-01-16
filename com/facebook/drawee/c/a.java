package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float bXP;
    float bXQ;
    InterfaceC0359a ioL;
    final float ioM;
    boolean ioN;
    boolean ioO;
    long ioP;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0359a {
        boolean bVQ();
    }

    public a(Context context) {
        this.ioM = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a dq(Context context) {
        return new a(context);
    }

    public void init() {
        this.ioL = null;
        reset();
    }

    public void reset() {
        this.ioN = false;
        this.ioO = false;
    }

    public void a(InterfaceC0359a interfaceC0359a) {
        this.ioL = interfaceC0359a;
    }

    public boolean bWT() {
        return this.ioN;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ioN = true;
                this.ioO = true;
                this.ioP = motionEvent.getEventTime();
                this.bXP = motionEvent.getX();
                this.bXQ = motionEvent.getY();
                break;
            case 1:
                this.ioN = false;
                if (Math.abs(motionEvent.getX() - this.bXP) > this.ioM || Math.abs(motionEvent.getY() - this.bXQ) > this.ioM) {
                    this.ioO = false;
                }
                if (this.ioO && motionEvent.getEventTime() - this.ioP <= ViewConfiguration.getLongPressTimeout() && this.ioL != null) {
                    this.ioL.bVQ();
                }
                this.ioO = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.bXP) > this.ioM || Math.abs(motionEvent.getY() - this.bXQ) > this.ioM) {
                    this.ioO = false;
                    break;
                }
                break;
            case 3:
                this.ioN = false;
                this.ioO = false;
                break;
        }
        return true;
    }
}
