package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f34722a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f34723b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34724c;

    /* renamed from: d  reason: collision with root package name */
    public a f34725d = new a();

    /* loaded from: classes6.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f34727a;

        /* renamed from: b  reason: collision with root package name */
        public String f34728b;

        /* renamed from: c  reason: collision with root package name */
        public String f34729c;

        /* renamed from: d  reason: collision with root package name */
        public String f34730d;

        /* renamed from: e  reason: collision with root package name */
        public int f34731e;

        /* renamed from: f  reason: collision with root package name */
        public int f34732f;

        /* renamed from: g  reason: collision with root package name */
        public String f34733g;

        /* renamed from: h  reason: collision with root package name */
        public String f34734h;
        public String i;
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
        this.f34722a = aVar;
        AdTemplate adTemplate = new AdTemplate();
        this.f34723b = adTemplate;
        try {
            adTemplate.parseJson(new JSONObject(this.f34722a.f34670b.mOriginJString));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.i;
        adConversionInfo.marketUrl = aVar.m;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.f34727a;
        adBaseInfo.appPackageName = aVar.f34729c;
        adBaseInfo.appName = aVar.f34728b;
        adBaseInfo.appVersion = aVar.f34730d;
        adBaseInfo.packageSize = aVar.f34732f;
        adBaseInfo.appIconUrl = aVar.j;
        adBaseInfo.appDescription = aVar.k;
        if (!com.kwad.sdk.core.response.b.a.y(adInfo)) {
            adInfo.adConversionInfo.h5Url = aVar.f34734h;
            return;
        }
        AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
        String str = aVar.f34734h;
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
            this.f34725d.parseJson(new JSONObject(str));
            a(com.kwad.sdk.core.response.b.c.j(this.f34723b), this.f34725d);
            if (this.f34724c == null) {
                com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.f34723b);
                this.f34724c = bVar;
                bVar.a(1);
            }
            com.kwad.sdk.core.download.b.a.a(this.f34722a.f34673e.getContext(), this.f34723b, new a.InterfaceC0396a() { // from class: com.kwad.sdk.core.webview.jshandler.g.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
                public void a() {
                }
            }, this.f34724c);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
