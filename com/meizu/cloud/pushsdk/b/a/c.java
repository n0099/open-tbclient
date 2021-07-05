package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes7.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f40108a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f40109b;

    /* renamed from: c  reason: collision with root package name */
    public k f40110c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f40108a = null;
        this.f40109b = aVar;
    }

    public c(T t) {
        this.f40108a = t;
        this.f40109b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f40108a;
    }

    public void a(k kVar) {
        this.f40110c = kVar;
    }

    public boolean b() {
        return this.f40109b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f40109b;
    }
}
