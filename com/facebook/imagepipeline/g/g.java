package com.facebook.imagepipeline.g;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes13.dex */
public class g implements h {
    public static final h mdC = i(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean mdD;
    boolean mdE;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.mdD = z;
        this.mdE = z2;
    }

    @Override // com.facebook.imagepipeline.g.h
    public int dsX() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dsY() {
        return this.mdD;
    }

    @Override // com.facebook.imagepipeline.g.h
    public boolean dsZ() {
        return this.mdE;
    }

    public int hashCode() {
        return ((this.mdD ? 4194304 : 0) ^ this.mQuality) ^ (this.mdE ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.mdD == gVar.mdD && this.mdE == gVar.mdE;
        }
        return false;
    }

    public static h i(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
