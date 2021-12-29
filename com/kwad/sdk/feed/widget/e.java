package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59118f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59119g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59120h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f59121i;

    /* renamed from: j  reason: collision with root package name */
    public DownloadProgressView f59122j;

    public e(@NonNull Context context) {
        super(context);
    }

    private void d() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
        ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f59110c));
        textView.setText(com.kwad.sdk.core.response.a.a.A(((com.kwad.sdk.feed.widget.base.a) this).f59110c));
        findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void g() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_app_icon);
        ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.a.a.t(((com.kwad.sdk.feed.widget.base.a) this).f59110c));
        imageView.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(imageView, com.kwad.sdk.core.response.a.a.au(((com.kwad.sdk.feed.widget.base.a) this).f59110c), ((com.kwad.sdk.feed.widget.base.a) this).f59109b, 8);
        ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f59110c));
        this.f59122j.a(((com.kwad.sdk.feed.widget.base.a) this).f59109b);
        this.f59122j.setOnClickListener(this);
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).f59109b, null, this.f59122j.getAppDownloadListener());
        this.f59120h = bVar;
        bVar.c(this.f59122j.getAppDownloadListener());
        this.f59120h.a((DialogInterface.OnShowListener) this);
        this.f59120h.a((DialogInterface.OnDismissListener) this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f59110c));
        this.f59121i.a(adTemplate);
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f59110c);
        if (O.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f59118f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f59109b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextBelowImageView", "getImageUrlList size less than one");
        }
        if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f59110c)) {
            g();
        } else {
            d();
        }
        this.f59119g.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.a = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
        this.f59118f = (ImageView) findViewById(R.id.ksad_ad_image);
        this.f59119g = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.f59121i = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.f59122j = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_below_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f59119g) {
            m();
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C2083a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).f59109b).a(this.f59120h).a(view == this.f59122j ? 1 : 2).a(view == this.f59122j).a(new a.b() { // from class: com.kwad.sdk.feed.widget.e.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    e.this.k();
                }
            }));
        }
    }
}
