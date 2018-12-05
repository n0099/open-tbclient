package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g ioF = e(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean ioG;
    boolean ioH;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.ioG = z;
        this.ioH = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bYf() {
        return this.ioG;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean bYg() {
        return this.ioH;
    }

    public int hashCode() {
        return ((this.ioG ? 4194304 : 0) ^ this.mQuality) ^ (this.ioH ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.ioG == fVar.ioG && this.ioH == fVar.ioH;
        }
        return false;
    }

    public static g e(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
