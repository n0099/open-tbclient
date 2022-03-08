package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.FeedDownloadActivityProxy;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f55440f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f55441g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55442h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f55443i;

    /* renamed from: j  reason: collision with root package name */
    public KsLogoView f55444j;

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f55446c));
        this.f55444j.a(adTemplate);
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f55446c);
        if (O.size() >= 3) {
            KSImageLoader.loadFeeImage(this.f55440f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f55445b);
            KSImageLoader.loadFeeImage(this.f55441g, O.get(1), ((com.kwad.sdk.feed.widget.base.a) this).f55445b);
            KSImageLoader.loadFeeImage(this.f55442h, O.get(2), ((com.kwad.sdk.feed.widget.base.a) this).f55445b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextAboveGroupImageView", "getImageUrlList size less than three");
        }
        this.f55443i.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.a = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
        this.f55440f = (ImageView) findViewById(R.id.ksad_ad_image_left);
        this.f55441g = (ImageView) findViewById(R.id.ksad_ad_image_mid);
        this.f55442h = (ImageView) findViewById(R.id.ksad_ad_image_right);
        this.f55443i = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.f55444j = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_above_group_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f55443i) {
            m();
        } else if (com.kwad.sdk.core.download.a.d.a(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f55445b, 1) == 1) {
            k();
        } else {
            boolean B = com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f55446c);
            k();
            if (B) {
                FeedDownloadActivityProxy.launch(((com.kwad.sdk.feed.widget.base.a) this).f55448e, ((com.kwad.sdk.feed.widget.base.a) this).f55445b, ((com.kwad.sdk.feed.widget.base.a) this).f55447d);
            } else {
                AdWebViewActivityProxy.launch(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f55445b);
            }
        }
    }
}
