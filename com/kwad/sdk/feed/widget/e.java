package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public TextView f33284f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f33285g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f33286h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33287i;
    public KsLogoView j;
    public DownloadProgressView k;

    public e(@NonNull Context context) {
        super(context);
    }

    private void e() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
        ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.b.a.m(this.f33270b));
        textView.setText(com.kwad.sdk.core.response.b.a.u(this.f33270b));
        findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void f() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_app_icon);
        ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.b.a.o(this.f33270b));
        imageView.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(imageView, com.kwad.sdk.core.response.b.a.n(this.f33270b), ((com.kwad.sdk.feed.widget.base.a) this).f33269a, 8);
        ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.b.a.m(this.f33270b));
        this.k.a(((com.kwad.sdk.feed.widget.base.a) this).f33269a);
        this.k.setOnClickListener(this);
        com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f33269a, null, this.k.getAppDownloadListener());
        this.f33287i = bVar;
        bVar.c(this.k.getAppDownloadListener());
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.f33284f.setText(com.kwad.sdk.core.response.b.a.m(this.f33270b));
        this.j.a(adTemplate);
        List<String> E = com.kwad.sdk.core.response.b.a.E(this.f33270b);
        if (E.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f33285g, E.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f33269a);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextBelowImageView", "getImageUrlList size less than one");
        }
        if (com.kwad.sdk.core.response.b.a.v(this.f33270b)) {
            f();
        } else {
            e();
        }
        this.f33286h.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.f33284f = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
        this.f33285g = (ImageView) findViewById(R.id.ksad_ad_image);
        this.f33286h = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.j = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.k = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_below_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33286h) {
            l();
        } else {
            com.kwad.sdk.core.download.b.a.a(an.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f33269a, new a.InterfaceC0363a() { // from class: com.kwad.sdk.feed.widget.e.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
                public void a() {
                    e.this.k();
                }
            }, this.f33287i, view == this.k);
        }
    }
}
