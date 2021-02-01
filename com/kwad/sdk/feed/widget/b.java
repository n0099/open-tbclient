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
public class b extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    private TextView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private KsLogoView k;

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f.setText(com.kwad.sdk.core.response.b.a.n(this.f9863b));
        this.k.a(adTemplate);
        List<String> I = com.kwad.sdk.core.response.b.a.I(this.f9863b);
        if (I.size() >= 3) {
            KSImageLoader.loadFeeImage(this.g, I.get(0), this.f9862a);
            KSImageLoader.loadFeeImage(this.h, I.get(1), this.f9862a);
            KSImageLoader.loadFeeImage(this.i, I.get(2), this.f9862a);
        } else {
            com.kwad.sdk.core.d.a.d("FeedTextAboveGroupImageView", "getImageUrlList size less than three");
        }
        this.j.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    protected void c() {
        this.f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
        this.g = (ImageView) findViewById(R.id.ksad_ad_image_left);
        this.h = (ImageView) findViewById(R.id.ksad_ad_image_mid);
        this.i = (ImageView) findViewById(R.id.ksad_ad_image_right);
        this.j = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.k = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    protected int getLayoutId() {
        return R.layout.ksad_feed_text_above_group_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.j) {
            l();
        } else if (com.kwad.sdk.core.download.b.d.a(getContext(), this.f9862a, 1) == 1) {
            k();
        } else if (com.kwad.sdk.core.response.b.a.y(this.f9863b)) {
            k();
            FeedDownloadActivityProxy.launch(this.d, this.f9862a, this.c);
        } else {
            k();
            AdWebViewActivityProxy.launch(getContext(), this.f9862a);
        }
    }
}
