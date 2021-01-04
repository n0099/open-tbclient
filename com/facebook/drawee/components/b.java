package com.facebook.drawee.components;
/* loaded from: classes15.dex */
public class b {
    private boolean pvx;
    private int pvy;
    private int pvz;

    public b() {
        init();
    }

    public void init() {
        this.pvx = false;
        this.pvy = 4;
        reset();
    }

    public void reset() {
        this.pvz = 0;
    }

    public void AV(boolean z) {
        this.pvx = z;
    }

    public boolean evf() {
        return this.pvx && this.pvz < this.pvy;
    }

    public void evg() {
        this.pvz++;
    }
}
