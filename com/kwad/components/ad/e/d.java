package com.kwad.components.ad.e;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.e.a.e;
import com.kwad.components.ad.e.a.f;
import com.kwad.components.ad.e.a.g;
import com.kwad.components.ad.e.a.h;
import com.kwad.components.ad.e.a.i;
import com.kwad.components.ad.e.c;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.j;
/* loaded from: classes8.dex */
public final class d extends KSFrameLayout {
    public com.kwad.components.core.widget.kwai.b aM;
    public j bx;
    public KsNativeAd.VideoPlayListener jA;
    public c.a jC;
    public AdBasePvFrameLayout jK;
    public com.kwad.components.ad.e.kwai.b jL;
    public com.kwad.components.ad.e.b.a jM;
    public KsAdVideoPlayConfig jN;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public DetailVideoView mDetailVideoView;
    public Presenter mPresenter;

    public d(@NonNull Context context) {
        super(context);
        this.bx = new j() { // from class: com.kwad.components.ad.e.d.1
            @Override // com.kwad.sdk.widget.j
            public final void av() {
                k.cj(d.this.mAdTemplate);
            }
        };
        initView();
    }

    private Presenter ap() {
        Presenter presenter = new Presenter();
        presenter.a(new e());
        presenter.a(new com.kwad.components.ad.e.a.c());
        presenter.a(new i());
        presenter.a(new com.kwad.components.ad.e.a.j());
        presenter.a(new com.kwad.components.ad.e.a.d());
        presenter.a(new com.kwad.components.ad.e.a.b());
        presenter.a(new com.kwad.components.ad.e.a.k());
        presenter.a(new com.kwad.components.ad.e.a.a(this.jN));
        presenter.a(new g());
        presenter.a(com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)) ? new f() : new h());
        return presenter;
    }

    private com.kwad.components.ad.e.kwai.b eo() {
        com.kwad.components.ad.e.kwai.b bVar = new com.kwad.components.ad.e.kwai.b();
        bVar.jK = this.jK;
        AdTemplate adTemplate = this.mAdTemplate;
        bVar.mAdTemplate = adTemplate;
        bVar.jC = this.jC;
        bVar.jA = this.jA;
        bVar.mApkDownloadHelper = (this.mApkDownloadHelper == null && com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) ? new com.kwad.components.core.c.a.c(this.mAdTemplate) : this.mApkDownloadHelper;
        bVar.jM = this.jM;
        return bVar;
    }

    private void initView() {
        View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0476, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.obfuscated_res_0x7f09133d);
        this.jK = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.obfuscated_res_0x7f091393);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.c.a.c cVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.jN = ksAdVideoPlayConfig;
        this.jK.setVisibleListener(this.bx);
        this.aM = new com.kwad.components.core.widget.kwai.b(getParent() == null ? this : (View) getParent(), 30);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void am() {
        super.am();
        if (this.jM == null) {
            this.jM = new com.kwad.components.ad.e.b.a(this.mAdTemplate, this.aM, this.mDetailVideoView, this.jN);
        }
        this.jL = eo();
        Presenter ap = ap();
        this.mPresenter = ap;
        ap.B(this.jK);
        this.mPresenter.e(this.jL);
        this.aM.qi();
        this.jM.aO();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        super.an();
        com.kwad.components.core.widget.kwai.b bVar = this.aM;
        if (bVar != null) {
            bVar.release();
        }
        com.kwad.components.ad.e.b.a aVar = this.jM;
        if (aVar != null) {
            aVar.aP();
        }
        com.kwad.components.ad.e.kwai.b bVar2 = this.jL;
        if (bVar2 != null) {
            bVar2.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public final void setInnerAdInteractionListener(c.a aVar) {
        this.jC = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.jA = videoPlayListener;
    }
}
