package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float dxx;
    float dxy;
    InterfaceC0450a jWF;
    final float jWG;
    boolean jWH;
    boolean jWI;
    long jWJ;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0450a {
        boolean cCQ();
    }

    public a(Context context) {
        this.jWG = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a ez(Context context) {
        return new a(context);
    }

    public void init() {
        this.jWF = null;
        reset();
    }

    public void reset() {
        this.jWH = false;
        this.jWI = false;
    }

    public void a(InterfaceC0450a interfaceC0450a) {
        this.jWF = interfaceC0450a;
    }

    public boolean cDU() {
        return this.jWH;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.jWH = true;
                this.jWI = true;
                this.jWJ = motionEvent.getEventTime();
                this.dxx = motionEvent.getX();
                this.dxy = motionEvent.getY();
                break;
            case 1:
                this.jWH = false;
                if (Math.abs(motionEvent.getX() - this.dxx) > this.jWG || Math.abs(motionEvent.getY() - this.dxy) > this.jWG) {
                    this.jWI = false;
                }
                if (this.jWI && motionEvent.getEventTime() - this.jWJ <= ViewConfiguration.getLongPressTimeout() && this.jWF != null) {
                    this.jWF.cCQ();
                }
                this.jWI = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.dxx) > this.jWG || Math.abs(motionEvent.getY() - this.dxy) > this.jWG) {
                    this.jWI = false;
                    break;
                }
                break;
            case 3:
                this.jWH = false;
                this.jWI = false;
                break;
        }
        return true;
    }
}
