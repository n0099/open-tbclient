package com.facebook.imagepipeline.f;
/* loaded from: classes5.dex */
public class g implements h {
    public static final h pKj = k(Integer.MAX_VALUE, true, true);
    int mQuality;
    boolean pKk;
    boolean pKl;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.pKk = z;
        this.pKl = z2;
    }

    @Override // com.facebook.imagepipeline.f.h
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean eyt() {
        return this.pKk;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean eyu() {
        return this.pKl;
    }

    public int hashCode() {
        return ((this.pKk ? 4194304 : 0) ^ this.mQuality) ^ (this.pKl ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.pKk == gVar.pKk && this.pKl == gVar.pKl;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
