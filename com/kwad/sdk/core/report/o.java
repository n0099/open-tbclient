package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class o extends com.kwad.sdk.core.network.a<p> {
    public ReportResultData a;

    @NonNull
    private ReportResultData a(com.kwad.sdk.core.network.c cVar) {
        if (this.a == null) {
            this.a = new ReportResultData() { // from class: com.kwad.sdk.core.report.ReportNetwork$1
                @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
                public void parseJson(@Nullable JSONObject jSONObject) {
                    super.parseJson(jSONObject);
                }
            };
        }
        if (cVar != null) {
            try {
                this.a.parseJson(new JSONObject(cVar.f56103b));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this.a;
    }

    private void a(p pVar) {
        try {
            List<String> j2 = pVar.j();
            for (String str : j2) {
                KsAdSDKImpl.get().getProxyForHttp().doGetWithoutResponse(str, null);
            }
            d.a(pVar.i(), j2);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.a
    public void a(p pVar, com.kwad.sdk.core.network.c cVar) {
    }

    @Override // com.kwad.sdk.core.network.a
    public void d() {
        if (com.ksad.download.c.b.a(KsAdSDKImpl.get().getContext())) {
            super.d();
        } else {
            com.kwad.sdk.core.d.a.e("ReportNetwork", "no network while report log");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    @Override // com.kwad.sdk.core.network.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f() {
        String str;
        ReportResultData a;
        String str2;
        p b2 = b();
        com.kwad.sdk.core.network.c cVar = null;
        try {
            str = b2.a();
            try {
                cVar = KsAdSDKImpl.get().getProxyForHttp().doPost(str, (Map<String, String>) null, b2.e());
                if (cVar == null || cVar.a != 200) {
                    str2 = "report fail result is null";
                } else {
                    str2 = "report success actionType:" + b2.f56269b;
                }
                com.kwad.sdk.core.d.a.a("ReportNetwork", str2);
            } catch (Exception e2) {
                e = e2;
                com.kwad.sdk.core.d.a.a(e);
                a = a(cVar);
                if (a.isCheatingFlow()) {
                }
                if (!b2.i().mCheatingFlow) {
                }
                if (com.kwad.sdk.b.f55652c.booleanValue()) {
                    return;
                }
                return;
            }
        } catch (Exception e3) {
            e = e3;
            str = null;
        }
        a = a(cVar);
        if (a.isCheatingFlow()) {
            b2.i().setCheatingFlow(a.isCheatingFlow());
        }
        if (!b2.i().mCheatingFlow) {
            a(b2);
        }
        if (com.kwad.sdk.b.f55652c.booleanValue() || a.isResultOk()) {
            return;
        }
        throw new RuntimeException("请求返回失败 code:" + a.result + ", errorMsg:" + a.errorMsg + "\n url=" + str);
    }
}
