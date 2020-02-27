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
    private int gOR;
    private String hD;
    private int italic;
    private Layout.Alignment mBA;
    private String mBW;
    private String mBX;
    private List<String> mBY;
    private String mBZ;
    private boolean mBv;
    private boolean mBw;
    private int mBx;
    private int mBy;
    private int underline;

    public d() {
        reset();
    }

    public void reset() {
        this.mBW = "";
        this.mBX = "";
        this.mBY = Collections.emptyList();
        this.mBZ = "";
        this.hD = null;
        this.mBv = false;
        this.mBw = false;
        this.mBx = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.mBy = -1;
        this.mBA = null;
    }

    public void Qc(String str) {
        this.mBW = str;
    }

    public void Qd(String str) {
        this.mBX = str;
    }

    public void T(String[] strArr) {
        this.mBY = Arrays.asList(strArr);
    }

    public void Qe(String str) {
        this.mBZ = str;
    }

    public int a(String str, String str2, String[] strArr, String str3) {
        if (this.mBW.isEmpty() && this.mBX.isEmpty() && this.mBY.isEmpty() && this.mBZ.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int b = b(b(b(0, this.mBW, str, 1073741824), this.mBX, str2, 2), this.mBZ, str3, 4);
        if (b == -1 || !Arrays.asList(strArr).containsAll(this.mBY)) {
            return 0;
        }
        return (this.mBY.size() * 4) + b;
    }

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dyj() {
        return this.mBx == 1;
    }

    public boolean dyk() {
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

    public String dyl() {
        return this.hD;
    }

    public d Qf(String str) {
        this.hD = v.QB(str);
        return this;
    }

    public int getFontColor() {
        if (!this.mBv) {
            throw new IllegalStateException("Font color not defined");
        }
        return this.gOR;
    }

    public d LB(int i) {
        this.gOR = i;
        this.mBv = true;
        return this;
    }

    public boolean dym() {
        return this.mBv;
    }

    public int getBackgroundColor() {
        if (!this.mBw) {
            throw new IllegalStateException("Background color not defined.");
        }
        return this.backgroundColor;
    }

    public d LC(int i) {
        this.backgroundColor = i;
        this.mBw = true;
        return this;
    }

    public boolean dyn() {
        return this.mBw;
    }

    public Layout.Alignment dyo() {
        return this.mBA;
    }

    public int dyp() {
        return this.mBy;
    }

    public float dyq() {
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
