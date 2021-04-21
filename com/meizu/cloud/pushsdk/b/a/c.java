package com.meizu.cloud.pushsdk.b.a;

import com.meizu.cloud.pushsdk.b.c.k;
/* loaded from: classes6.dex */
public class c<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f37845a;

    /* renamed from: b  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.b.b.a f37846b;

    /* renamed from: c  reason: collision with root package name */
    public k f37847c;

    public c(com.meizu.cloud.pushsdk.b.b.a aVar) {
        this.f37845a = null;
        this.f37846b = aVar;
    }

    public c(T t) {
        this.f37845a = t;
        this.f37846b = null;
    }

    public static <T> c<T> a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        return new c<>(aVar);
    }

    public static <T> c<T> a(T t) {
        return new c<>(t);
    }

    public T a() {
        return this.f37845a;
    }

    public void a(k kVar) {
        this.f37847c = kVar;
    }

    public boolean b() {
        return this.f37846b == null;
    }

    public com.meizu.cloud.pushsdk.b.b.a c() {
        return this.f37846b;
    }
}
