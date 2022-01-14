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
public class i extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public TextView a;

    /* renamed from: f  reason: collision with root package name */
    public RoundAngleImageView f56905f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56906g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56907h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f56908i;

    /* renamed from: j  reason: collision with root package name */
    public DownloadProgressView f56909j;

    public i(@NonNull Context context) {
        super(context);
    }

    private void d() {
        this.f56908i.a(((com.kwad.sdk.feed.widget.base.a) this).f56883b);
        this.f56909j.a(((com.kwad.sdk.feed.widget.base.a) this).f56883b);
        this.f56909j.setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f56884c)) {
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).f56883b, null, this.f56909j.getAppDownloadListener());
            this.f56907h = bVar;
            bVar.c(this.f56909j.getAppDownloadListener());
            this.f56907h.a((DialogInterface.OnShowListener) this);
            this.f56907h.a((DialogInterface.OnDismissListener) this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        super.a(adTemplate);
        this.a.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f56884c));
        List<String> O = com.kwad.sdk.core.response.a.a.O(((com.kwad.sdk.feed.widget.base.a) this).f56884c);
        if (O.size() >= 1) {
            KSImageLoader.loadFeeImage(this.f56905f, O.get(0), ((com.kwad.sdk.feed.widget.base.a) this).f56883b);
        } else {
            com.kwad.sdk.core.d.a.e("FeedTextRightImageView", "getImageUrlList size less than one");
        }
        d();
        this.f56906g.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        this.a = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.66f);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.f56905f = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.a.kwai.a.a(getContext(), 3.0f));
        this.f56906g = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.f56909j = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.f56908i = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public int getLayoutId() {
        return R.layout.ksad_feed_text_right_image;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56906g) {
            m();
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C2100a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).f56883b).a(this.f56907h).a(view == this.f56909j ? 1 : 2).a(view == this.f56909j).a(new a.b() { // from class: com.kwad.sdk.feed.widget.i.1
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    i.this.k();
                }
            }));
        }
    }
}
