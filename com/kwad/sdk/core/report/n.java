package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.BaseResultData;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class n extends com.kwad.sdk.core.network.a<o> {
    private void a(o oVar) {
        try {
            for (String str : oVar.g()) {
                KsAdSDKImpl.get().getProxyForHttp().doGetWithoutResponse(str, null);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.a
    public void a(o oVar, com.kwad.sdk.core.network.c cVar) {
    }

    @Override // com.kwad.sdk.core.network.a
    public void c() {
        if (com.ksad.download.d.b.a(KsAdSDKImpl.get().getContext())) {
            super.c();
        } else {
            com.kwad.sdk.core.d.a.e("ReportNetwork", "no network while report log");
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void d() {
        String str;
        o b2 = b();
        com.kwad.sdk.core.network.c cVar = null;
        try {
            cVar = KsAdSDKImpl.get().getProxyForHttp().doPost(b2.a(), (Map<String, String>) null, b2.d());
            if (cVar == null || cVar.f32463a != 200) {
                str = "report fail result is null";
            } else {
                str = "report success actionType:" + b2.f32668b;
            }
            com.kwad.sdk.core.d.a.a("ReportNetwork", str);
            a(b2);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (com.kwad.sdk.b.f31890b.booleanValue()) {
            BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.sdk.core.report.ReportNetwork$1
                @Override // com.kwad.sdk.core.network.BaseResultData
                public void parseJson(@Nullable JSONObject jSONObject) {
                    super.parseJson(jSONObject);
                }
            };
            if (cVar != null) {
                try {
                    baseResultData.parseJson(new JSONObject(cVar.f32464b));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (baseResultData.isResultOk()) {
                return;
            }
            throw new RuntimeException("请求返回失败 code:" + baseResultData.result + ", errorMsg:" + baseResultData.errorMsg);
        }
    }
}
