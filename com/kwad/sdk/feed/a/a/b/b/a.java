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
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    private TextView f10126b;
    private ImageView c;
    private TextView d;
    private TextView e;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10751a).i;
        String x = c.x(adTemplate);
        if (ag.a(x)) {
            this.f10126b.setVisibility(8);
        } else {
            this.f10126b.setText(x);
            this.f10126b.setVisibility(0);
        }
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.feed.a.a.a.b) this.f10751a).d).a(c.q(adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.c);
        String v = c.v(adTemplate);
        if (ag.a(v) && c.c(adTemplate)) {
            v = o().getString(R.string.ksad_ad_default_username_normal);
        }
        this.d.setText(v);
        this.e.setText(ag.a(d.m(adTemplate.photoInfo)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10126b = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.c = (ImageView) b(R.id.ksad_feed_item_author_icon);
        this.d = (TextView) b(R.id.ksad_feed_item_author_name);
        this.e = (TextView) b(R.id.ksad_feed_item_author_like_count);
    }
}
