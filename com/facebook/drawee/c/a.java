package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes15.dex */
public class a {
    InterfaceC1047a pEF;
    final float pEG;
    boolean pEH;
    boolean pEI;
    long pEJ;
    float pEK;
    float pEL;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC1047a {
        boolean eub();
    }

    public a(Context context) {
        this.pEG = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a ii(Context context) {
        return new a(context);
    }

    public void init() {
        this.pEF = null;
        reset();
    }

    public void reset() {
        this.pEH = false;
        this.pEI = false;
    }

    public void a(InterfaceC1047a interfaceC1047a) {
        this.pEF = interfaceC1047a;
    }

    public boolean evf() {
        return this.pEH;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.pEH = true;
                this.pEI = true;
                this.pEJ = motionEvent.getEventTime();
                this.pEK = motionEvent.getX();
                this.pEL = motionEvent.getY();
                break;
            case 1:
                this.pEH = false;
                if (Math.abs(motionEvent.getX() - this.pEK) > this.pEG || Math.abs(motionEvent.getY() - this.pEL) > this.pEG) {
                    this.pEI = false;
                }
                if (this.pEI && motionEvent.getEventTime() - this.pEJ <= ViewConfiguration.getLongPressTimeout() && this.pEF != null) {
                    this.pEF.eub();
                }
                this.pEI = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.pEK) > this.pEG || Math.abs(motionEvent.getY() - this.pEL) > this.pEG) {
                    this.pEI = false;
                    break;
                }
                break;
            case 3:
                this.pEH = false;
                this.pEI = false;
                break;
        }
        return true;
    }
}
