package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final Type hGN;
    final Class<? super T> hHR;
    final int hashCode;

    protected a() {
        this.hGN = t(getClass());
        this.hHR = (Class<? super T>) C$Gson$Types.f(this.hGN);
        this.hashCode = this.hGN.hashCode();
    }

    a(Type type) {
        this.hGN = C$Gson$Types.e((Type) com.google.gson.internal.a.checkNotNull(type));
        this.hHR = (Class<? super T>) C$Gson$Types.f(this.hGN);
        this.hashCode = this.hGN.hashCode();
    }

    static Type t(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.e(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> bKr() {
        return this.hHR;
    }

    public final Type bKs() {
        return this.hGN;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.hGN, ((a) obj).hGN);
    }

    public final String toString() {
        return C$Gson$Types.g(this.hGN);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> u(Class<T> cls) {
        return new a<>(cls);
    }
}
