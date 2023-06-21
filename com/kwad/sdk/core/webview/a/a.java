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
/* loaded from: classes10.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {

    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0674a extends com.kwad.sdk.core.response.kwai.a {
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

        public static C0674a wi() {
            C0674a c0674a = new C0674a();
            c0674a.LF = BuildConfig.VERSION_NAME;
            c0674a.LG = BuildConfig.VERSION_CODE;
            c0674a.abe = "4.0.2";
            c0674a.LH = ((d) ServiceProvider.get(d.class)).getApiVersion();
            c0674a.LI = ((d) ServiceProvider.get(d.class)).getApiVersionCode();
            c0674a.LJ = 1;
            Context context = ((d) ServiceProvider.get(d.class)).getContext();
            c0674a.appVersion = j.cb(context);
            c0674a.appName = ((d) ServiceProvider.get(d.class)).getAppName();
            c0674a.appId = ((d) ServiceProvider.get(d.class)).getAppId();
            c0674a.agm = "";
            c0674a.acB = w.zE();
            f fVar = (f) c.f(f.class);
            if (fVar != null) {
                c0674a.acA = fVar.nb();
            }
            c0674a.LK = String.valueOf(ae.cw(context));
            c0674a.LL = az.AN();
            c0674a.model = az.AE();
            c0674a.LM = az.AG();
            c0674a.LN = 1;
            c0674a.LO = az.getOsVersion();
            c0674a.LP = az.AQ();
            c0674a.LQ = az.getLanguage();
            c0674a.LR = az.getLocale();
            c0674a.agn = ar.getDeviceId();
            c0674a.LS = az.getScreenWidth(context);
            c0674a.LT = az.getScreenHeight(context);
            c0674a.VB = ar.cI(context);
            c0674a.VC = ar.getOaid();
            c0674a.acv = ar.cJ(context);
            c0674a.acO = ar.cK(context);
            c0674a.LU = com.kwad.sdk.b.kwai.a.aH(context);
            c0674a.LV = com.kwad.sdk.b.kwai.a.a(context, 50.0f);
            return c0674a;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        cVar.a(C0674a.wi());
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
