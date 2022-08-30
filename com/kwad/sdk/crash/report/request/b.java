package com.kwad.sdk.crash.report.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public final void a(final List<ReportEvent> list, @Nullable final CountDownLatch countDownLatch) {
        com.kwad.sdk.core.e.b.d("ExceptionCollector", "CrashReportRequestManager request");
        if (list.size() > 0) {
            new m<a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.1
                @NonNull
                public static CrashReportResult dc(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    CrashReportResult crashReportResult = new CrashReportResult();
                    crashReportResult.parseJson(jSONObject);
                    return crashReportResult;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: wS */
                public a createRequest() {
                    return new a(list);
                }

                @Override // com.kwad.sdk.core.network.m
                public final boolean enableMonitorReport() {
                    return false;
                }

                /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.BaseResultData' to match base method */
                @Override // com.kwad.sdk.core.network.m
                @NonNull
                public final /* synthetic */ CrashReportResult parseData(String str) {
                    return dc(str);
                }
            }.request(new n<a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.2
                private void wT() {
                    CountDownLatch countDownLatch2 = countDownLatch;
                    if (countDownLatch2 != null) {
                        countDownLatch2.countDown();
                    }
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onError(@NonNull g gVar, int i, String str) {
                    wT();
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* bridge */ /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                }
            });
        }
    }
}
