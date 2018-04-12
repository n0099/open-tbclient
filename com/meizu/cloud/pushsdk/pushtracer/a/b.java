package com.meizu.cloud.pushsdk.pushtracer.a;

import com.meizu.cloud.pushsdk.pushtracer.utils.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b implements a {
    private final String a = b.class.getSimpleName();
    private final HashMap<String, Object> b = new HashMap<>();

    public b(String str, Object obj) {
        a(str);
        a(obj);
    }

    public b a(String str) {
        com.meizu.cloud.pushsdk.pushtracer.utils.c.a(str, "schema cannot be null");
        com.meizu.cloud.pushsdk.pushtracer.utils.c.a(!str.isEmpty(), "schema cannot be empty.");
        this.b.put("schema", str);
        return this;
    }

    public b a(Object obj) {
        if (obj != null) {
            this.b.put("data", obj);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.pushtracer.a.a
    @Deprecated
    public void a(String str, String str2) {
        com.meizu.cloud.pushsdk.pushtracer.utils.b.c(this.a, "Payload: add(String, String) method called - Doing nothing.", new Object[0]);
    }

    @Override // com.meizu.cloud.pushsdk.pushtracer.a.a
    public Map<String, Object> a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.pushtracer.a.a
    public String toString() {
        return d.a((Map) this.b).toString();
    }

    @Override // com.meizu.cloud.pushsdk.pushtracer.a.a
    public long b() {
        return d.a(toString());
    }
}
