package com.kwad.components.core.c;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class d implements com.kwad.components.core.c.c {
    public static volatile d IS = null;
    public static boolean IT = true;
    @NonNull
    public SparseArray<com.kwad.components.core.c.c> IR;

    /* loaded from: classes10.dex */
    public interface c {
        void mv();
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "AdCacheFetcherHolder";
    }

    /* loaded from: classes10.dex */
    public static class f implements com.kwad.components.core.c.c {
        @Override // com.kwad.components.core.c.c
        public final String getName() {
            return "StrategyNetworkFirst";
        }

        /* renamed from: com.kwad.components.core.c.d$f$1  reason: invalid class name */
        /* loaded from: classes10.dex */
        public class AnonymousClass1 extends b {
            public final /* synthetic */ com.kwad.components.core.request.model.a bB;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(com.kwad.components.core.request.model.a aVar, com.kwad.components.core.request.model.a aVar2) {
                super(aVar);
                this.bB = aVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.components.core.c.d.b, com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public final void onError(@NonNull final com.kwad.components.core.request.a aVar, final int i, final String str) {
                GlobalThreadPools.Ey().submit(new Runnable() { // from class: com.kwad.components.core.c.d.f.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new c() { // from class: com.kwad.components.core.c.d.f.1.2.1
                            @Override // com.kwad.components.core.c.d.c
                            public final void mv() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                com.kwad.components.core.request.model.a.a(AnonymousClass1.this.bB, i, str, false);
                            }
                        });
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @WorkerThread
            public void a(SceneImpl sceneImpl, @Nullable AdResultData adResultData, int i, c cVar) {
                AdResultData d = d.d(this.bB);
                if (d == null || d.isAdResultDataEmpty()) {
                    if (cVar != null) {
                        cVar.mv();
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
                    com.kwad.components.core.request.model.a.a(this.bB, new AdResultData(adResultData, sceneImpl, subList), false);
                }
            }

            @Override // com.kwad.components.core.c.d.b
            public final boolean a(final com.kwad.components.core.request.model.a aVar, final AdResultData adResultData) {
                AdResultData d;
                final SceneImpl adScene = adResultData.getAdScene(aVar.getPosId());
                final int adNum = adScene.getAdNum();
                if (adResultData.isAdResultDataEmpty()) {
                    GlobalThreadPools.Ey().submit(new Runnable() { // from class: com.kwad.components.core.c.d.f.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1.this.a(adScene, adResultData, adNum, new c() { // from class: com.kwad.components.core.c.d.f.1.1.1
                                @Override // com.kwad.components.core.c.d.c
                                public final void mv() {
                                    RunnableC06361 runnableC06361 = RunnableC06361.this;
                                    com.kwad.components.core.request.model.a.a(aVar, adResultData, false);
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
                        com.kwad.components.core.request.model.a.a(aVar, new AdResultData(adResultData, adScene, subList), true);
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // com.kwad.components.core.c.c
        public final void c(com.kwad.components.core.request.model.a aVar) {
            d.a(aVar, new AnonymousClass1(aVar, aVar));
        }
    }

    /* loaded from: classes10.dex */
    public static class a implements Comparator<AdTemplate> {
        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static int a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            int ed = com.kwad.sdk.core.response.b.e.ed(adTemplate2) - com.kwad.sdk.core.response.b.e.ed(adTemplate);
            if (ed != 0) {
                return ed;
            }
            if (adTemplate.fromCache && adTemplate2.fromCache) {
                return 0;
            }
            if (adTemplate.fromCache) {
                return 1;
            }
            return -1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return a(adTemplate, adTemplate2);
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends o<com.kwad.components.core.request.a, AdResultData> {
        public com.kwad.components.core.request.model.a IY;

        public boolean a(com.kwad.components.core.request.model.a aVar, AdResultData adResultData) {
            return false;
        }

        public b(com.kwad.components.core.request.model.a aVar) {
            this.IY = aVar;
        }

        @WorkerThread
        public static void h(AdResultData adResultData) {
            List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
            com.kwad.components.core.c.a mn = com.kwad.components.core.c.a.mn();
            if (mn != null && proceedTemplateList.size() > 0) {
                com.kwad.components.core.c.e s = com.kwad.components.core.c.e.s(adResultData.getPosId());
                mn.mo();
                mn.i(h.a(s, adResultData));
                mn.a(com.kwad.components.core.c.e.aj(proceedTemplateList.get(0)));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.components.core.request.a aVar, @NonNull final AdResultData adResultData) {
            super.onSuccess(aVar, adResultData);
            GlobalThreadPools.Ey().submit(new Runnable() { // from class: com.kwad.components.core.c.d.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b bVar = b.this;
                    b.h(adResultData);
                }
            });
            if (!a(this.IY, adResultData)) {
                com.kwad.components.core.request.model.a.a(this.IY, adResultData, false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onError(@NonNull com.kwad.components.core.request.a aVar, int i, String str) {
            super.onError(aVar, i, str);
            com.kwad.components.core.request.model.a.a(this.IY, i, str, false);
        }
    }

    public d() {
        SparseArray<com.kwad.components.core.c.c> sparseArray = new SparseArray<>();
        this.IR = sparseArray;
        sparseArray.append(1, new f());
        this.IR.append(2, new e());
        this.IR.append(0, new C0635d());
    }

    public static d mq() {
        if (IS == null) {
            synchronized (d.class) {
                if (IS == null) {
                    IS = new d();
                }
            }
        }
        return IS;
    }

    public static boolean mr() {
        if (!IT) {
            return false;
        }
        try {
            Class.forName("com.kwad.devTools.PosConfigFetcher");
            IT = true;
        } catch (ClassNotFoundException unused) {
            IT = false;
        }
        return IT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.c.c ms() {
        return this.IR.get(0);
    }

    /* renamed from: com.kwad.components.core.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0635d implements com.kwad.components.core.c.c {
        @Override // com.kwad.components.core.c.c
        public final String getName() {
            return "OnlyNetworkFetcher";
        }

        @Override // com.kwad.components.core.c.c
        public final void c(com.kwad.components.core.request.model.a aVar) {
            d.a(aVar, new b(aVar));
        }
    }

    /* loaded from: classes10.dex */
    public static class e implements com.kwad.components.core.c.c {
        @Override // com.kwad.components.core.c.c
        public final String getName() {
            return "StrategyLocalCacheFirst";
        }

        @Override // com.kwad.components.core.c.c
        public final void c(final com.kwad.components.core.request.model.a aVar) {
            GlobalThreadPools.Ey().submit(new Runnable() { // from class: com.kwad.components.core.c.d.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    AdResultData d = d.d(aVar);
                    if (d != null && !d.isAdResultDataEmpty()) {
                        com.kwad.components.core.request.model.a.a(aVar, d, true);
                        return;
                    }
                    com.kwad.components.core.request.model.a aVar2 = aVar;
                    d.a(aVar2, new b(aVar2));
                }
            });
        }
    }

    public static <T extends com.kwad.components.core.request.a> T a(com.kwad.sdk.g.c<T> cVar) {
        return cVar.get();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kwad.components.core.c.d.2.run():void] */
    public static /* synthetic */ com.kwad.components.core.c.c b(d dVar) {
        return dVar.ms();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kwad.components.core.c.d.2.run():void] */
    public static /* synthetic */ SparseArray c(d dVar) {
        return dVar.IR;
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
            long dZ = com.kwad.sdk.core.response.b.e.dZ(adTemplate);
            if (!hashSet.contains(Long.valueOf(dZ))) {
                hashSet.add(Long.valueOf(dZ));
                arrayList2.add(adTemplate);
            }
        }
        return arrayList2;
    }

    @Nullable
    @WorkerThread
    public static AdResultData d(com.kwad.components.core.request.model.a aVar) {
        com.kwad.components.core.c.a mn = com.kwad.components.core.c.a.mn();
        if (mn == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<h> a2 = mn.a(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, com.kwad.components.core.c.e.s(aVar.getPosId()).my());
        if (com.kwad.sdk.core.config.d.Bo()) {
            j(a2);
        }
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        Collections.sort(a2);
        return h.k(a2.subList(0, Math.min(a2.size(), adNum)));
    }

    public static void a(final com.kwad.components.core.request.model.a aVar, @NonNull o<com.kwad.components.core.request.a, AdResultData> oVar) {
        new com.kwad.components.core.m.a(aVar.Mp) { // from class: com.kwad.components.core.c.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: Z */
            public final AdResultData parseData(String str) {
                com.kwad.sdk.commercial.e.c.a(com.kwad.sdk.commercial.c.bT(aVar.getAdStyle()), false);
                return AdResultData.createFromResponseJson(str, aVar.Mp.adScene);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: mt */
            public final com.kwad.components.core.request.a createRequest() {
                return d.a(new com.kwad.sdk.g.c<com.kwad.components.core.request.a>() { // from class: com.kwad.components.core.c.d.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.c
                    /* renamed from: mu */
                    public com.kwad.components.core.request.a get() {
                        if (aVar.getAdStyle() == 4) {
                            aVar.Rn = ((com.kwad.components.ad.b.h) com.kwad.sdk.components.c.f(com.kwad.components.ad.b.h.class)).R();
                        }
                        return new com.kwad.components.core.request.a(aVar);
                    }
                });
            }
        }.request(oVar);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kwad.components.core.c.d.2.run():void] */
    public static /* synthetic */ boolean a(d dVar) {
        return mr();
    }

    @Override // com.kwad.components.core.c.c
    public final void c(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.Ey().submit(new Runnable() { // from class: com.kwad.components.core.c.d.2
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.components.core.c.d.a(com.kwad.components.core.c.d):boolean
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // java.lang.Runnable
            public final void run() {
                /*
                    r2 = this;
                    com.kwad.components.core.request.model.a r0 = r2
                    long r0 = r0.getPosId()
                    com.kwad.components.core.c.e r0 = com.kwad.components.core.c.e.s(r0)
                    com.kwad.components.core.c.d$2$1 r1 = new com.kwad.components.core.c.d$2$1
                    r1.<init>()
                    com.kwad.sdk.utils.bn.runOnUiThread(r1)
                    com.kwad.components.core.c.d r1 = com.kwad.components.core.c.d.this
                    boolean r1 = com.kwad.components.core.c.d.a(r1)
                    if (r1 != 0) goto L38
                    boolean r1 = r0.isDefault()
                    if (r1 != 0) goto L27
                    boolean r1 = r0.isEnable()
                    if (r1 != 0) goto L27
                    goto L38
                L27:
                    com.kwad.components.core.c.d r1 = com.kwad.components.core.c.d.this
                    android.util.SparseArray r1 = com.kwad.components.core.c.d.c(r1)
                    int r0 = r0.mx()
                    java.lang.Object r0 = r1.get(r0)
                    com.kwad.components.core.c.c r0 = (com.kwad.components.core.c.c) r0
                    goto L3e
                L38:
                    com.kwad.components.core.c.d r0 = com.kwad.components.core.c.d.this
                    com.kwad.components.core.c.c r0 = com.kwad.components.core.c.d.b(r0)
                L3e:
                    if (r0 != 0) goto L4d
                    com.kwad.components.core.c.d r0 = com.kwad.components.core.c.d.this
                    android.util.SparseArray r0 = com.kwad.components.core.c.d.c(r0)
                    r1 = 1
                    java.lang.Object r0 = r0.get(r1)
                    com.kwad.components.core.c.c r0 = (com.kwad.components.core.c.c) r0
                L4d:
                    com.kwad.components.core.request.model.a r1 = r2
                    com.kwad.components.core.request.i r1 = r1.qk()
                    if (r1 == 0) goto L5b
                    r0.getName()
                    r1.bK()
                L5b:
                    com.kwad.components.core.request.model.a r1 = r2
                    r0.c(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.c.d.AnonymousClass2.run():void");
            }
        });
    }

    public static void j(List<h> list) {
        if (list == null) {
            return;
        }
        Iterator<h> it = list.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (g.mC().a(next)) {
                com.kwad.sdk.core.e.c.d("AdCacheFetcherHolder", "filterByMemCached contain: " + next.mJ());
                it.remove();
            }
        }
    }
}
