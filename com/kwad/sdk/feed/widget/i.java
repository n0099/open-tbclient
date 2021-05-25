package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f33227f;

    /* renamed from: g  reason: collision with root package name */
    public RoundAngleImageView f33228g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33229h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33230i;
    public KsLogoView j;
    public DownloadProgressView k;

    public i(@NonNull Context context) {
        super(context);
    }

    private void e() {
        this.j.a(((com.kwad.sdk.feed.widget.base.a) this).f33198a);
        this.k.a(((com.kwad.sdk.feed.widget.base.a) this).f33198a);
        this.k.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.v(this.f33199b)) {
            com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f33198a, null, this.k.getAppDownloadListener());
            this.f33230i = bVar;
            bVar.c(this.k.getAppDownloadListener());
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f33227f.setText(com.kwad.sdk.core.response.b.a.m(this.f33199b));
        List<String> E = com.kwad.sdk.core.response.b.a.E(this.f33199b);
        if (E.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f33228g, E.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f33198a);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextRightImageView", "getImageUrlList size less than one");
        }
        e();
        this.f33229h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f33227f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.66f);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.f33228g = roundAngleImageView;
        roundAngleImageView.setRadius(an.a(getContext(), 3.0f));
        this.f33229h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.k = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.j = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_right_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33229h) {
            l();
        } else {
            com.kwad.sdk.core.download.b.a.a(an.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f33198a, new a.InterfaceC0364a() { // from class: com.kwad.sdk.feed.widget.i.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
                public void a() {
                    i.this.k();
                }
            }, this.f33230i, view == this.k);
        }
    }
}
