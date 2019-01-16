package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g isW = e(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean isX;
    boolean isY;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.isX = z;
        this.isY = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bZD() {
        return this.isX;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bZE() {
        return this.isY;
    }

    public int hashCode() {
        return ((this.isX ? 4194304 : 0) ^ this.mQuality) ^ (this.isY ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.isX == fVar.isX && this.isY == fVar.isY;
        }
        return false;
    }

    public static g e(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
