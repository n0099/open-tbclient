package com.google.android.exoplayer2.text.e;

import android.text.Layout;
/* loaded from: classes6.dex */
final class e {
    private float SW;
    private int backgroundColor;
    private int gOT;
    private String hD;
    private String id;
    private e mBB;
    private Layout.Alignment mBC;
    private boolean mBx;
    private boolean mBy;
    private int mBz = -1;
    private int underline = -1;
    private int bold = -1;
    private int italic = -1;
    private int mBA = -1;

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dyl() {
        return this.mBz == 1;
    }

    public e vK(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mBB == null);
        this.mBz = z ? 1 : 0;
        return this;
    }

    public boolean dym() {
        return this.underline == 1;
    }

    public e vL(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mBB == null);
        this.underline = z ? 1 : 0;
        return this;
    }

    public e vM(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mBB == null);
        this.bold = z ? 1 : 0;
        return this;
    }

    public e vN(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mBB == null);
        this.italic = z ? 1 : 0;
        return this;
    }

    public String dyn() {
        return this.hD;
    }

    public e Qa(String str) {
        com.google.android.exoplayer2.util.a.checkState(this.mBB == null);
        this.hD = str;
        return this;
    }

    public int getFontColor() {
        if (!this.mBx) {
            throw new IllegalStateException("Font color has not been defined.");
        }
        return this.gOT;
    }

    public e Ly(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mBB == null);
        this.gOT = i;
        this.mBx = true;
        return this;
    }

    public boolean dyo() {
        return this.mBx;
    }

    public int getBackgroundColor() {
        if (!this.mBy) {
            throw new IllegalStateException("Background color has not been defined.");
        }
        return this.backgroundColor;
    }

    public e Lz(int i) {
        this.backgroundColor = i;
        this.mBy = true;
        return this;
    }

    public boolean dyp() {
        return this.mBy;
    }

    public e b(e eVar) {
        return a(eVar, true);
    }

    private e a(e eVar, boolean z) {
        if (eVar != null) {
            if (!this.mBx && eVar.mBx) {
                Ly(eVar.gOT);
            }
            if (this.bold == -1) {
                this.bold = eVar.bold;
            }
            if (this.italic == -1) {
                this.italic = eVar.italic;
            }
            if (this.hD == null) {
                this.hD = eVar.hD;
            }
            if (this.mBz == -1) {
                this.mBz = eVar.mBz;
            }
            if (this.underline == -1) {
                this.underline = eVar.underline;
            }
            if (this.mBC == null) {
                this.mBC = eVar.mBC;
            }
            if (this.mBA == -1) {
                this.mBA = eVar.mBA;
                this.SW = eVar.SW;
            }
            if (z && !this.mBy && eVar.mBy) {
                Lz(eVar.backgroundColor);
            }
        }
        return this;
    }

    public e Qb(String str) {
        this.id = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Layout.Alignment dyq() {
        return this.mBC;
    }

    public e a(Layout.Alignment alignment) {
        this.mBC = alignment;
        return this;
    }

    public e by(float f) {
        this.SW = f;
        return this;
    }

    public e LA(int i) {
        this.mBA = i;
        return this;
    }

    public int dyr() {
        return this.mBA;
    }

    public float dys() {
        return this.SW;
    }
}
