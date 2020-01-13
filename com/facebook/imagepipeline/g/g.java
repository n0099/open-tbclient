package com.facebook.imagepipeline.g;
/* loaded from: classes12.dex */
public class g implements h {
    public static final h lTi = k(Integer.MAX_VALUE, true, true);
    boolean lTj;
    boolean lTk;
    int mQuality;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.lTj = z;
        this.lTk = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dpo() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dpp() {
        return this.lTj;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dpq() {
        return this.lTk;
    }

    public int hashCode() {
        return ((this.lTj ? 4194304 : 0) ^ this.mQuality) ^ (this.lTk ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.lTj == gVar.lTj && this.lTk == gVar.lTk;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
