package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean kcT;
    private int kcU;
    private int kcV;

    public b() {
        init();
    }

    public void init() {
        this.kcT = false;
        this.kcU = 4;
        reset();
    }

    public void reset() {
        this.kcV = 0;
    }

    public void se(boolean z) {
        this.kcT = z;
    }

    public boolean cDQ() {
        return this.kcT && this.kcV < this.kcU;
    }

    public void cDR() {
        this.kcV++;
    }
}
