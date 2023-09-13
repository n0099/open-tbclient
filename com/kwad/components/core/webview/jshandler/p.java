package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class p implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.b Lk;
    public final Handler Ll = new Handler(Looper.getMainLooper());
    public final AdTemplate mAdTemplate = new AdTemplate();
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    @KsJson
    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String LY;
        public int LZ;
        public String Ma;
        public String Mb;
        public String Mc;
        @Deprecated
        public boolean Md;
        public boolean Me;
        public boolean Mf;
        public String appId;
        public String appName;
        public String icon;
        public String np;
        public int type;
        public String url;
        public String version;
        public int versionCode;
    }

    public p(com.kwad.sdk.core.webview.b bVar) {
        this.Lk = bVar;
        try {
            AdTemplate adTemplate = this.Lk.getAdTemplate();
            if (adTemplate != null) {
                if (adTemplate.mOriginJString != null) {
                    this.mAdTemplate.parseJson(new JSONObject(adTemplate.mOriginJString));
                } else {
                    this.mAdTemplate.parseJson(adTemplate.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.Mb;
        adConversionInfo.marketUrl = aVar.Mc;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.type;
        adBaseInfo.appPackageName = aVar.LY;
        adBaseInfo.appName = aVar.appName;
        adBaseInfo.appVersion = aVar.version;
        adBaseInfo.packageSize = aVar.LZ;
        adBaseInfo.appIconUrl = aVar.icon;
        adBaseInfo.appDescription = aVar.np;
        if (!com.kwad.sdk.core.response.a.a.am(adInfo)) {
            adInfo.adConversionInfo.h5Url = aVar.url;
            return;
        }
        AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
        String str = aVar.url;
        adConversionInfo2.appDownloadUrl = str;
        adInfo.downloadId = com.kwad.sdk.utils.ab.dI(str);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.components.core.c.a.c cVar2;
        int i;
        if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i = 2;
        } else {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
            a(bQ, aVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i = 1;
        }
        cVar2.ah(i);
        this.Ll.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.p.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.c.a.a.a(new a.C0643a(p.this.Lk.Gl.getContext()).L(p.this.mAdTemplate).b(p.this.mApkDownloadHelper).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.p.1.1
                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                    }
                }));
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.Ll.removeCallbacksAndMessages(null);
    }
}
