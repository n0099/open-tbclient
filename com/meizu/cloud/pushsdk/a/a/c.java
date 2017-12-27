package com.meizu.cloud.pushsdk.a.a;

import com.meizu.cloud.pushsdk.a.d.k;
/* loaded from: classes2.dex */
public class c<T> {
    private final T a;
    private final com.meizu.cloud.pushsdk.a.c.a b;
    private k c;

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.a.c.a aVar) {
        return new c<>(aVar);
    }

    public c(T t) {
        this.a = t;
        this.b = null;
    }

    public c(com.meizu.cloud.pushsdk.a.c.a aVar) {
        this.a = null;
        this.b = aVar;
    }

    public T a() {
        return this.a;
    }

    public boolean b() {
        return this.b == null;
    }

    public com.meizu.cloud.pushsdk.a.c.a c() {
        return this.b;
    }

    public void a(k kVar) {
        this.c = kVar;
    }

    public k d() {
        return this.c;
    }
}
