package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes8.dex */
public class a {
    InterfaceC0991a phi;
    final float phj;
    boolean phk;
    boolean phl;
    long phm;
    float phn;
    float pho;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0991a {
        boolean erl();
    }

    public a(Context context) {
        this.phj = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a hF(Context context) {
        return new a(context);
    }

    public void init() {
        this.phi = null;
        reset();
    }

    public void reset() {
        this.phk = false;
        this.phl = false;
    }

    public void a(InterfaceC0991a interfaceC0991a) {
        this.phi = interfaceC0991a;
    }

    public boolean esn() {
        return this.phk;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.phk = true;
                this.phl = true;
                this.phm = motionEvent.getEventTime();
                this.phn = motionEvent.getX();
                this.pho = motionEvent.getY();
                break;
            case 1:
                this.phk = false;
                if (Math.abs(motionEvent.getX() - this.phn) > this.phj || Math.abs(motionEvent.getY() - this.pho) > this.phj) {
                    this.phl = false;
                }
                if (this.phl && motionEvent.getEventTime() - this.phm <= ViewConfiguration.getLongPressTimeout() && this.phi != null) {
                    this.phi.erl();
                }
                this.phl = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.phn) > this.phj || Math.abs(motionEvent.getY() - this.pho) > this.phj) {
                    this.phl = false;
                    break;
                }
                break;
            case 3:
                this.phk = false;
                this.phl = false;
                break;
        }
        return true;
    }
}
