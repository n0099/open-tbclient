package com.kwad.sdk.core.report;

import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.ReportResultData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bn;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class x extends com.kwad.sdk.core.network.a<y> {
    public abstract void Dn();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.network.f, com.kwad.sdk.core.network.c] */
    @Override // com.kwad.sdk.core.network.a
    public /* bridge */ /* synthetic */ void onResponse(y yVar, com.kwad.sdk.core.network.c cVar) {
    }

    public final void DN() {
        fetch();
    }

    @Override // com.kwad.sdk.core.network.a
    public void fetchImpl() {
        AdTemplate adTemplate;
        Throwable th;
        y createRequest;
        try {
            createRequest = createRequest();
            adTemplate = createRequest.getAdTemplate();
        } catch (Throwable th2) {
            adTemplate = null;
            th = th2;
        }
        try {
            int actionType = createRequest.getActionType();
            com.kwad.sdk.commercial.a.a.h(adTemplate, actionType);
            String url = createRequest.getUrl();
            if (!ag.isNetworkConnected(ServiceProvider.getContext())) {
                com.kwad.sdk.core.e.c.w("ReportNetwork", "no network while report log");
                com.kwad.sdk.commercial.a.a.h(adTemplate, actionType, url);
            } else if (bn.gt(url)) {
                com.kwad.sdk.commercial.a.a.a(adTemplate, actionType, url, 100001, "");
            } else {
                com.kwad.sdk.core.network.c doPost = com.kwad.sdk.f.xI().doPost(url, (Map<String, String>) null, createRequest.getBody());
                if (doPost.code != 200) {
                    com.kwad.sdk.commercial.a.a.c(adTemplate, actionType, url, com.kwad.sdk.commercial.c.bU(doPost.code), doPost.atm);
                    return;
                }
                ReportResultData reportResultData = new ReportResultData();
                reportResultData.parseJson(new JSONObject(doPost.atm));
                if (reportResultData.isResultOk()) {
                    com.kwad.sdk.commercial.a.a.i(adTemplate, actionType);
                } else if (reportResultData.isCheatingFlow()) {
                    createRequest.getAdTemplate().setCheatingFlow(reportResultData.isCheatingFlow());
                    com.kwad.sdk.commercial.a.a.b(adTemplate, actionType, url, reportResultData.result, reportResultData.errorMsg);
                } else {
                    com.kwad.sdk.core.e.c.w("ReportNetwork", "request fail code:" + reportResultData.result + ", errorMsg:" + reportResultData.errorMsg + ", url=" + url);
                    com.kwad.sdk.commercial.a.a.b(adTemplate, actionType, url, reportResultData.result, reportResultData.errorMsg);
                }
                Dn();
            }
        } catch (Throwable th3) {
            th = th3;
            com.kwad.sdk.commercial.a.a.a(adTemplate, 0, "", DefaultOggSeeker.MATCH_BYTE_RANGE, bn.s(th));
            com.kwad.sdk.core.e.c.printStackTrace(th);
            ServiceProvider.b(th);
        }
    }
}
