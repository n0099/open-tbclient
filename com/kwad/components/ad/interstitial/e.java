package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class e {
    public static void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            com.kwad.sdk.core.e.c.e("KsAdInterstitialLoadManager", "loadInterstitialAd please init sdk first");
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    KsLoadManager.InterstitialAdListener interstitialAdListener2 = KsLoadManager.InterstitialAdListener.this;
                    int i = com.kwad.sdk.core.network.e.ats.errorCode;
                    interstitialAdListener2.onError(i, com.kwad.sdk.core.network.e.ats.msg + "sdk not init");
                }
            });
            return;
        }
        final SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a = m.qR().a(covert, "loadInterstitialAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        covert.setAdStyle(13);
        com.kwad.components.ad.interstitial.report.c.dQ().i(covert.getPosId());
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0661a().e(new ImpInfo(covert)).aI(a).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.interstitial.e.2
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                String str;
                String str2;
                final List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                if (adTemplateList.isEmpty()) {
                    int i = com.kwad.sdk.core.network.e.ats.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str2 = com.kwad.sdk.core.network.e.ats.msg;
                    } else {
                        str2 = adResultData.testErrorMsg;
                    }
                    onError(i, str2);
                    i.an("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            interstitialAdListener.onRequestResult(adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class) != null) {
                        com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class);
                        adTemplateList.get(0);
                        com.kwad.sdk.core.response.b.e.dP(adTemplateList.get(0));
                    }
                } catch (Exception unused) {
                }
                com.kwad.components.ad.interstitial.report.c.dQ().a(adTemplateList.get(0), z);
                com.kwad.sdk.commercial.e.c.j(adTemplateList.get(0), adTemplateList.size());
                SystemClock.elapsedRealtime();
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            adTemplate.mAdScene = SceneImpl.this;
                        }
                        String K = com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.dP(adTemplate));
                        if (!com.kwad.sdk.core.response.b.b.cR(adTemplate)) {
                            com.kwad.components.ad.interstitial.report.realtime.a.dU();
                            com.kwad.components.ad.interstitial.report.realtime.a.w(adTemplate);
                        }
                        AdResultData a2 = com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate);
                        if (!TextUtils.isEmpty(K)) {
                            boolean j = com.kwad.components.ad.interstitial.a.a.j(adTemplate);
                            if (com.kwad.sdk.core.config.d.Ar() || j) {
                                arrayList.add(new b(SceneImpl.this, a2));
                            }
                        } else {
                            arrayList.add(new b(SceneImpl.this, a2));
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    int i2 = com.kwad.sdk.core.network.e.ats.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.ats.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    onError(i2, str);
                    com.kwad.components.ad.interstitial.report.realtime.a.dU();
                    com.kwad.components.ad.interstitial.report.realtime.a.a(com.kwad.sdk.core.network.e.ats);
                    i.an("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.interstitial.report.c.dQ().b(adTemplateList.get(0), z);
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsAdLoadManager.M().b(arrayList);
                        i.an("insertAd_", "onInterstitialAdCacheSuccess");
                        interstitialAdListener.onInterstitialAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.interstitial.report.c.dQ().a(i, str, SceneImpl.this.getPosId());
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.c.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        interstitialAdListener.onError(i, str);
                    }
                });
            }
        }).ql());
    }
}
