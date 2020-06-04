package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes13.dex */
public class g implements h {
    public static final h myD = i(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean myE;
    boolean myF;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.myE = z;
        this.myF = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dAE() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dAF() {
        return this.myE;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dAG() {
        return this.myF;
    }

    public int hashCode() {
        return ((this.myE ? 4194304 : 0) ^ this.mQuality) ^ (this.myF ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.myE == gVar.myE && this.myF == gVar.myF;
        }
        return false;
    }

    public static h i(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
