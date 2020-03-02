package com.facebook.drawee.components;
/* loaded from: classes13.dex */
public class b {
    private boolean lKP;
    private int lKQ;
    private int lKR;

    public b() {
        init();
    }

    public void init() {
        this.lKP = false;
        this.lKQ = 4;
        reset();
    }

    public void reset() {
        this.lKR = 0;
    }

    public void ve(boolean z) {
        this.lKP = z;
    }

    public boolean dlV() {
        return this.lKP && this.lKR < this.lKQ;
    }

    public void dlW() {
        this.lKR++;
    }
}
