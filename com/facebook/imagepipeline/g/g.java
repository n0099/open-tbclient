package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes13.dex */
public class g implements h {
    public static final h mdy = i(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean mdA;
    boolean mdz;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.mdz = z;
        this.mdA = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dta() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dtb() {
        return this.mdz;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dtc() {
        return this.mdA;
    }

    public int hashCode() {
        return ((this.mdz ? 4194304 : 0) ^ this.mQuality) ^ (this.mdA ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.mdz == gVar.mdz && this.mdA == gVar.mdA;
        }
        return false;
    }

    public static h i(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
