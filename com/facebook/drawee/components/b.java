package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean jTZ;
    private int jUa;
    private int jUb;

    public b() {
        init();
    }

    public void init() {
        this.jTZ = false;
        this.jUa = 4;
        reset();
    }

    public void reset() {
        this.jUb = 0;
    }

    public void sf(boolean z) {
        this.jTZ = z;
    }

    public boolean cCH() {
        return this.jTZ && this.jUb < this.jUa;
    }

    public void cCI() {
        this.jUb++;
    }
}
