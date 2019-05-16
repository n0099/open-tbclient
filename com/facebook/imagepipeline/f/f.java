package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g kaZ = f(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean kba;
    boolean kbb;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.kba = z;
        this.kbb = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cGK() {
        return this.kba;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cGL() {
        return this.kbb;
    }

    public int hashCode() {
        return ((this.kba ? 4194304 : 0) ^ this.mQuality) ^ (this.kbb ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.kba == fVar.kba && this.kbb == fVar.kbb;
        }
        return false;
    }

    public static g f(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
