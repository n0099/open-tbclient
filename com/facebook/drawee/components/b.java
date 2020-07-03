package com.facebook.drawee.components;
/* loaded from: classes13.dex */
public class b {
    private boolean mLf;
    private int mLg;
    private int mLh;

    public b() {
        init();
    }

    public void init() {
        this.mLf = false;
        this.mLg = 4;
        reset();
    }

    public void reset() {
        this.mLh = 0;
    }

    public void wv(boolean z) {
        this.mLf = z;
    }

    public boolean dAt() {
        return this.mLf && this.mLh < this.mLg;
    }

    public void dAu() {
        this.mLh++;
    }
}
