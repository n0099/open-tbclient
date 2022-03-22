package com.kwad.sdk.c.kwai;

import android.net.Uri;
import java.util.List;
/* loaded from: classes7.dex */
public class f {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f39190b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f39191c;

    /* renamed from: d  reason: collision with root package name */
    public String f39192d;

    /* renamed from: e  reason: collision with root package name */
    public String f39193e;

    public f(String str) {
        Uri parse = Uri.parse(str);
        this.a = parse.getHost();
        this.f39190b = parse.getScheme();
        this.f39191c = parse.getPathSegments();
        this.f39193e = parse.getQueryParameter("sceneId");
        this.f39192d = parse.getPath();
    }

    public String a() {
        return this.a + this.f39192d;
    }

    public String b() {
        return this.f39193e;
    }

    public String c() {
        List<String> list = this.f39191c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<String> list2 = this.f39191c;
        return list2.get(list2.size() - 1);
    }
}
