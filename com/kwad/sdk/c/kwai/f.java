package com.kwad.sdk.c.kwai;

import android.net.Uri;
import java.util.List;
/* loaded from: classes5.dex */
public class f {
    public String a;
    public String b;
    public List<String> c;
    public String d;
    public String e;

    public f(String str) {
        Uri parse = Uri.parse(str);
        this.a = parse.getHost();
        this.b = parse.getScheme();
        this.c = parse.getPathSegments();
        this.e = parse.getQueryParameter("sceneId");
        this.d = parse.getPath();
    }

    public String a() {
        return this.a + this.d;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        List<String> list = this.c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<String> list2 = this.c;
        return list2.get(list2.size() - 1);
    }
}
