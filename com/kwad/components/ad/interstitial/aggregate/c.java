package com.kwad.components.ad.interstitial.aggregate;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class c {
    public volatile boolean iI;
    public l<com.kwad.components.core.request.a, AdResultData> iJ;

    /* loaded from: classes10.dex */
    public interface b {
        void onInterstitialAdLoad(@Nullable List<AdResultData> list);
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass1 extends j {
        public final /* synthetic */ SceneImpl em;
        public final /* synthetic */ b iK;
        public final /* synthetic */ long ij;

        public AnonymousClass1(SceneImpl sceneImpl, b bVar, long j) {
            this.em = sceneImpl;
            this.iK = bVar;
            this.ij = j;
        }

        @Override // com.kwad.components.core.request.k
        public final void a(@NonNull final AdResultData adResultData) {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    final ArrayList arrayList = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = AnonymousClass1.this.em;
                            }
                            arrayList.add(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate));
                        }
                    }
                    bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1.this.iK.onInterstitialAdLoad(arrayList);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c cVar = c.this;
                            c.a(adResultData, anonymousClass1.ij);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.components.core.request.k
        public final void onError(final int i, final String str) {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.e.c.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static c iQ = new c((byte) 0);
    }

    public c() {
        this.iI = false;
    }

    public static c cx() {
        return a.iQ;
    }

    public final void release() {
        l<com.kwad.components.core.request.a, AdResultData> lVar = this.iJ;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    private void a(ImpInfo impInfo, @NonNull final j jVar) {
        com.kwad.components.core.m.a aVar = new com.kwad.components.core.m.a(impInfo);
        this.iJ = aVar;
        aVar.request(new o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.ad.interstitial.aggregate.c.2
            private void h(int i, String str) {
                c.a(c.this, false);
                jVar.onError(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                c((AdResultData) baseResultData);
            }

            private void c(@NonNull AdResultData adResultData) {
                String str;
                c.a(c.this, false);
                if (adResultData.isAdResultDataEmpty()) {
                    j jVar2 = jVar;
                    int i = e.ats.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = e.ats.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    jVar2.onError(i, str);
                    return;
                }
                jVar.a(adResultData);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i, String str) {
                h(i, str);
            }
        });
    }

    public static void a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() > 0 && (adTemplate = adResultData.getAdTemplateList().get(0)) != null) {
            com.kwad.components.core.o.a.pX().g(adTemplate, elapsedRealtime - j);
        }
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.iI = false;
        return false;
    }

    public final void a(int i, int i2, @NonNull SceneImpl sceneImpl, b bVar) {
        if (this.iI) {
            return;
        }
        SceneImpl m185clone = sceneImpl.m185clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m185clone.setAdStyle(16);
        m185clone.setAdNum(i2);
        a(new ImpInfo(m185clone), new AnonymousClass1(sceneImpl, bVar, elapsedRealtime));
    }
}
