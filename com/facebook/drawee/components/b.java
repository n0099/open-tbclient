package com.facebook.drawee.components;
/* loaded from: classes15.dex */
public class b {
    private boolean nMS;
    private int nMT;
    private int nMU;

    public b() {
        init();
    }

    public void init() {
        this.nMS = false;
        this.nMT = 4;
        reset();
    }

    public void reset() {
        this.nMU = 0;
    }

    public void yJ(boolean z) {
        this.nMS = z;
    }

    public boolean dXC() {
        return this.nMS && this.nMU < this.nMT;
    }

    public void dXD() {
        this.nMU++;
    }
}
