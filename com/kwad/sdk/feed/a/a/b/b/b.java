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
    public ImageView f35225b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35226c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35227d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35228e;

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36392a;
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).i;
        c.a(((com.kwad.sdk.feed.a.a.a.b) callercontext).f36387d).a(com.kwad.sdk.core.response.b.c.q(adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f35225b);
        String v = com.kwad.sdk.core.response.b.c.v(adTemplate);
        if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            v = o().getString(R.string.ksad_ad_default_username_normal);
        }
        this.f35226c.setText(v);
        String x = com.kwad.sdk.core.response.b.c.x(adTemplate);
        if (ag.a(x)) {
            this.f35227d.setVisibility(8);
        } else {
            this.f35227d.setText(x);
            this.f35227d.setVisibility(0);
        }
        this.f35228e.setText(String.format("%s 人点赞", ag.a(d.m(adTemplate.photoInfo))));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f35225b = (ImageView) b(R.id.ksad_feed_item_author_icon);
        this.f35226c = (TextView) b(R.id.ksad_feed_item_author_name);
        this.f35227d = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f35228e = (TextView) b(R.id.ksad_feed_item_author_like_count);
    }
}
