package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g ifJ = e(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean ifK;
    boolean ifL;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.ifK = z;
        this.ifL = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bWE() {
        return this.ifK;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bWF() {
        return this.ifL;
    }

    public int hashCode() {
        return ((this.ifK ? 4194304 : 0) ^ this.mQuality) ^ (this.ifL ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.ifK == fVar.ifK && this.ifL == fVar.ifL;
        }
        return false;
    }

    public static g e(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
