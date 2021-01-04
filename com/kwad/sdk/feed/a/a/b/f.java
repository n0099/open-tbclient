package com.kwad.sdk.feed.a.a.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class f extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f10132b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10751a).i;
        String a2 = com.kwad.sdk.core.response.b.c.o(adTemplate).a();
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) this.f10751a).d).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_small_bg)).c(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_small_bg)).a(this.f10132b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10132b = (ImageView) b(R.id.ksad_feed_item_cover);
    }
}
