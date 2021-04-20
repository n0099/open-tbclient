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
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f35218f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f35219g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f35220h;
    public com.kwad.sdk.core.download.b.b i;
    public TextProgressBar j;
    public TextView k;
    public View l;
    public KsLogoView m;
    public KsAppDownloadListener n;

    public e(@NonNull Context context) {
        super(context);
        this.n = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.widget.e.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                e.this.k.setVisibility(8);
                e.this.j.setVisibility(0);
                e.this.j.a(com.kwad.sdk.core.response.b.a.a(), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                e.this.k.setText(com.kwad.sdk.core.response.b.a.w(e.this.f35203b));
                e.this.k.setVisibility(0);
                e.this.j.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                e.this.k.setVisibility(8);
                e.this.j.setVisibility(0);
                e.this.j.a(com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) e.this).f35202a), e.this.j.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                e.this.k.setText(com.kwad.sdk.core.response.b.a.w(e.this.f35203b));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                e.this.k.setVisibility(8);
                e.this.j.setVisibility(0);
                e.this.j.a(com.kwad.sdk.core.response.b.a.b(), e.this.j.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                e.this.k.setVisibility(8);
                e.this.j.setVisibility(0);
                e.this.j.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }
        };
    }

    private void f() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
        ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f35203b));
        textView.setText(com.kwad.sdk.core.response.b.a.w(this.f35203b));
        findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void g() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.b.a.q(this.f35203b));
        KSImageLoader.loadAppIcon((ImageView) findViewById(R.id.ksad_app_icon), com.kwad.sdk.core.response.b.a.o(this.f35203b), ((com.kwad.sdk.feed.widget.base.a) this).f35202a, 8);
        ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f35203b));
        TextView textView = (TextView) findViewById(R.id.ksad_app_download_before);
        this.k = textView;
        textView.setText(com.kwad.sdk.core.response.b.a.w(this.f35203b));
        this.k.setVisibility(0);
        this.k.setOnClickListener(this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.j = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 11.0f));
        this.j.a(-1, -45056);
        this.j.setVisibility(8);
        this.j.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.i = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f35202a, null, this.n);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f35218f.setText(com.kwad.sdk.core.response.b.a.n(this.f35203b));
        this.m.a(adTemplate);
        List<String> I = com.kwad.sdk.core.response.b.a.I(this.f35203b);
        if (I.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f35219g, I.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f35202a);
        } else {
            com.kwad.sdk.core.d.a.d("FeedTextBelowImageView", "getImageUrlList size less than one");
        }
        if (com.kwad.sdk.core.response.b.a.y(this.f35203b)) {
            g();
        } else {
            f();
        }
        this.f35220h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f35218f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
        this.f35219g = (ImageView) findViewById(R.id.ksad_ad_image);
        this.f35220h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.m = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.l = findViewById(R.id.ksad_app_download_cover);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_below_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f35220h) {
            l();
            return;
        }
        com.kwad.sdk.core.download.b.b.a(this.i, view == this.l);
        com.kwad.sdk.core.download.b.a.a(ao.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f35202a, new a.InterfaceC0393a() { // from class: com.kwad.sdk.feed.widget.e.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
            public void a() {
                e.this.k();
            }
        }, this.i);
    }
}
