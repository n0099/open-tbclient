package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33720a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f33721b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public KsAppDownloadListener f33722c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f33723d;

    /* loaded from: classes6.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public double f33725a;

        /* renamed from: b  reason: collision with root package name */
        public int f33726b;
    }

    /* loaded from: classes6.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public String f33727a;

        /* renamed from: b  reason: collision with root package name */
        public String f33728b;

        /* renamed from: c  reason: collision with root package name */
        public String f33729c;

        /* renamed from: d  reason: collision with root package name */
        public int f33730d;

        /* renamed from: e  reason: collision with root package name */
        public long f33731e;

        /* renamed from: f  reason: collision with root package name */
        public String f33732f;

        /* renamed from: g  reason: collision with root package name */
        public String f33733g;

        /* renamed from: h  reason: collision with root package name */
        public String f33734h;

        /* renamed from: i  reason: collision with root package name */
        public String f33735i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2) {
        if (this.f33721b != null) {
            a aVar = new a();
            aVar.f33725a = f2;
            aVar.f33726b = i2;
            this.f33721b.a(aVar);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.f33728b;
        adBaseInfo.appName = bVar.f33727a;
        adBaseInfo.appVersion = bVar.f33729c;
        adBaseInfo.packageSize = bVar.f33731e;
        adBaseInfo.appIconUrl = bVar.f33734h;
        adBaseInfo.appDescription = bVar.f33735i;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.f33733g;
        adConversionInfo.appDownloadUrl = str;
        adInfo.downloadId = r.a(str);
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
        com.kwad.sdk.core.download.b.b bVar;
        int i2;
        AdTemplate adTemplate = this.f33723d;
        if (adTemplate == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.g(adTemplate))) {
            if (this.f33720a == null) {
                this.f33720a = new com.kwad.sdk.core.download.b.b(this.f33723d);
            }
            bVar = this.f33720a;
            i2 = 2;
        } else {
            AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f33723d);
            b bVar2 = new b();
            try {
                bVar2.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            a(g2, bVar2);
            if (this.f33720a == null) {
                this.f33720a = new com.kwad.sdk.core.download.b.b(this.f33723d);
            }
            bVar = this.f33720a;
            i2 = 1;
        }
        bVar.a(i2);
        this.f33721b = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.f33722c;
        if (ksAppDownloadListener != null) {
            this.f33720a.c(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener c2 = c();
        this.f33722c = c2;
        this.f33720a.a(c2);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f33721b = null;
        com.kwad.sdk.core.download.b.b bVar = this.f33720a;
        if (bVar == null || (ksAppDownloadListener = this.f33722c) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.f33722c = null;
    }
}
