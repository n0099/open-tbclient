package com.facebook.drawee.components;
/* loaded from: classes13.dex */
public class b {
    private boolean lKN;
    private int lKO;
    private int lKP;

    public b() {
        init();
    }

    public void init() {
        this.lKN = false;
        this.lKO = 4;
        reset();
    }

    public void reset() {
        this.lKP = 0;
    }

    public void ve(boolean z) {
        this.lKN = z;
    }

    public boolean dlT() {
        return this.lKN && this.lKP < this.lKO;
    }

    public void dlU() {
        this.lKP++;
    }
}
