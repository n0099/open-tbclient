package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fun.ad.au;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.qq.e.ads.nativ.express2.NativeExpressAD2;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.util.AdError;
import java.util.List;
/* loaded from: classes6.dex */
public class av extends an {
    public NativeExpressADData2 pPU;

    public av(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.an
    public void a() {
        super.a();
        NativeExpressADData2 nativeExpressADData2 = this.pPU;
        if (nativeExpressADData2 != null) {
            nativeExpressADData2.destroy();
            this.pPU = null;
        }
    }

    @Override // com.fun.ad.an
    public FunRippedAd eAx() {
        return null;
    }

    /* loaded from: classes6.dex */
    public class a implements NativeExpressAD2.AdLoadListener {
        public a() {
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            av.this.f7755b = false;
            m.a("GDTNativeExpressAd2 onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg());
            av avVar = av.this;
            ak akVar = avVar.pPM;
            if (akVar != null) {
                ((x) akVar).a(avVar.f7754a.f7762a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.nativ.express2.NativeExpressAD2.AdLoadListener
        public void onLoadSuccess(List<NativeExpressADData2> list) {
            m.a("GDTNativeExpressAd2 onADLoaded");
            if (list != null && !list.isEmpty()) {
                av.this.pPU = list.get(0);
                av avVar = av.this;
                avVar.pPU.setAdEventListener(new ay(avVar));
                avVar.pPU.setMediaListener(new bb(avVar));
                avVar.pPU.render();
                return;
            }
            av avVar2 = av.this;
            avVar2.f7755b = false;
            ak akVar = avVar2.pPM;
            if (akVar != null) {
                ((x) akVar).a(avVar2.f7754a.f7762a, 0, "Custom error message: adList is epmty");
            }
            m.a("GDTNativeExpressAd2 onADLoaded error: adList is null or empty");
        }
    }

    @Override // com.fun.ad.an
    public void a(Context context, FunAdSlot funAdSlot, ak akVar) {
        int expressWidth;
        super.a(context, funAdSlot, akVar);
        if (!this.f7755b) {
            this.f7755b = true;
            NativeExpressAD2 nativeExpressAD2 = new NativeExpressAD2(context, this.f7754a.f7762a, new a());
            if (funAdSlot.getExpressWidth() == 0) {
                expressWidth = this.f7754a.e;
            } else {
                expressWidth = funAdSlot.getExpressWidth();
            }
            nativeExpressAD2.setAdSize(expressWidth, 0);
            VideoOption2.Builder builder = new VideoOption2.Builder();
            builder.setAutoPlayPolicy(d.c ? VideoOption2.AutoPlayPolicy.ALWAYS : VideoOption2.AutoPlayPolicy.WIFI).setAutoPlayMuted(!d.f7778b).setDetailPageMuted(false).setMaxVideoDuration(0).setMinVideoDuration(0);
            nativeExpressAD2.setVideoOption2(builder.build());
            nativeExpressAD2.loadAd(1);
            ak akVar2 = this.pPM;
            if (akVar2 != null) {
                ((x) akVar2).a(this.f7754a.f7762a);
            }
        }
    }

    @Override // com.fun.ad.an
    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        super.a(activity, funAdView, ahVar);
        NativeExpressADData2 nativeExpressADData2 = this.pPU;
        if (nativeExpressADData2 == null) {
            ah ahVar2 = this.pPN;
            if (ahVar2 != null) {
                ((aa) ahVar2).a(this.f7754a.f7762a, 0, "Custom error message: mNativeExpressADData2 is null when show");
                return;
            }
            return;
        }
        View adView = nativeExpressADData2.getAdView();
        if (adView.getParent() != null) {
            ((ViewGroup) adView.getParent()).removeView(adView);
        }
        funAdView.removeAllViews();
        funAdView.addView(adView);
    }
}
