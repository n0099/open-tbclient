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
    public TextView f34044f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f34045g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34046h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f34047i;

    public g(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f34044f.setText(com.kwad.sdk.core.response.b.a.m(this.f34025b));
        List<String> E = com.kwad.sdk.core.response.b.a.E(this.f34025b);
        this.f34047i.a(adTemplate);
        if (E.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f34045g, E.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f34024a);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        this.f34046h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        ((RatioFrameLayout) findViewById(R.id.ksad_container)).setRatio(0.56f);
        this.f34044f = (TextView) findViewById(R.id.ksad_ad_desc);
        this.f34045g = (ImageView) findViewById(R.id.ksad_ad_image);
        this.f34046h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.f34047i = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_immerse_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f34046h) {
            l();
        } else if (com.kwad.sdk.core.download.b.d.a(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f34024a, 1) == 1) {
            k();
        } else {
            boolean v = com.kwad.sdk.core.response.b.a.v(this.f34025b);
            k();
            if (v) {
                FeedDownloadActivityProxy.launch(this.f34027d, ((com.kwad.sdk.feed.widget.base.a) this).f34024a, this.f34026c);
            } else {
                AdWebViewActivityProxy.launch(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f34024a);
            }
        }
    }
}
