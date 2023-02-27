package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.k.f;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class c {
    public volatile boolean fq;
    public m<com.kwad.components.core.k.a, AdResultData> fr;

    /* renamed from: com.kwad.components.ad.interstitial.c$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass1 extends f {
        public final /* synthetic */ SceneImpl fs;
        public final /* synthetic */ b ft;
        public final /* synthetic */ long fu;

        public AnonymousClass1(SceneImpl sceneImpl, b bVar, long j) {
            this.fs = sceneImpl;
            this.ft = bVar;
            this.fu = j;
        }

        @Override // com.kwad.components.core.k.g
        public final void a(@NonNull final AdResultData adResultData) {
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    final ArrayList arrayList = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = AnonymousClass1.this.fs;
                            }
                            arrayList.add(adTemplate);
                        }
                    }
                    bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.1.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1.this.ft.onInterstitialAdLoad(arrayList);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c cVar = c.this;
                            c.a(adResultData, anonymousClass1.fu);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.components.core.k.g
        public final void onError(final int i, final String str) {
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.e.b.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                }
            });
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static c fA = new c((byte) 0);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onInterstitialAdLoad(@Nullable List<AdTemplate> list);
    }

    public c() {
        this.fq = false;
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    private void a(com.kwad.components.core.k.kwai.b bVar, @NonNull final f fVar) {
        com.kwad.components.core.h.a aVar = new com.kwad.components.core.h.a(bVar);
        this.fr = aVar;
        aVar.request(new n<com.kwad.components.core.k.a, AdResultData>() { // from class: com.kwad.components.ad.interstitial.c.2
            private void b(@NonNull AdResultData adResultData) {
                c.a(c.this, false);
                if (!adResultData.isAdResultDataEmpty()) {
                    fVar.a(adResultData);
                    return;
                }
                f fVar2 = fVar;
                com.kwad.sdk.core.network.f fVar3 = com.kwad.sdk.core.network.f.Yd;
                fVar2.onError(fVar3.errorCode, fVar3.Qd);
            }

            private void c(int i, String str) {
                c.a(c.this, false);
                fVar.onError(i, str);
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull g gVar, int i, String str) {
                c(i, str);
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
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

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.fq = false;
        return false;
    }

    public static c cd() {
        return a.fA;
    }

    public final void a(int i, int i2, @NonNull SceneImpl sceneImpl, b bVar) {
        if (this.fq) {
            return;
        }
        SceneImpl m92clone = sceneImpl.m92clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m92clone.setAdStyle(16);
        m92clone.setAdNum(i2);
        a(new com.kwad.components.core.k.kwai.b(m92clone), new AnonymousClass1(sceneImpl, bVar, elapsedRealtime));
    }

    public final void release() {
        m<com.kwad.components.core.k.a, AdResultData> mVar = this.fr;
        if (mVar != null) {
            mVar.cancel();
        }
    }
}
