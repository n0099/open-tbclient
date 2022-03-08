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
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes8.dex */
public class h extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public RoundAngleImageView f55462f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f55463g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f55464h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f55465i;

    /* renamed from: j  reason: collision with root package name */
    public DownloadProgressView f55466j;

    public h(@NonNull Context context) {
        super(context);
    }

    private void d() {
        this.f55465i.a(((com.kwad.sdk.feed.widget.base.a) this).f55445b);
        this.f55466j.a(((com.kwad.sdk.feed.widget.base.a) this).f55445b);
        this.f55466j.setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f55446c)) {
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).f55445b, null, this.f55466j.getAppDownloadListener());
            this.f55464h = bVar;
            bVar.c(this.f55466j.getAppDownloadListener());
            this.f55464h.a((DialogInterface.OnShowListener) this);
            this.f55464h.a((DialogInterface.OnDismissListener) this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f55446c));
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f55446c);
        if (O.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f55462f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f55445b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextLeftImageView", "getImageUrlList size less than one");
        }
        d();
        this.f55463g.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.a = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.66f);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.f55462f = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.a.kwai.a.a(getContext(), 3.0f));
        this.f55463g = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.f55466j = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.f55465i = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_left_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f55463g) {
            m();
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C2095a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).f55445b).a(this.f55464h).a(view == this.f55466j ? 1 : 2).a(view == this.f55466j).a(new a.b() { // from class: com.kwad.sdk.feed.widget.h.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    h.this.k();
                }
            }));
        }
    }
}
