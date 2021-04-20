package com.kwad.sdk.feed.a.a.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35134b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f35135c;

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        ImageView imageView;
        int i;
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).i;
        com.kwad.sdk.core.response.model.c o = com.kwad.sdk.core.response.b.c.o(adTemplate);
        int c2 = o.c();
        int b2 = o.b();
        String a2 = o.a();
        if (b2 > c2) {
            this.f35134b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView = this.f35135c;
            i = 8;
        } else {
            this.f35134b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).f36292d).a(com.kwad.sdk.core.response.b.c.p(adTemplate)).a(this.f35135c);
            imageView = this.f35135c;
            i = 0;
        }
        imageView.setVisibility(i);
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).f36292d).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_bg)).c(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_bg)).a(this.f35134b);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35135c = (ImageView) b(R.id.ksad_feed_item_blur_bg);
        this.f35134b = (ImageView) b(R.id.ksad_feed_item_cover);
    }
}
