package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes8.dex */
public class g implements h {
    public static final h nwY = j(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean nwZ;
    boolean nxa;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.nwZ = z;
        this.nxa = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dUF() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dUG() {
        return this.nwZ;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dUH() {
        return this.nxa;
    }

    public int hashCode() {
        return ((this.nwZ ? 4194304 : 0) ^ this.mQuality) ^ (this.nxa ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.nwZ == gVar.nwZ && this.nxa == gVar.nxa;
        }
        return false;
    }

    public static h j(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
