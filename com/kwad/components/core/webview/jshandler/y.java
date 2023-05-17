package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class y implements com.kwad.sdk.core.webview.kwai.a {
    @Nullable
    public KsAppDownloadListener KW;
    @Nullable
    public com.kwad.sdk.core.webview.kwai.c Lb;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public final com.kwad.sdk.core.webview.b mJsBridgeContext;

    @KsJson
    /* loaded from: classes9.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public double MD;
        public int status;
    }

    @KsJson
    /* loaded from: classes9.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public String LY;
        public long MI;
        public String Ma;
        public String appName;
        public String icon;
        public String np;
        public String url;
        public String version;
        public int versionCode;
    }

    public y(com.kwad.sdk.core.webview.b bVar) {
        this.mJsBridgeContext = bVar;
        try {
            this.mAdTemplate = new AdTemplate();
            AdTemplate adTemplate = this.mJsBridgeContext.getAdTemplate();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.Lb != null) {
            a aVar = new a();
            aVar.MD = f;
            aVar.status = i;
            this.Lb.a(aVar);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.LY;
        adBaseInfo.appName = bVar.appName;
        adBaseInfo.appVersion = bVar.version;
        adBaseInfo.packageSize = bVar.MI;
        adBaseInfo.appIconUrl = bVar.icon;
        adBaseInfo.appDescription = bVar.np;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.url;
        adConversionInfo.appDownloadUrl = str;
        adInfo.downloadId = com.kwad.sdk.utils.ab.dI(str);
    }

    private KsAppDownloadListener pu() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.webview.jshandler.y.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                y.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                y.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                y.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                y.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                y.this.a(3, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                y.this.a(2, (i * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.components.core.c.a.c cVar2;
        int i;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i = 2;
        } else {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
            a(bQ, bVar);
            if (this.mApkDownloadHelper == null) {
                this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            }
            cVar2 = this.mApkDownloadHelper;
            i = 1;
        }
        cVar2.ah(i);
        this.Lb = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.KW;
        if (ksAppDownloadListener != null) {
            this.mApkDownloadHelper.d(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener pu = pu();
        this.KW = pu;
        this.mApkDownloadHelper.b(pu);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerApkStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.Lb = null;
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.KW) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.KW = null;
    }
}
