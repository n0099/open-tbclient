package com.facebook.drawee.components;
/* loaded from: classes4.dex */
public class b {
    private boolean pvE;
    private int pvF;
    private int pvG;

    public b() {
        init();
    }

    public void init() {
        this.pvE = false;
        this.pvF = 4;
        reset();
    }

    public void reset() {
        this.pvG = 0;
    }

    public void AV(boolean z) {
        this.pvE = z;
    }

    public boolean evm() {
        return this.pvE && this.pvG < this.pvF;
    }

    public void evn() {
        this.pvG++;
    }
}
