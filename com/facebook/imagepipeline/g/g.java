package com.facebook.imagepipeline.g;
/* loaded from: classes13.dex */
public class g implements h {
    public static final h lTW = k(Integer.MAX_VALUE, true, true);
    boolean lTX;
    boolean lTY;
    int mQuality;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.lTX = z;
        this.lTY = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dqE() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dqF() {
        return this.lTX;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dqG() {
        return this.lTY;
    }

    public int hashCode() {
        return ((this.lTX ? 4194304 : 0) ^ this.mQuality) ^ (this.lTY ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.lTX == gVar.lTX && this.lTY == gVar.lTY;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
