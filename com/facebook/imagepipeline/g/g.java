package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes12.dex */
public class g implements h {
    public static final h oWX = k(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean oWY;
    boolean oWZ;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.oWY = z;
        this.oWZ = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int eqd() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean eqe() {
        return this.oWY;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean eqf() {
        return this.oWZ;
    }

    public int hashCode() {
        return ((this.oWY ? 4194304 : 0) ^ this.mQuality) ^ (this.oWZ ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.oWY == gVar.oWY && this.oWZ == gVar.oWZ;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
