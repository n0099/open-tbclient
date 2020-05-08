package com.facebook.drawee.components;
/* loaded from: classes13.dex */
public class b {
    private boolean lUd;
    private int lUe;
    private int lUf;

    public b() {
        init();
    }

    public void init() {
        this.lUd = false;
        this.lUe = 4;
        reset();
    }

    public void reset() {
        this.lUf = 0;
    }

    public void vz(boolean z) {
        this.lUd = z;
    }

    public boolean doj() {
        return this.lUd && this.lUf < this.lUe;
    }

    public void dok() {
        this.lUf++;
    }
}
