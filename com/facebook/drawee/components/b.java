package com.facebook.drawee.components;
/* loaded from: classes15.dex */
public class b {
    private boolean pBm;
    private int pBn;
    private int pBo;

    public b() {
        init();
    }

    public void init() {
        this.pBm = false;
        this.pBn = 4;
        reset();
    }

    public void reset() {
        this.pBo = 0;
    }

    public void Bk(boolean z) {
        this.pBm = z;
    }

    public boolean etL() {
        return this.pBm && this.pBo < this.pBn;
    }

    public void etM() {
        this.pBo++;
    }
}
