package com.facebook.drawee.components;
/* loaded from: classes13.dex */
public class b {
    private boolean mLi;
    private int mLj;
    private int mLk;

    public b() {
        init();
    }

    public void init() {
        this.mLi = false;
        this.mLj = 4;
        reset();
    }

    public void reset() {
        this.mLk = 0;
    }

    public void wv(boolean z) {
        this.mLi = z;
    }

    public boolean dAx() {
        return this.mLi && this.mLk < this.mLj;
    }

    public void dAy() {
        this.mLk++;
    }
}
