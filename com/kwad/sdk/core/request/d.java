package com.kwad.sdk.core.request;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.request.model.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.feed.b;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.reward.n;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.as;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements KsLoadManager {
    public static final Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.sdk.core.request.d$5  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass5 implements a {
        public final /* synthetic */ KsLoadManager.FeedAdListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ KsScene f56163b;

        public AnonymousClass5(KsLoadManager.FeedAdListener feedAdListener, KsScene ksScene) {
            this.a = feedAdListener;
            this.f56163b = ksScene;
        }

        @Override // com.kwad.sdk.core.request.d.a
        public void a(final int i2, final String str) {
            d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.5.1
                @Override // java.lang.Runnable
                public void run() {
                    com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    AnonymousClass5.this.a.onError(i2, str);
                }
            });
        }

        @Override // com.kwad.sdk.core.request.d.a
        public void a(@NonNull AdResultData adResultData) {
            d.this.c(adResultData, this.f56163b.getPosId());
            final ArrayList arrayList = new ArrayList();
            String str = null;
            for (AdTemplate adTemplate : adResultData.adTemplateList) {
                if (adTemplate != null) {
                    AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
                    if (FeedType.checkTypeValid(adTemplate)) {
                        KsScene ksScene = this.f56163b;
                        if (ksScene instanceof SceneImpl) {
                            adTemplate.mAdScene = (SceneImpl) ksScene;
                        }
                        arrayList.add(new com.kwad.sdk.feed.b(adTemplate, this.f56163b.getWidth(), true));
                    } else {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.a.a.R(j2)), FeedType.fromInt(adTemplate.type));
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int size = arrayList.size();
                        if (size == 0) {
                            AnonymousClass5.this.a.onFeedAdLoad(arrayList);
                            return;
                        }
                        final b.a aVar = new b.a(size);
                        for (KsFeedAd ksFeedAd : arrayList) {
                            ((com.kwad.sdk.feed.b) ksFeedAd).a(new b.InterfaceC2132b() { // from class: com.kwad.sdk.core.request.d.5.2.1
                                @Override // com.kwad.sdk.feed.b.InterfaceC2132b
                                public void a() {
                                    if (aVar.a()) {
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        AnonymousClass5.this.a.onFeedAdLoad(arrayList);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            int i2 = f.f55940e.n;
            a(i2, f.f55940e.o + str);
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        @WorkerThread
        void a(int i2, String str);

        @WorkerThread
        void a(@NonNull AdResultData adResultData);
    }

    /* loaded from: classes3.dex */
    public static class b {
        public volatile boolean a;

        public b() {
            this.a = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public static j a(KsScene ksScene, boolean z) {
        boolean o = com.kwad.sdk.core.config.b.o();
        ?? r0 = o;
        if (KsAdSDKImpl.get().getContext() != null) {
            int f2 = as.f(KsAdSDKImpl.get().getContext(), String.valueOf(ksScene.getPosId()));
            r0 = o;
            if (f2 != -1) {
                r0 = 1;
                if (f2 != 1) {
                    r0 = 0;
                }
            }
        }
        j jVar = new j();
        if (z) {
            jVar.a = r0;
        }
        return jVar;
    }

    private AdTemplate a(long j2) {
        com.kwad.sdk.core.diskcache.a.a a2 = com.kwad.sdk.core.diskcache.a.a.a();
        Object c2 = a2.c("feed_ad_cache_" + j2);
        if (c2 == null || c2 == "") {
            return null;
        }
        AdTemplate adTemplate = new AdTemplate();
        try {
            adTemplate.parseJson(new JSONObject(com.kwad.sdk.core.a.d.b(c2.toString())));
            return adTemplate;
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.b(e2);
            return null;
        }
    }

    public static void a(com.kwad.sdk.core.request.model.f fVar, @NonNull a aVar, boolean z) {
        a(fVar, null, false, z, a((KsScene) fVar.a, false), aVar);
    }

    public static void a(com.kwad.sdk.core.request.model.f fVar, List<String> list, boolean z, boolean z2, @Nullable j jVar, @NonNull a aVar) {
        a(fVar, list, z, z2, jVar, aVar, false);
    }

    public static void a(final com.kwad.sdk.core.request.model.f fVar, final List<String> list, final boolean z, final boolean z2, @Nullable final j jVar, @NonNull final a aVar, final boolean z3) {
        new i<com.kwad.sdk.core.request.a, AdResultData>() { // from class: com.kwad.sdk.core.request.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.core.request.a b() {
                com.kwad.sdk.core.request.a aVar2 = new com.kwad.sdk.core.request.a(com.kwad.sdk.core.request.model.f.this, list, z, null, jVar);
                aVar2.a(z2 ? 1 : 0);
                return aVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(com.kwad.sdk.core.request.model.f.this.a);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }
        }.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.request.a, AdResultData>() { // from class: com.kwad.sdk.core.request.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.request.a aVar2, int i2, String str) {
                aVar.a(i2, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.request.a aVar2, @NonNull AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty() || z3) {
                    aVar.a(adResultData);
                    return;
                }
                a aVar3 = aVar;
                f fVar2 = f.f55940e;
                aVar3.a(fVar2.n, fVar2.o);
            }
        });
    }

    private void a(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            a.post(runnable);
        }
    }

    private boolean a(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        return com.kwad.sdk.core.response.a.d.j(adTemplate).adBaseInfo.adCacheSecond * 1000 > System.currentTimeMillis();
    }

    public static void b(AdResultData adResultData, long j2) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.adTemplateList.size() <= 0 || (adTemplate = adResultData.adTemplateList.get(0)) == null) {
            return;
        }
        com.kwad.sdk.core.report.d.a(adTemplate, elapsedRealtime - j2);
    }

    private void b(AdTemplate adTemplate) {
        AdInfo.AdBaseInfo adBaseInfo = com.kwad.sdk.core.response.a.d.j(adTemplate).adBaseInfo;
        adBaseInfo.adCacheSecond = (System.currentTimeMillis() / 1000) + adBaseInfo.adCacheSecond;
        com.kwad.sdk.core.diskcache.a.a a2 = com.kwad.sdk.core.diskcache.a.a.a();
        a2.a("feed_ad_cache_" + adTemplate.posId, com.kwad.sdk.core.a.d.a(adTemplate.toJson().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdResultData adResultData, long j2) {
        AdTemplate a2 = a(j2);
        if (adResultData.adTemplateList.isEmpty() && a(a2)) {
            adResultData.adTemplateList.add(a2);
        } else if (adResultData.adTemplateList.isEmpty()) {
        } else {
            AdTemplate adTemplate = adResultData.adTemplateList.get(0);
            if (com.kwad.sdk.core.response.a.d.j(adTemplate).adBaseInfo.adCacheSwitch == 0) {
                return;
            }
            if (a2 == null) {
                b(adTemplate);
                return;
            }
            int F = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.j(adTemplate));
            int F2 = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.j(a2));
            if (!a(a2) || F2 <= F) {
                b(adTemplate);
            } else {
                adResultData.adTemplateList.set(0, a2);
            }
        }
    }

    public void a(KsScene ksScene) {
        com.kwad.sdk.core.report.d.b();
        ksScene.setAdStyle(4);
        ksScene.setAdNum(5);
        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache ");
        a(new com.kwad.sdk.core.request.model.f(ksScene), new ArrayList(), false, false, a(ksScene, false), new a() { // from class: com.kwad.sdk.core.request.d.12
            @Override // com.kwad.sdk.core.request.d.a
            public void a(int i2, String str) {
                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
            }

            @Override // com.kwad.sdk.core.request.d.a
            public void a(@NonNull AdResultData adResultData) {
                if (adResultData.adTemplateList.size() > 0) {
                    int a2 = SplashPreloadManager.b().a(adResultData, false);
                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache onSuccess:" + adResultData.adTemplateList.size() + " saved " + a2);
                    com.kwad.sdk.core.report.d.b(adResultData.adTemplateList.size());
                }
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        boolean a2 = ap.a().a(ksScene, "loadConfigFeedAd");
        ksScene.setAdStyle(1);
        a(new com.kwad.sdk.core.request.model.f(ksScene), null, false, a2, a(ksScene, true), new AnonymousClass5(feedAdListener, ksScene), true);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        boolean a2 = ap.a().a(ksScene, "loadDrawAd");
        ksScene.setAdStyle(6);
        a(new com.kwad.sdk.core.request.model.f(ksScene), new a() { // from class: com.kwad.sdk.core.request.d.6
            @Override // com.kwad.sdk.core.request.d.a
            public void a(final int i2, final String str) {
                d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("AdRequestManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        drawAdListener.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.request.d.a
            public void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(adTemplate)))) {
                        arrayList.add(new com.kwad.sdk.draw.b(adTemplate));
                    }
                }
                if (!arrayList.isEmpty()) {
                    d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            drawAdListener.onDrawAdLoad(arrayList);
                        }
                    });
                    return;
                }
                int i2 = f.f55940e.n;
                a(i2, f.f55940e.o + "(无视频资源)");
            }
        }, a2);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFeedAd(final KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener) {
        boolean a2 = ap.a().a(ksScene, "loadFeedAd");
        ksScene.setAdStyle(1);
        a(new com.kwad.sdk.core.request.model.f(ksScene), null, false, a2, a(ksScene, true), new a() { // from class: com.kwad.sdk.core.request.d.4
            @Override // com.kwad.sdk.core.request.d.a
            public void a(final int i2, final String str) {
                d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        feedAdListener.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.request.d.a
            public void a(@NonNull AdResultData adResultData) {
                d.this.c(adResultData, ksScene.getPosId());
                final ArrayList arrayList = new ArrayList();
                String str = null;
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
                        if (FeedType.checkTypeValid(adTemplate)) {
                            KsScene ksScene2 = ksScene;
                            if (ksScene2 instanceof SceneImpl) {
                                adTemplate.mAdScene = (SceneImpl) ksScene2;
                            }
                            arrayList.add(new com.kwad.sdk.feed.b(adTemplate));
                        } else {
                            str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.a.a.R(j2)), FeedType.fromInt(adTemplate.type));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            feedAdListener.onFeedAdLoad(arrayList);
                        }
                    });
                    return;
                }
                int i2 = f.f55940e.n;
                a(i2, f.f55940e.o + str);
            }
        }, true);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFullScreenVideoAd(final KsScene ksScene, @NonNull final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        boolean a2 = ap.a().a(ksScene, "loadFullScreenVideoAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        ksScene.setAdStyle(3);
        a(new com.kwad.sdk.core.request.model.f(ksScene), new a() { // from class: com.kwad.sdk.core.request.d.13
            @Override // com.kwad.sdk.core.request.d.a
            public void a(final int i2, final String str) {
                d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("AdRequestManager", "loadFullScreenVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        fullScreenVideoAdListener.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.request.d.a
            public void a(@NonNull final AdResultData adResultData) {
                d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.13.2
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
                int C = com.kwad.sdk.core.config.b.C();
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
                        String a3 = com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(adTemplate));
                        com.kwad.sdk.core.d.a.a("loadFullScreenVideoAd", " videoUrl:" + a3);
                        if (!TextUtils.isEmpty(a3)) {
                            com.kwad.sdk.core.d.a.a("loadFullScreenVideoAd", " preSize:" + C);
                            if (C >= 0) {
                                if (C > 0 && !com.kwad.sdk.core.videocache.b.a.a(KsAdSDKImpl.get().getContext()).a(a3, C * 1024)) {
                                    z = true;
                                }
                                arrayList.add(new com.kwad.sdk.fullscreen.b(adTemplate));
                                z = true;
                                z2 = true;
                            } else if (n.a(adTemplate)) {
                                arrayList.add(new com.kwad.sdk.fullscreen.b(adTemplate));
                                z = true;
                                z2 = true;
                            } else {
                                z = true;
                            }
                        }
                    }
                }
                com.kwad.sdk.core.d.a.a("loadFullScreenVideoAd", " downloadVideo finish");
                if (z) {
                    if (z2) {
                        d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.13.3
                            @Override // java.lang.Runnable
                            public void run() {
                                fullScreenVideoAdListener.onFullScreenVideoAdLoad(arrayList);
                                d.b(adResultData, elapsedRealtime);
                            }
                        });
                        return;
                    }
                    f fVar = f.f55941f;
                    a(fVar.n, fVar.o);
                    return;
                }
                int i2 = f.f55940e.n;
                a(i2, f.f55940e.o + "(无视频资源)");
            }
        }, a2);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadInterstitialAd(@NonNull final KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        boolean a2 = ap.a().a(ksScene, "loadInterstitialAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        ksScene.setAdStyle(13);
        a(new com.kwad.sdk.core.request.model.f(ksScene), new a() { // from class: com.kwad.sdk.core.request.d.7
            @Override // com.kwad.sdk.core.request.d.a
            public void a(final int i2, final String str) {
                d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("AdRequestManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        interstitialAdListener.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.request.d.a
            public void a(@NonNull final AdResultData adResultData) {
                com.kwad.sdk.d.a aVar;
                d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            interstitialAdListener.onRequestResult(adResultData.adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                });
                final ArrayList arrayList = new ArrayList();
                int C = com.kwad.sdk.core.config.b.C();
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            KsScene ksScene2 = ksScene;
                            if (ksScene2 instanceof SceneImpl) {
                                adTemplate.mAdScene = (SceneImpl) ksScene2;
                            }
                        }
                        String a3 = com.kwad.sdk.core.response.a.a.a(com.kwad.sdk.core.response.a.d.j(adTemplate));
                        if (TextUtils.isEmpty(a3)) {
                            aVar = new com.kwad.sdk.d.a(ksScene, adTemplate);
                        } else if (C >= 0) {
                            if (C > 0 && !com.kwad.sdk.core.videocache.b.a.a(KsAdSDKImpl.get().getContext()).a(a3, C * 1024)) {
                            }
                            aVar = new com.kwad.sdk.d.a(ksScene, adTemplate);
                        } else if (n.a(adTemplate)) {
                            aVar = new com.kwad.sdk.d.a(ksScene, adTemplate);
                        }
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() != 0) {
                    d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.7.3
                        @Override // java.lang.Runnable
                        public void run() {
                            interstitialAdListener.onInterstitialAdLoad(arrayList);
                            d.b(adResultData, elapsedRealtime);
                        }
                    });
                    return;
                }
                f fVar = f.f55940e;
                a(fVar.n, fVar.o);
            }
        }, a2);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(KsScene ksScene, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        boolean a2 = ap.a().a(ksScene, "loadNativeAd");
        ksScene.setAdStyle(10000);
        a(new com.kwad.sdk.core.request.model.f(ksScene), new a() { // from class: com.kwad.sdk.core.request.d.15
            @Override // com.kwad.sdk.core.request.d.a
            public void a(final int i2, final String str) {
                d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("AdRequestManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        nativeAdListener.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.request.d.a
            public void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        arrayList.add(new com.kwad.sdk.f.a(adTemplate));
                    }
                }
                d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.15.2
                    @Override // java.lang.Runnable
                    public void run() {
                        nativeAdListener.onNativeAdLoad(arrayList);
                    }
                });
            }
        }, a2);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(String str, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        Runnable runnable;
        if (ap.a().a(null, "loadNativeAdByJson") && ap.a().b() == 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            a(new Runnable() { // from class: com.kwad.sdk.core.request.d.16
                @Override // java.lang.Runnable
                public void run() {
                    com.kwad.sdk.core.d.a.e("AdRequestManager", "method parseJson params jsonResult is empty");
                    KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                    f fVar = f.f55940e;
                    nativeAdListener2.onError(fVar.n, fVar.o);
                }
            });
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final AdResultData adResultData = new AdResultData();
            adResultData.parseJson(jSONObject);
            if (adResultData.result != 1) {
                a(new Runnable() { // from class: com.kwad.sdk.core.request.d.17
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
                runnable = new Runnable() { // from class: com.kwad.sdk.core.request.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                        f fVar = f.f55940e;
                        nativeAdListener2.onError(fVar.n, fVar.o);
                    }
                };
            } else {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        arrayList.add(new com.kwad.sdk.f.a(adTemplate));
                    }
                }
                runnable = new Runnable() { // from class: com.kwad.sdk.core.request.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        nativeAdListener.onNativeAdLoad(arrayList);
                    }
                };
            }
            a(runnable);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            f fVar = f.f55939d;
            nativeAdListener.onError(fVar.n, fVar.o);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadRewardVideoAd(final KsScene ksScene, @NonNull final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        boolean a2 = ap.a().a(ksScene, "loadRewardVideoAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        ksScene.setAdStyle(2);
        a(new com.kwad.sdk.core.request.model.f(ksScene), new a() { // from class: com.kwad.sdk.core.request.d.14
            @Override // com.kwad.sdk.core.request.d.a
            public void a(final int i2, final String str) {
                d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("AdRequestManager", "loadRewardVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        rewardVideoAdListener.onError(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.request.d.a
            public void a(@NonNull final AdResultData adResultData) {
                d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.14.2
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
                int C = com.kwad.sdk.core.config.b.C();
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            KsScene ksScene2 = ksScene;
                            if (ksScene2 instanceof SceneImpl) {
                                adTemplate.mAdScene = (SceneImpl) ksScene2;
                            }
                        }
                        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
                        String a3 = com.kwad.sdk.core.response.a.a.a(j2);
                        if (com.kwad.sdk.core.response.a.a.as(j2)) {
                            arrayList.add(new com.kwad.sdk.reward.f(adTemplate));
                            z = true;
                        } else if (!TextUtils.isEmpty(a3)) {
                            if (C >= 0) {
                                if (C > 0 && !com.kwad.sdk.core.videocache.b.a.a(KsAdSDKImpl.get().getContext()).a(a3, C * 1024)) {
                                    z2 = true;
                                }
                                arrayList.add(new com.kwad.sdk.reward.f(adTemplate));
                                z2 = true;
                                z3 = true;
                            } else if (n.a(adTemplate)) {
                                arrayList.add(new com.kwad.sdk.reward.f(adTemplate));
                                z2 = true;
                                z3 = true;
                            } else {
                                z2 = true;
                            }
                        }
                    }
                }
                if (!z) {
                    if (!z2) {
                        int i2 = f.f55940e.n;
                        a(i2, f.f55940e.o + "(无视频资源)");
                        return;
                    } else if (!z3) {
                        f fVar = f.f55941f;
                        a(fVar.n, fVar.o);
                        return;
                    }
                }
                d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.14.3
                    @Override // java.lang.Runnable
                    public void run() {
                        rewardVideoAdListener.onRewardVideoAdLoad(arrayList);
                        d.b(adResultData, elapsedRealtime);
                    }
                });
            }
        }, a2);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadSplashScreenAd(@NonNull final KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        boolean a2 = ap.a().a(ksScene, "loadSplashScreenAd");
        ksScene.setAdStyle(4);
        List<String> c2 = SplashPreloadManager.b().c();
        ksScene.setAdNum(1);
        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenAd ");
        final b bVar = new b();
        com.kwad.sdk.core.report.d.a();
        a.postDelayed(new Runnable() { // from class: com.kwad.sdk.core.request.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.a(ksScene);
            }
        }, 15000L);
        final Runnable runnable = new Runnable() { // from class: com.kwad.sdk.core.request.d.10
            @Override // java.lang.Runnable
            public void run() {
                bVar.a = true;
                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                f fVar = f.f55942g;
                splashScreenAdListener2.onError(fVar.n, fVar.o);
                com.kwad.sdk.core.report.d.a(4);
            }
        };
        a.postDelayed(runnable, com.kwad.sdk.core.config.b.i());
        a(new com.kwad.sdk.core.request.model.f(ksScene), c2, true, a2, a(ksScene, false), new a() { // from class: com.kwad.sdk.core.request.d.11
            @Override // com.kwad.sdk.core.request.d.a
            public void a(final int i2, final String str) {
                if (!bVar.a) {
                    d.a.removeCallbacks(runnable);
                    d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                            splashScreenAdListener.onError(i2, str);
                            if (i2 == f.f55943h.n) {
                                com.kwad.sdk.core.report.d.a(0);
                            } else {
                                com.kwad.sdk.core.report.d.a(3);
                            }
                        }
                    });
                    return;
                }
                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
            }

            @Override // com.kwad.sdk.core.request.d.a
            public void a(@NonNull final AdResultData adResultData) {
                if (adResultData.adTemplateList.size() > 0) {
                    final com.kwad.sdk.splashscreen.c cVar = new com.kwad.sdk.splashscreen.c(ksScene, adResultData);
                    d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.11.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                splashScreenAdListener.onRequestResult(adResultData.adTemplateList.size());
                            } catch (Throwable th) {
                                com.kwad.sdk.core.d.a.b(th);
                            }
                        }
                    });
                    boolean a3 = SplashPreloadManager.b().a(adResultData);
                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onSuccess " + a3);
                    if (a3) {
                        if (bVar.a) {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        d.a.removeCallbacks(runnable);
                        d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.11.3
                            @Override // java.lang.Runnable
                            public void run() {
                                splashScreenAdListener.onSplashScreenAdLoad(cVar);
                            }
                        });
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd cache returned");
                        com.kwad.sdk.core.report.d.a(1);
                        return;
                    } else if (SplashPreloadManager.b().b(adResultData)) {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd image returned");
                        int a4 = SplashPreloadManager.b().a(adResultData, true);
                        if (bVar.a) {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        d.a.removeCallbacks(runnable);
                        if (a4 > 0) {
                            d.a.post(new Runnable() { // from class: com.kwad.sdk.core.request.d.11.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    splashScreenAdListener.onSplashScreenAdLoad(cVar);
                                }
                            });
                            com.kwad.sdk.core.report.d.a(2);
                            return;
                        }
                        f fVar = f.f55943h;
                        a(fVar.n, fVar.o);
                        return;
                    } else if (bVar.a) {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                        return;
                    } else {
                        d.a.removeCallbacks(runnable);
                        a(f.f55941f.n, "请求成功，但缓存未命中");
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd no cache returned");
                    }
                } else if (bVar.a) {
                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                    return;
                } else {
                    d.a.removeCallbacks(runnable);
                    f fVar2 = f.f55940e;
                    a(fVar2.n, fVar2.o);
                }
                com.kwad.sdk.core.report.d.a(3);
            }
        });
    }
}
