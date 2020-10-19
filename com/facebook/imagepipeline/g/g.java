package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes12.dex */
public class g implements h {
    public static final h nWm = j(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean nWn;
    boolean nWo;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.nWn = z;
        this.nWo = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int eco() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean ecp() {
        return this.nWn;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean ecq() {
        return this.nWo;
    }

    public int hashCode() {
        return ((this.nWn ? 4194304 : 0) ^ this.mQuality) ^ (this.nWo ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.nWn == gVar.nWn && this.nWo == gVar.nWo;
        }
        return false;
    }

    public static h j(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
