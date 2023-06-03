package com.kwad.components.core.a;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements com.kwad.components.core.a.c {
    public static volatile d CY;
    @NonNull
    public SparseArray<com.kwad.components.core.a.c> CX;

    /* loaded from: classes9.dex */
    public static class a implements Comparator<AdTemplate> {
        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static int a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            int cf = com.kwad.sdk.core.response.a.d.cf(adTemplate2) - com.kwad.sdk.core.response.a.d.cf(adTemplate);
            if (cf != 0) {
                return cf;
            }
            if (adTemplate.fromCache && adTemplate2.fromCache) {
                return 0;
            }
            return adTemplate.fromCache ? 1 : -1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return a(adTemplate, adTemplate2);
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends n<com.kwad.components.core.k.a, AdResultData> {
        public com.kwad.components.core.k.kwai.a Dd;

        public b(com.kwad.components.core.k.kwai.a aVar) {
            this.Dd = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.components.core.k.a aVar, @NonNull final AdResultData adResultData) {
            super.onSuccess(aVar, adResultData);
            com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.core.a.d.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b bVar = b.this;
                    b.c(adResultData);
                }
            });
            if (a(this.Dd, adResultData)) {
                return;
            }
            com.kwad.components.core.k.kwai.a.a(this.Dd, adResultData, false);
        }

        @WorkerThread
        public static void c(AdResultData adResultData) {
            List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
            com.kwad.components.core.a.a lP = com.kwad.components.core.a.a.lP();
            if (lP == null || proceedTemplateList.size() <= 0) {
                return;
            }
            com.kwad.components.core.a.e k = com.kwad.components.core.a.e.k(adResultData.getPosId());
            lP.lQ();
            lP.h(g.a(k, adResultData));
            lP.a(com.kwad.components.core.a.e.H(proceedTemplateList.get(0)));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onError(@NonNull com.kwad.components.core.k.a aVar, int i, String str) {
            super.onError(aVar, i, str);
            com.kwad.components.core.k.kwai.a.a(this.Dd, i, str, false);
        }

        public boolean a(com.kwad.components.core.k.kwai.a aVar, AdResultData adResultData) {
            return false;
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void lV();
    }

    /* renamed from: com.kwad.components.core.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0624d implements com.kwad.components.core.a.c {
        @Override // com.kwad.components.core.a.c
        public final void c(com.kwad.components.core.k.kwai.a aVar) {
            d.a(aVar, new b(aVar));
        }
    }

    /* loaded from: classes9.dex */
    public static class e implements com.kwad.components.core.a.c {
        @Override // com.kwad.components.core.a.c
        public final void c(final com.kwad.components.core.k.kwai.a aVar) {
            com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.core.a.d.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    AdResultData d = d.d(aVar);
                    if (d != null && !d.isAdResultDataEmpty()) {
                        com.kwad.components.core.k.kwai.a.a(aVar, d, true);
                        return;
                    }
                    com.kwad.components.core.k.kwai.a aVar2 = aVar;
                    d.a(aVar2, new b(aVar2));
                }
            });
        }
    }

    /* loaded from: classes9.dex */
    public static class f implements com.kwad.components.core.a.c {

        /* renamed from: com.kwad.components.core.a.d$f$1  reason: invalid class name */
        /* loaded from: classes9.dex */
        public class AnonymousClass1 extends b {
            public final /* synthetic */ com.kwad.components.core.k.kwai.a aB;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(com.kwad.components.core.k.kwai.a aVar, com.kwad.components.core.k.kwai.a aVar2) {
                super(aVar);
                this.aB = aVar2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @WorkerThread
            public void a(SceneImpl sceneImpl, @Nullable AdResultData adResultData, int i, c cVar) {
                AdResultData d = d.d(this.aB);
                if (d == null || d.isAdResultDataEmpty()) {
                    if (cVar != null) {
                        cVar.lV();
                        return;
                    }
                    return;
                }
                List a = d.a(d.getProceedTemplateList());
                List subList = a.subList(0, Math.min(i, a.size()));
                if (subList.size() > 0) {
                    if (adResultData == null) {
                        adResultData = new AdResultData(sceneImpl);
                    }
                    com.kwad.components.core.k.kwai.a.a(this.aB, new AdResultData(adResultData, sceneImpl, subList), false);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.components.core.a.d.b, com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public final void onError(@NonNull final com.kwad.components.core.k.a aVar, final int i, final String str) {
                com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.core.a.d.f.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new c() { // from class: com.kwad.components.core.a.d.f.1.2.1
                            @Override // com.kwad.components.core.a.d.c
                            public final void lV() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                com.kwad.components.core.k.kwai.a.a(AnonymousClass1.this.aB, i, str, false);
                            }
                        });
                    }
                });
            }

            @Override // com.kwad.components.core.a.d.b
            public final boolean a(final com.kwad.components.core.k.kwai.a aVar, final AdResultData adResultData) {
                AdResultData d;
                final SceneImpl adScene = adResultData.getAdScene(aVar.getPosId());
                final int adNum = adScene.getAdNum();
                if (adResultData.isAdResultDataEmpty()) {
                    com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.core.a.d.f.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1.this.a(adScene, adResultData, adNum, new c() { // from class: com.kwad.components.core.a.d.f.1.1.1
                                @Override // com.kwad.components.core.a.d.c
                                public final void lV() {
                                    RunnableC06251 runnableC06251 = RunnableC06251.this;
                                    com.kwad.components.core.k.kwai.a.a(aVar, adResultData, false);
                                }
                            });
                        }
                    });
                    return true;
                }
                if (adResultData.isBidding() && (d = d.d(aVar)) != null && !d.isAdResultDataEmpty()) {
                    List a = d.a(d.getProceedTemplateList(), adResultData.getProceedTemplateList());
                    List subList = a.subList(0, Math.min(adNum, a.size()));
                    if (subList != null && subList.size() > 0) {
                        com.kwad.components.core.k.kwai.a.a(aVar, new AdResultData(adResultData, adScene, subList), true);
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // com.kwad.components.core.a.c
        public final void c(com.kwad.components.core.k.kwai.a aVar) {
            d.a(aVar, new AnonymousClass1(aVar, aVar));
        }
    }

    public d() {
        SparseArray<com.kwad.components.core.a.c> sparseArray = new SparseArray<>();
        this.CX = sparseArray;
        sparseArray.append(1, new f());
        this.CX.append(2, new e());
        this.CX.append(0, new C0624d());
    }

    public static <T extends com.kwad.components.core.k.a> T a(com.kwad.sdk.d.b<T> bVar) {
        return bVar.get();
    }

    public static List<AdTemplate> a(List<AdTemplate>... listArr) {
        if (listArr == null) {
            return null;
        }
        ArrayList<AdTemplate> arrayList = new ArrayList();
        for (List<AdTemplate> list : listArr) {
            arrayList.addAll(list);
        }
        Collections.sort(arrayList, new a((byte) 0));
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AdTemplate adTemplate : arrayList) {
            long ca = com.kwad.sdk.core.response.a.d.ca(adTemplate);
            if (!hashSet.contains(Long.valueOf(ca))) {
                hashSet.add(Long.valueOf(ca));
                arrayList2.add(adTemplate);
            }
        }
        return arrayList2;
    }

    public static void a(final com.kwad.components.core.k.kwai.a aVar, @NonNull n<com.kwad.components.core.k.a, AdResultData> nVar) {
        new com.kwad.components.core.h.a(aVar.EI) { // from class: com.kwad.components.core.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.components.core.h.a, com.kwad.sdk.core.network.m
            @NonNull
            /* renamed from: ah */
            public final AdResultData parseData(String str) {
                return AdResultData.createFromResponseJson(str, aVar.EI.HS);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.components.core.h.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: fe */
            public final com.kwad.components.core.k.a createRequest() {
                return d.a(new com.kwad.sdk.d.b<com.kwad.components.core.k.a>() { // from class: com.kwad.components.core.a.d.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.d.b
                    /* renamed from: lU */
                    public com.kwad.components.core.k.a get() {
                        if (aVar.getAdStyle() == 4) {
                            aVar.HO = SplashPreloadManager.qD().qE();
                        }
                        return new com.kwad.components.core.k.a(aVar);
                    }
                });
            }
        }.request(nVar);
    }

    @Nullable
    @WorkerThread
    public static AdResultData d(com.kwad.components.core.k.kwai.a aVar) {
        com.kwad.components.core.a.a lP = com.kwad.components.core.a.a.lP();
        if (lP == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<g> a2 = lP.a(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, com.kwad.components.core.a.e.k(aVar.getPosId()).lY());
        if (com.kwad.sdk.core.config.d.sw()) {
            i(a2);
        }
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        Collections.sort(a2);
        return g.j(a2.subList(0, Math.min(a2.size(), adNum)));
    }

    public static void i(List<g> list) {
        if (list == null) {
            return;
        }
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (com.kwad.components.core.a.f.mb().a(next)) {
                com.kwad.sdk.core.e.b.d("AdCacheFetcherHolder", "filterByMemCached contain: " + next.mi());
                it.remove();
            }
        }
    }

    public static d lS() {
        if (CY == null) {
            synchronized (d.class) {
                if (CY == null) {
                    CY = new d();
                }
            }
        }
        return CY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.a.c lT() {
        return this.CX.get(0);
    }

    @Override // com.kwad.components.core.a.c
    public final void c(final com.kwad.components.core.k.kwai.a aVar) {
        com.kwad.sdk.utils.g.runOnDefaultExecutor(new Runnable() { // from class: com.kwad.components.core.a.d.2
            @Override // java.lang.Runnable
            public final void run() {
                final com.kwad.components.core.a.e k = com.kwad.components.core.a.e.k(aVar.getPosId());
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.a.d.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.components.core.a.b.b(k);
                    }
                });
                com.kwad.components.core.a.c lT = (k.isDefault() || k.isEnable()) ? (com.kwad.components.core.a.c) d.this.CX.get(k.lX()) : d.this.lT();
                if (lT == null) {
                    lT = (com.kwad.components.core.a.c) d.this.CX.get(1);
                }
                lT.c(aVar);
            }
        });
    }
}
