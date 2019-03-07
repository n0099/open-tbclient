package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g jIG = f(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean jIH;
    boolean jII;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.jIH = z;
        this.jII = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cyI() {
        return this.jIH;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cyJ() {
        return this.jII;
    }

    public int hashCode() {
        return ((this.jIH ? 4194304 : 0) ^ this.mQuality) ^ (this.jII ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.jIH == fVar.jIH && this.jII == fVar.jII;
        }
        return false;
    }

    public static g f(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
