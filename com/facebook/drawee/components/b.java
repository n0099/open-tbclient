package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean hYN;
    private int hYO;
    private int hYP;

    public b() {
        init();
    }

    public void init() {
        this.hYN = false;
        this.hYO = 4;
        reset();
    }

    public void reset() {
        this.hYP = 0;
    }

    public void oB(boolean z) {
        this.hYN = z;
    }

    public boolean bSJ() {
        return this.hYN && this.hYP < this.hYO;
    }

    public void bSK() {
        this.hYP++;
    }
}
