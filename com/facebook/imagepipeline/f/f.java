package com.facebook.imagepipeline.f;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g kji = g(Integer.MAX_VALUE, true, true);
    boolean kjj;
    boolean kjk;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.kjj = z;
        this.kjk = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int cHS() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cHT() {
        return this.kjj;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cHU() {
        return this.kjk;
    }

    public int hashCode() {
        return ((this.kjj ? 4194304 : 0) ^ this.mQuality) ^ (this.kjk ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.kjj == fVar.kjj && this.kjk == fVar.kjk;
        }
        return false;
    }

    public static g g(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
