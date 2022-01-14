package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56427b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f56428c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f56429d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f56430e;

    /* loaded from: classes3.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public double a;

        /* renamed from: b  reason: collision with root package name */
        public int f56432b;
    }

    /* loaded from: classes3.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f56433b;

        /* renamed from: c  reason: collision with root package name */
        public String f56434c;

        /* renamed from: d  reason: collision with root package name */
        public int f56435d;

        /* renamed from: e  reason: collision with root package name */
        public long f56436e;

        /* renamed from: f  reason: collision with root package name */
        public String f56437f;

        /* renamed from: g  reason: collision with root package name */
        public String f56438g;

        /* renamed from: h  reason: collision with root package name */
        public String f56439h;

        /* renamed from: i  reason: collision with root package name */
        public String f56440i;
    }

    public q(com.kwad.sdk.core.webview.a aVar) {
        this.a = aVar;
        try {
            this.f56430e = new AdTemplate();
            AdTemplate a2 = this.a.a();
            if (a2 != null) {
                if (a2.mOriginJString != null) {
                    this.f56430e.parseJson(new JSONObject(a2.mOriginJString));
                } else {
                    this.f56430e.parseJson(a2.toJson());
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        if (this.f56428c != null) {
            a aVar = new a();
            aVar.a = f2;
            aVar.f56432b = i2;
            this.f56428c.a(aVar);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.f56433b;
        adBaseInfo.appName = bVar.a;
        adBaseInfo.appVersion = bVar.f56434c;
        adBaseInfo.packageSize = bVar.f56436e;
        adBaseInfo.appIconUrl = bVar.f56439h;
        adBaseInfo.appDescription = bVar.f56440i;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.f56438g;
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
        AdTemplate adTemplate = this.f56430e;
        if (adTemplate == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
            if (this.f56427b == null) {
                this.f56427b = new com.kwad.sdk.core.download.a.b(this.f56430e);
            }
            bVar = this.f56427b;
            i2 = 2;
        } else {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f56430e);
            b bVar2 = new b();
            try {
                bVar2.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            a(j2, bVar2);
            if (this.f56427b == null) {
                this.f56427b = new com.kwad.sdk.core.download.a.b(this.f56430e);
            }
            bVar = this.f56427b;
            i2 = 1;
        }
        bVar.a(i2);
        this.f56428c = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.f56429d;
        if (ksAppDownloadListener != null) {
            this.f56427b.c(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener c2 = c();
        this.f56429d = c2;
        this.f56427b.a(c2);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f56428c = null;
        com.kwad.sdk.core.download.a.b bVar = this.f56427b;
        if (bVar == null || (ksAppDownloadListener = this.f56429d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.f56429d = null;
    }
}
