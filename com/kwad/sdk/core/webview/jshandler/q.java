package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;
    public com.kwad.sdk.core.download.a.b b;
    @Nullable
    public com.kwad.sdk.core.webview.kwai.c c;
    @Nullable
    public KsAppDownloadListener d;
    public AdTemplate e;

    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public double a;
        public int b;
    }

    /* loaded from: classes5.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public String a;
        public String b;
        public String c;
        public int d;
        public long e;
        public String f;
        public String g;
        public String h;
        public String i;
    }

    public q(com.kwad.sdk.core.webview.a aVar) {
        this.a = aVar;
        try {
            this.e = new AdTemplate();
            AdTemplate a2 = this.a.a();
            if (a2 != null) {
                if (a2.mOriginJString != null) {
                    this.e.parseJson(new JSONObject(a2.mOriginJString));
                } else {
                    this.e.parseJson(a2.toJson());
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.c != null) {
            a aVar = new a();
            aVar.a = f;
            aVar.b = i;
            this.c.a(aVar);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull b bVar) {
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = 1;
        adBaseInfo.appPackageName = bVar.b;
        adBaseInfo.appName = bVar.a;
        adBaseInfo.appVersion = bVar.c;
        adBaseInfo.packageSize = bVar.e;
        adBaseInfo.appIconUrl = bVar.h;
        adBaseInfo.appDescription = bVar.i;
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        String str = bVar.g;
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
        AdTemplate adTemplate = this.e;
        if (adTemplate == null) {
            cVar.a(-1, "native photo is null");
            return;
        }
        if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
            if (this.b == null) {
                this.b = new com.kwad.sdk.core.download.a.b(this.e);
            }
            bVar = this.b;
            i = 2;
        } else {
            AdInfo j = com.kwad.sdk.core.response.a.d.j(this.e);
            b bVar2 = new b();
            try {
                bVar2.parseJson(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
            a(j, bVar2);
            if (this.b == null) {
                this.b = new com.kwad.sdk.core.download.a.b(this.e);
            }
            bVar = this.b;
            i = 1;
        }
        bVar.a(i);
        this.c = cVar;
        KsAppDownloadListener ksAppDownloadListener = this.d;
        if (ksAppDownloadListener != null) {
            this.b.c(ksAppDownloadListener);
            return;
        }
        KsAppDownloadListener c = c();
        this.d = c;
        this.b.a(c);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        KsAppDownloadListener ksAppDownloadListener;
        this.c = null;
        com.kwad.sdk.core.download.a.b bVar = this.b;
        if (bVar == null || (ksAppDownloadListener = this.d) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
        this.d = null;
    }
}
