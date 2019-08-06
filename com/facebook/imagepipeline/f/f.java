package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g kjq = g(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean kjr;
    boolean kjs;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.kjr = z;
        this.kjs = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int cKj() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cKk() {
        return this.kjr;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cKl() {
        return this.kjs;
    }

    public int hashCode() {
        return ((this.kjr ? 4194304 : 0) ^ this.mQuality) ^ (this.kjs ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.kjr == fVar.kjr && this.kjs == fVar.kjs;
        }
        return false;
    }

    public static g g(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
