package com.cmic.sso.sdk.c.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f7717a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, List<String>> f7718b;
    private String c;

    public b(int i, Map<String, List<String>> map, String str) {
        this.f7717a = i;
        this.f7718b = map;
        this.c = str;
    }

    public int a() {
        return this.f7717a;
    }

    public Map<String, List<String>> b() {
        return this.f7718b == null ? new HashMap() : this.f7718b;
    }

    public String c() {
        return this.c == null ? "" : this.c;
    }

    public boolean d() {
        return this.f7717a == 302 || this.f7717a == 301;
    }
}
