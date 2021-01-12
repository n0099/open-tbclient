package com.facebook.drawee.components;
/* loaded from: classes3.dex */
public class b {
    private boolean prc;
    private int prd;
    private int pre;

    public b() {
        init();
    }

    public void init() {
        this.prc = false;
        this.prd = 4;
        reset();
    }

    public void reset() {
        this.pre = 0;
    }

    public void AR(boolean z) {
        this.prc = z;
    }

    public boolean ert() {
        return this.prc && this.pre < this.prd;
    }

    public void eru() {
        this.pre++;
    }
}
