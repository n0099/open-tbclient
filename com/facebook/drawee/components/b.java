package com.facebook.drawee.components;
/* loaded from: classes13.dex */
public class b {
    private boolean mnV;
    private int mnW;
    private int mnX;

    public b() {
        init();
    }

    public void init() {
        this.mnV = false;
        this.mnW = 4;
        reset();
    }

    public void reset() {
        this.mnX = 0;
    }

    public void vX(boolean z) {
        this.mnV = z;
    }

    public boolean dvC() {
        return this.mnV && this.mnX < this.mnW;
    }

    public void dvD() {
        this.mnX++;
    }
}
