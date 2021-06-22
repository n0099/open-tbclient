package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes7.dex */
public class h extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f35703f;

    /* renamed from: g  reason: collision with root package name */
    public RoundAngleImageView f35704g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f35705h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35706i;
    public TextProgressBar j;
    public TextView k;
    public View l;
    public KsLogoView m;
    public KsAppDownloadListener n;

    public h(@NonNull Context context) {
        super(context);
        this.n = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.widget.h.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                h.this.k.setVisibility(8);
                h.this.j.setVisibility(0);
                h.this.j.a(com.kwad.sdk.core.response.b.a.a(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                h.this.k.setText(com.kwad.sdk.core.response.b.a.w(h.this.f35677b));
                h.this.k.setVisibility(0);
                h.this.j.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                h.this.k.setVisibility(8);
                h.this.j.setVisibility(0);
                h.this.j.a(com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) h.this).f35676a), h.this.j.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                h.this.k.setText(com.kwad.sdk.core.response.b.a.w(h.this.f35677b));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                h.this.k.setVisibility(8);
                h.this.j.setVisibility(0);
                h.this.j.a(com.kwad.sdk.core.response.b.a.b(), h.this.j.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                h.this.k.setVisibility(8);
                h.this.j.setVisibility(0);
                h.this.j.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        };
    }

    private void f() {
        this.m.a(((com.kwad.sdk.feed.widget.base.a) this).f35676a);
        this.k.setText(com.kwad.sdk.core.response.b.a.w(this.f35677b));
        this.k.setVisibility(0);
        this.k.setOnClickListener(this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.j = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 11.0f));
        this.j.a(-1, -45056);
        this.j.setVisibility(8);
        this.l.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.y(this.f35677b)) {
            this.f35706i = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f35676a, null, this.n);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f35703f.setText(com.kwad.sdk.core.response.b.a.n(this.f35677b));
        List<String> I = com.kwad.sdk.core.response.b.a.I(this.f35677b);
        if (I.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f35704g, I.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f35676a);
        } else {
            com.kwad.sdk.core.d.a.d("FeedTextLeftImageView", "getImageUrlList size less than one");
        }
        f();
        this.f35705h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f35703f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.66f);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.f35704g = roundAngleImageView;
        roundAngleImageView.setRadius(ao.a(getContext(), 3.0f));
        this.f35705h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.l = findViewById(R.id.ksad_app_download_cover);
        this.k = (TextView) findViewById(R.id.ksad_app_download_before);
        this.m = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_left_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35705h) {
            l();
            return;
        }
        com.kwad.sdk.core.download.b.b.a(this.f35706i, view == this.l);
        com.kwad.sdk.core.download.b.a.a(ao.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f35676a, new a.InterfaceC0382a() { // from class: com.kwad.sdk.feed.widget.h.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                h.this.k();
            }
        }, this.f35706i);
    }
}
