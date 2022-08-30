package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class k {
    public static volatile boolean aaa;
    public static float aab;
    public static float aac;
    public static float aad;

    /* loaded from: classes7.dex */
    public interface a {
        void f(String str, String str2, boolean z);
    }

    public static void a(double d, String str, HybridLoadMsg hybridLoadMsg) {
        a(d, str, BusinessType.WEB_CACHE, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.asl, "union_web_cache_download_event", hybridLoadMsg.toJson());
    }

    public static void a(double d, String str, WebViewLoadMsg webViewLoadMsg) {
        a(d, str, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.asl, "union_webview_load_event", webViewLoadMsg.toJson());
    }

    public static void a(double d, String str, BusinessType businessType, SubBusinessType subBusinessType, com.kwai.adclient.kscommerciallogger.model.d dVar, String str2, JSONObject jSONObject) {
        if (aab > d) {
            return;
        }
        try {
            com.kwai.adclient.kscommerciallogger.a.BE().a((ct(str) ? c.a.BO() : c.a.BP()).a(businessType).a(subBusinessType).el(str2).a(dVar).em(str2).l(h(jSONObject)).BQ());
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
            com.kwad.sdk.service.kwai.c cVar = (com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class);
            if (cVar != null) {
                cVar.gatherException(th);
            }
        }
    }

    public static void a(double d, String str, com.kwai.adclient.kscommerciallogger.model.d dVar, JSONObject jSONObject) {
        a(d, str, BusinessType.AD_SDK_INIT, SubBusinessType.OTHER, dVar, ILoggerReporter.Category.ERROR_LOG.equals(str) ? "ad_sdk_init_error_performance" : "ad_sdk_init_performance", jSONObject);
    }

    public static void a(double d, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.AD_WEBVIEW, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.arI, "ad_sdk_webview_track", jSONObject);
    }

    public static void a(double d, boolean z, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.ERROR_LOG, z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.b.arV, z ? "ad_sdk_reward_download_error" : "ad_sdk_fullscreen_download_error", jSONObject);
    }

    public static void a(double d, boolean z, JSONObject jSONObject, com.kwai.adclient.kscommerciallogger.model.d dVar) {
        a(d, ILoggerReporter.Category.APM_LOG, z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, SubBusinessType.OTHER, dVar, z ? "ad_sdk_reward_load" : "ad_sdk_fullscreen_load", jSONObject);
    }

    public static synchronized void a(float f, final a aVar) {
        synchronized (k.class) {
            if (aaa) {
                return;
            }
            aaa = true;
            aab = new Random().nextFloat();
            aac = new Random().nextFloat();
            aad = f;
            com.kwai.adclient.kscommerciallogger.a.BE().a(new com.kwai.adclient.kscommerciallogger.kwai.a() { // from class: com.kwad.sdk.core.report.k.1
                @Override // com.kwai.adclient.kscommerciallogger.kwai.a
                public final void I(String str, String str2) {
                    com.kwad.sdk.core.e.b.w(str, str2);
                }

                @Override // com.kwai.adclient.kscommerciallogger.kwai.a
                public final void J(String str, String str2) {
                    com.kwad.sdk.core.e.b.e(str, str2);
                }
            }, new com.kwai.adclient.kscommerciallogger.kwai.b() { // from class: com.kwad.sdk.core.report.k.2
                @Override // com.kwai.adclient.kscommerciallogger.kwai.b
                public final void K(@NonNull String str, @NonNull String str2) {
                    try {
                        new JSONObject(str2).optString("event_id");
                    } catch (JSONException unused) {
                    }
                    a.this.f(str, str2, ILoggerReporter.Category.ERROR_LOG.equalsIgnoreCase(str));
                }
            }, null, com.kwad.b.kwai.a.aw.booleanValue());
        }
    }

    public static void a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        com.kwad.sdk.utils.r.putValue(webViewCommercialMsg.msg, "ratio", webViewCommercialMsg.rate);
        a(webViewCommercialMsg.rate, str, webViewCommercialMsg.biz, webViewCommercialMsg.subBiz, webViewCommercialMsg.type, webViewCommercialMsg.eventId, webViewCommercialMsg.msg);
    }

    public static void b(double d, com.kwad.sdk.core.network.j jVar) {
        double d2 = 1.0d / jVar.Yr;
        com.kwad.sdk.core.e.b.d("NetworkMonitorRecorder", "reportNetPerf rate:" + d2);
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.asl, "ad_perf_monitor_net_error", jVar.toJson());
    }

    public static void b(double d, com.kwad.sdk.core.network.k kVar) {
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.asl, "ad_perf_monitor_net_success", kVar.toJson());
    }

    public static void b(double d, String str, HybridLoadMsg hybridLoadMsg) {
        a(d, str, BusinessType.WEB_CACHE, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.asl, "union_web_cache_load_event", hybridLoadMsg.toJson());
    }

    public static void b(double d, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.ERROR_LOG, BusinessType.AD_REWARD, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.asl, "ad_sdk_reward_performance", jSONObject);
    }

    public static void b(double d, boolean z, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.APM_LOG, z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.ary, z ? "ad_sdk_reward_page_show" : "ad_sdk_fullscreen_page_show", jSONObject);
    }

    public static void b(@NonNull com.kwad.sdk.utils.a.a aVar) {
        a((float) (1.0d / aVar.Yr), ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.d.asl, "ad_union_kv_fail_rate", aVar.toJson());
    }

    public static void c(double d, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.arI, "ad_sdk_splash_load", jSONObject);
    }

    public static void c(double d, boolean z, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.ERROR_LOG, z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.b.asb, z ? "ad_sdk_reward_play_error" : "ad_sdk_fullscreen_play_error", jSONObject);
    }

    public static boolean ct(String str) {
        if (aac > aad) {
            return ILoggerReporter.Category.ERROR_LOG.equals(str);
        }
        return true;
    }

    public static void d(double d, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.arI, "ad_sdk_splash_check", jSONObject);
    }

    public static void e(double d, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.arI, "ad_sdk_splash_preload", jSONObject);
    }

    public static void f(double d, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.arH, "ad_sdk_splash_single_cache", jSONObject);
    }

    public static void g(double d, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.arH, "ad_sdk_splash_cache", jSONObject);
    }

    public static void g(JSONObject jSONObject) {
        double d = 1.0d;
        try {
            if (jSONObject.has("ratio") && !Double.isNaN(jSONObject.optDouble("ratio"))) {
                d = jSONObject.optDouble("ratio");
            }
        } catch (Exception unused) {
        }
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.arI, "ad_sdk_dynamic_update", jSONObject);
    }

    public static JSONObject h(@NonNull JSONObject jSONObject) {
        double d;
        try {
            if (jSONObject.has("ratio")) {
                d = jSONObject.optDouble("ratio");
            } else {
                if (jSONObject.has("ratio_count")) {
                    if (jSONObject.optDouble("ratio_count") > 0.0d) {
                        d = 1.0d / jSONObject.optDouble("ratio_count");
                    }
                } else if (com.kwad.b.kwai.a.aw.booleanValue()) {
                    throw new Exception("未设置ratio");
                }
                d = 1.0d;
            }
            if (!jSONObject.has("ratio")) {
                com.kwad.sdk.utils.r.putValue(jSONObject, "ratio", d);
            }
            if (!jSONObject.has("ratio_count") && d > 0.0d) {
                com.kwad.sdk.utils.r.putValue(jSONObject, "ratio_count", 1.0d / d);
            }
            com.kwad.sdk.utils.r.putValue(jSONObject, "debug_mode", com.kwad.b.kwai.a.aw.booleanValue() ? 1 : 0);
            com.kwad.sdk.utils.r.putValue(jSONObject, "convert_ratio", aad);
            if (aad > 0.0f) {
                com.kwad.sdk.utils.r.putValue(jSONObject, "convert_ratio_count", 1.0d / aad);
            }
            return jSONObject;
        } catch (Exception e) {
            if (com.kwad.b.kwai.a.aw.booleanValue()) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
            return jSONObject;
        }
    }

    public static void h(double d, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.arI, "ad_sdk_splash_show", jSONObject);
    }

    public static void i(double d, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.a.arI, "ad_sdk_interstitial_load", jSONObject);
    }

    public static void j(double d, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.b.arV, "ad_sdk_interstitial_download_error", jSONObject);
    }

    public static void k(double d, JSONObject jSONObject) {
        a(d, ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.kscommerciallogger.model.b.asb, "ad_sdk_interstitial_play_error", jSONObject);
    }
}
