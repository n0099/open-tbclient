package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f11436a;

    /* renamed from: b  reason: collision with root package name */
    private final com.meizu.cloud.pushsdk.b.b.a f11437b;
    private k c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f11436a = null;
        this.f11437b = aVar;
    }

    public c(T t) {
        this.f11436a = t;
        this.f11437b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f11436a;
    }

    public void a(k kVar) {
        this.c = kVar;
    }

    public boolean b() {
        return this.f11437b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f11437b;
    }
}
