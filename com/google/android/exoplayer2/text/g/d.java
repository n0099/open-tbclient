package com.google.android.exoplayer2.text.g;

import android.text.Layout;
import com.google.android.exoplayer2.util.v;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
final class d {
    private float Rl;
    private int backgroundColor;
    private int bold;
    private int gJE;
    private String hz;
    private int italic;
    private boolean mwV;
    private boolean mwW;
    private int mwX;
    private int mwY;
    private Layout.Alignment mxa;
    private String mxw;
    private String mxx;
    private List<String> mxy;
    private String mxz;
    private int underline;

    public d() {
        reset();
    }

    public void reset() {
        this.mxw = "";
        this.mxx = "";
        this.mxy = Collections.emptyList();
        this.mxz = "";
        this.hz = null;
        this.mwV = false;
        this.mwW = false;
        this.mwX = -1;
        this.underline = -1;
        this.bold = -1;
        this.italic = -1;
        this.mwY = -1;
        this.mxa = null;
    }

    public void PE(String str) {
        this.mxw = str;
    }

    public void PF(String str) {
        this.mxx = str;
    }

    public void S(String[] strArr) {
        this.mxy = Arrays.asList(strArr);
    }

    public void PG(String str) {
        this.mxz = str;
    }

    public int a(String str, String str2, String[] strArr, String str3) {
        if (this.mxw.isEmpty() && this.mxx.isEmpty() && this.mxy.isEmpty() && this.mxz.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        int b = b(b(b(0, this.mxw, str, 1073741824), this.mxx, str2, 2), this.mxz, str3, 4);
        if (b == -1 || !Arrays.asList(strArr).containsAll(this.mxy)) {
            return 0;
        }
        return (this.mxy.size() * 4) + b;
    }

    public int getStyle() {
        if (this.bold == -1 && this.italic == -1) {
            return -1;
        }
        return (this.bold == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean dvM() {
        return this.mwX == 1;
    }

    public boolean dvN() {
        return this.underline == 1;
    }

    public d vz(boolean z) {
        this.underline = z ? 1 : 0;
        return this;
    }

    public d vA(boolean z) {
        this.bold = z ? 1 : 0;
        return this;
    }

    public d vB(boolean z) {
        this.italic = z ? 1 : 0;
        return this;
    }

    public String dvO() {
        return this.hz;
    }

    public d PH(String str) {
        this.hz = v.Qd(str);
        return this;
    }

    public int getFontColor() {
        if (!this.mwV) {
            throw new IllegalStateException("Font color not defined");
        }
        return this.gJE;
    }

    public d Ln(int i) {
        this.gJE = i;
        this.mwV = true;
        return this;
    }

    public boolean dvP() {
        return this.mwV;
    }

    public int getBackgroundColor() {
        if (!this.mwW) {
            throw new IllegalStateException("Background color not defined.");
        }
        return this.backgroundColor;
    }

    public d Lo(int i) {
        this.backgroundColor = i;
        this.mwW = true;
        return this;
    }

    public boolean dvQ() {
        return this.mwW;
    }

    public Layout.Alignment dvR() {
        return this.mxa;
    }

    public int dvS() {
        return this.mwY;
    }

    public float dvT() {
        return this.Rl;
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
