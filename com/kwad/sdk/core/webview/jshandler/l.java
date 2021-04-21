package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f34759a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34760b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f34761c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f34762d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34763e;

    /* loaded from: classes6.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public double f34765a;

        /* renamed from: b  reason: collision with root package name */
        public int f34766b;
    }

    /* loaded from: classes6.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public String f34767a;

        /* renamed from: b  reason: collision with root package name */
        public String f34768b;

        /* renamed from: c  reason: collision with root package name */
        public String f34769c;

        /* renamed from: d  reason: collision with root package name */
        public int f34770d;

        /* renamed from: e  reason: collision with root package name */
        public long f34771e;

        /* renamed from: f  reason: collision with root package name */
        public String f34772f;

        /* renamed from: g  reason: collision with root package name */
        public String f34773g;

        /* renamed from: h  reason: collision with root package name */
        public String f34774h;
        public String i;
    }

    public l(com.kwad.sdk.core.webview.a aVar) {
        this.f34759a = aVar;
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.f34763e = adTemplate;
            adTemplate.parseJson(new JSONObject(this.f34759a.f34670b.mOriginJString));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f2) {
        if (this.f34761c != null) {
            a aVar = new a();
            aVar.f34765a = f2;
            aVar.f34766b = i;
            this.f34761c.a(aVar);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.f34768b;
        adBaseInfo.appName = bVar.f34767a;
        adBaseInfo.appVersion = bVar.f34769c;
        adBaseInfo.packageSize = bVar.f34771e;
        adBaseInfo.appIconUrl = bVar.f34774h;
        adBaseInfo.appDescription = bVar.i;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.f34773g;
        adConversionInfo.appDownloadUrl = str;
        adInfo.downloadId = t.a(str);
    }

    private KsAppDownloadListener c() {
        return new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.core.webview.jshandler.l.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                l.this.a(3, (i * 1.0f) / 100.0f);
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
            public void onProgressUpdate(int i) {
                l.this.a(2, (i * 1.0f) / 100.0f);
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
        if (this.f34759a.f34670b == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        if (this.f34760b == null) {
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f34763e);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            a(j, bVar);
            com.kwad.sdk.core.download.b.b bVar2 = new com.kwad.sdk.core.download.b.b(this.f34763e);
            this.f34760b = bVar2;
            bVar2.a(1);
        }
        this.f34761c = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.f34762d;
        if (ksAppDownloadListener != null) {
            this.f34760b.c(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener c2 = c();
        this.f34762d = c2;
        this.f34760b.a(c2);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f34761c = null;
        com.kwad.sdk.core.download.b.b bVar = this.f34760b;
        if (bVar == null || (ksAppDownloadListener = this.f34762d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.f34762d = null;
    }
}
