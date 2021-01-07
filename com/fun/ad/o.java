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
/* loaded from: classes15.dex */
public class o extends i {
    public PBInterstitial pJd;

    /* loaded from: classes15.dex */
    public class a implements PBInterstitialListener {
        public a() {
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            m.a("JYInterstitialAd onClicked");
            o oVar = o.this;
            c cVar = oVar.pJa;
            if (cVar != null) {
                ((u) cVar).a(oVar.f8081a.f8060a);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            m.a("JYInterstitialAd onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg());
            o oVar = o.this;
            oVar.f8082b = false;
            f fVar = oVar.pIZ;
            if (fVar != null) {
                ((r) fVar).a(oVar.f8081a.f8060a, pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDismissed() {
            m.a("JYInterstitialAd onInterstitialDismissed");
            o oVar = o.this;
            c cVar = oVar.pJa;
            if (cVar != null) {
                ((u) cVar).b(oVar.f8081a.f8060a);
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialDisplayed() {
            m.a("JYInterstitialAd onInterstitialDisplayed");
            o oVar = o.this;
            c cVar = oVar.pJa;
            if (cVar != null) {
                ((u) cVar).c(oVar.f8081a.f8060a);
            }
        }

        @Override // com.win.opensdk.PBInterstitialListener
        public void onInterstitialShowFail(String str) {
            m.a("JYInterstitialAd onInterstitialShowFail");
            o oVar = o.this;
            c cVar = oVar.pJa;
            if (cVar != null) {
                ((u) cVar).a(oVar.f8081a.f8060a, 0, str);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            m.a("JYInterstitialAd onLoaded");
            o oVar = o.this;
            oVar.f8082b = false;
            f fVar = oVar.pIZ;
            if (fVar != null) {
                ((r) fVar).b(oVar.f8081a.f8060a);
            }
        }
    }

    public o(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.i
    public void a() {
        super.a();
        PBInterstitial pBInterstitial = this.pJd;
        if (pBInterstitial != null) {
            pBInterstitial.destroy();
            this.pJd = null;
        }
    }

    @Override // com.fun.ad.i
    public void a(Activity activity, FunAdView funAdView, c cVar) {
        super.a(activity, funAdView, cVar);
        PBInterstitial pBInterstitial = this.pJd;
        if (pBInterstitial == null || !pBInterstitial.isReady()) {
            m.a("JYInterstitialAd show error: Ad is not ready");
        } else {
            this.pJd.show();
        }
    }

    @Override // com.fun.ad.i
    public FunRippedAd eBP() {
        return null;
    }

    @Override // com.fun.ad.i
    public void a(Context context, FunAdSlot funAdSlot, f fVar) {
        super.a(context.getApplicationContext(), funAdSlot, fVar);
        if (!this.f8082b) {
            this.f8082b = true;
            PBInterstitial pBInterstitial = new PBInterstitial(context.getApplicationContext(), this.f8081a.f8060a);
            pBInterstitial.setInterstitialListener(new a());
            pBInterstitial.load();
            this.pJd = pBInterstitial;
            f fVar2 = this.pIZ;
            if (fVar2 != null) {
                ((r) fVar2).a(this.f8081a.f8060a);
            }
        }
    }
}
