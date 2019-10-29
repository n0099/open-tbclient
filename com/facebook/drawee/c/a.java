package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    InterfaceC0561a kfA;
    final float kfB;
    boolean kfC;
    boolean kfD;
    long kfE;
    float kfF;
    float kfG;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0561a {
        boolean cDZ();
    }

    public a(Context context) {
        this.kfB = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a er(Context context) {
        return new a(context);
    }

    public void init() {
        this.kfA = null;
        reset();
    }

    public void reset() {
        this.kfC = false;
        this.kfD = false;
    }

    public void a(InterfaceC0561a interfaceC0561a) {
        this.kfA = interfaceC0561a;
    }

    public boolean cFe() {
        return this.kfC;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.kfC = true;
                this.kfD = true;
                this.kfE = motionEvent.getEventTime();
                this.kfF = motionEvent.getX();
                this.kfG = motionEvent.getY();
                break;
            case 1:
                this.kfC = false;
                if (Math.abs(motionEvent.getX() - this.kfF) > this.kfB || Math.abs(motionEvent.getY() - this.kfG) > this.kfB) {
                    this.kfD = false;
                }
                if (this.kfD && motionEvent.getEventTime() - this.kfE <= ViewConfiguration.getLongPressTimeout() && this.kfA != null) {
                    this.kfA.cDZ();
                }
                this.kfD = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.kfF) > this.kfB || Math.abs(motionEvent.getY() - this.kfG) > this.kfB) {
                    this.kfD = false;
                    break;
                }
                break;
            case 3:
                this.kfC = false;
                this.kfD = false;
                break;
        }
        return true;
    }
}
