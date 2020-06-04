package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes13.dex */
public class a {
    InterfaceC0778a mrX;
    final float mrY;
    boolean mrZ;
    boolean msa;
    long msb;
    float msc;
    float msd;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0778a {
        boolean dvY();
    }

    public a(Context context) {
        this.mrY = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a fT(Context context) {
        return new a(context);
    }

    public void init() {
        this.mrX = null;
        reset();
    }

    public void reset() {
        this.mrZ = false;
        this.msa = false;
    }

    public void a(InterfaceC0778a interfaceC0778a) {
        this.mrX = interfaceC0778a;
    }

    public boolean dxd() {
        return this.mrZ;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mrZ = true;
                this.msa = true;
                this.msb = motionEvent.getEventTime();
                this.msc = motionEvent.getX();
                this.msd = motionEvent.getY();
                break;
            case 1:
                this.mrZ = false;
                if (Math.abs(motionEvent.getX() - this.msc) > this.mrY || Math.abs(motionEvent.getY() - this.msd) > this.mrY) {
                    this.msa = false;
                }
                if (this.msa && motionEvent.getEventTime() - this.msb <= ViewConfiguration.getLongPressTimeout() && this.mrX != null) {
                    this.mrX.dvY();
                }
                this.msa = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.msc) > this.mrY || Math.abs(motionEvent.getY() - this.msd) > this.mrY) {
                    this.msa = false;
                    break;
                }
                break;
            case 3:
                this.mrZ = false;
                this.msa = false;
                break;
        }
        return true;
    }
}
