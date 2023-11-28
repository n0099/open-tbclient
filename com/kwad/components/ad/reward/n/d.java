package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ai;
/* loaded from: classes10.dex */
public abstract class d {
    public void a(r rVar) {
    }

    public void ab(boolean z) {
    }

    public abstract ViewGroup gD();

    public void onUnbind() {
    }

    public final void b(@NonNull r rVar) {
        a(rVar);
        gD().getContext();
        ab(ai.Kx());
    }
}
