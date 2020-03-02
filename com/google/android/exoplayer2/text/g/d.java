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
    private int gOT;
    private String hD;
    private int italic;
    private int mBA;
    private Layout.Alignment mBC;
    private String mBY;
    private String mBZ;
    private boolean mBx;
    private boolean mBy;
    private int mBz;
    private List<String> mCa;
    private String mCb;
    private int underline;

    public d() {
        reset();
    }

    public void reset() {
        this.mBY = "";
        this.mBZ = "";
        this.mCa = Collections.emptyList();
        this.mCb = "";
        this.hD = null;
        this.mBx = false;
        this.mBy = false;
        this.mBz = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.mBA = -1;
        this.mBC = null;
    }

    public void Qc(String str) {
        this.mBY = str;
    }

    public void Qd(String str) {
        this.mBZ = str;
    }

    public void T(String[] strArr) {
        this.mCa = Arrays.asList(strArr);
    }

    public void Qe(String str) {
        this.mCb = str;
    }

    public int a(String str, String str2, String[] strArr, String str3) {
        if (this.mBY.isEmpty() && this.mBZ.isEmpty() && this.mCa.isEmpty() && this.mCb.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int b = b(b(b(0, this.mBY, str, 1073741824), this.mBZ, str2, 2), this.mCb, str3, 4);
        if (b == -1 || !Arrays.asList(strArr).containsAll(this.mCa)) {
            return 0;
        }
        return (this.mCa.size() * 4) + b;
    }

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dyl() {
        return this.mBz == 1;
    }

    public boolean dym() {
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

    public String dyn() {
        return this.hD;
    }

    public d Qf(String str) {
        this.hD = v.QB(str);
        return this;
    }

    public int getFontColor() {
        if (!this.mBx) {
            throw new IllegalStateException("Font color not defined");
        }
        return this.gOT;
    }

    public d LB(int i) {
        this.gOT = i;
        this.mBx = true;
        return this;
    }

    public boolean dyo() {
        return this.mBx;
    }

    public int getBackgroundColor() {
        if (!this.mBy) {
            throw new IllegalStateException("Background color not defined.");
        }
        return this.backgroundColor;
    }

    public d LC(int i) {
        this.backgroundColor = i;
        this.mBy = true;
        return this;
    }

    public boolean dyp() {
        return this.mBy;
    }

    public Layout.Alignment dyq() {
        return this.mBC;
    }

    public int dyr() {
        return this.mBA;
    }

    public float dys() {
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
