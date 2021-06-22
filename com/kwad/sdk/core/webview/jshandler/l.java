package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f35118a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35119b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f35120c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f35121d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f35122e;

    /* loaded from: classes7.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public double f35124a;

        /* renamed from: b  reason: collision with root package name */
        public int f35125b;
    }

    /* loaded from: classes7.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public String f35126a;

        /* renamed from: b  reason: collision with root package name */
        public String f35127b;

        /* renamed from: c  reason: collision with root package name */
        public String f35128c;

        /* renamed from: d  reason: collision with root package name */
        public int f35129d;

        /* renamed from: e  reason: collision with root package name */
        public long f35130e;

        /* renamed from: f  reason: collision with root package name */
        public String f35131f;

        /* renamed from: g  reason: collision with root package name */
        public String f35132g;

        /* renamed from: h  reason: collision with root package name */
        public String f35133h;

        /* renamed from: i  reason: collision with root package name */
        public String f35134i;
    }

    public l(com.kwad.sdk.core.webview.a aVar) {
        this.f35118a = aVar;
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.f35122e = adTemplate;
            adTemplate.parseJson(new JSONObject(this.f35118a.f35027b.mOriginJString));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        if (this.f35120c != null) {
            a aVar = new a();
            aVar.f35124a = f2;
            aVar.f35125b = i2;
            this.f35120c.a(aVar);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.f35127b;
        adBaseInfo.appName = bVar.f35126a;
        adBaseInfo.appVersion = bVar.f35128c;
        adBaseInfo.packageSize = bVar.f35130e;
        adBaseInfo.appIconUrl = bVar.f35133h;
        adBaseInfo.appDescription = bVar.f35134i;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.f35132g;
        adConversionInfo.appDownloadUrl = str;
        adInfo.downloadId = t.a(str);
    }

    private KsAppDownloadListener c() {
        return new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.core.webview.jshandler.l.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                l.this.a(3, (i2 * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                l.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                l.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                l.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                l.this.a(6, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                l.this.a(2, (i2 * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "registerApkStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        if (this.f35118a.f35027b == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        if (this.f35119b == null) {
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f35122e);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            a(j, bVar);
            com.kwad.sdk.core.download.b.b bVar2 = new com.kwad.sdk.core.download.b.b(this.f35122e);
            this.f35119b = bVar2;
            bVar2.a(1);
        }
        this.f35120c = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.f35121d;
        if (ksAppDownloadListener != null) {
            this.f35119b.c(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener c2 = c();
        this.f35121d = c2;
        this.f35119b.a(c2);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f35120c = null;
        com.kwad.sdk.core.download.b.b bVar = this.f35119b;
        if (bVar == null || (ksAppDownloadListener = this.f35121d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.f35121d = null;
    }
}
