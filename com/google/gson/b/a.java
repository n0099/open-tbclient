package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final Type hKc;
    final Class<? super T> hLg;
    final int hashCode;

    protected a() {
        this.hKc = t(getClass());
        this.hLg = (Class<? super T>) C$Gson$Types.f(this.hKc);
        this.hashCode = this.hKc.hashCode();
    }

    a(Type type) {
        this.hKc = C$Gson$Types.e((Type) com.google.gson.internal.a.checkNotNull(type));
        this.hLg = (Class<? super T>) C$Gson$Types.f(this.hKc);
        this.hashCode = this.hKc.hashCode();
    }

    static Type t(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.e(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> bOf() {
        return this.hLg;
    }

    public final Type bOg() {
        return this.hKc;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.hKc, ((a) obj).hKc);
    }

    public final String toString() {
        return C$Gson$Types.g(this.hKc);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> u(Class<T> cls) {
        return new a<>(cls);
    }
}
