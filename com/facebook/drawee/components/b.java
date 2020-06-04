package com.facebook.drawee.components;
/* loaded from: classes13.dex */
public class b {
    private boolean mpg;
    private int mph;
    private int mpi;

    public b() {
        init();
    }

    public void init() {
        this.mpg = false;
        this.mph = 4;
        reset();
    }

    public void reset() {
        this.mpi = 0;
    }

    public void vZ(boolean z) {
        this.mpg = z;
    }

    public boolean dvQ() {
        return this.mpg && this.mpi < this.mph;
    }

    public void dvR() {
        this.mpi++;
    }
}
