package com.google.android.exoplayer2.text.e;

import android.text.Layout;
/* loaded from: classes4.dex */
final class e {
    private float Rl;
    private int backgroundColor;
    private int gJE;
    private String hz;
    private String id;
    private boolean mwV;
    private boolean mwW;
    private e mwZ;
    private Layout.Alignment mxa;
    private int mwX = -1;
    private int underline = -1;
    private int bold = -1;
    private int italic = -1;
    private int mwY = -1;

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dvM() {
        return this.mwX == 1;
    }

    public e vu(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mwZ == null);
        this.mwX = z ? 1 : 0;
        return this;
    }

    public boolean dvN() {
        return this.underline == 1;
    }

    public e vv(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mwZ == null);
        this.underline = z ? 1 : 0;
        return this;
    }

    public e vw(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mwZ == null);
        this.bold = z ? 1 : 0;
        return this;
    }

    public e vx(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mwZ == null);
        this.italic = z ? 1 : 0;
        return this;
    }

    public String dvO() {
        return this.hz;
    }

    public e PC(String str) {
        com.google.android.exoplayer2.util.a.checkState(this.mwZ == null);
        this.hz = str;
        return this;
    }

    public int getFontColor() {
        if (!this.mwV) {
            throw new IllegalStateException("Font color has not been defined.");
        }
        return this.gJE;
    }

    public e Lk(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mwZ == null);
        this.gJE = i;
        this.mwV = true;
        return this;
    }

    public boolean dvP() {
        return this.mwV;
    }

    public int getBackgroundColor() {
        if (!this.mwW) {
            throw new IllegalStateException("Background color has not been defined.");
        }
        return this.backgroundColor;
    }

    public e Ll(int i) {
        this.backgroundColor = i;
        this.mwW = true;
        return this;
    }

    public boolean dvQ() {
        return this.mwW;
    }

    public e b(e eVar) {
        return a(eVar, true);
    }

    private e a(e eVar, boolean z) {
        if (eVar != null) {
            if (!this.mwV && eVar.mwV) {
                Lk(eVar.gJE);
            }
            if (this.bold == -1) {
                this.bold = eVar.bold;
            }
            if (this.italic == -1) {
                this.italic = eVar.italic;
            }
            if (this.hz == null) {
                this.hz = eVar.hz;
            }
            if (this.mwX == -1) {
                this.mwX = eVar.mwX;
            }
            if (this.underline == -1) {
                this.underline = eVar.underline;
            }
            if (this.mxa == null) {
                this.mxa = eVar.mxa;
            }
            if (this.mwY == -1) {
                this.mwY = eVar.mwY;
                this.Rl = eVar.Rl;
            }
            if (z && !this.mwW && eVar.mwW) {
                Ll(eVar.backgroundColor);
            }
        }
        return this;
    }

    public e PD(String str) {
        this.id = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Layout.Alignment dvR() {
        return this.mxa;
    }

    public e a(Layout.Alignment alignment) {
        this.mxa = alignment;
        return this;
    }

    public e bz(float f) {
        this.Rl = f;
        return this;
    }

    public e Lm(int i) {
        this.mwY = i;
        return this;
    }

    public int dvS() {
        return this.mwY;
    }

    public float dvT() {
        return this.Rl;
    }
}
