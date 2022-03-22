package com.kwad.sdk.reward.widget;

import android.app.Activity;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.j;
import com.kwad.sdk.reward.k;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static j.b a(final j.a aVar, final com.kwad.sdk.reward.a aVar2) {
        final Activity activity = aVar2.f40748h;
        final com.kwad.sdk.reward.c.a aVar3 = aVar2.k;
        final AdTemplate adTemplate = aVar2.f40747g;
        final AdInfo j = d.j(adTemplate);
        final JSONObject jSONObject = aVar2.f40745e;
        return new j.c() { // from class: com.kwad.sdk.reward.widget.a.1
            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void a() {
                com.kwad.sdk.reward.c.a.this.c();
                if (aVar.a() == 0) {
                    com.kwad.sdk.core.report.a.j(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.report.a.c(adTemplate, 149, jSONObject);
                }
            }

            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void b() {
                com.kwad.sdk.core.report.a.f(adTemplate, (int) Cea708Decoder.COMMAND_SWA);
                if (com.kwad.sdk.core.response.a.a.aG(j)) {
                    activity.finish();
                    return;
                }
                com.kwad.sdk.core.report.a.a(adTemplate, (int) (com.kwad.sdk.core.response.a.a.o(j) / 1000), (int) (com.kwad.sdk.reward.c.a.this.h() / 1000));
                aVar2.u = true;
                com.kwad.sdk.reward.c.a.this.a(true);
                k.a(aVar2);
            }

            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void c() {
                com.kwad.sdk.reward.c.a.this.b();
                if (aVar.a() == 1 || aVar.a() == 2) {
                    com.kwad.sdk.core.report.a.f(adTemplate, 150);
                } else {
                    com.kwad.sdk.core.report.a.k(adTemplate, jSONObject);
                }
            }

            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void d() {
                super.d();
                com.kwad.sdk.core.report.a.f(adTemplate, 150);
                com.kwad.sdk.reward.a aVar4 = aVar2;
                aVar4.a(aVar4.i, Cea708Decoder.COMMAND_DS4, 1);
            }

            @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
            public void e() {
                super.e();
                com.kwad.sdk.core.report.a.f(adTemplate, 150);
                com.kwad.sdk.reward.a aVar4 = aVar2;
                aVar4.a(aVar4.i, Cea708Decoder.COMMAND_DS4, 1);
            }
        };
    }

    public static void a(com.kwad.sdk.reward.a aVar) {
        Activity activity = aVar.f40748h;
        AdTemplate adTemplate = aVar.f40747g;
        AdInfo j = d.j(adTemplate);
        long b2 = com.kwad.sdk.core.response.a.a.b(j) * 1000;
        long n = com.kwad.sdk.core.response.a.a.n(j);
        String str = "观看完整视频即可获取奖励";
        if (n > 0 && b2 > n) {
            str = "观看视频" + n + "s即可获取奖励";
        }
        j.a a = j.a(adTemplate, str, aVar.y, aVar.z);
        j.a(activity, adTemplate, a, a(a, aVar));
    }
}
