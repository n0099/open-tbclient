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
public class b extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f34019f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f34020g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34021h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f34022i;
    public ImageView j;
    public KsLogoView k;

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f34019f.setText(com.kwad.sdk.core.response.b.a.m(this.f34025b));
        this.k.a(adTemplate);
        List<String> E = com.kwad.sdk.core.response.b.a.E(this.f34025b);
        if (E.size() >= 3) {
            KSImageLoader.loadFeeImage(this.f34020g, E.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f34024a);
            KSImageLoader.loadFeeImage(this.f34021h, E.get(1), ((com.kwad.sdk.feed.widget.base.a) this).f34024a);
            KSImageLoader.loadFeeImage(this.f34022i, E.get(2), ((com.kwad.sdk.feed.widget.base.a) this).f34024a);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextAboveGroupImageView", "getImageUrlList size less than three");
        }
        this.j.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f34019f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
        this.f34020g = (ImageView) findViewById(R.id.ksad_ad_image_left);
        this.f34021h = (ImageView) findViewById(R.id.ksad_ad_image_mid);
        this.f34022i = (ImageView) findViewById(R.id.ksad_ad_image_right);
        this.j = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.k = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_above_group_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.j) {
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
