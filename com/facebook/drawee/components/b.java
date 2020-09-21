package com.facebook.drawee.components;
/* loaded from: classes11.dex */
public class b {
    private int nxA;
    private int nxB;
    private boolean nxz;

    public b() {
        init();
    }

    public void init() {
        this.nxz = false;
        this.nxA = 4;
        reset();
    }

    public void reset() {
        this.nxB = 0;
    }

    public void yc(boolean z) {
        this.nxz = z;
    }

    public boolean dTR() {
        return this.nxz && this.nxB < this.nxA;
    }

    public void dTS() {
        this.nxB++;
    }
}
