package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g kba = f(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean kbb;
    boolean kbc;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.kbb = z;
        this.kbc = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cGM() {
        return this.kbb;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cGN() {
        return this.kbc;
    }

    public int hashCode() {
        return ((this.kbb ? 4194304 : 0) ^ this.mQuality) ^ (this.kbc ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.kbb == fVar.kbb && this.kbc == fVar.kbc;
        }
        return false;
    }

    public static g f(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
