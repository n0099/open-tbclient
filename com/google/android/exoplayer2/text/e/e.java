package com.google.android.exoplayer2.text.e;

import android.text.Layout;
/* loaded from: classes5.dex */
final class e {
    private float Ro;
    private int backgroundColor;
    private int gMR;
    private String hz;
    private String id;
    private boolean mAJ;
    private boolean mAK;
    private e mAN;
    private Layout.Alignment mAO;
    private int mAL = -1;
    private int underline = -1;
    private int bold = -1;
    private int italic = -1;
    private int mAM = -1;

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dwX() {
        return this.mAL == 1;
    }

    public e vG(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mAN == null);
        this.mAL = z ? 1 : 0;
        return this;
    }

    public boolean dwY() {
        return this.underline == 1;
    }

    public e vH(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mAN == null);
        this.underline = z ? 1 : 0;
        return this;
    }

    public e vI(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mAN == null);
        this.bold = z ? 1 : 0;
        return this;
    }

    public e vJ(boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mAN == null);
        this.italic = z ? 1 : 0;
        return this;
    }

    public String dwZ() {
        return this.hz;
    }

    public e PN(String str) {
        com.google.android.exoplayer2.util.a.checkState(this.mAN == null);
        this.hz = str;
        return this;
    }

    public int getFontColor() {
        if (!this.mAJ) {
            throw new IllegalStateException("Font color has not been defined.");
        }
        return this.gMR;
    }

    public e Lt(int i) {
        com.google.android.exoplayer2.util.a.checkState(this.mAN == null);
        this.gMR = i;
        this.mAJ = true;
        return this;
    }

    public boolean dxa() {
        return this.mAJ;
    }

    public int getBackgroundColor() {
        if (!this.mAK) {
            throw new IllegalStateException("Background color has not been defined.");
        }
        return this.backgroundColor;
    }

    public e Lu(int i) {
        this.backgroundColor = i;
        this.mAK = true;
        return this;
    }

    public boolean dxb() {
        return this.mAK;
    }

    public e b(e eVar) {
        return a(eVar, true);
    }

    private e a(e eVar, boolean z) {
        if (eVar != null) {
            if (!this.mAJ && eVar.mAJ) {
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
            if (this.mAL == -1) {
                this.mAL = eVar.mAL;
            }
            if (this.underline == -1) {
                this.underline = eVar.underline;
            }
            if (this.mAO == null) {
                this.mAO = eVar.mAO;
            }
            if (this.mAM == -1) {
                this.mAM = eVar.mAM;
                this.Ro = eVar.Ro;
            }
            if (z && !this.mAK && eVar.mAK) {
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

    public Layout.Alignment dxc() {
        return this.mAO;
    }

    public e a(Layout.Alignment alignment) {
        this.mAO = alignment;
        return this;
    }

    public e bz(float f) {
        this.Ro = f;
        return this;
    }

    public e Lv(int i) {
        this.mAM = i;
        return this;
    }

    public int dxd() {
        return this.mAM;
    }

    public float dxe() {
        return this.Ro;
    }
}
