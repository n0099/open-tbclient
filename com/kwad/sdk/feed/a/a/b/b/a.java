package com.kwad.sdk.feed.a.a.b.b;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.load.h;
import com.kwad.sdk.utils.ag;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f34836b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34837c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34838d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34839e;

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i;
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).i;
        String x = c.x(adTemplate);
        if (ag.a(x)) {
            textView = this.f34836b;
            i = 8;
        } else {
            this.f34836b.setText(x);
            textView = this.f34836b;
            i = 0;
        }
        textView.setVisibility(i);
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).f36002d).a(c.q(adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f34837c);
        String v = c.v(adTemplate);
        if (ag.a(v) && c.c(adTemplate)) {
            v = o().getString(R.string.ksad_ad_default_username_normal);
        }
        this.f34838d.setText(v);
        this.f34839e.setText(ag.a(d.m(adTemplate.photoInfo)));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f34836b = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.f34837c = (ImageView) b(R.id.ksad_feed_item_author_icon);
        this.f34838d = (TextView) b(R.id.ksad_feed_item_author_name);
        this.f34839e = (TextView) b(R.id.ksad_feed_item_author_like_count);
    }
}
