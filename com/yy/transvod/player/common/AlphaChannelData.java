package com.yy.transvod.player.common;
/* loaded from: classes2.dex */
public class AlphaChannelData {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;

    public static native void nativeClassInit();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof AlphaChannelData)) {
            AlphaChannelData alphaChannelData = (AlphaChannelData) obj;
            if (this.a == alphaChannelData.a && this.b == alphaChannelData.b && this.c == alphaChannelData.c && this.d == alphaChannelData.d && this.e == alphaChannelData.e && this.f == alphaChannelData.f && this.g == alphaChannelData.g && this.h == alphaChannelData.h) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "AlphaChannelData: x=" + this.a + " y=" + this.b + " width=" + this.c + " height=" + this.d + " gaussKernel=" + this.e + " gaussSigma=" + this.f + " meanKernel=" + this.g + " version=" + this.h;
    }
}
