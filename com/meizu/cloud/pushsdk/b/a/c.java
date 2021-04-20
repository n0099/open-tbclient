package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f37750a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f37751b;

    /* renamed from: c  reason: collision with root package name */
    public k f37752c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f37750a = null;
        this.f37751b = aVar;
    }

    public c(T t) {
        this.f37750a = t;
        this.f37751b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f37750a;
    }

    public void a(k kVar) {
        this.f37752c = kVar;
    }

    public boolean b() {
        return this.f37751b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f37751b;
    }
}
