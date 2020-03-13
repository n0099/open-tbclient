package com.facebook.imagepipeline.g;
/* loaded from: classes13.dex */
public class g implements h {
    public static final h lUh = k(Integer.MAX_VALUE, true, true);
    boolean lUi;
    boolean lUj;
    int mQuality;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.lUi = z;
        this.lUj = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dqF() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dqG() {
        return this.lUi;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dqH() {
        return this.lUj;
    }

    public int hashCode() {
        return ((this.lUi ? 4194304 : 0) ^ this.mQuality) ^ (this.lUj ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.lUi == gVar.lUi && this.lUj == gVar.lUj;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
