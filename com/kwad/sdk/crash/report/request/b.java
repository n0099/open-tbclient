package com.kwad.sdk.crash.report.request;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.crash.report.ReportEvent;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public void a(final List<ReportEvent> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        new i<a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public CrashReportResult b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                CrashReportResult crashReportResult = new CrashReportResult();
                crashReportResult.parseJson(jSONObject);
                return crashReportResult;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public a b() {
                return new a(list);
            }

            @Override // com.kwad.sdk.core.network.i
            public boolean c() {
                return false;
            }
        }.a(new j<a, CrashReportResult>() { // from class: com.kwad.sdk.crash.report.request.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull a aVar, int i, String str) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull a aVar, @NonNull CrashReportResult crashReportResult) {
            }
        });
    }
}
