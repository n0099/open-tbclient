package com.facebook.drawee.components;
/* loaded from: classes4.dex */
public class b {
    private boolean nnh;
    private int nni;
    private int nnj;

    public b() {
        init();
    }

    public void init() {
        this.nnh = false;
        this.nni = 4;
        reset();
    }

    public void reset() {
        this.nnj = 0;
    }

    public void xR(boolean z) {
        this.nnh = z;
    }

    public boolean dPK() {
        return this.nnh && this.nnj < this.nni;
    }

    public void dPL() {
        this.nnj++;
    }
}
