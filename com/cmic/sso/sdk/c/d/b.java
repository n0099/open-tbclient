package com.cmic.sso.sdk.c.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f8016a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, List<String>> f8017b;
    private String c;

    public b(int i, Map<String, List<String>> map, String str) {
        this.f8016a = i;
        this.f8017b = map;
        this.c = str;
    }

    public int a() {
        return this.f8016a;
    }

    public Map<String, List<String>> b() {
        return this.f8017b == null ? new HashMap() : this.f8017b;
    }

    public String c() {
        return this.c == null ? "" : this.c;
    }

    public boolean d() {
        return this.f8016a == 302 || this.f8016a == 301;
    }
}
