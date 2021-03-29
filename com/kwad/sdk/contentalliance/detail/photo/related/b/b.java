package com.kwad.sdk.contentalliance.detail.photo.related.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.glide.request.e;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.photo.related.a.a {

    /* renamed from: b  reason: collision with root package name */
    public View f32482b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f32483c;

    /* renamed from: d  reason: collision with root package name */
    public int f32484d;

    /* renamed from: e  reason: collision with root package name */
    public int f32485e;

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36008a).i;
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(adTemplate);
        int e2 = com.kwad.sdk.core.response.b.d.e(k);
        int f2 = com.kwad.sdk.core.response.b.d.f(k);
        ViewGroup.LayoutParams layoutParams = this.f32482b.getLayoutParams();
        if (e2 <= 0 || f2 <= 0) {
            layoutParams.height = this.f32485e;
            com.kwad.sdk.core.d.a.a("LookRelatedCoverPresenter", "videoWidth or videoHeight is 0 int position=" + ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36008a).f36007h);
        } else {
            layoutParams.height = (int) (((this.f32484d * f2) * 1.0f) / e2);
        }
        this.f32482b.setLayoutParams(layoutParams);
        String g2 = com.kwad.sdk.core.response.b.d.g(k);
        if (ag.a(g2)) {
            g2 = com.kwad.sdk.core.response.b.d.d(k);
        }
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36008a).f36003d).a(g2).a((e<Drawable>) new com.kwad.sdk.c(g2, adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_realted_video_cover_bg)).c(o().getResources().getDrawable(R.drawable.ksad_realted_video_cover_bg)).a(this.f32483c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32482b = b(R.id.ksad_related_video_item_root);
        this.f32483c = (ImageView) b(R.id.ksad_related_video_cover);
        this.f32484d = ((ao.c(o()) - ao.a(o(), R.dimen.ksad_content_related_video_item_padding)) - (ao.a(o(), R.dimen.ksad_content_related_video_item_margin) * 2)) / 2;
        this.f32485e = ao.a(o(), R.dimen.ksad_content_related_video_item_default_height);
    }
}
