package com.meizu.cloud.pushsdk.c.a;

import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String f37677a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, Object> f37678b = new HashMap<>();

    public b(String str, Object obj) {
        a(str);
        a(obj);
    }

    public b a(Object obj) {
        if (obj == null) {
            return this;
        }
        this.f37678b.put("dt", obj);
        return this;
    }

    public b a(String str) {
        d.a(str, "schema cannot be null");
        d.a(!str.isEmpty(), "schema cannot be empty.");
        this.f37678b.put("sa", str);
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public Map<String, Object> a() {
        return this.f37678b;
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    @Deprecated
    public void a(String str, String str2) {
        com.meizu.cloud.pushsdk.c.f.c.c(this.f37677a, "Payload: add(String, String) method called - Doing nothing.", new Object[0]);
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public long b() {
        return e.a(toString());
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public String toString() {
        return e.a((Map) this.f37678b).toString();
    }
}
