package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g jIR = f(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean jIS;
    boolean jIT;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.jIS = z;
        this.jIT = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cyV() {
        return this.jIS;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cyW() {
        return this.jIT;
    }

    public int hashCode() {
        return ((this.jIS ? 4194304 : 0) ^ this.mQuality) ^ (this.jIT ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.jIS == fVar.jIS && this.jIT == fVar.jIT;
        }
        return false;
    }

    public static g f(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
