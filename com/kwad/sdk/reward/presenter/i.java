package com.kwad.sdk.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes7.dex */
public class i extends com.kwad.sdk.reward.g {
    public i(AdTemplate adTemplate) {
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        if (com.kwad.sdk.core.response.a.a.an(j)) {
            a((Presenter) new g());
            a((Presenter) new h());
        } else if (com.kwad.sdk.core.response.a.a.ao(j)) {
        } else {
            com.kwad.sdk.core.report.d.b(adTemplate);
        }
    }
}
