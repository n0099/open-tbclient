package com.kwad.components.ad.reward.k;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ag;
/* loaded from: classes9.dex */
public abstract class d {
    public void a(u uVar) {
    }

    public void aa(boolean z) {
    }

    public final void b(@NonNull u uVar) {
        a(uVar);
        aa(ag.cB(fR().getContext()));
    }

    public abstract ViewGroup fR();

    public void onUnbind() {
    }
}
