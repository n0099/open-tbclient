package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.k.kwai.a;
import com.kwad.components.core.m.m;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public final class e {
    public static void loadInterstitialAd(@NonNull final KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        boolean a = m.oF().a(ksScene, "loadInterstitialAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        ksScene.setAdStyle(13);
        com.kwad.components.ad.interstitial.monitor.b.cr().cs();
        KsAdLoadManager.ab();
        KsAdLoadManager.a(new a.C0599a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(a).a(new com.kwad.components.core.k.c() { // from class: com.kwad.components.ad.interstitial.e.1
            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.b
            public final void a(@NonNull final AdResultData adResultData, boolean z) {
                b bVar;
                final List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                if (adTemplateList.isEmpty()) {
                    f fVar = f.Yd;
                    onError(fVar.errorCode, fVar.Qd);
                    return;
                }
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            KsLoadManager.InterstitialAdListener.this.onRequestResult(adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }
                });
                com.kwad.components.ad.interstitial.monitor.b.cr().a(adTemplateList.get(0), elapsedRealtime, z);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            KsScene ksScene2 = ksScene;
                            if (ksScene2 instanceof SceneImpl) {
                                adTemplate.mAdScene = (SceneImpl) ksScene2;
                            }
                        }
                        if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)))) {
                            bVar = new b(ksScene, adTemplate);
                        } else if (com.kwad.components.ad.interstitial.monitor.a.g(adTemplate)) {
                            bVar = new b(ksScene, adTemplate);
                        }
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.size() == 0) {
                    f fVar2 = f.Yd;
                    onError(fVar2.errorCode, fVar2.Qd);
                    return;
                }
                com.kwad.components.ad.interstitial.monitor.b.cr().b(adTemplateList.get(0), elapsedRealtime2, z);
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsAdLoadManager.ab().b(arrayList);
                        KsLoadManager.InterstitialAdListener.this.onInterstitialAdLoad(arrayList);
                        KsAdLoadManager.ab();
                        KsAdLoadManager.a(adResultData, elapsedRealtime);
                    }
                });
            }

            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.interstitial.monitor.b.cr().d(i, str);
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.b.e("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        KsLoadManager.InterstitialAdListener.this.onError(i, str);
                    }
                });
            }
        }).oo());
    }
}
