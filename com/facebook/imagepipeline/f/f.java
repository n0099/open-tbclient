package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g kik = g(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean kil;
    boolean kim;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.kil = z;
        this.kim = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int cJO() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cJP() {
        return this.kil;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cJQ() {
        return this.kim;
    }

    public int hashCode() {
        return ((this.kil ? 4194304 : 0) ^ this.mQuality) ^ (this.kim ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.kil == fVar.kil && this.kim == fVar.kim;
        }
        return false;
    }

    public static g g(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
