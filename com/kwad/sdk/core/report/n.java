package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.BaseResultData;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class n extends com.kwad.sdk.core.network.a<o> {
    private void a(o oVar) {
        try {
            for (String str : oVar.g()) {
                KsAdSDKImpl.get().getProxyForHttp().doGet(str, null);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.a
    public void a(o oVar, com.kwad.sdk.core.network.c cVar) {
    }

    @Override // com.kwad.sdk.core.network.a
    public void d() {
        if (com.ksad.download.d.b.a(KsAdSDKImpl.get().getContext())) {
            super.d();
        } else {
            com.kwad.sdk.core.d.a.d("ReportNetwork", "no network while report log");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1 A[ORIG_RETURN, RETURN] */
    @Override // com.kwad.sdk.core.network.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void f() {
        Exception e;
        com.kwad.sdk.core.network.c cVar;
        com.kwad.sdk.core.network.c doPost;
        o b2 = b();
        try {
            doPost = KsAdSDKImpl.get().getProxyForHttp().doPost(b2.a(), (Map<String, String>) null, b2.d());
        } catch (Exception e2) {
            e = e2;
            cVar = null;
        }
        if (doPost != null) {
            try {
            } catch (Exception e3) {
                e = e3;
                cVar = doPost;
                com.kwad.sdk.core.d.a.a(e);
                if (com.kwad.sdk.a.f8126b.booleanValue()) {
                }
            }
            if (doPost.f9320a == 200) {
                com.kwad.sdk.core.d.a.a("ReportNetwork", "report success actionType:" + b2.f9429b);
                a(b2);
                cVar = doPost;
                if (com.kwad.sdk.a.f8126b.booleanValue()) {
                    BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.sdk.core.report.ReportNetwork$1
                        @Override // com.kwad.sdk.core.network.BaseResultData
                        public void parseJson(@Nullable JSONObject jSONObject) {
                            super.parseJson(jSONObject);
                        }
                    };
                    if (cVar != null) {
                        try {
                            baseResultData.parseJson(new JSONObject(cVar.f9321b));
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (!baseResultData.isResultOk()) {
                        throw new RuntimeException("请求返回失败 code:" + baseResultData.result + ", errorMsg:" + baseResultData.errorMsg);
                    }
                    return;
                }
                return;
            }
        }
        com.kwad.sdk.core.d.a.a("ReportNetwork", "report fail result is null");
        a(b2);
        cVar = doPost;
        if (com.kwad.sdk.a.f8126b.booleanValue()) {
        }
    }
}
