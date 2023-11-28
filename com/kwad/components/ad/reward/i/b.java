package com.kwad.components.ad.reward.i;

import android.content.Context;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class b extends bf implements bf.a {
    public PlayableSource rZ;

    public b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        this.rZ = playableSource;
        a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.bf.a
    public final boolean dK() {
        com.kwad.components.ad.reward.a.eW().c(this.rZ, new a(this.mContext));
        return false;
    }
}
