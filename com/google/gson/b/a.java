package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final Type hOi;
    final Class<? super T> hPm;
    final int hashCode;

    protected a() {
        this.hOi = t(getClass());
        this.hPm = (Class<? super T>) C$Gson$Types.f(this.hOi);
        this.hashCode = this.hOi.hashCode();
    }

    a(Type type) {
        this.hOi = C$Gson$Types.e((Type) com.google.gson.internal.a.checkNotNull(type));
        this.hPm = (Class<? super T>) C$Gson$Types.f(this.hOi);
        this.hashCode = this.hOi.hashCode();
    }

    static Type t(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.e(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> bOH() {
        return this.hPm;
    }

    public final Type bOI() {
        return this.hOi;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.hOi, ((a) obj).hOi);
    }

    public final String toString() {
        return C$Gson$Types.g(this.hOi);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> u(Class<T> cls) {
        return new a<>(cls);
    }
}
