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
    public static final class C0639a extends com.kwad.sdk.core.response.kwai.a {
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

        public static C0639a wi() {
            C0639a c0639a = new C0639a();
            c0639a.LF = BuildConfig.VERSION_NAME;
            c0639a.LG = BuildConfig.VERSION_CODE;
            c0639a.abe = "4.0.2";
            c0639a.LH = ((d) ServiceProvider.get(d.class)).getApiVersion();
            c0639a.LI = ((d) ServiceProvider.get(d.class)).getApiVersionCode();
            c0639a.LJ = 1;
            Context context = ((d) ServiceProvider.get(d.class)).getContext();
            c0639a.appVersion = j.cb(context);
            c0639a.appName = ((d) ServiceProvider.get(d.class)).getAppName();
            c0639a.appId = ((d) ServiceProvider.get(d.class)).getAppId();
            c0639a.agm = "";
            c0639a.acB = w.zE();
            f fVar = (f) c.f(f.class);
            if (fVar != null) {
                c0639a.acA = fVar.nb();
            }
            c0639a.LK = String.valueOf(ae.cw(context));
            c0639a.LL = az.AN();
            c0639a.model = az.AE();
            c0639a.LM = az.AG();
            c0639a.LN = 1;
            c0639a.LO = az.getOsVersion();
            c0639a.LP = az.AQ();
            c0639a.LQ = az.getLanguage();
            c0639a.LR = az.getLocale();
            c0639a.agn = ar.getDeviceId();
            c0639a.LS = az.getScreenWidth(context);
            c0639a.LT = az.getScreenHeight(context);
            c0639a.VB = ar.cI(context);
            c0639a.VC = ar.getOaid();
            c0639a.acv = ar.cJ(context);
            c0639a.acO = ar.cK(context);
            c0639a.LU = com.kwad.sdk.b.kwai.a.aH(context);
            c0639a.LV = com.kwad.sdk.b.kwai.a.a(context, 50.0f);
            return c0639a;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        cVar.a(C0639a.wi());
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
