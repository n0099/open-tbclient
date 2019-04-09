package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean jBk;
    private int jBl;
    private int jBm;

    public b() {
        init();
    }

    public void init() {
        this.jBk = false;
        this.jBl = 4;
        reset();
    }

    public void reset() {
        this.jBm = 0;
    }

    public void rq(boolean z) {
        this.jBk = z;
    }

    public boolean cuL() {
        return this.jBk && this.jBm < this.jBl;
    }

    public void cuM() {
        this.jBm++;
    }
}
