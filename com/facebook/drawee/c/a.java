package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class a {
    boolean pyA;
    long pyB;
    float pyC;
    float pyD;
    InterfaceC1058a pyx;
    final float pyy;
    boolean pyz;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1058a {
        boolean evu();
    }

    public a(Context context) {
        this.pyy = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a ih(Context context) {
        return new a(context);
    }

    public void init() {
        this.pyx = null;
        reset();
    }

    public void reset() {
        this.pyz = false;
        this.pyA = false;
    }

    public void a(InterfaceC1058a interfaceC1058a) {
        this.pyx = interfaceC1058a;
    }

    public boolean ewx() {
        return this.pyz;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.pyz = true;
                this.pyA = true;
                this.pyB = motionEvent.getEventTime();
                this.pyC = motionEvent.getX();
                this.pyD = motionEvent.getY();
                break;
            case 1:
                this.pyz = false;
                if (Math.abs(motionEvent.getX() - this.pyC) > this.pyy || Math.abs(motionEvent.getY() - this.pyD) > this.pyy) {
                    this.pyA = false;
                }
                if (this.pyA && motionEvent.getEventTime() - this.pyB <= ViewConfiguration.getLongPressTimeout() && this.pyx != null) {
                    this.pyx.evu();
                }
                this.pyA = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.pyC) > this.pyy || Math.abs(motionEvent.getY() - this.pyD) > this.pyy) {
                    this.pyA = false;
                    break;
                }
                break;
            case 3:
                this.pyz = false;
                this.pyA = false;
                break;
        }
        return true;
    }
}
