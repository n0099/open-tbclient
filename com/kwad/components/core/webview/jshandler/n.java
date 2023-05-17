package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
/* loaded from: classes9.dex */
public final class n implements com.kwad.sdk.core.webview.kwai.a {

    @KsJson
    /* loaded from: classes9.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
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
        public String appId;
        public String appName;
        public String appVersion;
        public String model;

        public static a px() {
            a aVar = new a();
            aVar.LF = BuildConfig.VERSION_NAME;
            aVar.LG = BuildConfig.VERSION_CODE;
            aVar.LH = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getApiVersion();
            aVar.LI = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getApiVersionCode();
            aVar.LJ = 1;
            Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
            aVar.appVersion = com.kwad.sdk.utils.j.cb(context);
            aVar.appName = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getAppName();
            aVar.appId = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getAppId();
            aVar.LK = String.valueOf(com.kwad.sdk.utils.ae.cw(context));
            aVar.LL = az.AN();
            aVar.model = az.AE();
            aVar.LM = az.AG();
            aVar.LN = 1;
            aVar.LO = az.getOsVersion();
            aVar.LP = az.AQ();
            aVar.LQ = az.getLanguage();
            aVar.LR = az.getLocale();
            aVar.LS = az.getScreenWidth(context);
            aVar.LT = az.getScreenHeight(context);
            aVar.LU = com.kwad.sdk.b.kwai.a.aH(context);
            aVar.LV = com.kwad.sdk.b.kwai.a.a(context, 50.0f);
            return aVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        cVar.a(a.px());
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "getKsPlayableDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
    }
}
