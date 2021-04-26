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
    public final com.kwad.sdk.core.webview.a f33681a;

    /* renamed from: b  reason: collision with root package name */
    public final AdTemplate f33682b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33683c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f33684d;

    /* loaded from: classes6.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f33687a;

        /* renamed from: b  reason: collision with root package name */
        public String f33688b;

        /* renamed from: c  reason: collision with root package name */
        public String f33689c;

        /* renamed from: d  reason: collision with root package name */
        public String f33690d;

        /* renamed from: e  reason: collision with root package name */
        public int f33691e;

        /* renamed from: f  reason: collision with root package name */
        public int f33692f;

        /* renamed from: g  reason: collision with root package name */
        public String f33693g;

        /* renamed from: h  reason: collision with root package name */
        public String f33694h;

        /* renamed from: i  reason: collision with root package name */
        public String f33695i;
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
        adConversionInfo.deeplinkUrl = aVar.f33695i;
        adConversionInfo.marketUrl = aVar.m;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        adBaseInfo.adOperationType = aVar.f33687a;
        adBaseInfo.appPackageName = aVar.f33689c;
        adBaseInfo.appName = aVar.f33688b;
        adBaseInfo.appVersion = aVar.f33690d;
        adBaseInfo.packageSize = aVar.f33692f;
        adBaseInfo.appIconUrl = aVar.j;
        adBaseInfo.appDescription = aVar.k;
        if (!com.kwad.sdk.core.response.b.a.v(adInfo)) {
            adInfo.adConversionInfo.h5Url = aVar.f33694h;
            return;
        }
        AdInfo.AdConversionInfo adConversionInfo2 = adInfo.adConversionInfo;
        String str = aVar.f33694h;
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
        if (com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.g(this.f33682b))) {
            if (this.f33683c == null) {
                this.f33683c = new com.kwad.sdk.core.download.b.b(this.f33682b);
            }
            bVar = this.f33683c;
            i2 = 2;
        } else {
            AdInfo g2 = com.kwad.sdk.core.response.b.c.g(this.f33682b);
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            a(g2, aVar);
            if (this.f33683c == null) {
                this.f33683c = new com.kwad.sdk.core.download.b.b(this.f33682b);
            }
            bVar = this.f33683c;
            i2 = 1;
        }
        bVar.a(i2);
        this.f33684d.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.g.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.download.b.a.a(g.this.f33681a.f33625e.getContext(), g.this.f33682b, new a.InterfaceC0376a() { // from class: com.kwad.sdk.core.webview.jshandler.g.1.1
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                    public void a() {
                    }
                }, g.this.f33683c, false);
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f33684d.removeCallbacksAndMessages(null);
    }
}
