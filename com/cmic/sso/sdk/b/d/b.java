package com.cmic.sso.sdk.b.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f30724a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<String>> f30725b;

    /* renamed from: c  reason: collision with root package name */
    public String f30726c;

    public b(int i2, Map<String, List<String>> map, String str) {
        this.f30724a = i2;
        this.f30725b = map;
        this.f30726c = str;
    }

    public int a() {
        return this.f30724a;
    }

    public Map<String, List<String>> b() {
        Map<String, List<String>> map = this.f30725b;
        return map == null ? new HashMap() : map;
    }

    public String c() {
        String str = this.f30726c;
        return str == null ? "" : str;
    }

    public boolean d() {
        int i2 = this.f30724a;
        return i2 == 302 || i2 == 301;
    }
}
