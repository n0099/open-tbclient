package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes13.dex */
public class g implements h {
    public static final h mUN = i(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean mUO;
    boolean mUP;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.mUO = z;
        this.mUP = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dFk() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dFl() {
        return this.mUO;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dFm() {
        return this.mUP;
    }

    public int hashCode() {
        return ((this.mUO ? 4194304 : 0) ^ this.mQuality) ^ (this.mUP ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.mUO == gVar.mUO && this.mUP == gVar.mUP;
        }
        return false;
    }

    public static h i(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
