package com.kwad.components.ad.reward;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.k.kwai.a;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class f {
    @NonNull
    public static List<AdTemplate> a(KsScene ksScene, List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (AdTemplate adTemplate : list) {
            if (adTemplate != null) {
                if (adTemplate.mAdScene == null && (ksScene instanceof SceneImpl)) {
                    adTemplate.mAdScene = (SceneImpl) ksScene;
                }
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
                if (com.kwad.sdk.core.response.a.a.bk(bQ) || !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.A(bQ))) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public static void loadRewardVideoAd(final KsScene ksScene, @NonNull final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.a.a(true, elapsedRealtime);
        boolean a = com.kwad.components.core.m.m.oF().a(ksScene, "loadRewardVideoAd");
        ksScene.setAdStyle(2);
        KsAdLoadManager.ab();
        KsAdLoadManager.a(new a.C0635a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(a).a(new com.kwad.components.core.k.c() { // from class: com.kwad.components.ad.reward.f.1
            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.b
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                List<AdTemplate> a2 = f.a(ksScene, adResultData.getProceedTemplateList());
                if (a2.isEmpty()) {
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.Yd;
                    onError(fVar.errorCode, fVar.Qd);
                    return;
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                final ArrayList<KsRewardVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : a2) {
                    arrayList.add(new g(adTemplate));
                    adTemplate.mLoadDataTime = elapsedRealtime2;
                    adTemplate.mLoadFromCache = z;
                }
                com.kwad.components.ad.reward.monitor.a.a(true, (AdTemplate) a2.get(0), a2.size(), elapsedRealtime);
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.f.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            KsAdLoadManager.ab().b(arrayList);
                            KsLoadManager.RewardVideoAdListener.this.onRewardVideoResult(arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            com.kwad.sdk.utils.q.a((Object) KsLoadManager.RewardVideoAdListener.this, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                final ArrayList arrayList2 = new ArrayList();
                boolean z2 = false;
                for (KsRewardVideoAd ksRewardVideoAd : arrayList) {
                    AdTemplate adTemplate2 = ((g) ksRewardVideoAd).getAdTemplate();
                    if (com.kwad.sdk.core.response.a.a.bk(com.kwad.sdk.core.response.a.d.bQ(adTemplate2))) {
                        arrayList2.add(ksRewardVideoAd);
                        z2 = true;
                    } else if (com.kwad.components.ad.b.a.a(adTemplate2, true)) {
                        arrayList2.add(ksRewardVideoAd);
                    }
                }
                if (z2 || !arrayList2.isEmpty()) {
                    com.kwad.components.ad.reward.monitor.a.b(true, (AdTemplate) a2.get(0), a2.size(), elapsedRealtime);
                    bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.f.1.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            KsLoadManager.RewardVideoAdListener.this.onRewardVideoAdLoad(arrayList2);
                        }
                    });
                    return;
                }
                com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.Ye;
                onError(fVar2.errorCode, fVar2.Qd);
            }

            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.a.a(true, i, str);
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.f.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.b.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        KsLoadManager.RewardVideoAdListener.this.onError(i, str);
                    }
                });
            }
        }).oo());
    }
}
