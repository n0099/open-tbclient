package com.cmic.sso.sdk.c.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f5215a;
    private Map<String, List<String>> b;
    private String c;

    public b(int i, Map<String, List<String>> map, String str) {
        this.f5215a = i;
        this.b = map;
        this.c = str;
    }

    public int a() {
        return this.f5215a;
    }

    public Map<String, List<String>> b() {
        return this.b == null ? new HashMap() : this.b;
    }

    public String c() {
        return this.c == null ? "" : this.c;
    }

    public boolean d() {
        return this.f5215a == 302 || this.f5215a == 301;
    }
}
