package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes2.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f67251a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f67252b;

    /* renamed from: c  reason: collision with root package name */
    public k f67253c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f67251a = null;
        this.f67252b = aVar;
    }

    public c(T t) {
        this.f67251a = t;
        this.f67252b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f67251a;
    }

    public void a(k kVar) {
        this.f67253c = kVar;
    }

    public boolean b() {
        return this.f67252b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f67252b;
    }
}
