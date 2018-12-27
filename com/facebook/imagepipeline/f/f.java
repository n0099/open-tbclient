package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g irP = e(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean irQ;
    boolean irR;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.irQ = z;
        this.irR = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bYV() {
        return this.irQ;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bYW() {
        return this.irR;
    }

    public int hashCode() {
        return ((this.irQ ? 4194304 : 0) ^ this.mQuality) ^ (this.irR ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.irQ == fVar.irQ && this.irR == fVar.irR;
        }
        return false;
    }

    public static g e(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
