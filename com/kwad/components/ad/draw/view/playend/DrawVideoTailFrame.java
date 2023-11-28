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
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    public KsDrawAd.AdInteractionListener bN;
    @Nullable
    public KsAppDownloadListener cx;
    public AdBaseFrameLayout dB;
    public ImageView dC;
    public ViewGroup dD;
    public ImageView dE;
    public TextView dF;
    public AppScoreView dG;
    public TextView dH;
    public TextView dI;
    public DrawDownloadProgressBar dJ;
    public ViewGroup dK;
    public TextView dL;
    public TextView dM;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    @Nullable
    public c mApkDownloadHelper;
    public KsLogoView mLogoView;

    public DrawVideoTailFrame(@NonNull Context context) {
        super(context);
        B(context);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.dB = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.bN = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }

    private void B(Context context) {
        l.inflate(context, R.layout.obfuscated_res_0x7f0d04c4, this);
        this.dC = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914f2);
        this.dD = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091301);
        this.dE = (ImageView) findViewById(R.id.obfuscated_res_0x7f091306);
        this.dF = (TextView) findViewById(R.id.obfuscated_res_0x7f091308);
        this.dG = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091309);
        this.dH = (TextView) findViewById(R.id.obfuscated_res_0x7f091305);
        this.dI = (TextView) findViewById(R.id.obfuscated_res_0x7f091300);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.obfuscated_res_0x7f091304);
        this.dJ = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(15);
        this.dK = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09136e);
        this.dL = (TextView) findViewById(R.id.obfuscated_res_0x7f09136d);
        this.dM = (TextView) findViewById(R.id.obfuscated_res_0x7f091371);
        this.mLogoView = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09135c);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new a() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                super.onPaused(i);
                DrawVideoTailFrame.this.dJ.e(com.kwad.sdk.core.response.b.a.DX(), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                DrawDownloadProgressBar drawDownloadProgressBar = DrawVideoTailFrame.this.dJ;
                drawDownloadProgressBar.e(i + "%", i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DrawVideoTailFrame.this.dJ.e(com.kwad.sdk.core.response.b.a.aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dJ.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DrawVideoTailFrame.this.dJ.e(com.kwad.sdk.core.response.b.a.bX(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.dJ.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DrawVideoTailFrame.this.dJ.e(com.kwad.sdk.core.response.b.a.aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dJ.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DrawVideoTailFrame.this.dJ.e(com.kwad.sdk.core.response.b.a.ac(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.dJ.getMax());
            }
        };
    }

    public final void aR() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.cx;
            if (ksAppDownloadListener != null) {
                cVar.d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.cx = appDownloadListener;
            this.mApkDownloadHelper.b(appDownloadListener);
        }
    }

    public final void release() {
        KsAppDownloadListener ksAppDownloadListener;
        c cVar = this.mApkDownloadHelper;
        if (cVar != null && (ksAppDownloadListener = this.cx) != null) {
            cVar.c(ksAppDownloadListener);
        }
    }

    public final void b(AdTemplate adTemplate) {
        boolean z;
        this.mAdTemplate = adTemplate;
        AdInfo dP = e.dP(adTemplate);
        this.mAdInfo = dP;
        AdInfo.AdMaterialInfo.MaterialFeature aV = com.kwad.sdk.core.response.b.a.aV(dP);
        String str = aV.coverUrl;
        this.mLogoView.aD(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i = aV.width;
            int i2 = aV.height;
            if (i > 0 && i > i2) {
                int screenWidth = com.kwad.sdk.d.a.a.getScreenWidth(getContext());
                if (getWidth() != 0) {
                    screenWidth = getWidth();
                }
                ViewGroup.LayoutParams layoutParams = this.dC.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = (int) (screenWidth * (i2 / i));
            }
            KSImageLoader.loadImage(this.dC, str, this.mAdTemplate);
        }
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), this.mAdTemplate, 11);
            this.dF.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
            float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
            if (aA >= 3.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.dG.setScore(aA);
                this.dG.setVisibility(0);
            }
            this.dH.setText(com.kwad.sdk.core.response.b.a.az(this.mAdInfo));
            this.dI.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
            this.dD.setVisibility(0);
            this.dK.setVisibility(8);
        } else {
            this.dL.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
            this.dM.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.dD.setVisibility(8);
            this.dK.setVisibility(0);
        }
        this.dJ.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        boolean z = true;
        if (view2 == this.dJ) {
            i = 1;
        } else {
            i = 2;
        }
        a.C0644a an = new a.C0644a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(i);
        if (view2 != this.dJ) {
            z = false;
        }
        com.kwad.components.core.e.d.a.a(an.ao(z).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawVideoTailFrame.this.bN != null) {
                    DrawVideoTailFrame.this.bN.onAdClicked();
                }
                com.kwad.sdk.core.report.a.a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.dB.getTouchCoords());
            }
        }));
    }
}
