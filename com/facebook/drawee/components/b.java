package com.facebook.drawee.components;
/* loaded from: classes12.dex */
public class b {
    private boolean lKb;
    private int lKc;
    private int lKd;

    public b() {
        init();
    }

    public void init() {
        this.lKb = false;
        this.lKc = 4;
        reset();
    }

    public void reset() {
        this.lKd = 0;
    }

    public void va(boolean z) {
        this.lKb = z;
    }

    public boolean dkE() {
        return this.lKb && this.lKd < this.lKc;
    }

    public void dkF() {
        this.lKd++;
    }
}
