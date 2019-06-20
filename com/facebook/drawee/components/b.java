package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean jUd;
    private int jUe;
    private int jUf;

    public b() {
        init();
    }

    public void init() {
        this.jUd = false;
        this.jUe = 4;
        reset();
    }

    public void reset() {
        this.jUf = 0;
    }

    public void sg(boolean z) {
        this.jUd = z;
    }

    public boolean cCI() {
        return this.jUd && this.jUf < this.jUe;
    }

    public void cCJ() {
        this.jUf++;
    }
}
