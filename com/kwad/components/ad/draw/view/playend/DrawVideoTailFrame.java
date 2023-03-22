package com.kwad.components.ad.draw.view.playend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.a.c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.download.kwai.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes8.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    public KsDrawAd.AdInteractionListener aJ;
    public KsLogoView bq;
    @Nullable
    public KsAppDownloadListener br;
    public TextView cA;
    public DrawDownloadProgressBar cB;
    public ViewGroup cC;
    public TextView cD;
    public TextView cE;
    public AdBaseFrameLayout ct;
    public ImageView cu;
    public ViewGroup cv;
    public ImageView cw;
    public TextView cx;
    public AppScoreView cy;
    public TextView cz;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    @Nullable
    public c mApkDownloadHelper;

    public DrawVideoTailFrame(@NonNull Context context) {
        super(context);
        E(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        E(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        E(context);
    }

    private void E(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0453, this);
        this.cu = (ImageView) findViewById(R.id.obfuscated_res_0x7f091387);
        this.cv = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0911c7);
        this.cw = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911cc);
        this.cx = (TextView) findViewById(R.id.obfuscated_res_0x7f0911ce);
        this.cy = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f0911cf);
        this.cz = (TextView) findViewById(R.id.obfuscated_res_0x7f0911cb);
        this.cA = (TextView) findViewById(R.id.obfuscated_res_0x7f0911c6);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f0911ca);
        this.cB = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(15);
        this.cC = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091222);
        this.cD = (TextView) findViewById(R.id.obfuscated_res_0x7f091221);
        this.cE = (TextView) findViewById(R.id.obfuscated_res_0x7f091225);
        this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091213);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new a() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DrawVideoTailFrame.this.cB.f(com.kwad.sdk.core.response.a.a.al(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.cB.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DrawVideoTailFrame.this.cB.f(com.kwad.sdk.core.response.a.a.aJ(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.cB.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DrawVideoTailFrame.this.cB.f(com.kwad.sdk.core.response.a.a.al(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.cB.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DrawVideoTailFrame.this.cB.f(com.kwad.sdk.core.response.a.a.P(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.cB.getMax());
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                super.onPaused(i);
                DrawVideoTailFrame.this.cB.f(com.kwad.sdk.core.response.a.a.uU(), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                DrawDownloadProgressBar drawDownloadProgressBar = DrawVideoTailFrame.this.cB;
                drawDownloadProgressBar.f(i + "%", i);
            }
        };
    }

    public final void aW() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.br;
            if (ksAppDownloadListener != null) {
                cVar.d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.br = appDownloadListener;
            this.mApkDownloadHelper.b(appDownloadListener);
        }
    }

    public final void c(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo bQ = d.bQ(adTemplate);
        this.mAdInfo = bQ;
        AdInfo.AdMaterialInfo.MaterialFeature au = com.kwad.sdk.core.response.a.a.au(bQ);
        String str = au.coverUrl;
        this.bq.T(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i = au.width;
            int i2 = au.height;
            if (i > 0 && i > i2) {
                int screenWidth = com.kwad.sdk.b.kwai.a.getScreenWidth(getContext());
                if (getWidth() != 0) {
                    screenWidth = getWidth();
                }
                ViewGroup.LayoutParams layoutParams = this.cu.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = (int) (screenWidth * (i2 / i));
            }
            KSImageLoader.loadImage(this.cu, str, this.mAdTemplate);
        }
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            KSImageLoader.loadAppIcon(this.cw, com.kwad.sdk.core.response.a.a.bn(this.mAdInfo), this.mAdTemplate, 11);
            this.cx.setText(com.kwad.sdk.core.response.a.a.ae(this.mAdInfo));
            float ai = com.kwad.sdk.core.response.a.a.ai(this.mAdInfo);
            if (ai >= 3.0f) {
                this.cy.setScore(ai);
                this.cy.setVisibility(0);
            }
            this.cz.setText(com.kwad.sdk.core.response.a.a.ah(this.mAdInfo));
            this.cA.setText(com.kwad.sdk.core.response.a.a.ad(this.mAdInfo));
            this.cv.setVisibility(0);
            this.cC.setVisibility(8);
        } else {
            this.cD.setText(com.kwad.sdk.core.response.a.a.ad(this.mAdInfo));
            this.cE.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
            this.cv.setVisibility(8);
            this.cC.setVisibility(0);
        }
        this.cB.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        com.kwad.components.core.c.a.a.a(new a.C0593a(getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(view2 == this.cB ? 1 : 2).aj(view2 == this.cB).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                if (DrawVideoTailFrame.this.aJ != null) {
                    DrawVideoTailFrame.this.aJ.onAdClicked();
                }
                com.kwad.sdk.core.report.a.a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.ct.getTouchCoords());
            }
        }));
    }

    public final void release() {
        KsAppDownloadListener ksAppDownloadListener;
        c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.br) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.ct = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.aJ = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable c cVar) {
        this.mApkDownloadHelper = cVar;
    }
}
