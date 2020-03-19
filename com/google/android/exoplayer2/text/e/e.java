package com.google.android.exoplayer2.text.e;

import android.text.Layout;
/* loaded from: classes6.dex */
final class e {
    private float Th;
    private int backgroundColor;
    private int gQm;
    private String hC;
    private String id;
    private boolean mDq;
    private boolean mDr;
    private e mDu;
    private Layout.Alignment mDv;
    private int mDs = -1;
    private int underline = -1;
    private int bold = -1;
    private int italic = -1;
    private int mDt = -1;

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dyJ() {
        return this.mDs == 1;
    }

    public e vR(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mDu == null);
        this.mDs = z ? 1 : 0;
        return this;
    }

    public boolean dyK() {
        return this.underline == 1;
    }

    public e vS(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mDu == null);
        this.underline = z ? 1 : 0;
        return this;
    }

    public e vT(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mDu == null);
        this.bold = z ? 1 : 0;
        return this;
    }

    public e vU(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mDu == null);
        this.italic = z ? 1 : 0;
        return this;
    }

    public String dyL() {
        return this.hC;
    }

    public e Qb(String str) {
        com.google.android.exoplayer2.util.a.checkState(this.mDu == null);
        this.hC = str;
        return this;
    }

    public int getFontColor() {
        if (!this.mDq) {
            throw new IllegalStateException("Font color has not been defined.");
        }
        return this.gQm;
    }

    public e LE(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mDu == null);
        this.gQm = i;
        this.mDq = true;
        return this;
    }

    public boolean dyM() {
        return this.mDq;
    }

    public int getBackgroundColor() {
        if (!this.mDr) {
            throw new IllegalStateException("Background color has not been defined.");
        }
        return this.backgroundColor;
    }

    public e LF(int i) {
        this.backgroundColor = i;
        this.mDr = true;
        return this;
    }

    public boolean dyN() {
        return this.mDr;
    }

    public e b(e eVar) {
        return a(eVar, true);
    }

    private e a(e eVar, boolean z) {
        if (eVar != null) {
            if (!this.mDq && eVar.mDq) {
                LE(eVar.gQm);
            }
            if (this.bold == -1) {
                this.bold = eVar.bold;
            }
            if (this.italic == -1) {
                this.italic = eVar.italic;
            }
            if (this.hC == null) {
                this.hC = eVar.hC;
            }
            if (this.mDs == -1) {
                this.mDs = eVar.mDs;
            }
            if (this.underline == -1) {
                this.underline = eVar.underline;
            }
            if (this.mDv == null) {
                this.mDv = eVar.mDv;
            }
            if (this.mDt == -1) {
                this.mDt = eVar.mDt;
                this.Th = eVar.Th;
            }
            if (z && !this.mDr && eVar.mDr) {
                LF(eVar.backgroundColor);
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

    public Layout.Alignment dyO() {
        return this.mDv;
    }

    public e a(Layout.Alignment alignment) {
        this.mDv = alignment;
        return this;
    }

    public e by(float f) {
        this.Th = f;
        return this;
    }

    public e LG(int i) {
        this.mDt = i;
        return this;
    }

    public int dyP() {
        return this.mDt;
    }

    public float dyQ() {
        return this.Th;
    }
}
