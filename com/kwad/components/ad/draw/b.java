package com.kwad.components.ad.draw;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public final class b extends KSFrameLayout {
    @Nullable
    public KsDrawAd.AdInteractionListener bN;
    public com.kwad.components.ad.draw.a.b bO;
    public com.kwad.components.ad.draw.c.a bP;
    public com.kwad.components.core.widget.a.b bQ;
    public boolean bR;
    public ImageView bS;
    public com.kwad.sdk.core.h.b bT;
    public View.OnClickListener bU;
    public k bV;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public Presenter mPresenter;
    public AdBaseFrameLayout mRootContainer;

    public b(@NonNull Context context) {
        super(context);
        this.bU = new View.OnClickListener() { // from class: com.kwad.components.ad.draw.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.kwad.components.core.e.d.a.a(new a.C0644a(b.this.bO.mRootContainer.getContext()).aq(b.this.bO.mAdTemplate).b(b.this.bO.mApkDownloadHelper).ao(false).an(3).a(new a.b() { // from class: com.kwad.components.ad.draw.b.1.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                    }
                }));
                if (3 == com.kwad.sdk.core.response.b.a.bv(e.dP(b.this.bO.mAdTemplate))) {
                    b.this.ab();
                }
            }
        };
        this.bV = new l() { // from class: com.kwad.components.ad.draw.b.2
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayPaused() {
                super.onMediaPlayPaused();
                b.this.bS.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                b.this.bS.setVisibility(8);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                b.this.bS.setVisibility(8);
            }
        };
        this.mContext = context;
        initView();
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bN = adInteractionListener;
    }

    public final void setPageExitListener(com.kwad.sdk.core.h.b bVar) {
        this.bT = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab() {
        this.bP.f(!this.bR);
        if (!this.bR) {
            this.bP.pause();
        } else {
            this.bP.resume();
        }
        this.bR = !this.bR;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        com.kwad.components.core.widget.a.b bVar = this.bQ;
        if (bVar != null) {
            bVar.release();
        }
        com.kwad.components.ad.draw.c.a aVar = this.bP;
        if (aVar != null) {
            aVar.aK();
            this.bP.a(this.bV);
        }
        com.kwad.components.ad.draw.a.b bVar2 = this.bO;
        if (bVar2 != null) {
            bVar2.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    private com.kwad.components.ad.draw.a.b ae() {
        com.kwad.components.ad.draw.a.b bVar = new com.kwad.components.ad.draw.a.b();
        bVar.bN = this.bN;
        bVar.mRootContainer = this.mRootContainer;
        bVar.mAdTemplate = this.mAdTemplate;
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        bVar.bP = this.bP;
        bVar.ch = new com.kwad.components.ad.draw.b.b.a(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.b.cy(this.mAdTemplate)) {
            bVar.ci = new com.kwad.components.ad.k.b();
        }
        return bVar;
    }

    private void initView() {
        com.kwad.sdk.m.l.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d04c3, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f09148f);
        this.mRootContainer = adBaseFrameLayout;
        this.bS = (ImageView) adBaseFrameLayout.findViewById(R.id.obfuscated_res_0x7f0914e8);
        DetailVideoView detailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0914ff);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.g(true, com.kwad.sdk.core.config.d.Bs());
        this.mDetailVideoView.setOnClickListener(this.bU);
        this.bS.setOnClickListener(this.bU);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        this.bO = ae();
        Presenter af = af();
        this.mPresenter = af;
        af.G(this.mRootContainer);
        this.mPresenter.k(this.bO);
        this.bQ.a(this.bT);
        this.bQ.tm();
        this.bP.aJ();
        this.bP.b(this.bV);
    }

    private Presenter af() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.draw.b.a.a());
        presenter.a(new com.kwad.components.ad.draw.b.b());
        presenter.a(new com.kwad.components.ad.draw.b.d());
        presenter.a(new com.kwad.components.ad.draw.b.c());
        presenter.a(new com.kwad.components.ad.draw.b.b.b());
        if (com.kwad.sdk.core.response.b.b.cl(this.mAdTemplate)) {
            presenter.a(new com.kwad.components.ad.draw.b.b.c());
        }
        presenter.a(new com.kwad.components.ad.draw.b.c.a());
        if (com.kwad.sdk.core.response.b.b.cy(this.mAdTemplate)) {
            presenter.a(new com.kwad.components.ad.draw.b.c.b());
        }
        if (com.kwad.sdk.core.response.b.a.aP(this.mAdInfo)) {
            presenter.a(new com.kwad.components.ad.draw.b.a());
        }
        return presenter;
    }

    public final void a(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dP(adTemplate);
        com.kwad.components.core.widget.a.b bVar = new com.kwad.components.core.widget.a.b(this, 70);
        this.bQ = bVar;
        this.bP = new com.kwad.components.ad.draw.c.a(this.mAdTemplate, bVar, this.mDetailVideoView);
    }
}
