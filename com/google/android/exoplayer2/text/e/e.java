package com.google.android.exoplayer2.text.e;

import android.text.Layout;
/* loaded from: classes6.dex */
final class e {
    private float SW;
    private int backgroundColor;
    private int gPf;
    private String hD;
    private String id;
    private boolean mBI;
    private boolean mBJ;
    private e mBM;
    private Layout.Alignment mBN;
    private int mBK = -1;
    private int underline = -1;
    private int bold = -1;
    private int italic = -1;
    private int mBL = -1;

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dym() {
        return this.mBK == 1;
    }

    public e vK(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mBM == null);
        this.mBK = z ? 1 : 0;
        return this;
    }

    public boolean dyn() {
        return this.underline == 1;
    }

    public e vL(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mBM == null);
        this.underline = z ? 1 : 0;
        return this;
    }

    public e vM(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mBM == null);
        this.bold = z ? 1 : 0;
        return this;
    }

    public e vN(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mBM == null);
        this.italic = z ? 1 : 0;
        return this;
    }

    public String dyo() {
        return this.hD;
    }

    public e Qb(String str) {
        com.google.android.exoplayer2.util.a.checkState(this.mBM == null);
        this.hD = str;
        return this;
    }

    public int getFontColor() {
        if (!this.mBI) {
            throw new IllegalStateException("Font color has not been defined.");
        }
        return this.gPf;
    }

    public e Ly(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mBM == null);
        this.gPf = i;
        this.mBI = true;
        return this;
    }

    public boolean dyp() {
        return this.mBI;
    }

    public int getBackgroundColor() {
        if (!this.mBJ) {
            throw new IllegalStateException("Background color has not been defined.");
        }
        return this.backgroundColor;
    }

    public e Lz(int i) {
        this.backgroundColor = i;
        this.mBJ = true;
        return this;
    }

    public boolean dyq() {
        return this.mBJ;
    }

    public e b(e eVar) {
        return a(eVar, true);
    }

    private e a(e eVar, boolean z) {
        if (eVar != null) {
            if (!this.mBI && eVar.mBI) {
                Ly(eVar.gPf);
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
            if (this.mBK == -1) {
                this.mBK = eVar.mBK;
            }
            if (this.underline == -1) {
                this.underline = eVar.underline;
            }
            if (this.mBN == null) {
                this.mBN = eVar.mBN;
            }
            if (this.mBL == -1) {
                this.mBL = eVar.mBL;
                this.SW = eVar.SW;
            }
            if (z && !this.mBJ && eVar.mBJ) {
                Lz(eVar.backgroundColor);
            }
        }
        return this;
    }

    public e Qc(String str) {
        this.id = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Layout.Alignment dyr() {
        return this.mBN;
    }

    public e a(Layout.Alignment alignment) {
        this.mBN = alignment;
        return this;
    }

    public e by(float f) {
        this.SW = f;
        return this;
    }

    public e LA(int i) {
        this.mBL = i;
        return this;
    }

    public int dys() {
        return this.mBL;
    }

    public float dyt() {
        return this.SW;
    }
}
