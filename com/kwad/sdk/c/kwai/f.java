package com.kwad.sdk.c.kwai;

import android.net.Uri;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f55479b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f55480c;

    /* renamed from: d  reason: collision with root package name */
    public String f55481d;

    /* renamed from: e  reason: collision with root package name */
    public String f55482e;

    public f(String str) {
        Uri parse = Uri.parse(str);
        this.a = parse.getHost();
        this.f55479b = parse.getScheme();
        this.f55480c = parse.getPathSegments();
        this.f55482e = parse.getQueryParameter("sceneId");
        this.f55481d = parse.getPath();
    }

    public String a() {
        return this.a + this.f55481d;
    }

    public String b() {
        return this.f55482e;
    }

    public String c() {
        List<String> list = this.f55480c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<String> list2 = this.f55480c;
        return list2.get(list2.size() - 1);
    }
}
