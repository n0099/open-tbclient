package com.google.android.exoplayer2.text.e;

import android.text.Layout;
/* loaded from: classes6.dex */
final class e {
    private float SW;
    private int backgroundColor;
    private int gOR;
    private String hD;
    private String id;
    private Layout.Alignment mBA;
    private boolean mBv;
    private boolean mBw;
    private e mBz;
    private int mBx = -1;
    private int underline = -1;
    private int bold = -1;
    private int italic = -1;
    private int mBy = -1;

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dyj() {
        return this.mBx == 1;
    }

    public e vK(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mBz == null);
        this.mBx = z ? 1 : 0;
        return this;
    }

    public boolean dyk() {
        return this.underline == 1;
    }

    public e vL(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mBz == null);
        this.underline = z ? 1 : 0;
        return this;
    }

    public e vM(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mBz == null);
        this.bold = z ? 1 : 0;
        return this;
    }

    public e vN(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mBz == null);
        this.italic = z ? 1 : 0;
        return this;
    }

    public String dyl() {
        return this.hD;
    }

    public e Qa(String str) {
        com.google.android.exoplayer2.util.a.checkState(this.mBz == null);
        this.hD = str;
        return this;
    }

    public int getFontColor() {
        if (!this.mBv) {
            throw new IllegalStateException("Font color has not been defined.");
        }
        return this.gOR;
    }

    public e Ly(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mBz == null);
        this.gOR = i;
        this.mBv = true;
        return this;
    }

    public boolean dym() {
        return this.mBv;
    }

    public int getBackgroundColor() {
        if (!this.mBw) {
            throw new IllegalStateException("Background color has not been defined.");
        }
        return this.backgroundColor;
    }

    public e Lz(int i) {
        this.backgroundColor = i;
        this.mBw = true;
        return this;
    }

    public boolean dyn() {
        return this.mBw;
    }

    public e b(e eVar) {
        return a(eVar, true);
    }

    private e a(e eVar, boolean z) {
        if (eVar != null) {
            if (!this.mBv && eVar.mBv) {
                Ly(eVar.gOR);
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
            if (this.mBx == -1) {
                this.mBx = eVar.mBx;
            }
            if (this.underline == -1) {
                this.underline = eVar.underline;
            }
            if (this.mBA == null) {
                this.mBA = eVar.mBA;
            }
            if (this.mBy == -1) {
                this.mBy = eVar.mBy;
                this.SW = eVar.SW;
            }
            if (z && !this.mBw && eVar.mBw) {
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

    public Layout.Alignment dyo() {
        return this.mBA;
    }

    public e a(Layout.Alignment alignment) {
        this.mBA = alignment;
        return this;
    }

    public e by(float f) {
        this.SW = f;
        return this;
    }

    public e LA(int i) {
        this.mBy = i;
        return this;
    }

    public int dyp() {
        return this.mBy;
    }

    public float dyq() {
        return this.SW;
    }
}
