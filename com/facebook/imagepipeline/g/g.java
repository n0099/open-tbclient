package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes8.dex */
public class g implements h {
    public static final h nwG = j(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean nwH;
    boolean nwI;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.nwH = z;
        this.nwI = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dUw() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dUx() {
        return this.nwH;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dUy() {
        return this.nwI;
    }

    public int hashCode() {
        return ((this.nwH ? 4194304 : 0) ^ this.mQuality) ^ (this.nwI ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.nwH == gVar.nwH && this.nwI == gVar.nwI;
        }
        return false;
    }

    public static h j(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
