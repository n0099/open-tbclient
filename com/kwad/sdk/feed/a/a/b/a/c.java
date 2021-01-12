package com.kwad.sdk.feed.a.a.b.a;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes4.dex */
public class c extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    private TextView f9821b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10452a).i;
        if (com.kwad.sdk.core.response.b.c.b((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10452a).i)) {
            return;
        }
        this.f9821b.setText(com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.j(adTemplate)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9821b = (TextView) b(R.id.ksad_feed_ad_label);
    }
}
