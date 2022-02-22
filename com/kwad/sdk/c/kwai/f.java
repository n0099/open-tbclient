package com.kwad.sdk.c.kwai;

import android.net.Uri;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f55691b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f55692c;

    /* renamed from: d  reason: collision with root package name */
    public String f55693d;

    /* renamed from: e  reason: collision with root package name */
    public String f55694e;

    public f(String str) {
        Uri parse = Uri.parse(str);
        this.a = parse.getHost();
        this.f55691b = parse.getScheme();
        this.f55692c = parse.getPathSegments();
        this.f55694e = parse.getQueryParameter("sceneId");
        this.f55693d = parse.getPath();
    }

    public String a() {
        return this.a + this.f55693d;
    }

    public String b() {
        return this.f55694e;
    }

    public String c() {
        List<String> list = this.f55692c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<String> list2 = this.f55692c;
        return list2.get(list2.size() - 1);
    }
}
