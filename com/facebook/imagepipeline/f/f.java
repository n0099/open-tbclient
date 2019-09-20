package com.facebook.imagepipeline.f;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g klN = g(Integer.MAX_VALUE, true, true);
    boolean klO;
    boolean klP;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.klO = z;
        this.klP = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int cKX() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cKY() {
        return this.klO;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cKZ() {
        return this.klP;
    }

    public int hashCode() {
        return ((this.klO ? 4194304 : 0) ^ this.mQuality) ^ (this.klP ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.klO == fVar.klO && this.klP == fVar.klP;
        }
        return false;
    }

    public static g g(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
