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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class FunDrawVideoAdLoader {
    public boolean mIsLoading = false;
    public List<au.a> mLoopAdIds;
    public au mSlotId;
    public WeakReference<Activity> weakReferenceActivity;

    public FunDrawVideoAdLoader(au auVar) {
        this.mSlotId = auVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLoad(FunAdSlot funAdSlot, FunDrawVideoAdLoadListener funDrawVideoAdLoadListener) {
        au.a remove = this.mLoopAdIds.remove(0);
        String str = remove.f7761b;
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
            doLoadCsjDrawVideoAd(funAdSlot, remove, funDrawVideoAdLoadListener);
        } else if (c != 1) {
        } else {
            doLoadKsDrawVideoAd(funAdSlot, remove, funDrawVideoAdLoadListener);
        }
    }

    private void doLoadKsDrawVideoAd(FunAdSlot funAdSlot, au.a aVar, FunDrawVideoAdLoadListener funDrawVideoAdLoadListener) {
        KsAdSDK.getLoadManager().loadDrawAd(new KsScene.Builder(Long.parseLong(aVar.f7760a)).adNum(5).build(), new a(aVar, funDrawVideoAdLoadListener, funAdSlot));
        ((d.a) d.pEt).b(this.mSlotId.f7758a, FunAdType.KS_DRAW_VIDEO, aVar.f7760a);
    }

    private Activity getActivity() {
        WeakReference<Activity> weakReference = this.weakReferenceActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void load(FunAdSlot funAdSlot, FunDrawVideoAdLoadListener funDrawVideoAdLoadListener) {
        List<au.a> list = this.mSlotId.c;
        if (list != null && !list.isEmpty()) {
            if (this.mIsLoading) {
                return;
            }
            this.mIsLoading = true;
            this.mLoopAdIds = new ArrayList();
            for (au.a aVar : list) {
                String str = aVar.f7761b;
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
            doLoad(funAdSlot, funDrawVideoAdLoadListener);
            return;
        }
        Log.e("FunAdSdk", "FunDrawVideoAdLoader load广告位：" + this.mSlotId.f7758a + "未配置任何类型的广告ID");
    }

    public void setActivity(Activity activity) {
        this.weakReferenceActivity = new WeakReference<>(activity);
    }

    private void doLoadCsjDrawVideoAd(FunAdSlot funAdSlot, au.a aVar, FunDrawVideoAdLoadListener funDrawVideoAdLoadListener) {
        Activity activity = getActivity();
        if (activity == null) {
            if (funDrawVideoAdLoadListener != null) {
                funDrawVideoAdLoadListener.onError(funAdSlot.getSid(), 0, "Custom error message: activity is null");
                return;
            }
            return;
        }
        TTAdSdk.getAdManager().createAdNative(activity).loadExpressDrawFeedAd(new AdSlot.Builder().setCodeId(aVar.f7760a).setSupportDeepLink(true).setExpressViewAcceptedSize(funAdSlot.getExpressWidth(), funAdSlot.getExpressHeight()).setImageAcceptedSize(640, 320).setAdCount(3).build(), new b(aVar, funDrawVideoAdLoadListener, funAdSlot));
        ((d.a) d.pEt).b(this.mSlotId.f7758a, FunAdType.CSJ_DRAW_VIDEO, aVar.f7760a);
    }

    /* loaded from: classes14.dex */
    public class b implements TTAdNative.NativeExpressAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ au.a f7799a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunDrawVideoAdLoadListener f7800b;
        public final /* synthetic */ FunAdSlot c;

        public b(au.a aVar, FunDrawVideoAdLoadListener funDrawVideoAdLoadListener, FunAdSlot funAdSlot) {
            this.f7799a = aVar;
            this.f7800b = funDrawVideoAdLoadListener;
            this.c = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            m.a("CSJDrawVideoAd onError code: " + i + ", message: " + str);
            ((d.a) d.pEt).a(FunDrawVideoAdLoader.this.mSlotId.f7758a, FunAdType.CSJ_DRAW_VIDEO, this.f7799a.f7760a, i, str);
            if (!FunDrawVideoAdLoader.this.mLoopAdIds.isEmpty()) {
                FunDrawVideoAdLoader.this.doLoad(this.c, this.f7800b);
                return;
            }
            FunDrawVideoAdLoader.this.mIsLoading = false;
            FunDrawVideoAdLoadListener funDrawVideoAdLoadListener = this.f7800b;
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
                    arrayList.add(new FunDrawVideoAd(this.c.getSid(), this.f7799a.f7760a, tTNativeExpressAd));
                }
                FunDrawVideoAdLoader.this.mIsLoading = false;
                FunDrawVideoAdLoadListener funDrawVideoAdLoadListener = this.f7800b;
                if (funDrawVideoAdLoadListener != null) {
                    funDrawVideoAdLoadListener.onAdLoaded(this.c.getSid(), arrayList);
                }
                ((d.a) d.pEt).c(FunDrawVideoAdLoader.this.mSlotId.f7758a, FunAdType.CSJ_DRAW_VIDEO, this.f7799a.f7760a);
                return;
            }
            ((d.a) d.pEt).a(FunDrawVideoAdLoader.this.mSlotId.f7758a, FunAdType.CSJ_DRAW_VIDEO, this.f7799a.f7760a, 0, "Custom error message: adList is null");
            if (FunDrawVideoAdLoader.this.mLoopAdIds.isEmpty()) {
                FunDrawVideoAdLoader.this.mIsLoading = false;
                FunDrawVideoAdLoadListener funDrawVideoAdLoadListener2 = this.f7800b;
                if (funDrawVideoAdLoadListener2 != null) {
                    funDrawVideoAdLoadListener2.onError(this.c.getSid(), 0, "自定义错误：穿山甲csj无填充");
                }
            } else {
                FunDrawVideoAdLoader.this.doLoad(this.c, this.f7800b);
            }
            m.a("CSJDrawVideoAd onFeedAdLoad error: adList is null or empty");
        }
    }

    /* loaded from: classes14.dex */
    public class a implements KsLoadManager.DrawAdListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ au.a f7797a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FunDrawVideoAdLoadListener f7798b;
        public final /* synthetic */ FunAdSlot c;

        public a(au.a aVar, FunDrawVideoAdLoadListener funDrawVideoAdLoadListener, FunAdSlot funAdSlot) {
            this.f7797a = aVar;
            this.f7798b = funDrawVideoAdLoadListener;
            this.c = funAdSlot;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
        public void onError(int i, String str) {
            m.a("KSDrawVideoAd onError code: " + i + ", message: " + str);
            ((d.a) d.pEt).a(FunDrawVideoAdLoader.this.mSlotId.f7758a, FunAdType.KS_DRAW_VIDEO, this.f7797a.f7760a, i, str);
            if (!FunDrawVideoAdLoader.this.mLoopAdIds.isEmpty()) {
                FunDrawVideoAdLoader.this.doLoad(this.c, this.f7798b);
                return;
            }
            FunDrawVideoAdLoader.this.mIsLoading = false;
            FunDrawVideoAdLoadListener funDrawVideoAdLoadListener = this.f7798b;
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
                        arrayList.add(new FunDrawVideoAd(this.c.getSid(), this.f7797a.f7760a, ksDrawAd));
                    }
                }
                if (arrayList.isEmpty()) {
                    ((d.a) d.pEt).a(FunDrawVideoAdLoader.this.mSlotId.f7758a, FunAdType.KS_DRAW_VIDEO, this.f7797a.f7760a, 0, "Custom error message: adList is null");
                    if (!FunDrawVideoAdLoader.this.mLoopAdIds.isEmpty()) {
                        FunDrawVideoAdLoader.this.doLoad(this.c, this.f7798b);
                        return;
                    }
                    FunDrawVideoAdLoader.this.mIsLoading = false;
                    FunDrawVideoAdLoadListener funDrawVideoAdLoadListener = this.f7798b;
                    if (funDrawVideoAdLoadListener != null) {
                        funDrawVideoAdLoadListener.onError(this.c.getSid(), 0, "自定义错误：快手ks无填充");
                        return;
                    }
                    return;
                }
                FunDrawVideoAdLoader.this.mIsLoading = false;
                FunDrawVideoAdLoadListener funDrawVideoAdLoadListener2 = this.f7798b;
                if (funDrawVideoAdLoadListener2 != null) {
                    funDrawVideoAdLoadListener2.onAdLoaded(this.c.getSid(), arrayList);
                }
                ((d.a) d.pEt).c(FunDrawVideoAdLoader.this.mSlotId.f7758a, FunAdType.KS_DRAW_VIDEO, this.f7797a.f7760a);
                return;
            }
            ((d.a) d.pEt).a(FunDrawVideoAdLoader.this.mSlotId.f7758a, FunAdType.KS_DRAW_VIDEO, this.f7797a.f7760a, 0, "Custom error message: adList is null");
            if (FunDrawVideoAdLoader.this.mLoopAdIds.isEmpty()) {
                FunDrawVideoAdLoader.this.mIsLoading = false;
                FunDrawVideoAdLoadListener funDrawVideoAdLoadListener3 = this.f7798b;
                if (funDrawVideoAdLoadListener3 != null) {
                    funDrawVideoAdLoadListener3.onError(this.c.getSid(), 0, "自定义错误：快手ks无填充");
                }
            } else {
                FunDrawVideoAdLoader.this.doLoad(this.c, this.f7798b);
            }
            m.a("KSDrawVideoAd onDrawAdLoad error: adList is null or empty");
        }
    }
}
