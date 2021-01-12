package com.facebook.imagepipeline.f;

import androidx.appcompat.widget.ActivityChooserView;
/* loaded from: classes5.dex */
public class g implements h {
    public static final h pAa = k(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean pAb;
    boolean pAc;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.pAb = z;
        this.pAc = z2;
    }

    @Override // com.facebook.imagepipeline.f.h
    public int ewa() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean ewb() {
        return this.pAb;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean ewc() {
        return this.pAc;
    }

    public int hashCode() {
        return ((this.pAb ? 4194304 : 0) ^ this.mQuality) ^ (this.pAc ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.pAb == gVar.pAb && this.pAc == gVar.pAc;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
