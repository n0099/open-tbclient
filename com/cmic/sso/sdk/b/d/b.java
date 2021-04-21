package com.cmic.sso.sdk.b.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f30445a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<String>> f30446b;

    /* renamed from: c  reason: collision with root package name */
    public String f30447c;

    public b(int i, Map<String, List<String>> map, String str) {
        this.f30445a = i;
        this.f30446b = map;
        this.f30447c = str;
    }

    public int a() {
        return this.f30445a;
    }

    public Map<String, List<String>> b() {
        Map<String, List<String>> map = this.f30446b;
        return map == null ? new HashMap() : map;
    }

    public String c() {
        String str = this.f30447c;
        return str == null ? "" : str;
    }

    public boolean d() {
        int i = this.f30445a;
        return i == 302 || i == 301;
    }
}
