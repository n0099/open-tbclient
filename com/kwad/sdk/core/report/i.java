package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.CommercialAction;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.a;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i {
    public static void a() {
        com.kwai.adclient.kscommerciallogger.a.a().a(new com.kwai.adclient.kscommerciallogger.kwai.a() { // from class: com.kwad.sdk.core.report.i.1
            @Override // com.kwai.adclient.kscommerciallogger.kwai.a
            public void a(String str, String str2, Object... objArr) {
                com.kwad.sdk.core.d.a.d(str, str2);
            }
        }, new com.kwai.adclient.kscommerciallogger.kwai.b() { // from class: com.kwad.sdk.core.report.i.2
            @Override // com.kwai.adclient.kscommerciallogger.kwai.b
            public void a(@NonNull String str, @NonNull String str2) {
                d.a(str, str2, "ad_client_error_log".equalsIgnoreCase(str));
            }
        }, null, com.kwad.sdk.b.c.booleanValue());
    }

    public static void a(String str, CommercialAction.TKDownloadMsg tKDownloadMsg) {
        a(str, "ad_tk_download_performance", tKDownloadMsg.toJson());
    }

    public static void a(String str, CommercialAction.TKPerformMsg tKPerformMsg) {
        a(str, "ad_tk_render_performance", tKPerformMsg.toJson());
    }

    public static void a(String str, String str2, JSONObject jSONObject) {
        try {
            com.kwai.adclient.kscommerciallogger.a.a().a(("ad_client_error_log".equals(str) ? a.C0348a.a() : a.C0348a.b()).a(BusinessType.TACHIKOMA).a(str2).b(str2).a(jSONObject).c());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
            com.kwad.sdk.core.kwai.a.a(th);
        }
    }

    public static void b(String str, CommercialAction.TKDownloadMsg tKDownloadMsg) {
        a(str, "ad_tk_so_download_event", tKDownloadMsg.toJson());
    }

    public static void c(String str, CommercialAction.TKDownloadMsg tKDownloadMsg) {
        a(str, "ad_tk_so_load_performence", tKDownloadMsg.toJson());
    }
}
