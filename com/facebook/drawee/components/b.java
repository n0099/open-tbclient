package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean ikV;
    private int ikW;
    private int ikX;

    public b() {
        init();
    }

    public void init() {
        this.ikV = false;
        this.ikW = 4;
        reset();
    }

    public void reset() {
        this.ikX = 0;
    }

    public void oU(boolean z) {
        this.ikV = z;
    }

    public boolean bVa() {
        return this.ikV && this.ikX < this.ikW;
    }

    public void bVb() {
        this.ikX++;
    }
}
