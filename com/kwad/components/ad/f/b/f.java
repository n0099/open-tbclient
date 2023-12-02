package com.kwad.components.ad.f.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class f extends com.kwad.components.ad.f.a.a implements View.OnClickListener {
    public ImageView dE;
    public TextView dF;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public ViewGroup mZ;
    public TextView na;
    public KsAppDownloadListener nb = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.f.b.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            f.this.na.setText(com.kwad.sdk.core.response.b.a.aE(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            f.this.na.setText(com.kwad.sdk.core.response.b.a.bX(f.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            f.this.na.setText(com.kwad.sdk.core.response.b.a.aE(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            f.this.na.setText(com.kwad.sdk.core.response.b.a.ac(f.this.mAdInfo));
        }
    };

    private void notifyAdClick() {
        this.mM.mv.l(this.mZ);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.mM.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.mApkDownloadHelper = this.mM.mApkDownloadHelper;
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.f.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                try {
                    f.this.ew();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    com.kwad.components.core.d.a.b(th);
                }
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mM.mN.b((com.kwad.components.core.video.k) lVar);
        this.mZ.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mZ = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914e5);
        this.dE = (ImageView) findViewById(R.id.obfuscated_res_0x7f091307);
        this.dF = (TextView) findViewById(R.id.obfuscated_res_0x7f091309);
        this.na = (TextView) findViewById(R.id.obfuscated_res_0x7f091304);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.nb);
        }
    }

    private void G(int i) {
        com.kwad.components.core.e.d.a.a(new a.C0644a(this.mZ.getContext()).aq(this.mAdTemplate).an(i).b(this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.ad.f.b.f.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(f.this.mAdTemplate, 2, f.this.mM.mH.getTouchCoords());
            }
        }));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.mZ) {
            G(2);
            notifyAdClick();
        } else if (view2 == this.na) {
            G(1);
            notifyAdClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew() {
        KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), this.mAdTemplate, 12);
        this.dF.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        this.na.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this.nb);
        }
        this.mZ.setOnClickListener(this);
        this.mZ.setVisibility(0);
    }
}
