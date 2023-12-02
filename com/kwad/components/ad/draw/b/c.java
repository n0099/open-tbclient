package com.kwad.components.ad.draw.b;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.draw.a.a implements View.OnClickListener {
    public ViewGroup co;
    public TextView cp;
    public TextView cq;
    public TextView cr;
    public DrawDownloadProgressBar cs;
    public ValueAnimator ct;
    public int cu;
    public int cv;
    public int cw;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public KsLogoView mLogoView;
    public k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.c.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            if (j2 >= c.this.cw * 1000) {
                c.this.bO.ch.ap();
            } else if (j2 >= c.this.cv * 1000) {
                c.this.an();
            } else if (j2 >= c.this.cu * 1000) {
                c.this.al();
            }
        }
    };
    public KsAppDownloadListener cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.b.c.2
        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i) {
            super.onPaused(i);
            c.this.cr.setText(com.kwad.sdk.core.response.b.a.DX());
            c.this.cs.e(com.kwad.sdk.core.response.b.a.DX(), i);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            c.this.cr.setText(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo));
            c.this.cs.e(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo), c.this.cs.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            c.this.cr.setText(com.kwad.sdk.core.response.b.a.bX(c.this.mAdTemplate));
            c.this.cs.e(com.kwad.sdk.core.response.b.a.bX(c.this.mAdTemplate), c.this.cs.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            c.this.cr.setText(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo));
            c.this.cs.e(com.kwad.sdk.core.response.b.a.aE(c.this.mAdInfo), c.this.cs.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            c.this.cr.setText(com.kwad.sdk.core.response.b.a.ac(c.this.mAdInfo));
            c.this.cs.e(com.kwad.sdk.core.response.b.a.ac(c.this.mAdInfo), c.this.cs.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            TextView textView = c.this.cr;
            textView.setText(i + "%");
            DrawDownloadProgressBar drawDownloadProgressBar = c.this.cs;
            drawDownloadProgressBar.e(i + "%", i);
        }
    };

    private void ak() {
        this.cu = com.kwad.sdk.core.response.b.a.bo(this.mAdInfo);
        this.cv = com.kwad.sdk.core.response.b.a.bp(this.mAdInfo);
        this.cw = com.kwad.sdk.core.response.b.a.bq(this.mAdInfo);
    }

    private void am() {
        ValueAnimator valueAnimator = this.ct;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.ct.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an() {
        if (this.cs.getVisibility() == 0) {
            return;
        }
        this.cs.setOnClickListener(this);
        this.cs.setVisibility(0);
        this.cr.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        KsAppDownloadListener ksAppDownloadListener;
        super.onUnbind();
        am();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null && (ksAppDownloadListener = this.cx) != null) {
            cVar.c(ksAppDownloadListener);
        }
        this.bO.bP.a(this.mVideoPlayStateListener);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.co) {
            an();
            a(false, 2);
        } else if (view2 == this.cr) {
            an();
            a(true, 1);
        } else if (view2 == this.cs) {
            a(true, 1);
        }
    }

    private void a(boolean z, int i) {
        com.kwad.components.core.e.d.a.a(new a.C0644a(this.co.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(i).ao(z).a(new a.b() { // from class: com.kwad.components.ad.draw.b.c.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(c.this.mAdTemplate, 1, c.this.bO.mRootContainer.getTouchCoords());
                if (c.this.bO.bN != null) {
                    c.this.bO.bN.onAdClicked();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al() {
        if (this.cr.getVisibility() != 0 && this.cs.getVisibility() != 0) {
            this.cr.setOnClickListener(this);
            this.cr.setVisibility(0);
            TextView textView = this.cr;
            ValueAnimator b = n.b(textView, 0, com.kwad.sdk.d.a.a.a(textView.getContext(), 44.0f));
            this.ct = b;
            b.setInterpolator(new DecelerateInterpolator(2.0f));
            this.ct.setDuration(300L);
            this.ct.start();
        }
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.bO.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dP(adTemplate);
        this.mApkDownloadHelper = this.bO.mApkDownloadHelper;
        ak();
        this.mLogoView.aD(this.mAdTemplate);
        this.cr.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.cr.setVisibility(8);
        this.cs.e(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo), this.cs.getMax());
        this.cs.setVisibility(8);
        this.co.setVisibility(0);
        this.co.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            this.cp.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
            this.cp.setVisibility(0);
            com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.cx);
            }
        } else {
            this.cp.setVisibility(8);
        }
        this.cq.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.bO.bP.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.co = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912f9);
        this.cp = (TextView) findViewById(R.id.obfuscated_res_0x7f0912fd);
        this.cq = (TextView) findViewById(R.id.obfuscated_res_0x7f0912fb);
        this.mLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f0912fc);
        this.cr = (TextView) findViewById(R.id.obfuscated_res_0x7f0912fa);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f0912f8);
        this.cs = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }
}
