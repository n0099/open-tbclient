package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean hYO;
    private int hYP;
    private int hYQ;

    public b() {
        init();
    }

    public void init() {
        this.hYO = false;
        this.hYP = 4;
        reset();
    }

    public void reset() {
        this.hYQ = 0;
    }

    public void oB(boolean z) {
        this.hYO = z;
    }

    public boolean bSJ() {
        return this.hYO && this.hYQ < this.hYP;
    }

    public void bSK() {
        this.hYQ++;
    }
}
