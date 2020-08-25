package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class a {
    InterfaceC0865a npZ;
    final float nqa;
    boolean nqb;
    boolean nqc;
    long nqd;
    float nqe;
    float nqf;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0865a {
        boolean dPS();
    }

    public a(Context context) {
        this.nqa = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a gq(Context context) {
        return new a(context);
    }

    public void init() {
        this.npZ = null;
        reset();
    }

    public void reset() {
        this.nqb = false;
        this.nqc = false;
    }

    public void a(InterfaceC0865a interfaceC0865a) {
        this.npZ = interfaceC0865a;
    }

    public boolean dQV() {
        return this.nqb;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nqb = true;
                this.nqc = true;
                this.nqd = motionEvent.getEventTime();
                this.nqe = motionEvent.getX();
                this.nqf = motionEvent.getY();
                break;
            case 1:
                this.nqb = false;
                if (Math.abs(motionEvent.getX() - this.nqe) > this.nqa || Math.abs(motionEvent.getY() - this.nqf) > this.nqa) {
                    this.nqc = false;
                }
                if (this.nqc && motionEvent.getEventTime() - this.nqd <= ViewConfiguration.getLongPressTimeout() && this.npZ != null) {
                    this.npZ.dPS();
                }
                this.nqc = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.nqe) > this.nqa || Math.abs(motionEvent.getY() - this.nqf) > this.nqa) {
                    this.nqc = false;
                    break;
                }
                break;
            case 3:
                this.nqb = false;
                this.nqc = false;
                break;
        }
        return true;
    }
}
