package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes4.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f11138a;

    /* renamed from: b  reason: collision with root package name */
    private final com.meizu.cloud.pushsdk.b.b.a f11139b;
    private k c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f11138a = null;
        this.f11139b = aVar;
    }

    public c(T t) {
        this.f11138a = t;
        this.f11139b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f11138a;
    }

    public void a(k kVar) {
        this.c = kVar;
    }

    public boolean b() {
        return this.f11139b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f11139b;
    }
}
