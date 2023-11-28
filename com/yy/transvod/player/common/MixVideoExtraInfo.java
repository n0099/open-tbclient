package com.yy.transvod.player.common;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes2.dex */
public class MixVideoExtraInfo {
    public String a = "";
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public float o = 0.0f;
    public int p = 0;

    public static native void nativeClassInit();

    public boolean equals(Object obj) {
        MixVideoExtraInfo mixVideoExtraInfo;
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof MixVideoExtraInfo) && (((str = this.a) == (str2 = (mixVideoExtraInfo = (MixVideoExtraInfo) obj).a) || (str != null && str2 != null && str.equals(str2))) && this.b == mixVideoExtraInfo.b && this.c == mixVideoExtraInfo.c && this.d == mixVideoExtraInfo.d && this.e == mixVideoExtraInfo.e && this.f == mixVideoExtraInfo.f && this.g == mixVideoExtraInfo.g && this.h == mixVideoExtraInfo.h && this.i == mixVideoExtraInfo.i && this.j == mixVideoExtraInfo.j && this.k == mixVideoExtraInfo.k && this.l == mixVideoExtraInfo.l && this.m == mixVideoExtraInfo.m && this.n == mixVideoExtraInfo.n && Math.abs(this.o - mixVideoExtraInfo.o) < 1.0E-6d && this.p == mixVideoExtraInfo.p)) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MixVideoExtraInfo: ");
        sb.append(" uid=");
        String str = this.a;
        if (str == null) {
            str = StringUtil.NULL_STRING;
        }
        sb.append(str);
        sb.append(" width=");
        sb.append(this.b);
        sb.append(" height=");
        sb.append(this.c);
        sb.append(" cropX=");
        sb.append(this.d);
        sb.append(" cropY=");
        sb.append(this.e);
        sb.append(" cropW=");
        sb.append(this.f);
        sb.append(" cropH=");
        sb.append(this.g);
        sb.append(" layoutX=");
        sb.append(this.h);
        sb.append(" layoutY=");
        sb.append(this.i);
        sb.append(" layoutW=");
        sb.append(this.j);
        sb.append(" layoutH=");
        sb.append(this.k);
        sb.append(" cavasW=");
        sb.append(this.l);
        sb.append(" cavasH=");
        sb.append(this.m);
        sb.append(" zOrder=");
        sb.append(this.n);
        sb.append(" alpha=");
        sb.append(this.o);
        sb.append(" content=");
        sb.append(this.p);
        return sb.toString();
    }
}
