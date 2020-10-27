package com.facebook.drawee.components;
/* loaded from: classes15.dex */
public class b {
    private boolean oEl;
    private int oEm;
    private int oEn;

    public b() {
        init();
    }

    public void init() {
        this.oEl = false;
        this.oEm = 4;
        reset();
    }

    public void reset() {
        this.oEn = 0;
    }

    public void zR(boolean z) {
        this.oEl = z;
    }

    public boolean ehA() {
        return this.oEl && this.oEn < this.oEm;
    }

    public void ehB() {
        this.oEn++;
    }
}
