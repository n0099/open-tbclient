package com.facebook.imagepipeline.g;
/* loaded from: classes13.dex */
public class g implements h {
    public static final h lTU = k(Integer.MAX_VALUE, true, true);
    boolean lTV;
    boolean lTW;
    int mQuality;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.lTV = z;
        this.lTW = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dqC() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dqD() {
        return this.lTV;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dqE() {
        return this.lTW;
    }

    public int hashCode() {
        return ((this.lTV ? 4194304 : 0) ^ this.mQuality) ^ (this.lTW ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.lTV == gVar.lTV && this.lTW == gVar.lTW;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
