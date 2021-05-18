package com.bytedance.sdk.openadsdk.preload.a.c;

import com.bytedance.sdk.openadsdk.preload.a.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public class a<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Class<? super T> f29927b;

    /* renamed from: c  reason: collision with root package name */
    public final Type f29928c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29929d;

    public a() {
        Type a2 = a(getClass());
        this.f29928c = a2;
        this.f29927b = (Class<? super T>) b.e(a2);
        this.f29929d = this.f29928c.hashCode();
    }

    public static Type a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return b.d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Type b() {
        return this.f29928c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.a(this.f29928c, ((a) obj).f29928c);
    }

    public final int hashCode() {
        return this.f29929d;
    }

    public final String toString() {
        return b.f(this.f29928c);
    }

    public static <T> a<T> b(Class<T> cls) {
        return new a<>(cls);
    }

    public a(Type type) {
        Type d2 = b.d((Type) com.bytedance.sdk.openadsdk.preload.a.b.a.a(type));
        this.f29928c = d2;
        this.f29927b = (Class<? super T>) b.e(d2);
        this.f29929d = this.f29928c.hashCode();
    }

    public final Class<? super T> a() {
        return this.f29927b;
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }
}
