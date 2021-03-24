package com.kwad.sdk.contentalliance.home.c.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.glide.request.e;
import com.kwad.sdk.utils.ag;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.home.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32737b;

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).i;
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(adTemplate);
        String d2 = d.d(k);
        if (ag.a(d2)) {
            d2 = d.g(k);
        }
        if (ag.a(d2)) {
            return;
        }
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.home.c.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).f36002d).a(d2).a((e<Drawable>) new com.kwad.sdk.c(d2, adTemplate)).a(this.f32737b);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32737b = (ImageView) b(R.id.ksad_slide_profile_cover);
    }
}
