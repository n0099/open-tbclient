package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    InterfaceC0561a keJ;
    final float keK;
    boolean keL;
    boolean keM;
    long keN;
    float keO;
    float keP;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0561a {
        boolean cDX();
    }

    public a(Context context) {
        this.keK = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a er(Context context) {
        return new a(context);
    }

    public void init() {
        this.keJ = null;
        reset();
    }

    public void reset() {
        this.keL = false;
        this.keM = false;
    }

    public void a(InterfaceC0561a interfaceC0561a) {
        this.keJ = interfaceC0561a;
    }

    public boolean cFc() {
        return this.keL;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.keL = true;
                this.keM = true;
                this.keN = motionEvent.getEventTime();
                this.keO = motionEvent.getX();
                this.keP = motionEvent.getY();
                break;
            case 1:
                this.keL = false;
                if (Math.abs(motionEvent.getX() - this.keO) > this.keK || Math.abs(motionEvent.getY() - this.keP) > this.keK) {
                    this.keM = false;
                }
                if (this.keM && motionEvent.getEventTime() - this.keN <= ViewConfiguration.getLongPressTimeout() && this.keJ != null) {
                    this.keJ.cDX();
                }
                this.keM = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.keO) > this.keK || Math.abs(motionEvent.getY() - this.keP) > this.keK) {
                    this.keM = false;
                    break;
                }
                break;
            case 3:
                this.keL = false;
                this.keM = false;
                break;
        }
        return true;
    }
}
