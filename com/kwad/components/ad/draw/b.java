package com.kwad.components.ad.draw;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes9.dex */
public final class b extends KSFrameLayout {
    @Nullable
    public KsDrawAd.AdInteractionListener aJ;
    public com.kwad.components.ad.draw.kwai.b aK;
    public com.kwad.components.ad.draw.b.a aL;
    public com.kwad.components.core.widget.kwai.b aM;
    public boolean aN;
    public ImageView aO;
    public View.OnClickListener aP;
    public g aQ;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;
    public Context mContext;
    public DetailVideoView mDetailVideoView;
    public Presenter mPresenter;
    public AdBaseFrameLayout mRootContainer;

    public b(@NonNull Context context) {
        super(context);
        this.aP = new View.OnClickListener() { // from class: com.kwad.components.ad.draw.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.kwad.components.core.c.a.a.a(new a.C0647a(b.this.aK.mRootContainer.getContext()).L(b.this.aK.mAdTemplate).b(b.this.aK.mApkDownloadHelper).aj(false).ae(3).a(new a.b() { // from class: com.kwad.components.ad.draw.b.1.1
                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                    }
                }));
                if (3 == com.kwad.sdk.core.response.a.a.aP(com.kwad.sdk.core.response.a.d.bQ(b.this.aK.mAdTemplate))) {
                    b.this.al();
                }
            }
        };
        this.aQ = new h() { // from class: com.kwad.components.ad.draw.b.2
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayPaused() {
                super.onVideoPlayPaused();
                b.this.aO.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                super.onVideoPlayStart();
                b.this.aO.setVisibility(8);
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                b.this.aO.setVisibility(8);
            }
        };
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        this.aL.f(!this.aN);
        if (this.aN) {
            this.aL.resume();
        } else {
            this.aL.pause();
        }
        this.aN = !this.aN;
    }

    private com.kwad.components.ad.draw.kwai.b ao() {
        com.kwad.components.ad.draw.kwai.b bVar = new com.kwad.components.ad.draw.kwai.b();
        bVar.aJ = this.aJ;
        bVar.mRootContainer = this.mRootContainer;
        bVar.mAdTemplate = this.mAdTemplate;
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            bVar.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
        }
        bVar.aL = this.aL;
        bVar.ba = new com.kwad.components.ad.draw.a.a.a(this.mAdTemplate);
        if (com.kwad.sdk.core.response.a.b.bd(this.mAdTemplate)) {
            bVar.bb = new com.kwad.components.ad.i.b();
        }
        return bVar;
    }

    private Presenter ap() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.draw.a.kwai.a());
        presenter.a(new com.kwad.components.ad.draw.a.b());
        presenter.a(new com.kwad.components.ad.draw.a.d());
        presenter.a(new com.kwad.components.ad.draw.a.c());
        presenter.a(new com.kwad.components.ad.draw.a.a.b());
        if (com.kwad.sdk.core.response.a.b.aP(this.mAdTemplate)) {
            presenter.a(new com.kwad.components.ad.draw.a.a.c());
        }
        presenter.a(new com.kwad.components.ad.draw.a.b.a());
        if (com.kwad.sdk.core.response.a.b.bd(this.mAdTemplate)) {
            presenter.a(new com.kwad.components.ad.draw.a.b.b());
        }
        if (com.kwad.sdk.core.response.a.a.ao(this.mAdInfo)) {
            presenter.a(new com.kwad.components.ad.draw.a.a());
        }
        return presenter;
    }

    private void initView() {
        View.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d0492, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0913de);
        this.mRootContainer = adBaseFrameLayout;
        this.aO = (ImageView) adBaseFrameLayout.findViewById(R.id.obfuscated_res_0x7f09141e);
        DetailVideoView detailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091434);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
        this.mDetailVideoView.setOnClickListener(this.aP);
        this.aO.setOnClickListener(this.aP);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void am() {
        super.am();
        this.aK = ao();
        Presenter ap = ap();
        this.mPresenter = ap;
        ap.B(this.mRootContainer);
        this.mPresenter.e(this.aK);
        this.aM.qi();
        this.aL.aO();
        this.aL.a(this.aQ);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        super.an();
        com.kwad.components.core.widget.kwai.b bVar = this.aM;
        if (bVar != null) {
            bVar.release();
        }
        com.kwad.components.ad.draw.b.a aVar = this.aL;
        if (aVar != null) {
            aVar.aP();
            this.aL.b(this.aQ);
        }
        com.kwad.components.ad.draw.kwai.b bVar2 = this.aK;
        if (bVar2 != null) {
            bVar2.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public final void b(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        com.kwad.components.core.widget.kwai.b bVar = new com.kwad.components.core.widget.kwai.b(this, 70);
        this.aM = bVar;
        this.aL = new com.kwad.components.ad.draw.b.a(this.mAdTemplate, bVar, this.mDetailVideoView);
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.aJ = adInteractionListener;
    }
}
