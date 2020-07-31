package com.facebook.drawee.components;
/* loaded from: classes9.dex */
public class b {
    private boolean mTq;
    private int mTr;
    private int mTs;

    public b() {
        init();
    }

    public void init() {
        this.mTq = false;
        this.mTr = 4;
        reset();
    }

    public void reset() {
        this.mTs = 0;
    }

    public void xa(boolean z) {
        this.mTq = z;
    }

    public boolean dDJ() {
        return this.mTq && this.mTs < this.mTr;
    }

    public void dDK() {
        this.mTs++;
    }
}
