package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean jBj;
    private int jBk;
    private int jBl;

    public b() {
        init();
    }

    public void init() {
        this.jBj = false;
        this.jBk = 4;
        reset();
    }

    public void reset() {
        this.jBl = 0;
    }

    public void rq(boolean z) {
        this.jBj = z;
    }

    public boolean cuL() {
        return this.jBj && this.jBl < this.jBk;
    }

    public void cuM() {
        this.jBl++;
    }
}
