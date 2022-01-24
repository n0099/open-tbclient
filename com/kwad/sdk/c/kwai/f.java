package com.kwad.sdk.c.kwai;

import android.net.Uri;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f55524b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f55525c;

    /* renamed from: d  reason: collision with root package name */
    public String f55526d;

    /* renamed from: e  reason: collision with root package name */
    public String f55527e;

    public f(String str) {
        Uri parse = Uri.parse(str);
        this.a = parse.getHost();
        this.f55524b = parse.getScheme();
        this.f55525c = parse.getPathSegments();
        this.f55527e = parse.getQueryParameter("sceneId");
        this.f55526d = parse.getPath();
    }

    public String a() {
        return this.a + this.f55526d;
    }

    public String b() {
        return this.f55527e;
    }

    public String c() {
        List<String> list = this.f55525c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<String> list2 = this.f55525c;
        return list2.get(list2.size() - 1);
    }
}
