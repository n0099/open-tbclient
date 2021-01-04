package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.win.opensdk.PBError;
/* loaded from: classes15.dex */
public class t extends i {
    public com.win.opensdk.b pHL;

    /* loaded from: classes15.dex */
    public class a implements com.win.opensdk.c {
        public a() {
        }

        @Override // com.win.opensdk.c
        public void ZI(String str) {
            m.a("jyRewardVideoAd onRewardedShowFail: errorCode: 0, , errorMessage: " + str);
            t tVar = t.this;
            c cVar = tVar.pHs;
            if (cVar != null) {
                ((u) cVar).a(tVar.f8080a.f8059a, 0, str);
            }
        }

        @Override // com.win.opensdk.c
        public void eBm() {
            m.a("jyRewardVideoAd onRewardedAdClosed");
            t tVar = t.this;
            c cVar = tVar.pHs;
            if (cVar != null) {
                ((u) cVar).b(tVar.f8080a.f8059a);
            }
        }

        @Override // com.win.opensdk.c
        public void eBn() {
            m.a("jyRewardVideoAd onRewardedAdOpened");
            t tVar = t.this;
            c cVar = tVar.pHs;
            if (cVar != null) {
                ((u) cVar).c(tVar.f8080a.f8059a);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            m.a("jyRewardVideoAd onClicked");
            t tVar = t.this;
            c cVar = tVar.pHs;
            if (cVar != null) {
                ((u) cVar).a(tVar.f8080a.f8059a);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            m.a("jyRewardVideoAd onFail errorCode: " + pBError.getCode() + ", errorMessage: " + pBError.getMsg());
            t tVar = t.this;
            f fVar = tVar.pHr;
            if (fVar != null) {
                ((r) fVar).a(tVar.f8080a.f8059a, pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            m.a("jyRewardVideoAd onLoaded");
            t tVar = t.this;
            f fVar = tVar.pHr;
            if (fVar != null) {
                ((r) fVar).b(tVar.f8080a.f8059a);
            }
        }

        @Override // com.win.opensdk.c
        public void r(boolean z, long j) {
            m.a("jyRewardVideoAd onUserEarnedReward");
            t tVar = t.this;
            c cVar = tVar.pHs;
            if (cVar != null) {
                String str = tVar.f8080a.f8059a;
                u uVar = (u) cVar;
                if (uVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 巨赢互联广告 onRewardedVideo，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = uVar.pHN;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onRewardedVideo(uVar.pHP.pHx.f8057a);
                }
                d.b bVar = d.pHm;
                ((d.a) bVar).e(uVar.f8136b, uVar.pHO.f8060b, str);
            }
        }
    }

    public t(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.i
    public void a() {
        super.a();
        com.win.opensdk.b bVar = this.pHL;
        if (bVar != null) {
            bVar.destroy();
            this.pHL = null;
        }
    }

    @Override // com.fun.ad.i
    public FunRippedAd eBl() {
        return null;
    }

    @Override // com.fun.ad.i
    public void a(Context context, FunAdSlot funAdSlot, f fVar) {
        super.a(context, funAdSlot, fVar);
        if (!this.f8081b) {
            this.f8081b = true;
            com.win.opensdk.b bVar = new com.win.opensdk.b(context, this.f8080a.f8059a);
            this.pHL = bVar;
            bVar.a(new a());
            this.pHL.load();
            f fVar2 = this.pHr;
            if (fVar2 != null) {
                ((r) fVar2).a(this.f8080a.f8059a);
            }
        }
    }

    @Override // com.fun.ad.i
    public void a(Activity activity, FunAdView funAdView, c cVar) {
        super.a(activity, funAdView, cVar);
        com.win.opensdk.b bVar = this.pHL;
        if (bVar != null && bVar.isReady()) {
            this.pHL.show();
            return;
        }
        c cVar2 = this.pHs;
        if (cVar2 != null) {
            ((u) cVar2).a(this.f8080a.f8059a, 0, "Custom error message: mPBVideo is null or not ready");
        }
    }
}
