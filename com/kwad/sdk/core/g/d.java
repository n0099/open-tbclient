package com.kwad.sdk.core.g;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.page.widget.webview.KSApiWebView;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.feed.b;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.ad;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements KsLoadManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f33099a = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.sdk.core.g.d$5  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass5 implements a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ KsLoadManager.FeedAdListener f33165a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ KsScene f33166b;

        public AnonymousClass5(KsLoadManager.FeedAdListener feedAdListener, KsScene ksScene) {
            this.f33165a = feedAdListener;
            this.f33166b = ksScene;
        }

        @Override // com.kwad.sdk.core.g.d.a
        public void a(final int i2, final String str) {
            d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.5.1
                @Override // java.lang.Runnable
                public void run() {
                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    AnonymousClass5.this.f33165a.onError(i2, str);
                }
            });
        }

        @Override // com.kwad.sdk.core.g.d.a
        public void a(@NonNull AdResultData adResultData) {
            final ArrayList arrayList = new ArrayList();
            String str = null;
            for (AdTemplate adTemplate : adResultData.adTemplateList) {
                if (adTemplate != null) {
                    AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
                    if (FeedType.checkTypeValid(adTemplate)) {
                        arrayList.add(new com.kwad.sdk.feed.b(adTemplate, this.f33166b.getWidth(), true));
                    } else {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.H(g2)), FeedType.fromInt(adTemplate.type));
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int size = arrayList.size();
                        if (size == 0) {
                            AnonymousClass5.this.f33165a.onFeedAdLoad(arrayList);
                            return;
                        }
                        final b.a aVar = new b.a(size);
                        for (KsFeedAd ksFeedAd : arrayList) {
                            ((com.kwad.sdk.feed.b) ksFeedAd).a(new b.InterfaceC0391b() { // from class: com.kwad.sdk.core.g.d.5.2.1
                                @Override // com.kwad.sdk.feed.b.InterfaceC0391b
                                public void a() {
                                    if (aVar.a()) {
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        AnonymousClass5.this.f33165a.onFeedAdLoad(arrayList);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            int i2 = f.f33224c.k;
            a(i2, f.f33224c.l + str);
        }
    }

    /* loaded from: classes6.dex */
    public interface a {
        @WorkerThread
        void a(int i2, String str);

        @WorkerThread
        void a(@NonNull AdResultData adResultData);
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f33189a;

        public b() {
            this.f33189a = false;
        }
    }

    public static void a(com.kwad.sdk.core.g.a.f fVar, @NonNull a aVar) {
        a(fVar, null, false, aVar);
    }

    public static void a(final com.kwad.sdk.core.g.a.f fVar, final List<String> list, final boolean z, @NonNull final a aVar) {
        new i<com.kwad.sdk.core.g.a, AdResultData>() { // from class: com.kwad.sdk.core.g.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.core.g.a b() {
                return new com.kwad.sdk.core.g.a(com.kwad.sdk.core.g.a.f.this, list, z, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(com.kwad.sdk.core.g.a.f.this.f33068a);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }
        }.a(new j<com.kwad.sdk.core.g.a, AdResultData>() { // from class: com.kwad.sdk.core.g.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.a aVar2, int i2, String str) {
                a.this.a(i2, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.a aVar2, @NonNull AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty()) {
                    a.this.a(adResultData);
                    return;
                }
                a aVar3 = a.this;
                f fVar2 = f.f33224c;
                aVar3.a(fVar2.k, fVar2.l);
            }
        });
    }

    private void a(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            f33099a.post(runnable);
        }
    }

    public static void b(AdResultData adResultData) {
        if (KsAdSDKImpl.get().getContext() == null || adResultData.adTemplateList.size() <= 0) {
            return;
        }
        new KSApiWebView(KsAdSDKImpl.get().getContext()).loadUrl(com.kwad.sdk.core.response.b.c.g(adResultData.adTemplateList.get(0)).adStyleInfo.playDetailInfo.detailWebCardInfo.cardUrl);
    }

    public static void b(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.adTemplateList.size() <= 0 || (adTemplate = adResultData.adTemplateList.get(0)) == null) {
            return;
        }
        e.a(adTemplate, elapsedRealtime - j);
    }

    public void a(KsScene ksScene) {
        e.b();
        ksScene.setAdStyle(4);
        ksScene.setAdNum(5);
        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache ");
        a(new com.kwad.sdk.core.g.a.f(ksScene), new ArrayList(), false, new a() { // from class: com.kwad.sdk.core.g.d.11
            @Override // com.kwad.sdk.core.g.d.a
            public void a(int i2, String str) {
                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
            }

            @Override // com.kwad.sdk.core.g.d.a
            public void a(@NonNull AdResultData adResultData) {
                if (adResultData.adTemplateList.size() > 0) {
                    int a2 = SplashPreloadManager.b().a(adResultData, false);
                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache onSuccess:" + adResultData.adTemplateList.size() + " saved " + a2);
                    e.b(adResultData.adTemplateList.size());
                }
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        ad.a().a(ksScene, "loadConfigFeedAd");
        ksScene.setAdStyle(1);
        a(new com.kwad.sdk.core.g.a.f(ksScene), new AnonymousClass5(feedAdListener, ksScene));
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        ad.a().a(ksScene, "loadDrawAd");
        ksScene.setAdStyle(6);
        a(new com.kwad.sdk.core.g.a.f(ksScene), new a() { // from class: com.kwad.sdk.core.g.d.6
            @Override // com.kwad.sdk.core.g.d.a
            public void a(final int i2, final String str) {
                d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("AdRequestManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        drawAdListener.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.d.a
            public void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.g(adTemplate)))) {
                        arrayList.add(new com.kwad.sdk.draw.b(adTemplate));
                    }
                }
                if (!arrayList.isEmpty()) {
                    d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            drawAdListener.onDrawAdLoad(arrayList);
                        }
                    });
                    return;
                }
                int i2 = f.f33224c.k;
                a(i2, f.f33224c.l + "(无视频资源)");
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFeedAd(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener) {
        ad.a().a(ksScene, "loadFeedAd");
        ksScene.setAdStyle(1);
        a(new com.kwad.sdk.core.g.a.f(ksScene), new a() { // from class: com.kwad.sdk.core.g.d.4
            @Override // com.kwad.sdk.core.g.d.a
            public void a(final int i2, final String str) {
                d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        feedAdListener.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.d.a
            public void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                String str = null;
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
                        if (FeedType.checkTypeValid(adTemplate)) {
                            arrayList.add(new com.kwad.sdk.feed.b(adTemplate));
                        } else {
                            str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.H(g2)), FeedType.fromInt(adTemplate.type));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            feedAdListener.onFeedAdLoad(arrayList);
                        }
                    });
                    return;
                }
                int i2 = f.f33224c.k;
                a(i2, f.f33224c.l + str);
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFullScreenVideoAd(final KsScene ksScene, @NonNull final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        ad.a().a(ksScene, "loadFullScreenVideoAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        ksScene.setAdStyle(3);
        a(new com.kwad.sdk.core.g.a.f(ksScene), new a() { // from class: com.kwad.sdk.core.g.d.12
            @Override // com.kwad.sdk.core.g.d.a
            public void a(final int i2, final String str) {
                d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFullScreenVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        fullScreenVideoAdListener.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.d.a
            public void a(@NonNull final AdResultData adResultData) {
                d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.12.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            fullScreenVideoAdListener.onRequestResult(adResultData.adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                });
                final ArrayList arrayList = new ArrayList();
                int y = com.kwad.sdk.core.config.c.y();
                boolean z = false;
                boolean z2 = false;
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            KsScene ksScene2 = ksScene;
                            if (ksScene2 instanceof SceneImpl) {
                                adTemplate.mAdScene = (SceneImpl) ksScene2;
                            }
                        }
                        String a2 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.g(adTemplate));
                        if (!TextUtils.isEmpty(a2)) {
                            if (y >= 0) {
                                if (y > 0 && !com.kwad.sdk.core.videocache.c.a.a(KsAdSDKImpl.get().getContext()).a(a2, y * 1024)) {
                                    z = true;
                                }
                                arrayList.add(new com.kwad.sdk.fullscreen.b(adTemplate));
                                z = true;
                                z2 = true;
                            } else if (g.a(adTemplate)) {
                                arrayList.add(new com.kwad.sdk.fullscreen.b(adTemplate));
                                z = true;
                                z2 = true;
                            } else {
                                z = true;
                            }
                        }
                    }
                }
                if (z) {
                    if (z2) {
                        d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.12.3
                            @Override // java.lang.Runnable
                            public void run() {
                                fullScreenVideoAdListener.onFullScreenVideoAdLoad(arrayList);
                                d.b(adResultData, elapsedRealtime);
                                try {
                                    d.b(adResultData);
                                } catch (Throwable th) {
                                    com.kwad.sdk.core.d.a.a(th);
                                }
                            }
                        });
                        return;
                    }
                    f fVar = f.f33225d;
                    a(fVar.k, fVar.l);
                    return;
                }
                int i2 = f.f33224c.k;
                a(i2, f.f33224c.l + "(无视频资源)");
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(KsScene ksScene, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        ad.a().a(ksScene, "loadNativeAd");
        ksScene.setAdStyle(1);
        a(new com.kwad.sdk.core.g.a.f(ksScene), new a() { // from class: com.kwad.sdk.core.g.d.14
            @Override // com.kwad.sdk.core.g.d.a
            public void a(final int i2, final String str) {
                d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("AdRequestManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        nativeAdListener.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.d.a
            public void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        arrayList.add(new com.kwad.sdk.a.a(adTemplate));
                    }
                }
                d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.14.2
                    @Override // java.lang.Runnable
                    public void run() {
                        nativeAdListener.onNativeAdLoad(arrayList);
                    }
                });
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(String str, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        Runnable runnable;
        ad.a().a(null, "loadNativeAdByJson");
        if (TextUtils.isEmpty(str)) {
            a(new Runnable() { // from class: com.kwad.sdk.core.g.d.15
                @Override // java.lang.Runnable
                public void run() {
                    com.kwad.sdk.core.d.a.e("AdRequestManager", "method parseJson params jsonResult is empty");
                    KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                    f fVar = f.f33224c;
                    nativeAdListener2.onError(fVar.k, fVar.l);
                }
            });
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final AdResultData adResultData = new AdResultData();
            adResultData.parseJson(jSONObject);
            if (adResultData.result != 1) {
                a(new Runnable() { // from class: com.kwad.sdk.core.g.d.16
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("AdRequestManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(adResultData.result), adResultData.errorMsg));
                        KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                        AdResultData adResultData2 = adResultData;
                        nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                    }
                });
                return;
            }
            if (adResultData.isAdResultDataEmpty()) {
                runnable = new Runnable() { // from class: com.kwad.sdk.core.g.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                        f fVar = f.f33224c;
                        nativeAdListener2.onError(fVar.k, fVar.l);
                    }
                };
            } else {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        arrayList.add(new com.kwad.sdk.a.a(adTemplate));
                    }
                }
                runnable = new Runnable() { // from class: com.kwad.sdk.core.g.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        nativeAdListener.onNativeAdLoad(arrayList);
                    }
                };
            }
            a(runnable);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            f fVar = f.f33223b;
            nativeAdListener.onError(fVar.k, fVar.l);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadRewardVideoAd(final KsScene ksScene, @NonNull final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        ad.a().a(ksScene, "loadRewardVideoAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        ksScene.setAdStyle(2);
        a(new com.kwad.sdk.core.g.a.f(ksScene), new a() { // from class: com.kwad.sdk.core.g.d.13
            @Override // com.kwad.sdk.core.g.d.a
            public void a(final int i2, final String str) {
                d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("AdRequestManager", "loadRewardVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        rewardVideoAdListener.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.d.a
            public void a(@NonNull final AdResultData adResultData) {
                d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.13.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            rewardVideoAdListener.onRequestResult(adResultData.adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                });
                final ArrayList arrayList = new ArrayList();
                int y = com.kwad.sdk.core.config.c.y();
                boolean z = false;
                boolean z2 = false;
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            KsScene ksScene2 = ksScene;
                            if (ksScene2 instanceof SceneImpl) {
                                adTemplate.mAdScene = (SceneImpl) ksScene2;
                            }
                        }
                        String a2 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.g(adTemplate));
                        if (!TextUtils.isEmpty(a2)) {
                            if (y >= 0) {
                                if (y > 0 && !com.kwad.sdk.core.videocache.c.a.a(KsAdSDKImpl.get().getContext()).a(a2, y * 1024)) {
                                    z = true;
                                }
                                arrayList.add(new com.kwad.sdk.reward.c(adTemplate));
                                z = true;
                                z2 = true;
                            } else if (g.a(adTemplate)) {
                                arrayList.add(new com.kwad.sdk.reward.c(adTemplate));
                                z = true;
                                z2 = true;
                            } else {
                                z = true;
                            }
                        }
                    }
                }
                if (z) {
                    if (z2) {
                        d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.13.3
                            @Override // java.lang.Runnable
                            public void run() {
                                rewardVideoAdListener.onRewardVideoAdLoad(arrayList);
                                d.b(adResultData, elapsedRealtime);
                                try {
                                    d.b(adResultData);
                                } catch (Throwable th) {
                                    com.kwad.sdk.core.d.a.a(th);
                                }
                            }
                        });
                        return;
                    }
                    f fVar = f.f33225d;
                    a(fVar.k, fVar.l);
                    return;
                }
                int i2 = f.f33224c.k;
                a(i2, f.f33224c.l + "(无视频资源)");
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadSplashScreenAd(@NonNull final KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        ad.a().a(ksScene, "loadSplashScreenAd");
        ksScene.setAdStyle(4);
        List<String> c2 = SplashPreloadManager.b().c();
        ksScene.setAdNum(1);
        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenAd ");
        final b bVar = new b();
        e.a();
        f33099a.postDelayed(new Runnable() { // from class: com.kwad.sdk.core.g.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.a(ksScene);
            }
        }, 15000L);
        final Runnable runnable = new Runnable() { // from class: com.kwad.sdk.core.g.d.9
            @Override // java.lang.Runnable
            public void run() {
                bVar.f33189a = true;
                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                f fVar = f.f33226e;
                splashScreenAdListener2.onError(fVar.k, fVar.l);
                e.a(4);
            }
        };
        f33099a.postDelayed(runnable, com.kwad.sdk.core.config.c.h());
        a(new com.kwad.sdk.core.g.a.f(ksScene), c2, true, new a() { // from class: com.kwad.sdk.core.g.d.10
            @Override // com.kwad.sdk.core.g.d.a
            public void a(final int i2, final String str) {
                if (!bVar.f33189a) {
                    d.f33099a.removeCallbacks(runnable);
                    d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                            splashScreenAdListener.onError(i2, str);
                            if (i2 == f.f33227f.k) {
                                e.a(0);
                            } else {
                                e.a(3);
                            }
                        }
                    });
                    return;
                }
                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
            }

            @Override // com.kwad.sdk.core.g.d.a
            public void a(@NonNull final AdResultData adResultData) {
                if (adResultData.adTemplateList.size() > 0) {
                    final com.kwad.sdk.splashscreen.a aVar = new com.kwad.sdk.splashscreen.a(ksScene, adResultData);
                    d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.10.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                splashScreenAdListener.onRequestResult(adResultData.adTemplateList.size());
                            } catch (Throwable th) {
                                com.kwad.sdk.core.d.a.b(th);
                            }
                        }
                    });
                    boolean a2 = SplashPreloadManager.b().a(adResultData);
                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onSuccess " + a2);
                    if (a2) {
                        if (bVar.f33189a) {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        d.f33099a.removeCallbacks(runnable);
                        d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.10.3
                            @Override // java.lang.Runnable
                            public void run() {
                                splashScreenAdListener.onSplashScreenAdLoad(aVar);
                            }
                        });
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd cache returned");
                        e.a(1);
                        return;
                    } else if (SplashPreloadManager.b().b(adResultData)) {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd image returned");
                        int a3 = SplashPreloadManager.b().a(adResultData, true);
                        if (bVar.f33189a) {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        d.f33099a.removeCallbacks(runnable);
                        if (a3 > 0) {
                            d.f33099a.post(new Runnable() { // from class: com.kwad.sdk.core.g.d.10.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    splashScreenAdListener.onSplashScreenAdLoad(aVar);
                                }
                            });
                            e.a(2);
                            return;
                        }
                        f fVar = f.f33227f;
                        a(fVar.k, fVar.l);
                        return;
                    } else if (bVar.f33189a) {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                        return;
                    } else {
                        d.f33099a.removeCallbacks(runnable);
                        a(f.f33225d.k, "请求成功，但缓存未命中");
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd no cache returned");
                    }
                } else if (bVar.f33189a) {
                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                    return;
                } else {
                    d.f33099a.removeCallbacks(runnable);
                    f fVar2 = f.f33224c;
                    a(fVar2.k, fVar2.l);
                }
                e.a(3);
            }
        });
    }
}
