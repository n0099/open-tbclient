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
    private TextView f;
    private ImageView g;
    private ImageView h;
    private KsLogoView i;

    public g(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f.setText(com.kwad.sdk.core.response.b.a.n(this.b));
        List<String> I = com.kwad.sdk.core.response.b.a.I(this.b);
        this.i.a(adTemplate);
        if (I.size() >= 1) {
            KSImageLoader.loadFeeImage(this.g, I.get(0), this.f6524a);
        } else {
            com.kwad.sdk.core.d.a.d("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        this.h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    protected void c() {
        ((RatioFrameLayout) findViewById(R.id.ksad_container)).setRatio(0.56f);
        this.f = (TextView) findViewById(R.id.ksad_ad_desc);
        this.g = (ImageView) findViewById(R.id.ksad_ad_image);
        this.h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.i = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    protected int getLayoutId() {
        return R.layout.ksad_feed_text_immerse_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.h) {
            l();
        } else if (com.kwad.sdk.core.download.b.d.a(getContext(), this.f6524a, 1) == 1) {
            k();
        } else if (com.kwad.sdk.core.response.b.a.y(this.b)) {
            k();
            FeedDownloadActivityProxy.launch(this.d, this.f6524a, this.c);
        } else {
            k();
            AdWebViewActivityProxy.launch(getContext(), this.f6524a);
        }
    }
}
