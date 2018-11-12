package com.facebook.drawee.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
public class a {
    float bTj;
    float bTk;
    InterfaceC0346a idf;
    final float idg;
    boolean idh;
    boolean idi;
    long idj;

    /* renamed from: com.facebook.drawee.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0346a {
        boolean bSm();
    }

    public a(Context context) {
        this.idg = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static a dm(Context context) {
        return new a(context);
    }

    public void init() {
        this.idf = null;
        reset();
    }

    public void reset() {
        this.idh = false;
        this.idi = false;
    }

    public void a(InterfaceC0346a interfaceC0346a) {
        this.idf = interfaceC0346a;
    }

    public boolean bTp() {
        return this.idh;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.idh = true;
                this.idi = true;
                this.idj = motionEvent.getEventTime();
                this.bTj = motionEvent.getX();
                this.bTk = motionEvent.getY();
                break;
            case 1:
                this.idh = false;
                if (Math.abs(motionEvent.getX() - this.bTj) > this.idg || Math.abs(motionEvent.getY() - this.bTk) > this.idg) {
                    this.idi = false;
                }
                if (this.idi && motionEvent.getEventTime() - this.idj <= ViewConfiguration.getLongPressTimeout() && this.idf != null) {
                    this.idf.bSm();
                }
                this.idi = false;
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.bTj) > this.idg || Math.abs(motionEvent.getY() - this.bTk) > this.idg) {
                    this.idi = false;
                    break;
                }
                break;
            case 3:
                this.idh = false;
                this.idi = false;
                break;
        }
        return true;
    }
}
