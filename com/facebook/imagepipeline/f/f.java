package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g ifI = e(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean ifJ;
    boolean ifK;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.ifJ = z;
        this.ifK = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bWE() {
        return this.ifJ;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bWF() {
        return this.ifK;
    }

    public int hashCode() {
        return ((this.ifJ ? 4194304 : 0) ^ this.mQuality) ^ (this.ifK ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.ifJ == fVar.ifJ && this.ifK == fVar.ifK;
        }
        return false;
    }

    public static g e(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
