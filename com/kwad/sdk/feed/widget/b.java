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
    public TextView f34908f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f34909g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34910h;
    public ImageView i;
    public ImageView j;
    public KsLogoView k;

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f34908f.setText(com.kwad.sdk.core.response.b.a.n(this.f34913b));
        this.k.a(adTemplate);
        List<String> I = com.kwad.sdk.core.response.b.a.I(this.f34913b);
        if (I.size() >= 3) {
            KSImageLoader.loadFeeImage(this.f34909g, I.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f34912a);
            KSImageLoader.loadFeeImage(this.f34910h, I.get(1), ((com.kwad.sdk.feed.widget.base.a) this).f34912a);
            KSImageLoader.loadFeeImage(this.i, I.get(2), ((com.kwad.sdk.feed.widget.base.a) this).f34912a);
        } else {
            com.kwad.sdk.core.d.a.d("FeedTextAboveGroupImageView", "getImageUrlList size less than three");
        }
        this.j.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f34908f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
        this.f34909g = (ImageView) findViewById(R.id.ksad_ad_image_left);
        this.f34910h = (ImageView) findViewById(R.id.ksad_ad_image_mid);
        this.i = (ImageView) findViewById(R.id.ksad_ad_image_right);
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
        } else if (com.kwad.sdk.core.download.b.d.a(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f34912a, 1) == 1) {
            k();
        } else {
            boolean y = com.kwad.sdk.core.response.b.a.y(this.f34913b);
            k();
            if (y) {
                FeedDownloadActivityProxy.launch(this.f34915d, ((com.kwad.sdk.feed.widget.base.a) this).f34912a, this.f34914c);
            } else {
                AdWebViewActivityProxy.launch(getContext(), ((com.kwad.sdk.feed.widget.base.a) this).f34912a);
            }
        }
    }
}
