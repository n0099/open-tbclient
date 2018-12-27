package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float bXe;
    float bXf;
    InterfaceC0360a inE;
    final float inF;
    boolean inG;
    boolean inH;
    long inI;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0360a {
        boolean bVi();
    }

    public a(Context context) {
        this.inF = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a dq(Context context) {
        return new a(context);
    }

    public void init() {
        this.inE = null;
        reset();
    }

    public void reset() {
        this.inG = false;
        this.inH = false;
    }

    public void a(InterfaceC0360a interfaceC0360a) {
        this.inE = interfaceC0360a;
    }

    public boolean bWl() {
        return this.inG;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.inG = true;
                this.inH = true;
                this.inI = motionEvent.getEventTime();
                this.bXe = motionEvent.getX();
                this.bXf = motionEvent.getY();
                break;
            case 1:
                this.inG = false;
                if (Math.abs(motionEvent.getX() - this.bXe) > this.inF || Math.abs(motionEvent.getY() - this.bXf) > this.inF) {
                    this.inH = false;
                }
                if (this.inH && motionEvent.getEventTime() - this.inI <= ViewConfiguration.getLongPressTimeout() && this.inE != null) {
                    this.inE.bVi();
                }
                this.inH = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.bXe) > this.inF || Math.abs(motionEvent.getY() - this.bXf) > this.inF) {
                    this.inH = false;
                    break;
                }
                break;
            case 3:
                this.inG = false;
                this.inH = false;
                break;
        }
        return true;
    }
}
