package com.meizu.cloud.pushsdk.c.a;

import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String f38063a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, Object> f38064b = new HashMap<>();

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public Map a() {
        return this.f38064b;
    }

    public void a(String str, Object obj) {
        if (obj != null) {
            this.f38064b.put(str, obj);
            return;
        }
        String str2 = this.f38063a;
        com.meizu.cloud.pushsdk.c.f.c.c(str2, "The keys value is empty, returning without adding key: " + str, new Object[0]);
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public void a(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            this.f38064b.put(str, str2);
            return;
        }
        String str3 = this.f38063a;
        com.meizu.cloud.pushsdk.c.f.c.c(str3, "The keys value is empty, returning without adding key: " + str, new Object[0]);
    }

    public void a(Map<String, Object> map) {
        if (map == null) {
            com.meizu.cloud.pushsdk.c.f.c.c(this.f38063a, "Map passed in is null, returning without adding map.", new Object[0]);
        } else {
            this.f38064b.putAll(map);
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public long b() {
        return e.a(toString());
    }

    @Override // com.meizu.cloud.pushsdk.c.a.a
    public String toString() {
        return e.a((Map) this.f38064b).toString();
    }
}
