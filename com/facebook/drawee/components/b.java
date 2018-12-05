package com.facebook.drawee.components;
/* loaded from: classes2.dex */
public class b {
    private boolean ihL;
    private int ihM;
    private int ihN;

    public b() {
        init();
    }

    public void init() {
        this.ihL = false;
        this.ihM = 4;
        reset();
    }

    public void reset() {
        this.ihN = 0;
    }

    public void oR(boolean z) {
        this.ihL = z;
    }

    public boolean bUk() {
        return this.ihL && this.ihN < this.ihM;
    }

    public void bUl() {
        this.ihN++;
    }
}
