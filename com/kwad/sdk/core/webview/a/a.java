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
/* loaded from: classes9.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {

    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C0653a extends com.kwad.sdk.core.response.kwai.a {
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

        public static C0653a wi() {
            C0653a c0653a = new C0653a();
            c0653a.LF = BuildConfig.VERSION_NAME;
            c0653a.LG = BuildConfig.VERSION_CODE;
            c0653a.abe = "4.0.2";
            c0653a.LH = ((d) ServiceProvider.get(d.class)).getApiVersion();
            c0653a.LI = ((d) ServiceProvider.get(d.class)).getApiVersionCode();
            c0653a.LJ = 1;
            Context context = ((d) ServiceProvider.get(d.class)).getContext();
            c0653a.appVersion = j.cb(context);
            c0653a.appName = ((d) ServiceProvider.get(d.class)).getAppName();
            c0653a.appId = ((d) ServiceProvider.get(d.class)).getAppId();
            c0653a.agm = "";
            c0653a.acB = w.zE();
            f fVar = (f) c.f(f.class);
            if (fVar != null) {
                c0653a.acA = fVar.nb();
            }
            c0653a.LK = String.valueOf(ae.cw(context));
            c0653a.LL = az.AN();
            c0653a.model = az.AE();
            c0653a.LM = az.AG();
            c0653a.LN = 1;
            c0653a.LO = az.getOsVersion();
            c0653a.LP = az.AQ();
            c0653a.LQ = az.getLanguage();
            c0653a.LR = az.getLocale();
            c0653a.agn = ar.getDeviceId();
            c0653a.LS = az.getScreenWidth(context);
            c0653a.LT = az.getScreenHeight(context);
            c0653a.VB = ar.cI(context);
            c0653a.VC = ar.getOaid();
            c0653a.acv = ar.cJ(context);
            c0653a.acO = ar.cK(context);
            c0653a.LU = com.kwad.sdk.b.kwai.a.aH(context);
            c0653a.LV = com.kwad.sdk.b.kwai.a.a(context, 50.0f);
            return c0653a;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        cVar.a(C0653a.wi());
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
