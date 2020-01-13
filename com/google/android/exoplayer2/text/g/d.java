package com.google.android.exoplayer2.text.g;

import android.text.Layout;
import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
final class d {
    private float Ro;
    private int backgroundColor;
    private int bold;
    private int gMR;
    private String hz;
    private int italic;
    private boolean mAJ;
    private boolean mAK;
    private int mAL;
    private int mAM;
    private Layout.Alignment mAO;
    private String mBl;
    private String mBm;
    private List<String> mBn;
    private String mBo;
    private int underline;

    public d() {
        reset();
    }

    public void reset() {
        this.mBl = "";
        this.mBm = "";
        this.mBn = Collections.emptyList();
        this.mBo = "";
        this.hz = null;
        this.mAJ = false;
        this.mAK = false;
        this.mAL = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.mAM = -1;
        this.mAO = null;
    }

    public void PP(String str) {
        this.mBl = str;
    }

    public void PQ(String str) {
        this.mBm = str;
    }

    public void S(String[] strArr) {
        this.mBn = Arrays.asList(strArr);
    }

    public void PR(String str) {
        this.mBo = str;
    }

    public int a(String str, String str2, String[] strArr, String str3) {
        if (this.mBl.isEmpty() && this.mBm.isEmpty() && this.mBn.isEmpty() && this.mBo.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int b = b(b(b(0, this.mBl, str, 1073741824), this.mBm, str2, 2), this.mBo, str3, 4);
        if (b == -1 || !Arrays.asList(strArr).containsAll(this.mBn)) {
            return 0;
        }
        return (this.mBn.size() * 4) + b;
    }

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dwX() {
        return this.mAL == 1;
    }

    public boolean dwY() {
        return this.underline == 1;
    }

    public d vL(boolean z) {
        this.underline = z ? 1 : 0;
        return this;
    }

    public d vM(boolean z) {
        this.bold = z ? 1 : 0;
        return this;
    }

    public d vN(boolean z) {
        this.italic = z ? 1 : 0;
        return this;
    }

    public String dwZ() {
        return this.hz;
    }

    public d PS(String str) {
        this.hz = v.Qo(str);
        return this;
    }

    public int getFontColor() {
        if (!this.mAJ) {
            throw new IllegalStateException("Font color not defined");
        }
        return this.gMR;
    }

    public d Lw(int i) {
        this.gMR = i;
        this.mAJ = true;
        return this;
    }

    public boolean dxa() {
        return this.mAJ;
    }

    public int getBackgroundColor() {
        if (!this.mAK) {
            throw new IllegalStateException("Background color not defined.");
        }
        return this.backgroundColor;
    }

    public d Lx(int i) {
        this.backgroundColor = i;
        this.mAK = true;
        return this;
    }

    public boolean dxb() {
        return this.mAK;
    }

    public Layout.Alignment dxc() {
        return this.mAO;
    }

    public int dxd() {
        return this.mAM;
    }

    public float dxe() {
        return this.Ro;
    }

    private static int b(int i, String str, String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }
}
