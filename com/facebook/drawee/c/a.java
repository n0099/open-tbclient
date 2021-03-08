package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes4.dex */
public class a {
    InterfaceC1062a pGK;
    final float pGL;
    boolean pGM;
    boolean pGN;
    long pGO;
    float pGP;
    float pGQ;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1062a {
        boolean euk();
    }

    public a(Context context) {
        this.pGL = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a ih(Context context) {
        return new a(context);
    }

    public void init() {
        this.pGK = null;
        reset();
    }

    public void reset() {
        this.pGM = false;
        this.pGN = false;
    }

    public void a(InterfaceC1062a interfaceC1062a) {
        this.pGK = interfaceC1062a;
    }

    public boolean evo() {
        return this.pGM;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.pGM = true;
                this.pGN = true;
                this.pGO = motionEvent.getEventTime();
                this.pGP = motionEvent.getX();
                this.pGQ = motionEvent.getY();
                break;
            case 1:
                this.pGM = false;
                if (Math.abs(motionEvent.getX() - this.pGP) > this.pGL || Math.abs(motionEvent.getY() - this.pGQ) > this.pGL) {
                    this.pGN = false;
                }
                if (this.pGN && motionEvent.getEventTime() - this.pGO <= ViewConfiguration.getLongPressTimeout() && this.pGK != null) {
                    this.pGK.euk();
                }
                this.pGN = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.pGP) > this.pGL || Math.abs(motionEvent.getY() - this.pGQ) > this.pGL) {
                    this.pGN = false;
                    break;
                }
                break;
            case 3:
                this.pGM = false;
                this.pGN = false;
                break;
        }
        return true;
    }
}
