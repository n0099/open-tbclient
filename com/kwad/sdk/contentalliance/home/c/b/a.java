package com.kwad.sdk.contentalliance.home.c.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.glide.request.e;
import com.kwad.sdk.utils.ag;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.contentalliance.home.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f9016b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) this.f10751a).i;
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(adTemplate);
        String d = d.d(k);
        String g = ag.a(d) ? d.g(k) : d;
        if (ag.a(g)) {
            return;
        }
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.home.c.a.b) this.f10751a).d).a(g).a((e<Drawable>) new com.kwad.sdk.c(g, adTemplate)).a(this.f9016b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9016b = (ImageView) b(R.id.ksad_slide_profile_cover);
    }
}
