package com.kwad.components.ad.interstitial.g;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.ad.interstitial.e.f;
import com.kwad.components.ad.interstitial.e.g;
import com.kwad.components.ad.interstitial.g.d;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public final class c extends a {
    public KsAdVideoPlayConfig dU;
    public KsInterstitialAd.AdInteractionListener ie;
    public com.kwad.components.ad.interstitial.d io;
    public com.kwad.components.ad.interstitial.e.c jK;
    public boolean jO;
    public c.a jP;
    public com.kwad.components.core.webview.tachikoma.e.e jR;
    public int jY;
    @Nullable
    public com.kwad.components.ad.interstitial.e.b lA;
    public boolean lB;
    public ViewGroup lC;
    public AdInfo mAdInfo;
    @NonNull
    public AdResultData mAdResultData;
    @NonNull
    public AdTemplate mAdTemplate;

    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04dd;
    }

    public c(@NonNull Context context) {
        this(context, null);
    }

    public final void setAdConvertListener(c.a aVar) {
        this.jP = aVar;
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.jP = aVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.ie = adInteractionListener;
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.ie = adInteractionListener;
        }
    }

    public final void setAggregateAdView(boolean z) {
        this.jO = z;
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.jO = z;
        }
    }

    public final void setAggregateShowTriggerType(int i) {
        this.jY = i;
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.jY = i;
        }
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.jY = -1;
        this.jR = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.interstitial.g.c.1
            @Override // com.kwad.components.core.webview.tachikoma.e.b
            public final void q(String str) {
                if ("tk_interstitial".equals(str)) {
                    c.a(c.this, false);
                    com.kwad.components.ad.interstitial.e.b bVar = c.this.lA;
                    if (bVar != null) {
                        bVar.lP();
                    }
                    c cVar = c.this;
                    cVar.lA = cVar.dY();
                    c cVar2 = c.this;
                    cVar2.lA.G(cVar2.lC);
                    c cVar3 = c.this;
                    cVar3.lA.k(cVar3.jK);
                }
            }
        };
        this.lC = (ViewGroup) l.inflate(context, getLayoutId(), this);
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.lB = false;
        return false;
    }

    private d a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.e.c cVar) {
        boolean z;
        boolean a = com.kwad.components.ad.interstitial.e.c.a(this.mContext, adInfo);
        d.a aVar = new d.a();
        aVar.v(a);
        boolean z2 = true;
        if (!cVar.K(context) && com.kwad.components.ad.interstitial.b.b.cF()) {
            z = true;
        } else {
            z = false;
        }
        aVar.w(z);
        aVar.F(com.kwad.components.ad.interstitial.b.b.cG());
        if (com.kwad.sdk.core.response.b.a.aW(adInfo) && ai.Kx()) {
            z2 = false;
        }
        aVar.x(z2);
        return new d(context, aVar);
    }

    private com.kwad.components.ad.interstitial.e.c dX() {
        com.kwad.components.ad.interstitial.e.c cVar = new com.kwad.components.ad.interstitial.e.c();
        cVar.d(this.mAdResultData);
        cVar.ie = this.ie;
        cVar.io = this.io;
        cVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        cVar.dU = this.dU;
        cVar.eN = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) this.lC.findViewById(R.id.obfuscated_res_0x7f09133c);
        cVar.jS = kSFrameLayout;
        com.kwad.components.ad.interstitial.f.b bVar = new com.kwad.components.ad.interstitial.f.b(kSFrameLayout, 100);
        cVar.ib = bVar;
        bVar.tm();
        cVar.jY = this.jY;
        cVar.jO = this.jO;
        cVar.jP = this.jP;
        cVar.jR = this.jR;
        cVar.jL = a(this.mContext, com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate), cVar);
        return cVar;
    }

    @NonNull
    public final com.kwad.components.ad.interstitial.e.b dY() {
        com.kwad.components.ad.interstitial.e.b bVar = new com.kwad.components.ad.interstitial.e.b();
        if (this.lB) {
            bVar.a(new com.kwad.components.ad.interstitial.e.a.b());
        } else {
            if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
                bVar.a(new f());
            }
            bVar.a(new g());
            bVar.a(new com.kwad.components.ad.interstitial.e.d());
            if (com.kwad.sdk.core.response.b.a.aP(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.e.a());
            }
            if (this.jK.K(getContext())) {
                bVar.a(new com.kwad.components.ad.interstitial.e.e());
            }
        }
        return bVar;
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void a(@NonNull AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdResultData = adResultData;
        AdTemplate m = com.kwad.sdk.core.response.b.c.m(adResultData);
        this.mAdTemplate = m;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(m);
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.realShowType = 2;
        this.dU = ksAdVideoPlayConfig;
        this.io = dVar;
        this.lB = com.kwad.sdk.core.response.b.b.cR(adTemplate);
        this.ie = adInteractionListener;
        this.jK = dX();
        if (this.lA == null) {
            this.lA = dY();
        }
        this.lA.G(this.lC);
        this.lA.k(this.jK);
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void cr() {
        com.kwad.components.ad.interstitial.e.b bVar = this.lA;
        if (bVar != null) {
            bVar.cP();
        }
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void cs() {
        com.kwad.components.ad.interstitial.e.b bVar = this.lA;
        if (bVar != null) {
            bVar.cQ();
        }
    }

    public final void dZ() {
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null && cVar.jX) {
            cVar.cR();
        }
    }

    public final void ea() {
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            if (this.lB || cVar.jX) {
                this.jK.cS();
            }
        }
    }

    public final void eb() {
        if (this.jK != null) {
            this.jK.a(new c.b(this.mContext).k(true).A(1).m(true).z(2));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.interstitial.e.b bVar = this.lA;
        if (bVar != null) {
            bVar.destroy();
        }
    }
}
