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
    public final com.kwad.sdk.core.webview.a f35020a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35021b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f35022c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f35023d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f35024e;

    /* loaded from: classes7.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public double f35026a;

        /* renamed from: b  reason: collision with root package name */
        public int f35027b;
    }

    /* loaded from: classes7.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public String f35028a;

        /* renamed from: b  reason: collision with root package name */
        public String f35029b;

        /* renamed from: c  reason: collision with root package name */
        public String f35030c;

        /* renamed from: d  reason: collision with root package name */
        public int f35031d;

        /* renamed from: e  reason: collision with root package name */
        public long f35032e;

        /* renamed from: f  reason: collision with root package name */
        public String f35033f;

        /* renamed from: g  reason: collision with root package name */
        public String f35034g;

        /* renamed from: h  reason: collision with root package name */
        public String f35035h;

        /* renamed from: i  reason: collision with root package name */
        public String f35036i;
    }

    public l(com.kwad.sdk.core.webview.a aVar) {
        this.f35020a = aVar;
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.f35024e = adTemplate;
            adTemplate.parseJson(new JSONObject(this.f35020a.f34929b.mOriginJString));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        if (this.f35022c != null) {
            a aVar = new a();
            aVar.f35026a = f2;
            aVar.f35027b = i2;
            this.f35022c.a(aVar);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.f35029b;
        adBaseInfo.appName = bVar.f35028a;
        adBaseInfo.appVersion = bVar.f35030c;
        adBaseInfo.packageSize = bVar.f35032e;
        adBaseInfo.appIconUrl = bVar.f35035h;
        adBaseInfo.appDescription = bVar.f35036i;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.f35034g;
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
        if (this.f35020a.f34929b == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        if (this.f35021b == null) {
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f35024e);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            a(j, bVar);
            com.kwad.sdk.core.download.b.b bVar2 = new com.kwad.sdk.core.download.b.b(this.f35024e);
            this.f35021b = bVar2;
            bVar2.a(1);
        }
        this.f35022c = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.f35023d;
        if (ksAppDownloadListener != null) {
            this.f35021b.c(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener c2 = c();
        this.f35023d = c2;
        this.f35021b.a(c2);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f35022c = null;
        com.kwad.sdk.core.download.b.b bVar = this.f35021b;
        if (bVar == null || (ksAppDownloadListener = this.f35023d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.f35023d = null;
    }
}
