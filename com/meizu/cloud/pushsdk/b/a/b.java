package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.f.d;
import com.meizu.cloud.pushsdk.b.f.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements a {
    private final String a = b.class.getSimpleName();
    private final HashMap<String, Object> b = new HashMap<>();

    public b(String str, Object obj) {
        a(str);
        a(obj);
    }

    public b a(String str) {
        d.a(str, "schema cannot be null");
        d.a(!str.isEmpty(), "schema cannot be empty.");
        this.b.put("schema", str);
        return this;
    }

    public b a(Object obj) {
        if (obj != null) {
            this.b.put("data", obj);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.b.a.a
    @Deprecated
    public void a(String str, String str2) {
        com.meizu.cloud.pushsdk.b.f.c.c(this.a, "Payload: add(String, String) method called - Doing nothing.", new Object[0]);
    }

    @Override // com.meizu.cloud.pushsdk.b.a.a
    public Map<String, Object> a() {
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
