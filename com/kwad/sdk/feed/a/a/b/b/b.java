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
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.feed.a.a.a.a {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f9830b;
    private TextView c;
    private TextView d;
    private TextView e;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f10454a).i;
        c.a(((com.kwad.sdk.feed.a.a.a.b) this.f10454a).d).a(com.kwad.sdk.core.response.b.c.q(adTemplate)).a(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).c(o().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a((h<Bitmap>) new com.kwad.sdk.support.a()).a(this.f9830b);
        String v = com.kwad.sdk.core.response.b.c.v(adTemplate);
        if (ag.a(v) && com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            v = o().getString(R.string.ksad_ad_default_username_normal);
        }
        this.c.setText(v);
        String x = com.kwad.sdk.core.response.b.c.x(adTemplate);
        if (ag.a(x)) {
            this.d.setVisibility(8);
        } else {
            this.d.setText(x);
            this.d.setVisibility(0);
        }
        this.e.setText(String.format("%s 人点赞", ag.a(d.m(adTemplate.photoInfo))));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9830b = (ImageView) b(R.id.ksad_feed_item_author_icon);
        this.c = (TextView) b(R.id.ksad_feed_item_author_name);
        this.d = (TextView) b(R.id.ksad_feed_item_photo_desc);
        this.e = (TextView) b(R.id.ksad_feed_item_author_like_count);
    }
}
