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
/* loaded from: classes6.dex */
public class t extends i {
    public com.win.opensdk.b pPy;

    /* loaded from: classes6.dex */
    public class a implements com.win.opensdk.c {
        public a() {
        }

        @Override // com.win.opensdk.c
        public void ZP(String str) {
            m.a("jyRewardVideoAd onRewardedShowFail: errorCode: 0, , errorMessage: " + str);
            t tVar = t.this;
            c cVar = tVar.pPf;
            if (cVar != null) {
                ((u) cVar).a(tVar.f7783a.f7762a, 0, str);
            }
        }

        @Override // com.win.opensdk.c
        public void eAy() {
            m.a("jyRewardVideoAd onRewardedAdClosed");
            t tVar = t.this;
            c cVar = tVar.pPf;
            if (cVar != null) {
                ((u) cVar).b(tVar.f7783a.f7762a);
            }
        }

        @Override // com.win.opensdk.c
        public void eAz() {
            m.a("jyRewardVideoAd onRewardedAdOpened");
            t tVar = t.this;
            c cVar = tVar.pPf;
            if (cVar != null) {
                ((u) cVar).c(tVar.f7783a.f7762a);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            m.a("jyRewardVideoAd onClicked");
            t tVar = t.this;
            c cVar = tVar.pPf;
            if (cVar != null) {
                ((u) cVar).a(tVar.f7783a.f7762a);
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            m.a("jyRewardVideoAd onFail errorCode: " + pBError.getCode() + ", errorMessage: " + pBError.getMsg());
            t tVar = t.this;
            f fVar = tVar.pPe;
            if (fVar != null) {
                ((r) fVar).a(tVar.f7783a.f7762a, pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            m.a("jyRewardVideoAd onLoaded");
            t tVar = t.this;
            f fVar = tVar.pPe;
            if (fVar != null) {
                ((r) fVar).b(tVar.f7783a.f7762a);
            }
        }

        @Override // com.win.opensdk.c
        public void r(boolean z, long j) {
            m.a("jyRewardVideoAd onUserEarnedReward");
            t tVar = t.this;
            c cVar = tVar.pPf;
            if (cVar != null) {
                String str = tVar.f7783a.f7762a;
                u uVar = (u) cVar;
                if (uVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 巨赢互联广告 onRewardedVideo，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = uVar.pPA;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onRewardedVideo(uVar.pPC.pPk.f7760a);
                }
                d.b bVar = d.pOZ;
                ((d.a) bVar).e(uVar.f7839b, uVar.pPB.f7763b, str);
            }
        }
    }

    public t(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.i
    public void a() {
        super.a();
        com.win.opensdk.b bVar = this.pPy;
        if (bVar != null) {
            bVar.destroy();
            this.pPy = null;
        }
    }

    @Override // com.fun.ad.i
    public FunRippedAd eAx() {
        return null;
    }

    @Override // com.fun.ad.i
    public void a(Context context, FunAdSlot funAdSlot, f fVar) {
        super.a(context, funAdSlot, fVar);
        if (!this.f7784b) {
            this.f7784b = true;
            com.win.opensdk.b bVar = new com.win.opensdk.b(context, this.f7783a.f7762a);
            this.pPy = bVar;
            bVar.a(new a());
            this.pPy.load();
            f fVar2 = this.pPe;
            if (fVar2 != null) {
                ((r) fVar2).a(this.f7783a.f7762a);
            }
        }
    }

    @Override // com.fun.ad.i
    public void a(Activity activity, FunAdView funAdView, c cVar) {
        super.a(activity, funAdView, cVar);
        com.win.opensdk.b bVar = this.pPy;
        if (bVar != null && bVar.isReady()) {
            this.pPy.show();
            return;
        }
        c cVar2 = this.pPf;
        if (cVar2 != null) {
            ((u) cVar2).a(this.f7783a.f7762a, 0, "Custom error message: mPBVideo is null or not ready");
        }
    }
}
