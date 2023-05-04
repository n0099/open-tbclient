package com.kwad.components.ad.interstitial.widget;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.ad.interstitial.widget.f;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes8.dex */
public final class e extends b {
    public KsAdVideoPlayConfig cN;
    public KsInterstitialAd.AdInteractionListener fo;
    public com.kwad.components.ad.interstitial.b.c gh;
    public Dialog gi;
    public boolean gn;
    public c.a go;
    public com.kwad.components.core.webview.b.d.b gp;
    public int gx;
    public boolean iA;
    public ViewGroup iB;
    public com.kwad.components.ad.interstitial.b.b iz;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;

    public e(@NonNull Context context) {
        this(context, null);
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.gx = -1;
        this.gp = new com.kwad.components.core.webview.b.d.b() { // from class: com.kwad.components.ad.interstitial.widget.e.1
            @Override // com.kwad.components.core.webview.b.d.b
            public final void u(String str) {
                if ("ksad-interstitial-card".equals(str)) {
                    e.a(e.this, false);
                    com.kwad.components.ad.interstitial.b.b bVar = e.this.iz;
                    if (bVar != null) {
                        bVar.bt();
                    }
                    e eVar = e.this;
                    eVar.iz = eVar.dV();
                    e eVar2 = e.this;
                    eVar2.iz.B(eVar2.iB);
                    e eVar3 = e.this;
                    eVar3.iz.e(eVar3.gh);
                }
            }
        };
        this.iB = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
    }

    private f a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.b.c cVar) {
        boolean a = com.kwad.components.ad.interstitial.b.c.a(this.mContext, adInfo);
        f.a aVar = new f.a();
        aVar.v(a);
        boolean z = true;
        aVar.w(!cVar.K(context) && com.kwad.components.ad.interstitial.kwai.b.cj());
        aVar.E(com.kwad.components.ad.interstitial.kwai.b.ck());
        if (com.kwad.sdk.core.response.a.a.av(adInfo) && ag.cB(context)) {
            z = false;
        }
        aVar.x(z);
        return new f(context, aVar);
    }

    public static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.iA = false;
        return false;
    }

    private com.kwad.components.ad.interstitial.b.c dU() {
        com.kwad.components.ad.interstitial.b.c cVar = new com.kwad.components.ad.interstitial.b.c();
        AdTemplate adTemplate = this.mAdTemplate;
        cVar.mAdTemplate = adTemplate;
        cVar.fo = this.fo;
        cVar.gi = this.gi;
        cVar.mApkDownloadHelper = new com.kwad.components.core.c.a.c(adTemplate);
        cVar.cN = this.cN;
        cVar.dp = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) this.iB.findViewById(R.id.obfuscated_res_0x7f091204);
        cVar.gq = kSFrameLayout;
        com.kwad.components.ad.interstitial.c.b bVar = new com.kwad.components.ad.interstitial.c.b(kSFrameLayout, 100);
        cVar.gt = bVar;
        bVar.qi();
        cVar.gx = this.gx;
        cVar.gn = this.gn;
        cVar.go = this.go;
        cVar.gp = this.gp;
        cVar.gj = a(this.mContext, com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate), cVar);
        return cVar;
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void a(@NonNull AdTemplate adTemplate, Dialog dialog, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        adTemplate.realShowType = 2;
        this.cN = ksAdVideoPlayConfig;
        this.gi = dialog;
        this.iA = com.kwad.sdk.core.response.a.b.bn(this.mAdTemplate);
        this.fo = adInteractionListener;
        this.gh = dU();
        if (this.iz == null) {
            this.iz = dV();
        }
        this.iz.B(this.iB);
        this.iz.e(this.gh);
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void dM() {
        this.iz.cv();
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void dN() {
        this.iz.cw();
    }

    @NonNull
    public final com.kwad.components.ad.interstitial.b.b dV() {
        Presenter gVar;
        com.kwad.components.ad.interstitial.b.b bVar = new com.kwad.components.ad.interstitial.b.b();
        if (!this.iA) {
            bVar.a(new com.kwad.components.ad.interstitial.b.d());
            if (com.kwad.sdk.core.response.a.a.aB(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.b.h());
            }
            bVar.a(new com.kwad.components.ad.interstitial.b.i());
            bVar.a(new com.kwad.components.ad.interstitial.b.f());
            bVar.a(new com.kwad.components.ad.interstitial.b.e(this.mAdInfo));
            if (com.kwad.sdk.core.response.a.a.ao(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.b.a());
            }
            if (this.gh.K(getContext())) {
                gVar = new com.kwad.components.ad.interstitial.b.g();
            }
            return bVar;
        }
        gVar = new com.kwad.components.ad.interstitial.b.kwai.b();
        bVar.a(gVar);
        return bVar;
    }

    public final void dW() {
        com.kwad.components.ad.interstitial.b.c cVar = this.gh;
        if (cVar == null || !cVar.gw) {
            return;
        }
        cVar.cz();
    }

    public final void dX() {
        com.kwad.components.ad.interstitial.b.c cVar = this.gh;
        if (cVar != null) {
            if (this.iA || cVar.gw) {
                this.gh.cA();
            }
        }
    }

    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d046f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.b.c cVar = this.gh;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.interstitial.b.b bVar = this.iz;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public final void setAdConvertListener(c.a aVar) {
        this.go = aVar;
        com.kwad.components.ad.interstitial.b.c cVar = this.gh;
        if (cVar != null) {
            cVar.go = aVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.widget.b
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.fo = adInteractionListener;
        com.kwad.components.ad.interstitial.b.c cVar = this.gh;
        if (cVar != null) {
            cVar.fo = adInteractionListener;
        }
    }

    public final void setAggregateAdView(boolean z) {
        this.gn = z;
        com.kwad.components.ad.interstitial.b.c cVar = this.gh;
        if (cVar != null) {
            cVar.gn = z;
        }
    }

    public final void setAggregateShowTriggerType(int i) {
        this.gx = i;
        com.kwad.components.ad.interstitial.b.c cVar = this.gh;
        if (cVar != null) {
            cVar.gx = i;
        }
    }
}
