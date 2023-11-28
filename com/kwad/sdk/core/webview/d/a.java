package com.kwad.sdk.core.webview.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.y;
/* loaded from: classes10.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return CommonTbJsBridge.GET_DEVICE_INFO;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @KsJson
    /* renamed from: com.kwad.sdk.core.webview.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0715a extends com.kwad.sdk.core.response.a.a {
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
        public String aDB;
        public String aDC;
        public boolean aDD;
        public String aDE;
        public String appId;
        public String appName;
        public String appVersion;
        public String arh;
        public String ari;
        public String awC;
        public String ayC;
        public String ayl;
        public String ayq;
        public String ayr;
        public String model;
        public int sdkType;

        public static C0715a FR() {
            C0715a c0715a = new C0715a();
            c0715a.Wy = BuildConfig.VERSION_NAME;
            c0715a.Wz = BuildConfig.VERSION_CODE;
            c0715a.awC = "5.1.4";
            c0715a.aDE = "1.3";
            c0715a.WA = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c0715a.WB = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c0715a.sdkType = 1;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c0715a.appVersion = k.bQ(context);
            c0715a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c0715a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c0715a.aDB = "";
            c0715a.ayr = y.Kj();
            com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) c.f(com.kwad.sdk.components.f.class);
            if (fVar != null) {
                c0715a.ayq = fVar.om();
            }
            c0715a.WC = String.valueOf(ag.ck(context));
            c0715a.WD = bi.LD();
            c0715a.model = bi.Lu();
            c0715a.WE = bi.Lw();
            c0715a.WF = 1;
            c0715a.WG = bi.getOsVersion();
            c0715a.WH = bi.LG();
            c0715a.WI = bi.getLanguage();
            c0715a.WJ = bi.getLocale();
            c0715a.aDD = ((f) ServiceProvider.get(f.class)).getIsExternal();
            c0715a.aDC = av.getDeviceId();
            c0715a.WK = bi.getScreenWidth(context);
            c0715a.WL = bi.getScreenHeight(context);
            c0715a.arh = av.cv(context);
            c0715a.ari = av.getOaid();
            c0715a.ayl = av.cw(context);
            c0715a.ayC = av.cx(context);
            c0715a.WM = com.kwad.sdk.d.a.a.getStatusBarHeight(context);
            c0715a.WN = com.kwad.sdk.d.a.a.a(context, 50.0f);
            return c0715a;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(C0715a.FR());
    }
}
