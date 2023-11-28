package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.i;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class f {
    @NonNull
    public static List<AdTemplate> a(SceneImpl sceneImpl, List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (AdTemplate adTemplate : list) {
            if (adTemplate != null) {
                if (adTemplate.mAdScene == null) {
                    adTemplate.mAdScene = sceneImpl;
                }
                AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
                if (1 == com.kwad.sdk.core.response.b.a.be(dP) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(dP))) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.bd(dP)) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.cJ(dP)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public static void a(KsScene ksScene, @NonNull final e eVar) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.components.ad.reward.monitor.c.a(false, covert.getPosId());
        boolean a = m.qR().a(covert, "loadFullScreenVideoAd");
        covert.setAdStyle(3);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0661a().e(new ImpInfo(covert)).aI(a).a(new i() { // from class: com.kwad.components.ad.fullscreen.f.2
            @Override // com.kwad.components.core.request.i
            @WorkerThread
            public final void bK() {
                com.kwad.components.ad.reward.monitor.c.b(false, SceneImpl.this.posId);
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.fullscreen.f.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                List list;
                String str;
                com.kwad.components.ad.reward.monitor.c.c(false, SceneImpl.this.posId);
                List<AdTemplate> a2 = f.a(SceneImpl.this, adResultData.getAdTemplateList());
                if (a2.isEmpty()) {
                    int i = com.kwad.sdk.core.network.e.ats.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.ats.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    onError(i, str);
                    com.kwad.sdk.utils.i.an("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.d.yE());
                final ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : a2) {
                    arrayList.add(new g(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate)));
                    com.kwad.components.ad.reward.monitor.d.a(adTemplate, z, obtainVideoPreCacheConfig);
                }
                final AdTemplate adTemplate2 = (AdTemplate) a2.get(0);
                com.kwad.components.ad.reward.monitor.c.a(false, adTemplate2, a2.size(), elapsedRealtime);
                com.kwad.sdk.commercial.e.c.j(adTemplate2, a2.size());
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.f.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            eVar.a(adTemplate2, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            s.callMethod(eVar, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class) != null) {
                        com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class);
                        a2.get(0);
                        com.kwad.sdk.core.response.b.e.dP((AdTemplate) a2.get(0));
                    }
                } catch (Exception unused) {
                }
                final ArrayList arrayList2 = new ArrayList();
                com.kwad.components.ad.reward.monitor.c.d(false, adTemplate2);
                final boolean Bv = com.kwad.sdk.core.config.d.Bv();
                for (final KsFullScreenVideoAd ksFullScreenVideoAd : arrayList) {
                    AdTemplate adTemplate3 = ((g) ksFullScreenVideoAd).getAdTemplate();
                    AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate3);
                    if (!com.kwad.sdk.core.response.b.a.bd(dP) && !com.kwad.sdk.core.response.b.a.cJ(dP)) {
                        list = a2;
                        com.kwad.components.ad.c.b.a(adTemplate3, false, obtainVideoPreCacheConfig, new com.kwad.components.ad.c.a() { // from class: com.kwad.components.ad.fullscreen.f.1.3
                            @Override // com.kwad.components.ad.c.a
                            public final void V() {
                                com.kwad.sdk.core.e.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList2.add(ksFullScreenVideoAd);
                                f.a(adTemplate2, eVar, arrayList2);
                            }

                            @Override // com.kwad.components.ad.c.a
                            public final void W() {
                                if (!Bv) {
                                    return;
                                }
                                f.a(adTemplate2, eVar, arrayList);
                            }
                        });
                    } else {
                        list = a2;
                        arrayList2.add(ksFullScreenVideoAd);
                        f.a(adTemplate2, eVar, arrayList2);
                    }
                    a2 = list;
                }
                List list2 = a2;
                com.kwad.sdk.core.e.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd after cache");
                if (!Bv && arrayList2.isEmpty()) {
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.att;
                    onError(eVar2.errorCode, eVar2.msg);
                    com.kwad.sdk.utils.i.an("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.b(false, (AdTemplate) list2.get(0), list2.size(), elapsedRealtime);
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.c.a(false, i, str, SceneImpl.this.getPosId());
                if (i != com.kwad.sdk.core.network.e.ats.errorCode && i != com.kwad.sdk.core.network.e.atn.errorCode) {
                    com.kwad.components.ad.reward.monitor.b.c(false, i);
                }
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.f.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.c.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        eVar.onError(i, str);
                    }
                });
            }
        }).ql());
    }

    public static void a(final AdTemplate adTemplate, final e eVar, final List<KsFullScreenVideoAd> list) {
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.f.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.utils.i.an("fullAd_", "onFullScreenVideoAdCacheFailed");
                KsAdLoadManager.M().b(list);
                eVar.b(adTemplate, list);
            }
        });
    }
}
