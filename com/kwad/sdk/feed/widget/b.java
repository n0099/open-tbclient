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
public class b extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f35573f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f35574g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f35575h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f35576i;
    public ImageView j;
    public KsLogoView k;

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f35573f.setText(com.kwad.sdk.core.response.b.a.n(this.f35579b));
        this.k.a(adTemplate);
        List<String> I = com.kwad.sdk.core.response.b.a.I(this.f35579b);
        if (I.size() >= 3) {
            KSImageLoader.loadFeeImage(this.f35574g, I.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f35578a);
            KSImageLoader.loadFeeImage(this.f35575h, I.get(1), ((com.kwad.sdk.feed.widget.base.a) this).f35578a);
            KSImageLoader.loadFeeImage(this.f35576i, I.get(2), ((com.kwad.sdk.feed.widget.base.a) this).f35578a);
        } else {
            com.kwad.sdk.core.d.a.d("FeedTextAboveGroupImageView", "getImageUrlList size less than three");
        }
        this.j.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f35573f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
        this.f35574g = (ImageView) findViewById(R.id.ksad_ad_image_left);
        this.f35575h = (ImageView) findViewById(R.id.ksad_ad_image_mid);
        this.f35576i = (ImageView) findViewById(R.id.ksad_ad_image_right);
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
