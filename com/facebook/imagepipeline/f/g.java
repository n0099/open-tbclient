package com.facebook.imagepipeline.f;
/* loaded from: classes5.dex */
public class g implements h {
    public static final h pKJ = k(Integer.MAX_VALUE, true, true);
    int mQuality;
    boolean pKK;
    boolean pKL;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.pKK = z;
        this.pKL = z2;
    }

    @Override // com.facebook.imagepipeline.f.h
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean eyB() {
        return this.pKK;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean eyC() {
        return this.pKL;
    }

    public int hashCode() {
        return ((this.pKK ? 4194304 : 0) ^ this.mQuality) ^ (this.pKL ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.pKK == gVar.pKK && this.pKL == gVar.pKL;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
