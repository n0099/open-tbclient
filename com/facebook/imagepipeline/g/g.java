package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes12.dex */
public class g implements h {
    public static final h oNE = j(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean oNF;
    boolean oNG;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.oNF = z;
        this.oNG = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int emm() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean emn() {
        return this.oNF;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean emo() {
        return this.oNG;
    }

    public int hashCode() {
        return ((this.oNF ? 4194304 : 0) ^ this.mQuality) ^ (this.oNG ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.oNF == gVar.oNF && this.oNG == gVar.oNG;
        }
        return false;
    }

    public static h j(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
