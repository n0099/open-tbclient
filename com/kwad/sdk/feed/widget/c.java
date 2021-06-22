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
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f35687f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f35688g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f35689h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35690i;
    public TextView j;
    public TextProgressBar k;
    public View l;
    public KsLogoView m;
    public KsAppDownloadListener n;

    public c(@NonNull Context context) {
        super(context);
        this.n = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.widget.c.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                c.this.j.setVisibility(8);
                c.this.k.setVisibility(0);
                c.this.k.a(com.kwad.sdk.core.response.b.a.a(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                c.this.j.setText(com.kwad.sdk.core.response.b.a.w(c.this.f35677b));
                c.this.j.setVisibility(0);
                c.this.k.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                c.this.j.setVisibility(8);
                c.this.k.setVisibility(0);
                c.this.k.a(com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) c.this).f35676a), c.this.k.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                c.this.j.setText(com.kwad.sdk.core.response.b.a.w(c.this.f35677b));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                c.this.j.setVisibility(8);
                c.this.k.setVisibility(0);
                c.this.k.a(com.kwad.sdk.core.response.b.a.b(), c.this.k.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                c.this.j.setVisibility(8);
                c.this.k.setVisibility(0);
                c.this.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
            }
        };
    }

    private void f() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
        ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f35677b));
        textView.setText(com.kwad.sdk.core.response.b.a.w(this.f35677b));
        findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void g() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.b.a.q(this.f35677b));
        KSImageLoader.loadAppIcon((ImageView) findViewById(R.id.ksad_app_icon), com.kwad.sdk.core.response.b.a.o(this.f35677b), ((com.kwad.sdk.feed.widget.base.a) this).f35676a, 8);
        ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f35677b));
        TextView textView = (TextView) findViewById(R.id.ksad_app_download_before);
        this.j = textView;
        textView.setText(com.kwad.sdk.core.response.b.a.w(this.f35677b));
        this.j.setVisibility(0);
        this.j.setOnClickListener(this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.k = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 11.0f));
        this.k.a(-1, -45056);
        this.k.setVisibility(8);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.f35690i = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f35676a, null, this.n);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f35687f.setText(com.kwad.sdk.core.response.b.a.n(this.f35677b));
        this.m.a(adTemplate);
        List<String> I = com.kwad.sdk.core.response.b.a.I(this.f35677b);
        if (I.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f35688g, I.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f35676a);
        } else {
            com.kwad.sdk.core.d.a.d("FeedTextAboveImageView", "getImageUrlList size less than one");
        }
        if (com.kwad.sdk.core.response.b.a.y(this.f35677b)) {
            g();
        } else {
            f();
        }
        this.f35689h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f35687f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
        this.f35688g = (ImageView) findViewById(R.id.ksad_ad_image);
        this.f35689h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.m = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.l = findViewById(R.id.ksad_app_download_cover);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_above_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35689h) {
            l();
            return;
        }
        com.kwad.sdk.core.download.b.b.a(this.f35690i, view == this.l);
        com.kwad.sdk.core.download.b.a.a(ao.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f35676a, new a.InterfaceC0382a() { // from class: com.kwad.sdk.feed.widget.c.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                c.this.k();
            }
        }, this.f35690i);
    }
}
