package com.meizu.cloud.pushsdk.c.a;

import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final String f7394a = b.class.getSimpleName();
    private final HashMap<String, Object> b = new HashMap<>();

    public b(String str, Object obj) {
        a(str);
        a(obj);
    }

    public b a(Object obj) {
        if (obj != null) {
            this.b.put("dt", obj);
        }
        return this;
    }

    public b a(String str) {
        d.a(str, "schema cannot be null");
        d.a(!str.isEmpty(), "schema cannot be empty.");
        this.b.put("sa", str);
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public Map<String, Object> a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    @Deprecated
    public void a(String str, String str2) {
        com.meizu.cloud.pushsdk.c.f.c.c(this.f7394a, "Payload: add(String, String) method called - Doing nothing.", new Object[0]);
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public long b() {
        return e.a(toString());
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public String toString() {
        return e.a((Map) this.b).toString();
    }
}
