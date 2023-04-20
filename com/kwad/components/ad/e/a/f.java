package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class f extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    public ImageView cw;
    public TextView cx;
    public ViewGroup jY;
    public TextView jZ;
    public KsAppDownloadListener ka = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.e.a.f.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            f.this.jZ.setText(com.kwad.sdk.core.response.a.a.al(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            f.this.jZ.setText(com.kwad.sdk.core.response.a.a.aJ(f.this.mAdTemplate));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            f.this.jZ.setText(com.kwad.sdk.core.response.a.a.al(f.this.mAdInfo));
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            f.this.jZ.setText("立即打开");
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
        }
    };
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    private void G(int i) {
        com.kwad.components.core.c.a.a.a(new a.C0593a(this.jY.getContext()).L(this.mAdTemplate).ae(i).b(this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.ad.e.a.f.3
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(f.this.mAdTemplate, 2, f.this.jL.jK.getTouchCoords());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er() {
        KSImageLoader.loadAppIcon(this.cw, com.kwad.sdk.core.response.a.a.bn(this.mAdInfo), this.mAdTemplate, 12);
        this.cx.setText(com.kwad.sdk.core.response.a.a.ae(this.mAdInfo));
        this.jZ.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this.ka);
        }
        this.jY.setOnClickListener(this);
        this.jY.setVisibility(0);
    }

    private void notifyAdClick() {
        this.jL.jC.i(this.jY);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        AdTemplate adTemplate = this.jL.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.mApkDownloadHelper = this.jL.mApkDownloadHelper;
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.e.a.f.1
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                try {
                    f.this.er();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                    com.kwad.components.core.b.a.b(th);
                }
            }
        };
        this.mVideoPlayStateListener = hVar;
        this.jL.jM.a(hVar);
        this.jY.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.jY) {
            G(2);
            notifyAdClick();
        } else if (view2 == this.jZ) {
            G(1);
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jY = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09137d);
        this.cw = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911d0);
        this.cx = (TextView) findViewById(R.id.obfuscated_res_0x7f0911d2);
        this.jZ = (TextView) findViewById(R.id.obfuscated_res_0x7f0911cd);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.ka);
        }
    }
}
