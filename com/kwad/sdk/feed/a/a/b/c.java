package com.kwad.sdk.feed.a.a.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35507b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f35508c;

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        ImageView imageView;
        int i2;
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36713a).f36712i;
        com.kwad.sdk.core.response.model.c o = com.kwad.sdk.core.response.b.c.o(adTemplate);
        int c2 = o.c();
        int b2 = o.b();
        String a2 = o.a();
        if (b2 > c2) {
            this.f35507b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView = this.f35508c;
            i2 = 8;
        } else {
            this.f35507b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36713a).f36707d).a(com.kwad.sdk.core.response.b.c.p(adTemplate)).a(this.f35508c);
            imageView = this.f35508c;
            i2 = 0;
        }
        imageView.setVisibility(i2);
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36713a).f36707d).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_bg)).c(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_bg)).a(this.f35507b);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35508c = (ImageView) b(R.id.ksad_feed_item_blur_bg);
        this.f35507b = (ImageView) b(R.id.ksad_feed_item_cover);
    }
}
