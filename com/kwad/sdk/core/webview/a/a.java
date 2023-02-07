package com.kwad.sdk.core.webview.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.c;
import com.kwad.sdk.components.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.d;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.w;
/* loaded from: classes8.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {

    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0640a extends com.kwad.sdk.core.response.kwai.a {
        public String LF;
        public int LG;
        public String LH;
        public int LI;
        public int LJ;
        public String LK;
        public String LL;
        public String LM;
        public int LN;
        public String LO;
        public int LP;
        public String LQ;
        public String LR;
        public int LS;
        public int LT;
        public int LU;
        public int LV;
        public String VB;
        public String VC;
        public String abe;
        public String acA;
        public String acB;
        public String acO;
        public String acv;
        public String agm;
        public String agn;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;

        public static C0640a wi() {
            C0640a c0640a = new C0640a();
            c0640a.LF = BuildConfig.VERSION_NAME;
            c0640a.LG = BuildConfig.VERSION_CODE;
            c0640a.abe = "4.0.2";
            c0640a.LH = ((d) ServiceProvider.get(d.class)).getApiVersion();
            c0640a.LI = ((d) ServiceProvider.get(d.class)).getApiVersionCode();
            c0640a.LJ = 1;
            Context context = ((d) ServiceProvider.get(d.class)).getContext();
            c0640a.appVersion = j.cb(context);
            c0640a.appName = ((d) ServiceProvider.get(d.class)).getAppName();
            c0640a.appId = ((d) ServiceProvider.get(d.class)).getAppId();
            c0640a.agm = "";
            c0640a.acB = w.zE();
            f fVar = (f) c.f(f.class);
            if (fVar != null) {
                c0640a.acA = fVar.nb();
            }
            c0640a.LK = String.valueOf(ae.cw(context));
            c0640a.LL = az.AN();
            c0640a.model = az.AE();
            c0640a.LM = az.AG();
            c0640a.LN = 1;
            c0640a.LO = az.getOsVersion();
            c0640a.LP = az.AQ();
            c0640a.LQ = az.getLanguage();
            c0640a.LR = az.getLocale();
            c0640a.agn = ar.getDeviceId();
            c0640a.LS = az.getScreenWidth(context);
            c0640a.LT = az.getScreenHeight(context);
            c0640a.VB = ar.cI(context);
            c0640a.VC = ar.getOaid();
            c0640a.acv = ar.cJ(context);
            c0640a.acO = ar.cK(context);
            c0640a.LU = com.kwad.sdk.b.kwai.a.aH(context);
            c0640a.LV = com.kwad.sdk.b.kwai.a.a(context, 50.0f);
            return c0640a;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        cVar.a(C0640a.wi());
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return CommonTbJsBridge.GET_DEVICE_INFO;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
