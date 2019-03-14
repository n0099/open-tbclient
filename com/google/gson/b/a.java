package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type jPn;
    final Class<? super T> jQB;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.jPn = E(getClass());
        this.jQB = (Class<? super T>) C$Gson$Types.g(this.jPn);
        this.hashCode = this.jPn.hashCode();
    }

    a(Type type) {
        this.jPn = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.jQB = (Class<? super T>) C$Gson$Types.g(this.jPn);
        this.hashCode = this.jPn.hashCode();
    }

    static Type E(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cBJ() {
        return this.jQB;
    }

    public final Type cBK() {
        return this.jPn;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.jPn, ((a) obj).jPn);
    }

    public final String toString() {
        return C$Gson$Types.h(this.jPn);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> F(Class<T> cls) {
        return new a<>(cls);
    }
}
