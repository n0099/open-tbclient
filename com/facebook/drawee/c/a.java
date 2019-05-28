package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float dxy;
    float dxz;
    InterfaceC0450a jWG;
    final float jWH;
    boolean jWI;
    boolean jWJ;
    long jWK;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0450a {
        boolean cCS();
    }

    public a(Context context) {
        this.jWH = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a ez(Context context) {
        return new a(context);
    }

    public void init() {
        this.jWG = null;
        reset();
    }

    public void reset() {
        this.jWI = false;
        this.jWJ = false;
    }

    public void a(InterfaceC0450a interfaceC0450a) {
        this.jWG = interfaceC0450a;
    }

    public boolean cDW() {
        return this.jWI;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.jWI = true;
                this.jWJ = true;
                this.jWK = motionEvent.getEventTime();
                this.dxy = motionEvent.getX();
                this.dxz = motionEvent.getY();
                break;
            case 1:
                this.jWI = false;
                if (Math.abs(motionEvent.getX() - this.dxy) > this.jWH || Math.abs(motionEvent.getY() - this.dxz) > this.jWH) {
                    this.jWJ = false;
                }
                if (this.jWJ && motionEvent.getEventTime() - this.jWK <= ViewConfiguration.getLongPressTimeout() && this.jWG != null) {
                    this.jWG.cCS();
                }
                this.jWJ = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.dxy) > this.jWH || Math.abs(motionEvent.getY() - this.dxz) > this.jWH) {
                    this.jWJ = false;
                    break;
                }
                break;
            case 3:
                this.jWI = false;
                this.jWJ = false;
                break;
        }
        return true;
    }
}
