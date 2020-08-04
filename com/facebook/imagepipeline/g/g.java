package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes3.dex */
public class g implements h {
    public static final h ncQ = i(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean ncR;
    boolean ncS;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.ncR = z;
        this.ncS = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dIx() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dIy() {
        return this.ncR;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dIz() {
        return this.ncS;
    }

    public int hashCode() {
        return ((this.ncR ? 4194304 : 0) ^ this.mQuality) ^ (this.ncS ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.ncR == gVar.ncR && this.ncS == gVar.ncS;
        }
        return false;
    }

    public static h i(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
