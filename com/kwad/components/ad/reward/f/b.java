package com.kwad.components.ad.reward.f;

import android.content.Context;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class b extends ah implements ah.a {
    public PlayableSource pt;

    public b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        this.pt = playableSource;
        a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.ah.a
    public final boolean dc() {
        com.kwad.components.ad.reward.b.eV().c(this.pt, new a(this.mContext));
        return false;
    }
}
