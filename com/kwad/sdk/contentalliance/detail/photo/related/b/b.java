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
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.contentalliance.detail.photo.related.a.a {

    /* renamed from: b  reason: collision with root package name */
    private View f8876b;
    private ImageView c;
    private int d;
    private int e;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) this.f10751a).i;
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(adTemplate);
        int e = com.kwad.sdk.core.response.b.d.e(k);
        int f = com.kwad.sdk.core.response.b.d.f(k);
        ViewGroup.LayoutParams layoutParams = this.f8876b.getLayoutParams();
        if (e <= 0 || f <= 0) {
            layoutParams.height = this.e;
            com.kwad.sdk.core.d.a.a("LookRelatedCoverPresenter", "videoWidth or videoHeight is 0 int position=" + ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) this.f10751a).h);
        } else {
            layoutParams.height = (int) (((f * this.d) * 1.0f) / e);
        }
        this.f8876b.setLayoutParams(layoutParams);
        String g = com.kwad.sdk.core.response.b.d.g(k);
        String d = ag.a(g) ? com.kwad.sdk.core.response.b.d.d(k) : g;
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.detail.photo.related.a.b) this.f10751a).d).a(d).a((e<Drawable>) new com.kwad.sdk.c(d, adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_realted_video_cover_bg)).c(o().getResources().getDrawable(R.drawable.ksad_realted_video_cover_bg)).a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8876b = b(R.id.ksad_related_video_item_root);
        this.c = (ImageView) b(R.id.ksad_related_video_cover);
        this.d = ((ao.c(o()) - ao.a(o(), R.dimen.ksad_content_related_video_item_padding)) - (ao.a(o(), R.dimen.ksad_content_related_video_item_margin) * 2)) / 2;
        this.e = ao.a(o(), R.dimen.ksad_content_related_video_item_default_height);
    }
}
