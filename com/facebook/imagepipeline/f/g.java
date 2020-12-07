package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes7.dex */
public class g implements h {
    public static final h pnp = k(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean pnq;
    boolean pnr;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.pnq = z;
        this.pnr = z2;
    }

    @Override // com.facebook.imagepipeline.f.h
    public int evG() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean evH() {
        return this.pnq;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean evI() {
        return this.pnr;
    }

    public int hashCode() {
        return ((this.pnq ? 4194304 : 0) ^ this.mQuality) ^ (this.pnr ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.pnq == gVar.pnq && this.pnr == gVar.pnr;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
