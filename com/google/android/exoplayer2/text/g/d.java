package com.google.android.exoplayer2.text.g;

import android.text.Layout;
import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
final class d {
    private float SW;
    private int backgroundColor;
    private int bold;
    private int gPf;
    private String hD;
    private int italic;
    private boolean mBI;
    private boolean mBJ;
    private int mBK;
    private int mBL;
    private Layout.Alignment mBN;
    private String mCj;
    private String mCk;
    private List<String> mCl;
    private String mCm;
    private int underline;

    public d() {
        reset();
    }

    public void reset() {
        this.mCj = "";
        this.mCk = "";
        this.mCl = Collections.emptyList();
        this.mCm = "";
        this.hD = null;
        this.mBI = false;
        this.mBJ = false;
        this.mBK = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.mBL = -1;
        this.mBN = null;
    }

    public void Qd(String str) {
        this.mCj = str;
    }

    public void Qe(String str) {
        this.mCk = str;
    }

    public void T(String[] strArr) {
        this.mCl = Arrays.asList(strArr);
    }

    public void Qf(String str) {
        this.mCm = str;
    }

    public int a(String str, String str2, String[] strArr, String str3) {
        if (this.mCj.isEmpty() && this.mCk.isEmpty() && this.mCl.isEmpty() && this.mCm.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int b = b(b(b(0, this.mCj, str, 1073741824), this.mCk, str2, 2), this.mCm, str3, 4);
        if (b == -1 || !Arrays.asList(strArr).containsAll(this.mCl)) {
            return 0;
        }
        return (this.mCl.size() * 4) + b;
    }

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dym() {
        return this.mBK == 1;
    }

    public boolean dyn() {
        return this.underline == 1;
    }

    public d vP(boolean z) {
        this.underline = z ? 1 : 0;
        return this;
    }

    public d vQ(boolean z) {
        this.bold = z ? 1 : 0;
        return this;
    }

    public d vR(boolean z) {
        this.italic = z ? 1 : 0;
        return this;
    }

    public String dyo() {
        return this.hD;
    }

    public d Qg(String str) {
        this.hD = v.QC(str);
        return this;
    }

    public int getFontColor() {
        if (!this.mBI) {
            throw new IllegalStateException("Font color not defined");
        }
        return this.gPf;
    }

    public d LB(int i) {
        this.gPf = i;
        this.mBI = true;
        return this;
    }

    public boolean dyp() {
        return this.mBI;
    }

    public int getBackgroundColor() {
        if (!this.mBJ) {
            throw new IllegalStateException("Background color not defined.");
        }
        return this.backgroundColor;
    }

    public d LC(int i) {
        this.backgroundColor = i;
        this.mBJ = true;
        return this;
    }

    public boolean dyq() {
        return this.mBJ;
    }

    public Layout.Alignment dyr() {
        return this.mBN;
    }

    public int dys() {
        return this.mBL;
    }

    public float dyt() {
        return this.SW;
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
