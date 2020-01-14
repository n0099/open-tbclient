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
    private boolean mAO;
    private boolean mAP;
    private int mAQ;
    private int mAR;
    private Layout.Alignment mAT;
    private String mBq;
    private String mBr;
    private List<String> mBs;
    private String mBt;
    private int underline;

    public d() {
        reset();
    }

    public void reset() {
        this.mBq = "";
        this.mBr = "";
        this.mBs = Collections.emptyList();
        this.mBt = "";
        this.hz = null;
        this.mAO = false;
        this.mAP = false;
        this.mAQ = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.mAR = -1;
        this.mAT = null;
    }

    public void PP(String str) {
        this.mBq = str;
    }

    public void PQ(String str) {
        this.mBr = str;
    }

    public void S(String[] strArr) {
        this.mBs = Arrays.asList(strArr);
    }

    public void PR(String str) {
        this.mBt = str;
    }

    public int a(String str, String str2, String[] strArr, String str3) {
        if (this.mBq.isEmpty() && this.mBr.isEmpty() && this.mBs.isEmpty() && this.mBt.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int b = b(b(b(0, this.mBq, str, 1073741824), this.mBr, str2, 2), this.mBt, str3, 4);
        if (b == -1 || !Arrays.asList(strArr).containsAll(this.mBs)) {
            return 0;
        }
        return (this.mBs.size() * 4) + b;
    }

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dwZ() {
        return this.mAQ == 1;
    }

    public boolean dxa() {
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

    public String dxb() {
        return this.hz;
    }

    public d PS(String str) {
        this.hz = v.Qo(str);
        return this;
    }

    public int getFontColor() {
        if (!this.mAO) {
            throw new IllegalStateException("Font color not defined");
        }
        return this.gMR;
    }

    public d Lw(int i) {
        this.gMR = i;
        this.mAO = true;
        return this;
    }

    public boolean dxc() {
        return this.mAO;
    }

    public int getBackgroundColor() {
        if (!this.mAP) {
            throw new IllegalStateException("Background color not defined.");
        }
        return this.backgroundColor;
    }

    public d Lx(int i) {
        this.backgroundColor = i;
        this.mAP = true;
        return this;
    }

    public boolean dxd() {
        return this.mAP;
    }

    public Layout.Alignment dxe() {
        return this.mAT;
    }

    public int dxf() {
        return this.mAR;
    }

    public float dxg() {
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
