package com.kwad.components.ad.draw;

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
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class d {
    public static void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        boolean a = m.oF().a(ksScene, "loadDrawAd");
        ksScene.setAdStyle(6);
        KsAdLoadManager.ab();
        KsAdLoadManager.a(new a.C0646a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(a).a(new com.kwad.components.core.k.c() { // from class: com.kwad.components.ad.draw.d.1
            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
            public final void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)))) {
                        arrayList.add(new c(adTemplate));
                    }
                }
                if (!arrayList.isEmpty()) {
                    bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.draw.d.1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            KsAdLoadManager.ab().b(arrayList);
                            KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
                        }
                    });
                    return;
                }
                int i = f.Yd.errorCode;
                onError(i, f.Yd.Qd + "(无视频资源)");
            }

            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
            public final void onError(final int i, final String str) {
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.draw.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.b.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        KsLoadManager.DrawAdListener.this.onError(i, str);
                    }
                });
            }
        }).oo());
    }
}
