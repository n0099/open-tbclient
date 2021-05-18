package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f32926a;

    /* renamed from: b  reason: collision with root package name */
    public final AdTemplate f32927b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32928c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f32929d;

    /* loaded from: classes6.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f32932a;

        /* renamed from: b  reason: collision with root package name */
        public String f32933b;

        /* renamed from: c  reason: collision with root package name */
        public String f32934c;

        /* renamed from: d  reason: collision with root package name */
        public String f32935d;

        /* renamed from: e  reason: collision with root package name */
        public int f32936e;

        /* renamed from: f  reason: collision with root package name */
        public int f32937f;

        /* renamed from: g  reason: collision with root package name */
        public String f32938g;

        /* renamed from: h  reason: collision with root package name */
        public String f32939h;

        /* renamed from: i  reason: collision with root package name */
        public String f32940i;
        public String j;
        public String k;
        public String l;
        public String m;
        @Deprecated
        public boolean n;
        public boolean o;
        public boolean p;
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.f32940i;
        adConversionInfo.marketUrl = aVar.m;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.f32932a;
        adBaseInfo.appPackageName = aVar.f32934c;
        adBaseInfo.appName = aVar.f32933b;
        adBaseInfo.appVersion = aVar.f32935d;
        adBaseInfo.packageSize = aVar.f32937f;
        adBaseInfo.appIconUrl = aVar.j;
        adBaseInfo.appDescription = aVar.k;
        if (!com.kwad.sdk.core.response.b.a.v(adInfo)) {
            adInfo.adConversionInfo.h5Url = aVar.f32939h;
            return;
        }
        AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
        String str = aVar.f32939h;
        adConversionInfo2.appDownloadUrl = str;
        adInfo.downloadId = r.a(str);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        com.kwad.sdk.core.download.b.b bVar;
        int i2;
        if (com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.g(this.f32927b))) {
            if (this.f32928c == null) {
                this.f32928c = new com.kwad.sdk.core.download.b.b(this.f32927b);
            }
            bVar = this.f32928c;
            i2 = 2;
        } else {
            AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f32927b);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            a(g2, aVar);
            if (this.f32928c == null) {
                this.f32928c = new com.kwad.sdk.core.download.b.b(this.f32927b);
            }
            bVar = this.f32928c;
            i2 = 1;
        }
        bVar.a(i2);
        this.f32929d.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.g.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.download.b.a.a(g.this.f32926a.f32870e.getContext(), g.this.f32927b, new a.InterfaceC0363a() { // from class: com.kwad.sdk.core.webview.jshandler.g.1.1
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
                    public void a() {
                    }
                }, g.this.f32928c, false);
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f32929d.removeCallbacksAndMessages(null);
    }
}
