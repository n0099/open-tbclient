package com.cmic.sso.sdk.b.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f30664a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<String>> f30665b;

    /* renamed from: c  reason: collision with root package name */
    public String f30666c;

    public b(int i, Map<String, List<String>> map, String str) {
        this.f30664a = i;
        this.f30665b = map;
        this.f30666c = str;
    }

    public int a() {
        return this.f30664a;
    }

    public Map<String, List<String>> b() {
        Map<String, List<String>> map = this.f30665b;
        return map == null ? new HashMap() : map;
    }

    public String c() {
        String str = this.f30666c;
        return str == null ? "" : str;
    }

    public boolean d() {
        int i = this.f30664a;
        return i == 302 || i == 301;
    }
}
