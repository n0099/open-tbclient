package com.kwad.sdk.reward.b.c;

import android.content.Context;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f34505b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34506c;

    public a(Context context, AdTemplate adTemplate, boolean z) {
        this.f34506c = adTemplate;
        this.f34505b = c.g(adTemplate);
        if (z) {
            a(context);
        } else {
            e();
        }
    }

    private void a(Context context) {
        boolean a2 = com.kwad.sdk.core.response.b.a.a(this.f34505b, context);
        if (com.kwad.sdk.core.config.c.a(this.f34505b, context)) {
            a((Presenter) new com.kwad.sdk.reward.b.b());
        }
        if (a2) {
            return;
        }
        a((Presenter) new com.kwad.sdk.reward.b.c.a.b());
        if (c.a(this.f34506c, context)) {
            a((Presenter) new com.kwad.sdk.reward.b.c.a.c());
        }
        if (c.k(this.f34506c)) {
            a((Presenter) new com.kwad.sdk.reward.b.c.a.a());
        }
    }

    private void e() {
        a((Presenter) new com.kwad.sdk.reward.b.c.a.b());
        if (com.kwad.sdk.core.response.b.b.j(this.f34506c)) {
            a((Presenter) new com.kwad.sdk.reward.b.c.a.c());
        }
        if (c.k(this.f34506c)) {
            a((Presenter) new com.kwad.sdk.reward.b.c.a.a());
        }
    }
}
