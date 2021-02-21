package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.util.AdError;
/* loaded from: classes6.dex */
public class bm extends an {
    public RewardVideoAD pQn;

    /* loaded from: classes6.dex */
    public class a implements RewardVideoADListener {
        public a() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            m.a("GDTRewardVideoAd onADClick");
            bm bmVar = bm.this;
            ah ahVar = bmVar.pPN;
            if (ahVar != null) {
                ((aa) ahVar).c(bmVar.f7754a.f7762a);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            m.a("GDTRewardVideoAd onADClose");
            bm bmVar = bm.this;
            ah ahVar = bmVar.pPN;
            if (ahVar != null) {
                ((aa) ahVar).a(bmVar.f7754a.f7762a);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            m.a("GDTRewardVideoAd onADExpose");
            bm bmVar = bm.this;
            ah ahVar = bmVar.pPN;
            if (ahVar != null) {
                ((aa) ahVar).b(bmVar.f7754a.f7762a);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            m.a("GDTRewardVideoAd onADLoad");
            bm bmVar = bm.this;
            bmVar.f7755b = false;
            ak akVar = bmVar.pPM;
            if (akVar != null) {
                ((x) akVar).b(bmVar.f7754a.f7762a);
            }
            AdRipper.ripGDTRewardVideo(bm.this.pQn);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            m.a("GDTRewardVideoAd onADShow");
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            m.a("GDTRewardVideoAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg());
            bm bmVar = bm.this;
            bmVar.f7755b = false;
            ak akVar = bmVar.pPM;
            if (akVar != null) {
                ((x) akVar).a(bmVar.f7754a.f7762a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward() {
            m.a("GDTRewardVideoAd onReward");
            bm bmVar = bm.this;
            ah ahVar = bmVar.pPN;
            if (ahVar != null) {
                String str = bmVar.f7754a.f7762a;
                aa aaVar = (aa) ahVar;
                if (aaVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 优量汇广告 onRewardedVideo，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = aaVar.pPA;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onRewardedVideo(aaVar.pPC.pPk.f7760a);
                }
                d.b bVar = d.pOZ;
                ((d.a) bVar).e(aaVar.f7744b, aaVar.pPB.f7763b, str);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            m.a("GDTRewardVideoAd onVideoCached");
            ah ahVar = bm.this.pPN;
            if (ahVar != null) {
                if (((aa) ahVar) == null) {
                    throw null;
                }
                m.a("GDTAdLoaderFactory onVideoCached");
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            m.a("GDTRewardVideoAd onVideoComplete");
            ah ahVar = bm.this.pPN;
            if (ahVar != null) {
                if (((aa) ahVar) == null) {
                    throw null;
                }
                m.a("GDTAdLoaderFactory onVideoComplete");
            }
        }
    }

    public bm(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.an
    public void a() {
        super.a();
        this.pQn = null;
    }

    @Override // com.fun.ad.an
    public FunRippedAd eAx() {
        AdRipper.RippedGDTAd rippedGDTRewardVideoAd;
        RewardVideoAD rewardVideoAD = this.pQn;
        if (rewardVideoAD == null || (rippedGDTRewardVideoAd = AdRipper.getRippedGDTRewardVideoAd(rewardVideoAD, false)) == null) {
            return null;
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        funRippedAd.title = rippedGDTRewardVideoAd.title;
        funRippedAd.description = rippedGDTRewardVideoAd.description;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedGDTRewardVideoAd.customized_invoke_url);
        funRippedAd.uniqueId = rippedGDTRewardVideoAd.title;
        funRippedAd.appName = rippedGDTRewardVideoAd.appName;
        funRippedAd.appPackageName = rippedGDTRewardVideoAd.appPackageName;
        funRippedAd.appLinkUrl = rippedGDTRewardVideoAd.appLinkUrl;
        return funRippedAd;
    }

    @Override // com.fun.ad.an
    public void a(Context context, FunAdSlot funAdSlot, ak akVar) {
        super.a(context.getApplicationContext(), funAdSlot, akVar);
        if (!this.f7755b) {
            this.f7755b = true;
            RewardVideoAD rewardVideoAD = new RewardVideoAD(context.getApplicationContext(), this.f7754a.f7762a, (RewardVideoADListener) new a(), true);
            this.pQn = rewardVideoAD;
            rewardVideoAD.loadAD();
            ak akVar2 = this.pPM;
            if (akVar2 != null) {
                ((x) akVar2).a(this.f7754a.f7762a);
            }
        }
    }

    @Override // com.fun.ad.an
    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        super.a(activity, funAdView, ahVar);
        RewardVideoAD rewardVideoAD = this.pQn;
        if (rewardVideoAD != null) {
            rewardVideoAD.showAD(activity);
            return;
        }
        ah ahVar2 = this.pPN;
        if (ahVar2 != null) {
            ((aa) ahVar2).a(this.f7754a.f7762a, 0, "Custom error message: mRewardVideoAD is null when show");
        }
    }
}
