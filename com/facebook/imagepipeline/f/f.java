package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g isX = e(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean isY;
    boolean isZ;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.isY = z;
        this.isZ = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bZD() {
        return this.isY;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bZE() {
        return this.isZ;
    }

    public int hashCode() {
        return ((this.isY ? 4194304 : 0) ^ this.mQuality) ^ (this.isZ ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.isY == fVar.isY && this.isZ == fVar.isZ;
        }
        return false;
    }

    public static g e(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
