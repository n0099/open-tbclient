package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.at;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class k {
    public static volatile boolean a;
    public static float b;
    public static float c;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, String str2, boolean z);
    }

    public static synchronized void a(float f, final a aVar) {
        synchronized (k.class) {
            if (a) {
                return;
            }
            a = true;
            b = new Random().nextFloat();
            c = f;
            com.kwai.adclient.kscommerciallogger.a.a().a(new com.kwai.adclient.kscommerciallogger.kwai.a() { // from class: com.kwad.sdk.core.report.k.1
                @Override // com.kwai.adclient.kscommerciallogger.kwai.a
                public final void a(String str, String str2) {
                    com.kwad.sdk.core.d.b.d(str, str2);
                }

                @Override // com.kwai.adclient.kscommerciallogger.kwai.a
                public final void b(String str, String str2) {
                    com.kwad.sdk.core.d.b.e(str, str2);
                }
            }, new com.kwai.adclient.kscommerciallogger.kwai.b() { // from class: com.kwad.sdk.core.report.k.2
                @Override // com.kwai.adclient.kscommerciallogger.kwai.b
                public final void a(@NonNull String str, @NonNull String str2) {
                    String str3;
                    try {
                        str3 = new JSONObject(str2).optString("event_id");
                    } catch (JSONException unused) {
                        str3 = null;
                    }
                    a.this.a(str, str2, ILoggerReporter.Category.ERROR_LOG.equalsIgnoreCase(str) && at.a(str3, "ad_sdk_init_error_performance"));
                }
            }, null, com.kwad.b.kwai.a.b.booleanValue());
        }
    }

    public static void a(float f, String str, BusinessType businessType, com.kwai.adclient.kscommerciallogger.model.d dVar, String str2, JSONObject jSONObject) {
        if (f > b) {
            a(str, businessType, dVar, str2, jSONObject);
        }
    }

    public static void a(com.kwad.sdk.core.network.i iVar) {
        int i = iVar.g;
        if (i != 0) {
            float f = (float) (1.0d / i);
            com.kwad.sdk.core.d.b.a("NetworkMonitorRecorder", "reportNetError rate:" + f);
            a(f, ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.t, "ad_perf_monitor_net_error", iVar.toJson());
        }
    }

    public static void a(com.kwad.sdk.core.network.j jVar) {
        int i = jVar.g;
        if (i != 0) {
            float f = (float) (1.0d / i);
            com.kwad.sdk.core.d.b.a("NetworkMonitorRecorder", "reportNetPerf rate:" + f);
            a(f, ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.t, "ad_perf_monitor_net_success", jVar.toJson());
        }
    }

    public static void a(String str, HybridLoadMsg hybridLoadMsg) {
        a(str, BusinessType.WEB_CACHE, com.kwai.adclient.kscommerciallogger.model.d.t, "union_web_cache_download_event", hybridLoadMsg.toJson());
    }

    public static void a(String str, WebViewLoadMsg webViewLoadMsg) {
        a(str, BusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.t, "union_webview_load_event", webViewLoadMsg.toJson());
    }

    public static void a(String str, BusinessType businessType, com.kwai.adclient.kscommerciallogger.model.d dVar, String str2, JSONObject jSONObject) {
        try {
            com.kwai.adclient.kscommerciallogger.a.a().a((ILoggerReporter.Category.ERROR_LOG.equals(str) ? c.a.a() : c.a.b()).a(businessType).a(str2).a(dVar).b(str2).a(jSONObject).c());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.a(th);
            ((com.kwad.sdk.service.kwai.c) ServiceProvider.a(com.kwad.sdk.service.kwai.c.class)).a(th);
        }
    }

    public static void a(String str, BusinessType businessType, String str2, JSONObject jSONObject) {
        a(c, str, businessType, com.kwai.adclient.kscommerciallogger.model.d.t, str2, jSONObject);
    }

    public static void a(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, JSONObject jSONObject) {
        a(str, BusinessType.AD_SDK_INIT, dVar, ILoggerReporter.Category.ERROR_LOG.equals(str) ? "ad_sdk_init_error_performance" : "ad_sdk_init_performance", jSONObject);
    }

    public static void a(JSONObject jSONObject) {
        a(ILoggerReporter.Category.ERROR_LOG, BusinessType.AD_REWARD, com.kwai.adclient.kscommerciallogger.model.d.t, "ad_sdk_reward_performance", jSONObject);
    }

    public static void a(boolean z, JSONObject jSONObject) {
        a(ILoggerReporter.Category.ERROR_LOG, z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, com.kwai.adclient.kscommerciallogger.model.b.e, z ? "ad_sdk_reward_download_error" : "ad_sdk_fullscreen_download_error", jSONObject);
    }

    public static void a(boolean z, JSONObject jSONObject, com.kwai.adclient.kscommerciallogger.model.d dVar) {
        a(ILoggerReporter.Category.APM_LOG, z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, dVar, z ? "ad_sdk_reward_load" : "ad_sdk_fullscreen_load", jSONObject);
    }

    public static void b(String str, HybridLoadMsg hybridLoadMsg) {
        a(str, BusinessType.WEB_CACHE, com.kwai.adclient.kscommerciallogger.model.d.t, "union_web_cache_load_event", hybridLoadMsg.toJson());
    }

    public static void b(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, com.kwai.adclient.kscommerciallogger.model.a.k, "ad_sdk_splash_load", jSONObject);
    }

    public static void b(boolean z, JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, com.kwai.adclient.kscommerciallogger.model.a.a, z ? "ad_sdk_reward_page_show" : "ad_sdk_fullscreen_page_show", jSONObject);
    }

    public static void c(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, com.kwai.adclient.kscommerciallogger.model.a.k, "ad_sdk_splash_check", jSONObject);
    }

    public static void c(boolean z, JSONObject jSONObject) {
        a(ILoggerReporter.Category.ERROR_LOG, z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, com.kwai.adclient.kscommerciallogger.model.b.k, z ? "ad_sdk_reward_play_error" : "ad_sdk_fullscreen_play_error", jSONObject);
    }

    public static void d(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, com.kwai.adclient.kscommerciallogger.model.a.k, "ad_sdk_splash_preload", jSONObject);
    }

    public static void e(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, com.kwai.adclient.kscommerciallogger.model.a.j, "ad_sdk_splash_single_cache", jSONObject);
    }

    public static void f(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, com.kwai.adclient.kscommerciallogger.model.a.j, "ad_sdk_splash_cache", jSONObject);
    }

    public static void g(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, com.kwai.adclient.kscommerciallogger.model.a.k, "ad_sdk_splash_show", jSONObject);
    }
}
