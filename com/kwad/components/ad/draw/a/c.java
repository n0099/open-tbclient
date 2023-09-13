package com.kwad.components.ad.draw.a;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.m.n;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.draw.kwai.a implements View.OnClickListener {
    public ViewGroup bh;
    public TextView bi;
    public TextView bj;
    public TextView bk;
    public DrawDownloadProgressBar bl;
    public ValueAnimator bm;
    public int bn;
    public int bo;
    public int bp;
    public KsLogoView bq;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public g mVideoPlayStateListener = new h() { // from class: com.kwad.components.ad.draw.a.c.1
        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            int i = (j2 > (c.this.bp * 1000) ? 1 : (j2 == (c.this.bp * 1000) ? 0 : -1));
            c cVar = c.this;
            if (i >= 0) {
                cVar.aK.ba.aw();
                return;
            }
            int i2 = (j2 > (cVar.bo * 1000) ? 1 : (j2 == (cVar.bo * 1000) ? 0 : -1));
            c cVar2 = c.this;
            if (i2 >= 0) {
                cVar2.au();
            } else if (j2 >= cVar2.bn * 1000) {
                c.this.as();
            }
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayStart() {
        }
    };
    public KsAppDownloadListener br = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.draw.a.c.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            c.this.bk.setText(com.kwad.sdk.core.response.a.a.al(c.this.mAdInfo));
            c.this.bl.f(com.kwad.sdk.core.response.a.a.al(c.this.mAdInfo), c.this.bl.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            c.this.bk.setText(com.kwad.sdk.core.response.a.a.aJ(c.this.mAdTemplate));
            c.this.bl.f(com.kwad.sdk.core.response.a.a.aJ(c.this.mAdTemplate), c.this.bl.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            c.this.bk.setText(com.kwad.sdk.core.response.a.a.al(c.this.mAdInfo));
            c.this.bl.f(com.kwad.sdk.core.response.a.a.al(c.this.mAdInfo), c.this.bl.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            c.this.bk.setText(com.kwad.sdk.core.response.a.a.P(c.this.mAdInfo));
            c.this.bl.f(com.kwad.sdk.core.response.a.a.P(c.this.mAdInfo), c.this.bl.getMax());
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i) {
            super.onPaused(i);
            c.this.bk.setText(com.kwad.sdk.core.response.a.a.uU());
            c.this.bl.f(com.kwad.sdk.core.response.a.a.uU(), i);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            TextView textView = c.this.bk;
            textView.setText(i + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = c.this.bl;
            drawDownloadProgressBar.f(i + "%", i);
        }
    };

    private void a(boolean z, int i) {
        com.kwad.components.core.c.a.a.a(new a.C0643a(this.bh.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(i).aj(z).a(new a.b() { // from class: com.kwad.components.ad.draw.a.c.3
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(c.this.mAdTemplate, 1, c.this.aK.mRootContainer.getTouchCoords());
                if (c.this.aK.aJ != null) {
                    c.this.aK.aJ.onAdClicked();
                }
            }
        }));
    }

    private void ar() {
        this.bn = com.kwad.sdk.core.response.a.a.aI(this.mAdInfo);
        this.bo = com.kwad.sdk.core.response.a.a.aJ(this.mAdInfo);
        this.bp = com.kwad.sdk.core.response.a.a.aK(this.mAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as() {
        if (this.bk.getVisibility() == 0 || this.bl.getVisibility() == 0) {
            return;
        }
        this.bk.setOnClickListener(this);
        this.bk.setVisibility(0);
        TextView textView = this.bk;
        ValueAnimator b = n.b(textView, 0, com.kwad.sdk.b.kwai.a.a(textView.getContext(), 44.0f));
        this.bm = b;
        b.setInterpolator(new DecelerateInterpolator(2.0f));
        this.bm.setDuration(300L);
        this.bm.start();
    }

    private void at() {
        ValueAnimator valueAnimator = this.bm;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.bm.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au() {
        if (this.bl.getVisibility() == 0) {
            return;
        }
        this.bl.setOnClickListener(this);
        this.bl.setVisibility(0);
        this.bk.setVisibility(8);
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        AdTemplate adTemplate = this.aK.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.mApkDownloadHelper = this.aK.mApkDownloadHelper;
        ar();
        this.bq.T(this.mAdTemplate);
        this.bk.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
        this.bk.setVisibility(8);
        this.bl.f(com.kwad.sdk.core.response.a.a.al(this.mAdInfo), this.bl.getMax());
        this.bl.setVisibility(8);
        this.bh.setVisibility(0);
        this.bh.setOnClickListener(this);
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            this.bi.setText(com.kwad.sdk.core.response.a.a.ae(this.mAdInfo));
            this.bi.setVisibility(0);
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.br);
            }
        } else {
            this.bi.setVisibility(8);
        }
        this.bj.setText(com.kwad.sdk.core.response.a.a.ad(this.mAdInfo));
        this.aK.aL.a(this.mVideoPlayStateListener);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.bh) {
            au();
            a(false, 2);
        } else if (view2 == this.bk) {
            au();
            a(true, 1);
        } else if (view2 == this.bl) {
            a(true, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bh = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09127d);
        this.bi = (TextView) findViewById(R.id.obfuscated_res_0x7f091281);
        this.bj = (TextView) findViewById(R.id.obfuscated_res_0x7f09127f);
        this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091280);
        this.bk = (TextView) findViewById(R.id.obfuscated_res_0x7f09127e);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f09127c);
        this.bl = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        KsAppDownloadListener ksAppDownloadListener;
        super.onUnbind();
        at();
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar != null && (ksAppDownloadListener = this.br) != null) {
            cVar.c(ksAppDownloadListener);
        }
        this.aK.aL.b(this.mVideoPlayStateListener);
    }
}
