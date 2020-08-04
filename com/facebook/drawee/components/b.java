package com.facebook.drawee.components;
/* loaded from: classes9.dex */
public class b {
    private boolean mTs;
    private int mTt;
    private int mTu;

    public b() {
        init();
    }

    public void init() {
        this.mTs = false;
        this.mTt = 4;
        reset();
    }

    public void reset() {
        this.mTu = 0;
    }

    public void xa(boolean z) {
        this.mTs = z;
    }

    public boolean dDK() {
        return this.mTs && this.mTu < this.mTt;
    }

    public void dDL() {
        this.mTu++;
    }
}
