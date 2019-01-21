package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float bXQ;
    float bXR;
    InterfaceC0359a ioM;
    final float ioN;
    boolean ioO;
    boolean ioP;
    long ioQ;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0359a {
        boolean bVQ();
    }

    public a(Context context) {
        this.ioN = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a dq(Context context) {
        return new a(context);
    }

    public void init() {
        this.ioM = null;
        reset();
    }

    public void reset() {
        this.ioO = false;
        this.ioP = false;
    }

    public void a(InterfaceC0359a interfaceC0359a) {
        this.ioM = interfaceC0359a;
    }

    public boolean bWT() {
        return this.ioO;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.ioO = true;
                this.ioP = true;
                this.ioQ = motionEvent.getEventTime();
                this.bXQ = motionEvent.getX();
                this.bXR = motionEvent.getY();
                break;
            case 1:
                this.ioO = false;
                if (Math.abs(motionEvent.getX() - this.bXQ) > this.ioN || Math.abs(motionEvent.getY() - this.bXR) > this.ioN) {
                    this.ioP = false;
                }
                if (this.ioP && motionEvent.getEventTime() - this.ioQ <= ViewConfiguration.getLongPressTimeout() && this.ioM != null) {
                    this.ioM.bVQ();
                }
                this.ioP = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.bXQ) > this.ioN || Math.abs(motionEvent.getY() - this.bXR) > this.ioN) {
                    this.ioP = false;
                    break;
                }
                break;
            case 3:
                this.ioO = false;
                this.ioP = false;
                break;
        }
        return true;
    }
}
