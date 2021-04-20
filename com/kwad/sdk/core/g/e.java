package com.kwad.sdk.core.g;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsContentAllianceAd;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFeedPage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.FeedType;
import com.kwad.sdk.feed.b;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e implements KsLoadManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f33969a = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.sdk.core.g.e$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass2 implements a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ KsLoadManager.FeedAdListener f34013a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ KsScene f34014b;

        public AnonymousClass2(KsLoadManager.FeedAdListener feedAdListener, KsScene ksScene) {
            this.f34013a = feedAdListener;
            this.f34014b = ksScene;
        }

        @Override // com.kwad.sdk.core.g.e.a
        public void a(final int i, final String str) {
            e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.2.1
                @Override // java.lang.Runnable
                public void run() {
                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                    AnonymousClass2.this.f34013a.onError(i, str);
                }
            });
        }

        @Override // com.kwad.sdk.core.g.e.a
        public void a(@NonNull AdResultData adResultData) {
            final ArrayList arrayList = new ArrayList();
            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadFeedAd onSuccess:" + adResultData.adTemplateList.size());
            String str = null;
            for (AdTemplate adTemplate : adResultData.adTemplateList) {
                if (adTemplate != null) {
                    AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
                    if (FeedType.checkTypeValid(adTemplate)) {
                        arrayList.add(new com.kwad.sdk.feed.b(adTemplate, this.f34014b.getWidth(), true));
                    } else {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.L(j)), FeedType.fromInt(adTemplate.type));
                    }
                }
            }
            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadFeedAd onSuccess:" + arrayList.size());
            if (!arrayList.isEmpty()) {
                e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int size = arrayList.size();
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "mHandler " + size);
                        if (size == 0) {
                            AnonymousClass2.this.f34013a.onFeedAdLoad(arrayList);
                            return;
                        }
                        final b.a aVar = new b.a(size);
                        for (KsFeedAd ksFeedAd : arrayList) {
                            final com.kwad.sdk.feed.b bVar = (com.kwad.sdk.feed.b) ksFeedAd;
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "ksFeedAd " + ksFeedAd);
                            bVar.a(new b.InterfaceC0418b() { // from class: com.kwad.sdk.core.g.e.2.2.1
                                @Override // com.kwad.sdk.feed.b.InterfaceC0418b
                                public void a() {
                                    com.kwad.sdk.core.d.a.a("AdRequestManager", "ksFeedAd onLoadFinished" + bVar + " cnt: " + aVar.a());
                                    if (aVar.b()) {
                                        RunnableC03982 runnableC03982 = RunnableC03982.this;
                                        AnonymousClass2.this.f34013a.onFeedAdLoad(arrayList);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            int i = com.kwad.sdk.core.network.f.f34160c.k;
            a(i, com.kwad.sdk.core.network.f.f34160c.l + str);
            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadFeedAd onError");
        }
    }

    /* loaded from: classes6.dex */
    public interface a {
        @WorkerThread
        void a(int i, String str);

        @WorkerThread
        void a(@NonNull AdResultData adResultData);
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f34053a;

        public b() {
            this.f34053a = false;
        }
    }

    public static void a(com.kwad.sdk.core.g.a.f fVar, @NonNull a aVar) {
        a(fVar, null, false, aVar);
    }

    public static void a(final com.kwad.sdk.core.g.a.f fVar, final List<String> list, final boolean z, @NonNull final a aVar) {
        new com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.a, AdResultData>() { // from class: com.kwad.sdk.core.g.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(com.kwad.sdk.core.g.a.f.this.f33940a);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public com.kwad.sdk.core.g.a b() {
                return new com.kwad.sdk.core.g.a(com.kwad.sdk.core.g.a.f.this, list, z, null);
            }
        }.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.g.a, AdResultData>() { // from class: com.kwad.sdk.core.g.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.a aVar2, int i, String str) {
                a.this.a(i, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.a aVar2, @NonNull AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty()) {
                    a.this.a(adResultData);
                    return;
                }
                a aVar3 = a.this;
                com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f34160c;
                aVar3.a(fVar2.k, fVar2.l);
            }
        });
    }

    public static void b(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.adTemplateList.size() <= 0 || (adTemplate = adResultData.adTemplateList.get(0)) == null) {
            return;
        }
        com.kwad.sdk.core.report.e.d(adTemplate, elapsedRealtime - j);
    }

    public void a(KsScene ksScene) {
        com.kwad.sdk.core.report.e.c();
        ksScene.setAdStyle(4);
        ksScene.setAdNum(5);
        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache ");
        a(new com.kwad.sdk.core.g.a.f(ksScene), new ArrayList(), false, new a() { // from class: com.kwad.sdk.core.g.e.9
            @Override // com.kwad.sdk.core.g.e.a
            public void a(int i, String str) {
                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull AdResultData adResultData) {
                if (adResultData.adTemplateList.size() > 0) {
                    int a2 = SplashPreloadManager.b().a(adResultData, false);
                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenCache onSuccess:" + adResultData.adTemplateList.size() + " saved " + a2);
                    com.kwad.sdk.core.report.e.b(adResultData.adTemplateList.size());
                }
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        ksScene.setAdStyle(1);
        a(new com.kwad.sdk.core.g.a.f(ksScene), new AnonymousClass2(feedAdListener, ksScene));
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentAllianceAd loadContentAllianceAd(KsScene ksScene) {
        if (ksScene == null) {
            return null;
        }
        return new com.kwad.sdk.contentalliance.e(ksScene);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentPage loadContentPage(KsScene ksScene) {
        if (ksScene == null) {
            return null;
        }
        return new com.kwad.sdk.contentalliance.f(ksScene);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentPage loadContentPageByPush(KsScene ksScene, String str) {
        if (ksScene == null) {
            return null;
        }
        com.kwad.sdk.contentalliance.f fVar = new com.kwad.sdk.contentalliance.f(ksScene);
        com.kwad.sdk.core.report.e.a(str);
        fVar.a(str);
        return fVar;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        ksScene.setAdStyle(6);
        a(new com.kwad.sdk.core.g.a.f(ksScene), new a() { // from class: com.kwad.sdk.core.g.e.3
            @Override // com.kwad.sdk.core.g.e.a
            public void a(final int i, final String str) {
                e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        drawAdListener.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.j(adTemplate)))) {
                        arrayList.add(new com.kwad.sdk.draw.b(adTemplate));
                    }
                }
                if (!arrayList.isEmpty()) {
                    e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            drawAdListener.onDrawAdLoad(arrayList);
                        }
                    });
                    return;
                }
                int i = com.kwad.sdk.core.network.f.f34160c.k;
                a(i, com.kwad.sdk.core.network.f.f34160c.l + "(无视频资源)");
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadEntryElement(KsScene ksScene, @NonNull KsLoadManager.EntryElementListener<KsEntryElement> entryElementListener) {
        loadEntryElement(ksScene, entryElementListener, false);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadEntryElement(KsScene ksScene, @NonNull final KsLoadManager.EntryElementListener<KsEntryElement> entryElementListener, boolean z) {
        final h.a aVar = new h.a();
        aVar.f34074a.add(new com.kwad.sdk.core.g.a.f(ksScene));
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        cVar.f33926a = 1;
        cVar.f33927b = z ? 1 : 0;
        aVar.f34075b = cVar;
        i.a(aVar, new a() { // from class: com.kwad.sdk.core.g.e.1
            @Override // com.kwad.sdk.core.g.e.a
            public void a(final int i, final String str) {
                e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadEntryElement onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        entryElementListener.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull final AdResultData adResultData) {
                if (adResultData.entryInfo != null) {
                    final com.kwad.sdk.entry.a aVar2 = new com.kwad.sdk.entry.a();
                    aVar2.a(aVar);
                    e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar2.a(adResultData.entryInfo);
                            entryElementListener.onEntryLoad(aVar2);
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFeedAd(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener) {
        ksScene.setAdStyle(1);
        a(new com.kwad.sdk.core.g.a.f(ksScene), new a() { // from class: com.kwad.sdk.core.g.e.13
            @Override // com.kwad.sdk.core.g.e.a
            public void a(final int i, final String str) {
                e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        feedAdListener.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                String str = null;
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
                        if (FeedType.checkTypeValid(adTemplate)) {
                            arrayList.add(new com.kwad.sdk.feed.b(adTemplate));
                        } else {
                            str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.L(j)), FeedType.fromInt(adTemplate.type));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.13.2
                        @Override // java.lang.Runnable
                        public void run() {
                            feedAdListener.onFeedAdLoad(arrayList);
                        }
                    });
                    return;
                }
                int i = com.kwad.sdk.core.network.f.f34160c.k;
                a(i, com.kwad.sdk.core.network.f.f34160c.l + str);
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsFeedPage loadFeedPage(KsScene ksScene) {
        if (ksScene == null) {
            return null;
        }
        return new com.kwad.sdk.feed.a.e(ksScene);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFullScreenVideoAd(final KsScene ksScene, @NonNull final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        ksScene.setAdStyle(3);
        a(new com.kwad.sdk.core.g.a.f(ksScene), new a() { // from class: com.kwad.sdk.core.g.e.10
            @Override // com.kwad.sdk.core.g.e.a
            public void a(final int i, final String str) {
                e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadFullScreenVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        fullScreenVideoAdListener.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull final AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                int ae = com.kwad.sdk.core.config.c.ae();
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
                        String a2 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.j(adTemplate));
                        if (!TextUtils.isEmpty(a2)) {
                            if (ae >= 0) {
                                if (ae > 0 && !com.kwad.sdk.core.videocache.c.a.a(KsAdSDKImpl.get().getContext()).a(a2, ae * 1024)) {
                                    z = true;
                                }
                                arrayList.add(new com.kwad.sdk.fullscreen.b(adTemplate));
                                z = true;
                                z2 = true;
                            } else if (com.kwad.sdk.reward.f.a(adTemplate)) {
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
                        e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.10.2
                            @Override // java.lang.Runnable
                            public void run() {
                                fullScreenVideoAdListener.onFullScreenVideoAdLoad(arrayList);
                                e.b(adResultData, elapsedRealtime);
                            }
                        });
                        return;
                    }
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f34161d;
                    a(fVar.k, fVar.l);
                    return;
                }
                int i = com.kwad.sdk.core.network.f.f34160c.k;
                a(i, com.kwad.sdk.core.network.f.f34160c.l + "(无视频资源)");
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(KsScene ksScene, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        ksScene.setAdStyle(1);
        a(new com.kwad.sdk.core.g.a.f(ksScene), new a() { // from class: com.kwad.sdk.core.g.e.12
            @Override // com.kwad.sdk.core.g.e.a
            public void a(final int i, final String str) {
                e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        nativeAdListener.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        arrayList.add(new com.kwad.sdk.a.a(adTemplate));
                    }
                }
                e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.12.2
                    @Override // java.lang.Runnable
                    public void run() {
                        nativeAdListener.onNativeAdLoad(arrayList);
                    }
                });
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadRewardVideoAd(final KsScene ksScene, @NonNull final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        ksScene.setAdStyle(2);
        a(new com.kwad.sdk.core.g.a.f(ksScene), new a() { // from class: com.kwad.sdk.core.g.e.11
            @Override // com.kwad.sdk.core.g.e.a
            public void a(final int i, final String str) {
                e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadRewardVideoAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        rewardVideoAdListener.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull final AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                int ae = com.kwad.sdk.core.config.c.ae();
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
                        String a2 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.j(adTemplate));
                        if (!TextUtils.isEmpty(a2)) {
                            if (ae >= 0) {
                                if (ae > 0 && !com.kwad.sdk.core.videocache.c.a.a(KsAdSDKImpl.get().getContext()).a(a2, ae * 1024)) {
                                    z = true;
                                }
                                arrayList.add(new com.kwad.sdk.reward.c(adTemplate));
                                z = true;
                                z2 = true;
                            } else if (com.kwad.sdk.reward.f.a(adTemplate)) {
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
                        e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.11.2
                            @Override // java.lang.Runnable
                            public void run() {
                                rewardVideoAdListener.onRewardVideoAdLoad(arrayList);
                                e.b(adResultData, elapsedRealtime);
                            }
                        });
                        return;
                    }
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f34161d;
                    a(fVar.k, fVar.l);
                    return;
                }
                int i = com.kwad.sdk.core.network.f.f34160c.k;
                a(i, com.kwad.sdk.core.network.f.f34160c.l + "(无视频资源)");
            }
        });
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadSplashScreenAd(@NonNull final KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        ksScene.setAdStyle(4);
        List<String> c2 = SplashPreloadManager.b().c();
        ksScene.setAdNum(c2.size() > 0 ? 1 : 5);
        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashScreenAd ");
        final b bVar = new b();
        com.kwad.sdk.core.report.e.b();
        f33969a.postDelayed(new Runnable() { // from class: com.kwad.sdk.core.g.e.6
            @Override // java.lang.Runnable
            public void run() {
                e.this.a(ksScene);
            }
        }, 15000L);
        final Runnable runnable = new Runnable() { // from class: com.kwad.sdk.core.g.e.7
            @Override // java.lang.Runnable
            public void run() {
                bVar.f34053a = true;
                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f34162e;
                splashScreenAdListener2.onError(fVar.k, fVar.l);
                com.kwad.sdk.core.report.e.a(4);
            }
        };
        f33969a.postDelayed(runnable, com.kwad.sdk.core.config.c.s());
        a(new com.kwad.sdk.core.g.a.f(ksScene), c2, true, new a() { // from class: com.kwad.sdk.core.g.e.8
            @Override // com.kwad.sdk.core.g.e.a
            public void a(final int i, final String str) {
                if (!bVar.f34053a) {
                    e.f33969a.removeCallbacks(runnable);
                    e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                            splashScreenAdListener.onError(i, str);
                            if (i == com.kwad.sdk.core.network.f.f34163f.k) {
                                com.kwad.sdk.core.report.e.a(0);
                            } else {
                                com.kwad.sdk.core.report.e.a(3);
                            }
                        }
                    });
                    return;
                }
                com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull AdResultData adResultData) {
                if (adResultData.adTemplateList.size() > 0) {
                    final com.kwad.sdk.splashscreen.a aVar = new com.kwad.sdk.splashscreen.a(ksScene, adResultData);
                    boolean a2 = SplashPreloadManager.b().a(adResultData);
                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd onSuccess " + a2);
                    if (a2) {
                        if (bVar.f34053a) {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        e.f33969a.removeCallbacks(runnable);
                        e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.8.2
                            @Override // java.lang.Runnable
                            public void run() {
                                splashScreenAdListener.onSplashScreenAdLoad(aVar);
                            }
                        });
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd cache returned");
                        com.kwad.sdk.core.report.e.a(1);
                        return;
                    } else if (SplashPreloadManager.b().b(adResultData)) {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd image returned");
                        int a3 = SplashPreloadManager.b().a(adResultData, true);
                        if (bVar.f34053a) {
                            com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        e.f33969a.removeCallbacks(runnable);
                        if (a3 > 0) {
                            e.f33969a.post(new Runnable() { // from class: com.kwad.sdk.core.g.e.8.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    splashScreenAdListener.onSplashScreenAdLoad(aVar);
                                }
                            });
                            com.kwad.sdk.core.report.e.a(2);
                            return;
                        }
                        com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f34163f;
                        a(fVar.k, fVar.l);
                        return;
                    } else if (bVar.f34053a) {
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                        return;
                    } else {
                        e.f33969a.removeCallbacks(runnable);
                        a(com.kwad.sdk.core.network.f.f34161d.k, "请求成功，但缓存未命中");
                        com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd no cache returned");
                    }
                } else if (bVar.f34053a) {
                    com.kwad.sdk.core.d.a.a("AdRequestManager", "loadSplashAd isTimeOut return ");
                    return;
                } else {
                    e.f33969a.removeCallbacks(runnable);
                    com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f34160c;
                    a(fVar2.k, fVar2.l);
                }
                com.kwad.sdk.core.report.e.a(3);
            }
        });
    }
}
