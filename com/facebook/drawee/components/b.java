package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean jBX;
    private int jBY;
    private int jBZ;

    public b() {
        init();
    }

    public void init() {
        this.jBX = false;
        this.jBY = 4;
        reset();
    }

    public void reset() {
        this.jBZ = 0;
    }

    public void rq(boolean z) {
        this.jBX = z;
    }

    public boolean cuP() {
        return this.jBX && this.jBZ < this.jBY;
    }

    public void cuQ() {
        this.jBZ++;
    }
}
