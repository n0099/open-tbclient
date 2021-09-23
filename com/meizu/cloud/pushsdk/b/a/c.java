package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes10.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f74850a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f74851b;

    /* renamed from: c  reason: collision with root package name */
    public k f74852c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f74850a = null;
        this.f74851b = aVar;
    }

    public c(T t) {
        this.f74850a = t;
        this.f74851b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f74850a;
    }

    public void a(k kVar) {
        this.f74852c = kVar;
    }

    public boolean b() {
        return this.f74851b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f74851b;
    }
}
