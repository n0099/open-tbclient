package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes2.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f68163a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f68164b;

    /* renamed from: c  reason: collision with root package name */
    public k f68165c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f68163a = null;
        this.f68164b = aVar;
    }

    public c(T t) {
        this.f68163a = t;
        this.f68164b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f68163a;
    }

    public void a(k kVar) {
        this.f68165c = kVar;
    }

    public boolean b() {
        return this.f68164b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f68164b;
    }
}
