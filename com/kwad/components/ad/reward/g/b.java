package com.kwad.components.ad.reward.g;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.reward.KsRewardVideoAdControl;
import com.kwad.components.core.request.d;
import com.kwad.components.core.request.i;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.b.e;
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
public final class b {
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
                AdInfo dP = e.dP(adTemplate);
                int be = com.kwad.sdk.core.response.b.a.be(dP);
                if (adTemplate.isNativeRewardPreview) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.cJ(dP)) {
                    arrayList.add(adTemplate);
                } else if (1 == be && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(dP))) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.bd(dP)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public static void a(KsScene ksScene, @NonNull final c cVar) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.components.ad.reward.monitor.c.a(true, covert.getPosId());
        boolean a = m.qR().a(covert, "loadRewardVideoAd");
        covert.setAdStyle(2);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0661a().e(new ImpInfo(covert)).aI(a).a(new i() { // from class: com.kwad.components.ad.reward.g.b.2
            @Override // com.kwad.components.core.request.i
            @WorkerThread
            public final void bK() {
                com.kwad.components.ad.reward.monitor.c.b(true, SceneImpl.this.posId);
            }
        }).a(new d() { // from class: com.kwad.components.ad.reward.g.b.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                String str;
                com.kwad.components.ad.reward.monitor.c.c(true, SceneImpl.this.posId);
                List a2 = b.a(SceneImpl.this, adResultData.getProceedTemplateList());
                if (a2.isEmpty()) {
                    int i = com.kwad.sdk.core.network.e.ats.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.ats.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    onError(i, str);
                    com.kwad.sdk.utils.i.an("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.d.yE());
                final ArrayList<KsRewardVideoAd> arrayList = new ArrayList();
                final AdTemplate adTemplate = (AdTemplate) a2.get(0);
                arrayList.add(new KsRewardVideoAdControl(adResultData));
                com.kwad.components.ad.reward.monitor.d.a(adTemplate, z, obtainVideoPreCacheConfig);
                com.kwad.components.ad.reward.monitor.c.a(true, (AdTemplate) a2.get(0), a2.size(), elapsedRealtime);
                com.kwad.sdk.commercial.e.c.j((AdTemplate) a2.get(0), a2.size());
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.g.b.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            KsAdLoadManager.M().b(arrayList);
                            cVar.c(adTemplate, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            s.callMethod(cVar, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class) != null) {
                        com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class);
                        a2.get(0);
                        e.dP((AdTemplate) a2.get(0));
                    }
                } catch (Exception unused) {
                }
                ArrayList arrayList2 = new ArrayList();
                com.kwad.components.ad.reward.monitor.c.d(true, adTemplate);
                final boolean Bv = com.kwad.sdk.core.config.d.Bv();
                boolean z2 = false;
                for (final KsRewardVideoAd ksRewardVideoAd : arrayList) {
                    AdTemplate adTemplate2 = ((KsRewardVideoAdControl) ksRewardVideoAd).getAdTemplate();
                    AdInfo dP = e.dP(adTemplate2);
                    if (!adTemplate2.isNativeRewardPreview && !com.kwad.sdk.core.response.b.a.cJ(dP) && !com.kwad.sdk.core.response.b.a.bd(dP)) {
                        final ArrayList arrayList3 = arrayList2;
                        com.kwad.components.ad.c.b.a(adTemplate2, true, obtainVideoPreCacheConfig, new com.kwad.components.ad.c.a() { // from class: com.kwad.components.ad.reward.g.b.1.3
                            @Override // com.kwad.components.ad.c.a
                            public final void V() {
                                com.kwad.sdk.core.e.c.d("KsAdRewardLoadManager", "loadRewardVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList3.add(ksRewardVideoAd);
                                b.a(adTemplate, cVar, arrayList3);
                            }

                            @Override // com.kwad.components.ad.c.a
                            public final void W() {
                                if (!Bv) {
                                    return;
                                }
                                b.a(adTemplate, cVar, arrayList);
                            }
                        });
                        arrayList2 = arrayList2;
                        a2 = a2;
                    } else {
                        List list = a2;
                        ArrayList arrayList4 = arrayList2;
                        arrayList4.add(ksRewardVideoAd);
                        b.a(adTemplate, cVar, arrayList4);
                        arrayList2 = arrayList4;
                        a2 = list;
                        z2 = true;
                    }
                }
                List list2 = a2;
                ArrayList arrayList5 = arrayList2;
                com.kwad.sdk.core.e.c.d("KsAdRewardLoadManager", "loadRewardVideoAd after cache");
                if (!Bv && !z2 && arrayList5.isEmpty()) {
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.att;
                    onError(eVar.errorCode, eVar.msg);
                    com.kwad.sdk.utils.i.an("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.b(true, (AdTemplate) list2.get(0), list2.size(), elapsedRealtime);
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.c.a(true, i, str, SceneImpl.this.getPosId());
                if (i != com.kwad.sdk.core.network.e.ats.errorCode && i != com.kwad.sdk.core.network.e.atn.errorCode) {
                    com.kwad.components.ad.reward.monitor.b.c(true, i);
                }
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.g.b.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.c.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        cVar.onError(i, str);
                    }
                });
            }
        }).ql());
    }

    public static void a(final AdTemplate adTemplate, final c cVar, final List<KsRewardVideoAd> list) {
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.g.b.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.utils.i.an("rewardAd_", "onRewardVideoAdCacheSuccess");
                c.this.d(adTemplate, list);
            }
        });
    }
}
