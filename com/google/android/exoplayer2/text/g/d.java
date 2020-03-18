package com.google.android.exoplayer2.text.g;

import android.text.Layout;
import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
final class d {
    private float Th;
    private int backgroundColor;
    private int bold;
    private int gQm;
    private String hC;
    private int italic;
    private String mDT;
    private String mDU;
    private List<String> mDV;
    private String mDW;
    private boolean mDq;
    private boolean mDr;
    private int mDs;
    private int mDt;
    private Layout.Alignment mDv;
    private int underline;

    public d() {
        reset();
    }

    public void reset() {
        this.mDT = "";
        this.mDU = "";
        this.mDV = Collections.emptyList();
        this.mDW = "";
        this.hC = null;
        this.mDq = false;
        this.mDr = false;
        this.mDs = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.mDt = -1;
        this.mDv = null;
    }

    public void Qc(String str) {
        this.mDT = str;
    }

    public void Qd(String str) {
        this.mDU = str;
    }

    public void T(String[] strArr) {
        this.mDV = Arrays.asList(strArr);
    }

    public void Qe(String str) {
        this.mDW = str;
    }

    public int a(String str, String str2, String[] strArr, String str3) {
        if (this.mDT.isEmpty() && this.mDU.isEmpty() && this.mDV.isEmpty() && this.mDW.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int b = b(b(b(0, this.mDT, str, 1073741824), this.mDU, str2, 2), this.mDW, str3, 4);
        if (b == -1 || !Arrays.asList(strArr).containsAll(this.mDV)) {
            return 0;
        }
        return (this.mDV.size() * 4) + b;
    }

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dyJ() {
        return this.mDs == 1;
    }

    public boolean dyK() {
        return this.underline == 1;
    }

    public d vW(boolean z) {
        this.underline = z ? 1 : 0;
        return this;
    }

    public d vX(boolean z) {
        this.bold = z ? 1 : 0;
        return this;
    }

    public d vY(boolean z) {
        this.italic = z ? 1 : 0;
        return this;
    }

    public String dyL() {
        return this.hC;
    }

    public d Qf(String str) {
        this.hC = v.QB(str);
        return this;
    }

    public int getFontColor() {
        if (!this.mDq) {
            throw new IllegalStateException("Font color not defined");
        }
        return this.gQm;
    }

    public d LH(int i) {
        this.gQm = i;
        this.mDq = true;
        return this;
    }

    public boolean dyM() {
        return this.mDq;
    }

    public int getBackgroundColor() {
        if (!this.mDr) {
            throw new IllegalStateException("Background color not defined.");
        }
        return this.backgroundColor;
    }

    public d LI(int i) {
        this.backgroundColor = i;
        this.mDr = true;
        return this;
    }

    public boolean dyN() {
        return this.mDr;
    }

    public Layout.Alignment dyO() {
        return this.mDv;
    }

    public int dyP() {
        return this.mDt;
    }

    public float dyQ() {
        return this.Th;
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
