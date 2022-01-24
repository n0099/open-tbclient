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
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public RoundAngleImageView f56945f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56946g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56947h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f56948i;

    /* renamed from: j  reason: collision with root package name */
    public DownloadProgressView f56949j;

    public h(@NonNull Context context) {
        super(context);
    }

    private void d() {
        this.f56948i.a(((com.kwad.sdk.feed.widget.base.a) this).f56928b);
        this.f56949j.a(((com.kwad.sdk.feed.widget.base.a) this).f56928b);
        this.f56949j.setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f56929c)) {
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).f56928b, null, this.f56949j.getAppDownloadListener());
            this.f56947h = bVar;
            bVar.c(this.f56949j.getAppDownloadListener());
            this.f56947h.a((DialogInterface.OnShowListener) this);
            this.f56947h.a((DialogInterface.OnDismissListener) this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f56929c));
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f56929c);
        if (O.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f56945f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f56928b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextLeftImageView", "getImageUrlList size less than one");
        }
        d();
        this.f56946g.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.a = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.66f);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.f56945f = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.a.kwai.a.a(getContext(), 3.0f));
        this.f56946g = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.f56949j = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.f56948i = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_left_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56946g) {
            m();
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C2106a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).f56928b).a(this.f56947h).a(view == this.f56949j ? 1 : 2).a(view == this.f56949j).a(new a.b() { // from class: com.kwad.sdk.feed.widget.h.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    h.this.k();
                }
            }));
        }
    }
}
