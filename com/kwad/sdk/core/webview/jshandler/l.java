package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class l implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.webview.a f9895a;

    /* renamed from: b  reason: collision with root package name */
    private com.kwad.sdk.core.download.b.b f9896b;
    @Nullable
    private com.kwad.sdk.core.webview.a.c c;
    @Nullable
    private KsAppDownloadListener d;
    private AdTemplate e;

    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public double f9898a;

        /* renamed from: b  reason: collision with root package name */
        public int f9899b;
    }

    /* loaded from: classes5.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public String f9900a;

        /* renamed from: b  reason: collision with root package name */
        public String f9901b;
        public String c;
        public int d;
        public long e;
        public String f;
        public String g;
        public String h;
        public String i;
    }

    public l(com.kwad.sdk.core.webview.a aVar) {
        this.f9895a = aVar;
        try {
            this.e = new AdTemplate();
            this.e.parseJson(new JSONObject(this.f9895a.f9837b.mOriginJString));
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.c != null) {
            a aVar = new a();
            aVar.f9898a = f;
            aVar.f9899b = i;
            this.c.a(aVar);
        }
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        adInfo.adBaseInfo.adOperationType = 1;
        adInfo.adBaseInfo.appPackageName = bVar.f9901b;
        adInfo.adBaseInfo.appName = bVar.f9900a;
        adInfo.adBaseInfo.appVersion = bVar.c;
        adInfo.adBaseInfo.packageSize = bVar.e;
        adInfo.adBaseInfo.appIconUrl = bVar.h;
        adInfo.adBaseInfo.appDescription = bVar.i;
        adInfo.adConversionInfo.appDownloadUrl = bVar.g;
        adInfo.downloadId = t.a(adInfo.adConversionInfo.appDownloadUrl);
    }

    private KsAppDownloadListener c() {
        return new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.core.webview.jshandler.l.1
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                l.this.a(3, (1.0f * i) / 100.0f);
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
                l.this.a(2, (1.0f * i) / 100.0f);
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
        if (this.f9895a.f9837b == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        if (this.f9896b == null) {
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.e);
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.a.a(e);
            }
            a(j, bVar);
            this.f9896b = new com.kwad.sdk.core.download.b.b(this.e);
            this.f9896b.a(1);
        }
        this.c = cVar;
        if (this.d != null) {
            this.f9896b.c(this.d);
            return;
        }
        this.d = c();
        this.f9896b.a(this.d);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.c = null;
        if (this.f9896b == null || this.d == null) {
            return;
        }
        this.f9896b.b(this.d);
        this.d = null;
    }
}
