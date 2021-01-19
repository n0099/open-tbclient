package com.facebook.drawee.components;
/* loaded from: classes3.dex */
public class b {
    private boolean prd;
    private int pre;
    private int prf;

    public b() {
        init();
    }

    public void init() {
        this.prd = false;
        this.pre = 4;
        reset();
    }

    public void reset() {
        this.prf = 0;
    }

    public void AR(boolean z) {
        this.prd = z;
    }

    public boolean ert() {
        return this.prd && this.prf < this.pre;
    }

    public void eru() {
        this.prf++;
    }
}
