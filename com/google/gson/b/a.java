package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type jPc;
    final Class<? super T> jQq;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.jPc = E(getClass());
        this.jQq = (Class<? super T>) C$Gson$Types.g(this.jPc);
        this.hashCode = this.jPc.hashCode();
    }

    a(Type type) {
        this.jPc = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.jQq = (Class<? super T>) C$Gson$Types.g(this.jPc);
        this.hashCode = this.jPc.hashCode();
    }

    static Type E(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cBw() {
        return this.jQq;
    }

    public final Type cBx() {
        return this.jPc;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.jPc, ((a) obj).jPc);
    }

    public final String toString() {
        return C$Gson$Types.h(this.jPc);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> F(Class<T> cls) {
        return new a<>(cls);
    }
}
