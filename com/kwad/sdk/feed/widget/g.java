package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.FeedDownloadActivityProxy;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes6.dex */
public class g extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f33289f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f33290g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33291h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f33292i;

    public g(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f33289f.setText(com.kwad.sdk.core.response.b.a.m(this.f33270b));
        List<String> E = com.kwad.sdk.core.response.b.a.E(this.f33270b);
        this.f33292i.a(adTemplate);
        if (E.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f33290g, E.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f33269a);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        this.f33291h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        ((RatioFrameLayout) findViewById(R.id.ksad_container)).setRatio(0.56f);
        this.f33289f = (TextView) findViewById(R.id.ksad_ad_desc);
        this.f33290g = (ImageView) findViewById(R.id.ksad_ad_image);
        this.f33291h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.f33292i = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_immerse_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33291h) {
            l();
        } else if (com.kwad.sdk.core.download.b.d.a(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f33269a, 1) == 1) {
            k();
        } else {
            boolean v = com.kwad.sdk.core.response.b.a.v(this.f33270b);
            k();
            if (v) {
                FeedDownloadActivityProxy.launch(this.f33272d, ((com.kwad.sdk.feed.widget.base.a) this).f33269a, this.f33271c);
            } else {
                AdWebViewActivityProxy.launch(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f33269a);
            }
        }
    }
}
