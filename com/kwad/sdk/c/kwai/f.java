package com.kwad.sdk.c.kwai;

import android.net.Uri;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f57665b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f57666c;

    /* renamed from: d  reason: collision with root package name */
    public String f57667d;

    /* renamed from: e  reason: collision with root package name */
    public String f57668e;

    public f(String str) {
        Uri parse = Uri.parse(str);
        this.a = parse.getHost();
        this.f57665b = parse.getScheme();
        this.f57666c = parse.getPathSegments();
        this.f57668e = parse.getQueryParameter("sceneId");
        this.f57667d = parse.getPath();
    }

    public String a() {
        return this.a + this.f57667d;
    }

    public String b() {
        return this.f57668e;
    }

    public String c() {
        List<String> list = this.f57666c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<String> list2 = this.f57666c;
        return list2.get(list2.size() - 1);
    }
}
