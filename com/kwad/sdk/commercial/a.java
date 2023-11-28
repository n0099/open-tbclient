package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.ui.animview.util.PraiseUBCHelper;
import com.baidu.searchbox.util.KVStorageUtils;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.e;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.t;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import com.kwai.adclient.kscommerciallogger.model.d;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public static float ann = -1.0f;
    public static double ano = -1.0d;
    public static final AtomicBoolean anp = new AtomicBoolean();
    public static boolean anq;
    public static volatile boolean anr;
    public static List<b> ans;
    public static InterfaceC0696a ant;
    public static Map<String, com.kwad.sdk.commercial.d.c> anu;

    /* renamed from: com.kwad.sdk.commercial.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0696a {
        @WorkerThread
        void j(String str, String str2, boolean z);

        @WorkerThread
        boolean xX();

        @WorkerThread
        boolean xY();

        @WorkerThread
        JSONObject xZ();
    }

    public static synchronized void mK() {
        synchronized (a.class) {
            if (ans == null) {
                return;
            }
            for (b bVar : ans) {
                b(bVar);
            }
            ans.clear();
            ans = null;
        }
    }

    public static double a(double d, double d2, int i) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d2)), 0, 4).doubleValue();
    }

    @NonNull
    public static com.kwad.sdk.commercial.d.b a(b bVar) {
        double d;
        double d2;
        com.kwad.sdk.commercial.d.b bVar2 = new com.kwad.sdk.commercial.d.b();
        try {
            bVar2.anQ = bVar.anx;
            bVar2.anR = bVar.anz;
            String str = bVar.eventId;
            if (!TextUtils.isEmpty(bVar.primaryKey)) {
                if (bVar.msg.has(bVar.primaryKey)) {
                    str = str + "_" + bVar.msg.opt(bVar.primaryKey);
                } else {
                    str = str + "_" + bVar.primaryKey;
                }
            } else if (com.kwad.framework.a.a.mc.booleanValue()) {
                throw new Exception("primaryKey为空");
            }
            if (anu.containsKey(bVar.eventId) && anu.get(bVar.eventId) != null) {
                com.kwad.sdk.commercial.d.c cVar = anu.get(bVar.eventId);
                if (cVar.anT) {
                    d = cVar.anQ;
                } else {
                    d = -1.0d;
                }
                if (cVar.anU) {
                    d2 = cVar.anR;
                } else {
                    d2 = -1.0d;
                }
                if (!TextUtils.isEmpty(cVar.anS)) {
                    bVar2.anS = cVar.anS;
                }
            } else {
                d = -1.0d;
                d2 = -1.0d;
            }
            if (anu.containsKey(str) && anu.get(str) != null) {
                com.kwad.sdk.commercial.d.c cVar2 = anu.get(str);
                if (cVar2.anT) {
                    d = cVar2.anQ;
                }
                if (cVar2.anU) {
                    d2 = cVar2.anR;
                }
                if (!TextUtils.isEmpty(cVar2.anS)) {
                    bVar2.anS = cVar2.anS;
                }
            }
            if (d != -1.0d) {
                bVar2.anQ = d;
            }
            if (d2 != -1.0d) {
                bVar2.anR = d2;
            } else {
                bVar2.zT();
            }
            bVar.anx = bVar2.anQ;
            bVar.anz = bVar2.anR;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        return bVar2;
    }

    public static String a(com.kwad.sdk.commercial.d.b bVar, String str) {
        try {
            int lastIndexOf = str.lastIndexOf(95);
            int length = str.length() - 1;
            if (str.charAt(length) >= '0' && str.charAt(length) <= '9' && lastIndexOf != -1) {
                bVar.anS = str.substring(lastIndexOf + 1);
                return str.substring(0, lastIndexOf);
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String a(String str, b bVar) {
        if (str.equals(ILoggerReporter.Category.APM_LOG) && ano < bVar.anz) {
            return ILoggerReporter.Category.ERROR_LOG;
        }
        return str;
    }

    public static JSONObject a(JSONObject jSONObject, com.kwad.sdk.commercial.d.b bVar) {
        int i;
        try {
            t.putValue(jSONObject, MapBundleKey.OfflineMapKey.OFFLINE_RATION, bVar.anQ);
            if (bVar.anQ > 0.0d) {
                t.putValue(jSONObject, "ratio_count", a(1.0d, bVar.anQ, 0));
            }
            if (com.kwad.framework.a.a.mc.booleanValue()) {
                i = 1;
            } else {
                i = 0;
            }
            t.putValue(jSONObject, "debug_mode", i);
            t.putValue(jSONObject, "convert_ratio", bVar.anR);
            if (bVar.anR > 0.0d) {
                t.putValue(jSONObject, "convert_ratio_count", a(1.0d, bVar.anR, 0));
            }
            return jSONObject;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return jSONObject;
        }
    }

    public static synchronized void a(final InterfaceC0696a interfaceC0696a, final boolean z) {
        synchronized (a.class) {
            if (anq) {
                return;
            }
            anq = true;
            ant = interfaceC0696a;
            g.execute(new ay() { // from class: com.kwad.sdk.commercial.a.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    a.b(InterfaceC0696a.this, z);
                    a.zL();
                    a.anp.set(true);
                    a.mK();
                }
            });
        }
    }

    public static void a(String str, HybridLoadMsg hybridLoadMsg) {
        d(b.zP().cl(str).i(1.0E-4d).L("union_web_cache_download_event", "state").a(BusinessType.WEB_CACHE).u(hybridLoadMsg).a(d.aSH));
    }

    public static void a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        double d = webViewCommercialMsg.rate;
        if (d >= 0.0d) {
            t.putValue(webViewCommercialMsg.msg, MapBundleKey.OfflineMapKey.OFFLINE_RATION, d);
        }
        if (TextUtils.isEmpty(webViewCommercialMsg.primaryKey)) {
            webViewCommercialMsg.primaryKey = "web_log";
        }
        d(b.zP().cl(str).i(webViewCommercialMsg.rate).L(webViewCommercialMsg.eventId, webViewCommercialMsg.primaryKey).a(webViewCommercialMsg.biz).a(webViewCommercialMsg.subBiz).h(webViewCommercialMsg.msg).a(d.aSH));
    }

    public static void a(String str, WebViewLoadMsg webViewLoadMsg) {
        d(b.zP().cl(str).i(1.0d).L("union_webview_load_event", "state").u(webViewLoadMsg).a(d.aSH));
    }

    public static void a(String str, d dVar, com.kwad.sdk.commercial.d.a aVar) {
        String str2;
        if (ILoggerReporter.Category.ERROR_LOG.equals(str)) {
            str2 = "ad_sdk_init_error_performance";
        } else {
            str2 = "ad_sdk_init_performance";
        }
        d(b.zP().cl(str).i(0.001d).L(str2, "init_status").a(BusinessType.AD_SDK_INIT).u(aVar).a(dVar));
    }

    public static void a(boolean z, com.kwad.sdk.commercial.d.a aVar, d dVar) {
        String str;
        BusinessType businessType;
        if (z) {
            str = "ad_sdk_reward_load";
        } else {
            str = "ad_sdk_fullscreen_load";
        }
        b L = b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L(str, "load_status");
        if (z) {
            businessType = BusinessType.AD_REWARD;
        } else {
            businessType = BusinessType.AD_FULLSCREEN;
        }
        d(L.a(businessType).u(aVar).a(dVar));
    }

    public static void a(boolean z, String str, com.kwad.sdk.commercial.d.a aVar) {
        BusinessType businessType;
        b L = b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(1.0d).L(str, "reward_type");
        if (z) {
            businessType = BusinessType.AD_REWARD;
        } else {
            businessType = BusinessType.AD_FULLSCREEN;
        }
        d(L.a(businessType).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aSy));
    }

    public static void b(final InterfaceC0696a interfaceC0696a, boolean z) {
        boolean xX = interfaceC0696a.xX();
        anr = xX;
        if (!xX) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "publish_type", 0);
        t.putValue(jSONObject, "plug_sdk", z ? 1 : 0);
        com.kwai.adclient.kscommerciallogger.a.MB().a(new com.kwai.adclient.kscommerciallogger.a.a() { // from class: com.kwad.sdk.commercial.a.2
            @Override // com.kwai.adclient.kscommerciallogger.a.a
            public final void H(String str, String str2) {
                com.kwad.sdk.core.e.c.w(str, str2);
            }

            @Override // com.kwai.adclient.kscommerciallogger.a.a
            public final void I(String str, String str2) {
                com.kwad.sdk.core.e.c.e(str, str2);
            }
        }, new com.kwai.adclient.kscommerciallogger.a.b() { // from class: com.kwad.sdk.commercial.a.3
            private void K(String str, String str2) {
                InterfaceC0696a.this.j(str, str2, false);
            }

            @Override // com.kwai.adclient.kscommerciallogger.a.b
            public final void J(@NonNull String str, @NonNull String str2) {
                K(str, str2);
            }
        }, jSONObject, com.kwad.framework.a.a.mc.booleanValue(), com.kwad.framework.a.a.mc.booleanValue());
    }

    public static void c(boolean z, com.kwad.sdk.commercial.d.a aVar) {
        String str;
        BusinessType businessType;
        if (z) {
            str = "ad_sdk_reward_page_show";
        } else {
            str = "ad_sdk_fullscreen_page_show";
        }
        b L = b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L(str, "page_status");
        if (z) {
            businessType = BusinessType.AD_REWARD;
        } else {
            businessType = BusinessType.AD_FULLSCREEN;
        }
        d(L.a(businessType).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aRV));
    }

    public static void d(boolean z, com.kwad.sdk.commercial.d.a aVar) {
        String str;
        BusinessType businessType;
        if (z) {
            str = "ad_sdk_reward_callback_interaction";
        } else {
            str = "ad_sdk_fullscreen_callback_interaction";
        }
        if (z) {
            businessType = BusinessType.AD_REWARD;
        } else {
            businessType = BusinessType.AD_FULLSCREEN;
        }
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L(str, "callback_type").a(businessType).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void e(boolean z, com.kwad.sdk.commercial.d.a aVar) {
        String str;
        BusinessType businessType;
        if (z) {
            str = "ad_sdk_reward_callback_load";
        } else {
            str = "ad_sdk_fullscreen_callback_load";
        }
        if (z) {
            businessType = BusinessType.AD_REWARD;
        } else {
            businessType = BusinessType.AD_FULLSCREEN;
        }
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L(str, "callback_type").a(businessType).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void f(boolean z, com.kwad.sdk.commercial.d.a aVar) {
        String str;
        BusinessType businessType;
        if (z) {
            str = "ad_sdk_reward_play_error";
        } else {
            str = "ad_sdk_fullscreen_play_error";
        }
        b L = b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(1.0d).L(str, "reward_type");
        if (z) {
            businessType = BusinessType.AD_REWARD;
        } else {
            businessType = BusinessType.AD_FULLSCREEN;
        }
        d(L.a(businessType).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aSy));
    }

    public static void g(boolean z, com.kwad.sdk.commercial.d.a aVar) {
        double d;
        b cl = b.zP().cl(ILoggerReporter.Category.APM_LOG);
        if (z) {
            d = 1.0d;
        } else {
            d = 0.01d;
        }
        d(cl.i(d).L("ad_sdk_splash_single_cache", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSe));
    }

    public static void b(b bVar) {
        c.a MM;
        String str;
        if (!anr) {
            return;
        }
        com.kwad.sdk.commercial.d.b a = a(bVar);
        if (ann == -1.0f) {
            ann = new Random().nextFloat();
        }
        if (ano == -1.0d) {
            ano = new Random().nextFloat();
        }
        if ((!ant.xY() && ann > a.anQ) || !bo.ax(BuildConfig.VERSION_NAME, a.anS)) {
            return;
        }
        try {
            if (ILoggerReporter.Category.ERROR_LOG.equals(a(bVar.category, bVar))) {
                MM = c.a.ML();
            } else {
                MM = c.a.MM();
            }
            if (TextUtils.isEmpty(bVar.tag)) {
                str = bVar.eventId;
            } else {
                str = bVar.tag;
            }
            com.kwai.adclient.kscommerciallogger.a.MB().a(MM.b(bVar.anA).b(bVar.anB).gD(str).b(bVar.anC).gE(bVar.eventId).y(a(bVar.msg, a)).MN());
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            e eVar = (e) ServiceProvider.get(e.class);
            if (eVar != null) {
                eVar.gatherException(th);
            }
        }
    }

    public static void b(i iVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.1d).L("ad_perf_monitor_net_error", "network_monitor").u(iVar).a(d.aSH));
    }

    public static void c(b bVar) {
        if (ans == null) {
            ans = new CopyOnWriteArrayList();
        }
        ans.add(bVar);
    }

    public static void f(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.5d).L("ad_sdk_webview_track", "scene_id").a(BusinessType.AD_WEBVIEW).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void g(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(0.01d).L("ad_sdk_reward_performance", "reward_type").a(BusinessType.AD_REWARD).u(aVar).a(d.aSH));
    }

    public static void h(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.1d).L("ad_sdk_splash_load", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void i(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.1d).L("ad_sdk_splash_preload", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void j(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("ad_sdk_splash_cache", "cache").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSe));
    }

    public static void k(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("ad_sdk_splash_show", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void l(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(1.0d).L("ad_sdk_splash_monitor_view_error", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void m(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(1.0d).L("ad_sdk_splash_monitor_template_data_error", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void n(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(1.0d).L("ad_sdk_splash_monitor_errorcode_error", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void o(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(1.0d).L("ad_sdk_dynamic_run", PraiseUBCHelper.SOURCE_DYNAMIC).a(com.kwai.adclient.kscommerciallogger.model.a.aSf).u(aVar));
    }

    public static void p(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("ad_sdk_block_info", BreakpointSQLiteHelper.BLOCK_TABLE_NAME).a(com.kwai.adclient.kscommerciallogger.model.b.aSy).u(aVar));
    }

    public static void q(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("ad_image_load_perf", "image_perf").u(aVar).a(d.aSH));
    }

    public static void r(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(1.0d).L("ad_thread_monitor", "thread_perf").u(aVar).a(d.aSH));
    }

    public static void s(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.001d).L("ad_video_load_perf", "video_load_perf").cm("ad_video_load_perf").u(aVar).a(d.aSH));
    }

    public static void t(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.001d).L("ad_video_load_failed", "video_load_failed").cm("ad_video_load_failed").u(aVar).a(d.aSH));
    }

    public static void b(j jVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(1.0E-5d).L("ad_perf_monitor_net_success", "network_monitor").u(jVar).a(d.aSH));
    }

    public static void b(@NonNull com.kwad.sdk.utils.b.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("ad_union_kv_fail_rate", KVStorageUtils.KV_FILE_TYPE).u(aVar).a(d.aSH));
    }

    public static void b(String str, HybridLoadMsg hybridLoadMsg) {
        double d;
        if (ILoggerReporter.Category.ERROR_LOG.equals(str)) {
            d = 1.0d;
        } else {
            d = 0.001d;
        }
        d(b.zP().cl(str).i(d).L("union_web_cache_load_event", "state").a(BusinessType.WEB_CACHE).u(hybridLoadMsg).a(d.aSH));
    }

    public static void b(boolean z, com.kwad.sdk.commercial.d.a aVar) {
        String str;
        BusinessType businessType;
        if (z) {
            str = "ad_sdk_reward_download_error";
        } else {
            str = "ad_sdk_fullscreen_download_error";
        }
        b L = b.zP().cl(ILoggerReporter.Category.ERROR_LOG).i(1.0d).L(str, "download_type");
        if (z) {
            businessType = BusinessType.AD_REWARD;
        } else {
            businessType = BusinessType.AD_FULLSCREEN;
        }
        d(L.a(businessType).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aSs));
    }

    public static synchronized void d(b bVar) {
        synchronized (a.class) {
            if (com.kwad.framework.a.a.mc.booleanValue()) {
                if (bVar.category.equals(ILoggerReporter.Category.ERROR_LOG)) {
                    com.kwad.sdk.core.e.c.e("KCLogReporter", "reportItem: " + bVar);
                } else {
                    com.kwad.sdk.core.e.c.d("KCLogReporter", "reportItem: " + bVar);
                }
            }
            if (!anp.get()) {
                c(bVar);
            } else {
                b(bVar);
            }
        }
    }

    public static void g(JSONObject jSONObject) {
        String str;
        int optInt = jSONObject.optInt("load_status");
        if (optInt != 3 && optInt != 4 && optInt != 7) {
            str = ILoggerReporter.Category.APM_LOG;
        } else {
            str = ILoggerReporter.Category.ERROR_LOG;
        }
        d(b.zP().cl(str).i(1.0d).j(0.1d).k(0.001d).L("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.aSf).h(jSONObject));
    }

    public static void e(com.kwad.sdk.commercial.d.a aVar) {
        d(b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("ad_sdk_reward_check_result", "check_type").a(BusinessType.AD_REWARD).u(aVar).a(new com.kwai.adclient.kscommerciallogger.model.b("RESULT_CHECK_REWARD")));
    }

    public static void zL() {
        try {
            anu = new HashMap();
            JSONObject xZ = ant.xZ();
            if (xZ == null) {
                if (!com.kwad.framework.a.a.mc.booleanValue()) {
                    return;
                }
                throw new Exception("reportConf未初始化");
            }
            Iterator<String> keys = xZ.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (xZ.opt(next) instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) xZ.opt(next);
                    new JSONArray();
                    if (jSONObject.opt(MapBundleKey.OfflineMapKey.OFFLINE_RATION) instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) jSONObject.opt(MapBundleKey.OfflineMapKey.OFFLINE_RATION);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            if (jSONArray.get(i) instanceof String) {
                                com.kwad.sdk.commercial.d.c cVar = new com.kwad.sdk.commercial.d.c();
                                String a = a(cVar, (String) jSONArray.get(i));
                                if (anu.containsKey(a) && anu.get(a) != null) {
                                    anu.get(a).anT = true;
                                    anu.get(a).anQ = Double.parseDouble(next);
                                } else {
                                    cVar.anT = true;
                                    cVar.anQ = Double.parseDouble(next);
                                    anu.put(a, cVar);
                                }
                            }
                        }
                    }
                    if (jSONObject.opt("ratioApmRL") instanceof JSONArray) {
                        JSONArray jSONArray2 = (JSONArray) jSONObject.opt("ratioApmRL");
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            if (jSONArray2.get(i2) instanceof String) {
                                com.kwad.sdk.commercial.d.c cVar2 = new com.kwad.sdk.commercial.d.c();
                                String a2 = a(cVar2, (String) jSONArray2.get(i2));
                                if (anu.containsKey(a2) && anu.get(a2) != null) {
                                    anu.get(a2).anU = true;
                                    anu.get(a2).anR = Double.parseDouble(next);
                                } else {
                                    cVar2.anU = true;
                                    cVar2.anR = Double.parseDouble(next);
                                    anu.put(a2, cVar2);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }
}
