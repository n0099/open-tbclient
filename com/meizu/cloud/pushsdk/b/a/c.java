package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f35394a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f35395b;

    /* renamed from: c  reason: collision with root package name */
    public k f35396c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f35394a = null;
        this.f35395b = aVar;
    }

    public c(T t) {
        this.f35394a = t;
        this.f35395b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f35394a;
    }

    public void a(k kVar) {
        this.f35396c = kVar;
    }

    public boolean b() {
        return this.f35395b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f35395b;
    }
}
