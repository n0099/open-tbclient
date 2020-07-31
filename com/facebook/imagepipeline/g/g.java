package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes3.dex */
public class g implements h {
    public static final h ncO = i(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean ncP;
    boolean ncQ;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.ncP = z;
        this.ncQ = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dIw() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dIx() {
        return this.ncP;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dIy() {
        return this.ncQ;
    }

    public int hashCode() {
        return ((this.ncP ? 4194304 : 0) ^ this.mQuality) ^ (this.ncQ ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.ncP == gVar.ncP && this.ncQ == gVar.ncQ;
        }
        return false;
    }

    public static h i(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
