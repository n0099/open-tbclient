package com.facebook.imagepipeline.f;

import androidx.appcompat.widget.ActivityChooserView;
/* loaded from: classes6.dex */
public class g implements h {
    public static final h pCU = k(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean pCV;
    boolean pCW;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.pCV = z;
        this.pCW = z2;
    }

    @Override // com.facebook.imagepipeline.f.h
    public int ezo() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean ezp() {
        return this.pCV;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean ezq() {
        return this.pCW;
    }

    public int hashCode() {
        return ((this.pCV ? 4194304 : 0) ^ this.mQuality) ^ (this.pCW ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.pCV == gVar.pCV && this.pCW == gVar.pCW;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
