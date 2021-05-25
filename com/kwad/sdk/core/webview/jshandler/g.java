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
    public final com.kwad.sdk.core.webview.a f32855a;

    /* renamed from: b  reason: collision with root package name */
    public final AdTemplate f32856b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32857c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f32858d;

    /* loaded from: classes6.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f32861a;

        /* renamed from: b  reason: collision with root package name */
        public String f32862b;

        /* renamed from: c  reason: collision with root package name */
        public String f32863c;

        /* renamed from: d  reason: collision with root package name */
        public String f32864d;

        /* renamed from: e  reason: collision with root package name */
        public int f32865e;

        /* renamed from: f  reason: collision with root package name */
        public int f32866f;

        /* renamed from: g  reason: collision with root package name */
        public String f32867g;

        /* renamed from: h  reason: collision with root package name */
        public String f32868h;

        /* renamed from: i  reason: collision with root package name */
        public String f32869i;
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
        adConversionInfo.deeplinkUrl = aVar.f32869i;
        adConversionInfo.marketUrl = aVar.m;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.f32861a;
        adBaseInfo.appPackageName = aVar.f32863c;
        adBaseInfo.appName = aVar.f32862b;
        adBaseInfo.appVersion = aVar.f32864d;
        adBaseInfo.packageSize = aVar.f32866f;
        adBaseInfo.appIconUrl = aVar.j;
        adBaseInfo.appDescription = aVar.k;
        if (!com.kwad.sdk.core.response.b.a.v(adInfo)) {
            adInfo.adConversionInfo.h5Url = aVar.f32868h;
            return;
        }
        AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
        String str = aVar.f32868h;
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
        if (com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.g(this.f32856b))) {
            if (this.f32857c == null) {
                this.f32857c = new com.kwad.sdk.core.download.b.b(this.f32856b);
            }
            bVar = this.f32857c;
            i2 = 2;
        } else {
            AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f32856b);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            a(g2, aVar);
            if (this.f32857c == null) {
                this.f32857c = new com.kwad.sdk.core.download.b.b(this.f32856b);
            }
            bVar = this.f32857c;
            i2 = 1;
        }
        bVar.a(i2);
        this.f32858d.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.g.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.download.b.a.a(g.this.f32855a.f32799e.getContext(), g.this.f32856b, new a.InterfaceC0364a() { // from class: com.kwad.sdk.core.webview.jshandler.g.1.1
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
                    public void a() {
                    }
                }, g.this.f32857c, false);
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f32858d.removeCallbacksAndMessages(null);
    }
}
