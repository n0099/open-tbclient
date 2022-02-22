package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56594c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f56595d = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final AdTemplate f56593b = new AdTemplate();

    /* loaded from: classes4.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f56596b;

        /* renamed from: c  reason: collision with root package name */
        public String f56597c;

        /* renamed from: d  reason: collision with root package name */
        public String f56598d;

        /* renamed from: e  reason: collision with root package name */
        public int f56599e;

        /* renamed from: f  reason: collision with root package name */
        public int f56600f;

        /* renamed from: g  reason: collision with root package name */
        public String f56601g;

        /* renamed from: h  reason: collision with root package name */
        public String f56602h;

        /* renamed from: i  reason: collision with root package name */
        public String f56603i;

        /* renamed from: j  reason: collision with root package name */
        public String f56604j;
        public String k;
        public String l;
        public String m;
        @Deprecated
        public boolean n;
        public boolean o;
        public boolean p;
    }

    public h(com.kwad.sdk.core.webview.a aVar) {
        this.a = aVar;
        try {
            AdTemplate a2 = this.a.a();
            if (a2 != null) {
                if (a2.mOriginJString != null) {
                    this.f56593b.parseJson(new JSONObject(a2.mOriginJString));
                } else {
                    this.f56593b.parseJson(a2.toJson());
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.f56603i;
        adConversionInfo.marketUrl = aVar.m;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.a;
        adBaseInfo.appPackageName = aVar.f56597c;
        adBaseInfo.appName = aVar.f56596b;
        adBaseInfo.appVersion = aVar.f56598d;
        adBaseInfo.packageSize = aVar.f56600f;
        adBaseInfo.appIconUrl = aVar.f56604j;
        adBaseInfo.appDescription = aVar.k;
        if (!com.kwad.sdk.core.response.a.a.B(adInfo)) {
            adInfo.adConversionInfo.h5Url = aVar.f56602h;
            return;
        }
        AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
        String str = aVar.f56602h;
        adConversionInfo2.appDownloadUrl = str;
        adInfo.downloadId = com.kwad.sdk.utils.aa.a(str);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.sdk.core.download.a.b bVar;
        int i2;
        if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(this.f56593b))) {
            if (this.f56594c == null) {
                this.f56594c = new com.kwad.sdk.core.download.a.b(this.f56593b);
            }
            bVar = this.f56594c;
            i2 = 2;
        } else {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f56593b);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            a(j2, aVar);
            if (this.f56594c == null) {
                this.f56594c = new com.kwad.sdk.core.download.a.b(this.f56593b);
            }
            bVar = this.f56594c;
            i2 = 1;
        }
        bVar.a(i2);
        this.f56595d.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.download.a.a.a(h.this.a.f56541d.getContext(), h.this.f56593b, new a.b() { // from class: com.kwad.sdk.core.webview.jshandler.h.1.1
                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                    }
                }, h.this.f56594c, false);
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f56595d.removeCallbacksAndMessages(null);
    }
}
