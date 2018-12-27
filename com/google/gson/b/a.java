package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type iyj;
    final Class<? super T> izx;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.iyj = B(getClass());
        this.izx = (Class<? super T>) C$Gson$Types.g(this.iyj);
        this.hashCode = this.iyj.hashCode();
    }

    a(Type type) {
        this.iyj = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.izx = (Class<? super T>) C$Gson$Types.g(this.iyj);
        this.hashCode = this.iyj.hashCode();
    }

    static Type B(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cbJ() {
        return this.izx;
    }

    public final Type cbK() {
        return this.iyj;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.iyj, ((a) obj).iyj);
    }

    public final String toString() {
        return C$Gson$Types.h(this.iyj);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> C(Class<T> cls) {
        return new a<>(cls);
    }
}
