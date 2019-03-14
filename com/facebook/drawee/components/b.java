package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean jBP;
    private int jBQ;
    private int jBR;

    public b() {
        init();
    }

    public void init() {
        this.jBP = false;
        this.jBQ = 4;
        reset();
    }

    public void reset() {
        this.jBR = 0;
    }

    public void rq(boolean z) {
        this.jBP = z;
    }

    public boolean cuS() {
        return this.jBP && this.jBR < this.jBQ;
    }

    public void cuT() {
        this.jBR++;
    }
}
