package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes13.dex */
public class g implements h {
    public static final h mxt = i(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean mxu;
    boolean mxv;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.mxu = z;
        this.mxv = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dAq() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dAr() {
        return this.mxu;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dAs() {
        return this.mxv;
    }

    public int hashCode() {
        return ((this.mxu ? 4194304 : 0) ^ this.mQuality) ^ (this.mxv ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.mxu == gVar.mxu && this.mxv == gVar.mxv;
        }
        return false;
    }

    public static h i(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
