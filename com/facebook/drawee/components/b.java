package com.facebook.drawee.components;
/* loaded from: classes13.dex */
public class b {
    private boolean lLa;
    private int lLb;
    private int lLc;

    public b() {
        init();
    }

    public void init() {
        this.lLa = false;
        this.lLb = 4;
        reset();
    }

    public void reset() {
        this.lLc = 0;
    }

    public void ve(boolean z) {
        this.lLa = z;
    }

    public boolean dlW() {
        return this.lLa && this.lLc < this.lLb;
    }

    public void dlX() {
        this.lLc++;
    }
}
