package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes3.dex */
public class c<T> {
    public final T a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f58507b;

    /* renamed from: c  reason: collision with root package name */
    public k f58508c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.a = null;
        this.f58507b = aVar;
    }

    public c(T t) {
        this.a = t;
        this.f58507b = null;
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
        this.f58508c = kVar;
    }

    public boolean b() {
        return this.f58507b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f58507b;
    }
}
