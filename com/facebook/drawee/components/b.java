package com.facebook.drawee.components;
/* loaded from: classes4.dex */
public class b {
    private int nnA;
    private int nnB;
    private boolean nnz;

    public b() {
        init();
    }

    public void init() {
        this.nnz = false;
        this.nnA = 4;
        reset();
    }

    public void reset() {
        this.nnB = 0;
    }

    public void xT(boolean z) {
        this.nnz = z;
    }

    public boolean dPT() {
        return this.nnz && this.nnB < this.nnA;
    }

    public void dPU() {
        this.nnB++;
    }
}
