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
/* loaded from: classes3.dex */
public class g extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56942f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56943g;

    /* renamed from: h  reason: collision with root package name */
    public KsLogoView f56944h;

    public g(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f56929c));
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f56929c);
        this.f56944h.a(adTemplate);
        if (O.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f56942f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f56928b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        this.f56943g.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        ((RatioFrameLayout) findViewById(R.id.ksad_container)).setRatio(0.56f);
        this.a = (TextView) findViewById(R.id.ksad_ad_desc);
        this.f56942f = (ImageView) findViewById(R.id.ksad_ad_image);
        this.f56943g = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.f56944h = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_immerse_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56943g) {
            m();
        } else if (com.kwad.sdk.core.download.a.d.a(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f56928b, 1) == 1) {
            k();
        } else {
            boolean B = com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f56929c);
            k();
            if (B) {
                FeedDownloadActivityProxy.launch(((com.kwad.sdk.feed.widget.base.a) this).f56931e, ((com.kwad.sdk.feed.widget.base.a) this).f56928b, ((com.kwad.sdk.feed.widget.base.a) this).f56930d);
            } else {
                AdWebViewActivityProxy.launch(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f56928b);
            }
        }
    }
}
