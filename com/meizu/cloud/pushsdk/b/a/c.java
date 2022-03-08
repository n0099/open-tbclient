package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes8.dex */
public class c<T> {
    public final T a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f57069b;

    /* renamed from: c  reason: collision with root package name */
    public k f57070c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.a = null;
        this.f57069b = aVar;
    }

    public c(T t) {
        this.a = t;
        this.f57069b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.a;
    }

    public void a(k kVar) {
        this.f57070c = kVar;
    }

    public boolean b() {
        return this.f57069b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f57069b;
    }
}
