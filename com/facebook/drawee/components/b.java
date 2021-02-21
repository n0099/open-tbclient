package com.facebook.drawee.components;
/* loaded from: classes15.dex */
public class b {
    private boolean pBM;
    private int pBN;
    private int pBO;

    public b() {
        init();
    }

    public void init() {
        this.pBM = false;
        this.pBN = 4;
        reset();
    }

    public void reset() {
        this.pBO = 0;
    }

    public void Bk(boolean z) {
        this.pBM = z;
    }

    public boolean etT() {
        return this.pBM && this.pBO < this.pBN;
    }

    public void etU() {
        this.pBO++;
    }
}
