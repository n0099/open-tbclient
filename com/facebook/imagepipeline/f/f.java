package com.facebook.imagepipeline.f;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g kjZ = g(Integer.MAX_VALUE, true, true);
    boolean kka;
    boolean kkb;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.kka = z;
        this.kkb = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int cHU() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cHV() {
        return this.kka;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cHW() {
        return this.kkb;
    }

    public int hashCode() {
        return ((this.kka ? 4194304 : 0) ^ this.mQuality) ^ (this.kkb ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.kka == fVar.kka && this.kkb == fVar.kkb;
        }
        return false;
    }

    public static g g(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
