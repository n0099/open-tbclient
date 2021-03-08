package com.bytedance.sdk.openadsdk.preload.a.c;

import com.bytedance.sdk.openadsdk.preload.a.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public class a<T> {
    final Class<? super T> b;
    final Type c;
    final int d;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.c = a(getClass());
        this.b = (Class<? super T>) b.e(this.c);
        this.d = this.c.hashCode();
    }

    a(Type type) {
        this.c = b.d((Type) com.bytedance.sdk.openadsdk.preload.a.b.a.a(type));
        this.b = (Class<? super T>) b.e(this.c);
        this.d = this.c.hashCode();
    }

    static Type a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return b.d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> a() {
        return this.b;
    }

    public final Type b() {
        return this.c;
    }

    public final int hashCode() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.a(this.c, ((a) obj).c);
    }

    public final String toString() {
        return b.f(this.c);
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> b(Class<T> cls) {
        return new a<>(cls);
    }
}
