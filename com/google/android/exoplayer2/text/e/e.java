package com.google.android.exoplayer2.text.e;

import android.text.Layout;
/* loaded from: classes5.dex */
final class e {
    private float Ro;
    private int backgroundColor;
    private int gMR;
    private String hz;
    private String id;
    private boolean mAO;
    private boolean mAP;
    private e mAS;
    private Layout.Alignment mAT;
    private int mAQ = -1;
    private int underline = -1;
    private int bold = -1;
    private int italic = -1;
    private int mAR = -1;

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dwZ() {
        return this.mAQ == 1;
    }

    public e vG(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mAS == null);
        this.mAQ = z ? 1 : 0;
        return this;
    }

    public boolean dxa() {
        return this.underline == 1;
    }

    public e vH(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mAS == null);
        this.underline = z ? 1 : 0;
        return this;
    }

    public e vI(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mAS == null);
        this.bold = z ? 1 : 0;
        return this;
    }

    public e vJ(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mAS == null);
        this.italic = z ? 1 : 0;
        return this;
    }

    public String dxb() {
        return this.hz;
    }

    public e PN(String str) {
        com.google.android.exoplayer2.util.a.checkState(this.mAS == null);
        this.hz = str;
        return this;
    }

    public int getFontColor() {
        if (!this.mAO) {
            throw new IllegalStateException("Font color has not been defined.");
        }
        return this.gMR;
    }

    public e Lt(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mAS == null);
        this.gMR = i;
        this.mAO = true;
        return this;
    }

    public boolean dxc() {
        return this.mAO;
    }

    public int getBackgroundColor() {
        if (!this.mAP) {
            throw new IllegalStateException("Background color has not been defined.");
        }
        return this.backgroundColor;
    }

    public e Lu(int i) {
        this.backgroundColor = i;
        this.mAP = true;
        return this;
    }

    public boolean dxd() {
        return this.mAP;
    }

    public e b(e eVar) {
        return a(eVar, true);
    }

    private e a(e eVar, boolean z) {
        if (eVar != null) {
            if (!this.mAO && eVar.mAO) {
                Lt(eVar.gMR);
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
            if (this.mAQ == -1) {
                this.mAQ = eVar.mAQ;
            }
            if (this.underline == -1) {
                this.underline = eVar.underline;
            }
            if (this.mAT == null) {
                this.mAT = eVar.mAT;
            }
            if (this.mAR == -1) {
                this.mAR = eVar.mAR;
                this.Ro = eVar.Ro;
            }
            if (z && !this.mAP && eVar.mAP) {
                Lu(eVar.backgroundColor);
            }
        }
        return this;
    }

    public e PO(String str) {
        this.id = str;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Layout.Alignment dxe() {
        return this.mAT;
    }

    public e a(Layout.Alignment alignment) {
        this.mAT = alignment;
        return this;
    }

    public e bz(float f) {
        this.Ro = f;
        return this;
    }

    public e Lv(int i) {
        this.mAR = i;
        return this;
    }

    public int dxf() {
        return this.mAR;
    }

    public float dxg() {
        return this.Ro;
    }
}
