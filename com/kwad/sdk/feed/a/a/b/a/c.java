package com.kwad.sdk.feed.a.a.b.a;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.feed.a.a.a.a {
    private TextView b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f6892a).i;
        if (com.kwad.sdk.core.response.b.c.b((AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f6892a).i)) {
            return;
        }
        this.b.setText(com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.j(adTemplate)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (TextView) b(R.id.ksad_feed_ad_label);
    }
}
