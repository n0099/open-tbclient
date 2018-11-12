package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g iht = e(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean ihu;
    boolean ihv;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.ihu = z;
        this.ihv = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bVZ() {
        return this.ihu;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bWa() {
        return this.ihv;
    }

    public int hashCode() {
        return ((this.ihu ? 4194304 : 0) ^ this.mQuality) ^ (this.ihv ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.ihu == fVar.ihu && this.ihv == fVar.ihv;
        }
        return false;
    }

    public static g e(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
