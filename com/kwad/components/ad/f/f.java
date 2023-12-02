package com.kwad.components.ad.f;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.f.b.g;
import com.kwad.components.ad.f.b.h;
import com.kwad.components.ad.f.b.i;
import com.kwad.components.ad.f.b.k;
import com.kwad.components.ad.f.d;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.m.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.j;
/* loaded from: classes10.dex */
public final class f extends KSFrameLayout {
    public com.kwad.components.core.widget.a.b bQ;
    public j cD;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public DetailVideoView mDetailVideoView;
    public AdBasePvFrameLayout mH;
    public com.kwad.components.ad.f.a.b mM;
    public com.kwad.components.ad.f.c.a mN;
    public KsAdVideoPlayConfig mO;
    public Presenter mPresenter;
    public KsNativeAd.VideoPlayListener mq;
    public d.a mv;

    public f(@NonNull Context context) {
        this(context, null);
    }

    private void B(Context context) {
        l.inflate(context, R.layout.obfuscated_res_0x7f0d04ef, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.obfuscated_res_0x7f091490);
        this.mH = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.obfuscated_res_0x7f091500);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.mv = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.mq = videoPlayListener;
    }

    public f(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public f(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.cD = new j() { // from class: com.kwad.components.ad.f.f.1
            @Override // com.kwad.sdk.widget.j
            public final void ao() {
                com.kwad.sdk.utils.l.ek(f.this.mAdTemplate);
            }
        };
        B(context);
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        View view2;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.mO = ksAdVideoPlayConfig;
        this.mH.setVisibleListener(this.cD);
        if (getParent() == null) {
            view2 = this;
        } else {
            view2 = (View) getParent();
        }
        this.bQ = new com.kwad.components.core.widget.a.b(view2, 30);
    }

    private Presenter af() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.f.b.e());
        presenter.a(new com.kwad.components.ad.f.b.c());
        presenter.a(new i());
        presenter.a(new com.kwad.components.ad.f.b.j());
        presenter.a(new com.kwad.components.ad.f.b.d());
        presenter.a(new com.kwad.components.ad.f.b.b());
        presenter.a(new k());
        presenter.a(new com.kwad.components.ad.f.b.a(this.mO));
        presenter.a(new g());
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate))) {
            presenter.a(new com.kwad.components.ad.f.b.f());
        } else {
            presenter.a(new h());
        }
        return presenter;
    }

    private com.kwad.components.ad.f.a.b et() {
        com.kwad.components.ad.f.a.b bVar = new com.kwad.components.ad.f.a.b();
        bVar.mH = this.mH;
        AdTemplate adTemplate = this.mAdTemplate;
        bVar.mAdTemplate = adTemplate;
        bVar.mv = this.mv;
        bVar.mq = this.mq;
        bVar.mN = this.mN;
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dP(adTemplate))) {
            com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
            if (cVar == null) {
                bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            } else {
                cVar.nK();
                bVar.mApkDownloadHelper = this.mApkDownloadHelper;
            }
        }
        return bVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        if (this.mN == null) {
            this.mN = new com.kwad.components.ad.f.c.a(this.mAdTemplate, this.bQ, this.mDetailVideoView, this.mO);
        }
        this.mM = et();
        Presenter af = af();
        this.mPresenter = af;
        af.G(this.mH);
        this.mPresenter.k(this.mM);
        this.bQ.tm();
        this.mN.aJ();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        com.kwad.components.core.widget.a.b bVar = this.bQ;
        if (bVar != null) {
            bVar.release();
        }
        com.kwad.components.ad.f.c.a aVar = this.mN;
        if (aVar != null) {
            aVar.aK();
        }
        com.kwad.components.ad.f.a.b bVar2 = this.mM;
        if (bVar2 != null) {
            bVar2.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }
}
