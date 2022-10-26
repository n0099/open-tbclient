package com.kwad.sdk.core.report;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.ReportResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ae;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class t extends com.kwad.sdk.core.network.a {
    public ReportResultData abv;

    private ReportResultData a(com.kwad.sdk.core.network.c cVar) {
        if (this.abv == null) {
            this.abv = new ReportResultData() { // from class: com.kwad.sdk.core.report.ReportNetwork$1
                @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
                public void parseJson(JSONObject jSONObject) {
                    super.parseJson(jSONObject);
                }
            };
        }
        if (cVar != null) {
            try {
                this.abv.parseJson(new JSONObject(cVar.XV));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.abv;
    }

    private void a(u uVar) {
        try {
            List<String> uK = uVar.uK();
            for (String str : uK) {
                getProxyForHttp().doGetWithoutResponse(str, null);
                if (!isValidUrl(str)) {
                    e(uVar.getAdTemplate(), uVar.abw, str);
                }
            }
            a(uVar.getAdTemplate(), uK);
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    public static void a(AdTemplate adTemplate, List list) {
        if (adTemplate.mTrackUrlReported || list == null || list.isEmpty()) {
            return;
        }
        adTemplate.mTrackUrlReported = true;
        m mVar = new m(10217L, adTemplate);
        mVar.aba = com.kwad.sdk.utils.r.toJsonArray(list);
        e.a(mVar);
    }

    public static void e(AdTemplate adTemplate, int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m mVar = new m(10218L);
        mVar.creativeId = com.kwad.sdk.core.response.a.d.bQ(adTemplate).adBaseInfo.creativeId;
        mVar.aaZ = i;
        mVar.aba = com.kwad.sdk.utils.r.toJsonArray(Collections.singletonList(str));
        e.a(mVar);
    }

    public static AdHttpProxy getProxyForHttp() {
        return (AdHttpProxy) ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).lm();
    }

    public static boolean isValidUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            URI uri = new URI(str);
            if (uri.getHost() == null) {
                return false;
            }
            return uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https");
        } catch (URISyntaxException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void fetch() {
        if (ae.isNetworkConnected(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext())) {
            super.fetch();
        } else {
            com.kwad.sdk.core.e.b.e("ReportNetwork", "no network while report log");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    @Override // com.kwad.sdk.core.network.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fetchImpl() {
        String str;
        ReportResultData a;
        String str2;
        u uVar = (u) createRequest();
        com.kwad.sdk.core.network.c cVar = null;
        try {
            str = uVar.getUrl();
        } catch (Exception e) {
            e = e;
            str = null;
        }
        try {
            cVar = getProxyForHttp().doPost(str, (Map) null, uVar.getBody());
            if (cVar == null || cVar.code != 200) {
                str2 = "report fail result is null";
            } else {
                str2 = "report success actionType:" + uVar.abw;
            }
            com.kwad.sdk.core.e.b.d("ReportNetwork", str2);
        } catch (Exception e2) {
            e = e2;
            com.kwad.sdk.core.e.b.printStackTrace(e);
            a = a(cVar);
            if (a.isCheatingFlow()) {
            }
            if (!uVar.getAdTemplate().mCheatingFlow) {
            }
            if (com.kwad.b.kwai.a.aw.booleanValue()) {
                return;
            }
            return;
        }
        a = a(cVar);
        if (a.isCheatingFlow()) {
            uVar.getAdTemplate().setCheatingFlow(a.isCheatingFlow());
        }
        if (!uVar.getAdTemplate().mCheatingFlow) {
            a(uVar);
        }
        if (com.kwad.b.kwai.a.aw.booleanValue() || a.isResultOk()) {
            return;
        }
        throw new RuntimeException("请求返回失败 code:" + a.result + ", errorMsg:" + a.errorMsg + "\n url=" + str);
    }

    @Override // com.kwad.sdk.core.network.a
    public /* bridge */ /* synthetic */ void onResponse(com.kwad.sdk.core.network.g gVar, com.kwad.sdk.core.network.c cVar) {
    }
}
