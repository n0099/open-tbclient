package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float dxy;
    float dxz;
    InterfaceC0450a jWJ;
    final float jWK;
    boolean jWL;
    boolean jWM;
    long jWN;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0450a {
        boolean cCR();
    }

    public a(Context context) {
        this.jWK = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a ez(Context context) {
        return new a(context);
    }

    public void init() {
        this.jWJ = null;
        reset();
    }

    public void reset() {
        this.jWL = false;
        this.jWM = false;
    }

    public void a(InterfaceC0450a interfaceC0450a) {
        this.jWJ = interfaceC0450a;
    }

    public boolean cDV() {
        return this.jWL;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.jWL = true;
                this.jWM = true;
                this.jWN = motionEvent.getEventTime();
                this.dxy = motionEvent.getX();
                this.dxz = motionEvent.getY();
                break;
            case 1:
                this.jWL = false;
                if (Math.abs(motionEvent.getX() - this.dxy) > this.jWK || Math.abs(motionEvent.getY() - this.dxz) > this.jWK) {
                    this.jWM = false;
                }
                if (this.jWM && motionEvent.getEventTime() - this.jWN <= ViewConfiguration.getLongPressTimeout() && this.jWJ != null) {
                    this.jWJ.cCR();
                }
                this.jWM = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.dxy) > this.jWK || Math.abs(motionEvent.getY() - this.dxz) > this.jWK) {
                    this.jWM = false;
                    break;
                }
                break;
            case 3:
                this.jWL = false;
                this.jWM = false;
                break;
        }
        return true;
    }
}
