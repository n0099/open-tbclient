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
/* loaded from: classes3.dex */
public class i extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    private TextView f;
    private RoundAngleImageView g;
    private ImageView h;
    private com.kwad.sdk.core.download.b.b i;
    private TextProgressBar j;
    private TextView k;
    private View l;
    private KsLogoView m;
    private KsAppDownloadListener n;

    public i(@NonNull Context context) {
        super(context);
        this.n = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.widget.i.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                i.this.k.setVisibility(8);
                i.this.j.setVisibility(0);
                i.this.j.a(com.kwad.sdk.core.response.b.a.a(), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                i.this.k.setText(com.kwad.sdk.core.response.b.a.w(i.this.f9863b));
                i.this.k.setVisibility(0);
                i.this.j.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                i.this.k.setVisibility(8);
                i.this.j.setVisibility(0);
                i.this.j.a(com.kwad.sdk.core.response.b.a.a(i.this.f9862a), i.this.j.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                i.this.k.setText(com.kwad.sdk.core.response.b.a.w(i.this.f9863b));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                i.this.k.setVisibility(8);
                i.this.j.setVisibility(0);
                i.this.j.a(com.kwad.sdk.core.response.b.a.b(), i.this.j.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                i.this.k.setVisibility(8);
                i.this.j.setVisibility(0);
                i.this.j.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }
        };
    }

    private void f() {
        this.k = (TextView) findViewById(R.id.ksad_app_download_before);
        this.k.setText(com.kwad.sdk.core.response.b.a.w(this.f9863b));
        this.k.setVisibility(0);
        this.k.setOnClickListener(this);
        this.m.a(this.f9862a);
        this.j = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.j.setTextDimen(ao.a(getContext(), 11.0f));
        this.j.a(-1, -45056);
        this.j.setVisibility(8);
        this.l.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.y(this.f9863b)) {
            this.i = new com.kwad.sdk.core.download.b.b(this.f9862a, null, this.n);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f.setText(com.kwad.sdk.core.response.b.a.n(this.f9863b));
        List<String> I = com.kwad.sdk.core.response.b.a.I(this.f9863b);
        if (I.size() >= 1) {
            KSImageLoader.loadFeeImage(this.g, I.get(0), this.f9862a);
        } else {
            com.kwad.sdk.core.d.a.d("FeedTextRightImageView", "getImageUrlList size less than one");
        }
        f();
        this.h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    protected void c() {
        this.f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.66f);
        this.g = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.g.setRadius(ao.a(getContext(), 3.0f));
        this.h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.l = findViewById(R.id.ksad_app_download_cover);
        this.m = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    protected int getLayoutId() {
        return R.layout.ksad_feed_text_right_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.h) {
            l();
            return;
        }
        com.kwad.sdk.core.download.b.b.a(this.i, view == this.l);
        com.kwad.sdk.core.download.b.a.a(ao.a(this), this.f9862a, new a.InterfaceC1094a() { // from class: com.kwad.sdk.feed.widget.i.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1094a
            public void a() {
                i.this.k();
            }
        }, this.i);
    }
}
