package com.kwad.sdk.reward.b;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class g extends com.kwad.sdk.reward.d {
    public g(Context context, AdTemplate adTemplate) {
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        if (com.kwad.sdk.core.response.b.a.a(g2, context)) {
            a((Presenter) new f());
        } else if (com.kwad.sdk.core.response.b.a.b(g2, context)) {
        } else {
            com.kwad.sdk.core.report.e.b(adTemplate);
        }
    }
}
