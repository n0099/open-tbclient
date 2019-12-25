package com.facebook.drawee.components;
/* loaded from: classes11.dex */
public class b {
    private boolean lGD;
    private int lGE;
    private int lGF;

    public b() {
        init();
    }

    public void init() {
        this.lGD = false;
        this.lGE = 4;
        reset();
    }

    public void reset() {
        this.lGF = 0;
    }

    public void uP(boolean z) {
        this.lGD = z;
    }

    public boolean djD() {
        return this.lGD && this.lGF < this.lGE;
    }

    public void djE() {
        this.lGF++;
    }
}
