package com.kwad.sdk.feed.a.a.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f10128b;
    private ImageView c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10751a).i;
        com.kwad.sdk.core.response.model.c o = com.kwad.sdk.core.response.b.c.o(adTemplate);
        int c = o.c();
        int b2 = o.b();
        String a2 = o.a();
        if (b2 > c) {
            this.f10128b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c.setVisibility(8);
        } else {
            this.f10128b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) this.f10751a).d).a(com.kwad.sdk.core.response.b.c.p(adTemplate)).a(this.c);
            this.c.setVisibility(0);
        }
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) this.f10751a).d).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_bg)).c(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_bg)).a(this.f10128b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c = (ImageView) b(R.id.ksad_feed_item_blur_bg);
        this.f10128b = (ImageView) b(R.id.ksad_feed_item_cover);
    }
}
