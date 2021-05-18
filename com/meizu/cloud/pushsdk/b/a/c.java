package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f34639a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f34640b;

    /* renamed from: c  reason: collision with root package name */
    public k f34641c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f34639a = null;
        this.f34640b = aVar;
    }

    public c(T t) {
        this.f34639a = t;
        this.f34640b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f34639a;
    }

    public void a(k kVar) {
        this.f34641c = kVar;
    }

    public boolean b() {
        return this.f34640b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f34640b;
    }
}
