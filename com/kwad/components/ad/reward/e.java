package com.kwad.components.ad.reward;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class e {
    public static int lF = 12;
    public static int lG = 4;

    /* loaded from: classes10.dex */
    public interface a {
        void C(String str);

        void e(@Nullable List<com.kwad.components.ad.reward.c.b> list);

        void onRequestResult(int i);
    }

    public static List<com.kwad.components.ad.reward.c.b> a(List<AdTemplate> list, int i) {
        ArrayList arrayList = new ArrayList();
        for (AdTemplate adTemplate : list) {
            arrayList.add(new com.kwad.components.ad.reward.c.b(adTemplate, i));
        }
        return arrayList;
    }

    public static void a(int i, int i2, @NonNull SceneImpl sceneImpl, final int i3, final a aVar) {
        SceneImpl m172clone = sceneImpl.m172clone();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        m172clone.setAdStyle(i);
        m172clone.setAdNum(i2);
        a(new com.kwad.components.core.k.kwai.b(m172clone), null, false, true, new com.kwad.components.core.k.f() { // from class: com.kwad.components.ad.reward.e.1
            @Override // com.kwad.components.core.k.g
            public final void a(@NonNull final AdResultData adResultData) {
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            a.this.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }
                });
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.e(e.a(adResultData.getAdTemplateList(), i3));
                        e.a(adResultData, elapsedRealtime);
                    }
                });
            }

            @Override // com.kwad.components.core.k.g
            public final void onError(final int i4, final String str) {
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.b.e("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i4), str));
                        a.this.C(str);
                    }
                });
            }
        }, false);
    }

    public static void a(final com.kwad.components.core.k.kwai.b bVar, List<String> list, boolean z, boolean z2, @NonNull final com.kwad.components.core.k.f fVar, boolean z3) {
        new com.kwad.components.core.h.a(bVar) { // from class: com.kwad.components.ad.reward.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.components.core.h.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: fe */
            public final com.kwad.components.core.k.a createRequest() {
                com.kwad.components.core.k.a aVar = new com.kwad.components.core.k.a(bVar, r3, r4, null);
                aVar.ao(r5 ? 1 : 0);
                return aVar;
            }
        }.request(new com.kwad.sdk.core.network.n<com.kwad.components.core.k.a, AdResultData>() { // from class: com.kwad.components.ad.reward.e.3
            private void b(@NonNull AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty() || r1) {
                    fVar.a(adResultData);
                    return;
                }
                com.kwad.components.core.k.f fVar2 = fVar;
                com.kwad.sdk.core.network.f fVar3 = com.kwad.sdk.core.network.f.Yd;
                fVar2.onError(fVar3.errorCode, fVar3.Qd);
            }

            private void c(int i, String str) {
                fVar.onError(i, str);
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.g gVar, int i, String str) {
                c(i, str);
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                b((AdResultData) baseResultData);
            }
        });
    }

    public static void a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.j.a.og().c(adTemplate, elapsedRealtime - j);
    }

    public static void a(@NonNull SceneImpl sceneImpl, a aVar) {
        a(11, lF, sceneImpl, com.kwad.components.ad.reward.c.d.REFLOW, aVar);
    }

    public static void b(@NonNull SceneImpl sceneImpl, a aVar) {
        a(15, lG, sceneImpl, com.kwad.components.ad.reward.c.d.AGGREGATION, aVar);
    }
}
