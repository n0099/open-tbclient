package com.kwad.sdk.core.report;

import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.y;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f34291a = Executors.newSingleThreadExecutor();

    /* loaded from: classes6.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {

        /* renamed from: a  reason: collision with root package name */
        public int f34301a;

        /* renamed from: b  reason: collision with root package name */
        public String f34302b;

        public a(int i, String str) {
            this.f34301a = i;
            this.f34302b = str;
        }
    }

    public static void a(AdTemplate adTemplate) {
        e(adTemplate, 4);
    }

    public static void a(@Nullable AdTemplate adTemplate, int i) {
        o.a aVar = new o.a();
        aVar.f34352g = i;
        a(adTemplate, (int) MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, int i2) {
        o.a aVar = new o.a();
        aVar.f34349d = 69;
        aVar.o = i;
        aVar.p = i2;
        a(adTemplate, 141, aVar, (JSONObject) null);
    }

    public static void a(@Nullable final AdTemplate adTemplate, final int i, @Nullable final o.a aVar, @Nullable final JSONObject jSONObject) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.d.a.a("AdReportManager", i + "");
        new n() { // from class: com.kwad.sdk.core.report.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public o b() {
                return new o(AdTemplate.this, i, aVar, jSONObject);
            }
        }.d();
    }

    public static void a(AdTemplate adTemplate, int i, @Nullable s.a aVar) {
        o.a aVar2 = new o.a();
        aVar2.f34347b = i;
        if (aVar != null) {
            aVar2.f34350e = aVar;
        }
        a(adTemplate, 2, aVar2, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, s.a aVar, @Nullable JSONObject jSONObject) {
        o.a aVar2 = new o.a();
        aVar2.f34347b = i;
        aVar2.f34350e = aVar;
        a(adTemplate, 2, aVar2, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        o.a aVar = new o.a();
        aVar.f34348c = i;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        o.a aVar = new o.a();
        aVar.f34351f = str;
        a(adTemplate, i, aVar, jSONObject);
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

    public static void a(AdTemplate adTemplate, s.a aVar) {
        o.a aVar2 = new o.a();
        aVar2.f34350e = aVar;
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

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, s.a aVar, String str) {
        o.a aVar2 = new o.a();
        aVar2.f34350e = aVar;
        aVar2.f34351f = str;
        a(adTemplate, 2, aVar2, jSONObject);
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject, String str) {
        o.a aVar = new o.a();
        aVar.f34351f = str;
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate) {
        o.a aVar = new o.a();
        aVar.f34353h = adTemplate.downloadSource;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void b(@Nullable AdTemplate adTemplate, int i) {
        o.a aVar = new o.a();
        aVar.f34352g = i;
        a(adTemplate, 321, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        o.a aVar = new o.a();
        aVar.f34346a = i;
        a(adTemplate, 402, aVar, jSONObject);
    }

    public static void b(@Nullable AdTemplate adTemplate, o.a aVar) {
        a(adTemplate, 51, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, JSONObject jSONObject) {
        e(adTemplate, 601, jSONObject);
    }

    public static void c(final AdTemplate adTemplate) {
        com.kwad.sdk.core.response.b.c.j(adTemplate);
        f34291a.submit(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public void run() {
                o.a aVar = new o.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.f34353h = adTemplate2.downloadSource;
                b.f(adTemplate2, aVar);
                b.a(AdTemplate.this, 31, aVar, (JSONObject) null);
            }
        });
    }

    public static void c(AdTemplate adTemplate, int i) {
        o.a aVar = new o.a();
        f(adTemplate, aVar);
        a(adTemplate, i, aVar, new JSONObject());
    }

    public static void c(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        o.a aVar = new o.a();
        aVar.f34349d = i;
        a(adTemplate, (int) PbFullScreenEditorActivity.REPLY_MAX_SIZE, aVar, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, o.a aVar) {
        a(adTemplate, 52, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        o.a aVar = new o.a();
        aVar.f34353h = adTemplate.downloadSource;
        a(adTemplate, 33, aVar, jSONObject);
    }

    public static void d(final AdTemplate adTemplate) {
        f34291a.submit(new Runnable() { // from class: com.kwad.sdk.core.report.b.3
            @Override // java.lang.Runnable
            public void run() {
                int b2 = y.b(com.kwad.sdk.core.response.b.a.s(com.kwad.sdk.core.response.b.c.j(AdTemplate.this)));
                o.a aVar = new o.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.f34353h = adTemplate2.downloadSource;
                aVar.i = b2;
                aVar.j = adTemplate2.installFrom;
                b.a(adTemplate2, 32, aVar, (JSONObject) null);
            }
        });
    }

    public static void d(AdTemplate adTemplate, int i) {
        o.a aVar = new o.a();
        aVar.f34349d = i;
        a(adTemplate, 141, aVar, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        o.a aVar = new o.a();
        f(adTemplate, aVar);
        aVar.f34349d = i;
        a(adTemplate, (int) PbFullScreenEditorActivity.REPLY_MAX_SIZE, aVar, jSONObject);
    }

    public static void d(@Nullable AdTemplate adTemplate, o.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        o.a aVar = new o.a();
        aVar.f34353h = adTemplate.downloadSource;
        a(adTemplate, 34, aVar, jSONObject);
    }

    public static void e(AdTemplate adTemplate) {
        e(adTemplate, 36);
    }

    public static void e(AdTemplate adTemplate, int i) {
        a(adTemplate, i, (o.a) null, new JSONObject());
    }

    public static void e(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        a(adTemplate, i, (o.a) null, jSONObject);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        com.kwad.sdk.core.response.b.c.j(adTemplate);
        f34291a.submit(new Runnable() { // from class: com.kwad.sdk.core.report.b.2
            @Override // java.lang.Runnable
            public void run() {
                o.a aVar = new o.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.f34353h = adTemplate2.downloadSource;
                b.f(adTemplate2, aVar);
                b.a(AdTemplate.this, 31, aVar, jSONObject);
            }
        });
    }

    public static void f(AdTemplate adTemplate) {
        e(adTemplate, 38);
    }

    public static void f(AdTemplate adTemplate, o.a aVar) {
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        String str = j.downloadFilePath;
        if (str == null) {
            return;
        }
        String s = com.kwad.sdk.core.response.b.a.s(j);
        String a2 = y.a(str);
        if (a2 == null || TextUtils.isEmpty(a2) || a2.equals(s)) {
            return;
        }
        aVar.n = a2;
        aVar.m = s;
        j.adBaseInfo.appPackageName = a2;
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        o.a aVar = new o.a();
        aVar.f34353h = adTemplate.downloadSource;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void g(final AdTemplate adTemplate) {
        e(adTemplate, 37);
        f34291a.submit(new Runnable() { // from class: com.kwad.sdk.core.report.b.4
            @Override // java.lang.Runnable
            public void run() {
                AdInfo j = com.kwad.sdk.core.response.b.c.j(AdTemplate.this);
                y.a(j.downloadFilePath, j.adBaseInfo.appPackageName);
            }
        });
    }

    public static void g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 399, jSONObject);
    }

    public static void h(@Nullable AdTemplate adTemplate) {
        g(adTemplate, null);
    }

    public static void h(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 400, jSONObject);
    }

    public static void i(@Nullable AdTemplate adTemplate) {
        h(adTemplate, null);
    }

    public static void i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 501, jSONObject);
    }

    public static void j(@Nullable AdTemplate adTemplate) {
        e(adTemplate, 323);
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 450, jSONObject);
    }

    public static void k(@Nullable AdTemplate adTemplate) {
        e(adTemplate, 58);
    }

    public static void k(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        e(adTemplate, 451, jSONObject);
    }

    public static void l(@Nullable AdTemplate adTemplate) {
        e(adTemplate, (int) LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK);
    }

    public static void m(AdTemplate adTemplate) {
        a(adTemplate, 600, (o.a) null, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate) {
        a(adTemplate, (int) BaseActivity.DIALOG_LOADING, (o.a) null, (JSONObject) null);
    }

    public static void o(AdTemplate adTemplate) {
        o.a aVar = new o.a();
        aVar.q = com.kwad.sdk.core.response.b.a.ab(com.kwad.sdk.core.response.b.c.j(adTemplate));
        com.kwad.sdk.core.d.a.a("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.q);
        a(adTemplate, (int) SDKLogTypeConstants.TYPE_JMY_DEEP_LINK, aVar, (JSONObject) null);
    }
}
