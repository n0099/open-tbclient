package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes17.dex */
public class g implements h {
    public static final h oYA = k(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean oYB;
    boolean oYC;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.oYB = z;
        this.oYC = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int eqb() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean eqc() {
        return this.oYB;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean eqd() {
        return this.oYC;
    }

    public int hashCode() {
        return ((this.oYB ? 4194304 : 0) ^ this.mQuality) ^ (this.oYC ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.oYB == gVar.oYB && this.oYC == gVar.oYC;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
