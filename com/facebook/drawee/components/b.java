package com.facebook.drawee.components;
/* loaded from: classes14.dex */
public class b {
    private boolean oPi;
    private int oPj;
    private int oPk;

    public b() {
        init();
    }

    public void init() {
        this.oPi = false;
        this.oPj = 4;
        reset();
    }

    public void reset() {
        this.oPk = 0;
    }

    public void Aj(boolean z) {
        this.oPi = z;
    }

    public boolean eln() {
        return this.oPi && this.oPk < this.oPj;
    }

    public void elo() {
        this.oPk++;
    }
}
