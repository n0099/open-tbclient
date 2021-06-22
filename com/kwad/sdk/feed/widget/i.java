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
public class i extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f35709f;

    /* renamed from: g  reason: collision with root package name */
    public RoundAngleImageView f35710g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f35711h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35712i;
    public TextProgressBar j;
    public TextView k;
    public View l;
    public KsLogoView m;
    public KsAppDownloadListener n;

    public i(@NonNull Context context) {
        super(context);
        this.n = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.widget.i.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                i.this.k.setVisibility(8);
                i.this.j.setVisibility(0);
                i.this.j.a(com.kwad.sdk.core.response.b.a.a(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                i.this.k.setText(com.kwad.sdk.core.response.b.a.w(i.this.f35677b));
                i.this.k.setVisibility(0);
                i.this.j.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                i.this.k.setVisibility(8);
                i.this.j.setVisibility(0);
                i.this.j.a(com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) i.this).f35676a), i.this.j.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                i.this.k.setText(com.kwad.sdk.core.response.b.a.w(i.this.f35677b));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                i.this.k.setVisibility(8);
                i.this.j.setVisibility(0);
                i.this.j.a(com.kwad.sdk.core.response.b.a.b(), i.this.j.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                i.this.k.setVisibility(8);
                i.this.j.setVisibility(0);
                i.this.j.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        };
    }

    private void f() {
        TextView textView = (TextView) findViewById(R.id.ksad_app_download_before);
        this.k = textView;
        textView.setText(com.kwad.sdk.core.response.b.a.w(this.f35677b));
        this.k.setVisibility(0);
        this.k.setOnClickListener(this);
        this.m.a(((com.kwad.sdk.feed.widget.base.a) this).f35676a);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.j = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 11.0f));
        this.j.a(-1, -45056);
        this.j.setVisibility(8);
        this.l.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.y(this.f35677b)) {
            this.f35712i = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f35676a, null, this.n);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f35709f.setText(com.kwad.sdk.core.response.b.a.n(this.f35677b));
        List<String> I = com.kwad.sdk.core.response.b.a.I(this.f35677b);
        if (I.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f35710g, I.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f35676a);
        } else {
            com.kwad.sdk.core.d.a.d("FeedTextRightImageView", "getImageUrlList size less than one");
        }
        f();
        this.f35711h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f35709f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.66f);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.f35710g = roundAngleImageView;
        roundAngleImageView.setRadius(ao.a(getContext(), 3.0f));
        this.f35711h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.l = findViewById(R.id.ksad_app_download_cover);
        this.m = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_right_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35711h) {
            l();
            return;
        }
        com.kwad.sdk.core.download.b.b.a(this.f35712i, view == this.l);
        com.kwad.sdk.core.download.b.a.a(ao.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f35676a, new a.InterfaceC0382a() { // from class: com.kwad.sdk.feed.widget.i.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                i.this.k();
            }
        }, this.f35712i);
    }
}
