package com.cmic.sso.sdk.b.d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f31374a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, List<String>> f31375b;

    /* renamed from: c  reason: collision with root package name */
    public String f31376c;

    public b(int i2, Map<String, List<String>> map, String str) {
        this.f31374a = i2;
        this.f31375b = map;
        this.f31376c = str;
    }

    public int a() {
        return this.f31374a;
    }

    public Map<String, List<String>> b() {
        Map<String, List<String>> map = this.f31375b;
        return map == null ? new HashMap() : map;
    }

    public String c() {
        String str = this.f31376c;
        return str == null ? "" : str;
    }

    public boolean d() {
        int i2 = this.f31374a;
        return i2 == 302 || i2 == 301;
    }
}
