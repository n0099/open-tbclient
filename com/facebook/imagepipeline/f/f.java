package com.facebook.imagepipeline.f;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public class f implements g {
    public static final g jIm = f(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    boolean jIn;
    boolean jIo;
    int mQuality;

    private f(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.jIn = z;
        this.jIo = z2;
    }

    @Override // com.facebook.imagepipeline.f.g
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cyO() {
        return this.jIn;
    }

    @Override // com.facebook.imagepipeline.f.g
    public boolean cyP() {
        return this.jIo;
    }

    public int hashCode() {
        return ((this.jIn ? 4194304 : 0) ^ this.mQuality) ^ (this.jIo ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.mQuality == fVar.mQuality && this.jIn == fVar.jIn && this.jIo == fVar.jIo;
        }
        return false;
    }

    public static g f(int i, boolean z, boolean z2) {
        return new f(i, z, z2);
    }
}
