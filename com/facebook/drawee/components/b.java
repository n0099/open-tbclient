package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean jBE;
    private int jBF;
    private int jBG;

    public b() {
        init();
    }

    public void init() {
        this.jBE = false;
        this.jBF = 4;
        reset();
    }

    public void reset() {
        this.jBG = 0;
    }

    public void rq(boolean z) {
        this.jBE = z;
    }

    public boolean cuF() {
        return this.jBE && this.jBG < this.jBF;
    }

    public void cuG() {
        this.jBG++;
    }
}
