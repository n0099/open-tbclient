package com.facebook.drawee.components;
/* loaded from: classes12.dex */
public class b {
    private boolean lKg;
    private int lKh;
    private int lKi;

    public b() {
        init();
    }

    public void init() {
        this.lKg = false;
        this.lKh = 4;
        reset();
    }

    public void reset() {
        this.lKi = 0;
    }

    public void va(boolean z) {
        this.lKg = z;
    }

    public boolean dkG() {
        return this.lKg && this.lKi < this.lKh;
    }

    public void dkH() {
        this.lKi++;
    }
}
