package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f35080a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35081b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35082c;

    /* renamed from: d  reason: collision with root package name */
    public a f35083d = new a();

    /* loaded from: classes7.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f35085a;

        /* renamed from: b  reason: collision with root package name */
        public String f35086b;

        /* renamed from: c  reason: collision with root package name */
        public String f35087c;

        /* renamed from: d  reason: collision with root package name */
        public String f35088d;

        /* renamed from: e  reason: collision with root package name */
        public int f35089e;

        /* renamed from: f  reason: collision with root package name */
        public int f35090f;

        /* renamed from: g  reason: collision with root package name */
        public String f35091g;

        /* renamed from: h  reason: collision with root package name */
        public String f35092h;

        /* renamed from: i  reason: collision with root package name */
        public String f35093i;
        public String j;
        public String k;
        public String l;
        public String m;
        @Deprecated
        public boolean n;
        public boolean o;
        public boolean p;
    }

    public g(com.kwad.sdk.core.webview.a aVar) {
        this.f35080a = aVar;
        AdTemplate adTemplate = new AdTemplate();
        this.f35081b = adTemplate;
        try {
            adTemplate.parseJson(new JSONObject(this.f35080a.f35027b.mOriginJString));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.f35093i;
        adConversionInfo.marketUrl = aVar.m;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.f35085a;
        adBaseInfo.appPackageName = aVar.f35087c;
        adBaseInfo.appName = aVar.f35086b;
        adBaseInfo.appVersion = aVar.f35088d;
        adBaseInfo.packageSize = aVar.f35090f;
        adBaseInfo.appIconUrl = aVar.j;
        adBaseInfo.appDescription = aVar.k;
        if (!com.kwad.sdk.core.response.b.a.y(adInfo)) {
            adInfo.adConversionInfo.h5Url = aVar.f35092h;
            return;
        }
        AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
        String str = aVar.f35092h;
        adConversionInfo2.appDownloadUrl = str;
        adInfo.downloadId = t.a(str);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        try {
            this.f35083d.parseJson(new JSONObject(str));
            a(com.kwad.sdk.core.response.b.c.j(this.f35081b), this.f35083d);
            if (this.f35082c == null) {
                com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.f35081b);
                this.f35082c = bVar;
                bVar.a(1);
            }
            com.kwad.sdk.core.download.b.a.a(this.f35080a.f35030e.getContext(), this.f35081b, new a.InterfaceC0382a() { // from class: com.kwad.sdk.core.webview.jshandler.g.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
                public void a() {
                }
            }, this.f35082c);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
