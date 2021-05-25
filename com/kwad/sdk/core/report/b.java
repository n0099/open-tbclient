package com.kwad.sdk.core.report;

import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.w;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f32547a = Executors.newSingleThreadExecutor();

    /* loaded from: classes6.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f32555a;

        /* renamed from: b  reason: collision with root package name */
        public String f32556b;

        public a(int i2, String str) {
            this.f32555a = i2;
            this.f32556b = str;
        }
    }

    public static void a(AdTemplate adTemplate) {
        d(adTemplate, 4);
    }

    public static void a(@Nullable AdTemplate adTemplate, int i2) {
        o.a aVar = new o.a();
        aVar.f32607g = i2;
        a(adTemplate, (int) MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i2, int i3) {
        o.a aVar = new o.a();
        aVar.f32604d = 69;
        aVar.o = i2;
        aVar.p = i3;
        a(adTemplate, 141, aVar, (JSONObject) null);
    }

    public static void a(@Nullable final AdTemplate adTemplate, final int i2, @Nullable final o.a aVar, @Nullable final JSONObject jSONObject) {
        if (adTemplate == null) {
            return;
        }
        if (aVar == null) {
            aVar = new o.a();
        }
        aVar.s = com.kwad.sdk.core.response.b.a.z(com.kwad.sdk.core.response.b.c.g(adTemplate));
        com.kwad.sdk.core.d.a.a("AdReportManager", i2 + "");
        new n() { // from class: com.kwad.sdk.core.report.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public o b() {
                return new o(AdTemplate.this, i2, aVar, jSONObject);
            }
        }.c();
    }

    public static void a(AdTemplate adTemplate, int i2, @Nullable q.a aVar) {
        o.a aVar2 = new o.a();
        aVar2.f32602b = i2;
        if (aVar != null) {
            aVar2.f32605e = aVar;
        }
        a(adTemplate, 2, aVar2, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i2, q.a aVar, @Nullable JSONObject jSONObject) {
        o.a aVar2 = new o.a();
        aVar2.f32602b = i2;
        aVar2.f32605e = aVar;
        a(adTemplate, 2, aVar2, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        o.a aVar = new o.a();
        aVar.f32603c = i2;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i2, JSONObject jSONObject, String str) {
        o.a aVar = new o.a();
        aVar.f32606f = str;
        a(adTemplate, i2, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, a aVar) {
        o.a aVar2 = new o.a();
        if (aVar != null) {
            aVar2.k = aVar.toJson().toString();
        }
        a(adTemplate, 40, aVar2, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, o.a aVar) {
        a(adTemplate, 50, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, q.a aVar) {
        o.a aVar2 = new o.a();
        aVar2.f32605e = aVar;
        a(adTemplate, 2, aVar2, (JSONObject) null);
    }

    public static void a(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        if (adTemplate.mPvReported) {
            return;
        }
        com.kwad.sdk.core.d.a.a("AdReportManager", "reportAdPv " + adTemplate);
        adTemplate.mPvReported = true;
        a(adTemplate, 1, (o.a) null, jSONObject);
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, q.a aVar, String str) {
        o.a aVar2 = new o.a();
        aVar2.f32605e = aVar;
        aVar2.f32606f = str;
        a(adTemplate, 2, aVar2, jSONObject);
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, String str) {
        o.a aVar = new o.a();
        aVar.f32606f = str;
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate) {
        o.a aVar = new o.a();
        aVar.f32608h = adTemplate.downloadSource;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void b(@Nullable AdTemplate adTemplate, int i2) {
        o.a aVar = new o.a();
        aVar.f32607g = i2;
        a(adTemplate, 321, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        o.a aVar = new o.a();
        aVar.f32601a = i2;
        a(adTemplate, 402, aVar, jSONObject);
    }

    public static void b(@Nullable AdTemplate adTemplate, o.a aVar) {
        a(adTemplate, 51, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 601, jSONObject);
    }

    public static void c(final AdTemplate adTemplate) {
        f32547a.submit(new Runnable() { // from class: com.kwad.sdk.core.report.b.2
            @Override // java.lang.Runnable
            public void run() {
                AdInfo g2 = com.kwad.sdk.core.response.b.c.g(AdTemplate.this);
                int b2 = w.b(g2.downloadId, com.kwad.sdk.core.response.b.a.q(g2));
                o.a aVar = new o.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.f32608h = adTemplate2.downloadSource;
                aVar.f32609i = b2;
                aVar.j = adTemplate2.installFrom;
                b.a(adTemplate2, 32, aVar, (JSONObject) null);
            }
        });
    }

    public static void c(AdTemplate adTemplate, int i2) {
        o.a aVar = new o.a();
        aVar.f32604d = i2;
        a(adTemplate, 141, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        o.a aVar = new o.a();
        aVar.f32604d = i2;
        a(adTemplate, (int) PbFullScreenEditorActivity.REPLY_MAX_SIZE, aVar, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, o.a aVar) {
        a(adTemplate, 52, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        o.a aVar = new o.a();
        aVar.f32608h = adTemplate.downloadSource;
        a(adTemplate, 33, aVar, jSONObject);
    }

    public static void d(AdTemplate adTemplate) {
        d(adTemplate, 36);
    }

    public static void d(AdTemplate adTemplate, int i2) {
        a(adTemplate, i2, (o.a) null, new JSONObject());
    }

    public static void d(AdTemplate adTemplate, int i2, JSONObject jSONObject) {
        a(adTemplate, i2, (o.a) null, jSONObject);
    }

    public static void d(@Nullable AdTemplate adTemplate, o.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        o.a aVar = new o.a();
        aVar.f32608h = adTemplate.downloadSource;
        a(adTemplate, 34, aVar, jSONObject);
    }

    public static void e(AdTemplate adTemplate) {
        d(adTemplate, 38);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        f32547a.submit(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public void run() {
                o.a aVar = new o.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.f32608h = adTemplate2.downloadSource;
                b.f(adTemplate2, aVar);
                b.a(AdTemplate.this, 31, aVar, jSONObject);
                AdInfo g2 = com.kwad.sdk.core.response.b.c.g(AdTemplate.this);
                w.a(g2.downloadFilePath, g2.downloadId);
            }
        });
    }

    public static void f(AdTemplate adTemplate) {
        d(adTemplate, 41);
    }

    public static void f(AdTemplate adTemplate, o.a aVar) {
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        String str = g2.downloadFilePath;
        if (str == null) {
            return;
        }
        String q = com.kwad.sdk.core.response.b.a.q(g2);
        String a2 = w.a(str);
        if (a2 == null || TextUtils.isEmpty(a2) || a2.equals(q)) {
            return;
        }
        aVar.n = a2;
        aVar.m = q;
        g2.adBaseInfo.appPackageName = a2;
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        o.a aVar = new o.a();
        aVar.f32608h = adTemplate.downloadSource;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void g(AdTemplate adTemplate) {
        d(adTemplate, 37);
    }

    public static void g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void h(@Nullable AdTemplate adTemplate) {
        g(adTemplate, null);
    }

    public static void h(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 400, jSONObject);
    }

    public static void i(@Nullable AdTemplate adTemplate) {
        h(adTemplate, null);
    }

    public static void i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 501, jSONObject);
    }

    public static void j(@Nullable AdTemplate adTemplate) {
        d(adTemplate, 323);
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 450, jSONObject);
    }

    public static void k(@Nullable AdTemplate adTemplate) {
        d(adTemplate, 58);
    }

    public static void k(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 451, jSONObject);
    }

    public static void l(AdTemplate adTemplate) {
        a(adTemplate, 600, (o.a) null, (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate) {
        o.a aVar = new o.a();
        aVar.r = com.kwad.sdk.core.response.b.a.U(com.kwad.sdk.core.response.b.c.g(adTemplate));
        com.kwad.sdk.core.d.a.a("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.r);
        a(adTemplate, (int) SDKLogTypeConstants.TYPE_JMY_DEEP_LINK, aVar, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate) {
        d(adTemplate, 722);
    }

    public static void o(AdTemplate adTemplate) {
        d(adTemplate, 721);
    }
}
