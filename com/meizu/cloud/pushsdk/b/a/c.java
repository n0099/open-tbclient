package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes7.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f38247a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f38248b;

    /* renamed from: c  reason: collision with root package name */
    public k f38249c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f38247a = null;
        this.f38248b = aVar;
    }

    public c(T t) {
        this.f38247a = t;
        this.f38248b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f38247a;
    }

    public void a(k kVar) {
        this.f38249c = kVar;
    }

    public boolean b() {
        return this.f38248b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f38248b;
    }
}
