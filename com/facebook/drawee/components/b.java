package com.facebook.drawee.components;
/* loaded from: classes8.dex */
public class b {
    private boolean per;
    private int pes;
    private int pet;

    public b() {
        init();
    }

    public void init() {
        this.per = false;
        this.pes = 4;
        reset();
    }

    public void reset() {
        this.pet = 0;
    }

    public void AN(boolean z) {
        this.per = z;
    }

    public boolean erd() {
        return this.per && this.pet < this.pes;
    }

    public void ere() {
        this.pet++;
    }
}
