package com.facebook.imagepipeline.g;
/* loaded from: classes11.dex */
public class g implements h {
    public static final h lPw = k(Integer.MAX_VALUE, true, true);
    boolean lPx;
    boolean lPy;
    int mQuality;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.lPx = z;
        this.lPy = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int doi() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean doj() {
        return this.lPx;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dok() {
        return this.lPy;
    }

    public int hashCode() {
        return ((this.lPx ? 4194304 : 0) ^ this.mQuality) ^ (this.lPy ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.lPx == gVar.lPx && this.lPy == gVar.lPy;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
