package com.fun.ad.sdk;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.m;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class FunDrawVideoAdLoader {
    public boolean mIsLoading = false;
    public List<au.a> mLoopAdIds;
    public au mSlotId;

    public FunDrawVideoAdLoader(au auVar) {
        this.mSlotId = auVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLoad(Activity activity, FunAdSlot funAdSlot, FunDrawVideoAdLoadListener funDrawVideoAdLoadListener) {
        au.a remove = this.mLoopAdIds.remove(0);
        String str = remove.f8061b;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -2105157443) {
            if (hashCode == 2017609999 && str.equals(FunAdType.KS_DRAW_VIDEO)) {
                c = 1;
            }
        } else if (str.equals(FunAdType.CSJ_DRAW_VIDEO)) {
            c = 0;
        }
        if (c == 0) {
            doLoadCsjDrawVideoAd(activity, funAdSlot, remove, funDrawVideoAdLoadListener);
        } else if (c != 1) {
        } else {
            doLoadKsDrawVideoAd(activity, funAdSlot, remove, funDrawVideoAdLoadListener);
        }
    }

    private void doLoadCsjDrawVideoAd(Activity activity, FunAdSlot funAdSlot, au.a aVar, FunDrawVideoAdLoadListener funDrawVideoAdLoadListener) {
        TTAdSdk.getAdManager().createAdNative(activity).loadExpressDrawFeedAd(new AdSlot.Builder().setCodeId(aVar.f8060a).setSupportDeepLink(true).setExpressViewAcceptedSize(funAdSlot.getExpressWidth(), funAdSlot.getExpressHeight()).setImageAcceptedSize(640, 320).setAdCount(3).build(), new b(aVar, funDrawVideoAdLoadListener, funAdSlot, activity));
        ((d.a) d.pIU).b(this.mSlotId.f8058a, FunAdType.CSJ_DRAW_VIDEO, aVar.f8060a);
    }

    private void doLoadKsDrawVideoAd(Activity activity, FunAdSlot funAdSlot, au.a aVar, FunDrawVideoAdLoadListener funDrawVideoAdLoadListener) {
        KsAdSDK.getLoadManager().loadDrawAd(new KsScene.Builder(Long.parseLong(aVar.f8060a)).adNum(5).build(), new a(aVar, funDrawVideoAdLoadListener, funAdSlot, activity));
        ((d.a) d.pIU).b(this.mSlotId.f8058a, FunAdType.KS_DRAW_VIDEO, aVar.f8060a);
    }

    public void load(Activity activity, FunAdSlot funAdSlot, FunDrawVideoAdLoadListener funDrawVideoAdLoadListener) {
        List<au.a> list = this.mSlotId.c;
        if (list != null && !list.isEmpty()) {
            if (this.mIsLoading) {
                return;
            }
            this.mIsLoading = true;
            this.mLoopAdIds = new ArrayList();
            for (au.a aVar : list) {
                String str = aVar.f8061b;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -2105157443) {
                    if (hashCode == 2017609999 && str.equals(FunAdType.KS_DRAW_VIDEO)) {
                        c = 1;
                    }
                } else if (str.equals(FunAdType.CSJ_DRAW_VIDEO)) {
                    c = 0;
                }
                if (c == 0 || c == 1) {
                    this.mLoopAdIds.add(aVar);
                }
            }
            doLoad(activity, funAdSlot, funDrawVideoAdLoadListener);
            return;
        }
        Log.e("FunAdSdk", "FunDrawVideoAdLoader load广告位：" + this.mSlotId.f8058a + "未配置任何类型的广告ID");
    }

    /* loaded from: classes15.dex */
    public class b implements TTAdNative.NativeExpressAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ au.a f8099a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunDrawVideoAdLoadListener f8100b;
        public final /* synthetic */ FunAdSlot c;
        public final /* synthetic */ Activity d;

        public b(au.a aVar, FunDrawVideoAdLoadListener funDrawVideoAdLoadListener, FunAdSlot funAdSlot, Activity activity) {
            this.f8099a = aVar;
            this.f8100b = funDrawVideoAdLoadListener;
            this.c = funAdSlot;
            this.d = activity;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJDrawVideoAd onError code: " + i + ", message: " + str);
            ((d.a) d.pIU).a(FunDrawVideoAdLoader.this.mSlotId.f8058a, FunAdType.CSJ_DRAW_VIDEO, this.f8099a.f8060a, i, str);
            if (!FunDrawVideoAdLoader.this.mLoopAdIds.isEmpty()) {
                FunDrawVideoAdLoader.this.doLoad(this.d, this.c, this.f8100b);
                return;
            }
            FunDrawVideoAdLoader.this.mIsLoading = false;
            FunDrawVideoAdLoadListener funDrawVideoAdLoadListener = this.f8100b;
            if (funDrawVideoAdLoadListener != null) {
                funDrawVideoAdLoadListener.onError(this.c.getSid(), i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            m.a("CSJDrawVideoAd onDrawFeedAdLoad");
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (TTNativeExpressAd tTNativeExpressAd : list) {
                    AdRipper.ripCSJ(tTNativeExpressAd);
                    arrayList.add(new FunDrawVideoAd(this.c.getSid(), this.f8099a.f8060a, tTNativeExpressAd));
                }
                FunDrawVideoAdLoader.this.mIsLoading = false;
                FunDrawVideoAdLoadListener funDrawVideoAdLoadListener = this.f8100b;
                if (funDrawVideoAdLoadListener != null) {
                    funDrawVideoAdLoadListener.onAdLoaded(this.c.getSid(), arrayList);
                }
                ((d.a) d.pIU).c(FunDrawVideoAdLoader.this.mSlotId.f8058a, FunAdType.CSJ_DRAW_VIDEO, this.f8099a.f8060a);
                return;
            }
            ((d.a) d.pIU).a(FunDrawVideoAdLoader.this.mSlotId.f8058a, FunAdType.CSJ_DRAW_VIDEO, this.f8099a.f8060a, 0, "Custom error message: adList is null");
            if (FunDrawVideoAdLoader.this.mLoopAdIds.isEmpty()) {
                FunDrawVideoAdLoader.this.mIsLoading = false;
                FunDrawVideoAdLoadListener funDrawVideoAdLoadListener2 = this.f8100b;
                if (funDrawVideoAdLoadListener2 != null) {
                    funDrawVideoAdLoadListener2.onError(this.c.getSid(), 0, "自定义错误：穿山甲csj无填充");
                }
            } else {
                FunDrawVideoAdLoader.this.doLoad(this.d, this.c, this.f8100b);
            }
            m.a("CSJDrawVideoAd onFeedAdLoad error: adList is null or empty");
        }
    }

    /* loaded from: classes15.dex */
    public class a implements KsLoadManager.DrawAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ au.a f8097a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunDrawVideoAdLoadListener f8098b;
        public final /* synthetic */ FunAdSlot c;
        public final /* synthetic */ Activity d;

        public a(au.a aVar, FunDrawVideoAdLoadListener funDrawVideoAdLoadListener, FunAdSlot funAdSlot, Activity activity) {
            this.f8097a = aVar;
            this.f8098b = funDrawVideoAdLoadListener;
            this.c = funAdSlot;
            this.d = activity;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onError(int i, String str) {
            m.a("KSDrawVideoAd onError code: " + i + ", message: " + str);
            ((d.a) d.pIU).a(FunDrawVideoAdLoader.this.mSlotId.f8058a, FunAdType.KS_DRAW_VIDEO, this.f8097a.f8060a, i, str);
            if (!FunDrawVideoAdLoader.this.mLoopAdIds.isEmpty()) {
                FunDrawVideoAdLoader.this.doLoad(this.d, this.c, this.f8098b);
                return;
            }
            FunDrawVideoAdLoader.this.mIsLoading = false;
            FunDrawVideoAdLoadListener funDrawVideoAdLoadListener = this.f8098b;
            if (funDrawVideoAdLoadListener != null) {
                funDrawVideoAdLoadListener.onError(this.c.getSid(), i, str);
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
            m.a("KSDrawVideoAd onNativeAdLoad");
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (KsDrawAd ksDrawAd : list) {
                    if (ksDrawAd != null) {
                        AdRipper.ripKSDrawAd(ksDrawAd);
                        arrayList.add(new FunDrawVideoAd(this.c.getSid(), this.f8097a.f8060a, ksDrawAd));
                    }
                }
                if (arrayList.isEmpty()) {
                    ((d.a) d.pIU).a(FunDrawVideoAdLoader.this.mSlotId.f8058a, FunAdType.KS_DRAW_VIDEO, this.f8097a.f8060a, 0, "Custom error message: adList is null");
                    if (!FunDrawVideoAdLoader.this.mLoopAdIds.isEmpty()) {
                        FunDrawVideoAdLoader.this.doLoad(this.d, this.c, this.f8098b);
                        return;
                    }
                    FunDrawVideoAdLoader.this.mIsLoading = false;
                    FunDrawVideoAdLoadListener funDrawVideoAdLoadListener = this.f8098b;
                    if (funDrawVideoAdLoadListener != null) {
                        funDrawVideoAdLoadListener.onError(this.c.getSid(), 0, "自定义错误：快手ks无填充");
                        return;
                    }
                    return;
                }
                FunDrawVideoAdLoader.this.mIsLoading = false;
                FunDrawVideoAdLoadListener funDrawVideoAdLoadListener2 = this.f8098b;
                if (funDrawVideoAdLoadListener2 != null) {
                    funDrawVideoAdLoadListener2.onAdLoaded(this.c.getSid(), arrayList);
                }
                ((d.a) d.pIU).c(FunDrawVideoAdLoader.this.mSlotId.f8058a, FunAdType.KS_DRAW_VIDEO, this.f8097a.f8060a);
                return;
            }
            ((d.a) d.pIU).a(FunDrawVideoAdLoader.this.mSlotId.f8058a, FunAdType.KS_DRAW_VIDEO, this.f8097a.f8060a, 0, "Custom error message: adList is null");
            if (FunDrawVideoAdLoader.this.mLoopAdIds.isEmpty()) {
                FunDrawVideoAdLoader.this.mIsLoading = false;
                FunDrawVideoAdLoadListener funDrawVideoAdLoadListener3 = this.f8098b;
                if (funDrawVideoAdLoadListener3 != null) {
                    funDrawVideoAdLoadListener3.onError(this.c.getSid(), 0, "自定义错误：快手ks无填充");
                }
            } else {
                FunDrawVideoAdLoader.this.doLoad(this.d, this.c, this.f8098b);
            }
            m.a("KSDrawVideoAd onDrawAdLoad error: adList is null or empty");
        }
    }
}
