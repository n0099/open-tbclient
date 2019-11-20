package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean kcc;
    private int kcd;
    private int kce;

    public b() {
        init();
    }

    public void init() {
        this.kcc = false;
        this.kcd = 4;
        reset();
    }

    public void reset() {
        this.kce = 0;
    }

    public void se(boolean z) {
        this.kcc = z;
    }

    public boolean cDO() {
        return this.kcc && this.kce < this.kcd;
    }

    public void cDP() {
        this.kce++;
    }
}
