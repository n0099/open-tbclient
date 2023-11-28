package com.kwad.components.ad.reward.j;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.sdk.core.report.AdTrackLog;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public static void a(final Context context, AdTemplate adTemplate, String str, final int i, JSONObject jSONObject) {
        j cC = new j().cC(18);
        cC.a(adTemplate, str, null, new com.kwad.sdk.g.a<AdTrackLog>() { // from class: com.kwad.components.ad.reward.j.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: a */
            public void accept(AdTrackLog adTrackLog) {
                adTrackLog.rewardDetailStatusBarHeight = com.kwad.sdk.d.a.a.getStatusBarHeight(context);
                adTrackLog.rewardDetailCallPositionY = i;
            }
        });
        com.kwad.sdk.core.report.a.d(adTemplate, jSONObject, cC);
    }

    public static void a(AdTemplate adTemplate, String str, String str2, j jVar, JSONObject jSONObject) {
        if (jVar == null) {
            jVar = new j();
        }
        jVar.a(adTemplate, str, str2, null);
        com.kwad.sdk.core.report.a.a(adTemplate, jVar, jSONObject);
    }

    public static void a(boolean z, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable j jVar) {
        boolean z2;
        boolean a = com.kwad.components.core.s.b.qL().a(adTemplate, jSONObject, jVar);
        if (z && a) {
            if (e.dJ(adTemplate) == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            c.e(z2, adTemplate);
        }
    }
}
