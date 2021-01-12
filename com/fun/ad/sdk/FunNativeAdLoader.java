package com.fun.ad.sdk;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.m;
import com.fun.ad.sdk.AdRipper;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import com.win.opensdk.PBError;
import com.win.opensdk.PBNative;
import com.win.opensdk.PBNativeListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class FunNativeAdLoader {
    public boolean mIsLoading = false;
    public List<au.a> mLoopAdIds;
    public au mSlotId;
    public WeakReference<Activity> weakReferenceActivity;

    /* loaded from: classes14.dex */
    public class a implements PBNativeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7811a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ au.a f7812b;
        public final /* synthetic */ PBNative c;
        public final /* synthetic */ FunNativeAdLoadListener d;

        public a(String str, au.a aVar, PBNative pBNative, FunNativeAdLoadListener funNativeAdLoadListener) {
            this.f7811a = str;
            this.f7812b = aVar;
            this.c = pBNative;
            this.d = funNativeAdLoadListener;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
        }

        @Override // com.win.opensdk.PBNativeListener
        public void onDisplayed() {
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            m.a("JYNativeAd onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg());
            ((d.a) com.fun.ad.d.pEt).a(this.f7811a, FunAdType.JY_NATIVE, this.f7812b.f7760a, pBError.getCode(), pBError.getMsg());
            if (!FunNativeAdLoader.this.mLoopAdIds.isEmpty()) {
                FunNativeAdLoader.this.doLoad(this.f7811a, this.d);
                return;
            }
            FunNativeAdLoader.this.mIsLoading = false;
            FunNativeAdLoadListener funNativeAdLoadListener = this.d;
            if (funNativeAdLoadListener != null) {
                funNativeAdLoadListener.onError(this.f7811a, pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new FunNativeAd(this.f7811a, this.f7812b.f7760a, this.c, (FunRippedAd) null));
            FunNativeAdLoader.this.mIsLoading = false;
            FunNativeAdLoadListener funNativeAdLoadListener = this.d;
            if (funNativeAdLoadListener != null) {
                funNativeAdLoadListener.onNativeAdLoaded(this.f7811a, arrayList);
            }
            ((d.a) com.fun.ad.d.pEt).c(this.f7811a, FunAdType.JY_NATIVE, this.f7812b.f7760a);
        }
    }

    public FunNativeAdLoader(au auVar) {
        this.mSlotId = auVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLoad(String str, FunNativeAdLoadListener funNativeAdLoadListener) {
        au.a remove = this.mLoopAdIds.remove(0);
        String str2 = remove.f7761b;
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != -1900686778) {
            if (hashCode != -1187931233) {
                if (hashCode != 425812868) {
                    if (hashCode == 1922685617 && str2.equals(FunAdType.CSJ_NATIVE)) {
                        c2 = 0;
                    }
                } else if (str2.equals(FunAdType.GDT_NATIVE_UNIFIED)) {
                    c2 = 2;
                }
            } else if (str2.equals(FunAdType.KS_NATIVE)) {
                c2 = 1;
            }
        } else if (str2.equals(FunAdType.JY_NATIVE)) {
            c2 = 3;
        }
        switch (c2) {
            case 0:
                doLoadCsjNativeAd(str, remove, funNativeAdLoadListener);
                return;
            case 1:
                doLoadKsNativeAd(str, remove, funNativeAdLoadListener);
                return;
            case 2:
                doLoadGdtNativeUnifiedAd(str, remove, funNativeAdLoadListener);
                return;
            case 3:
                doLoadJyNativeAd(str, remove, funNativeAdLoadListener);
                return;
            default:
                return;
        }
    }

    private void doLoadKsNativeAd(String str, au.a aVar, FunNativeAdLoadListener funNativeAdLoadListener) {
        KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(Long.parseLong(aVar.f7760a)).adNum(5).build(), new c(str, aVar, funNativeAdLoadListener));
        ((d.a) com.fun.ad.d.pEt).b(str, FunAdType.KS_NATIVE, aVar.f7760a);
    }

    private Activity getActivity() {
        WeakReference<Activity> weakReference = this.weakReferenceActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void load(FunAdSlot funAdSlot, FunNativeAdLoadListener funNativeAdLoadListener) {
        List<au.a> list = this.mSlotId.c;
        if (list != null && !list.isEmpty()) {
            if (this.mIsLoading) {
                return;
            }
            this.mIsLoading = true;
            this.mLoopAdIds = new ArrayList();
            for (au.a aVar : list) {
                String str = aVar.f7761b;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1900686778) {
                    if (hashCode != -1187931233) {
                        if (hashCode != 425812868) {
                            if (hashCode == 1922685617 && str.equals(FunAdType.CSJ_NATIVE)) {
                                c2 = 0;
                            }
                        } else if (str.equals(FunAdType.GDT_NATIVE_UNIFIED)) {
                            c2 = 2;
                        }
                    } else if (str.equals(FunAdType.KS_NATIVE)) {
                        c2 = 1;
                    }
                } else if (str.equals(FunAdType.JY_NATIVE)) {
                    c2 = 3;
                }
                switch (c2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        this.mLoopAdIds.add(aVar);
                        break;
                }
            }
            if (!this.mLoopAdIds.isEmpty()) {
                doLoad(funAdSlot.getSid(), funNativeAdLoadListener);
                return;
            }
            this.mIsLoading = false;
            if (funNativeAdLoadListener != null) {
                funNativeAdLoadListener.onError(funAdSlot.getSid(), 0, "自定义错误：无自渲染广告类型");
                return;
            }
            return;
        }
        Log.e("FunAdSdk", "FunNativeAdLoader load广告位：" + this.mSlotId.f7758a + "未配置任何类型的广告ID");
    }

    public void setActivity(Activity activity) {
        this.weakReferenceActivity = new WeakReference<>(activity);
    }

    private void doLoadGdtNativeUnifiedAd(String str, au.a aVar, FunNativeAdLoadListener funNativeAdLoadListener) {
        Activity activity = getActivity();
        if (activity == null) {
            if (funNativeAdLoadListener != null) {
                funNativeAdLoadListener.onError(str, 0, "Custom error message: activity is null");
                return;
            }
            return;
        }
        NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(activity, aVar.f7760a, new b(str, aVar, funNativeAdLoadListener));
        nativeUnifiedAD.setMinVideoDuration(0);
        nativeUnifiedAD.setMaxVideoDuration(0);
        nativeUnifiedAD.setVideoPlayPolicy(1);
        nativeUnifiedAD.setVideoADContainerRender(1);
        nativeUnifiedAD.loadData(5);
        ((d.a) com.fun.ad.d.pEt).b(str, FunAdType.GDT_NATIVE_UNIFIED, aVar.f7760a);
    }

    private void doLoadJyNativeAd(String str, au.a aVar, FunNativeAdLoadListener funNativeAdLoadListener) {
        Activity activity = getActivity();
        if (activity == null) {
            if (funNativeAdLoadListener != null) {
                funNativeAdLoadListener.onError(str, 0, "Custom error message: activity is null");
                return;
            }
            return;
        }
        PBNative pBNative = new PBNative(activity.getApplicationContext(), aVar.f7760a);
        pBNative.setNativeListener(new a(str, aVar, pBNative, funNativeAdLoadListener));
        pBNative.load();
        ((d.a) com.fun.ad.d.pEt).b(str, FunAdType.JY_NATIVE, aVar.f7760a);
    }

    /* loaded from: classes14.dex */
    public class b implements NativeADUnifiedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7813a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ au.a f7814b;
        public final /* synthetic */ FunNativeAdLoadListener c;

        public b(String str, au.a aVar, FunNativeAdLoadListener funNativeAdLoadListener) {
            this.f7813a = str;
            this.f7814b = aVar;
            this.c = funNativeAdLoadListener;
        }

        @Override // com.qq.e.ads.AbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            m.a("GDTNativeUnified onNoAD code: " + adError.getErrorCode() + ", message: " + adError.getErrorMsg());
            ((d.a) com.fun.ad.d.pEt).a(this.f7813a, FunAdType.GDT_NATIVE_UNIFIED, this.f7814b.f7760a, adError.getErrorCode(), adError.getErrorMsg());
            if (!FunNativeAdLoader.this.mLoopAdIds.isEmpty()) {
                FunNativeAdLoader.this.doLoad(this.f7813a, this.c);
                return;
            }
            FunNativeAdLoader.this.mIsLoading = false;
            FunNativeAdLoadListener funNativeAdLoadListener = this.c;
            if (funNativeAdLoadListener != null) {
                funNativeAdLoadListener.onError(this.f7813a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    AdRipper.ripGDTNativeUnified(nativeUnifiedADData);
                    AdRipper.RippedGDTAd rippedGDTNativeUnifiedAd = AdRipper.getRippedGDTNativeUnifiedAd(nativeUnifiedADData, false);
                    if (rippedGDTNativeUnifiedAd != null) {
                        FunRippedAd funRippedAd = new FunRippedAd();
                        funRippedAd.title = rippedGDTNativeUnifiedAd.title;
                        funRippedAd.description = rippedGDTNativeUnifiedAd.description;
                        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedGDTNativeUnifiedAd.customized_invoke_url);
                        funRippedAd.uniqueId = rippedGDTNativeUnifiedAd.title;
                        funRippedAd.appName = rippedGDTNativeUnifiedAd.appName;
                        funRippedAd.appPackageName = rippedGDTNativeUnifiedAd.appPackageName;
                        funRippedAd.appLinkUrl = rippedGDTNativeUnifiedAd.appLinkUrl;
                        arrayList.add(new FunNativeAd(this.f7813a, this.f7814b.f7760a, nativeUnifiedADData, funRippedAd));
                    } else {
                        arrayList.add(new FunNativeAd(this.f7813a, this.f7814b.f7760a, nativeUnifiedADData, (FunRippedAd) null));
                    }
                }
                FunNativeAdLoader.this.mIsLoading = false;
                FunNativeAdLoadListener funNativeAdLoadListener = this.c;
                if (funNativeAdLoadListener != null) {
                    funNativeAdLoadListener.onNativeAdLoaded(this.f7813a, arrayList);
                }
                ((d.a) com.fun.ad.d.pEt).c(this.f7813a, FunAdType.GDT_NATIVE_UNIFIED, this.f7814b.f7760a);
                return;
            }
            m.a("GDTNativeUnified onADLoaded error: adList is null or empty");
            ((d.a) com.fun.ad.d.pEt).a(this.f7813a, FunAdType.GDT_NATIVE_UNIFIED, this.f7814b.f7760a, 0, "Custom error message: adList is null");
            if (!FunNativeAdLoader.this.mLoopAdIds.isEmpty()) {
                FunNativeAdLoader.this.doLoad(this.f7813a, this.c);
                return;
            }
            FunNativeAdLoader.this.mIsLoading = false;
            FunNativeAdLoadListener funNativeAdLoadListener2 = this.c;
            if (funNativeAdLoadListener2 != null) {
                funNativeAdLoadListener2.onError(this.f7813a, 0, "自定义错误：优量汇gdt无填充");
            }
        }
    }

    /* loaded from: classes14.dex */
    public class c implements KsLoadManager.NativeAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7815a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ au.a f7816b;
        public final /* synthetic */ FunNativeAdLoadListener c;

        public c(String str, au.a aVar, FunNativeAdLoadListener funNativeAdLoadListener) {
            this.f7815a = str;
            this.f7816b = aVar;
            this.c = funNativeAdLoadListener;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i, String str) {
            m.a("KSNativeAd onError code: " + i + ", message: " + str);
            ((d.a) com.fun.ad.d.pEt).a(this.f7815a, FunAdType.KS_NATIVE, this.f7816b.f7760a, i, str);
            if (!FunNativeAdLoader.this.mLoopAdIds.isEmpty()) {
                FunNativeAdLoader.this.doLoad(this.f7815a, this.c);
                return;
            }
            FunNativeAdLoader.this.mIsLoading = false;
            FunNativeAdLoadListener funNativeAdLoadListener = this.c;
            if (funNativeAdLoadListener != null) {
                funNativeAdLoadListener.onError(this.f7815a, i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            m.a("KSNativeAd onNativeAdLoad");
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (KsNativeAd ksNativeAd : list) {
                    AdRipper.ripKS(ksNativeAd);
                    AdRipper.RippedKSAd rippedKSAd = AdRipper.getRippedKSAd((Object) ksNativeAd, false);
                    if (rippedKSAd != null) {
                        FunRippedAd funRippedAd = new FunRippedAd();
                        funRippedAd.description = rippedKSAd.adDescription;
                        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedKSAd.deeplinkUrl);
                        funRippedAd.uniqueId = rippedKSAd.adDescription;
                        funRippedAd.appName = rippedKSAd.appName;
                        funRippedAd.appPackageName = rippedKSAd.appPackageName;
                        funRippedAd.appLinkUrl = rippedKSAd.appDownloadUrl;
                        funRippedAd.appMarketUrl = rippedKSAd.marketUrl;
                        arrayList.add(new FunNativeAd(this.f7815a, this.f7816b.f7760a, ksNativeAd, funRippedAd));
                    } else {
                        arrayList.add(new FunNativeAd(this.f7815a, this.f7816b.f7760a, ksNativeAd, (FunRippedAd) null));
                    }
                }
                FunNativeAdLoader.this.mIsLoading = false;
                FunNativeAdLoadListener funNativeAdLoadListener = this.c;
                if (funNativeAdLoadListener != null) {
                    funNativeAdLoadListener.onNativeAdLoaded(this.f7815a, arrayList);
                }
                ((d.a) com.fun.ad.d.pEt).c(this.f7815a, FunAdType.KS_NATIVE, this.f7816b.f7760a);
                return;
            }
            ((d.a) com.fun.ad.d.pEt).a(this.f7815a, FunAdType.KS_NATIVE, this.f7816b.f7760a, 0, "Custom error message: adList is null");
            if (FunNativeAdLoader.this.mLoopAdIds.isEmpty()) {
                FunNativeAdLoader.this.mIsLoading = false;
                FunNativeAdLoadListener funNativeAdLoadListener2 = this.c;
                if (funNativeAdLoadListener2 != null) {
                    funNativeAdLoadListener2.onError(this.f7815a, 0, "自定义错误：快手ks无填充");
                }
            } else {
                FunNativeAdLoader.this.doLoad(this.f7815a, this.c);
            }
            m.a("KSNativeAd onNativeAdLoad error: adList is null or empty");
        }
    }

    /* loaded from: classes14.dex */
    public class d implements TTAdNative.FeedAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7817a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ au.a f7818b;
        public final /* synthetic */ FunNativeAdLoadListener c;

        public d(String str, au.a aVar, FunNativeAdLoadListener funNativeAdLoadListener) {
            this.f7817a = str;
            this.f7818b = aVar;
            this.c = funNativeAdLoadListener;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJNative onError code: " + i + ", message: " + str);
            ((d.a) com.fun.ad.d.pEt).a(this.f7817a, FunAdType.CSJ_NATIVE, this.f7818b.f7760a, i, str);
            if (!FunNativeAdLoader.this.mLoopAdIds.isEmpty()) {
                FunNativeAdLoader.this.doLoad(this.f7817a, this.c);
                return;
            }
            FunNativeAdLoader.this.mIsLoading = false;
            FunNativeAdLoadListener funNativeAdLoadListener = this.c;
            if (funNativeAdLoadListener != null) {
                funNativeAdLoadListener.onError(this.f7817a, i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            m.a("CSJNative onFeedAdLoad");
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (TTFeedAd tTFeedAd : list) {
                    AdRipper.ripCSJ(tTFeedAd);
                    AdRipper.RippedCSJAd rippedCSJAd = AdRipper.getRippedCSJAd(tTFeedAd, false);
                    if (rippedCSJAd != null) {
                        FunRippedAd funRippedAd = new FunRippedAd();
                        funRippedAd.title = rippedCSJAd.title;
                        funRippedAd.description = rippedCSJAd.description;
                        funRippedAd.isDeepLinkAd = !TextUtils.isEmpty(rippedCSJAd.landingPageUrl);
                        funRippedAd.uniqueId = rippedCSJAd.title;
                        funRippedAd.appName = rippedCSJAd.appName;
                        funRippedAd.appPackageName = rippedCSJAd.appPackageName;
                        funRippedAd.appLinkUrl = rippedCSJAd.appLinkUrl;
                        funRippedAd.appMarketUrl = rippedCSJAd.marketUrl;
                        arrayList.add(new FunNativeAd(this.f7817a, this.f7818b.f7760a, tTFeedAd, funRippedAd));
                    } else {
                        arrayList.add(new FunNativeAd(this.f7817a, this.f7818b.f7760a, tTFeedAd, (FunRippedAd) null));
                    }
                }
                FunNativeAdLoader.this.mIsLoading = false;
                FunNativeAdLoadListener funNativeAdLoadListener = this.c;
                if (funNativeAdLoadListener != null) {
                    funNativeAdLoadListener.onNativeAdLoaded(this.f7817a, arrayList);
                }
                ((d.a) com.fun.ad.d.pEt).c(this.f7817a, FunAdType.CSJ_NATIVE, this.f7818b.f7760a);
                return;
            }
            ((d.a) com.fun.ad.d.pEt).a(this.f7817a, FunAdType.CSJ_NATIVE, this.f7818b.f7760a, 0, "Custom error message: adList is null");
            if (FunNativeAdLoader.this.mLoopAdIds.isEmpty()) {
                FunNativeAdLoader.this.mIsLoading = false;
                FunNativeAdLoadListener funNativeAdLoadListener2 = this.c;
                if (funNativeAdLoadListener2 != null) {
                    funNativeAdLoadListener2.onError(this.f7817a, 0, "自定义错误：穿山甲csj无填充");
                }
            } else {
                FunNativeAdLoader.this.doLoad(this.f7817a, this.c);
            }
            m.a("CSJNative onFeedAdLoad error: adList is null or empty");
        }
    }

    private void doLoadCsjNativeAd(String str, au.a aVar, FunNativeAdLoadListener funNativeAdLoadListener) {
        Activity activity = getActivity();
        if (activity == null) {
            if (funNativeAdLoadListener != null) {
                funNativeAdLoadListener.onError(str, 0, "Custom error message: activity is null");
                return;
            }
            return;
        }
        TTAdSdk.getAdManager().createAdNative(activity).loadFeedAd(new AdSlot.Builder().setCodeId(aVar.f7760a).setSupportDeepLink(true).setImageAcceptedSize(aVar.c, aVar.d).setAdCount(3).build(), new d(str, aVar, funNativeAdLoadListener));
        ((d.a) com.fun.ad.d.pEt).b(str, FunAdType.CSJ_NATIVE, aVar.f7760a);
    }
}
