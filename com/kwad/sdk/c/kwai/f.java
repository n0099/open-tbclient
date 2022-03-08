package com.kwad.sdk.c.kwai;

import android.net.Uri;
import java.util.List;
/* loaded from: classes7.dex */
public class f {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f54041b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f54042c;

    /* renamed from: d  reason: collision with root package name */
    public String f54043d;

    /* renamed from: e  reason: collision with root package name */
    public String f54044e;

    public f(String str) {
        Uri parse = Uri.parse(str);
        this.a = parse.getHost();
        this.f54041b = parse.getScheme();
        this.f54042c = parse.getPathSegments();
        this.f54044e = parse.getQueryParameter("sceneId");
        this.f54043d = parse.getPath();
    }

    public String a() {
        return this.a + this.f54043d;
    }

    public String b() {
        return this.f54044e;
    }

    public String c() {
        List<String> list = this.f54042c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<String> list2 = this.f54042c;
        return list2.get(list2.size() - 1);
    }
}
