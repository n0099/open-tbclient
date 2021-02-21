package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.win.opensdk.PBError;
import com.win.opensdk.PBInterstitial;
import com.win.opensdk.PBInterstitialListener;
/* loaded from: classes6.dex */
public class o extends i {
    public PBInterstitial pPi;

    /* loaded from: classes6.dex */
    public class a implements PBInterstitialListener {
        public a() {
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            m.a("JYInterstitialAd onClicked");
            o oVar = o.this;
            c cVar = oVar.pPf;
            if (cVar != null) {
                ((u) cVar).a(oVar.f7783a.f7762a);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            m.a("JYInterstitialAd onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg());
            o oVar = o.this;
            oVar.f7784b = false;
            f fVar = oVar.pPe;
            if (fVar != null) {
                ((r) fVar).a(oVar.f7783a.f7762a, pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDismissed() {
            m.a("JYInterstitialAd onInterstitialDismissed");
            o oVar = o.this;
            c cVar = oVar.pPf;
            if (cVar != null) {
                ((u) cVar).b(oVar.f7783a.f7762a);
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDisplayed() {
            m.a("JYInterstitialAd onInterstitialDisplayed");
            o oVar = o.this;
            c cVar = oVar.pPf;
            if (cVar != null) {
                ((u) cVar).c(oVar.f7783a.f7762a);
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialShowFail(String str) {
            m.a("JYInterstitialAd onInterstitialShowFail");
            o oVar = o.this;
            c cVar = oVar.pPf;
            if (cVar != null) {
                ((u) cVar).a(oVar.f7783a.f7762a, 0, str);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            m.a("JYInterstitialAd onLoaded");
            o oVar = o.this;
            oVar.f7784b = false;
            f fVar = oVar.pPe;
            if (fVar != null) {
                ((r) fVar).b(oVar.f7783a.f7762a);
            }
        }
    }

    public o(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.i
    public void a() {
        super.a();
        PBInterstitial pBInterstitial = this.pPi;
        if (pBInterstitial != null) {
            pBInterstitial.destroy();
            this.pPi = null;
        }
    }

    @Override // com.fun.ad.i
    public void a(Activity activity, FunAdView funAdView, c cVar) {
        super.a(activity, funAdView, cVar);
        PBInterstitial pBInterstitial = this.pPi;
        if (pBInterstitial == null || !pBInterstitial.isReady()) {
            m.a("JYInterstitialAd show error: Ad is not ready");
        } else {
            this.pPi.show();
        }
    }

    @Override // com.fun.ad.i
    public FunRippedAd eAx() {
        return null;
    }

    @Override // com.fun.ad.i
    public void a(Context context, FunAdSlot funAdSlot, f fVar) {
        super.a(context.getApplicationContext(), funAdSlot, fVar);
        if (!this.f7784b) {
            this.f7784b = true;
            PBInterstitial pBInterstitial = new PBInterstitial(context.getApplicationContext(), this.f7783a.f7762a);
            pBInterstitial.setInterstitialListener(new a());
            pBInterstitial.load();
            this.pPi = pBInterstitial;
            f fVar2 = this.pPe;
            if (fVar2 != null) {
                ((r) fVar2).a(this.f7783a.f7762a);
            }
        }
    }
}
