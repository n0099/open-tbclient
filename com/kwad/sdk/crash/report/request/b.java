package com.kwad.sdk.crash.report.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {

    /* loaded from: classes10.dex */
    public interface a {
        void onError(int i, String str);

        void onSuccess();
    }

    public static void a(List<ReportEvent> list, @Nullable CountDownLatch countDownLatch) {
        a(list, countDownLatch, null);
    }

    public static void a(final List<ReportEvent> list, @Nullable final CountDownLatch countDownLatch, final a aVar) {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "CrashReportRequestManager request");
        if (list != null && list.size() > 0) {
            new l<com.kwad.sdk.crash.report.request.a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.1
                @Override // com.kwad.sdk.core.network.l
                public final boolean enableMonitorReport() {
                    return false;
                }

                @NonNull
                public static CrashReportResult fh(String str) {
                    JSONObject jSONObject = new JSONObject(str);
                    CrashReportResult crashReportResult = new CrashReportResult();
                    crashReportResult.parseJson(jSONObject);
                    return crashReportResult;
                }

                /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.response.model.BaseResultData' to match base method */
                @Override // com.kwad.sdk.core.network.l
                @NonNull
                public final /* synthetic */ CrashReportResult parseData(String str) {
                    return fh(str);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: GQ */
                public com.kwad.sdk.crash.report.request.a createRequest() {
                    return new com.kwad.sdk.crash.report.request.a(list);
                }
            }.request(new o<com.kwad.sdk.crash.report.request.a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.2
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onError(@NonNull f fVar, int i, String str) {
                    s(i, str);
                }

                private void GR() {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onSuccess();
                    }
                }

                private void s(int i, String str) {
                    CountDownLatch countDownLatch2 = countDownLatch;
                    if (countDownLatch2 != null) {
                        countDownLatch2.countDown();
                    }
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onError(i, str);
                    }
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                    GR();
                }
            });
        }
    }
}
