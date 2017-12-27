package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.f.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c implements a {
    private final String a = c.class.getSimpleName();
    private final HashMap<String, Object> b = new HashMap<>();

    @Override // com.meizu.cloud.pushsdk.b.a.a
    public void a(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            com.meizu.cloud.pushsdk.b.f.c.c(this.a, "The keys value is empty, returning without adding key: " + str, new Object[0]);
        } else {
            this.b.put(str, str2);
        }
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            com.meizu.cloud.pushsdk.b.f.c.c(this.a, "The keys value is empty, returning without adding key: " + str, new Object[0]);
        } else {
            this.b.put(str, obj);
        }
    }

    public void a(Map<String, Object> map) {
        if (map == null) {
            com.meizu.cloud.pushsdk.b.f.c.c(this.a, "Map passed in is null, returning without adding map.", new Object[0]);
        } else {
            this.b.putAll(map);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.a.a
    public Map a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.b.a.a
    public String toString() {
        return e.a((Map) this.b).toString();
    }

    @Override // com.meizu.cloud.pushsdk.b.a.a
    public long b() {
        return e.a(toString());
    }
}
