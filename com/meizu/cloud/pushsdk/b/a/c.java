package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes2.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f67250a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f67251b;

    /* renamed from: c  reason: collision with root package name */
    public k f67252c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f67250a = null;
        this.f67251b = aVar;
    }

    public c(T t) {
        this.f67250a = t;
        this.f67251b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f67250a;
    }

    public void a(k kVar) {
        this.f67252c = kVar;
    }

    public boolean b() {
        return this.f67251b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f67251b;
    }
}
