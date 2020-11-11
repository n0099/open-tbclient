package com.facebook.drawee.components;
/* loaded from: classes15.dex */
public class b {
    private boolean oNE;
    private int oNF;
    private int oNG;

    public b() {
        init();
    }

    public void init() {
        this.oNE = false;
        this.oNF = 4;
        reset();
    }

    public void reset() {
        this.oNG = 0;
    }

    public void Ac(boolean z) {
        this.oNE = z;
    }

    public boolean elp() {
        return this.oNE && this.oNG < this.oNF;
    }

    public void elq() {
        this.oNG++;
    }
}
