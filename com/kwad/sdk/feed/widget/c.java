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
public class c extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f34924f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f34925g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34926h;
    public com.kwad.sdk.core.download.b.b i;
    public TextView j;
    public TextProgressBar k;
    public View l;
    public KsLogoView m;
    public KsAppDownloadListener n;

    public c(@NonNull Context context) {
        super(context);
        this.n = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.feed.widget.c.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                c.this.j.setVisibility(8);
                c.this.k.setVisibility(0);
                c.this.k.a(com.kwad.sdk.core.response.b.a.a(), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                c.this.j.setText(com.kwad.sdk.core.response.b.a.w(c.this.f34914b));
                c.this.j.setVisibility(0);
                c.this.k.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                c.this.j.setVisibility(8);
                c.this.k.setVisibility(0);
                c.this.k.a(com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) c.this).f34913a), c.this.k.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                c.this.j.setText(com.kwad.sdk.core.response.b.a.w(c.this.f34914b));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                c.this.j.setVisibility(8);
                c.this.k.setVisibility(0);
                c.this.k.a(com.kwad.sdk.core.response.b.a.b(), c.this.k.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                c.this.j.setVisibility(8);
                c.this.k.setVisibility(0);
                c.this.k.a(com.kwad.sdk.core.response.b.a.a(i), i);
            }
        };
    }

    private void f() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
        ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f34914b));
        textView.setText(com.kwad.sdk.core.response.b.a.w(this.f34914b));
        findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void g() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.b.a.q(this.f34914b));
        KSImageLoader.loadAppIcon((ImageView) findViewById(R.id.ksad_app_icon), com.kwad.sdk.core.response.b.a.o(this.f34914b), ((com.kwad.sdk.feed.widget.base.a) this).f34913a, 8);
        ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f34914b));
        TextView textView = (TextView) findViewById(R.id.ksad_app_download_before);
        this.j = textView;
        textView.setText(com.kwad.sdk.core.response.b.a.w(this.f34914b));
        this.j.setVisibility(0);
        this.j.setOnClickListener(this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.k = textProgressBar;
        textProgressBar.setTextDimen(ao.a(getContext(), 11.0f));
        this.k.a(-1, -45056);
        this.k.setVisibility(8);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.i = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f34913a, null, this.n);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f34924f.setText(com.kwad.sdk.core.response.b.a.n(this.f34914b));
        this.m.a(adTemplate);
        List<String> I = com.kwad.sdk.core.response.b.a.I(this.f34914b);
        if (I.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f34925g, I.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f34913a);
        } else {
            com.kwad.sdk.core.d.a.d("FeedTextAboveImageView", "getImageUrlList size less than one");
        }
        if (com.kwad.sdk.core.response.b.a.y(this.f34914b)) {
            g();
        } else {
            f();
        }
        this.f34926h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f34924f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
        this.f34925g = (ImageView) findViewById(R.id.ksad_ad_image);
        this.f34926h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.m = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.l = findViewById(R.id.ksad_app_download_cover);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_above_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f34926h) {
            l();
            return;
        }
        com.kwad.sdk.core.download.b.b.a(this.i, view == this.l);
        com.kwad.sdk.core.download.b.a.a(ao.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f34913a, new a.InterfaceC0379a() { // from class: com.kwad.sdk.feed.widget.c.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                c.this.k();
            }
        }, this.i);
    }
}
