package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f40075b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f40076c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f40077d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f40078e;

    /* loaded from: classes7.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public double a;

        /* renamed from: b  reason: collision with root package name */
        public int f40080b;
    }

    /* loaded from: classes7.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f40081b;

        /* renamed from: c  reason: collision with root package name */
        public String f40082c;

        /* renamed from: d  reason: collision with root package name */
        public int f40083d;

        /* renamed from: e  reason: collision with root package name */
        public long f40084e;

        /* renamed from: f  reason: collision with root package name */
        public String f40085f;

        /* renamed from: g  reason: collision with root package name */
        public String f40086g;

        /* renamed from: h  reason: collision with root package name */
        public String f40087h;
        public String i;
    }

    public q(com.kwad.sdk.core.webview.a aVar) {
        this.a = aVar;
        try {
            this.f40078e = new AdTemplate();
            AdTemplate a2 = this.a.a();
            if (a2 != null) {
                if (a2.mOriginJString != null) {
                    this.f40078e.parseJson(new JSONObject(a2.mOriginJString));
                } else {
                    this.f40078e.parseJson(a2.toJson());
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f2) {
        if (this.f40076c != null) {
            a aVar = new a();
            aVar.a = f2;
            aVar.f40080b = i;
            this.f40076c.a(aVar);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.f40081b;
        adBaseInfo.appName = bVar.a;
        adBaseInfo.appVersion = bVar.f40082c;
        adBaseInfo.packageSize = bVar.f40084e;
        adBaseInfo.appIconUrl = bVar.f40087h;
        adBaseInfo.appDescription = bVar.i;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.f40086g;
        adConversionInfo.appDownloadUrl = str;
        adInfo.downloadId = com.kwad.sdk.utils.aa.a(str);
    }

    private KsAppDownloadListener c() {
        return new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.core.webview.jshandler.q.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                q.this.a(3, (i * 1.0f) / 100.0f);
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
            public void onProgressUpdate(int i) {
                q.this.a(2, (i * 1.0f) / 100.0f);
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
        int i;
        AdTemplate adTemplate = this.f40078e;
        if (adTemplate == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
            if (this.f40075b == null) {
                this.f40075b = new com.kwad.sdk.core.download.a.b(this.f40078e);
            }
            bVar = this.f40075b;
            i = 2;
        } else {
            AdInfo j = com.kwad.sdk.core.response.a.d.j(this.f40078e);
            b bVar2 = new b();
            try {
                bVar2.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            a(j, bVar2);
            if (this.f40075b == null) {
                this.f40075b = new com.kwad.sdk.core.download.a.b(this.f40078e);
            }
            bVar = this.f40075b;
            i = 1;
        }
        bVar.a(i);
        this.f40076c = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.f40077d;
        if (ksAppDownloadListener != null) {
            this.f40075b.c(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener c2 = c();
        this.f40077d = c2;
        this.f40075b.a(c2);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f40076c = null;
        com.kwad.sdk.core.download.a.b bVar = this.f40075b;
        if (bVar == null || (ksAppDownloadListener = this.f40077d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.f40077d = null;
    }
}
