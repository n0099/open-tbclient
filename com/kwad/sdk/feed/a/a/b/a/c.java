package com.kwad.sdk.feed.a.a.b.a;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f35582b;

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a;
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36810i;
        if (com.kwad.sdk.core.response.b.c.b((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36810i)) {
            return;
        }
        this.f35582b.setText(com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.j(adTemplate)));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35582b = (TextView) b(R.id.ksad_feed_ad_label);
    }
}
