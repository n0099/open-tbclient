package com.kwad.sdk.core.webview.a;

import android.content.Context;
import com.baidu.tbadk.browser.CommonTbJsBridge;
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
/* loaded from: classes7.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {

    /* renamed from: com.kwad.sdk.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C0609a extends com.kwad.sdk.core.response.kwai.a {
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

        public static C0609a wi() {
            C0609a c0609a = new C0609a();
            c0609a.LF = BuildConfig.VERSION_NAME;
            c0609a.LG = BuildConfig.VERSION_CODE;
            c0609a.abe = "4.0.2";
            c0609a.LH = ((d) ServiceProvider.get(d.class)).getApiVersion();
            c0609a.LI = ((d) ServiceProvider.get(d.class)).getApiVersionCode();
            c0609a.LJ = 1;
            Context context = ((d) ServiceProvider.get(d.class)).getContext();
            c0609a.appVersion = j.cb(context);
            c0609a.appName = ((d) ServiceProvider.get(d.class)).getAppName();
            c0609a.appId = ((d) ServiceProvider.get(d.class)).getAppId();
            c0609a.agm = "";
            c0609a.acB = w.zE();
            f fVar = (f) c.f(f.class);
            if (fVar != null) {
                c0609a.acA = fVar.nb();
            }
            c0609a.LK = String.valueOf(ae.cw(context));
            c0609a.LL = az.AN();
            c0609a.model = az.AE();
            c0609a.LM = az.AG();
            c0609a.LN = 1;
            c0609a.LO = az.getOsVersion();
            c0609a.LP = az.AQ();
            c0609a.LQ = az.getLanguage();
            c0609a.LR = az.getLocale();
            c0609a.agn = ar.getDeviceId();
            c0609a.LS = az.getScreenWidth(context);
            c0609a.LT = az.getScreenHeight(context);
            c0609a.VB = ar.cI(context);
            c0609a.VC = ar.getOaid();
            c0609a.acv = ar.cJ(context);
            c0609a.acO = ar.cK(context);
            c0609a.LU = com.kwad.sdk.b.kwai.a.aH(context);
            c0609a.LV = com.kwad.sdk.b.kwai.a.a(context, 50.0f);
            return c0609a;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, com.kwad.sdk.core.webview.kwai.c cVar) {
        cVar.a(C0609a.wi());
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final String getKey() {
        return CommonTbJsBridge.GET_DEVICE_INFO;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
