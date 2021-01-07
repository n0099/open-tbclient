package com.facebook.imagepipeline.f;

import androidx.appcompat.widget.ActivityChooserView;
/* loaded from: classes5.dex */
public class g implements h {
    public static final h pEB = k(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, true, true);
    int mQuality;
    boolean pEC;
    boolean pED;

    private g(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.pEC = z;
        this.pED = z2;
    }

    @Override // com.facebook.imagepipeline.f.h
    public int ezS() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean ezT() {
        return this.pEC;
    }

    @Override // com.facebook.imagepipeline.f.h
    public boolean ezU() {
        return this.pED;
    }

    public int hashCode() {
        return ((this.pEC ? 4194304 : 0) ^ this.mQuality) ^ (this.pED ? 8388608 : 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.mQuality == gVar.mQuality && this.pEC == gVar.pEC && this.pED == gVar.pED;
        }
        return false;
    }

    public static h k(int i, boolean z, boolean z2) {
        return new g(i, z, z2);
    }
}
