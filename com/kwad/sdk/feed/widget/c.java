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
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    private TextView f;
    private ImageView g;
    private ImageView h;
    private com.kwad.sdk.core.download.b.b i;
    private TextView j;
    private TextProgressBar k;
    private View l;
    private KsLogoView m;
    private KsAppDownloadListener n;

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
                c.this.j.setText(com.kwad.sdk.core.response.b.a.w(c.this.f10161b));
                c.this.j.setVisibility(0);
                c.this.k.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                c.this.j.setVisibility(8);
                c.this.k.setVisibility(0);
                c.this.k.a(com.kwad.sdk.core.response.b.a.a(c.this.f10160a), c.this.k.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                c.this.j.setText(com.kwad.sdk.core.response.b.a.w(c.this.f10161b));
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
        ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f10161b));
        textView.setText(com.kwad.sdk.core.response.b.a.w(this.f10161b));
        findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void g() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.b.a.q(this.f10161b));
        KSImageLoader.loadAppIcon((ImageView) findViewById(R.id.ksad_app_icon), com.kwad.sdk.core.response.b.a.o(this.f10161b), this.f10160a, 8);
        ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f10161b));
        this.j = (TextView) findViewById(R.id.ksad_app_download_before);
        this.j.setText(com.kwad.sdk.core.response.b.a.w(this.f10161b));
        this.j.setVisibility(0);
        this.j.setOnClickListener(this);
        this.k = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.k.setTextDimen(ao.a(getContext(), 11.0f));
        this.k.a(-1, -45056);
        this.k.setVisibility(8);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.i = new com.kwad.sdk.core.download.b.b(this.f10160a, null, this.n);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f.setText(com.kwad.sdk.core.response.b.a.n(this.f10161b));
        this.m.a(adTemplate);
        List<String> I = com.kwad.sdk.core.response.b.a.I(this.f10161b);
        if (I.size() >= 1) {
            KSImageLoader.loadFeeImage(this.g, I.get(0), this.f10160a);
        } else {
            com.kwad.sdk.core.d.a.d("FeedTextAboveImageView", "getImageUrlList size less than one");
        }
        if (com.kwad.sdk.core.response.b.a.y(this.f10161b)) {
            g();
        } else {
            f();
        }
        this.h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    protected void c() {
        this.f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
        this.g = (ImageView) findViewById(R.id.ksad_ad_image);
        this.h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.m = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.l = findViewById(R.id.ksad_app_download_cover);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    protected int getLayoutId() {
        return R.layout.ksad_feed_text_above_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.h) {
            l();
            return;
        }
        com.kwad.sdk.core.download.b.b.a(this.i, view == this.l);
        com.kwad.sdk.core.download.b.a.a(ao.a(this), this.f10160a, new a.InterfaceC1105a() { // from class: com.kwad.sdk.feed.widget.c.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1105a
            public void a() {
                c.this.k();
            }
        }, this.i);
    }
}
