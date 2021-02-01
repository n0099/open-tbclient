package com.fun.ad.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.d;
import com.fun.ad.m;
import com.fun.ad.sdk.AdRipper;
import com.kwad.sdk.api.KsDrawAd;
/* loaded from: classes6.dex */
public class FunDrawVideoAd {
    public String mAid;
    public KsDrawAd mKsDrawAd;
    public AdRipper.RippedCSJAd mRippedCSJAd;
    public AdRipper.RippedKSAd mRippedKSAd;
    public String mSid;
    public TTNativeExpressAd mTTNativeExpressAd;
    public boolean mTTNativeExpressAdRenderFailed = false;

    /* loaded from: classes6.dex */
    public class a implements TTNativeExpressAd.ExpressAdInteractionListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i) {
            m.a("FunDrawVideoAd onAdClicked");
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i) {
            m.a("FunDrawVideoAd onAdShow");
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i) {
            m.a("FunDrawVideoAd onRenderFail");
            FunDrawVideoAd.this.mTTNativeExpressAdRenderFailed = true;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f, float f2) {
            m.a("FunDrawVideoAd onRenderSuccess");
            FunDrawVideoAd.this.mTTNativeExpressAdRenderFailed = false;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements KsDrawAd.AdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunDrawVideoAdInteractionListener f7793a;

        public b(FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener) {
            this.f7793a = funDrawVideoAdInteractionListener;
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onAdClicked() {
            m.a("FunDrawVideoAd onAdClicked");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7793a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onAdClick(FunDrawVideoAd.this.mSid);
            }
            FunDrawVideoAd.this.ripKsAd();
            if (FunDrawVideoAd.this.mRippedKSAd != null) {
                ((d.a) com.fun.ad.d.pOz).a(FunDrawVideoAd.this.mSid, FunAdType.KS_DRAW_VIDEO, FunDrawVideoAd.this.mAid, FunDrawVideoAd.this.mRippedKSAd.appPackageName, FunDrawVideoAd.this.mRippedKSAd.appDownloadUrl);
                return;
            }
            ((d.a) com.fun.ad.d.pOz).a(FunDrawVideoAd.this.mSid, FunAdType.KS_DRAW_VIDEO, FunDrawVideoAd.this.mAid, (String) null, (String) null);
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onAdShow() {
            m.a("FunDrawVideoAd onAdShow");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7793a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onAdShow(FunDrawVideoAd.this.mSid);
            }
            ((d.a) com.fun.ad.d.pOz).d(FunDrawVideoAd.this.mSid, FunAdType.KS_DRAW_VIDEO, FunDrawVideoAd.this.mAid);
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayEnd() {
            m.a("FunDrawVideoAd onVideoPlayEnd");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7793a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onVideoAdComplete(FunDrawVideoAd.this.mSid);
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayError() {
            m.a("FunDrawVideoAd onVideoPlayError");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7793a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onVideoError(FunDrawVideoAd.this.mSid, 0, 0);
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayPause() {
            m.a("FunDrawVideoAd onVideoPlayPause");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7793a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onVideoAdPaused(FunDrawVideoAd.this.mSid);
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayResume() {
            m.a("FunDrawVideoAd onVideoPlayResume");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7793a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onVideoAdContinuePlay(FunDrawVideoAd.this.mSid);
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayStart() {
            m.a("FunDrawVideoAd onVideoPlayStart");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7793a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onVideoAdStartPlay(FunDrawVideoAd.this.mSid);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TTNativeExpressAd.ExpressVideoAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunDrawVideoAdInteractionListener f7795a;

        public c(FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener) {
            this.f7795a = funDrawVideoAdInteractionListener;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onClickRetry() {
            m.a("FunDrawVideoAd onClickRetry");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7795a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onClickRetry(FunDrawVideoAd.this.mSid);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onProgressUpdate(long j, long j2) {
            m.a("FunDrawVideoAd onProgressUpdate");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7795a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onProgressUpdate(FunDrawVideoAd.this.mSid, j, j2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onVideoAdComplete() {
            m.a("FunDrawVideoAd onVideoAdComplete");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7795a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onVideoAdComplete(FunDrawVideoAd.this.mSid);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onVideoAdContinuePlay() {
            m.a("FunDrawVideoAd onVideoAdContinuePlay");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7795a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onVideoAdContinuePlay(FunDrawVideoAd.this.mSid);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onVideoAdPaused() {
            m.a("FunDrawVideoAd onVideoAdPaused");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7795a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onVideoAdPaused(FunDrawVideoAd.this.mSid);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onVideoAdStartPlay() {
            m.a("FunDrawVideoAd onVideoAdStartPlay");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7795a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onVideoAdStartPlay(FunDrawVideoAd.this.mSid);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onVideoError(int i, int i2) {
            m.a("FunDrawVideoAd onVideoError errorCode: " + i + ", extraCode: " + i2);
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7795a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onVideoError(FunDrawVideoAd.this.mSid, i, i2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public void onVideoLoad() {
            m.a("FunDrawVideoAd onVideoLoad");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7795a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onVideoLoad(FunDrawVideoAd.this.mSid);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements TTNativeExpressAd.ExpressAdInteractionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunDrawVideoAdInteractionListener f7797a;

        public d(FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener) {
            this.f7797a = funDrawVideoAdInteractionListener;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i) {
            m.a("FunDrawVideoAd onAdClicked");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7797a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onAdClick(FunDrawVideoAd.this.mSid);
            }
            if (FunDrawVideoAd.this.mRippedCSJAd != null) {
                ((d.a) com.fun.ad.d.pOz).a(FunDrawVideoAd.this.mSid, FunAdType.CSJ_DRAW_VIDEO, FunDrawVideoAd.this.mAid, FunDrawVideoAd.this.mRippedCSJAd.appPackageName, FunDrawVideoAd.this.mRippedCSJAd.appLinkUrl);
                return;
            }
            ((d.a) com.fun.ad.d.pOz).a(FunDrawVideoAd.this.mSid, FunAdType.CSJ_DRAW_VIDEO, FunDrawVideoAd.this.mAid, (String) null, (String) null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i) {
            m.a("FunDrawVideoAd onAdShow");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7797a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onAdShow(FunDrawVideoAd.this.mSid);
            }
            ((d.a) com.fun.ad.d.pOz).d(FunDrawVideoAd.this.mSid, FunAdType.CSJ_DRAW_VIDEO, FunDrawVideoAd.this.mAid);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i) {
            m.a("FunDrawVideoAd onRenderFail");
            FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener = this.f7797a;
            if (funDrawVideoAdInteractionListener != null) {
                funDrawVideoAdInteractionListener.onAdError(str, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f, float f2) {
            m.a("FunDrawVideoAd onRenderSuccess");
        }
    }

    public FunDrawVideoAd() {
    }

    public FunDrawVideoAd(String str, String str2, TTNativeExpressAd tTNativeExpressAd) {
        this.mSid = str;
        this.mAid = str2;
        this.mTTNativeExpressAd = tTNativeExpressAd;
        tTNativeExpressAd.setExpressInteractionListener(new a());
        this.mTTNativeExpressAd.render();
    }

    public FunDrawVideoAd(String str, String str2, KsDrawAd ksDrawAd) {
        this.mSid = str;
        this.mAid = str2;
        this.mKsDrawAd = ksDrawAd;
    }

    private void ripCsjAd() {
        if (this.mRippedCSJAd == null) {
            this.mRippedCSJAd = AdRipper.getRippedCSJAd(this.mTTNativeExpressAd, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ripKsAd() {
        if (this.mRippedKSAd == null) {
            this.mRippedKSAd = AdRipper.getRippedKSDrawAd(this.mKsDrawAd, false);
        }
    }

    private void showCJS(FunAdView funAdView, FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener) {
        this.mTTNativeExpressAd.setCanInterruptVideoPlay(true);
        this.mTTNativeExpressAd.setVideoAdListener(new c(funDrawVideoAdInteractionListener));
        this.mTTNativeExpressAd.setExpressInteractionListener(new d(funDrawVideoAdInteractionListener));
        if (this.mTTNativeExpressAdRenderFailed) {
            this.mTTNativeExpressAd.render();
        }
        View expressAdView = this.mTTNativeExpressAd.getExpressAdView();
        if (expressAdView != null && expressAdView.getParent() != null) {
            ((ViewGroup) expressAdView.getParent()).removeView(expressAdView);
        }
        if (expressAdView != null) {
            funAdView.removeAllViews();
            funAdView.addView(expressAdView);
        } else if (funDrawVideoAdInteractionListener != null) {
            funDrawVideoAdInteractionListener.onAdError(this.mSid, 0, "Custom error message: drawView is null");
        }
    }

    private void showKS(FunAdView funAdView, FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener) {
        this.mKsDrawAd.setAdInteractionListener(new b(funDrawVideoAdInteractionListener));
        View drawView = this.mKsDrawAd.getDrawView(funAdView.getContext());
        if (drawView != null && drawView.getParent() != null) {
            ((ViewGroup) drawView.getParent()).removeView(drawView);
        }
        if (drawView != null) {
            funAdView.removeAllViews();
            funAdView.addView(drawView);
        } else if (funDrawVideoAdInteractionListener != null) {
            funDrawVideoAdInteractionListener.onAdError(this.mSid, 0, "Custom error message: drawView is null");
        }
    }

    public void destroy(Context context) {
        TTNativeExpressAd tTNativeExpressAd = this.mTTNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
            this.mTTNativeExpressAd = null;
            this.mRippedCSJAd = null;
        }
        if (this.mKsDrawAd != null) {
            this.mKsDrawAd = null;
            this.mRippedKSAd = null;
        }
    }

    public String getAdType() {
        if (this.mKsDrawAd != null) {
            return FunAdType.KS_DRAW_VIDEO;
        }
        if (this.mTTNativeExpressAd != null) {
            return FunAdType.CSJ_DRAW_VIDEO;
        }
        return null;
    }

    public FunRippedAd getDeepLinkAd() {
        if (this.mTTNativeExpressAd != null) {
            ripCsjAd();
            if (this.mRippedCSJAd == null) {
                return null;
            }
            FunRippedAd funRippedAd = new FunRippedAd();
            AdRipper.RippedCSJAd rippedCSJAd = this.mRippedCSJAd;
            funRippedAd.title = rippedCSJAd.title;
            funRippedAd.description = rippedCSJAd.description;
            funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedCSJAd.landingPageUrl);
            AdRipper.RippedCSJAd rippedCSJAd2 = this.mRippedCSJAd;
            funRippedAd.uniqueId = rippedCSJAd2.title;
            funRippedAd.appName = rippedCSJAd2.appName;
            funRippedAd.appPackageName = rippedCSJAd2.appPackageName;
            funRippedAd.appLinkUrl = rippedCSJAd2.appLinkUrl;
            funRippedAd.appMarketUrl = rippedCSJAd2.marketUrl;
            return funRippedAd;
        } else if (this.mKsDrawAd != null) {
            ripKsAd();
            if (this.mRippedKSAd != null) {
                FunRippedAd funRippedAd2 = new FunRippedAd();
                AdRipper.RippedKSAd rippedKSAd = this.mRippedKSAd;
                funRippedAd2.description = rippedKSAd.adDescription;
                funRippedAd2.isDeepLinkAd = !TextUtils.isEmpty(rippedKSAd.deeplinkUrl);
                AdRipper.RippedKSAd rippedKSAd2 = this.mRippedKSAd;
                funRippedAd2.uniqueId = rippedKSAd2.adDescription;
                funRippedAd2.appName = rippedKSAd2.appName;
                funRippedAd2.appPackageName = rippedKSAd2.appPackageName;
                funRippedAd2.appLinkUrl = rippedKSAd2.appDownloadUrl;
                funRippedAd2.appMarketUrl = rippedKSAd2.marketUrl;
                return funRippedAd2;
            }
            return null;
        } else {
            return null;
        }
    }

    public void show(@NonNull FunAdView funAdView, FunDrawVideoAdInteractionListener funDrawVideoAdInteractionListener) {
        if (this.mKsDrawAd != null) {
            showKS(funAdView, funDrawVideoAdInteractionListener);
        } else if (this.mTTNativeExpressAd != null) {
            showCJS(funAdView, funDrawVideoAdInteractionListener);
        }
    }
}
