package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes9.dex */
public class a {
    InterfaceC0807a mWj;
    final float mWk;
    boolean mWl;
    boolean mWm;
    long mWn;
    float mWo;
    float mWp;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0807a {
        boolean dDS();
    }

    public a(Context context) {
        this.mWk = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a fX(Context context) {
        return new a(context);
    }

    public void init() {
        this.mWj = null;
        reset();
    }

    public void reset() {
        this.mWl = false;
        this.mWm = false;
    }

    public void a(InterfaceC0807a interfaceC0807a) {
        this.mWj = interfaceC0807a;
    }

    public boolean dEW() {
        return this.mWl;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mWl = true;
                this.mWm = true;
                this.mWn = motionEvent.getEventTime();
                this.mWo = motionEvent.getX();
                this.mWp = motionEvent.getY();
                break;
            case 1:
                this.mWl = false;
                if (Math.abs(motionEvent.getX() - this.mWo) > this.mWk || Math.abs(motionEvent.getY() - this.mWp) > this.mWk) {
                    this.mWm = false;
                }
                if (this.mWm && motionEvent.getEventTime() - this.mWn <= ViewConfiguration.getLongPressTimeout() && this.mWj != null) {
                    this.mWj.dDS();
                }
                this.mWm = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.mWo) > this.mWk || Math.abs(motionEvent.getY() - this.mWp) > this.mWk) {
                    this.mWm = false;
                    break;
                }
                break;
            case 3:
                this.mWl = false;
                this.mWm = false;
                break;
        }
        return true;
    }
}
