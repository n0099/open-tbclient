package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.fun.ad.au;
import com.fun.ad.sdk.AdRipper;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.List;
/* loaded from: classes15.dex */
public class ao extends ac {
    public String g;
    public AdRipper.RippedKSAd pHX;
    public KsNativeAd pIb;

    /* loaded from: classes15.dex */
    public class b implements KsNativeAd.AdInteractionListener {
        public b() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            m.a("KSNativeAd open app download onAdClicked");
            ao aoVar = ao.this;
            w wVar = aoVar.pHV;
            if (wVar != null) {
                ((ag) wVar).a(aoVar.f8042a.f8059a);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onAdShow(KsNativeAd ksNativeAd) {
            m.a("KSNativeAd open app download onAdShow");
            ao aoVar = ao.this;
            w wVar = aoVar.pHV;
            if (wVar != null) {
                ((ag) wVar).c(aoVar.f8042a.f8059a);
            }
        }
    }

    public ao(au.a aVar) {
        super(aVar);
    }

    @Override // com.fun.ad.ac
    public void a() {
        super.a();
        this.pIb = null;
        this.pHX = null;
    }

    @Override // com.fun.ad.ac
    public FunRippedAd eBl() {
        KsNativeAd ksNativeAd = this.pIb;
        if (ksNativeAd == null) {
            return null;
        }
        if (this.pHX == null) {
            this.pHX = AdRipper.getRippedKSAd((Object) ksNativeAd, false);
        }
        FunRippedAd funRippedAd = new FunRippedAd();
        AdRipper.RippedKSAd rippedKSAd = this.pHX;
        funRippedAd.description = rippedKSAd.adDescription;
        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedKSAd.deeplinkUrl);
        AdRipper.RippedKSAd rippedKSAd2 = this.pHX;
        funRippedAd.uniqueId = rippedKSAd2.adDescription;
        funRippedAd.appName = rippedKSAd2.appName;
        funRippedAd.appPackageName = rippedKSAd2.appPackageName;
        funRippedAd.appLinkUrl = rippedKSAd2.appDownloadUrl;
        funRippedAd.appMarketUrl = rippedKSAd2.marketUrl;
        return funRippedAd;
    }

    @Override // com.fun.ad.ac
    public void a(Context context, FunAdSlot funAdSlot, z zVar) {
        super.a(context.getApplicationContext(), funAdSlot, zVar);
        this.g = funAdSlot.getSid();
        if (!this.f8043b) {
            this.f8043b = true;
            KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(Long.parseLong(this.f8042a.f8059a)).adNum(1).build(), new a());
            z zVar2 = this.pHU;
            if (zVar2 != null) {
                ((ad) zVar2).a(this.f8042a.f8059a);
            }
        }
    }

    @Override // com.fun.ad.ac
    public void a(Activity activity, FunAdView funAdView, w wVar) {
        int i;
        super.a(activity, funAdView, wVar);
        if (this.pIb == null) {
            w wVar2 = this.pHV;
            if (wVar2 != null) {
                ((ag) wVar2).a(this.f8042a.f8059a, 0, "Custom error message: mKsNativeAd is null show");
                return;
            }
            return;
        }
        b bVar = new b();
        m.a("KSNativeAd show materialType: " + this.pIb.getMaterialType());
        switch (this.pIb.getMaterialType()) {
            case 0:
                i = 0;
                break;
            case 1:
                int interactionType = this.pIb.getInteractionType();
                if (interactionType == 1) {
                    i = R.layout.ks_ad_native_video_app_download_view;
                    break;
                } else if (interactionType == 2) {
                    i = R.layout.ks_ad_native_video_h5_open_view;
                    break;
                } else {
                    i = 0;
                    break;
                }
            case 2:
                int interactionType2 = this.pIb.getInteractionType();
                if (interactionType2 == 1) {
                    i = R.layout.ks_ad_native_single_img_app_download_view;
                    break;
                } else if (interactionType2 == 2) {
                    i = R.layout.ks_ad_native_single_img_h5_open_view;
                    break;
                } else {
                    i = 0;
                    break;
                }
            case 3:
                int interactionType3 = this.pIb.getInteractionType();
                if (interactionType3 == 1) {
                    i = R.layout.ks_ad_native_group_img_app_download_view;
                    break;
                } else if (interactionType3 == 2) {
                    i = R.layout.ks_ad_native_group_img_h5_open_view;
                    break;
                } else {
                    i = 0;
                    break;
                }
            default:
                return;
        }
        if (i != 0) {
            o1 o1Var = (o1) LayoutInflater.from(activity).inflate(i, (ViewGroup) funAdView, false);
            funAdView.removeAllViews();
            funAdView.addView(o1Var);
            m.a("KSNativeAdLoader show KSNativeAdView: " + o1Var);
            o1Var.a(activity, this.g, this.f8042a.f8059a, this.pIb, bVar);
        }
    }

    /* loaded from: classes15.dex */
    public class a implements KsLoadManager.NativeAdListener {
        public a() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i, String str) {
            m.a("KSNativeAd onError code: " + i + ", message: " + str);
            ao aoVar = ao.this;
            aoVar.f8043b = false;
            z zVar = aoVar.pHU;
            if (zVar != null) {
                ((ad) zVar).a(aoVar.f8042a.f8059a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            m.a("KSNativeAd onNativeAdLoad");
            ao.this.f8043b = false;
            if (list != null && !list.isEmpty()) {
                ao.this.pIb = list.get(0);
                m.a("KSNativeAd onNativeAdLoad materialType: " + ao.this.pIb.getMaterialType());
                ao aoVar = ao.this;
                z zVar = aoVar.pHU;
                if (zVar != null) {
                    ((ad) zVar).b(aoVar.f8042a.f8059a);
                }
                AdRipper.ripKS(ao.this.pIb);
                return;
            }
            m.a("KSNativeAd onNativeAdLoad error: adList is null or empty");
        }
    }
}
