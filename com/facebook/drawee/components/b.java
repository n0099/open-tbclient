package com.facebook.drawee.components;
/* loaded from: classes8.dex */
public class b {
    private boolean pep;
    private int peq;
    private int per;

    public b() {
        init();
    }

    public void init() {
        this.pep = false;
        this.peq = 4;
        reset();
    }

    public void reset() {
        this.per = 0;
    }

    public void AN(boolean z) {
        this.pep = z;
    }

    public boolean erc() {
        return this.pep && this.per < this.peq;
    }

    public void erd() {
        this.per++;
    }
}
