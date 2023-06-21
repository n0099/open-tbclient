package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.k.kwai.a;
import com.kwad.components.core.m.m;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class c {
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
                if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)))) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public static void loadFullScreenVideoAd(final KsScene ksScene, @NonNull final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.a.a(false, elapsedRealtime);
        boolean a = m.oF().a(ksScene, "loadFullScreenVideoAd");
        ksScene.setAdStyle(3);
        KsAdLoadManager.ab();
        KsAdLoadManager.a(new a.C0636a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(a).a(new com.kwad.components.core.k.c() { // from class: com.kwad.components.ad.fullscreen.c.1
            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.b
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                List<AdTemplate> a2 = c.a(ksScene, adResultData.getAdTemplateList());
                if (a2.isEmpty()) {
                    f fVar = f.Yd;
                    onError(fVar.errorCode, fVar.Qd);
                    return;
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                final ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : a2) {
                    arrayList.add(new d(adTemplate));
                    adTemplate.mLoadDataTime = elapsedRealtime2;
                    adTemplate.mLoadFromCache = z;
                }
                com.kwad.components.ad.reward.monitor.a.a(false, (AdTemplate) a2.get(0), a2.size(), elapsedRealtime);
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.c.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            KsLoadManager.FullScreenVideoAdListener.this.onFullScreenVideoResult(arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            q.a((Object) KsLoadManager.FullScreenVideoAdListener.this, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                ArrayList arrayList2 = new ArrayList();
                for (KsFullScreenVideoAd ksFullScreenVideoAd : arrayList) {
                    if (com.kwad.components.ad.b.a.a(((d) ksFullScreenVideoAd).getAdTemplate(), false)) {
                        arrayList2.add(ksFullScreenVideoAd);
                    }
                }
                if (arrayList2.isEmpty()) {
                    f fVar2 = f.Ye;
                    onError(fVar2.errorCode, fVar2.Qd);
                    return;
                }
                com.kwad.components.ad.reward.monitor.a.b(false, (AdTemplate) a2.get(0), a2.size(), elapsedRealtime);
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.c.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsAdLoadManager.ab().b(arrayList);
                        KsLoadManager.FullScreenVideoAdListener.this.onFullScreenVideoAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.a.a(false, i, str);
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.c.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.b.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        KsLoadManager.FullScreenVideoAdListener.this.onError(i, str);
                    }
                });
            }
        }).oo());
    }
}
