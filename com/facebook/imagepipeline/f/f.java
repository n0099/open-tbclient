package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g jIZ = f(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean jJa;
    boolean jJb;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.jJa = z;
        this.jJb = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cyS() {
        return this.jJa;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cyT() {
        return this.jJb;
    }

    public int hashCode() {
        return ((this.jJa ? 4194304 : 0) ^ this.mQuality) ^ (this.jJb ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.jJa == fVar.jJa && this.jJb == fVar.jJb;
        }
        return false;
    }

    public static g f(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
