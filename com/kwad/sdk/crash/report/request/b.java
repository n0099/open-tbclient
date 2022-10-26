package com.kwad.sdk.crash.report.request;

import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.n;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public final void a(final List list, final CountDownLatch countDownLatch) {
        com.kwad.sdk.core.e.b.d("ExceptionCollector", "CrashReportRequestManager request");
        if (list.size() > 0) {
            new m() { // from class: com.kwad.sdk.crash.report.request.b.1
                public static CrashReportResult dc(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    CrashReportResult crashReportResult = new CrashReportResult();
                    crashReportResult.parseJson(jSONObject);
                    return crashReportResult;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                /* renamed from: wS */
                public a createRequest() {
                    return new a(list);
                }

                @Override // com.kwad.sdk.core.network.m
                public final boolean enableMonitorReport() {
                    return false;
                }

                @Override // com.kwad.sdk.core.network.m
                public final /* synthetic */ BaseResultData parseData(String str) {
                    return dc(str);
                }
            }.request(new n() { // from class: com.kwad.sdk.crash.report.request.b.2
                private void wT() {
                    CountDownLatch countDownLatch2 = countDownLatch;
                    if (countDownLatch2 != null) {
                        countDownLatch2.countDown();
                    }
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onError(g gVar, int i, String str) {
                    wT();
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* bridge */ /* synthetic */ void onSuccess(g gVar, BaseResultData baseResultData) {
                }
            });
        }
    }
}
