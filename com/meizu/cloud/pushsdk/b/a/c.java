package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f37311a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f37312b;

    /* renamed from: c  reason: collision with root package name */
    public k f37313c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f37311a = null;
        this.f37312b = aVar;
    }

    public c(T t) {
        this.f37311a = t;
        this.f37312b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f37311a;
    }

    public void a(k kVar) {
        this.f37313c = kVar;
    }

    public boolean b() {
        return this.f37312b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f37312b;
    }
}
