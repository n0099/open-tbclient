package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes8.dex */
public class a {
    InterfaceC0991a phg;
    final float phh;
    boolean phi;
    boolean phj;
    long phk;
    float phl;
    float phm;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0991a {
        boolean erk();
    }

    public a(Context context) {
        this.phh = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a hF(Context context) {
        return new a(context);
    }

    public void init() {
        this.phg = null;
        reset();
    }

    public void reset() {
        this.phi = false;
        this.phj = false;
    }

    public void a(InterfaceC0991a interfaceC0991a) {
        this.phg = interfaceC0991a;
    }

    public boolean esm() {
        return this.phi;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.phi = true;
                this.phj = true;
                this.phk = motionEvent.getEventTime();
                this.phl = motionEvent.getX();
                this.phm = motionEvent.getY();
                break;
            case 1:
                this.phi = false;
                if (Math.abs(motionEvent.getX() - this.phl) > this.phh || Math.abs(motionEvent.getY() - this.phm) > this.phh) {
                    this.phj = false;
                }
                if (this.phj && motionEvent.getEventTime() - this.phk <= ViewConfiguration.getLongPressTimeout() && this.phg != null) {
                    this.phg.erk();
                }
                this.phj = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.phl) > this.phh || Math.abs(motionEvent.getY() - this.phm) > this.phh) {
                    this.phj = false;
                    break;
                }
                break;
            case 3:
                this.phi = false;
                this.phj = false;
                break;
        }
        return true;
    }
}
