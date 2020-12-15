package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes7.dex */
public class g implements h {
    public static final h pnr = k(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean pns;
    boolean pnt;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.pns = z;
        this.pnt = z2;
    }

    @Override // com.facebook.imagepipeline.f.h
    public int evH() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean evI() {
        return this.pns;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean evJ() {
        return this.pnt;
    }

    public int hashCode() {
        return ((this.pns ? 4194304 : 0) ^ this.mQuality) ^ (this.pnt ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.pns == gVar.pns && this.pnt == gVar.pnt;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
