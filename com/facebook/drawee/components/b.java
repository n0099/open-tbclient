package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean kcn;
    private int kco;
    private int kcp;

    public b() {
        init();
    }

    public void init() {
        this.kcn = false;
        this.kco = 4;
        reset();
    }

    public void reset() {
        this.kcp = 0;
    }

    public void sw(boolean z) {
        this.kcn = z;
    }

    public boolean cGe() {
        return this.kcn && this.kcp < this.kco;
    }

    public void cGf() {
        this.kcp++;
    }
}
