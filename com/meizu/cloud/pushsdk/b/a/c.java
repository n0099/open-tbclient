package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes8.dex */
public class c {
    public final Object a;
    public final com.meizu.cloud.pushsdk.b.b.a b;
    public k c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.a = null;
        this.b = aVar;
    }

    public c(Object obj) {
        this.a = obj;
        this.b = null;
    }

    public static c a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c(aVar);
    }

    public static c a(Object obj) {
        return new c(obj);
    }

    public Object a() {
        return this.a;
    }

    public void a(k kVar) {
        this.c = kVar;
    }

    public boolean b() {
        return this.b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.b;
    }
}
