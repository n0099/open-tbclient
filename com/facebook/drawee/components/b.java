package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean keL;
    private int keM;
    private int keN;

    public b() {
        init();
    }

    public void init() {
        this.keL = false;
        this.keM = 4;
        reset();
    }

    public void reset() {
        this.keN = 0;
    }

    public void sz(boolean z) {
        this.keL = z;
    }

    public boolean cGS() {
        return this.keL && this.keN < this.keM;
    }

    public void cGT() {
        this.keN++;
    }
}
