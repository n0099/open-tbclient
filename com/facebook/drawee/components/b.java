package com.facebook.drawee.components;
/* loaded from: classes4.dex */
public class b {
    private boolean pDR;
    private int pDS;
    private int pDT;

    public b() {
        init();
    }

    public void init() {
        this.pDR = false;
        this.pDS = 4;
        reset();
    }

    public void reset() {
        this.pDT = 0;
    }

    public void Bi(boolean z) {
        this.pDR = z;
    }

    public boolean euc() {
        return this.pDR && this.pDT < this.pDS;
    }

    public void eud() {
        this.pDT++;
    }
}
