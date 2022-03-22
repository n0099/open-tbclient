package com.kwad.sdk.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.splashscreen.a.i;
/* loaded from: classes7.dex */
public class e {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41326b;

    /* renamed from: c  reason: collision with root package name */
    public int f41327c = 2;

    public static e a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.sdk.core.download.a.b bVar) {
        String str;
        int c2;
        e eVar = new e();
        if (adInfo == null || !com.kwad.sdk.core.response.a.a.B(adInfo) || bVar == null) {
            String aB = com.kwad.sdk.core.config.b.aB();
            if (TextUtils.isEmpty(aB)) {
                aB = "点击跳过详情页或第三方应用";
            }
            str = "或" + aB;
        } else {
            com.kwad.sdk.core.d.a.c("SplashActionBarModel", "createModel localStatus: " + bVar.c());
            str = "或点击" + a(adTemplate, adInfo, c2);
        }
        eVar.a(str);
        eVar.a(com.kwad.sdk.core.response.a.b.a(adInfo));
        eVar.a(i.a(adInfo));
        return eVar;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i) {
        return i != 8 ? i != 12 ? com.kwad.sdk.core.response.a.a.A(adInfo) : com.kwad.sdk.core.response.a.a.m(adInfo) : com.kwad.sdk.core.response.a.a.a(adTemplate);
    }

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.f41327c = i;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.f41326b = z;
    }

    public int b() {
        return this.f41327c;
    }
}
