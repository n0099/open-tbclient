package com.kwad.components.ad.reward.k;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;
/* loaded from: classes9.dex */
public abstract class v extends d {
    public ViewGroup pV;

    public final void a(ViewGroup viewGroup, @IdRes int i, @IdRes int i2) {
        if (this.pV != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i);
        this.pV = (ViewGroup) (viewStub != null ? viewStub.inflate() : viewGroup.findViewById(i2));
    }

    @Override // com.kwad.components.ad.reward.k.d
    public ViewGroup fR() {
        return this.pV;
    }
}
