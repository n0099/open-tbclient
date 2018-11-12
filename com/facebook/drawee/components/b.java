package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private int iaA;
    private boolean iay;
    private int iaz;

    public b() {
        init();
    }

    public void init() {
        this.iay = false;
        this.iaz = 4;
        reset();
    }

    public void reset() {
        this.iaA = 0;
    }

    public void oP(boolean z) {
        this.iay = z;
    }

    public boolean bSe() {
        return this.iay && this.iaA < this.iaz;
    }

    public void bSf() {
        this.iaA++;
    }
}
