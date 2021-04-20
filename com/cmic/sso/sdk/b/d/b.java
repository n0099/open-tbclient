package com.cmic.sso.sdk.b.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f30350a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<String>> f30351b;

    /* renamed from: c  reason: collision with root package name */
    public String f30352c;

    public b(int i, Map<String, List<String>> map, String str) {
        this.f30350a = i;
        this.f30351b = map;
        this.f30352c = str;
    }

    public int a() {
        return this.f30350a;
    }

    public Map<String, List<String>> b() {
        Map<String, List<String>> map = this.f30351b;
        return map == null ? new HashMap() : map;
    }

    public String c() {
        String str = this.f30352c;
        return str == null ? "" : str;
    }

    public boolean d() {
        int i = this.f30350a;
        return i == 302 || i == 301;
    }
}
