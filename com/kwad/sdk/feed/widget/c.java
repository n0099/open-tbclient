package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f55449f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f55450g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f55451h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f55452i;

    /* renamed from: j  reason: collision with root package name */
    public DownloadProgressView f55453j;

    public c(@NonNull Context context) {
        super(context);
    }

    private void d() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
        ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f55446c));
        textView.setText(com.kwad.sdk.core.response.a.a.A(((com.kwad.sdk.feed.widget.base.a) this).f55446c));
        findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
        textView.setOnClickListener(this);
    }

    private void g() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_app_icon);
        ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.a.a.t(((com.kwad.sdk.feed.widget.base.a) this).f55446c));
        imageView.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(imageView, com.kwad.sdk.core.response.a.a.au(((com.kwad.sdk.feed.widget.base.a) this).f55446c), ((com.kwad.sdk.feed.widget.base.a) this).f55445b, 8);
        ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f55446c));
        this.f55453j.a(((com.kwad.sdk.feed.widget.base.a) this).f55445b);
        this.f55453j.setOnClickListener(this);
        com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).f55445b, null, this.f55453j.getAppDownloadListener());
        this.f55451h = bVar;
        bVar.c(this.f55453j.getAppDownloadListener());
        this.f55451h.a((DialogInterface.OnShowListener) this);
        this.f55451h.a((DialogInterface.OnDismissListener) this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f55446c));
        this.f55452i.a(adTemplate);
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f55446c);
        if (O.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f55449f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f55445b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextAboveImageView", "getImageUrlList size less than one");
        }
        if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f55446c)) {
            g();
        } else {
            d();
        }
        this.f55450g.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.a = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.56f);
        this.f55449f = (ImageView) findViewById(R.id.ksad_ad_image);
        this.f55450g = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.f55452i = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.f55453j = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_above_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f55450g) {
            m();
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C2095a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).f55445b).a(this.f55451h).a(view == this.f55453j ? 1 : 2).a(view == this.f55453j).a(new a.b() { // from class: com.kwad.sdk.feed.widget.c.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    c.this.k();
                }
            }));
        }
    }
}
