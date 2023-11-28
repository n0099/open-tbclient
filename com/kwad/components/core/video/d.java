package com.kwad.components.core.video;
/* loaded from: classes10.dex */
public final class d {
    public boolean Ur = false;
    public boolean Us = false;
    public boolean Ut = false;
    public boolean Uu = false;
    public boolean Uv = false;
    public int Uw = -1;

    public final boolean ro() {
        if (this.Uw > 0) {
            return true;
        }
        return false;
    }

    public final int rp() {
        return this.Uw;
    }

    public final boolean rq() {
        return this.Ur;
    }

    public final boolean rr() {
        return this.Us;
    }

    public final boolean rs() {
        return this.Ut;
    }

    public final boolean rt() {
        return this.Uu;
    }

    public final boolean ru() {
        return this.Uv;
    }

    public final void aI(int i) {
        this.Uw = i;
    }

    public final void aQ(boolean z) {
        this.Ut = z;
    }

    public final void setAd(boolean z) {
        this.Us = z;
    }

    public final void setFillXY(boolean z) {
        this.Uv = z;
    }

    public final void setForce(boolean z) {
        this.Ur = z;
    }

    public final void setHorizontalVideo(boolean z) {
        this.Uu = z;
    }
}
