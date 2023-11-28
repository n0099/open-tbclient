package com.kwad.components.ad.feed.monitor;

import com.kwad.components.ad.feed.c;
import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public static void a(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "feedLoadOptimizeType", d.An());
        t.putValue(jSONObject, "feedLoadOptimizeExternalEnable", d.Aq());
        t.putValue(jSONObject, "isExternal", KsAdSDKImpl.get().getIsExternal());
        a(new FeedPageInfo().setStatus(6).setAdNum(i).setLoadDataDuration(j).setAbParams(jSONObject.toString()));
    }

    public static void a(int i, AdTemplate adTemplate, String str, int i2) {
        b(new FeedPageInfo().setCallbackType(i).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dP(adTemplate))).setMaterialUrl(str).setRenderType(i2).setAdTemplate(adTemplate));
    }

    public static void a(long j, int i, int i2) {
        a("ad_sdk_feed_width_monitor", new FeedErrorInfo().setWidth(j).setMaterialType(i).setFeedType(i2), 1.0d);
    }

    public static void a(long j, List<KsFeedAd> list) {
        if (list != null && list.size() != 0 && (list.get(0) instanceof c)) {
            b(new FeedPageInfo().setCallbackType(1).setPosId(j).setMaterialInfoList(c(list)).setAdTemplate(((c) list.get(0)).getAdTemplate()));
        }
    }

    public static void a(com.kwad.sdk.commercial.d.a aVar) {
        a(aVar, false);
    }

    public static void b(com.kwad.sdk.commercial.d.a aVar) {
        com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("ad_sdk_feed_callback", "callback_type").a(BusinessType.AD_FEED).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void e(AdTemplate adTemplate) {
        a(new FeedPageInfo().setStatus(11).setAdTemplate(adTemplate));
    }

    public static void f(AdTemplate adTemplate) {
        com.kwad.sdk.commercial.a.f(new FeedWebViewInfo().setEvent("ad_show").setSceneId("ad_feed").setAdTemplate(adTemplate));
    }

    public static void s(int i) {
        a(new FeedPageInfo().setStatus(1).setAdNum(i));
    }

    public static void t(int i) {
        a(new FeedPageInfo().setStatus(2).setAdNum(i));
    }

    public static void a(com.kwad.sdk.commercial.d.a aVar, boolean z) {
        String str;
        double d;
        com.kwad.sdk.commercial.b zP = com.kwad.sdk.commercial.b.zP();
        if (z) {
            str = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str = ILoggerReporter.Category.APM_LOG;
        }
        com.kwad.sdk.commercial.b cl = zP.cl(str);
        if (z) {
            d = 1.0d;
        } else {
            d = 0.001d;
        }
        com.kwad.sdk.commercial.a.d(cl.i(d).L("ad_sdk_feed_load", "status").a(BusinessType.AD_FEED).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
    }

    public static void a(AdTemplate adTemplate, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "feedLoadOptimizeType", d.An());
        t.putValue(jSONObject, "feedLoadOptimizeExternalEnable", d.Aq());
        t.putValue(jSONObject, "isExternal", KsAdSDKImpl.get().getIsExternal());
        a(new FeedPageInfo().setStatus(7).setType(adTemplate.type).setLoadType(adTemplate.loadType).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dP(adTemplate))).setRenderType(i).setExpectedRenderType(i2).setAbParams(jSONObject.toString()).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, int i2, long j, String str) {
        boolean z;
        com.kwad.sdk.commercial.d.a adTemplate2 = new FeedPageInfo().setStatus(5).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dP(adTemplate))).setRenderType(i).setLoadType(adTemplate.loadType).setExpectedRenderType(i2).setErrorMsg(str).setRenderDuration(j).setAdTemplate(adTemplate);
        if (i != 2) {
            z = true;
        } else {
            z = false;
        }
        a(adTemplate2, z);
    }

    public static void a(AdTemplate adTemplate, int i, int i2, String str, String str2, long j) {
        boolean z = true;
        if (i2 == 1 && adTemplate.mHasReportVideoLoad) {
            return;
        }
        if (i2 == 1) {
            adTemplate.mHasReportVideoLoad = true;
        }
        com.kwad.sdk.commercial.d.a adTemplate2 = new FeedPageInfo().setStatus(3).setType(adTemplate.type).setLoadStatus(i).setResourceLoadDuration(j).setMaterialType(i2).setMaterialUrl(str).setErrorMsg(str2).setAdTemplate(adTemplate);
        if (i != 2) {
            z = false;
        }
        a(adTemplate2, z);
    }

    public static void a(AdTemplate adTemplate, int i, long j) {
        a(new FeedPageInfo().setStatus(8).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dP(adTemplate))).setRenderType(i).setConvertDuration(j).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str) {
        com.kwad.sdk.commercial.a.f(new FeedWebViewInfo().setEvent("webview_load_url").setSceneId("ad_feed").setUrl(str).setAdTemplate(adTemplate));
    }

    public static void d(int i, String str) {
        a((com.kwad.sdk.commercial.d.a) new FeedPageInfo().setStatus(9).setErrorCode(i).setErrorMsg(str), true);
    }

    public static void e(int i, int i2) {
        a("ad_sdk_feed_showType_monitor", new FeedErrorInfo().setMaterialType(i).setFeedType(i2), 1.0d);
    }

    public static void f(int i, int i2) {
        a("ad_sdk_feed_h5_monitor", (FeedErrorInfo) new FeedErrorInfo().setMaterialType(i2).setErrorCode(i), 1.0d);
    }

    public static void a(AdTemplate adTemplate, String str, long j) {
        com.kwad.sdk.commercial.a.f(new FeedWebViewInfo().setEvent("webview_load_finish").setSceneId("ad_feed").setDurationMs(j).setUrl(str).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str, long j, int i) {
        com.kwad.sdk.commercial.a.f(new FeedWebViewInfo().setEvent("webview_timeout").setSceneId("ad_feed").setTimeType(i).setDurationMs(j).setUrl(str).setAdTemplate(adTemplate));
    }

    public static void a(String str, FeedErrorInfo feedErrorInfo, double d) {
        try {
            com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.ERROR_LOG).a(BusinessType.AD_FEED).L(str, "default").cm(str).a(com.kwai.adclient.kscommerciallogger.model.a.aSf).u(feedErrorInfo).i(d));
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.d("reportFeedError", e.toString());
        }
    }

    public static void aY() {
        a("ad_sdk_feed_adnum_monitor", new FeedErrorInfo(), 1.0E-4d);
    }

    public static void aZ() {
        com.kwad.sdk.commercial.a.f(new FeedWebViewInfo().setEvent("webview_init").setSceneId("ad_feed"));
    }

    public static List<FeedPageInfo.a> c(List<KsFeedAd> list) {
        ArrayList arrayList = new ArrayList();
        for (KsFeedAd ksFeedAd : list) {
            if (ksFeedAd instanceof c) {
                AdInfo dP = e.dP(((c) ksFeedAd).getAdTemplate());
                arrayList.add(new FeedPageInfo.a().d(com.kwad.sdk.core.response.b.a.J(dP)).u(com.kwad.sdk.core.response.b.a.be(dP)).o(com.kwad.sdk.core.response.b.a.bb(dP)));
            }
        }
        return arrayList;
    }

    public static void e(int i, String str) {
        boolean z;
        FeedPageInfo errorMsg = new FeedPageInfo().setStatus(10).setLoadStatus(i).setErrorMsg(str);
        if (i == 2) {
            z = true;
        } else {
            z = false;
        }
        a(errorMsg, z);
    }

    public static void f(int i, String str) {
        a("ad_sdk_feed_request_monitor", (FeedErrorInfo) new FeedErrorInfo().setErrorCode(i).setErrorMsg(str), 1.0d);
    }
}
