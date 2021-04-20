package com.kwad.sdk.feed.a.a.b.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.c;
import com.kwad.sdk.glide.load.h;
import com.kwad.sdk.utils.ag;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35130b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35131c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35132d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35133e;

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a;
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).i;
        c.a(((com.kwad.sdk.feed.a.a.a.b) callercontext).f36292d).a(com.kwad.sdk.core.response.b.c.q(adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f35130b);
        String v = com.kwad.sdk.core.response.b.c.v(adTemplate);
        if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            v = o().getString(R.string.ksad_ad_default_username_normal);
        }
        this.f35131c.setText(v);
        String x = com.kwad.sdk.core.response.b.c.x(adTemplate);
        if (ag.a(x)) {
            this.f35132d.setVisibility(8);
        } else {
            this.f35132d.setText(x);
            this.f35132d.setVisibility(0);
        }
        this.f35133e.setText(String.format("%s 人点赞", ag.a(d.m(adTemplate.photoInfo))));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35130b = (ImageView) b(R.id.ksad_feed_item_author_icon);
        this.f35131c = (TextView) b(R.id.ksad_feed_item_author_name);
        this.f35132d = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f35133e = (TextView) b(R.id.ksad_feed_item_author_like_count);
    }
}
