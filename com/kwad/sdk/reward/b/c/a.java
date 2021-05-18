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
    public AdInfo f33750b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f33751c;

    public a(Context context, AdTemplate adTemplate, boolean z) {
        this.f33751c = adTemplate;
        this.f33750b = c.g(adTemplate);
        if (z) {
            a(context);
        } else {
            e();
        }
    }

    private void a(Context context) {
        boolean a2 = com.kwad.sdk.core.response.b.a.a(this.f33750b, context);
        if (com.kwad.sdk.core.config.c.a(this.f33750b, context)) {
            a((Presenter) new com.kwad.sdk.reward.b.b());
        }
        if (a2) {
            return;
        }
        a((Presenter) new com.kwad.sdk.reward.b.c.a.b());
        if (c.a(this.f33751c, context)) {
            a((Presenter) new com.kwad.sdk.reward.b.c.a.c());
        }
        if (c.k(this.f33751c)) {
            a((Presenter) new com.kwad.sdk.reward.b.c.a.a());
        }
    }

    private void e() {
        a((Presenter) new com.kwad.sdk.reward.b.c.a.b());
        if (com.kwad.sdk.core.response.b.b.j(this.f33751c)) {
            a((Presenter) new com.kwad.sdk.reward.b.c.a.c());
        }
        if (c.k(this.f33751c)) {
            a((Presenter) new com.kwad.sdk.reward.b.c.a.a());
        }
    }
}
