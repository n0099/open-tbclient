package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.fun.ad.sdk.R;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.List;
/* loaded from: classes6.dex */
public class bh extends an {
    public NativeUnifiedADData pPF;

    public bh(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.an
    public void a() {
        super.a();
        NativeUnifiedADData nativeUnifiedADData = this.pPF;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
            this.pPF = null;
        }
    }

    @Override // com.fun.ad.an
    public FunRippedAd eAp() {
        AdRipper.RippedGDTAd rippedGDTNativeUnifiedAd;
        NativeUnifiedADData nativeUnifiedADData = this.pPF;
        if (nativeUnifiedADData == null || (rippedGDTNativeUnifiedAd = AdRipper.getRippedGDTNativeUnifiedAd(nativeUnifiedADData, false)) == null) {
            return null;
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        funRippedAd.title = rippedGDTNativeUnifiedAd.title;
        funRippedAd.description = rippedGDTNativeUnifiedAd.description;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedGDTNativeUnifiedAd.customized_invoke_url);
        funRippedAd.uniqueId = rippedGDTNativeUnifiedAd.title;
        funRippedAd.appName = rippedGDTNativeUnifiedAd.appName;
        funRippedAd.appPackageName = rippedGDTNativeUnifiedAd.appPackageName;
        funRippedAd.appLinkUrl = rippedGDTNativeUnifiedAd.appLinkUrl;
        return funRippedAd;
    }

    @Override // com.fun.ad.an
    public void a(Context context, FunAdSlot funAdSlot, ak akVar) {
        super.a(context.getApplicationContext(), funAdSlot, akVar);
        if (!this.f7755b) {
            this.f7755b = true;
            NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(context.getApplicationContext(), this.f7754a.f7762a, new a());
            nativeUnifiedAD.setMinVideoDuration(0);
            nativeUnifiedAD.setMaxVideoDuration(0);
            nativeUnifiedAD.setVideoPlayPolicy(1);
            nativeUnifiedAD.setVideoADContainerRender(1);
            nativeUnifiedAD.loadData(1);
            ak akVar2 = this.pPm;
            if (akVar2 != null) {
                ((x) akVar2).a(this.f7754a.f7762a);
            }
        }
    }

    @Override // com.fun.ad.an
    public void a(Activity activity, FunAdView funAdView, ah ahVar) {
        int i;
        super.a(activity, funAdView, ahVar);
        if (this.pPF == null) {
            ah ahVar2 = this.pPn;
            if (ahVar2 != null) {
                ((aa) ahVar2).a(this.f7754a.f7762a, 0, "Custom error message: mNativeUnifiedADData is null when show");
                return;
            }
            return;
        }
        m.a("GDTNativeUnifiedAd AdPatternType: " + this.pPF.getAdPatternType());
        switch (this.pPF.getAdPatternType()) {
            case 1:
                i = R.layout.gdt_ad_native_unified_img2_view;
                break;
            case 2:
                i = R.layout.gdt_ad_native_unified_video_view;
                break;
            case 3:
                if (this.pPF.getImgList().size() == 3) {
                    i = R.layout.gdt_ad_native_unified_img3_view;
                    break;
                }
            case 4:
                i = R.layout.gdt_ad_native_unified_img_view;
                break;
            default:
                return;
        }
        v0 v0Var = (v0) LayoutInflater.from(activity).inflate(i, (ViewGroup) funAdView, false);
        funAdView.removeAllViews();
        funAdView.addView(v0Var);
        v0Var.a(activity, this.f7754a, this.pPF, ahVar);
    }

    /* loaded from: classes6.dex */
    public class a implements NativeADUnifiedListener {
        public a() {
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            bh.this.f7755b = false;
            m.a("GDTNativeUnifiedAd onError code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg());
            bh bhVar = bh.this;
            ak akVar = bhVar.pPm;
            if (akVar != null) {
                ((x) akVar).a(bhVar.f7754a.f7762a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            m.a("GDTNativeUnifiedAd onADLoaded");
            bh.this.f7755b = false;
            if (list != null && !list.isEmpty()) {
                bh.this.pPF = list.get(0);
                m.a("GDTNativeUnifiedAd onADLoaded adPatternType: " + bh.this.pPF.getAdPatternType());
                bh bhVar = bh.this;
                ak akVar = bhVar.pPm;
                if (akVar != null) {
                    ((x) akVar).b(bhVar.f7754a.f7762a);
                }
                AdRipper.ripGDTNativeUnified(bh.this.pPF);
                return;
            }
            m.a("GDTNativeUnifiedAd onADLoaded error: adList is null or empty");
        }
    }
}
