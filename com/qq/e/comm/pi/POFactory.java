package com.qq.e.comm.pi;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.ViewGroup;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.comm.adevent.ADListener;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface POFactory extends InnerPOFactory {
    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ void config(int i, String str);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ SVSD getAPKDownloadServiceDelegate(Service service);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ ACTD getActivityDelegate(String str, Activity activity);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ String getBuyerId();

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ UIADI2 getExpressInterstitialADDelegate(Context context, String str, String str2, ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ RVADI2 getExpressRewardVideoADDelegate(Context context, String str, String str2, ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ NUADI getNativeAdManagerDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ NEIADI getNativeExpressADDelegate2(Context context, String str, String str2, ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ NEADVI getNativeExpressADView(NEADI neadi, NEADVI neadvi, NativeExpressADData2 nativeExpressADData2, Context context, ViewGroup viewGroup, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, Object> hashMap);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ NSPVI getNativeSplashAdView(Context context, String str, String str2, String str3);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ RVADI getRewardVideoADDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, UnifiedBannerADListener unifiedBannerADListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, String str3, UnifiedInterstitialADListener unifiedInterstitialADListener);

    @Override // com.qq.e.comm.pi.InnerPOFactory
    /* synthetic */ int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener);
}
