package com.kwad.sdk.i;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.commercial.d.a {
        public String aEm;
        public int aHV;
        public String sdkVersion;
    }

    @KsJson
    /* renamed from: com.kwad.sdk.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0722b extends com.kwad.sdk.commercial.d.a {
        public int aHW;
        public String aHX;
        public String aHY;
        public String aHZ;
        public String aIa;
        public String aIb;
    }

    public static void HQ() {
        g.execute(new ay() { // from class: com.kwad.sdk.i.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.HR();
            }
        });
    }

    public static void HR() {
        a a2;
        JSONObject jSONObject = (JSONObject) d.AR().getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.i.b.2
            public static JSONObject m(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return m(jSONObject2);
            }
        });
        if (jSONObject == null) {
            return;
        }
        C0722b c0722b = new C0722b();
        try {
            c0722b.parseJson(jSONObject);
            if (c0722b.aHW == 1 && (a2 = a(ServiceProvider.getContext().getClassLoader(), c0722b)) != null) {
                com.kwad.sdk.commercial.a.d(com.kwad.sdk.commercial.b.zP().cl(ILoggerReporter.Category.APM_LOG).i(0.01d).L("ad_sdk_tt_sdk_info", "sv").u(a2).a(com.kwai.adclient.kscommerciallogger.model.a.aSf));
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public static a a(ClassLoader classLoader, C0722b c0722b) {
        Class<?> a2 = s.a(c0722b.aHX, classLoader);
        if (a2 == null) {
            return null;
        }
        a aVar = new a();
        aVar.aHV = s.classExists(c0722b.aHY) ? 1 : 0;
        Object callStaticMethod = s.callStaticMethod(a2, c0722b.aHZ, new Object[0]);
        aVar.sdkVersion = (String) s.callMethod(callStaticMethod, c0722b.aIa, new Object[0]);
        aVar.aEm = (String) s.callMethod(callStaticMethod, c0722b.aIb, new Object[0]);
        return aVar;
    }
}
