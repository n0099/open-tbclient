package com.kwad.sdk.feed.a.a.b;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.RCRatioFrameLayout;
/* loaded from: classes5.dex */
public class e extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    private RCRatioFrameLayout f10132b;
    private ImageView c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10752a).i;
        com.kwad.sdk.core.response.model.c o = com.kwad.sdk.core.response.b.c.o(adTemplate);
        int c = o.c();
        int b2 = o.b();
        String a2 = o.a();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f10132b.getLayoutParams();
        if (b2 >= c) {
            marginLayoutParams.width = ao.a(o(), R.dimen.ksad_content_feed_item_single_large_width);
            this.f10132b.setRatio(1.3333334f);
        } else {
            marginLayoutParams.width = -1;
            this.f10132b.setRatio(0.75f);
        }
        this.f10132b.setLayoutParams(marginLayoutParams);
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) this.f10752a).d).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_large_bg)).c(o().getResources().getDrawable(R.drawable.ksad_feed_item_cover_large_bg)).a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10132b = (RCRatioFrameLayout) b(R.id.ksad_cover_container);
        this.c = (ImageView) b(R.id.ksad_feed_item_cover);
    }
}
