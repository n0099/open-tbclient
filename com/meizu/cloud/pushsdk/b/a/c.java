package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes7.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f38345a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f38346b;

    /* renamed from: c  reason: collision with root package name */
    public k f38347c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f38345a = null;
        this.f38346b = aVar;
    }

    public c(T t) {
        this.f38345a = t;
        this.f38346b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f38345a;
    }

    public void a(k kVar) {
        this.f38347c = kVar;
    }

    public boolean b() {
        return this.f38346b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f38346b;
    }
}
