package com.facebook.drawee.components;
/* loaded from: classes13.dex */
public class b {
    private boolean lMG;
    private int lMH;
    private int lMI;

    public b() {
        init();
    }

    public void init() {
        this.lMG = false;
        this.lMH = 4;
        reset();
    }

    public void reset() {
        this.lMI = 0;
    }

    public void vl(boolean z) {
        this.lMG = z;
    }

    public boolean dmt() {
        return this.lMG && this.lMI < this.lMH;
    }

    public void dmu() {
        this.lMI++;
    }
}
