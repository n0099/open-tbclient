package com.facebook.drawee.components;
/* loaded from: classes13.dex */
public class b {
    private boolean lTZ;
    private int lUa;
    private int lUb;

    public b() {
        init();
    }

    public void init() {
        this.lTZ = false;
        this.lUa = 4;
        reset();
    }

    public void reset() {
        this.lUb = 0;
    }

    public void vz(boolean z) {
        this.lTZ = z;
    }

    public boolean dom() {
        return this.lTZ && this.lUb < this.lUa;
    }

    public void don() {
        this.lUb++;
    }
}
