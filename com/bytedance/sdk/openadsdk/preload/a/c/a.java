package com.bytedance.sdk.openadsdk.preload.a.c;

import com.bytedance.sdk.openadsdk.preload.a.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public class a<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Class<? super T> f30080b;

    /* renamed from: c  reason: collision with root package name */
    public final Type f30081c;

    /* renamed from: d  reason: collision with root package name */
    public final int f30082d;

    public a() {
        Type a2 = a(getClass());
        this.f30081c = a2;
        this.f30080b = (Class<? super T>) b.e(a2);
        this.f30082d = this.f30081c.hashCode();
    }

    public static Type a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return b.d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Type b() {
        return this.f30081c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.a(this.f30081c, ((a) obj).f30081c);
    }

    public final int hashCode() {
        return this.f30082d;
    }

    public final String toString() {
        return b.f(this.f30081c);
    }

    public static <T> a<T> b(Class<T> cls) {
        return new a<>(cls);
    }

    public a(Type type) {
        Type d2 = b.d((Type) com.bytedance.sdk.openadsdk.preload.a.b.a.a(type));
        this.f30081c = d2;
        this.f30080b = (Class<? super T>) b.e(d2);
        this.f30082d = this.f30081c.hashCode();
    }

    public final Class<? super T> a() {
        return this.f30080b;
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }
}
