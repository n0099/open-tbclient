package com.facebook.imagepipeline.f;
/* loaded from: classes5.dex */
public class g implements h {
    public static final h pMO = k(Integer.MAX_VALUE, true, true);
    int mQuality;
    boolean pMP;
    boolean pMQ;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.pMP = z;
        this.pMQ = z2;
    }

    @Override // com.facebook.imagepipeline.f.h
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean eyK() {
        return this.pMP;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean eyL() {
        return this.pMQ;
    }

    public int hashCode() {
        return ((this.pMP ? 4194304 : 0) ^ this.mQuality) ^ (this.pMQ ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.pMP == gVar.pMP && this.pMQ == gVar.pMQ;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
