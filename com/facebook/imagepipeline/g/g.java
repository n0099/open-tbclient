package com.facebook.imagepipeline.g;
/* loaded from: classes12.dex */
public class g implements h {
    public static final h lTn = k(Integer.MAX_VALUE, true, true);
    boolean lTo;
    boolean lTp;
    int mQuality;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.lTo = z;
        this.lTp = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dpq() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dpr() {
        return this.lTo;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dps() {
        return this.lTp;
    }

    public int hashCode() {
        return ((this.lTo ? 4194304 : 0) ^ this.mQuality) ^ (this.lTp ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.lTo == gVar.lTo && this.lTp == gVar.lTp;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
