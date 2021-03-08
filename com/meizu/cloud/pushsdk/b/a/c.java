package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes4.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f7330a;
    private final com.meizu.cloud.pushsdk.b.b.a b;
    private k c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f7330a = null;
        this.b = aVar;
    }

    public c(T t) {
        this.f7330a = t;
        this.b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f7330a;
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
