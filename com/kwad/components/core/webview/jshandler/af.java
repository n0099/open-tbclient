package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
/* loaded from: classes10.dex */
public final class af implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsPlayableDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String WA;
        public int WB;
        public String WC;
        public String WD;
        public String WE;
        public int WF;
        public String WG;
        public int WH;
        public String WI;
        public String WJ;
        public int WK;
        public int WL;
        public int WM;
        public int WN;
        public String Wy;
        public int Wz;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;
        public int sdkType;

        public static a sc() {
            a aVar = new a();
            aVar.Wy = BuildConfig.VERSION_NAME;
            aVar.Wz = BuildConfig.VERSION_CODE;
            aVar.WA = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
            aVar.WB = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersionCode();
            aVar.sdkType = 1;
            Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
            aVar.appVersion = com.kwad.sdk.utils.k.bQ(context);
            aVar.appName = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppName();
            aVar.appId = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getAppId();
            aVar.WC = String.valueOf(com.kwad.sdk.utils.ag.ck(context));
            aVar.WD = bi.LD();
            aVar.model = bi.Lu();
            aVar.WE = bi.Lw();
            aVar.WF = 1;
            aVar.WG = bi.getOsVersion();
            aVar.WH = bi.LG();
            aVar.WI = bi.getLanguage();
            aVar.WJ = bi.getLocale();
            aVar.WK = bi.getScreenWidth(context);
            aVar.WL = bi.getScreenHeight(context);
            aVar.WM = com.kwad.sdk.d.a.a.getStatusBarHeight(context);
            aVar.WN = com.kwad.sdk.d.a.a.a(context, 50.0f);
            return aVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(a.sc());
    }
}
