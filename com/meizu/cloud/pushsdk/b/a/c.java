package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes10.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f74151a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f74152b;

    /* renamed from: c  reason: collision with root package name */
    public k f74153c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f74151a = null;
        this.f74152b = aVar;
    }

    public c(T t) {
        this.f74151a = t;
        this.f74152b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f74151a;
    }

    public void a(k kVar) {
        this.f74153c = kVar;
    }

    public boolean b() {
        return this.f74152b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f74152b;
    }
}
