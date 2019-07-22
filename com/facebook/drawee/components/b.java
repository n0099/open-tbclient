package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean kbh;
    private int kbi;
    private int kbj;

    public b() {
        init();
    }

    public void init() {
        this.kbh = false;
        this.kbi = 4;
        reset();
    }

    public void reset() {
        this.kbj = 0;
    }

    public void sv(boolean z) {
        this.kbh = z;
    }

    public boolean cFJ() {
        return this.kbh && this.kbj < this.kbi;
    }

    public void cFK() {
        this.kbj++;
    }
}
