package com.kwad.sdk.core.h;
/* loaded from: classes10.dex */
public abstract class b implements c {
    public boolean aCF = false;
    public boolean Mc = false;
    public boolean Md = false;

    public abstract void ah();

    public abstract void ai();

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        this.aCF = true;
        if (!this.Md) {
            ah();
            this.Md = true;
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        if (this.aCF && !this.Mc) {
            ai();
            this.Mc = true;
        }
    }
}
