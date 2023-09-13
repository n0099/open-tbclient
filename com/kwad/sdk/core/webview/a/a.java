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
    public static final class C0686a extends com.kwad.sdk.core.response.kwai.a {
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

        public static C0686a wi() {
            C0686a c0686a = new C0686a();
            c0686a.LF = BuildConfig.VERSION_NAME;
            c0686a.LG = BuildConfig.VERSION_CODE;
            c0686a.abe = "4.0.2";
            c0686a.LH = ((d) ServiceProvider.get(d.class)).getApiVersion();
            c0686a.LI = ((d) ServiceProvider.get(d.class)).getApiVersionCode();
            c0686a.LJ = 1;
            Context context = ((d) ServiceProvider.get(d.class)).getContext();
            c0686a.appVersion = j.cb(context);
            c0686a.appName = ((d) ServiceProvider.get(d.class)).getAppName();
            c0686a.appId = ((d) ServiceProvider.get(d.class)).getAppId();
            c0686a.agm = "";
            c0686a.acB = w.zE();
            f fVar = (f) c.f(f.class);
            if (fVar != null) {
                c0686a.acA = fVar.nb();
            }
            c0686a.LK = String.valueOf(ae.cw(context));
            c0686a.LL = az.AN();
            c0686a.model = az.AE();
            c0686a.LM = az.AG();
            c0686a.LN = 1;
            c0686a.LO = az.getOsVersion();
            c0686a.LP = az.AQ();
            c0686a.LQ = az.getLanguage();
            c0686a.LR = az.getLocale();
            c0686a.agn = ar.getDeviceId();
            c0686a.LS = az.getScreenWidth(context);
            c0686a.LT = az.getScreenHeight(context);
            c0686a.VB = ar.cI(context);
            c0686a.VC = ar.getOaid();
            c0686a.acv = ar.cJ(context);
            c0686a.acO = ar.cK(context);
            c0686a.LU = com.kwad.sdk.b.kwai.a.aH(context);
            c0686a.LV = com.kwad.sdk.b.kwai.a.a(context, 50.0f);
            return c0686a;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        cVar.a(C0686a.wi());
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
