package com.cmic.sso.sdk.b.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f30619a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<String>> f30620b;

    /* renamed from: c  reason: collision with root package name */
    public String f30621c;

    public b(int i2, Map<String, List<String>> map, String str) {
        this.f30619a = i2;
        this.f30620b = map;
        this.f30621c = str;
    }

    public int a() {
        return this.f30619a;
    }

    public Map<String, List<String>> b() {
        Map<String, List<String>> map = this.f30620b;
        return map == null ? new HashMap() : map;
    }

    public String c() {
        String str = this.f30621c;
        return str == null ? "" : str;
    }

    public boolean d() {
        int i2 = this.f30619a;
        return i2 == 302 || i2 == 301;
    }
}
