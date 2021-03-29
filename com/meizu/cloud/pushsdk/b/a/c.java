package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f37461a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f37462b;

    /* renamed from: c  reason: collision with root package name */
    public k f37463c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f37461a = null;
        this.f37462b = aVar;
    }

    public c(T t) {
        this.f37461a = t;
        this.f37462b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f37461a;
    }

    public void a(k kVar) {
        this.f37463c = kVar;
    }

    public boolean b() {
        return this.f37462b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f37462b;
    }
}
