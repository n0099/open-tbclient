package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final Type hPh;
    final Class<? super T> hQl;
    final int hashCode;

    protected a() {
        this.hPh = w(getClass());
        this.hQl = (Class<? super T>) C$Gson$Types.f(this.hPh);
        this.hashCode = this.hPh.hashCode();
    }

    a(Type type) {
        this.hPh = C$Gson$Types.e((Type) com.google.gson.internal.a.checkNotNull(type));
        this.hQl = (Class<? super T>) C$Gson$Types.f(this.hPh);
        this.hashCode = this.hPh.hashCode();
    }

    static Type w(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.e(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> bNi() {
        return this.hQl;
    }

    public final Type bNj() {
        return this.hPh;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.hPh, ((a) obj).hPh);
    }

    public final String toString() {
        return C$Gson$Types.g(this.hPh);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> x(Class<T> cls) {
        return new a<>(cls);
    }
}
