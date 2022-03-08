package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class q implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f54989b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f54990c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f54991d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f54992e;

    /* loaded from: classes8.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public double a;

        /* renamed from: b  reason: collision with root package name */
        public int f54994b;
    }

    /* loaded from: classes8.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f54995b;

        /* renamed from: c  reason: collision with root package name */
        public String f54996c;

        /* renamed from: d  reason: collision with root package name */
        public int f54997d;

        /* renamed from: e  reason: collision with root package name */
        public long f54998e;

        /* renamed from: f  reason: collision with root package name */
        public String f54999f;

        /* renamed from: g  reason: collision with root package name */
        public String f55000g;

        /* renamed from: h  reason: collision with root package name */
        public String f55001h;

        /* renamed from: i  reason: collision with root package name */
        public String f55002i;
    }

    public q(com.kwad.sdk.core.webview.a aVar) {
        this.a = aVar;
        try {
            this.f54992e = new AdTemplate();
            AdTemplate a2 = this.a.a();
            if (a2 != null) {
                if (a2.mOriginJString != null) {
                    this.f54992e.parseJson(new JSONObject(a2.mOriginJString));
                } else {
                    this.f54992e.parseJson(a2.toJson());
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        if (this.f54990c != null) {
            a aVar = new a();
            aVar.a = f2;
            aVar.f54994b = i2;
            this.f54990c.a(aVar);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.f54995b;
        adBaseInfo.appName = bVar.a;
        adBaseInfo.appVersion = bVar.f54996c;
        adBaseInfo.packageSize = bVar.f54998e;
        adBaseInfo.appIconUrl = bVar.f55001h;
        adBaseInfo.appDescription = bVar.f55002i;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.f55000g;
        adConversionInfo.appDownloadUrl = str;
        adInfo.downloadId = com.kwad.sdk.utils.aa.a(str);
    }

    private KsAppDownloadListener c() {
        return new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.core.webview.jshandler.q.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i2) {
                q.this.a(3, (i2 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                q.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                q.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                q.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                q.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                q.this.a(2, (i2 * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "registerApkStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.sdk.core.download.a.b bVar;
        int i2;
        AdTemplate adTemplate = this.f54992e;
        if (adTemplate == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
            if (this.f54989b == null) {
                this.f54989b = new com.kwad.sdk.core.download.a.b(this.f54992e);
            }
            bVar = this.f54989b;
            i2 = 2;
        } else {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f54992e);
            b bVar2 = new b();
            try {
                bVar2.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            a(j2, bVar2);
            if (this.f54989b == null) {
                this.f54989b = new com.kwad.sdk.core.download.a.b(this.f54992e);
            }
            bVar = this.f54989b;
            i2 = 1;
        }
        bVar.a(i2);
        this.f54990c = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.f54991d;
        if (ksAppDownloadListener != null) {
            this.f54989b.c(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener c2 = c();
        this.f54991d = c2;
        this.f54989b.a(c2);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f54990c = null;
        com.kwad.sdk.core.download.a.b bVar = this.f54989b;
        if (bVar == null || (ksAppDownloadListener = this.f54991d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.f54991d = null;
    }
}
