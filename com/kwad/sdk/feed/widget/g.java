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
/* loaded from: classes7.dex */
public class g extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f35601f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f35602g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f35603h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f35604i;

    public g(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f35601f.setText(com.kwad.sdk.core.response.b.a.n(this.f35579b));
        List<String> I = com.kwad.sdk.core.response.b.a.I(this.f35579b);
        this.f35604i.a(adTemplate);
        if (I.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f35602g, I.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f35578a);
        } else {
            com.kwad.sdk.core.d.a.d("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        this.f35603h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        ((RatioFrameLayout) findViewById(R.id.ksad_container)).setRatio(0.56f);
        this.f35601f = (TextView) findViewById(R.id.ksad_ad_desc);
        this.f35602g = (ImageView) findViewById(R.id.ksad_ad_image);
        this.f35603h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.f35604i = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_immerse_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35603h) {
            l();
        } else if (com.kwad.sdk.core.download.b.d.a(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f35578a, 1) == 1) {
            k();
        } else {
            boolean y = com.kwad.sdk.core.response.b.a.y(this.f35579b);
            k();
            if (y) {
                FeedDownloadActivityProxy.launch(this.f35581d, ((com.kwad.sdk.feed.widget.base.a) this).f35578a, this.f35580c);
            } else {
                AdWebViewActivityProxy.launch(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f35578a);
            }
        }
    }
}
