package com.facebook.imagepipeline.f;

import androidx.appcompat.widget.ActivityChooserView;
/* loaded from: classes5.dex */
public class g implements h {
    public static final h pAb = k(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean pAc;
    boolean pAd;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.pAc = z;
        this.pAd = z2;
    }

    @Override // com.facebook.imagepipeline.f.h
    public int ewa() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean ewb() {
        return this.pAc;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean ewc() {
        return this.pAd;
    }

    public int hashCode() {
        return ((this.pAc ? 4194304 : 0) ^ this.mQuality) ^ (this.pAd ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.pAc == gVar.pAc && this.pAd == gVar.pAd;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
