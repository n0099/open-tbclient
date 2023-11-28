package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;
/* loaded from: classes10.dex */
public abstract class s extends d {
    public ViewGroup sy;

    @Override // com.kwad.components.ad.reward.n.d
    public ViewGroup gD() {
        return this.sy;
    }

    public final void a(ViewGroup viewGroup, @IdRes int i, @IdRes int i2) {
        if (this.sy != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i);
        if (viewStub != null) {
            this.sy = (ViewGroup) viewStub.inflate();
        } else {
            this.sy = (ViewGroup) viewGroup.findViewById(i2);
        }
    }
}
