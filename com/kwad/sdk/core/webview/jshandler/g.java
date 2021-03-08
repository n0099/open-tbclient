package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.webview.a f6341a;
    private com.kwad.sdk.core.download.b.b c;
    private a d = new a();
    private AdTemplate b = new AdTemplate();

    /* loaded from: classes3.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f6343a;
        public String b;
        public String c;
        public String d;
        public int e;
        public int f;
        public String g;
        public String h;
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
        this.f6341a = aVar;
        try {
            this.b.parseJson(new JSONObject(this.f6341a.b.mOriginJString));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void a(@NonNull AdInfo adInfo, @NonNull a aVar) {
        AdInfo.AdConversionInfo adConversionInfo = adInfo.adConversionInfo;
        adConversionInfo.deeplinkUrl = aVar.i;
        adConversionInfo.marketUrl = aVar.m;
        adInfo.adBaseInfo.adOperationType = aVar.f6343a;
        adInfo.adBaseInfo.appPackageName = aVar.c;
        adInfo.adBaseInfo.appName = aVar.b;
        adInfo.adBaseInfo.appVersion = aVar.d;
        adInfo.adBaseInfo.packageSize = aVar.f;
        adInfo.adBaseInfo.appIconUrl = aVar.j;
        adInfo.adBaseInfo.appDescription = aVar.k;
        if (!com.kwad.sdk.core.response.b.a.y(adInfo)) {
            adInfo.adConversionInfo.h5Url = aVar.h;
            return;
        }
        adInfo.adConversionInfo.appDownloadUrl = aVar.h;
        adInfo.downloadId = t.a(adInfo.adConversionInfo.appDownloadUrl);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "handleAdUrl";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        try {
            this.d.parseJson(new JSONObject(str));
            a(com.kwad.sdk.core.response.b.c.j(this.b), this.d);
            if (this.c == null) {
                this.c = new com.kwad.sdk.core.download.b.b(this.b);
                this.c.a(1);
            }
            com.kwad.sdk.core.download.b.a.a(this.f6341a.e.getContext(), this.b, new a.InterfaceC1111a() { // from class: com.kwad.sdk.core.webview.jshandler.g.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1111a
                public void a() {
                }
            }, this.c);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
