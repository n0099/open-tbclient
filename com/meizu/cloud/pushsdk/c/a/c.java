package com.meizu.cloud.pushsdk.c.a;

import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final String f11251a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Object> f11252b = new HashMap<>();

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public Map a() {
        return this.f11252b;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            com.meizu.cloud.pushsdk.c.f.c.c(this.f11251a, "The keys value is empty, returning without adding key: " + str, new Object[0]);
        } else {
            this.f11252b.put(str, obj);
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public void a(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            com.meizu.cloud.pushsdk.c.f.c.c(this.f11251a, "The keys value is empty, returning without adding key: " + str, new Object[0]);
        } else {
            this.f11252b.put(str, str2);
        }
    }

    public void a(Map<String, Object> map) {
        if (map == null) {
            com.meizu.cloud.pushsdk.c.f.c.c(this.f11251a, "Map passed in is null, returning without adding map.", new Object[0]);
        } else {
            this.f11252b.putAll(map);
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public long b() {
        return e.a(toString());
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public String toString() {
        return e.a((Map) this.f11252b).toString();
    }
}
