package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final Type hHg;
    final Class<? super T> hIk;
    final int hashCode;

    protected a() {
        this.hHg = t(getClass());
        this.hIk = (Class<? super T>) C$Gson$Types.f(this.hHg);
        this.hashCode = this.hHg.hashCode();
    }

    a(Type type) {
        this.hHg = C$Gson$Types.e((Type) com.google.gson.internal.a.checkNotNull(type));
        this.hIk = (Class<? super T>) C$Gson$Types.f(this.hHg);
        this.hashCode = this.hHg.hashCode();
    }

    static Type t(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.e(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> bKA() {
        return this.hIk;
    }

    public final Type bKB() {
        return this.hHg;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.hHg, ((a) obj).hHg);
    }

    public final String toString() {
        return C$Gson$Types.g(this.hHg);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> u(Class<T> cls) {
        return new a<>(cls);
    }
}
