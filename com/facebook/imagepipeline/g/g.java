package com.facebook.imagepipeline.g;
/* loaded from: classes13.dex */
public class g implements h {
    public static final h lVN = k(Integer.MAX_VALUE, true, true);
    boolean lVO;
    boolean lVP;
    int mQuality;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.lVO = z;
        this.lVP = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int drc() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean drd() {
        return this.lVO;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dre() {
        return this.lVP;
    }

    public int hashCode() {
        return ((this.lVO ? 4194304 : 0) ^ this.mQuality) ^ (this.lVP ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.lVO == gVar.lVO && this.lVP == gVar.lVP;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
