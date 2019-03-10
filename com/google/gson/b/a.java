package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type jPv;
    final Class<? super T> jQJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.jPv = E(getClass());
        this.jQJ = (Class<? super T>) C$Gson$Types.g(this.jPv);
        this.hashCode = this.jPv.hashCode();
    }

    a(Type type) {
        this.jPv = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.jQJ = (Class<? super T>) C$Gson$Types.g(this.jPv);
        this.hashCode = this.jPv.hashCode();
    }

    static Type E(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cBG() {
        return this.jQJ;
    }

    public final Type cBH() {
        return this.jPv;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.jPv, ((a) obj).jPv);
    }

    public final String toString() {
        return C$Gson$Types.h(this.jPv);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> F(Class<T> cls) {
        return new a<>(cls);
    }
}
