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
/* loaded from: classes15.dex */
public class bm extends an {
    public RewardVideoAD pKi;

    /* loaded from: classes15.dex */
    public class a implements RewardVideoADListener {
        public a() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            m.a("GDTRewardVideoAd onADClick");
            bm bmVar = bm.this;
            ah ahVar = bmVar.pJI;
            if (ahVar != null) {
                ((aa) ahVar).c(bmVar.f8052a.f8060a);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            m.a("GDTRewardVideoAd onADClose");
            bm bmVar = bm.this;
            ah ahVar = bmVar.pJI;
            if (ahVar != null) {
                ((aa) ahVar).a(bmVar.f8052a.f8060a);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            m.a("GDTRewardVideoAd onADExpose");
            bm bmVar = bm.this;
            ah ahVar = bmVar.pJI;
            if (ahVar != null) {
                ((aa) ahVar).b(bmVar.f8052a.f8060a);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            m.a("GDTRewardVideoAd onADLoad");
            bm bmVar = bm.this;
            bmVar.f8053b = false;
            ak akVar = bmVar.pJH;
            if (akVar != null) {
                ((x) akVar).b(bmVar.f8052a.f8060a);
            }
            AdRipper.ripGDTRewardVideo(bm.this.pKi);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            m.a("GDTRewardVideoAd onADShow");
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            m.a("GDTRewardVideoAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg());
            bm bmVar = bm.this;
            bmVar.f8053b = false;
            ak akVar = bmVar.pJH;
            if (akVar != null) {
                ((x) akVar).a(bmVar.f8052a.f8060a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward() {
            m.a("GDTRewardVideoAd onReward");
            bm bmVar = bm.this;
            ah ahVar = bmVar.pJI;
            if (ahVar != null) {
                String str = bmVar.f8052a.f8060a;
                aa aaVar = (aa) ahVar;
                if (aaVar == null) {
                    throw null;
                }
                m.a("FunAdLoader 优量汇广告 onRewardedVideo，广告ID：" + str);
                FunAdInteractionListener funAdInteractionListener = aaVar.pJv;
                if (funAdInteractionListener != null) {
                    funAdInteractionListener.onRewardedVideo(aaVar.pJx.pJf.f8058a);
                }
                d.b bVar = d.pIU;
                ((d.a) bVar).e(aaVar.f8042b, aaVar.pJw.f8061b, str);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            m.a("GDTRewardVideoAd onVideoCached");
            ah ahVar = bm.this.pJI;
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
            ah ahVar = bm.this.pJI;
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
        this.pKi = null;
    }

    @Override // com.fun.ad.an
    public FunRippedAd eBP() {
        AdRipper.RippedGDTAd rippedGDTRewardVideoAd;
        RewardVideoAD rewardVideoAD = this.pKi;
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
        if (!this.f8053b) {
            this.f8053b = true;
            RewardVideoAD rewardVideoAD = new RewardVideoAD(context.getApplicationContext(), this.f8052a.f8060a, (RewardVideoADListener) new a(), true);
            this.pKi = rewardVideoAD;
            rewardVideoAD.loadAD();
            ak akVar2 = this.pJH;
            if (akVar2 != null) {
                ((x) akVar2).a(this.f8052a.f8060a);
            }
        }
    }

    @Override // com.fun.ad.an
    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        super.a(activity, funAdView, ahVar);
        RewardVideoAD rewardVideoAD = this.pKi;
        if (rewardVideoAD != null) {
            rewardVideoAD.showAD(activity);
            return;
        }
        ah ahVar2 = this.pJI;
        if (ahVar2 != null) {
            ((aa) ahVar2).a(this.f8052a.f8060a, 0, "Custom error message: mRewardVideoAD is null when show");
        }
    }
}
