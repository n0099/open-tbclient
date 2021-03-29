package com.cmic.sso.sdk.b.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f30665a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<String>> f30666b;

    /* renamed from: c  reason: collision with root package name */
    public String f30667c;

    public b(int i, Map<String, List<String>> map, String str) {
        this.f30665a = i;
        this.f30666b = map;
        this.f30667c = str;
    }

    public int a() {
        return this.f30665a;
    }

    public Map<String, List<String>> b() {
        Map<String, List<String>> map = this.f30666b;
        return map == null ? new HashMap() : map;
    }

    public String c() {
        String str = this.f30667c;
        return str == null ? "" : str;
    }

    public boolean d() {
        int i = this.f30665a;
        return i == 302 || i == 301;
    }
}
