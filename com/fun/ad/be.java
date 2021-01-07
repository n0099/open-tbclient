package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.util.AdError;
import java.util.List;
/* loaded from: classes15.dex */
public class be extends an {
    public NativeExpressADView pJY;

    /* loaded from: classes15.dex */
    public class a implements NativeExpressAD.NativeExpressADListener {
        public a() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onADClicked");
            be beVar = be.this;
            ah ahVar = beVar.pJI;
            if (ahVar != null) {
                ((aa) ahVar).c(beVar.f8052a.f8060a);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADCloseOverlay(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onADCloseOverlay");
            ah ahVar = be.this.pJI;
            if (ahVar != null) {
                aa aaVar = (aa) ahVar;
                m.a("GDTAdLoaderFactory onADCloseOverlay");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onADClosed");
            be beVar = be.this;
            ah ahVar = beVar.pJI;
            if (ahVar != null) {
                ((aa) ahVar).a(beVar.f8052a.f8060a);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onADExposure");
            be beVar = be.this;
            ah ahVar = beVar.pJI;
            if (ahVar != null) {
                ((aa) ahVar).b(beVar.f8052a.f8060a);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onADLeftApplication");
            ah ahVar = be.this.pJI;
            if (ahVar != null) {
                if (((aa) ahVar) == null) {
                    throw null;
                }
                m.a("GDTAdLoaderFactory onADLeftApplication");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            m.a("GDTNativeExpressAd onADLoaded");
            if (list != null && !list.isEmpty()) {
                NativeExpressADView nativeExpressADView = list.get(0);
                AdRipper.ripGDTNativeExpress(nativeExpressADView);
                nativeExpressADView.render();
                return;
            }
            be beVar = be.this;
            beVar.f8053b = false;
            ak akVar = beVar.pJH;
            if (akVar != null) {
                ((x) akVar).a(beVar.f8052a.f8060a, 0, "Custom error message: adList is epmty");
            }
            m.a("GDTNativeExpressAd onADLoaded error: adList is null or empty");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADOpenOverlay(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onADOpenOverlay");
            ah ahVar = be.this.pJI;
            if (ahVar != null) {
                aa aaVar = (aa) ahVar;
                m.a("GDTAdLoaderFactory onADOpenOverlay");
            }
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            be.this.f8053b = false;
            m.a("GDTNativeExpressAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg());
            be beVar = be.this;
            ak akVar = beVar.pJH;
            if (akVar != null) {
                ((x) akVar).a(beVar.f8052a.f8060a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            be.this.f8053b = false;
            m.a("GDTNativeExpressAd onRenderFail");
            be beVar = be.this;
            ak akVar = beVar.pJH;
            if (akVar != null) {
                ((x) akVar).a(beVar.f8052a.f8060a, 0, "Custom error message: render fail");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onRenderSuccess");
            be beVar = be.this;
            beVar.f8053b = false;
            beVar.pJY = nativeExpressADView;
            m.a("GDTNativeExpressAd onADLoaded adPatternType: " + nativeExpressADView.getBoundData().getAdPatternType());
            be beVar2 = be.this;
            ak akVar = beVar2.pJH;
            if (akVar != null) {
                ((x) akVar).b(beVar2.f8052a.f8060a);
            }
        }
    }

    /* loaded from: classes15.dex */
    public class b implements NativeExpressMediaListener {
        public b(be beVar) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoCached(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onVideoCached");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoComplete(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onVideoComplete");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
            m.a("GDTNativeExpressAd onVideoError");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoInit(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onVideoInit");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoLoading(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onVideoLoading");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onVideoPageClose");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onVideoPageOpen");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoPause(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onVideoPause");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoReady(NativeExpressADView nativeExpressADView, long j) {
            m.a("GDTNativeExpressAd onVideoReady");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoStart(NativeExpressADView nativeExpressADView) {
            m.a("GDTNativeExpressAd onVideoStart");
        }
    }

    public be(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.an
    public void a() {
        super.a();
        NativeExpressADView nativeExpressADView = this.pJY;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
            this.pJY = null;
        }
    }

    @Override // com.fun.ad.an
    public FunRippedAd eBP() {
        AdRipper.RippedGDTAd rippedGDTNativeExpressAd;
        NativeExpressADView nativeExpressADView = this.pJY;
        if (nativeExpressADView == null || (rippedGDTNativeExpressAd = AdRipper.getRippedGDTNativeExpressAd(nativeExpressADView, false)) == null) {
            return null;
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        funRippedAd.title = rippedGDTNativeExpressAd.title;
        funRippedAd.description = rippedGDTNativeExpressAd.description;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedGDTNativeExpressAd.customized_invoke_url);
        funRippedAd.uniqueId = rippedGDTNativeExpressAd.title;
        funRippedAd.appName = rippedGDTNativeExpressAd.appName;
        funRippedAd.appPackageName = rippedGDTNativeExpressAd.appPackageName;
        funRippedAd.appLinkUrl = rippedGDTNativeExpressAd.appLinkUrl;
        return funRippedAd;
    }

    @Override // com.fun.ad.an
    public void a(Context context, FunAdSlot funAdSlot, ak akVar) {
        super.a(context, funAdSlot, akVar);
        if (!this.f8053b) {
            this.f8053b = true;
            a aVar = new a();
            if (!(context instanceof Activity)) {
                m.a("GDTNativeExpressAdLoader context is not activity");
                this.f8053b = false;
                ak akVar2 = this.pJH;
                if (akVar2 != null) {
                    ((x) akVar2).a(this.f8052a.f8060a, 0, "Custom error message: context is not activity");
                    return;
                }
                return;
            }
            NativeExpressAD nativeExpressAD = new NativeExpressAD((Activity) context, new ADSize(-1, -2), this.f8052a.f8060a, aVar);
            nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(d.c ? 1 : 0).setAutoPlayMuted(!d.f8076b).setDetailPageMuted(false).setNeedCoverImage(true).setNeedProgressBar(true).setEnableDetailPage(false).setEnableUserControl(false).build());
            nativeExpressAD.setMinVideoDuration(0);
            nativeExpressAD.setMaxVideoDuration(0);
            nativeExpressAD.setVideoPlayPolicy(1);
            nativeExpressAD.loadAD(1);
            ak akVar3 = this.pJH;
            if (akVar3 != null) {
                ((x) akVar3).a(this.f8052a.f8060a);
            }
        }
    }

    @Override // com.fun.ad.an
    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        super.a(activity, funAdView, ahVar);
        NativeExpressADView nativeExpressADView = this.pJY;
        if (nativeExpressADView == null) {
            ah ahVar2 = this.pJI;
            if (ahVar2 != null) {
                ((aa) ahVar2).a(this.f8052a.f8060a, 0, "Custom error message: mNativeExpressADView is null when show");
                return;
            }
            return;
        }
        if (nativeExpressADView.getBoundData().getAdPatternType() == 2) {
            this.pJY.setMediaListener(new b(this));
        }
        if (this.pJY.getParent() != null) {
            ((ViewGroup) this.pJY.getParent()).removeView(this.pJY);
        }
        funAdView.removeAllViews();
        funAdView.addView(this.pJY);
    }
}
