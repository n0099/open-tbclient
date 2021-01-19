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
/* loaded from: classes14.dex */
public class t extends i {
    public com.win.opensdk.b pET;

    /* loaded from: classes14.dex */
    public class a implements com.win.opensdk.c {
        public a() {
        }

        @Override // com.win.opensdk.c
        public void YC(String str) {
            m.a("jyRewardVideoAd onRewardedShowFail: errorCode: 0, , errorMessage: " + str);
            t tVar = t.this;
            c cVar = tVar.pEA;
            if (cVar != null) {
                ((u) cVar).a(tVar.f7781a.f7760a, 0, str);
            }
        }

        @Override // com.win.opensdk.c
        public void exY() {
            m.a("jyRewardVideoAd onRewardedAdClosed");
            t tVar = t.this;
            c cVar = tVar.pEA;
            if (cVar != null) {
                ((u) cVar).b(tVar.f7781a.f7760a);
            }
        }

        @Override // com.win.opensdk.c
        public void exZ() {
            m.a("jyRewardVideoAd onRewardedAdOpened");
            t tVar = t.this;
            c cVar = tVar.pEA;
            if (cVar != null) {
                ((u) cVar).c(tVar.f7781a.f7760a);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            m.a("jyRewardVideoAd onClicked");
            t tVar = t.this;
            c cVar = tVar.pEA;
            if (cVar != null) {
                ((u) cVar).a(tVar.f7781a.f7760a);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            m.a("jyRewardVideoAd onFail errorCode: " + pBError.getCode() + ", errorMessage: " + pBError.getMsg());
            t tVar = t.this;
            f fVar = tVar.pEz;
            if (fVar != null) {
                ((r) fVar).a(tVar.f7781a.f7760a, pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            m.a("jyRewardVideoAd onLoaded");
            t tVar = t.this;
            f fVar = tVar.pEz;
            if (fVar != null) {
                ((r) fVar).b(tVar.f7781a.f7760a);
            }
        }

        @Override // com.win.opensdk.c
        public void r(boolean z, long j) {
            m.a("jyRewardVideoAd onUserEarnedReward");
            t tVar = t.this;
            c cVar = tVar.pEA;
            if (cVar != null) {
                String str = tVar.f7781a.f7760a;
                u uVar = (u) cVar;
                if (uVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 巨赢互联广告 onRewardedVideo，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = uVar.pEV;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onRewardedVideo(uVar.pEX.pEF.f7758a);
                }
                d.b bVar = d.pEu;
                ((d.a) bVar).e(uVar.f7837b, uVar.pEW.f7761b, str);
            }
        }
    }

    public t(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.i
    public void a() {
        super.a();
        com.win.opensdk.b bVar = this.pET;
        if (bVar != null) {
            bVar.destroy();
            this.pET = null;
        }
    }

    @Override // com.fun.ad.i
    public FunRippedAd exX() {
        return null;
    }

    @Override // com.fun.ad.i
    public void a(Context context, FunAdSlot funAdSlot, f fVar) {
        super.a(context, funAdSlot, fVar);
        if (!this.f7782b) {
            this.f7782b = true;
            com.win.opensdk.b bVar = new com.win.opensdk.b(context, this.f7781a.f7760a);
            this.pET = bVar;
            bVar.a(new a());
            this.pET.load();
            f fVar2 = this.pEz;
            if (fVar2 != null) {
                ((r) fVar2).a(this.f7781a.f7760a);
            }
        }
    }

    @Override // com.fun.ad.i
    public void a(Activity activity, FunAdView funAdView, c cVar) {
        super.a(activity, funAdView, cVar);
        com.win.opensdk.b bVar = this.pET;
        if (bVar != null && bVar.isReady()) {
            this.pET.show();
            return;
        }
        c cVar2 = this.pEA;
        if (cVar2 != null) {
            ((u) cVar2).a(this.f7781a.f7760a, 0, "Custom error message: mPBVideo is null or not ready");
        }
    }
}
