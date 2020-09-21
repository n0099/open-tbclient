package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes12.dex */
public class g implements h {
    public static final h nGV = j(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean nGW;
    boolean nGX;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.nGW = z;
        this.nGX = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dYD() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dYE() {
        return this.nGW;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dYF() {
        return this.nGX;
    }

    public int hashCode() {
        return ((this.nGW ? 4194304 : 0) ^ this.mQuality) ^ (this.nGX ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.nGW == gVar.nGW && this.nGX == gVar.nGX;
        }
        return false;
    }

    public static h j(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
