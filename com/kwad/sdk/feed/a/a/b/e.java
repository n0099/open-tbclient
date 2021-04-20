package com.kwad.sdk.feed.a.a.b;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.RCRatioFrameLayout;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public RCRatioFrameLayout f35139b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f35140c;

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        RCRatioFrameLayout rCRatioFrameLayout;
        float f2;
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).i;
        com.kwad.sdk.core.response.model.c o = com.kwad.sdk.core.response.b.c.o(adTemplate);
        int c2 = o.c();
        int b2 = o.b();
        String a2 = o.a();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35139b.getLayoutParams();
        if (b2 >= c2) {
            marginLayoutParams.width = ao.a(o(), R.dimen.ksad_content_feed_item_single_large_width);
            rCRatioFrameLayout = this.f35139b;
            f2 = 1.3333334f;
        } else {
            marginLayoutParams.width = -1;
            rCRatioFrameLayout = this.f35139b;
            f2 = 0.75f;
        }
        rCRatioFrameLayout.setRatio(f2);
        this.f35139b.setLayoutParams(marginLayoutParams);
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).f36292d).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_large_bg)).c(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_large_bg)).a(this.f35140c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35139b = (RCRatioFrameLayout) b(R.id.ksad_cover_container);
        this.f35140c = (ImageView) b(R.id.ksad_feed_item_cover);
    }
}
