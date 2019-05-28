package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean jUa;
    private int jUb;
    private int jUc;

    public b() {
        init();
    }

    public void init() {
        this.jUa = false;
        this.jUb = 4;
        reset();
    }

    public void reset() {
        this.jUc = 0;
    }

    public void sf(boolean z) {
        this.jUa = z;
    }

    public boolean cCJ() {
        return this.jUa && this.jUc < this.jUb;
    }

    public void cCK() {
        this.jUc++;
    }
}
