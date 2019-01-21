package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean imd;
    private int ime;
    private int imf;

    public b() {
        init();
    }

    public void init() {
        this.imd = false;
        this.ime = 4;
        reset();
    }

    public void reset() {
        this.imf = 0;
    }

    public void oV(boolean z) {
        this.imd = z;
    }

    public boolean bVI() {
        return this.imd && this.imf < this.ime;
    }

    public void bVJ() {
        this.imf++;
    }
}
