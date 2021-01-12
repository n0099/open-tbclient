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
/* loaded from: classes14.dex */
public class av extends an {
    public NativeExpressADData2 pFo;

    public av(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.an
    public void a() {
        super.a();
        NativeExpressADData2 nativeExpressADData2 = this.pFo;
        if (nativeExpressADData2 != null) {
            nativeExpressADData2.destroy();
            this.pFo = null;
        }
    }

    @Override // com.fun.ad.an
    public FunRippedAd exX() {
        return null;
    }

    /* loaded from: classes14.dex */
    public class a implements NativeExpressAD2.AdLoadListener {
        public a() {
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            av.this.f7753b = false;
            m.a("GDTNativeExpressAd2 onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg());
            av avVar = av.this;
            ak akVar = avVar.pFg;
            if (akVar != null) {
                ((x) akVar).a(avVar.f7752a.f7760a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.nativ.express2.NativeExpressAD2.AdLoadListener
        public void onLoadSuccess(List<NativeExpressADData2> list) {
            m.a("GDTNativeExpressAd2 onADLoaded");
            if (list != null && !list.isEmpty()) {
                av.this.pFo = list.get(0);
                av avVar = av.this;
                avVar.pFo.setAdEventListener(new ay(avVar));
                avVar.pFo.setMediaListener(new bb(avVar));
                avVar.pFo.render();
                return;
            }
            av avVar2 = av.this;
            avVar2.f7753b = false;
            ak akVar = avVar2.pFg;
            if (akVar != null) {
                ((x) akVar).a(avVar2.f7752a.f7760a, 0, "Custom error message: adList is epmty");
            }
            m.a("GDTNativeExpressAd2 onADLoaded error: adList is null or empty");
        }
    }

    @Override // com.fun.ad.an
    public void a(Context context, FunAdSlot funAdSlot, ak akVar) {
        int expressWidth;
        super.a(context, funAdSlot, akVar);
        if (!this.f7753b) {
            this.f7753b = true;
            NativeExpressAD2 nativeExpressAD2 = new NativeExpressAD2(context, this.f7752a.f7760a, new a());
            if (funAdSlot.getExpressWidth() == 0) {
                expressWidth = this.f7752a.e;
            } else {
                expressWidth = funAdSlot.getExpressWidth();
            }
            nativeExpressAD2.setAdSize(expressWidth, 0);
            VideoOption2.Builder builder = new VideoOption2.Builder();
            builder.setAutoPlayPolicy(d.c ? VideoOption2.AutoPlayPolicy.ALWAYS : VideoOption2.AutoPlayPolicy.WIFI).setAutoPlayMuted(!d.f7776b).setDetailPageMuted(false).setMaxVideoDuration(0).setMinVideoDuration(0);
            nativeExpressAD2.setVideoOption2(builder.build());
            nativeExpressAD2.loadAd(1);
            ak akVar2 = this.pFg;
            if (akVar2 != null) {
                ((x) akVar2).a(this.f7752a.f7760a);
            }
        }
    }

    @Override // com.fun.ad.an
    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        super.a(activity, funAdView, ahVar);
        NativeExpressADData2 nativeExpressADData2 = this.pFo;
        if (nativeExpressADData2 == null) {
            ah ahVar2 = this.pFh;
            if (ahVar2 != null) {
                ((aa) ahVar2).a(this.f7752a.f7760a, 0, "Custom error message: mNativeExpressADData2 is null when show");
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
