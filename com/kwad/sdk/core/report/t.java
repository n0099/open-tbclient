package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.ReportResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class t extends com.kwad.sdk.core.network.a<u> {
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
                this.a.parseJson(new JSONObject(cVar.d));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.a;
    }

    public static AdHttpProxy a() {
        return (AdHttpProxy) ((com.kwad.sdk.service.kwai.e) ServiceProvider.a(com.kwad.sdk.service.kwai.e.class)).a();
    }

    private void a(u uVar) {
        try {
            List<String> b = uVar.b();
            for (String str : b) {
                a().doGetWithoutResponse(str, null);
                if (!a(str)) {
                    a(uVar.a(), str);
                }
            }
            a(uVar.a(), b);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
        }
    }

    public static void a(@NonNull AdTemplate adTemplate, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m mVar = new m(10218L);
        mVar.T = com.kwad.sdk.core.response.a.d.i(adTemplate).adBaseInfo.creativeId;
        mVar.aw = com.kwad.sdk.utils.r.a(Collections.singletonList(str));
        e.a2(mVar);
    }

    public static void a(@NonNull AdTemplate adTemplate, List<String> list) {
        if (adTemplate.mTrackUrlReported || list == null || list.isEmpty()) {
            return;
        }
        adTemplate.mTrackUrlReported = true;
        m mVar = new m(10217L, adTemplate);
        mVar.aw = com.kwad.sdk.utils.r.a(list);
        e.a2(mVar);
    }

    public static boolean a(String str) {
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
        if (ac.b(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a())) {
            super.fetch();
        } else {
            com.kwad.sdk.core.d.b.e("ReportNetwork", "no network while report log");
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
        u createRequest = createRequest();
        com.kwad.sdk.core.network.c cVar = null;
        try {
            str = createRequest.getUrl();
        } catch (Exception e) {
            e = e;
            str = null;
        }
        try {
            cVar = a().doPost(str, (Map<String, String>) null, createRequest.getBody());
            if (cVar == null || cVar.a != 200) {
                str2 = "report fail result is null";
            } else {
                str2 = "report success actionType:" + createRequest.a;
            }
            com.kwad.sdk.core.d.b.a("ReportNetwork", str2);
        } catch (Exception e2) {
            e = e2;
            com.kwad.sdk.core.d.b.a(e);
            a = a(cVar);
            if (a.isCheatingFlow()) {
            }
            if (!createRequest.a().mCheatingFlow) {
            }
            if (com.kwad.b.kwai.a.b.booleanValue()) {
                return;
            }
            return;
        }
        a = a(cVar);
        if (a.isCheatingFlow()) {
            createRequest.a().setCheatingFlow(a.isCheatingFlow());
        }
        if (!createRequest.a().mCheatingFlow) {
            a(createRequest);
        }
        if (com.kwad.b.kwai.a.b.booleanValue() || a.isResultOk()) {
            return;
        }
        throw new RuntimeException("请求返回失败 code:" + a.result + ", errorMsg:" + a.errorMsg + "\n url=" + str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.network.g, com.kwad.sdk.core.network.c] */
    @Override // com.kwad.sdk.core.network.a
    public /* bridge */ /* synthetic */ void onResponse(u uVar, com.kwad.sdk.core.network.c cVar) {
    }
}
