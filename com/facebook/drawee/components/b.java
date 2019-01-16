package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean imc;
    private int imd;
    private int ime;

    public b() {
        init();
    }

    public void init() {
        this.imc = false;
        this.imd = 4;
        reset();
    }

    public void reset() {
        this.ime = 0;
    }

    public void oV(boolean z) {
        this.imc = z;
    }

    public boolean bVI() {
        return this.imc && this.ime < this.imd;
    }

    public void bVJ() {
        this.ime++;
    }
}
